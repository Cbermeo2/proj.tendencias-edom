package com.carlos.paquetes.app.service

import com.carlos.paquetes.app.model.Clientes
import com.carlos.paquetes.app.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired

class ClienteServicio {
    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun list(): List<Clientes> {

        return clienteRepository.findAll()
    }

    fun save(cliente:Clientes):Clientes{
        return clienteRepository.save(cliente)
    }

    fun update(cliente:Clientes):Clientes{
        return clienteRepository.save(cliente)
    }

    fun updateDescription (clientes:Clientes):Clientes {
        val response = clienteRepository.findById(clientes.id)
            ?: throw Exception()
        response.apply {
            this.Nombre=clientes.Nombre;
            this.Apellido=clientes.Apellido;
            this.Direccion_Residencia=clientes.Direccion_Residencia;
            this.Edad=clientes.Edad;

        }
        return clienteRepository.save(clientes)
    }

    fun delete (id:Long): Boolean{
        clienteRepository.deleteById(id)
        return true
    }


}