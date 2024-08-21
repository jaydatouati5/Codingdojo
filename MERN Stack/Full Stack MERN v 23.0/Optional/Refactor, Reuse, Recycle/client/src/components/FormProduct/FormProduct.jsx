import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

const FormProduct = ({type, handleSubmit}) => {
    
    // ! Extracting 'id' from the URL parameters (useful for Update scenarios)
    const { id } = useParams();
    
    // ! State hooks for the form fields
    const [title , setTitle] = useState("");
    const [price , setPrice] = useState(0);
    const [description , setDescription] = useState("");

    // ! Fetch product data when the component loads, but only if the form is in "Update" mode
    useEffect(() => {
        if(type == "Update"){
            axios.get("http://localhost:8000/api/products/"+id)
            .then(res => {
                // Populate the form with the fetched data
                setTitle(res.data.title);
                setPrice(res.data.price);
                setDescription(res.data.description);
            })
        }
    },[])

    // ! General handler for all input changes
    const handleAll = (e) => {
        switch (e.target.id) {
            case 'title':
                setTitle(e.target.value);
                break;
            case 'price':
                setPrice(e.target.value);
                break;
            case 'description':
                setDescription(e.target.value);
                break
        }
    }

    // ! Form submission handler
    const onSubmitLocalHandler = (e) => {
        e.preventDefault();
        if (type == "Create")
            handleSubmit({title, price, description});
        else
            handleSubmit(id, {title, price, description})
    }

    // ! JSX for rendering the form
    return (
        <form onSubmit={onSubmitLocalHandler}>
            <div>
                <label htmlFor="title">Title</label>
                <input type="text" onChange={handleAll} id='title' value={title}/>
            </div>
            <div>
                <label htmlFor="price">Price</label>
                <input type="number" onChange={handleAll} id='price' value={price}/>
            </div>
            <div>
                <label htmlFor="description">Description</label>
                <input type="text" onChange={handleAll} id='description' value={description}/>
            </div>

            <button type="submit">{type}</button>
        </form>
    )
}

export default FormProduct