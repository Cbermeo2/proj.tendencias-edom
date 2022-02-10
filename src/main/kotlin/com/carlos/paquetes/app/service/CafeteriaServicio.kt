package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Cafeteria
import com.carlos.paquetes.app.repository.CafeteriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CafeteriaServicio {
    @Autowired
    lateinit var cafeteriaRepository: CafeteriaRepository

    fun list(): List<Cafeteria> {

        return cafeteriaRepository.findAll()
    }

    fun save(cafeteria:Cafeteria):Cafeteria{
        try{
            if(cafeteria.nombre?.trim()?.isEmpty() == true){
               throw Exception("El nombre no puede estar vacio")}

            if(cafeteria.telefono?.trim()?.isEmpty() == true){
                throw Exception("El telefono no puede estar vacio")}

            if(cafeteria.direccion?.trim()?.isEmpty() == true){
                throw Exception("L direccion  no puede estar vacio")}

            return cafeteriaRepository.save(cafeteria)

        }catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(cafeteria:Cafeteria):Cafeteria{
        val response = cafeteriaRepository.findById(cafeteria.id)
            ?: throw Exception()
        response.apply {
            this.nombre=cafeteria.nombre;
            this.telefono=cafeteria.telefono;
            this.direccion=cafeteria.direccion;
        }
        return cafeteriaRepository.save(cafeteria)
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