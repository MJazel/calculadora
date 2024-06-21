package com.example.appmicalculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsuario:EditText;
    private lateinit var txtPassword:EditText;
    private lateinit var btnIngresar:Button;
    private lateinit var btnSalir:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarComponentes(){
        txtUsuario = findViewById(R.id.txtUsuario) as EditText
        txtPassword = findViewById(R.id.txtPassword) as EditText
        btnSalir = findViewById(R.id.btnSalir) as Button
        btnIngresar = findViewById(R.id.btnIngresar) as Button
    }

    public fun eventosClic(){
        btnIngresar.setOnClickListener(View.OnClickListener {
            var usuario:String = getString(R.string.usuario)
            var pass:String = getString(R.string.pass)
            if (txtUsuario.text.toString().contentEquals(usuario) && txtPassword.text.toString().contentEquals(pass)){
                val intent = Intent(this,operacionesActivity::class.java)
                intent.putExtra("nombre",txtUsuario.text.toString())
                startActivity(intent)
            }else
                Toast.makeText(this, "El usuario o password no es correcto", Toast.LENGTH_SHORT).show()
        })
        btnSalir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}