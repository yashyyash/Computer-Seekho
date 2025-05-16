import React from 'react';
import './Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-section quick-links">
        <h3>Quick Links</h3>
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#">PG-DAC</a></li>
          <li><a href="#">PG-DBDA</a></li>
          <li><a href="#">Pre C-CAT</a></li>
        
          <li><a href="#">Placement</a></li>
          <li><a href="#">Campus Life</a></li>
          <li><a href="#">Faculty</a></li>
          <li><a href="#">Contact Us</a></li>
        </ul>
      </div>
      <div className="footer-section address">
        <h3>Authorised Training Centre</h3>
        <p>5th Floor, Vidyanidhi Education <br /> Complex, Vidyanidhi Road, Juhu <br /> Scheme, Andheri (W), Mumbai 400 049 <br /> India <br /> 9029435311 / 9324095272 <br />9987062416</p>
        
        
      </div>
      
      <div className="footer-section social-icons">
        
        <ul>
          <li><a href="#"><img src="/Footer/x.webp" alt="Twitter"/></a></li>
          <li><a href="#"><img src="/Footer/youtube.png" alt="YouTube"/></a></li>
          <li><a href="#"><img src="/Footer/linkdin.webp" alt="LinkedIn"/></a></li>
        </ul>
      </div>
    </footer>
  );
};

export default Footer;
