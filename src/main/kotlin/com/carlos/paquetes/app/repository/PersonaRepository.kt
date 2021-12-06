package com.carlos.paquetes.app.repository

import com.carlos.paquetes.app.model.Personas
import org.springframework.data.jpa.repository.JpaRepository

interface PersonaRepository:JpaRepository<Personas, Long> {
    fun findById(id: Long?): Personas?
}
