package com.example

import com.example.dao.DatabaseFactory
import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    val driverClassName = environment.config.property("ktor.storage.driverClassName").getString()
    val jdbcURL = environment.config.property("ktor.storage.jdbcURL").getString()

    DatabaseFactory.init(driverClassName = driverClassName, jdbcURL = jdbcURL)
    configureRouting()
    configureSerialization()
}