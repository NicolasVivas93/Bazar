package com.bazar.bazarapi.service;

import com.bazar.bazarapi.model.Producto;

import java.util.List;

public interface IProductoService {

    // GET
    public List<Producto> getProductos();
    public Producto getProducto(Long id);

    // POST
    public void saveProducto(Producto producto);

    // PUT
    public void editProducto(Producto producto);

    // DELETE
    public void deleteProducto(Long id);
}
