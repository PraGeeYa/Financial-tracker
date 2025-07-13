package com.example.coinomy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PasscodeActivity : AppCompatActivity() {
    private lateinit var passcodeDisplay: TextView
    private var enteredPasscode = ""
    private val correctPasscode = "1111"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passcode)

        passcodeDisplay = findViewById(R.id.passcodeDisplay)

        // Set up number buttons
        for (i in 0..9) {
            val buttonId = resources.getIdentifier("button$i", "id", packageName)
            findViewById<Button>(buttonId).setOnClickListener {
                if (enteredPasscode.length < 4) {
                    enteredPasscode += i.toString()
                    updatePasscodeDisplay()
                }
            }
        }

        // Clear button
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            enteredPasscode = ""
            updatePasscodeDisplay()
        }

        // Delete button
        findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            if (enteredPasscode.isNotEmpty()) {
                enteredPasscode = enteredPasscode.substring(0, enteredPasscode.length - 1)
                updatePasscodeDisplay()
            }
        }
    }

    private fun updatePasscodeDisplay() {
        passcodeDisplay.text = "•".repeat(enteredPasscode.length)
        
        if (enteredPasscode.length == 4) {
            if (enteredPasscode == correctPasscode) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Wrong passcode. Try again.", Toast.LENGTH_SHORT).show()
                enteredPasscode = ""
                updatePasscodeDisplay()
            }
        }
    }
} 