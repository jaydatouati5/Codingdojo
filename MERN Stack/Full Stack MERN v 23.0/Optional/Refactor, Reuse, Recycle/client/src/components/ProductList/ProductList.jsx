import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import DeleteProduct from '../DeleteProduct/DeleteProduct';

const ProductList = ({products, setProducts}) => {
    
    useEffect(() => {
        axios.get("http://localhost:8000/api/products")
        .then(res => {
            setProducts(res.data);
        })
        .catch(err => console.error(err));
    } , []);

    

    return (
        <div>
            <h1>All Products:</h1>
            {products.map((product, i) => 
            <p>
                <Link to={`/products/${product._id}`} key={i}>{product.title}</Link>
                <br />
                <Link to={`/${product._id}/edit`}>EDIT ⚙</Link>
                <br />
                <DeleteProduct product={product} products={products} setProducts={setProducts}/>
            </p>
            )}
        </div>
    )
}

export default ProductList