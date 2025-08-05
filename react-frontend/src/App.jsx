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
import EditBatchwisePlacedStudents from './pages/EditBatchwisePlacedStudents';
import AddMarquee from './pages/AddMarquee';
import Login from './pages/Login';
import ProtectedRoute from './pages/ProtectedRoute';
import PaymentPage from './pages/PaymentPage';
import ReceiptPage from './pages/ReceiptPage';
import CrudFaculty from './pages/CrudFaculty';
import Faculty from './pages/Faculty'; 

const App = () => {
  return (
    <>
      <Header />
      <Navbar />
      <NotificationBar />

      <Routes>
        
        <Route path="/" element={<Home />} />
        <Route path="/placement" element={<BatchwisePlacement />} />
        <Route path="/courses" element={<Courses />} />
        <Route path="/login" element={<Login />} />
        <Route path="/batchwise-placed-students/:batchId" element={<BatchwisePlacedStudents />} />
        <Route path="/faculty" element={<Faculty />} />

       
        <Route path="/admin" element={ <ProtectedRoute> <AdminPage /> </ProtectedRoute>}/>

        <Route
          path="/manage-data"
          element={
            <ProtectedRoute>
              <ManageWebsiteData />
            </ProtectedRoute>
          }
        />

        <Route
          path="/add-course"
          element={
            <ProtectedRoute>
              <AddCourse />
            </ProtectedRoute>
          }
        />

        <Route
          path="/add-batch-placement"
          element={
            <ProtectedRoute>
              <AddBatchPlacement />
            </ProtectedRoute>
          }
        />

        <Route
          path="/add-marquee"
          element={
            <ProtectedRoute>
              <AddMarquee />
            </ProtectedRoute>
          }
        />

        <Route
          path="/edit-batchwise-placed-students/:batchId"
          element={
            <ProtectedRoute>
              <EditBatchwisePlacedStudents />
            </ProtectedRoute>
          }
        />

        <Route
          path="/add-faculty"
          element={
            <ProtectedRoute>
              <CrudFaculty />
            </ProtectedRoute>
          }
        />

        <Route 
        path="/payments" 
        element={
        <ProtectedRoute>
          <PaymentPage />
        </ProtectedRoute>
        } 
        
        />
        <Route 
        path="/receipt/:id" 
        element={
          
          <ProtectedRoute>
            <ReceiptPage />
          </ProtectedRoute>
      
      } 
        />
      </Routes>

      <Footer />
    </>
  );
};

export default App;
