import logo from './logo.svg';
import './App.css';
import Tabs from './components/Tabs';

function App() {
  const arr = [
    {label: "tab 1", content: "Tab 1 is selected"},
    {label: "tab 2", content: "Tab 2 is selected"},
    {label: "tab 3", content: "Tab 3 is selected"}
  ]
  return (
    <div className="App">
      <Tabs arr={arr}/>
    </div>
  );
}

export default App;
