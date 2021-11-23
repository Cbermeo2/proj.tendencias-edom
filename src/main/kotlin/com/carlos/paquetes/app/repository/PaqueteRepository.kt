package com.carlos.paquetes.app.repository

import com.carlos.paquetes.app.model.Paquetes
import org.springframework.data.jpa.repository.JpaRepository

interface PaqueteRepository:JpaRepository<Paquetes, Long> {
    fun findById(id: Long?): Paquetes?
}