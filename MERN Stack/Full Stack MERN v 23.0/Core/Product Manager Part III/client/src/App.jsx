import logo from './logo.svg';
import './App.css';
import ProductForm from './components/ProductForm/ProductForm';
import ProductList from './components/ProductList/ProductList';
import { useState } from 'react';
import { Routes , Route , Link } from 'react-router-dom';
import Product from './components/Product/Product';
import UpdateProductForm from './components/UpdateProductForm/UpdateProductForm';

function App() {
  const [submitted , setSubmitted] = useState(false);

  return (
    <div className="App">
      <Routes>
        <Route path='/products' element={
          <>
            <h1>Product Manager</h1>
            <ProductForm setSubmitted={setSubmitted}/>
            <ProductList submitted={submitted} setSubmitted={setSubmitted}/>
          </>
          } />
        <Route path='/products/:id' element={<Product/>}/>
        <Route path='/:id/edit' element={<UpdateProductForm />}/>
      </Routes>
    </div>
  );
}

export default App;
