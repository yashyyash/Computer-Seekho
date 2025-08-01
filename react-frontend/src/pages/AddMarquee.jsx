import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './AddMarquee.css';

const AddMarquee = () => {
  const [aDesc, setADesc] = useState('');
  const [aIsActive, setAIsActive] = useState(true);
  const [message, setMessage] = useState('');
  const [announcements, setAnnouncements] = useState([]);
  const [editingId, setEditingId] = useState(null); // null means we are adding, not editing

  const fetchAnnouncements = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/announcements');
      setAnnouncements(response.data);
    } catch (error) {
      console.error('Error fetching announcements:', error);
    }
  };

  useEffect(() => {
    fetchAnnouncements();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newAnnouncement = {
      aDesc,
      aIsActive
    };

    try {
      if (editingId === null) {
        // Add
        await axios.post('http://localhost:8080/api/announcements', newAnnouncement);
        setMessage('Announcement added successfully!');
      } else {
        // Edit
        await axios.put(`http://localhost:8080/api/announcements/${editingId}`, newAnnouncement);
        setMessage('Announcement updated successfully!');
      }

      setADesc('');
      setAIsActive(true);
      setEditingId(null);
      fetchAnnouncements();
    } catch (error) {
      console.error(error);
      setMessage('Error saving announcement.');
    }
  };

  const handleEdit = (announcement) => {
    setADesc(announcement.aDesc);
    setAIsActive(announcement.aIsActive);
    setEditingId(announcement.aId);
    setMessage('');
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/announcements/${id}`);
      setMessage('Announcement deleted successfully!');
      fetchAnnouncements();
    } catch (error) {
      console.error(error);
      setMessage('Error deleting announcement.');
    }
  };

  return (
    <div className="add-marquee-container">
      <h2>{editingId ? 'Edit Announcement' : 'Add New Announcement'}</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="aDesc">Announcement Description:</label>
          <input
            type="text"
            id="aDesc"
            value={aDesc}
            onChange={(e) => setADesc(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="aIsActive">Is Active:</label>
          <select
            id="aIsActive"
            value={aIsActive}
            onChange={(e) => setAIsActive(e.target.value === 'true')}
          >
            <option value="true">Active</option>
            <option value="false">Inactive</option>
          </select>
        </div>

        <button type="submit">{editingId ? 'Update' : 'Add'} Announcement</button>
        {message && <p className="message">{message}</p>}
      </form>

      <hr />

      <h3>All Announcements</h3>
      <ul className="announcement-list">
        {announcements.map((ann) => (
          <li key={ann.aId}>
            <strong>{ann.aDesc}</strong> - <em>{ann.aIsActive ? 'Active' : 'Inactive'}</em>
            <div className="actions">
              <button onClick={() => handleEdit(ann)}>Edit</button>
              <button onClick={() => handleDelete(ann.aId)}>Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AddMarquee;
