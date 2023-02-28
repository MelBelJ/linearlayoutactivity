package edu.iest.linearlayoutactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var bnSuma : Button? =null
    private var bnResta : Button? =null
    private var etNumeroPrimero: EditText? = null
    private var etNumeroSegundo: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        asignarEventos()
        inicializarVistas()
    }

    private fun asignarEventos(){
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
    }
    private fun inicializarVistas(){
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
    }
    override fun onClick(miVista: View?) {
        val numeroUno = etNumeroPrimero?.text.toString().toFloat()
        val numeroDos = etNumeroSegundo?.text.toString().toFloat()
        if (numeroUno == null)
            return
        if (numeroDos==null)
            return

        val aritmetica = Aritmetica()

        when(miVista?.id){
            R.id.bnSuma -> {
                val suma = aritmetica.suma(numeroUno, numeroDos)
                val mensaje=  mensajes("La sumatoria fue $suma", this)
                mensaje.mostrarToast()

            }

            R.id.bnResta -> {
                val resta = aritmetica.resta(numeroUno, numeroDos)
                val mensaje=mensajes("El resultado es $resta",this)
                mensaje.mostrarSnackbar(miVista)
            }
        }

    }

}