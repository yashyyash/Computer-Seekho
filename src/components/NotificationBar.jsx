import React from 'react';
import './NotificationBar.css';

const NotificationBar = () => {
  return (
    <div className="notification-bar">
      <div className="marquee">
        <p>
          Admissions open for 2025 – Apply Now! &nbsp; | &nbsp;
          Campus placements begin from July 1st. &nbsp; | &nbsp;
          Check out our new PG diploma courses!
        </p>
      </div>
    </div>
  );
};

export default NotificationBar;
