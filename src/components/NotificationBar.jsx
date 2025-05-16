// notification bar component
// This component is responsible for rendering the notification bar of the application
// It includes a marquee that scrolls important announcements
// The component uses CSS for styling
// The component is a functional component
// Currently, the notification bar is static and does not fetch data from an API but has to be dynamic
// The notification bar is a separate component and can be reused in other parts of the application
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
