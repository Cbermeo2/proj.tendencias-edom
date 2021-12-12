package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Entregas
import com.carlos.paquetes.app.repository.CafeteriaRepository
import com.carlos.paquetes.app.repository.EntregasRepository
import com.carlos.paquetes.app.repository.PersonaRepository
import com.carlos.paquetes.app.repository.ProductosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class EntregasServicio {
    @Autowired
    lateinit var entregaRepository: EntregasRepository
    @Autowired
    lateinit var personaRepository: PersonaRepository
    @Autowired
    lateinit var productosRepository: ProductosRepository

    fun list(): List<Entregas> {

        return entregaRepository.findAll()
    }

    fun save(entregas:Entregas):Entregas{
        try{
            personaRepository.findById(entregas.persona_id) ?: throw Exception("id persona no encontrada")
            productosRepository.findById(entregas.producto_id) ?: throw Exception("id del producto no encontrada")
            return entregaRepository.save(entregas)

        }catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
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