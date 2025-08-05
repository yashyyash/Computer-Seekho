import React, { useEffect, useState } from "react";
import "./PaymentPage.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import ReceiptPage from "./ReceiptPage";

const PaymentPage = () => {
  const [formData, setFormData] = useState({
    payment_type_id: "",
    payment_date: "",
    student_id: "",
    course_id: "",
    batch_id: "",
    amount: "",
  });

  const [payments, setPayments] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchPayments();
  }, []);

  const fetchPayments = async () => {
    const res = await axios.get("http://localhost:8080/api/payment");
    setPayments(res.data);
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/payment", formData);
    fetchPayments();
    resetForm();
  };

  const resetForm = () => {
    setFormData({
      payment_type_id: "",
      payment_date: "",
      student_id: "",
      course_id: "",
      batch_id: "",
      amount: "",
    });
  };

  const goToReceipt = (paymentId) => {
    navigate(`/receipt/${paymentId}`);
  };

  return (
    <div className="payment-container">
      <h2>Payment Form</h2>
      <form onSubmit={handleSubmit} className="payment-form">
        <input
          type="number"
          name="payment_type_id"
          placeholder="Payment Type ID"
          value={formData.payment_type_id}
          onChange={handleChange}
          required
        />
        <input
          type="date"
          name="payment_date"
          value={formData.payment_date}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="student_id"
          placeholder="Student ID"
          value={formData.student_id}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="course_id"
          placeholder="Course ID"
          value={formData.course_id}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="batch_id"
          placeholder="Batch ID"
          value={formData.batch_id}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="amount"
          placeholder="Amount"
          value={formData.amount}
          onChange={handleChange}
          required
        />
        <button type="submit">Add Payment</button>
        <button type="button" onClick={resetForm} className="reset-btn">
          Reset
        </button>
      </form>

      <h2>Payments Table</h2>
      <table className="payment-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Payment Type</th>
            <th>Date</th>
            <th>Student</th>
            <th>Course</th>
            <th>Batch</th>
            <th>Amount</th>
            <th>Receipt</th>
          </tr>
        </thead>
        <tbody>
          {payments.map((p) => (
            <tr key={p.payment_id}>
              <td>{p.payment_id}</td>
              <td>{p.payment_type_id}</td>
              <td>{p.payment_date}</td>
              <td>{p.student_id}</td>
              <td>{p.course_id}</td>
              <td>{p.batch_id}</td>
              <td>{p.amount}</td>
              <td>
                <button onClick={() => goToReceipt(p.payment_id)}>Receipt</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PaymentPage;
