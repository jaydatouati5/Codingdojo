import axios from 'axios'
import React from 'react'
import { useLocation, useNavigate } from 'react-router-dom'

const DeleteProduct = ({product , products, setProducts}) => {
    const location = useLocation();
    const navigate = useNavigate();
    const handleClick = (e) => {
        axios.delete(`http://localhost:8000/api/products/${product._id}`)
        .then(res => {
            console.log(res);
            setProducts(products.filter(p => p._id != product._id));
            if (location.pathname != "/products")
                navigate(-1);
        })
        .catch(err => console.error(err))
    }
    return (
        <button onClick={handleClick}>
            Delete 🗑
        </button>
    )
}

export default DeleteProduct