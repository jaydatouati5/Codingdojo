import logo from './logo.svg';
import './App.css';
import SearchForm from './components/SearchForm';
import {Route , Routes} from 'react-router-dom'
import DisplayPeople from './components/DisplayPeople';
import DisplayPlanet from './components/DisplayPlanet';
import ErrorPage from './components/ErrorPage';
function App() {
  return (
    <div className="App container">
      <SearchForm />  
      <Routes>
        <Route path='/people/:id' element={<DisplayPeople />}/>
        <Route path='/planets/:id' element={<DisplayPlanet />}/>
        <Route path="*" element={<ErrorPage/>}/>
      </Routes>
    </div>
  );
}

export default App;
