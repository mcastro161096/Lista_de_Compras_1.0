package br.com.aula.listadecompras10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_adicionarr : Button
        btn_adicionarr = btn_adicionar
        btn_adicionarr.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(p0: View?)
            {
                val intent = Intent(this@MainActivity, CadastroActivity ::class.java)
                startActivity(intent)
            }
        })
    }
}