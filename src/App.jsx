// App.jsx
import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Home from './pages/Home';
import Header from './components/Header';
import Navbar from './components/Navbar';
import NotificationBar from './components/NotificationBar';
import Footer from './components/Footer';
import BatchwisePlacement from './pages/BatchwisePlacement';

const App = () => {
  return (
    <>
      <Header />
      <Navbar />
      <NotificationBar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/placement" element={<BatchwisePlacement />} />

      </Routes>

      <Footer />
    </>
  );
};

export default App;
