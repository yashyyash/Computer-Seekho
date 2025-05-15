import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
  const navItems = [
    'Home',
    'Placement',
    'Courses',
    'Campus Life',
    'Faculty',
    'Online PG Diploma Courses',
    'Get in Touch',
  ];

  return (
    <nav className="navbar">
      <ul className="nav-list">
        {navItems.map((item, index) => (
          <li key={index} className="nav-item">
            <Link to="/" className="nav-link">
              {item.toUpperCase()}
            </Link>
          </li>
        ))}
      </ul>
    </nav>
  );
};

export default Navbar;
