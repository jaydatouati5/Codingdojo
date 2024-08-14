import logo from "./logo.svg";
import "./App.css";
import ProductForm from "./components/ProductForm/ProductForm";
import ProductList from "./components/ProductList/ProductList";
import { useState } from "react";
import { Routes , Route , Link } from 'react-router-dom';
import Product from "./components/Product/Product";


function App() {
  const [submit, setSubmit] = useState(false);

  return (
    <div className="App">
      <Routes>
        <Route path="/products" 
        element={
          <>
            <h1>Product Manager</h1>
            <ProductForm setSubmit={setSubmit} />
            <ProductList setSubmit={setSubmit} submit={submit} />
          </>
        }/>
        <Route path="/products/:id" element={<Product/>}/>
      </Routes>
    </div>
  );
}

export default App;
