import logo from './logo.svg';
import './App.css';
import Header from './components/Header/Header'
import Navigation from './components/Navigation/Navigation';
import Main from './components/Main/Main';
import SubContent from './components/SubContent/SubContent';


function App() {
  return (
    <div className="App">
      <Header />
      <div className="sub-class">
        <Navigation />
        <Main>
          <SubContent />
          <SubContent />
          <SubContent />  
        </Main>
      </div>
    </div>
  );
}

export default App;
