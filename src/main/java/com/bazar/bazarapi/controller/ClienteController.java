package com.bazar.bazarapi.controller;

import com.bazar.bazarapi.model.Cliente;
import com.bazar.bazarapi.model.Producto;
import com.bazar.bazarapi.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;

    // GET
    @GetMapping("/todos")
    @ResponseBody
    public List<Cliente> getClientes() {
        return clienteServ.getClientes();
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Cliente getCliente(@PathVariable Long id) {
        return clienteServ.getCliente(id);
    }

    // POST - CREATE

    // Crear varios
    @PostMapping("/crearVarios")
    public String saveCliente(@RequestBody List<Cliente> clientes) {
        for(Cliente cliente : clientes) {
            clienteServ.saveCliente(cliente);
        }

        return "Clientes guardados con éxito";
    }

    // Crear uno
    @PostMapping("/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteServ.saveCliente(cliente);
        return "Cliente creado";
    }

    // PUT
    @PutMapping("/editar")
    @ResponseBody
    public Cliente editCliente(@RequestBody Cliente cliente) {
        clienteServ.editCliente(cliente);
        return clienteServ.getCliente(cliente.getId_cliente());
    }

    // DELETE
    @DeleteMapping("/borrar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteServ.deleteCliente(id);
        return "Cliente eliminado";
    }
}
