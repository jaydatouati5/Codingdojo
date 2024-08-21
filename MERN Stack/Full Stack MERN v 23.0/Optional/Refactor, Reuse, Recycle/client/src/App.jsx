import './App.css';
import ProductList from './components/ProductList/ProductList';
import { useEffect, useState } from 'react';
import { Routes , Route , useNavigate, useLocation } from 'react-router-dom';
import Product from './components/Product/Product';
import FormProduct from './components/FormProduct/FormProduct';
import axios from 'axios';

function App() {
  const [products , setProducts] = useState([]);
  const navigate = useNavigate();
  const location = useLocation();
  
  // ! Automatically redirect to '/products'
  useEffect(() => {
    if(location.pathname == "/")
      navigate('/products')
  }, [])

  // // ! State used to rerender list on form submition
  // const [submitted , setSubmitted] = useState(false);

  // ! Method for handling form create submission
  const handleCreate = (product) => {
    axios.post('http://localhost:8000/api/products' , product)
    .then(res => {
        console.log(res); 
        // setSubmitted(true);
        setProducts([...products, res.data])
    })
    .catch(err => console.error(err));
}

  // ! Method for handling form update submission
  const handleUpdate = (id , product) => {
    axios.patch(`http://localhost:8000/api/products/${id}` , product)
    .then(res => navigate(-1))
    .catch(err => console.error(err))
  }

  
  return (
    <div className="App">
      <Routes>
        <Route path='/products' element={
          <>
            <h1>Product Manager</h1>
            <FormProduct 
            type="Create"
            handleSubmit={handleCreate}
            />
            <ProductList products={products} setProducts={setProducts}/>
          </>
          } />
        <Route path='/products/:id' element={<Product products={products} setProducts={setProducts}/>}/>
        <Route path='/:id/edit' element={
          
          <FormProduct  type="Update" handleSubmit={handleUpdate}/>
          }/>
      </Routes>
    </div>
  );
}

export default App;
