package com.carlos.paquetes.app.repository

import com.carlos.paquetes.app.model.Destinatario
import org.springframework.data.jpa.repository.JpaRepository

interface DestinatarioRepository:JpaRepository<Destinatario, Long> {
    fun findById(id: Long?): Destinatario?
}