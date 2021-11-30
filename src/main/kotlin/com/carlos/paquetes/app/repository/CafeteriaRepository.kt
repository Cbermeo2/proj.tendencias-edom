package com.carlos.paquetes.app.repository

import com.carlos.paquetes.app.model.Cafeteria
import org.springframework.data.jpa.repository.JpaRepository

interface CafeteriaRepository:JpaRepository<Cafeteria, Long> {
    fun findById(id: Long?): Cafeteria?
}
