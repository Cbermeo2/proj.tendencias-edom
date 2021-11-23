package com.carlos.paquetes.app.model

import javax.persistence.*
@Entity
@Table(name = "Paquete")
class Paquetes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var Nombre: String? = null
    var Fechaentrega: String? = null
    var Hora: String? = null
    var Direccion_Residencia: String? = null


}


