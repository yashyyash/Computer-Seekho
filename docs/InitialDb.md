
---

## ✅ Step-by-Step Plan for MySQL Integration (Shared by Both Backends)

---

### 🔧 **1. MySQL Setup**

* ✅ Use a **local MySQL server** during development.
* Use consistent DB schema and credentials for both APIs.

**Sample DB: `seekho_db`**
**Sample User: `seekho_user` / Password: `seekho_pass`**

---

## 📌 JAVA - Spring Boot: MySQL Configuration

### ➤ Add Dependencies in `pom.xml`

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

---

### ➤ `application.properties` or `application.yml`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seekho_db
spring.datasource.username=seekho_user
spring.datasource.password=seekho_pass
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

### ➤ Folder Structure Tip (Spring Boot)

```
src/main/java/com/seekho/api/
├── controller/
├── model/
├── repository/
├── service/
├── config/
└── SeekhoApplication.java
```

---

## 📌 .NET Core Web API: MySQL Configuration

### ➤ 1. Install EF Core & MySQL Packages

```bash
dotnet add package Pomelo.EntityFrameworkCore.MySql
```

---

### ➤ 2. Configure `DbContext`

```csharp
public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

    public DbSet<User> Users { get; set; }

    // Add other entities
}
```

---

### ➤ 3. Add to `Program.cs`

```csharp
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseMySql(
        builder.Configuration.GetConnectionString("DefaultConnection"),
        ServerVersion.AutoDetect(builder.Configuration.GetConnectionString("DefaultConnection"))
    ));
```

---

### ➤ 4. In `appsettings.json`

```json
{
  "ConnectionStrings": {
    "DefaultConnection": "Server=localhost;Database=seekho_db;User=seekho_user;Password=seekho_pass;"
  }
}
```

---

## ✅ Entity Naming & Data Model Sync

To **share the same DB**, make sure:

* Tables, columns, types match exactly in both apps.
* Primary key/foreign key constraints are identical.
* Use either:

  * `snake_case` for tables (`user_profiles`, `course_details`) or
  * `PascalCase` if you're okay with default mappings.

Let both APIs read/write to common tables like:

| Table Name | Description         |
| ---------- | ------------------- |
| `users`    | Common user profile |
| `roles`    | Roles/permissions   |
| `courses`  | Learning content    |
| `progress` | Track course status |

---

## 🔐 Security Tip

* Use **limited-privilege MySQL user** (`seekho_user`) — give it **only access to needed tables**.
* For Dockerized version, mount a `.env` or secrets file — don’t hardcode passwords in config.

---

## 🚀 Final Goal

| Layer    | Tool / Stack            | Status        |
| -------- | ----------------------- | ------------- |
| Database | MySQL (shared)          | ✅ Configured  |
| Java API | Spring Boot             | 🔄 Under Dev  |
| .NET API | ASP.NET Core + EF Core  | 🔄 Under Dev  |
| Frontend | React + Axios           | ⏳ Later       |
| Testing  | Postman / Swagger       | 🔄 After CRUD |
| Docker   | Shared `docker-compose` | ⏳ After APIs  |
| Cloud    | Azure / AWS / Render    | ⏳ Final Stage |

---



---

### ✅ Step 1: Create the Database

```sql
CREATE DATABASE IF NOT EXISTS ComputerSeekhoDB;
USE ComputerSeekhoDB;
```

---

### ✅ Step 2: Create Master Tables (No dependencies)

#### Closure Reason Master

```sql
CREATE TABLE closure_reason_master (
    closure_reason_id INT AUTO_INCREMENT PRIMARY KEY,
    closure_reason_desc VARCHAR(255)
);
```

#### Payment Type Master

```sql
CREATE TABLE payment_type_master (
    payment_type_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_type_desc VARCHAR(100)
);
```

#### Staff Master

```sql
CREATE TABLE staff_master (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(100),
    photo_url VARCHAR(255),
    staff_mobile BIGINT,
    staff_email VARCHAR(255),
    staff_username VARCHAR(100) UNIQUE,
    staff_password VARCHAR(100),
    staff_role VARCHAR(50)
);
```

#### Album Master

```sql
CREATE TABLE album_master (
    album_id INT AUTO_INCREMENT PRIMARY KEY,
    album_name VARCHAR(255),
    album_description VARCHAR(255),
    start_date DATETIME,
    end_date DATETIME,
    album_is_active TINYINT(1)
);
```

---

### ✅ Step 3: Dependent Master Tables

#### Image Master

```sql
CREATE TABLE image_master (
    image_id INT AUTO_INCREMENT PRIMARY KEY,
    image_path VARCHAR(255),
    album_id INT,
    is_album_cover TINYINT(1) DEFAULT 0,
    image_is_active TINYINT(1),
    FOREIGN KEY (album_id) REFERENCES album_master(album_id)
);
```

#### Course Master (depends on video\_master, but create now and later use ALTER to add FK)

