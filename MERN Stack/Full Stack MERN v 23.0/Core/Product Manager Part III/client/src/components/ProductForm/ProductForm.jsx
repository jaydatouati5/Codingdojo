import React, { useState } from 'react';
import axios from 'axios'

const ProductForm = ({setSubmitted}) => {

    const [title , setTitle] = useState("");
    const [price , setPrice] = useState(0);
    const [description , setDescription] = useState("");
    
    // ! Casual way of doing it
    // const handleTitle = (e) => {
    //     setTitle(e.target.value);
    // }

    // const handlePrice = (e) => {
    //     setPrice(e.target.value);
    // }

    // const handleDescription = (e) => {
    //     setDescription(e.target.value);
    // }

    // ! Experimental way
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

    const handleSubmit = (e) => {
        e.preventDefault();

        axios.post('http://localhost:8000/api/products' , {title , price , description})
        .then(res => {
            console.log(res); 
            setSubmitted(true);
        })
        .catch(err => console.error(err));
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="title">Title</label>
                <input type="text" onChange={handleAll} id='title' />
            </div>
            <div>
                <label htmlFor="price">Price</label>
                <input type="number" onChange={handleAll} id='price' />
            </div>
            <div>
                <label htmlFor="description">Description</label>
                <input type="text" onChange={handleAll} id='description' />
            </div>

            <button type="submit">Create</button>
        </form>
    )
}

export default ProductForm