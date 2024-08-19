import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

const UpdateProductForm = () => {

    const { id } = useParams();
    const [title , setTitle] = useState("");
    const [price , setPrice] = useState(0);
    const [description , setDescription] = useState("");

    const navigate = useNavigate();

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

    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
        .then(res => {
            setTitle(res.data.title);
            setPrice(res.data.price)
            setDescription(res.data.description);
        }
        )
        .catch(err => console.error(err))
    }, [])

    const handleSubmit = (e) => {
        e.preventDefault();

        axios.patch(`http://localhost:8000/api/products/${id}`, {title, price, description})
        .then(res => {console.log(res); navigate('/products')})
        .catch(err => console.error(err))
    }

    return (
        <form onSubmit={handleSubmit}>
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

            <button type="submit">Update</button>
        </form>
    )
}

export default UpdateProductForm