package com.example.vangtichai

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentInput = ""

    private lateinit var amountText: TextView

    private val noteViews = mutableMapOf<Long, TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        bindViews()
        setupKeypad()

        currentInput =
            savedInstanceState?.getString(KEY_CURRENT_INPUT) ?: ""

        updateScreen()
    }

    private fun bindViews() {

        amountText = findViewById(R.id.tvAmount)

        noteViews[500L] = findViewById(R.id.tv500)
        noteViews[100L] = findViewById(R.id.tv100)
        noteViews[50L] = findViewById(R.id.tv50)
        noteViews[20L] = findViewById(R.id.tv20)
        noteViews[10L] = findViewById(R.id.tv10)
        noteViews[5L] = findViewById(R.id.tv5)
        noteViews[2L] = findViewById(R.id.tv2)
        noteViews[1L] = findViewById(R.id.tv1)
    }

    private fun setupKeypad() {

        val digitButtons = mapOf(
            R.id.btn0 to '0',
            R.id.btn1 to '1',
            R.id.btn2 to '2',
            R.id.btn3 to '3',
            R.id.btn4 to '4',
            R.id.btn5 to '5',
            R.id.btn6 to '6',
            R.id.btn7 to '7',
            R.id.btn8 to '8',
            R.id.btn9 to '9'
        )

        for ((buttonId, digit) in digitButtons) {
            findViewById<Button>(buttonId).setOnClickListener {
                addDigit(digit)
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            updateScreen()
        }
    }

    private fun addDigit(digit: Char) {

        val newInput = currentInput + digit

        if (newInput.toLongOrNull() != null) {
            currentInput = newInput
            updateScreen()
        }
    }

    private fun updateScreen() {

        if (currentInput.isEmpty()) {
            amountText.text = getString(R.string.taka_empty)
        } else {
            amountText.text =
                getString(R.string.taka_value, currentInput)
        }

        var remainingAmount =
            currentInput.toLongOrNull() ?: 0L

        for (note in NOTES) {

            val numberOfNotes =
                remainingAmount / note

            remainingAmount %= note

            noteViews[note]?.text =
                getString(
                    R.string.note_count,
                    note.toString(),
                    numberOfNotes.toString()
                )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putString(
            KEY_CURRENT_INPUT,
            currentInput
        )

        super.onSaveInstanceState(outState)
    }

    companion object {

        private const val KEY_CURRENT_INPUT =
            "current_input"

        private val NOTES = listOf(
            500L,
            100L,
            50L,
            20L,
            10L,
            5L,
            2L,
            1L
        )
    }
}