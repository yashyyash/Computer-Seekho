// Import core React library
import React from 'react';

// Import component-specific CSS
import './CoursesOffered.css';

// Array of course data (static for now, can later be fetched from an API)
const courses = [
  {
    title: 'PG DAC',
    description: 'Post Graduate Diploma in Advanced Computing (PG DAC) grooms engineers and IT professionals for a career in Software Development.',
  },
  {
    title: 'PG DBDA',
    description: 'Post Graduate Diploma in Big Data Analytics (PG DBDA) enables students to explore the fundamental concepts of big data analytics.',
  },
  {
    title: 'Pre CAT',
    description: 'The admission to all PG Courses by C-DAC ACTS is through an All-India C-DAC Common Admission Test (C-CAT).',
  },
];

// Functional component to render the list of courses
function CoursesOffered() {
  return (
    <div className="app">
      {/* Section heading */}
      <h1 className="title">Courses Offered</h1>

      {/* Decorative underline below heading */}
      <div className="underline"></div>

      {/* Course cards container */}
      <div className="course-container">
        {/* Map through the courses array and render a card for each course */}
        {courses.map((course, index) => (
          <div className="course-card" key={index}>
            {/* Course title */}
            <h2>{course.title}</h2>

            {/* Course description */}
            <p>{course.description}</p>

            {/* Call-to-action button */}
            <button>Click to know more</button>
          </div>
        ))}
      </div>
    </div>
  );
}

// Export the component to be used in other parts of the app
export default CoursesOffered;
