// Home.jsx
import React from 'react';
import Hero from '../components/Hero';
import CoursesOffered from '../components/CoursesOffered';
import MajorRecruiters from '../components/MajorRecruiters';
import Whyvita from '../components/Whyvita';


const Home = () => {
  return (
    <div>
      {/* Hi i am jidnyasa*/}
      <Hero />
      <CoursesOffered />
      <MajorRecruiters />
      <Whyvita /> 
      {/* wow i like this footer */}
    </div>
  );
};

export default Home;
