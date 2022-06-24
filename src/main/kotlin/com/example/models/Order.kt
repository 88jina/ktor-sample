package com.example.models

@kotlinx.serialization.Serializable
data class Order(val id: String, val contents: List<Item>)

@kotlinx.serialization.Serializable
data class Item(val id: String, val name: String, val price: Double)


val orderStorage = listOf(
    Order(id = "1", contents = listOf(Item("1", "음료수", 29.0), Item("2", "아이스크림", 39.0), Item("3", "과자", 19.0))),
    Order(id = "2", contents = listOf(Item("1", "음료수", 29.0), Item("6", "아이스크림1", 9.0), Item("23", "과자22", 29.0))),
)