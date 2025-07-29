
---

## ✅ 1. 📁 **Folder & File Naming (Root Level)**

| Component      | Folder Name          | Convention                       | Notes                          |
| -------------- | -------------------- | -------------------------------- | ------------------------------ |
| Java Backend   | `java-backend`       | kebab-case                       | Consistent across environments |
| .NET Backend   | `dotnet-backend`     | kebab-case                       |                                |
| React Frontend | `react-frontend`     | kebab-case                       |                                |
| Docker Files   | `docker`             | kebab-case                       |                                |
| Docs / README  | `README.md`, `docs/` | Upper for README, kebab for docs |                                |

---

## ✅ 2. ☕ **Java (Spring Boot)**

### 🔹 Project Structure

```
java-backend/
└── src/main/java/com/seekho/
    ├── controller/
    ├── service/
    ├── repository/
    ├── model/
    ├── dto/
    ├── exception/
    └── SeekhoApplication.java
```

### 🔹 Java Naming Conventions

| Type        | Convention                           | Example                           |
| ----------- | ------------------------------------ | --------------------------------- |
| Class       | `PascalCase`                         | `UserController.java`             |
| Interface   | `PascalCase` (often with `I` prefix) | `IUserService` or `UserService`   |
| Methods     | `camelCase`                          | `getUserById()`                   |
| Variables   | `camelCase`                          | `userRepository`                  |
| Constants   | `UPPER_SNAKE_CASE`                   | `MAX_USERS = 100`                 |
| Packages    | `lowercase` with dots                | `com.seekho.service`              |
| REST Routes | `kebab-case`                         | `/api/users`, `/api/user-details` |

---

## ✅ 3. ⚙️ **.NET (ASP.NET Web API)**

### 🔹 Project Structure

```
dotnet-backend/
└── SeekhoDotNetAPI/
    ├── Controllers/
    ├── Models/
    ├── Services/
    ├── DTOs/
    ├── Middleware/
    └── Program.cs
```

### 🔹 .NET Naming Conventions

| Type        | Convention                            | Example                   |
| ----------- | ------------------------------------- | ------------------------- |
| Class       | `PascalCase`                          | `UserController.cs`       |
| Interface   | `IPascalCase`                         | `IUserService.cs`         |
| Methods     | `PascalCase`                          | `GetUserById()`           |
| Variables   | `camelCase` or `_camelCase` (private) | `_userRepo`               |
| Constants   | `PascalCase` or `UPPER_SNAKE_CASE`    | `MaxUsers` or `MAX_USERS` |
| REST Routes | `kebab-case` in routing               | `/api/user-details`       |

> In .NET routing, kebab-case is preferred for REST endpoints (even though method names are PascalCase).

---

## ✅ 4. ⚛️ **React Frontend (JS/TS + SWC)**

### 🔹 Folder Structure

```
react-frontend/
├── src/
│   ├── components/         # PascalCase folder names
│   │   └── Navbar.jsx
│   ├── pages/              # Each page = component
│   │   └── Home.jsx
│   ├── services/           # API handlers
│   ├── hooks/
│   ├── utils/
│   └── App.jsx
├── public/
├── .env
├── package.json
```

### 🔹 React Naming Conventions

| Type        | Convention              | Example                     |
| ----------- | ----------------------- | --------------------------- |
| Component   | `PascalCase`            | `UserProfile.jsx`           |
| Props       | `camelCase`             | `userId`, `onClickHandler`  |
| Hooks       | `useCamelCase`          | `useAuth`, `useFetchData`   |
| CSS Modules | `kebab-case.module.css` | `navbar.module.css`         |
| Routes      | `kebab-case`            | `/user-profile`, `/sign-in` |

---

## ✅ 5. 🐳 **Docker & DevOps**

### 🔹 Dockerfiles

* File name: `Dockerfile` or `Dockerfile.react`, `Dockerfile.java`
* Use lowercase for folder names and build context
* Image names: `seekho-java-api`, `seekho-dotnet-api`, `seekho-react-ui`

### 🔹 docker-compose

* File name: `docker-compose.yml`
* Service names: `react-ui`, `java-api`, `dotnet-api`

### 🔹 Environment Variables

| Context     | Convention         | Example                             |
| ----------- | ------------------ | ----------------------------------- |
| Environment | `UPPER_SNAKE_CASE` | `REACT_APP_API_URL`, `JAVA_DB_HOST` |

---

## ✅ 6. 📂 Git Branch Naming

| Branch Type | Naming Convention   | Example                   |
| ----------- | ------------------- | ------------------------- |
| Feature     | `feature/<module>`  | `feature/user-auth`       |
| Bugfix      | `bugfix/<issue>`    | `bugfix/login-error`      |
| Release     | `release/<version>` | `release/v1.0.0`          |
| Hotfix      | `hotfix/<issue>`    | `hotfix/null-pointer-fix` |
| Dev         | `dev`               | integration branch        |
| Main        | `main`              | production-ready branch   |

---

## 📌 Summary

* ✅ Use **PascalCase for classes/components**
* ✅ Use **camelCase for variables, methods, props**
* ✅ Use **kebab-case for folders, URLs, REST endpoints**
* ✅ Use **UPPER\_SNAKE\_CASE for constants and env variables**
* ✅ Use **consistent API contracts and folder hierarchy**

---


