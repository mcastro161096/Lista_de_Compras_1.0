package br.com.aula.listadecompras10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ProdutoAdapter(this)
        list_view_produtos.adapter = produtosAdapter

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

        val btn_limparr : Button
        btn_limparr = btn_limpar
        btn_limparr.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(p0: View?)
            {
                list_view_produtos.removeAllViewsInLayout()
                txt_total.text = "TOTAL: 0,00"
                produtosGlobal.clear()

            }
        })
    }

    override fun onResume() {
        super.onResume()
        val adapter = list_view_produtos.adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)
        val soma = produtosGlobal.sumByDouble { it.valor * it.quantidade}
        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        txt_total.text = "TOTAL: ${ f.format(soma)}"
    }
}