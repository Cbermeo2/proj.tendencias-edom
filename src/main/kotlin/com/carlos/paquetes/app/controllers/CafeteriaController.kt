package com.carlos.paquetes.app.controllers

import com.carlos.paquetes.app.model.Cafeteria
import com.carlos.paquetes.app.service.CafeteriaServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cafeteria")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class CafeteriaController {

    @Autowired
    lateinit var cafeteriaServicio: CafeteriaServicio

    @GetMapping
    fun list(): List<Cafeteria>{
        return cafeteriaServicio.list()
    }

    @PostMapping
    fun save(@RequestBody cafeteria:Cafeteria):Cafeteria{
        return cafeteriaServicio.save(cafeteria)
    }

    @PutMapping
    fun update (@RequestBody cafeteria:Cafeteria): Cafeteria {
        return cafeteriaServicio.update(cafeteria)
    }

    @PatchMapping
    fun updateDescription (@RequestBody cafeteria:Cafeteria):Cafeteria{
        return cafeteriaServicio.updateDescription(cafeteria)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return cafeteriaServicio.delete(id)
    }

}