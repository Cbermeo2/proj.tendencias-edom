package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Cafeteria
import com.carlos.paquetes.app.repository.CafeteriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CafeteriaServicio {
    @Autowired
    lateinit var cafeteriaRepository: CafeteriaRepository

    fun list(): List<Cafeteria> {

        return cafeteriaRepository.findAll()
    }

    fun save(cafeteria:Cafeteria):Cafeteria{
        return cafeteriaRepository.save(cafeteria)
    }

    fun update(cliente:Cafeteria):Cafeteria{
        return cafeteriaRepository.save(cliente)
    }

    fun updateDescription (cafeteria:Cafeteria):Cafeteria {
        val response = cafeteriaRepository.findById(cafeteria.id)
            ?: throw Exception()
        response.apply {
            this.nombre=cafeteria.nombre;
            this.telefono=cafeteria.telefono;
            this.direccion=cafeteria.direccion;
        }
        return cafeteriaRepository.save(cafeteria)
    }

    fun delete (id:Long): Boolean{
        cafeteriaRepository.deleteById(id)
        return true
    }


}