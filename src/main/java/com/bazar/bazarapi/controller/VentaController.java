package com.bazar.bazarapi.controller;

import com.bazar.bazarapi.model.Producto;
import com.bazar.bazarapi.model.Venta;
import com.bazar.bazarapi.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    // GET
    @GetMapping("/")
    @ResponseBody
    public List<Venta> getVentas() {
        return ventaServ.getVentas();
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Venta getVenta(@PathVariable Long id) {
        return ventaServ.getVenta(id);
    }

    // POST - CREATE

    // Crear varios
    @PostMapping("/crearVarios")
    public String saveVentas(@RequestBody List<Venta> ventas) {
        for(Venta venta : ventas) {
            ventaServ.saveVenta(venta);
        }

        return "Ventas guardadas con éxito";
    }

    // Crear uno
    @PostMapping("/crear")
    public String saveVenta(@RequestBody Venta venta) {
        ventaServ.saveVenta(venta);
        return "Venta creada";
    }


    // PUT
    @PutMapping("/editar")
    @ResponseBody
    public Venta editVenta(@RequestBody Venta venta) {
        ventaServ.editVenta(venta);
        return ventaServ.getVenta(venta.getCod_venta());
    }

    // DELETE
    @DeleteMapping("/borrar/{id}")
    public String deleteVenta(@PathVariable Long id) {
        ventaServ.deleteVenta(id);
        return "Venta eliminada";
    }
}
