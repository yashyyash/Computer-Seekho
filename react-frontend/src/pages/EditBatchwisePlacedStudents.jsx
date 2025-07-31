import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import "./EditBatchwisePlacedStudents.css";

const EditBatchwisePlacedStudents = () => {
  const { batchId } = useParams();
  const [students, setStudents] = useState([]);
  const [formData, setFormData] = useState({
    studentName: "",
    companyName: "",
    photoUrl: "",
    active: true,
  });
  const [editingId, setEditingId] = useState(null);

  const fetchStudents = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/students/batch/${batchId}`
      );
      setStudents(response.data);
    } catch (error) {
      console.error("Error fetching students", error);
    }
  };

  useEffect(() => {
    fetchStudents();
  }, [batchId]);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editingId !== null) {
        await axios.put(`http://localhost:8080/api/students/${editingId}`, {
          ...formData,
          batchId,
        });
      } else {
        await axios.post("http://localhost:8080/api/students", {
          ...formData,
          batchId,
        });
      }

      setFormData({
        studentName: "",
        companyName: "",
        photoUrl: "",
        active: true,
      });
      setEditingId(null);
      fetchStudents();
    } catch (error) {
      console.error("Error saving student", error);
    }
  };

  const handleEdit = (student) => {
    setFormData({
      studentName: student.studentName,
      companyName: student.companyName,
      photoUrl: student.photoUrl,
      active: student.active ?? true,
    });
    setEditingId(student.id ?? student.studentId);
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure to delete?")) {
      try {
        await axios.delete(`http://localhost:8080/api/students/${id}`);
        fetchStudents();
      } catch (error) {
        console.error("Delete failed", error);
      }
    }
  };

  return (
    <div className="student-management-container">
      <h2>Manage Placed Students - Batch {batchId}</h2>

      <form className="student-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="studentName"
          placeholder="Student Name"
          value={formData.studentName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="companyName"
          placeholder="Company"
          value={formData.companyName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="photoUrl"
          placeholder="Photo URL"
          value={formData.photoUrl}
          onChange={handleChange}
          required
        />
        <label>
          Active:
          <input
            type="checkbox"
            name="active"
            checked={formData.active}
            onChange={handleChange}
          />
        </label>
        <button type="submit">{editingId ? "Update" : "Add"}</button>
      </form>

      <div className="student-cards">
        {students.map((student) => (
          <div className="student-card" key={student.id ?? student.studentId}>
            <img src={`${student.photoUrl}`} alt={student.studentName} />
            <div className="student-info">
              <h4>{student.studentName}</h4>
              <p>{student.companyName}</p>
              <div className="card-actions">
                <button onClick={() => handleEdit(student)}>Edit</button>
                <button
                  onClick={() => handleDelete(student.id ?? student.studentId)}
                  className="delete-btn">
                  Delete
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default EditBatchwisePlacedStudents;
