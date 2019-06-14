package com.curtesmalteser.tragicintroductiontokoinandcoroutines

interface HelloRepository {
    fun giveHello(): String
}

class HelloRepositoryImpl() : HelloRepository {
    override fun giveHello() = "Hello Koin"
}