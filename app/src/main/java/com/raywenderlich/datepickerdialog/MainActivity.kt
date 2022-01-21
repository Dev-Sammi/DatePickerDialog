package com.raywenderlich.datepickerdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentContainer = supportFragmentManager.findFragmentById(R.id.fragment_container_id)
        if (fragmentContainer == null){
            val dateFragment = DataFragment.getInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_id, dateFragment)
                .commit()
        }
    }
}