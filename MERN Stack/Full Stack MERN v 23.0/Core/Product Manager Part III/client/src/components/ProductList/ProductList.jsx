import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

const ProductList = ({submitted , setSubmitted}) => {
    const [products , setProducts] = useState([]);
    const navigate = useNavigate()
    useEffect(() => {
        axios.get("http://localhost:8000/api/products")
        .then(res => {
            setProducts(res.data);
            setSubmitted(false);
        })
        .catch(err => console.error(err));
    } , [submitted]);

    const deleteProduct = (id) => {
        
        axios.delete(`http://localhost:8000/api/products/${id}`)
        .then(res => {console.log(res); setSubmitted(true)})
        .catch(err => console.error(err))
    }

    return (
        <div>
            <h1>All Products:</h1>
            {products.map((product, i) => 
            <p>
                <Link to={`/products/${product._id}`} key={i}>{product.title}</Link>
                <br />
                <Link to={`/${product._id}/edit`}>EDIT ⚙</Link>
                <br />
                <button onClick={(e) => deleteProduct(product._id)}>Delete 🚮</button>
            </p>
            )}
        </div>
    )
}

export default ProductList