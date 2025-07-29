import React, { useEffect, useState } from "react";
import axios from "axios";
import "./AddBatchPlacement.css";

const AddBatchPlacement = () => {
  const [formData, setFormData] = useState({
    batchId: null,
    batchName: "",
    placementPercentage: "",
    logoFileName: "",
    isActive: true,
  });

  const [placements, setPlacements] = useState([]);

  const fetchPlacements = async () => {
    try {
      const res = await axios.get("http://localhost:8080/api/batches");
      setPlacements(res.data);
    } catch (err) {
      console.error("Failed to fetch placements:", err);
    }
  };

  useEffect(() => {
    fetchPlacements();
  }, []);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const payload = {
      batchName: formData.batchName,
      placementPercentage: formData.placementPercentage,
      batchLogoUrl: `/public/batchwisePlacement/${formData.logoFileName.trim()}`,
      isActive: formData.isActive,
    };

    try {
      if (formData.batchId) {
        await axios.put(
          `http://localhost:8080/api/batches/${formData.batchId}`,
          payload
        );
        alert("Updated successfully!");
      } else {
        await axios.post("http://localhost:8080/api/batches", payload);
        alert("Added successfully!");
      }

      setFormData({
        batchId: null,
        batchName: "",
        placementPercentage: "",
        logoFileName: "",
        isActive: true,
      });
      fetchPlacements();
    } catch (err) {
      console.error("Save failed:", err.response || err);
      alert("Failed to save placement.");
    }
  };

  const handleEdit = (placement) => {
    const filename = placement.batchLogoUrl?.split("/").pop() || "";
    setFormData({
      batchId: placement.batchId,
      batchName: placement.batchName,
      placementPercentage: placement.placementPercentage,
      logoFileName: filename,
      isActive: placement.isActive,
    });
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this placement?")) {
      try {
        await axios.delete(`http://localhost:8080/api/batches/${id}`);
        alert("Deleted successfully!");
        fetchPlacements();
      } catch (err) {
        console.error("Delete failed:", err);
        alert("Failed to delete placement.");
      }
    }
  };

  return (
    <div className="add-placement-container">
      <h2 className="form-heading">
        {formData.batchId ? "Edit" : "Add"} Batchwise Placement
      </h2>
      <form className="add-placement-form" onSubmit={handleSubmit}>
        <label>
          Batch Name:
          <input
            type="text"
            name="batchName"
            value={formData.batchName}
            onChange={handleChange}
            required
          />
        </label>

        <label>
          Placement Percentage:
          <input
            type="number"
            name="placementPercentage"
            value={formData.placementPercentage}
            onChange={handleChange}
            step="0.01"
            min="0"
            max="100"
            required
          />
        </label>

        <label>
          Batch Logo Filename:
          <input
            type="text"
            name="logoFileName"
            placeholder="e.g. feb15.png"
            value={formData.logoFileName}
            onChange={handleChange}
            required
          />
          <small className="note">
            Stored as: /public/batchwisePlacement/[filename]
          </small>
        </label>

        <button type="submit" className="submit-btn">
          {formData.batchId ? "Update" : "Add"} Placement
        </button>
      </form>

      <h3 className="form-heading">Existing Placements</h3>
      <table className="placement-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Batch Name</th>
            <th>Percentage</th>
            <th>Logo</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {placements.map((placement) => (
            <tr key={placement.batchId}>
              <td>{placement.batchId}</td>
              <td>{placement.batchName}</td>
              <td>{placement.placementPercentage}%</td>
              <td>
                <img
                  src={placement.batchLogoUrl}
                  alt="logo"
                  style={{ width: "50px", height: "50px", objectFit: "cover" }}
                />
              </td>
              <td>
                <button
                  onClick={() => handleEdit(placement)}
                  className="update-btn"
                >
                  Edit
                </button>
                <button
                  onClick={() => handleDelete(placement.batchId)}
                  className="delete-btn"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AddBatchPlacement;
