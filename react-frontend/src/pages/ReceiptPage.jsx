import React, { useEffect, useState } from 'react';
import './ReceiptPage.css';

const ReceiptPage = () => {
  const [receipt, setReceipt] = useState(null);
  const receiptId = 3;

  useEffect(() => {
    fetch(`http://localhost:8080/api/receipt/${receiptId}`)
      .then((response) => response.json())
      .then((data) => setReceipt(data))
      .catch((error) => console.error('Error fetching receipt:', error));
  }, []);

  const downloadPDF = () => {
    fetch(`http://localhost:8080/api/receipt/${receiptId}/pdf`, {
      method: 'GET',
    })
      .then((response) => response.blob())
      .then((blob) => {
        const url = window.URL.createObjectURL(new Blob([blob]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', `receipt_${receiptId}.pdf`);
        document.body.appendChild(link);
        link.click();
        link.remove();
      })
      .catch((error) => console.error('Error downloading PDF:', error));
  };

  return (
    <div className="receipt-container">
      <h1>Receipt Details</h1>
      {receipt ? (
        <div className="receipt-card">
          <p><strong>Receipt Date:</strong> {receipt.receipt_date}</p>
          <p><strong>Receipt Amount:</strong> ₹{receipt.receipt_amount}</p>
          <p><strong>Payment ID:</strong> {receipt.payment_id}</p>
          <button onClick={downloadPDF}>Download PDF</button>
        </div>
      ) : (
        <p>Loading receipt...</p>
      )}
    </div>
  );
};

export default ReceiptPage;
