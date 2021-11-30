package com.carlos.paquetes.app.repository

import com.carlos.paquetes.app.model.Productos
import org.springframework.data.jpa.repository.JpaRepository

interface ProductosRepository:JpaRepository<Productos, Long> {
    fun findById(id: Long?): Productos?
}