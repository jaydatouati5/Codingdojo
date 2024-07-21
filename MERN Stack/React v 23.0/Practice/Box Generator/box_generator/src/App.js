import logo from './logo.svg';
import './App.css';
import Form from './components/Form/Form';
import { useState } from 'react'
import Box from './components/Box/Box';

function App() {
  const [colors , setColors] = useState([]);

  return (
    <div className="App">
      <Form setColors={setColors} colors={colors} />
      <div className='box_container'>
        {colors.map(color => <Box color={color}/>)}
      </div>
    </div>
  );
}

export default App;
