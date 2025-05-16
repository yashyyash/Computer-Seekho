// Import core React and React Router functionality
import React from 'react';
import { Routes, Route } from 'react-router-dom';

// Import pages and components used in the app
import Home from './pages/Home';
import Header from './components/Header';
import Navbar from './components/Navbar';
import Hero from './components/Hero';
import NotificationBar from './components/NotificationBar';

// Root component of the application
const App = () => {
  return (
    <>
      {/* Top header section (e.g., logo, title) */}
      <Header />

      {/* Navigation bar (e.g., links to pages) */}
      <Navbar />

      {/* Notification bar for announcements or alerts */}
      <NotificationBar />

      {/* Hero section (main banner or image) */}
      <Hero />

      {/* Define routes using React Router */}
      <Routes>
        {/* Home route mapped to the Home component */}
        <Route path="/" element={<Home />} />
      </Routes>
    </>
  );
};

export default App; // Exporting App component as the root component of the project
