package com.example.ejer6repaso

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var boton = findViewById<Button>(R.id.button)
        var editText = findViewById<EditText>(R.id.editText)
        var imagen = findViewById<ImageView>(R.id.imageView)
        var fondo = findViewById<ConstraintLayout>(R.id.idFondo)

        boton.setOnClickListener {
            if(boton.text.toString() == "Comenzar"){
                boton.text = "Finalizar"
                editText.isVisible = true
            }else if (boton.text.toString() == "Finalizar"){
                boton.text = "Comenzar"
                editText.isVisible = false
            }
        }
        editText.onFocusChangeListener = View.OnFocusChangeListener { view, focus ->
            if (focus){
                editText.hint = ""
            }else{
                editText.hint = "Introduce tu nombre"
                editText.text.clear()
            }
        }

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                imagen.isVisible = editText.text.toString().contains("Wayne")
                if (editText.text.toString().contains("Joker")){
                    //editText.setTextColor(Color.parseColor("#FF0000")) una manera de ponerle color que sea
                    editText.setTextColor(Color.RED)
                    fondo.setBackgroundColor(Color.YELLOW)
                }else{
                    editText.setTextColor(Color.BLACK)
                    fondo.setBackgroundColor(Color.WHITE)
                }
            }
        })

    }
}