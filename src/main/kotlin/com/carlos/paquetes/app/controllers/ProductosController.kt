package com.carlos.paquetes.app.controllers

import com.carlos.paquetes.app.model.Productos
import com.carlos.paquetes.app.service.ProductosServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/productos")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ProductosController {

    @Autowired
    lateinit var productosServicio: ProductosServicio

    @GetMapping
    fun list(): List<Productos>{
        return productosServicio.list()
    }

    @PostMapping
    fun save(@RequestBody productos:Productos):Productos{
        return productosServicio.save(productos)
    }

    @PutMapping
    fun update (@RequestBody productos:Productos): Productos {
        return productosServicio.update(productos)
    }

    @PatchMapping
    fun updateDescription (@RequestBody productos:Productos):Productos{
        return productosServicio.updateDescription(productos)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return productosServicio.delete(id)
    }

}