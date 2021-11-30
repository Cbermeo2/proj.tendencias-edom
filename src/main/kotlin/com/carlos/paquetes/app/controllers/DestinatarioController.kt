package com.carlos.paquetes.app.controllers

import com.carlos.paquetes.app.model.Destinatario
import com.carlos.paquetes.app.service.DestinatarioServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/destinatario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DestinatarioController {

    @Autowired
    lateinit var destinatarioServicio: DestinatarioServicio

    @GetMapping
    fun list(): List<Destinatario>{
        return destinatarioServicio.list()
    }

    @PostMapping
    fun save(@RequestBody destinatario:Destinatario):Destinatario{
        return destinatarioServicio.save(destinatario)
    }

    @PutMapping
    fun update (@RequestBody destinatario:Destinatario): Destinatario {
        return destinatarioServicio.update(destinatario)
    }

    @PatchMapping
    fun updateDescription (@RequestBody destinatario:Destinatario):Destinatario{
        return destinatarioServicio.updateDescription(destinatario)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return destinatarioServicio.delete(id)
    }

}