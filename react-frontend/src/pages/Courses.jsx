import React, { useEffect, useState } from "react";
import axios from "axios";
import "./Courses.css";

const Courses = () => {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/courses")
      .then((res) => setCourses(res.data))
      .catch((err) => console.error("Error fetching courses:", err));
  }, []);

  return (
    <div className="courses-container">
      <h2 className="courses-heading">All Courses</h2>
      <div className="courses-grid">
        {courses.map((course) => (
          <div className="course-card" key={course.course_id}>
            <img
              src={course.cover_photo_url}
              alt={course.course_name}
              className="course-image"
            />
            <div className="course-info">
              <h3>{course.course_name}</h3>
              <p><strong>Code:</strong> {course.course_code}</p>
              <p><strong>Fee:</strong> ₹{course.total_fee}</p>
              <p><strong>Duration:</strong> {course.duration}</p>
              <p><strong>Age Group:</strong> {course.age_group}</p>
              <p><strong>Status:</strong> {course.is_active ? "Active" : "Inactive"}</p>
              <p className="course-description">{course.description}</p>
              <details>
                <summary>View Syllabus</summary>
                <p>{course.syllabus}</p>
              </details>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Courses;
