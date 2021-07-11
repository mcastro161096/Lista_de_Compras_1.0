package br.com.aula.listadecompras10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        val btn_inserirr : Button
        btn_inserirr = btn_inserir
        btn_inserirr.setOnClickListener(object : View.OnClickListener
        {
           override fun onClick(p0: View?)
            {
                val produto : String
                produto = txt_produto.text.toString()
                if (produto.isNotEmpty())
                {
                    //evia para a lista
                    txt_produto.text.clear()
                }
                else
                    txt_produto.error = "Preencha um valor!"
            }
        })
    }
}