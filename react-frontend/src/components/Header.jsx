// code for Header Component
// This component is responsible for rendering the header of the application
// It includes the logos of VITA and CDAC
// The logos are imported from the public folder
// The component uses CSS for styling
// The component is a functional component

import React from 'react';
import './Header.css';

const Header = () => {
  return (
    <header className="header">
      <img src="/Header/vita_logo1.png" alt="VITA logo" />
      <img src="/Header/vita_logo2.png" alt="Center text" />
      <img src="/Header/cdac_logo3.png" alt="CDAC logo" />
    </header>
  );
};

export default Header;
