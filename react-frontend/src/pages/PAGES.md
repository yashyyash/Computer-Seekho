## Pages 

- pages rn contains Home.jsx and home.css 

---

## 🔄 Overall Application Flow (React Router + Component Structure)

### 1. **`index.jsx` (entry point)**

* Renders the `<App />` component inside `<BrowserRouter>`.
* Enables client-side routing using React Router.

```jsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);
```

---

### 2. **`App.jsx` (Main Application Layout)**

* Acts as the **root layout component**.
* Contains parts that appear on **every page**, like:

  * `<Header />`
  * `<Navbar />`
  * `<NotificationBar />`
* Uses React Router's `<Routes>` and `<Route>` to render pages dynamically.
* When the URL is `/`, it renders the `<Home />` component.

```jsx
<Routes>
  <Route path="/" element={<Home />} />
</Routes>
```

---

### 3. **`Home.jsx` (Home Page Content)**

* This is the actual component rendered when the path is `/`.
* It's where you display homepage-specific content like:

```jsx
<Hero />
<CoursesOffered />
<MajorRecruiters />
```

Each of these is a **separate component** organized under `/components/`.

---

### 4. **Component Rendering Flow (Homepage)**

When user opens `http://localhost:5173/`:

1. `index.jsx` loads → wraps `App` with `BrowserRouter`.
2. `App.jsx` renders:

   * Header
   * Navbar
   * NotificationBar
   * Finds the route `/` and renders `Home.jsx`.
3. `Home.jsx` renders:

   * `<Hero />`
   * `<CoursesOffered />`
   * `<MajorRecruiters />`
4. Each component renders its own structure and styles.

---

## ✅ Result on Screen (Visual Order)

```
Header (always visible)
Navbar (always visible)
NotificationBar (always visible)
-----------------------------------
Hero Section (only in Home)
Courses Offered (only in Home)
Major Recruiters (only in Home)
```

---

## ✅ Benefits of This Flow

* **Modular**: Each section is its own component — easier to manage.
* **Scalable**: You can easily add new routes like `/about`, `/contact`.
* **Clean separation**: Shared layout vs page-specific content is separated.


