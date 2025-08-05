import React, { useEffect, useState } from 'react';
import './Faculty.css';

const Faculty = () => {
  const [faculties, setFaculties] = useState([]);
  const [loading, setLoading] = useState(true);

  const API_URL = 'http://localhost:8080/api/faculty';

  useEffect(() => {
    const fetchFaculties = async () => {
      try {
        const response = await fetch(API_URL);
        const data = await response.json();
        setFaculties(data);
      } catch (error) {
        console.error("Error fetching faculty:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchFaculties();
  }, []);

  return (
    <div className="faculty-readonly-container">
      <h2>Our Faculty</h2>
      {loading ? (
        <p>Loading faculty list...</p>
      ) : faculties.length === 0 ? (
        <p>No faculty data available.</p>
      ) : (
        <div className="faculty-grid">
          {faculties.map((faculty) => (
            <div key={faculty.id} className="faculty-card">
              {faculty.photoUrl ? (
                <img
                  src={faculty.photoUrl}
                  alt={faculty.name}
                  className="faculty-photo"
                />
              ) : (
                <div className="faculty-placeholder">No Image</div>
              )}
              <h3>{faculty.name}</h3>
              <p><strong>Subject:</strong> {faculty.subject}</p>
              <p><strong>Email:</strong> {faculty.email}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Faculty;
