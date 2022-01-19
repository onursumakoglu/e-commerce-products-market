package com.moralabs.istegelsin.data.remote.api

import com.moralabs.istegelsin.data.remote.dto.CategoryResponse
import com.moralabs.istegelsin.data.remote.dto.ProductResponse
import retrofit2.Response
import retrofit2.http.*

interface MainApi {

    @Headers("Authorization: Bearer eyJhbGciOiJSUzUxMiIsInR5cCI6ImF0K2p3dCJ9.eyJuYmYiOjE2NDI1NzIyNzMsImV4cCI6MTY0MjYwODI3MywiaXNzIjoiaHR0cHM6Ly9naXJpc3Rlc3QucGF6YXJhbWEuY29tIiwiY2xpZW50X2lkIjoicGF6YXJhbWEubWF4bW9iaWxlLnRlc3QuY2xpZW50Iiwicm9sZSI6Ikd1ZXN0Iiwic3ViIjoiMjU1YTc2M2ItNmZkOS00ZDhkLWE3NDUtZmE4NWUzNTNlMzlmIiwianRpIjoiNkZGODg3MUI1RUI2MEYzRUY5QzEwQzUzMjNBNDBBQTkiLCJpYXQiOjE2NDI1NzIyNzMsInNjb3BlIjpbIm1heG1vYmlsZWdhdGV3YXkuZnVsbGFjY2VzcyJdfQ.t0f71kOff-5g_25AwA8__tFCIp7Bg9eVRoNzZuBgX7DNAxJZwuzUXvpZu0l8zLrFIgKQzQzi0HwewM8v4umDBsXnnHg-r7C9ffnC3e9gjB9vGbXRe0TUfntqmUqo4S7OZtLZQizHYIoP-sisq3FpjlTd3cyIOffRuFhIy8NSrg65NdV17fzPftq4MuFAmQJmbahxWBCJA-zdCUcI3PVSxFvlgQUsN7if9Sd50DT02er7JPd50Hdrakwez9uYpVvk2-7U0hdr43ejgMYTXju5FkbksjX0CUoaqoHMQ8AqiDYg1Q2LnVFQeO13EuH7b_ee1iaXP1zSCMbQdjoL8tuLqA")
    @GET("market/{market}/address/{address}/category/{category}")
    suspend fun getCategories(
        @Path("market") market: String,
        @Path("address") address: String,
        @Path("category") category: String

    ) : Response<CategoryResponse>

}