import React, { useEffect, useState } from "react";
import axios from "axios";
import "./AddCourse.css";

const AddCourse = () => {
  const [formData, setFormData] = useState({
    course_id: null,
    course_name: "",
    course_code: "",
    description: "",
    duration: "",
    total_fee: "",
    is_active: true,
    syllabus: "",
    age_group: "",
    cover_photo_url: "",
  });

  const [courses, setCourses] = useState([]);

  const fetchCourses = async () => {
    try {
      const res = await axios.get("http://localhost:8080/api/courses");
      setCourses(res.data);
    } catch (err) {
      console.error("Failed to fetch courses:", err);
    }
  };

  useEffect(() => {
    fetchCourses();
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
      ...formData,
      total_fee: parseInt(formData.total_fee) || 0,
    };

    try {
      if (formData.course_id) {
        await axios.put(`http://localhost:8080/api/courses/${formData.course_id}`, payload);
        alert("Course updated successfully!");
      } else {
        await axios.post("http://localhost:8080/api/courses", payload);
        alert("Course added successfully!");
      }

      setFormData({
        course_id: null,
        course_name: "",
        course_code: "",
        description: "",
        duration: "",
        total_fee: "",
        is_active: true,
        syllabus: "",
        age_group: "",
        cover_photo_url: "",
      });

      fetchCourses();
    } catch (err) {
      console.error("Save failed:", err);
      alert("Failed to save course.");
    }
  };

  const handleEdit = (course) => {
    setFormData({ ...course });
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this course?")) {
      try {
        await axios.delete(`http://localhost:8080/api/courses/${id}`);
        alert("Course deleted successfully!");
        fetchCourses();
      } catch (err) {
        console.error("Delete failed:", err);
        alert("Failed to delete course.");
      }
    }
  };

  return (
    <div className="add-course-container">
      <h2 className="form-heading">{formData.course_id ? "Edit" : "Add"} Course</h2>
      <form className="add-course-form" onSubmit={handleSubmit}>
        <label>
          Course Name:
          <input type="text" name="course_name" value={formData.course_name} onChange={handleChange} required />
        </label>

        <label>
          Course Code:
          <input type="text" name="course_code" value={formData.course_code} onChange={handleChange} required />
        </label>

        <label>
          Description:
          <input type="text" name="description" value={formData.description} onChange={handleChange} />
        </label>

        <label>
          Duration:
          <input type="text" name="duration" value={formData.duration} onChange={handleChange} />
        </label>

        <label>
          Total Fee:
          <input type="number" name="total_fee" value={formData.total_fee} onChange={handleChange} />
        </label>

        <label>
          Syllabus:
          <textarea name="syllabus" value={formData.syllabus} onChange={handleChange} />
        </label>

        <label>
          Age Group:
          <input type="text" name="age_group" value={formData.age_group} onChange={handleChange} />
        </label>

        <label>
          Cover Photo URL:
          <input type="text" name="cover_photo_url" value={formData.cover_photo_url} onChange={handleChange} />
        </label>

        <label>
          Is Active:
          <input type="checkbox" name="is_active" checked={formData.is_active} onChange={handleChange} />
        </label>

        <button type="submit" className="submit-btn">
          {formData.course_id ? "Update Course" : "Add Course"}
        </button>
      </form>

      <h3 className="form-heading">Existing Courses</h3>
      <table className="course-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Code</th>
            <th>Fee</th>
            <th>Duration</th>
            <th>Status</th>
            <th>Cover</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {courses.map((c) => (
            <tr key={c.course_id}>
              <td>{c.course_id}</td>
              <td>{c.course_name}</td>
              <td>{c.course_code}</td>
              <td>{c.total_fee}</td>
              <td>{c.duration}</td>
              <td>{c.is_active ? "Active" : "Inactive"}</td>
              <td>
                <img src={c.cover_photo_url} alt="cover" style={{ width: "50px", height: "50px", objectFit: "cover" }} />
              </td>
              <td>
                <button className="update-btn" onClick={() => handleEdit(c)}>
                  Edit
                </button>
                <button className="delete-btn" onClick={() => handleDelete(c.course_id)}>
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

export default AddCourse;
