import React from 'react';
import './Whyvita.css'; 


function Whyvita() {
  return (
    <div className="why-vita">  
      <div className="why-vita-image">
        
        <img src="/Whyvita/vita12.jpg" alt="Why Choose VITA" />
        
      </div>
      <div className="why-vita-content">
        <h1>Why Choose <span style={{color: 'red'}}>SM VITA</span>  ?</h1>
        <p>Our institute has been present for over 20 years in the market. We make the most of all our students.</p>
        <ul>
          <li>Best in class Infrastructure</li>
          <li>Best Faculty / Teachers</li>
          <li>Best Learning Methodology</li>
          <li>More than 95% Placement for 10 Consecutive batches</li>
        </ul>
      </div>

    </div>
  );
}

export default Whyvita;
