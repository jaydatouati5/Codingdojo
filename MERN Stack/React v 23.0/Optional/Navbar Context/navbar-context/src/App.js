import logo from './logo.svg';
import './App.css';
import Form from './components/Form';
import FormWrapper from './components/FormWrapper';
import Navbar from './components/Navbar';
import MyContext from'./components/conText';
import { useState } from 'react';


function App() {
  const [name , setName] = useState("");

  return (
    <div className="App">
      <MyContext.Provider value={{name , setName}}>
        <Navbar />
        <FormWrapper />
      </MyContext.Provider>
      
    </div>
  );
}

export default App;
