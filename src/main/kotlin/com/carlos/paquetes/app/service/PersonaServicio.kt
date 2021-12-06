package com.carlos.paquetes.app.service


import com.carlos.paquetes.app.model.Personas
import com.carlos.paquetes.app.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonaServicio {
    @Autowired
    lateinit var personasRepository: PersonaRepository

    fun list(): List<Personas> {

        return personasRepository.findAll()
    }

    fun save(personas:Personas):Personas{
        return personasRepository.save(personas)
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