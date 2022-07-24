package com.example.demo.clients.ibge

import com.example.demo.dto.Aggregate

interface IbgaServices {
    fun getPopulacao(ano: String, uf: String, cidade: String): Aggregate;
}