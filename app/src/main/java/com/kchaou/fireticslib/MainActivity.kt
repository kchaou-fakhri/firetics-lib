package com.kchaou.fireticslib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.google.firebase.ktx.Firebase
import com.kchaou.fireticslibrary.Firetics
import com.kchaou.fireticslibrary.Put

class MainActivity : AppCompatActivity() {
    lateinit var firetics: Firetics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Firebase

        firetics = Firetics(db, this)
        firetics.put.start()
        firetics.get.get().observe(this, Observer {
            Log.println(Log.ASSERT, "---------", it.toString())
        })

    }

    override fun onStop() {
        firetics.put.changeData()
        super.onStop()
    }


}