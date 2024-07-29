import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const [pokemon, setPokemon] = useState([])

  const get_pokemon = () =>{
    fetch('https://pokeapi.co/api/v2/pokemon?limit=807')
    .then(response => response.json())
    .then(result => setPokemon(result.results))
    .catch (rej => console.log(rej))
  }

  return(
    <div className='App'>
      <button onClick={get_pokemon}>Fetch Pokemon</button>
      <ul>
        {pokemon.map(item => <li>{item.name}</li>)}
      </ul>
    </div>
  )
}

export default App;
