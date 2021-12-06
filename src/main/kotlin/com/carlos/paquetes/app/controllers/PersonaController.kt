package com.carlos.paquetes.app.controllers

import com.carlos.paquetes.app.model.Personas
import com.carlos.paquetes.app.service.PersonaServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/persona")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class PersonaController {

    @Autowired
    lateinit var personasServicio: PersonaServicio

    @GetMapping
    fun list(): List<Personas>{
        return personasServicio.list()
    }

    @PostMapping
    fun save(@RequestBody personas:Personas):Personas{
        return personasServicio.save(personas)
    }

    @PutMapping
    fun update (@RequestBody personas:Personas): Personas {
        return personasServicio.update(personas)
    }

    @PatchMapping
    fun updateDescription (@RequestBody personas:Personas):Personas{
        return personasServicio.updateDescription(personas)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return personasServicio.delete(id)
    }

}