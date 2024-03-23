package com.bazar.bazarapi.service;

import com.bazar.bazarapi.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    @Autowired
    private IVentaRepository ventaRepo;

}
