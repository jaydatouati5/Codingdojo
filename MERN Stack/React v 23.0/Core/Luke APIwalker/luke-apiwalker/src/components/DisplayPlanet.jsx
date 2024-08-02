import axios from 'axios';
import React, { useEffect , useState} from 'react'
import { useNavigate, useParams } from 'react-router-dom';

const DisplayPlanet = () => {
    const [planet , setPlanet] = useState({});
    const {id} = useParams();

    const navigate = useNavigate()

    useEffect(()=>{
        axios.get(`https://swapi.dev/api/planets/${id}`)
        .then(res => setPlanet({
            name: res.data.name,
            diameter: res.data.diameter,
            climate: res.data.climate,
            gravity: res.data.gravity,
            terrain: res.data.terrain
        })).catch(err => navigate("/not-found"))
    } , [id])

    return (
        <div className='mt-4'>
            <h1>{planet.name}</h1>
            <p><strong>Diameter:</strong>{planet.diameter}</p>
            <p><strong>Climate:</strong>{planet.climate}</p>
            <p><strong>Gravity:</strong>{planet.gravity}</p>
            <p><strong>Terrain:</strong>{planet.terrain}</p>
        </div>
    )
}

export default DisplayPlanet;