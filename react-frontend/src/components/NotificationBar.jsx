import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './NotificationBar.css';

const NotificationBar = () => {
  const [announcements, setAnnouncements] = useState([]);

  useEffect(() => {
    const fetchAnnouncements = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/announcements');
        setAnnouncements(response.data);
      } catch (error) {
        console.error('Failed to fetch announcements:', error);
      }
    };

    fetchAnnouncements();
  }, []);

  return (
    <div className="notification-bar">
      <div className="marquee">
        <p>
          {announcements
            .filter(item => item.aIsActive)
            .map((item, index) => (
              <span key={index}>
                {item.aDesc} &nbsp; | &nbsp;
              </span>
            ))}
        </p>
      </div>
    </div>
  );
};

export default NotificationBar;
