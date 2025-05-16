// Home.jsx
import React from 'react';
import Hero from '../components/Hero';
import CoursesOffered from '../components/CoursesOffered';
import MajorRecruiters from '../components/MajorRecruiters';

const Home = () => {
  return (
    <div>
      <Hero />
      <CoursesOffered />
      <MajorRecruiters />
    </div>
  );
};

export default Home;
