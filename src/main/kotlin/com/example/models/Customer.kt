package com.example.models

@kotlinx.serialization.Serializable
data class Customer(val id: String, val name: String)

val customerStorage = mutableListOf<Customer>(Customer(id="1",name="Jina"))