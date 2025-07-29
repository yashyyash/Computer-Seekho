

import Home from './pages/Home';
import Header from './components/Header';
import Navbar from './components/Navbar';
import NotificationBar from './components/NotificationBar';
import Footer from './components/Footer';
import BatchwisePlacement from './pages/BatchwisePlacement';
import AddCourse from './pages/AddCourse';
import Courses from "./pages/Courses";


import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AdminPage from "./pages/AdminPage";
import ManageWebsiteData from "./pages/ManageWebsiteData";
import BatchwisePlacedStudents from "./pages/BatchwisePlacedStudents";
import AddBatchPlacement from "./pages/AddBatchPlacement";

const App = () => {
  return (
    <>
      <Header />
      <Navbar />
      <NotificationBar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/placement" element={<BatchwisePlacement />} />
        <Route path="/admin" element={<AdminPage />} />
        <Route path="/manage-data" element={<ManageWebsiteData />} />
        <Route path="/add-course" element={<AddCourse />} />
        <Route path="/batchwise-placed-students/1" element={<BatchwisePlacedStudents />} />
        <Route path="/add-batch-placement" element={<AddBatchPlacement />} />
        <Route path="/courses" element={<Courses />} />
      </Routes>

      <Footer />
    </>
  );
};

export default App;
