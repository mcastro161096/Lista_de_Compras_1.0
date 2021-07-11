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
                    val produto = txt_produto.text.toString()
                    val qtd = txt_qtd.text.toString()
                    val valor = txt_valor.text.toString()
                        if (produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty())
                        {
                            val prod = Produto(produto, qtd.toInt(), valor.toDouble())
                            produtosGlobal.add(prod)
                            txt_produto.text.clear()
                            txt_qtd.text.clear()
                            txt_valor.text.clear()
                            //evia para a lista
                        }
                        else{
                            txt_produto.error = if (txt_produto.text.isEmpty()) "Preencha o nome doproduto" else null
                            txt_qtd.error = if (txt_qtd.text.isEmpty()) "Preencha a quantidade" else null
                            txt_valor.error = if (txt_valor.text.isEmpty()) "Preencha o valor" else null
                            }

                        txt_produto.text.clear()
                }
                else
                    txt_produto.error = "Preencha um valor!"
            }
        })
    }
}