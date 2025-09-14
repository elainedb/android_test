package com.example.myapplication.data

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UserRepositoryTest {

    private lateinit var userRepository: UserRepository
    private val user1 = User(1, "John Doe", "john@example.com", 25)
    private val user2 = User(2, "Jane Smith", "jane@example.com", 30)
    private val user3 = User(3, "Bob Johnson", "bob@example.com", 35)

    @Before
    fun setUp() {
        userRepository = UserRepository()
    }

    @Test
    fun addUser_shouldAddNewUserSuccessfully() {
        assertTrue(userRepository.addUser(user1))
        assertEquals(1, userRepository.size())
        assertEquals(user1, userRepository.getUserById(1))
    }

    @Test
    fun addUser_shouldReturnFalseWhenUserWithSameIdExists() {
        assertTrue(userRepository.addUser(user1))
        assertFalse(userRepository.addUser(user1))
        assertEquals(1, userRepository.size())
    }

    @Test
    fun getUserById_shouldReturnCorrectUser() {
        userRepository.addUser(user1)
        userRepository.addUser(user2)

        assertEquals(user1, userRepository.getUserById(1))
        assertEquals(user2, userRepository.getUserById(2))
    }

    @Test
    fun getUserById_shouldReturnNullWhenUserNotFound() {
        assertNull(userRepository.getUserById(999))
    }

    @Test
    fun getUserByEmail_shouldReturnCorrectUser() {
        userRepository.addUser(user1)
        userRepository.addUser(user2)

        assertEquals(user1, userRepository.getUserByEmail("john@example.com"))
        assertEquals(user2, userRepository.getUserByEmail("jane@example.com"))
    }

    @Test
    fun getUserByEmail_shouldReturnNullWhenEmailNotFound() {
        assertNull(userRepository.getUserByEmail("nonexistent@example.com"))
    }

    @Test
    fun getAllUsers_shouldReturnAllAddedUsers() {
        userRepository.addUser(user1)
        userRepository.addUser(user2)
        userRepository.addUser(user3)

        val allUsers = userRepository.getAllUsers()
        assertEquals(3, allUsers.size)
        assertTrue(allUsers.contains(user1))
        assertTrue(allUsers.contains(user2))
        assertTrue(allUsers.contains(user3))
    }

    @Test
    fun getAllUsers_shouldReturnEmptyListWhenNoUsers() {
        assertTrue(userRepository.getAllUsers().isEmpty())
    }

    @Test
    fun updateUser_shouldUpdateExistingUser() {
        userRepository.addUser(user1)
        val updatedUser = user1.copy(name = "John Updated", age = 26)

        assertTrue(userRepository.updateUser(updatedUser))
        assertEquals(updatedUser, userRepository.getUserById(1))
    }

    @Test
    fun updateUser_shouldReturnFalseWhenUserNotFound() {
        assertFalse(userRepository.updateUser(user1))
    }

    @Test
    fun deleteUser_shouldRemoveUserSuccessfully() {
        userRepository.addUser(user1)
        userRepository.addUser(user2)

        assertTrue(userRepository.deleteUser(1))
        assertEquals(1, userRepository.size())
        assertNull(userRepository.getUserById(1))
        assertNotNull(userRepository.getUserById(2))
    }

    @Test
    fun deleteUser_shouldReturnFalseWhenUserNotFound() {
        assertFalse(userRepository.deleteUser(999))
    }

    @Test
    fun getUsersAboveAge_shouldReturnUsersAboveGivenAge() {
        userRepository.addUser(user1) // age 25
        userRepository.addUser(user2) // age 30
        userRepository.addUser(user3) // age 35

        val usersAbove28 = userRepository.getUsersAboveAge(28)
        assertEquals(2, usersAbove28.size)
        assertTrue(usersAbove28.contains(user2))
        assertTrue(usersAbove28.contains(user3))
        assertFalse(usersAbove28.contains(user1))
    }

    @Test
    fun getUsersAboveAge_shouldReturnEmptyListWhenNoUsersAboveAge() {
        userRepository.addUser(user1) // age 25

        val usersAbove30 = userRepository.getUsersAboveAge(30)
        assertTrue(usersAbove30.isEmpty())
    }

    @Test
    fun clear_shouldRemoveAllUsers() {
        userRepository.addUser(user1)
        userRepository.addUser(user2)
        assertEquals(2, userRepository.size())

        userRepository.clear()
        assertEquals(0, userRepository.size())
        assertTrue(userRepository.getAllUsers().isEmpty())
    }

    @Test
    fun size_shouldReturnCorrectNumberOfUsers() {
        assertEquals(0, userRepository.size())

        userRepository.addUser(user1)
        assertEquals(1, userRepository.size())

        userRepository.addUser(user2)
        assertEquals(2, userRepository.size())

        userRepository.deleteUser(1)
        assertEquals(1, userRepository.size())
    }
}