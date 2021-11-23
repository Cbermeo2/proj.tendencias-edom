package com.carlos.paquetes.app.controllers


import com.carlos.paquetes.app.model.Paquetes
import com.carlos.paquetes.app.service.PaqueteServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/paquete")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class PaqueteController {

    @Autowired
    lateinit var paqueteServicio: PaqueteServicio

    @GetMapping
    fun list(): List<Paquetes>{
        return paqueteServicio.list()
    }

    @PostMapping
    fun save(@RequestBody paquete:Paquetes):Paquetes{
        return paqueteServicio.save(paquete)
    }

    @PutMapping
    fun update (@RequestBody paquete:Paquetes): Paquetes {
        return paqueteServicio.update(paquete)
    }

    @PatchMapping
    fun updateDescription (@RequestBody paquete:Paquetes):Paquetes{
        return paqueteServicio.updateDescription(paquete)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return paqueteServicio.delete(id)
    }

}