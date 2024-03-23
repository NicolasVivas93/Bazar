package com.bazar.bazarapi.service;

import com.bazar.bazarapi.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepo;
}
