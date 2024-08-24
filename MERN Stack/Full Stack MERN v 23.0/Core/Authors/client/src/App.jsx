import './App.css';
import { Routes , Route, useLocation, useNavigate } from 'react-router-dom';
import AuthorForm from './components/AuthorForm/AuthorForm';
import AuthorList from './components/AuthorList/AuthorList';
import { Paper } from '@mui/material';
import { useEffect } from 'react';
import Header from './components/Header/Header';

function App() {
  const location = useLocation();
  const navigate = useNavigate()
  useEffect(() => {
    if(location.pathname == "/")
      navigate("/authors")
  } , [])

  const mainStyles = {
    display: 'flex',
    justifyContent:'center',
    alignItems: 'center',
    padding: '20px',
  }

  
  return (
    <div>
      <Header />
      <main style={mainStyles}>
        <Routes>
          <Route path='/authors/new' element={
            <Paper elevation={3} sx={{width: '500px', padding: '20px'}}>
              <AuthorForm type="create"/>
            </Paper>
          }/>
          <Route path='/authors' element={
            <Paper elevation={3} sx={{width: '500px', padding: '20px'}}>
              <AuthorList />
            </Paper>
          }/>
          <Route path='/authors/:id/edit' element={
            <Paper elevation={3} sx={{width: '500px', padding: '20px'}}>
              <AuthorForm type="update"/>
            </Paper>
          }/>
        </Routes>
      </main>
    </div>
  );
}

export default App;
