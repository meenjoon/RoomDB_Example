package com.example.roomdb_example

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myText : TextView = findViewById(R.id.textView)

        var newUser = User("홍길동", "20", "010-1234-1234")

//        //싱글톤 패턴을 사용하지 않은경우
//        val db = Room.databaseBuilder(
//            applicationContext,
//            UserDatabase::class.java,
//            "user-database"
//        ).build()
//        db.userDao().insert(newUser)

        //싱글톤 패턴을 사용한 경우
        val db = UserDatabase.getInstance(applicationContext)

        CoroutineScope(Dispatchers.IO).launch {
            db!!.userDao().insert(newUser)
            myText.text = db.userDao().getAll().toString()
            db.userDao().deleteUserByName("홍길동")
        }
    }
}
