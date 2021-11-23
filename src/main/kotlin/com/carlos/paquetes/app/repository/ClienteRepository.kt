package com.carlos.paquetes.app.repository

import com.carlos.paquetes.app.model.Clientes
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository:JpaRepository<Clientes, Long> {
    fun findById(id: Long?): Clientes?
}