```sql
CREATE TABLE course_master (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(255),
    course_description VARCHAR(255),
    course_duration INT,
    course_fees INT,
    course_fees_from DATE,
    course_fees_to DATE,
    course_syllabus TEXT,
    age_grp_type VARCHAR(100),
    course_is_active TINYINT(1) DEFAULT 1,
    cover_photo VARCHAR(255),
    video_id INT
    -- FK added later
);
```

#### Batch Master (depends on course\_master)

```sql
CREATE TABLE batch_master (
    batch_id INT AUTO_INCREMENT PRIMARY KEY,
    batch_name VARCHAR(100),
    batch_start_time TIME,
    batch_end_time TIME,
    course_id INT,
    presentation_date DATETIME,
    course_fees INT,
    course_fees_from DATE,
    course_fees_to DATE,
    batch_is_active TINYINT(1) DEFAULT 1,
    FOREIGN KEY (course_id) REFERENCES course_master(course_id)
);
```

#### Video Master (now batch\_master exists)

```sql
CREATE TABLE video_master (
    video_id INT AUTO_INCREMENT PRIMARY KEY,
    video_description VARCHAR(60),
    video_url VARCHAR(255),
    batch_id INT,
    start_date DATE,
    end_date DATE,
    video_is_active TINYINT(1),
    FOREIGN KEY (batch_id) REFERENCES batch_master(batch_id)
);
```

🔁 Now update `course_master` with the foreign key:

```sql
ALTER TABLE course_master
ADD CONSTRAINT fk_video_id FOREIGN KEY (video_id) REFERENCES video_master(video_id);
```

---

### ✅ Step 4: Student Master (depends on batch\_master and course\_master)

```sql
CREATE TABLE student_master (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30),
    student_address VARCHAR(60),
    student_gender VARCHAR(10),
    photo_url VARCHAR(255),
    student_dob DATE,
    student_qualification VARCHAR(20),
    student_mobile BIGINT,
    course_fee INT,
    batch_id INT,
    course_id INT,
    student_password VARCHAR(15),
    student_username VARCHAR(15) UNIQUE,
    FOREIGN KEY (batch_id) REFERENCES batch_master(batch_id),
    FOREIGN KEY (course_id) REFERENCES course_master(course_id)
);
```

---

### ✅ Step 5: Enquiry Table

```sql
CREATE TABLE enquiry (
    enquiry_id INT AUTO_INCREMENT PRIMARY KEY,
    enquirer_name VARCHAR(255),
    enquirer_address VARCHAR(255),
    enquirer_mobile BIGINT,
    enquirer_alternate_mobile BIGINT,
    enquirer_email_id VARCHAR(255) UNIQUE,
    enquiry_date DATE,
    enquirer_query VARCHAR(255),
    closure_reason_id INT,
    closure_reason VARCHAR(255),
    enquiry_processed_flag TINYINT(1),
    course_id INT,
    staff_id INT,
    student_name VARCHAR(255),
    inquiry_counter INT,
    FOREIGN KEY (closure_reason_id) REFERENCES closure_reason_master(closure_reason_id),
    FOREIGN KEY (course_id) REFERENCES course_master(course_id),
    FOREIGN KEY (staff_id) REFERENCES staff_master(staff_id)
);
```

---

### ✅ Step 6: Followup Table (depends on enquiry and staff)

```sql
CREATE TABLE followup (
    followup_id INT AUTO_INCREMENT PRIMARY KEY,
    enquiry_id INT,
    staff_id INT,
    followup_date DATE,
    followup_msg VARCHAR(150),
    is_active TINYINT(1) DEFAULT 0,
    FOREIGN KEY (enquiry_id) REFERENCES enquiry(enquiry_id),
    FOREIGN KEY (staff_id) REFERENCES staff_master(staff_id)
);
```

---

### ✅ Step 7: Payment Table (depends on payment\_type\_master, student\_master, course\_master, batch\_master, enquiry)

```sql
CREATE TABLE payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_type_id INT,
    payment_date DATE,
    student_id INT,
    course_id INT,
    batch_id INT,
    amount DECIMAL(10,2),
    enquiry_id INT,
    FOREIGN KEY (payment_type_id) REFERENCES payment_type_master(payment_type_id),
    FOREIGN KEY (student_id) REFERENCES student_master(student_id),
    FOREIGN KEY (course_id) REFERENCES course_master(course_id),
    FOREIGN KEY (batch_id) REFERENCES batch_master(batch_id),
    FOREIGN KEY (enquiry_id) REFERENCES enquiry(enquiry_id)
);
```

---

### ✅ Step 8: Receipt Table (depends on payment)

```sql
CREATE TABLE receipt (
    receipt_id INT AUTO_INCREMENT PRIMARY KEY,
    receipt_date DATE,
    receipt_amount DECIMAL(10,2),
    payment_id INT,
    FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);
```

---

