import React from 'react';
import './BatchwisePlacement.css';

// const placementData = [
//   {
//     id: 1,
//     img: '/public/batchwisePlacement/dac_March24.jpg',
//     title: 'PG DAC March 2024',
//     percent: '79 % Placement',
//   },
//   {
//     id: 2,
//     img: '/public/batchwisePlacement/dac_Sept23.jpg',
//     title: 'PG DAC Sept 2023',
//     percent: '70 % Placement',
//   },
//   {
//     id: 3,
//     img: '/public/batchwisePlacement/dac_march23.png',
//     title: 'PG DAC March 2023',
//     percent: '67 % Placement',
//   },
//   {
//     id: 4,
//     img: '/public/batchwisePlacement/dac_sept22.png',
//     title: 'PG DAC Sept 2022',
//     percent: '70 % Placement',
//   },
//   {
//     id: 5,
//     img: '/public/batchwisePlacement/DAC_march22.png',
//     title: 'DAC March 2022',
//     percent: '90 % Placement',
//   },
//   {
//     id: 6,
//     img: '/public/batchwisePlacement/dac_sept21.png',
//     title: 'e-DAC Sept 2021',
//     percent: '100 % Placement',
//   },
//   {
//     id: 7,
//     img: '/public/batchwisePlacement/DAC_may21.png',
//     title: 'e-DAC May 2021',
//     percent: '100 % Placement',
//   },
//   {
//     id: 8,
//     img: '/public/batchwisePlacement/DAC_sep20.png',
//     title: 'e-DAC Sep 2020',
//     percent: '100 % Placement',
//   },
//   {
//     id: 9,
//     img: '/public/batchwisePlacement/DAC_feb20.png',
//     title: 'PG-DAC Feb 2020',
//     percent: '100 % Placement',
//   },
//    {
//     id: 10,
//     img: '/public/batchwisePlacement/dac_aug19.png', 
//     title: 'PG-DAC Feb 2020',
//     percent: '90 % Placement', 
//   },
//    {
//     id: 11,
//     img: '/public/batchwisePlacement/dac_aug19.png',
//     title: 'PG-DAC Aug 2019',
//     percent: '90 % Placement',
//   },
//   {
//     id: 12,
//     img: '/public/batchwisePlacement/feb19.png',
//     title: 'PG-DAC Feb 2019',
//     percent: '100 % Placement',
//   },
//   {
//     id: 13,
//     img: '/public/batchwisePlacement/aug18.png',
//     title: 'PG-DAC Aug 2018',
//     percent: '100 % Placement',
//   },
//   {
//     id: 14,
//     img: '/public/batchwisePlacement/feb18.png',
//     title: 'PG-DAC Feb 2018',
//     percent: '100 % Placement',
//   },
//   {
//     id: 15,
//     img: '/public/batchwisePlacement/aug17.png',
//     title: 'PG-DAC Aug 2017',
//     percent: '98 % Placement',
//   },
//   {
//     id: 16,
//     img: '/public/batchwisePlacement/feb17.png',
//     title: 'PG-DAC Feb 2017',
//     percent: '97 % Placement',
//   },
//   {
//     id: 17,
//     img: '/public/batchwisePlacement/aug16.png',
//     title: 'PG-DAC Aug 2016',
//     percent: '100 % Placement',
//   },
//   {
//     id: 18,
//     img: '/public/batchwisePlacement/feb16.png',
//     title: 'PG-DAC Feb 2016',
//     percent: '97 % Placement',
//   },
//   {
//     id: 19,
//     img: '/public/batchwisePlacement/aug15.png',
//     title: 'PG-DAC Aug 2015',
//     percent: '100 % Placement',
//   },
//   {
//     id: 20,
//     img: '/public/batchwisePlacement/feb15.png',
//     title: 'PG-DAC Feb 2015',
//     percent: '100 % Placement',
//   }
// ];

// const BatchwisePlacement = () => {
//   return (
//     <div className="batchwise-placement">
//       <h2>PG-DAC Placement</h2>
//       <div className="placement-grid">
//         {placementData.map((batch) => (
//           <div className="placement-card" key={batch.id}>
//             <img src={batch.img} alt={batch.title} />
//             <p className="title">{batch.title}</p>
//             <p className="percent">{batch.percent}</p>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// };

// export default BatchwisePlacement;




// // Revision 2
// import { useEffect, useState } from "react";

// const BatchwisePlacement = () => {
//   const [placementData, setPlacementData] = useState([]);

//   useEffect(() => {
//     fetch("http://localhost:8080/api/placements")
//       .then((res) => res.json())
//       .then((data) => {
//         console.log(data);
//         setPlacementData(data);
//       })
//       .catch((err) => console.error(err));
//   }, []);

//   return (  
//     <div className="batchwise-placement">
//       <h2>PG-DAC Placement</h2>
//       <div className="placement-grid">
//         {placementData.map((batch) => (
//           <div className="placement-card" key={batch.id}>
//             <img src={batch.img} alt={batch.title} />
//             <p className="title">{batch.title}</p>
//             <p className="percent">{batch.percent}</p>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// };

// export default BatchwisePlacement;



//revision 3
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const BatchwisePlacement = () => {
  const [placementData, setPlacementData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("http://localhost:8080/api/batches")
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        setPlacementData(data);
      })
      .catch((err) => console.error(err));
  }, []);

  const handleCardClick = (batchId) => {
    navigate(`/batchwise-placed-students/${batchId}`);
  };

  return (
    <div className="batchwise-placement">
      <h2>PG-DAC Batchwise Placement</h2>
      <div className="placement-grid">
        {placementData.map((batch) => (
          <div
            className="placement-card"
            key={batch.batchId}
            onClick={() => handleCardClick(batch.batchId)}
            style={{ cursor: "pointer" }}
          >
            <img src={batch.batchLogoUrl} alt={batch.batchName} />
            <p className="title">{batch.batchName}</p>
            <p className="percent">{batch.placementPercentage}% Placement</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BatchwisePlacement;
