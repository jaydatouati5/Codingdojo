import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

const ProductList = ({submit , setSubmit}) => {
    const [products , setProducts] = useState([]);
    const [loaded , setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/products')
        .then(res => {setProducts(res.data); setLoaded(true)})
        .catch(err => console.error(err));
        setSubmit(false);
    } , [submit]);
    
    return (
        <div>
            <h2>List of Products</h2>
            {
                loaded ? 
                <div>
                {products.map((product , i) => 
                    <div>
                        <Link to={`/products/${product._id}`} key={i}>{product.title}</Link>
                    </div>
                )}
                </div> : 
                "Loading ..."
}
        </div>
    )
}

export default ProductList