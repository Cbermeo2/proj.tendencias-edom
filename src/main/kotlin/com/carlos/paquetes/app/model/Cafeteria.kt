package com.carlos.paquetes.app.model

import javax.persistence.*
@Entity
@Table(name = "cafeteria")
class Cafeteria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var telefono: String? = null
    var direccion:String?= null
}