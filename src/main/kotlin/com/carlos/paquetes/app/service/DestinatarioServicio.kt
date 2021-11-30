package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Destinatario
import com.carlos.paquetes.app.repository.DestinatarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DestinatarioServicio {
    @Autowired
    lateinit var destinatarioRepository: DestinatarioRepository

    fun list(): List<Destinatario> {

        return destinatarioRepository.findAll()
    }

    fun save(destinatario:Destinatario):Destinatario{
        return destinatarioRepository.save(destinatario)
    }

    fun update(destinatario:Destinatario):Destinatario{
        return destinatarioRepository.save(destinatario)
    }

    fun updateDescription (destinatario:Destinatario):Destinatario {
        val response = destinatarioRepository.findById(destinatario.id)
            ?: throw Exception()
        response.apply {
            this.Nombre=destinatario.Nombre;
            this.Apellido=destinatario.Apellido;
            this.Direccion_Residencia=destinatario.Direccion_Residencia;
            this.Edad=destinatario.Edad;

        }
        return destinatarioRepository.save(destinatario)
    }

    fun delete (id:Long): Boolean{
        destinatarioRepository.deleteById(id)
        return true
    }


}