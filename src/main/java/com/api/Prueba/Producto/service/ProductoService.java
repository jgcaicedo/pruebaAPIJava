package com.api.Prueba.Producto.service;

import com.api.Prueba.Producto.model.Producto;
import com.api.Prueba.Producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Guardar un producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto
    public Producto updateProducto(Integer id, Producto producto) {
        Optional<Producto> productoExistente = productoRepository.findById(id);

        if (productoExistente.isPresent()) {
            Producto productoActualizado = productoExistente.get();
            // Aquí puedes actualizar los campos necesarios del producto
            productoActualizado.setNombre(producto.getNombre());
            productoActualizado.setPrecio(producto.getPrecio());
            // Actualiza cualquier otro campo relevante

            return productoRepository.save(productoActualizado);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }

    // Eliminar un producto por ID
    public void deleteProducto(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }
}
