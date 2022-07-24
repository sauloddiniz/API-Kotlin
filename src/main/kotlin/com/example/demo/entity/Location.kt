package com.example.demo.entity;

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Location(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val cep: String = "",
    val logradouro: String = "",
    val complemento: String = "",
    val bairro: String = "",
    val localidade: String = "",
    val uf: String = "",
    val ibge: String = "",
    val gia: String = "",
    val ddd: String = "",
    val siafi: String = ""
)