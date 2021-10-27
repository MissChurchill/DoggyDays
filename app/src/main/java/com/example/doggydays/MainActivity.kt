package com.example.doggydays

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import coil.load

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

                //viewModel.currentlyDisplayedDog.observe(this,
            //{ findViewById<TextView>(R.id.text).text = Dog })

            viewModel.currentlyDisplayedDog.observe(this,
                { findViewById<ImageView>(R.id.image).load(it?.image?.toUri()?.buildUpon()?.scheme("https")?.build()) })

            findViewById<Button>(R.id.button).setOnClickListener {
                viewModel.getNewDog()
            }

        }
    }

