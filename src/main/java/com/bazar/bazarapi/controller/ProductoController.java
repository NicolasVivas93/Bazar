package com.bazar.bazarapi.controller;

import com.bazar.bazarapi.model.Producto;
import com.bazar.bazarapi.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoServ;

    // GET
    @GetMapping("/todos")
    @ResponseBody
    public List<Producto> getProductos() {
        return productoServ.getProductos();
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Producto getProducto(@PathVariable Long id) {
        return productoServ.getProducto(id);
    }

    // POST - CREATE

    // Crear varios
    @PostMapping("/crearVarios")
    public String saveProductos(@RequestBody List<Producto> productos) {
        for(Producto producto : productos) {
            productoServ.saveProducto(producto);
        }

        return "Productos guardados con éxito";
    }

    // Crear uno
    @PostMapping("/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoServ.saveProducto(producto);
        return "Producto creado";
    }


    // PUT
    @PutMapping("/editar")
    @ResponseBody
    public Producto editProducto(@RequestBody Producto producto) {
        productoServ.editProducto(producto);
        return productoServ.getProducto(producto.getCodigo_producto());
    }

    // DELETE
    @DeleteMapping("/borrar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productoServ.deleteProducto(id);
        return "Producto eliminado";
    }

}
