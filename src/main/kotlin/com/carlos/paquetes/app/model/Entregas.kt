package com.carlos.paquetes.app.model

import javax.persistence.*
@Entity
@Table(name = "entrega")
class Entregas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fecha: String? = null
    var persona_id: Long? = null
    var producto_id: Long? = null


}