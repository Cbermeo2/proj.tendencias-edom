package com.carlos.paquetes.app.service


import com.carlos.paquetes.app.model.Personas
import com.carlos.paquetes.app.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PersonaServicio {
    @Autowired
    lateinit var personasRepository: PersonaRepository

    fun list(): List<Personas> {

        return personasRepository.findAll()
    }

    fun save(personas:Personas):Personas{

        try{
            if(personas.cedula?.trim()?.isEmpty() == true){
            throw Exception("El telefono no puede estar vacio")}

            if(personas.nombre?.trim()?.isEmpty() == true){
                throw Exception("El nombre no puede estar vacio")}

            if(personas.apellido?.trim()?.isEmpty() == true){
                throw Exception("El nombre no puede estar vacio")}

            if(personas.direccion?.trim()?.isEmpty() == true){
                throw Exception("L direccion  no puede estar vacio")}

            return personasRepository.save(personas)

        }catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(personas:Personas):Personas{
        return personasRepository.save(personas)
    }

    fun updateDescription (personas:Personas):Personas {
        val response = personasRepository.findById(personas.id)
            ?: throw Exception()
        response.apply {
            this.cedula=personas.cedula;
            this.nombre=personas.nombre;
             this.apellido=personas.apellido;
            this.direccion=personas.direccion;
        }
        return personasRepository.save(personas)
    }

    fun delete (id:Long): Boolean{
        personasRepository.deleteById(id)
        return true
    }


}