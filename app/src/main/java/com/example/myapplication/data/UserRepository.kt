package com.example.myapplication.data

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val age: Int
)

class UserRepository {
    private val users = mutableListOf<User>()

    fun addUser(user: User): Boolean {
        if (users.any { it.id == user.id }) {
            return false
        }
        users.add(user)
        return true
    }

    fun getUserById(id: Int): User? {
        return users.find { it.id == id }
    }

    fun getUserByEmail(email: String): User? {
        return users.find { it.email == email }
    }

    fun getAllUsers(): List<User> {
        return users.toList()
    }

    fun updateUser(updatedUser: User): Boolean {
        val index = users.indexOfFirst { it.id == updatedUser.id }
        if (index == -1) return false

        users[index] = updatedUser
        return true
    }

    fun deleteUser(id: Int): Boolean {
        return users.removeIf { it.id == id }
    }

    fun getUsersAboveAge(age: Int): List<User> {
        return users.filter { it.age > age }
    }

    fun clear() {
        users.clear()
    }

    fun size(): Int = users.size
}