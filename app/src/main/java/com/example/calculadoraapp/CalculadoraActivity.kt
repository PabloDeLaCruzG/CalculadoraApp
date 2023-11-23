package com.example.calculadoraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoraapp.databinding.ActivityCalculadoraBinding
import java.lang.StringBuilder

class CalculadoraActivity : AppCompatActivity() {

    lateinit var binding : ActivityCalculadoraBinding
    var numero = StringBuilder()
    var numeroUno: Float = 0f
    var numeroDos: Float = 0f
    var operacion: String = ""
    var resultado: Float = 0f
    var pantalla: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnUno.setOnClickListener { numberClick("1") }
        binding.btnDos.setOnClickListener { numberClick("2") }
        binding.btnTres.setOnClickListener { numberClick("3") }
        binding.btnCuatro.setOnClickListener { numberClick("4") }
        binding.btnCinco.setOnClickListener { numberClick("5") }
        binding.btnSeis.setOnClickListener { numberClick("6") }
        binding.btnSiete.setOnClickListener { numberClick("7") }
        binding.btnOcho.setOnClickListener { numberClick("8") }
        binding.btnNueve.setOnClickListener { numberClick("9") }
        binding.btnCero.setOnClickListener { numberClick("0") }

        binding.btnMas.setOnClickListener {

            operaciones()
            operacion = binding.btnMas.text.toString()

        }

        binding.btnMenos.setOnClickListener {

            operaciones()
            operacion = binding.btnMenos.text.toString()

        }

        binding.btnMultiplicacion.setOnClickListener {


            operacion = binding.btnMultiplicacion.text.toString()

        }

        binding.btnDivision.setOnClickListener {

            operaciones()
            operacion = binding.btnDivision.text.toString()

        }

        binding.btnIgual.setOnClickListener {

            operaciones()

        }

        binding.btnClear.setOnClickListener {

            numero = StringBuilder()
            numeroUno = 0f
            numeroDos = 0f
            pantalla = ""
            resultado = 0f
            binding.textView.text = ""

        }

        binding.btnDecimal.setOnClickListener {

            numberClick(".")

        }

    }



    fun numberClick(numBoton: String) {
        pantalla += numBoton
        binding.textView.text = pantalla
    }

    fun operaciones() {

        if (pantalla.isNotEmpty()) {

            numeroDos = pantalla.toFloat()

            if (operacion == "") {

                resultado = numeroDos

            } else if (operacion == "+") {

                resultado += numeroDos

            } else if (operacion == "-") {

                resultado -= numeroDos

            } else if (operacion == "x") {

                resultado *= numeroDos

            } else if (operacion == "/") {

                resultado /= numeroDos

            }

            pantalla = ""
            binding.textView.text = resultado.toString()

        }

    }
}
