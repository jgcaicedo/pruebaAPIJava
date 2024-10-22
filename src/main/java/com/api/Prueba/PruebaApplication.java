package com.api.Prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.api.Prueba.Producto.controlador", "com.api.Prueba.Producto.model", "com.api.Prueba.Producto.repository", "com.api.Prueba.Producto.service", "com.api.Prueba.Producto.config"})
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

}
