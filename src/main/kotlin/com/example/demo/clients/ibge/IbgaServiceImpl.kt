package com.example.demo.clients.ibge

import com.example.demo.dto.Aggregate
import org.springframework.stereotype.Service

@Service
class IbgaServiceImpl(val ibgeClient:IbgaClient): IbgaServices {

    override fun getPopulacao(ano: String, uf: String, cidade: String): Aggregate {
        return ibgeClient.getPopulacaoIbge().get(0);
    }
}