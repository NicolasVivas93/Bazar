package com.bazar.bazarapi.service;

import com.bazar.bazarapi.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();
    public Cliente getCliente(Long id);
    public void saveCliente(Cliente cliente);
    public void editCliente(Cliente cliente);
    public void deleteCliente(Long id);

}
