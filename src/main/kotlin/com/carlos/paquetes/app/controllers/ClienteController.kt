package com.carlos.paquetes.app.controllers

import com.carlos.paquetes.app.model.Clientes
import com.carlos.paquetes.app.service.ClienteServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cliente")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ClienteController {

    @Autowired
    lateinit var clienteServicio: ClienteServicio

    @GetMapping
    fun list(): List<Clientes>{
        return clienteServicio.list()
    }

    @PostMapping
    fun save(@RequestBody cliente:Clientes):Clientes{
        return clienteServicio.save(cliente)
    }

    @PutMapping
    fun update (@RequestBody cliente:Clientes): Clientes {
        return clienteServicio.update(cliente)
    }

    @PatchMapping
    fun updateDescription (@RequestBody cliente:Clientes):Clientes{
        return clienteServicio.updateDescription(cliente)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return clienteServicio.delete(id)
    }

}