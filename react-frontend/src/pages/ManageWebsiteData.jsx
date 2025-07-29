import React from "react";
import { useNavigate } from "react-router-dom";
import "./ManageWebsiteData.css";

const ManageWebsiteData = () => {
  const navigate = useNavigate();

  const sections = [
    { name: "Courses", route: "/add-course" },
    { name: "Marquee", route: "/add-marquee" },
    { name: "Campus Life", route: "/add-campus-life" },
    { name: "Faculty", route: "/add-faculty" },
    { name: "Batchwise Placement", route: "/add-batch-placement" },
    { name: "Students Placed per Batch", route: "/add-students-per-batch" },
    { name: "Recruiters", route: "/add-recruiters" },
  ];

  return (
    <div className="manage-data">
      <h1 className="page-title">Manage Website Data</h1>
      <div className="button-grid">
        {sections.map((section) => (
          <button
            key={section.name}
            className="section-button"
            onClick={() => navigate(section.route)}
          >
            Add {section.name}
          </button>
        ))}
      </div>
    </div>
  );
};

export default ManageWebsiteData;
