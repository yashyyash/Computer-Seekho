import React, { useEffect, useState } from 'react'; // Importing React and necessary hooks
import './Home.css'; // Importing the CSS file for styling
import CoursesOffered from '../components/CoursesOffered'; // adjust the path if needed

// Functional component for the Home page
const Home = () => {
  // Component JSX return
  return (
    <div className="home">
      {/* Content for Home page will go here */}
       <CoursesOffered />
    </div>
  );
};

export default Home; // Exporting the Home component for use in other parts of the app
