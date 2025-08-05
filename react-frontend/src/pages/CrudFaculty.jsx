import React, { useEffect, useState } from 'react';
import './CrudFaculty.css';

const CrudFaculty = () => {
  const [faculties, setFaculties] = useState([]);
  const [formData, setFormData] = useState({
    name: '',
    subject: '',
    email: '',
    photoUrl: ''
  });
  const [editingId, setEditingId] = useState(null);

  const API_URL = 'http://localhost:8080/api/faculty';

  useEffect(() => {
    fetchFaculties();
  }, []);

  const fetchFaculties = async () => {
    const response = await fetch(API_URL);
    const data = await response.json();
    setFaculties(data);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const method = editingId ? 'PUT' : 'POST';
    const url = editingId ? `${API_URL}/${editingId}` : API_URL;

    await fetch(url, {
      method,
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formData),
    });

    setFormData({ name: '', subject: '', email: '', photoUrl: '' });
    setEditingId(null);
    fetchFaculties();
  };

  const handleEdit = (faculty) => {
    setFormData(faculty);
    setEditingId(faculty.id);
  };

  const handleDelete = async (id) => {
    if (window.confirm('Are you sure you want to delete this faculty?')) {
      await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
      fetchFaculties();
    }
  };

  const handleCancel = () => {
    setEditingId(null);
    setFormData({ name: '', subject: '', email: '', photoUrl: '' });
  };

  return (
    <div className="faculty-container">
      <h2>{editingId ? 'Edit Faculty' : 'Add Faculty'}</h2>
      <form className="faculty-form" onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={formData.name} onChange={handleChange} required />
        <input name="subject" placeholder="Subject" value={formData.subject} onChange={handleChange} required />
        <input name="email" placeholder="Email" type="email" value={formData.email} onChange={handleChange} required />
        <input name="photoUrl" placeholder="Photo URL" value={formData.photoUrl} onChange={handleChange} />
        <div className="form-buttons">
          <button type="submit">{editingId ? 'Update' : 'Add'}</button>
          {editingId && <button type="button" onClick={handleCancel}>Cancel</button>}
        </div>
      </form>

      <h3>Faculty List</h3>
      <table className="faculty-table">
        <thead>
          <tr>
            <th>Photo</th>
            <th>Name</th>
            <th>Subject</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {faculties.map((faculty) => (
            <tr key={faculty.id}>
              <td>
                {faculty.photoUrl ? (
                  <img src={faculty.photoUrl} alt={faculty.name} className="faculty-photo" />
                ) : (
                  'N/A'
                )}
              </td>
              <td>{faculty.name}</td>
              <td>{faculty.subject}</td>
              <td>{faculty.email}</td>
              <td>
                <button onClick={() => handleEdit(faculty)}>Edit</button>
                <button className="delete-btn" onClick={() => handleDelete(faculty.id)}>Delete</button>
              </td>
            </tr>
          ))}
          {faculties.length === 0 && (
            <tr>
              <td colSpan="5">No faculty records found.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default CrudFaculty;
