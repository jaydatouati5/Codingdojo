import React, { useState , useEffect } from 'react'
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const DisplayPeople = () => {
    const [person , setPerson] = useState({});
    const {id} = useParams();

    const navigate = useNavigate()

    useEffect(()=> {
        axios.get(`https://swapi.dev/api/people/${id}`)
        .then(res => setPerson({
            name: res.data.name,
            height: res.data.height,
            mass: res.data.mass,
            hair_color: res.data.hair_color,
            skin_color: res.data.skin_color,
        })).catch(err => navigate("/not-found"))
        ;
    },[id]);

    return (
        <div className='mt-4'>
            <h1>{person.name}</h1>
            <p><strong>Height:</strong>{person.height}</p>
            <p><strong>Mass:</strong>{person.mass}</p>
            <p><strong>hair Color:</strong>{person.hair_color}</p>
            <p><strong>Skin Color:</strong>{person.skin_color}</p>
        </div>
    )
}

export default DisplayPeople