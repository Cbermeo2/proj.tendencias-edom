package com.carlos.paquetes.app.repository

import com.carlos.paquetes.app.model.Entregas
import org.springframework.data.jpa.repository.JpaRepository

interface EntregasRepository:JpaRepository<Entregas, Long> {
    fun findById(id: Long?): Entregas?
}
