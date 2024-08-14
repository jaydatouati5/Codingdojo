import React , { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Product = () => {
    const [product , setProduct] = useState({});
    const { id } = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
        .then(res => setProduct(res.data))
        .catch(err => console.error(err));
    } , [])


    return (
        <div>
            <h2>{product.title}</h2>
            <p><strong>Price:</strong>{product.price}</p>
            <p><strong>Description:</strong>{product.description}</p>
        </div>
    )
}

export default Product