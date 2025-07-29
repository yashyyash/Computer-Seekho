const placedStudents = [
  {
    studentName: "AAKANKSHA KHAIRNAR",
    company: "Landmark Car Pvt Ltd",
    imagePath: "/students/dac_March24/AAKANKSHA KHAIRNAR_SMVITA.jpg"
  },
  {
    studentName: "ABHISHEK KARMORE",
    company: "Inogic",
    imagePath: "/students/dac_March24/ABHISHEK KARMORE_SMVITA.jpg"
  },
  {
    studentName: "ABHISHEK SHELKE",
    company: "IDBI Intech Limited",
    imagePath: "/students/dac_March24/ABHISHEK SHELKE_SMVITA.jpg"
  },
  {
    studentName: "AJINKYA MALI",
    company: "63 moons technologies limited",
    imagePath: "/students/dac_March24/AJINKYA MALI_SMVITA.jpg"
  },
  {
    studentName: "AKSHAY GHANEKAR",
    company: "SmartStream Technologies",
    imagePath: "/students/dac_March24/AKSHAY GHANEKAR_SMVITA.jpg"
  },
  {
    studentName: "AKSHAYKUMAR FAGARE",
    company: "63 moons technologies limited",
    imagePath: "/students/dac_March24/AKSHAYKUMAR FAGARE_SMVITA.jpg"
  },
  {
    studentName: "ANKLESH BHUTE",
    company: "NeoSOFT",
    imagePath: "/students/dac_March24/ANKLESH BHUTE_SMVITA.jpg"
  },
  {
    studentName: "ASHITOSH KUDTARKAR",
    company: "IDBI Intech Limited",
    imagePath: "/students/dac_March24/ASHITOSH KUDTARKAR_SMVITA.jpg"
  },
  {
    studentName: "ASHUTOSH TRIPATHI",
    company: "63 moons technologies limited",
    imagePath: "/students/dac_March24/ASHUTOSH TRIPATHI_SMVITA.jpg"
  },
  {
    studentName: "AVADHUT GHADGE",
    company: "Capgemini",
    imagePath: "/students/dac_March24/AVADHUT GHADGE_SMVITA.jpg"
  },
  {
    studentName: "CHAITANYA RASKAR",
    company: "CRISIL Limited",
    imagePath: "/students/dac_March24/CHAITANYA RASKAR_SMVITA.jpg"
  },
  {
    studentName: "CHIRAG YADAV",
    company: "eNix Software Pvt. Ltd.",
    imagePath: "/students/dac_March24/CHIRAG YADAV_SMVITA.jpg"
  },
  {
    studentName: "DARSHAN SAMBAR",
    company: "Maharashtra Knowledge Corporation Limited (MKCL)",
    imagePath: "/students/dac_March24/DARSHAN SAMBAR_SMVITA.jpg"
  },
  {
    studentName: "DURGESH GAIKWAD",
    company: "63 moons technologies limited",
    imagePath: "/students/dac_March24/DURGESH GAIKWAD_SMVITA.jpg"
  },
  {
    studentName: "GANESH WAGH",
    company: "eNix Software Pvt. Ltd.",
    imagePath: "/students/dac_March24/GANESH WAGH_SMVITA.jpg"
  },
  {
    studentName: "GAURAV SHARMA",
    company: "Capgemini",
    imagePath: "/students/dac_March24/GAURAV SHARMA_SMVITA.jpg"
  }
];

const BatchwisePlacedStudents = () => {
  return (
    <div className="placed-students">
      <h2>Placed Students - DAC March 2024</h2>
      <div className="placement-grid">
        {placedStudents.map((student, index) => (
          <div className="placement-card" key={index}>
            <img
              src={student.imagePath}
              alt={student.studentName}
              style={{ width: "150px", height: "150px", objectFit: "cover" }}
            />
            <p className="title">{student.studentName}</p>
            <p className="percent">{student.company}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BatchwisePlacedStudents;
