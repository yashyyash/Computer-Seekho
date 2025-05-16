import React from 'react';
import './MajorRecruiters.css'; // CSS file

const recruiters = [
  { name: 'Atos Worldline', logo: '/Logos/atos.png' },
  { name: 'Altair', logo: '/Logos/altair.png' },
  { name: 'BNP Paribas', logo: '/Logos/bnp.png' },
  { name: 'Capgemini', logo: '/Logos/capg.png' },
  { name: 'Financial Technologies', logo: '/Logos/financialtech.png' },
  { name: 'NSE', logo: '/Logos/nse.png' },
  { name: 'TATA Power', logo: '/Logos/tata.png' },
  { name: 'OnMobile', logo: '/Logos/onmobile.png' },
];

 function MajorRecruiters() {
  return (
    <section className="recruiters-section">
      <h2 className="recruiters-title">Major Recruiters</h2>
      <div className="recruiters-grid">
        {recruiters.map((r, index) => (
          <div key={index} className="recruiter-logo">
            <img src={r.logo} alt={r.name} />
          </div>
        ))}
      </div>
      <button className="see-more-btn">SEE MORE</button>
    </section>
  );
}

export default MajorRecruiters;
