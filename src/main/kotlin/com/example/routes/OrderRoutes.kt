package com.example.routes

import com.example.models.orderStorage
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Route.listOfOrders() {
    route("/order") {
        get() {
            if (orderStorage.isNotEmpty()) {
                call.respond(orderStorage)
            } else {
                call.respondText("No Order Found", status = HttpStatusCode.OK)
            }
        }
        get("/item/{id}") {
            val id =
                call.parameters["id"] ?: return@get call.respondText("Missing Id", status = HttpStatusCode.BadRequest)
            val items = orderStorage.map { it.contents.filter { it.id == id } }.toList()
            if (items.isNotEmpty()) {
                call.respond(items)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }

        }
    }
}
