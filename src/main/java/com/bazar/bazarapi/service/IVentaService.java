package com.bazar.bazarapi.service;

import com.bazar.bazarapi.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();
    public Venta getVenta(Long id);
    public void saveVenta(Venta venta);
    public void editVenta(Venta venta);
    public void deleteVenta(Long id);
}
