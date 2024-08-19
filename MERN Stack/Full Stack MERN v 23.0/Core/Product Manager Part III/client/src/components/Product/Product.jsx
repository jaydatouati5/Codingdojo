import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const Product = () => {
    const [product, setProduct] = useState({});
    const {id} = useParams();
    const navigate = useNavigate()

    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
        .then(res => setProduct(res.data))
        .catch(err => console.error(err))
    }, [])

    const deleteProduct = (id) => {
        
        axios.delete(`http://localhost:8000/api/products/${id}`)
        .then(res => {console.log(res); navigate('/products')})
        .catch(err => console.error(err))
    }

    return (
        <div>
            <h2>{product.title}</h2>
            <p><strong>Price:</strong> {product.price}</p>
            <p><strong>Description:</strong> {product.description}</p>
            <button onClick={(e) => deleteProduct(product._id)}>Delete 🚮</button>
        </div>
    )
}

export default Product