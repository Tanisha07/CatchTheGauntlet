package com.tani.catchthekenny

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ActStart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_start)

    }

    fun newGameStart (view: View){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    fun instructions (view : View){
        val intent = Intent(applicationContext, instructions::class.java)
        startActivity(intent)
    }
}
