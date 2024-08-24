// TODO: Component for both updating and creating authors.
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { FormLabel , Input, Button, FormControl, TextField } from '@mui/material';
import  SendIcon  from '@mui/icons-material/Send';
import KeyboardReturnIcon from '@mui/icons-material/KeyboardReturn';
import { Link, useNavigate, useParams } from 'react-router-dom';


const CreateAuthor = ({type}) => {
    const [name , setName] = useState("");
    const [errors , setErrors] = useState("");

    const {id} = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if(type == 'update'){
            axios.get(`http://localhost:8000/api/authors/${id}`)
            .then(res => setName(res.data.name))
            .catch(err => console.log(err))
        }
    } , [])

    const handleChange = (e) => {
        setName(e.target.value);
    }


    const createAuthor = () => {
        axios.post('http://localhost:8000/api/authors' , {name})
        .then(res => {console.log(res.data); returnToRoot()})
        .catch(err => {
            setErrors(err.response.data.errors.name.message);
            console.error(err)
        })
    }

    const updateAuthor = () => {
        axios.patch(`http://localhost:8000/api/authors/${id}` , {name})
        .then(res => {console.log(res.data);returnToRoot()})
        .catch(err => {
            setErrors(err.response.data.errors.name.message);
            console.error(err);
        })
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        if (type == "create"){
            createAuthor();
        }else{
            updateAuthor();
        }
    }

    const returnToRoot = (e) => {
        navigate('/authors')
    }

    return (
        <React.Fragment>
        <form autoComplete="off" onSubmit={handleSubmit}>
            <h2>{type == 'create' ? "Create Author" : "Update Author"}</h2>
                <TextField 
                    label="Name"
                    onChange={handleChange}
                    required
                    variant="outlined"
                    color="secondary"
                    type="text"
                    fullWidth
                    value={name}
                    error={errors}
                />
                <small style={{color: 'red', }}>{errors}</small>
                <Button fullWidth variant="outlined" sx={{mr: 3 , mb: 1, mt: 3}} color="success" type="submit">Submit</Button>
                <Button fullWidth variant="outlined" color="error" type="submit" onClick={returnToRoot}>Cancel</Button>

        </form>
        </React.Fragment>
    )
}

export default CreateAuthor;