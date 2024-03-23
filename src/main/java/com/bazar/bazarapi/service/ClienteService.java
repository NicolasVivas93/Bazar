package com.bazar.bazarapi.service;

import com.bazar.bazarapi.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepo;
}
