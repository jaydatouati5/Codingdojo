import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { useState } from 'react';

function App() {
  const [pokemon, setPokemon] = useState([])

  const get_pokemon = () => {
    axios.get('https://pokeapi.co/api/v2/pokemon?limit=807')
    .then(res => setPokemon(res.data.results))
    .catch(err => console.log(err))
  }
  return (
    <div className="App">
      <button onClick={get_pokemon}>Fetch Pokemon</button>
      <ul>
        {pokemon.map(item => <li>{item.name}</li>)}
      </ul>
    </div>
  );
}

export default App;
