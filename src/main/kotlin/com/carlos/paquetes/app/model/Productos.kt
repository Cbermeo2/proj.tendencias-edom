package com.carlos.paquetes.app.model

import javax.persistence.*
@Entity
@Table(name = "productos")
class Productos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var id_cafeteria: Long? = null


}