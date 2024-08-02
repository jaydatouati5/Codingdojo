import logo from './logo.svg';
import './App.css';
import { Route,Link, Routes } from 'react-router-dom';
import Welcome from './components/Welcome';
import Hello from './components/Hello';
import WordColor from './components/WordColor';

function App() {
  
  return (
    <div className="App">
      <Routes>
        <Route path='/home' element={<Welcome/>}/>
        <Route path='/:word' element ={<Hello/>}/>
        <Route path='/:hello/:color/:backgroundColor' element = {< WordColor/>}/>
        
      </Routes>

    </div>
  );
}

export default App;
