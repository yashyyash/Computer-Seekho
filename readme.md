
---

# Computer Seekho

A full-stack application for managing courses and batch placements. This project includes a Java-based backend and a React frontend.

---

## 📁 Project Structure

```
Computer-Seekho/
├── docs/
│   └── db.txt            # Database schema and seed data
├── java-backend/         # Backend - Spring Boot
│   └── src/
│   └── application.properties
├── front-end/            # Frontend - React.js
```

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yashyyash/Computer-Seekho.git
cd Computer-Seekho
```

---

### 2. Set Up the Backend

#### a. Open in IDE

Open the `java-backend` folder using IntelliJ IDEA, Spring Tool Suite (STS), or your preferred Java IDE.

#### b. Configure MySQL Database

1. Create a new MySQL database named:

   ```sql
   CREATE DATABASE project_g1;
   ```

2. Open `docs/db.txt` and run its contents in your MySQL console to:

   * Create tables
   * Insert dummy data

#### c. Update Database Credentials

Open `java-backend/src/main/resources/application.properties` and update the MySQL credentials:

```properties
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```

#### d. Run the Backend

Run the `JavaBackendApplication.java` file as a Java application in your IDE.

If everything is set up correctly, your Spring Boot server should start.

---

### 3. Use Postman for Testing

Once the backend is running, you can use Postman to test the available CRUD endpoints for:

* `batches`
* `courses`

> Note: Only these controllers are currently implemented. Others are pending.

---

### 4. Set Up the Frontend

```bash
cd front-end
npm install
npm run dev
```

Visit the frontend in your browser (usually at `http://localhost:5173`).

---

### 5. Admin Panel

Once the frontend is running:

* Go to the **Admin** section
* Click on **Manage Website Data**
* You can now:

  * Add courses
  * Add batch placements

---

## ✅ Status

* [x] Backend: CRUD for Batches and Courses
* [ ] Backend: Remaining controllers
* [x] Frontend: Admin can manage course and batch placement

---

## 🛠 Tech Stack

**Backend**:

* Java
* Spring Boot
* MySQL

**Frontend**:

* React
* Vite
* Tailwind CSS (if applicable)

---

## 🤝 Contributions

Pull requests are welcome! Please open an issue first to discuss what you would like to change.

---

