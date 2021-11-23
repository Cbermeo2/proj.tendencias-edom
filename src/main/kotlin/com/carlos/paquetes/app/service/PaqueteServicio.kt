package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Clientes
import com.carlos.paquetes.app.model.Paquetes
import com.carlos.paquetes.app.repository.ClienteRepository
import com.carlos.paquetes.app.repository.PaqueteRepository
import org.springframework.beans.factory.annotation.Autowired

class PaqueteServicio {
    @Autowired
    lateinit var paqueteRepository: PaqueteRepository

    fun list(): List<Paquetes> {

        return paqueteRepository.findAll()
    }

    fun save(paquetes:Paquetes):Paquetes{
        return paqueteRepository.save(paquetes)
    }

    fun update(paquetes:Paquetes):Paquetes{
        return paqueteRepository.save(paquetes)
    }

    fun updateDescription (paquetes: Paquetes): Paquetes {
        val response = paqueteRepository.findById(paquetes.id)
            ?: throw Exception()
        response.apply {
            this.Nombre=paquetes.Nombre;
            this.Fechaentrega=paquetes.Fechaentrega;
            this.Hora=paquetes.Hora;
            this.Direccion_Residencia=paquetes.Direccion_Residencia;



        }
        return paqueteRepository.save(paquetes)
    }

    fun delete (id:Long): Boolean{
        paqueteRepository.deleteById(id)
        return true
    }


}