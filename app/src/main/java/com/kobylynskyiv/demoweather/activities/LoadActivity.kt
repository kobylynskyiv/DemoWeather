package com.kobylynskyiv.demoweather.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.kobylynskyiv.demoweather.databinding.ActivityLoadBinding

/**
 * Start application
 */
class LoadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadBinding
    private val splashScreenDuration = 2000f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                this.finish()
            },
            splashScreenDuration.toLong()
        )
    }


}