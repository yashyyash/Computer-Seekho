import React from "react";
import { useNavigate } from "react-router-dom";
import "./AdminPage.css";

const dummyFollowUps = [
  { id: 1, name: "Rahul", phone: "9999999999", course: "DAC", date: "2025-07-28" },
  { id: 2, name: "Priya", phone: "8888888888", course: "DBDA", date: "2025-07-29" },
];

const AdminPage = () => {
  const navigate = useNavigate();

  return (
    <div className="admin-container">
      <h1 className="admin-heading">
        Welcome, <span className="staff-name">Staff Name</span>
      </h1>

      <div className="admin-buttons">
        <button className="btn btn-green">Add Enquiry</button>
        <button className="btn btn-blue" onClick={() => navigate("/manage-data")}>
          Manage Website Data
        </button>
      </div>

      <h2 className="sub-heading">Follow-Ups</h2>
      <table className="followup-table">
        <thead>
          <tr>
            <th>Enquiry ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Course</th>
            <th>Follow-up Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {dummyFollowUps.map((entry) => (
            <tr key={entry.id}>
              <td>{entry.id}</td>
              <td>{entry.name}</td>
              <td>{entry.phone}</td>
              <td>{entry.course}</td>
              <td>{entry.date}</td>
              <td>
                <button
                  onClick={() => alert("Redirect to Full Details")}
                  className="btn btn-yellow"
                >
                  Call
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AdminPage;
