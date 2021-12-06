package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Entregas
import com.carlos.paquetes.app.repository.EntregasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EntregasServicio {
    @Autowired
    lateinit var entregaRepository: EntregasRepository

    fun list(): List<Entregas> {

        return entregaRepository.findAll()
    }

    fun save(entregas:Entregas):Entregas{
        return entregaRepository.save(entregas)
    }

    fun update(entregas: Entregas):Entregas{
        return entregaRepository.save(entregas)
    }

    fun updateDescription (entregas:Entregas):Entregas {
        val response = entregaRepository.findById(entregas.id)
            ?: throw Exception()
        response.apply {
            this.fecha=entregas.fecha;
            this.persona_id=entregas.persona_id;
            this.producto_id=entregas.producto_id;
        }
        return entregaRepository.save(entregas)
    }

    fun delete (id:Long): Boolean{
        entregaRepository.deleteById(id)
        return true
    }


}