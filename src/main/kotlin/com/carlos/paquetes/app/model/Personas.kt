package com.carlos.paquetes.app.model

import javax.persistence.*
@Entity
@Table(name = "persona")
class Personas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var cedula: String? = null
    var nombre: String? = null
    var apellido: String? = null
    var direccion:String?= null
}