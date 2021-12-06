package com.carlos.paquetes.app.controllers

import com.carlos.paquetes.app.model.Entregas
import com.carlos.paquetes.app.service.EntregasServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/entrega")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class EntregaController {

    @Autowired
    lateinit var entregaServicio: EntregasServicio

    @GetMapping
    fun list(): List<Entregas>{
        return entregaServicio.list()
    }

    @PostMapping
    fun save(@RequestBody entrega:Entregas):Entregas{
        return entregaServicio.save(entrega)
    }

    @PutMapping
    fun update (@RequestBody entrega:Entregas): Entregas {
        return entregaServicio.update(entrega)
    }

    @PatchMapping
    fun updateDescription (@RequestBody entrega:Entregas):Entregas{
        return entregaServicio.updateDescription(entrega)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return entregaServicio.delete(id)
    }

}