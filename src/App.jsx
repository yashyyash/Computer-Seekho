import React from 'react'
import { Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import Header from './components/Header'

import Navbar from './components/Navbar'
import Hero from './components/Hero'
import NotificationBar from './components/NotificationBar'

const App = () => {
  return (
    <>
      <Header />
      <Navbar/>
      <NotificationBar/>
      <Hero/>
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
     
    </>
  )
}

export default App
