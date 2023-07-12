package com.example.homework_4fragments

import com.github.javafaker.Faker

object Data {

    private val faker = Faker.instance()
    val users = mutableListOf(
        User(0, faker.country().flag().toString(), "Andrey", "Arshavin", "88005553535"),
        User(1, faker.country().flag().toString(), "Brad", "Pitt", "8984373054234"),
        User(2, faker.country().flag().toString(), "Nicolas", "Cage", "3496498567934"),
        User(3, faker.country().flag().toString(), "Joe", "Biden", "2625465462546"),
    )

    fun updateUser(user: User) {
        val index = users.indexOfFirst { it.id == user.id }
        users[index] = user
    }

    fun getUsersList(): List<User> = users.toList()
}