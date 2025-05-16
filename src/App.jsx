// App.jsx
import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Home from './pages/Home';
import Header from './components/Header';
import Navbar from './components/Navbar';
import NotificationBar from './components/NotificationBar';
// trying changes 
const App = () => {
  return (
    <>
      <Header />
      <Navbar />
      <NotificationBar />

      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
    </>
  );
};

export default App;
