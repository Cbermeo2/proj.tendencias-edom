package com.carlos.paquetes.app.model

import javax.persistence.*
@Entity
@Table(name = "Cliente")
class Clientes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var Nombre: String? = null
    var Apellido: String? = null
    var Edad:String?= null
    var Direccion_Residencia:String?= null


}