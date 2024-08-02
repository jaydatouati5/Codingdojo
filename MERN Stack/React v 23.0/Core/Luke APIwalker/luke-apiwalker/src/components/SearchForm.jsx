import React , {useState} from 'react'
import { useNavigate } from "react-router-dom"


const SearchForm = () => {
    const [type , setType] = useState("people");
    const [id , setId] = useState("");

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        navigate(`/${type}/${id}`);
    }

    return (
        <form className='d-flex container justify-content-center mt-4' onSubmit={handleSubmit}>
            
            <div>
                <label htmlFor="type">Search For</label>
                <select id="type" className='' onChange={(e) => setType(e.target.value)}>
                    <option value="people">People</option>
                    <option value="planets">Planets</option>
                </select>
                
                <label htmlFor="id">ID:</label>
                <input type="number" className='' onChange={e => setId(e.target.value)}/>
            </div>
            <button type="submit" className='btn btn-primary myButton'>
                <span class="material-symbols-outlined">search</span> Search
            </button>
        </form>
    )
}

export default SearchForm