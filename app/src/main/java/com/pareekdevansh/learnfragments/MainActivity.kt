package com.pareekdevansh.learnfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val firstFragment = Fragment1()
    val secondFragment = Fragment2()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.btn1)
        val button2 = findViewById<Button>(R.id.btn2)
        val num = 1

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, firstFragment)
            commit()
        }

        button1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, firstFragment)
                addToBackStack(null)
                commit()
            }
            showToast(1)
        }
        button2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, secondFragment)
                addToBackStack(null)
                commit()
            }
            showToast(2)
        }
    }
    private fun showToast( num :Int)
    {
        val toast = Toast.makeText(this, "Loading Fragment $num", Toast.LENGTH_SHORT)
        toast.show()
    }
}