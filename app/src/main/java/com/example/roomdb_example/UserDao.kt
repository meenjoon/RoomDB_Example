package com.example.roomdb_example

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM User") //테이블의 모든 값 가져오기
    fun getAll(): List<User>

    @Query("DELETE FROM User WHERE name = :name")
    fun deleteUserByName(name: String)
}
