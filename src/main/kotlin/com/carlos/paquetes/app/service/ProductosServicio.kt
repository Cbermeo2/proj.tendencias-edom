package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Productos
import com.carlos.paquetes.app.repository.ProductosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductosServicio {
    @Autowired
    lateinit var productosRepository: ProductosRepository

    fun list(): List<Productos> {

        return productosRepository.findAll()
    }

    fun save(productos:Productos):Productos{
        return productosRepository.save(productos)
    }

    fun update(productos:Productos):Productos{
        return productosRepository.save(productos)
    }

    fun updateDescription (productos:Productos):Productos {
        val response = productosRepository.findById(productos.id)
            ?: throw Exception()
        response.apply {
            this.nombre=productos.nombre;
            this.id_cafeteria=productos.id_cafeteria;
        }
        return productosRepository.save(productos)
    }

    fun delete (id:Long): Boolean{
        productosRepository.deleteById(id)
        return true
    }


}