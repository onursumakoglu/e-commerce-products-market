package com.moralabs.istegelsin.data.remote.api

import com.moralabs.istegelsin.data.remote.dto.ProductResponse
import retrofit2.Response
import retrofit2.http.*

interface MainApi {

    @Headers("Authorization: Bearer eyJhbGciOiJSUzUxMiIsInR5cCI6ImF0K2p3dCJ9.eyJuYmYiOjE2NDI1MTk2NTIsImV4cCI6MTY0MjU1NTY1MiwiaXNzIjoiaHR0cHM6Ly9naXJpc3Rlc3QucGF6YXJhbWEuY29tIiwiY2xpZW50X2lkIjoicGF6YXJhbWEubWF4bW9iaWxlLnRlc3QuY2xpZW50Iiwic3ViIjoiOTNmOTIwYjgtZDMyNS00NDIyLTJlZGMtMDhkOWQwNTU0N2RjIiwiYXV0aF90aW1lIjoxNjQyNTE5NjUxLCJpZHAiOiJsb2NhbCIsImZpcnN0X25hbWUiOiJOb3lhbiIsImxhc3RfbmFtZSI6Ik5veWFuIiwiZW1haWwiOiJub3lhbkBnbWFpbC5jb20iLCJyb2xlIjoiUGF6YXJhbWEiLCJqdGkiOiI4RTU0MzNCRDU1RTE2RjEyODc3N0U2OTA4MjdCQzExQyIsImlhdCI6MTY0MjUxOTY1Miwic2NvcGUiOlsibWF4bW9iaWxlZ2F0ZXdheS5mdWxsYWNjZXNzIiwib2ZmbGluZV9hY2Nlc3MiXSwiYW1yIjpbInB3ZCJdfQ.LQ6K5db2Ni62OldFgMad7Q-8GGbfuZz2lo1fpc9BeI5ycR8A_lPETq-XDH6PHFq12xF0v1EqXONZ1-bBt49eb1WkpcXnE7oIo77evvtLY7ROESH0lovsjL0aXUGu9KdF9opF0bG5EwinbK1LrsLgUylWLKwxW0Yrq6ivqb99Y1LARi0sL2zcNLSdzYFISXJlnJ-LFNWTPhOx3V4WqPfeXfEbd-OlQA62m-cQr_NQ_kO_Rm1BI9qqKu0xTijg0iGf0fxbFlEJWoLDsemMc77J6o0YGVfC8llhTkMBkOlCRthvUKiBEh06DMHyxDoqn6Z2YyXLm30dwKL5wupLDMXiig")
    @GET("market/{market}/address/{address}/category/{category}")
    suspend fun getProducts(
        @Path("market") market: String,
        @Path("address") address: String,
        @Path("category") category: String

    ) : Response<ProductResponse>

}