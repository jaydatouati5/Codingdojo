import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import StartChatting from './components/StartChatting';
import { useState } from 'react';
import Chatroom from './components/Chatroom';
function App() {
  const [name , setName] = useState("")

  return (
    <div className="App">
      <h1>MERN CHAT</h1>
      <Routes>
        <Route path='/' element={<StartChatting />}/>
        <Route path='/chatroom/:id' element={<Chatroom />}/>
      </Routes>
    </div>
  );
}

export default App;
