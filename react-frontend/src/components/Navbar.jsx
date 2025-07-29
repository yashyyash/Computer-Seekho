// navbar.jsx
// This component is responsible for rendering the navigation bar of the application
// It includes links to different sections of the website
// The component uses React Router for navigation
// The component uses CSS for styling
// The component is a functional component
// all pages are linked to the home page and the same navigation bar should be used in all pages
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
    'Admin'
  ];

  return (
    <nav className="navbar">
      <ul className="nav-list">
        {navItems.map((item, index) => (
          <li key={index} className="nav-item">
           <Link
  to={item === 'Home' ? '/' : `/${item.toLowerCase().replace(/\s+/g, '')}`}
  className="nav-link"
>
  {item.toUpperCase()}
</Link>

          </li>
        ))}
      </ul>
    </nav>
  );
};

export default Navbar;
