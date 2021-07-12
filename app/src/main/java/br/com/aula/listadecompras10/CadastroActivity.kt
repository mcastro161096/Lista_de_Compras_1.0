package br.com.aula.listadecompras10

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlin.math.absoluteValue

class CadastroActivity : Activity() {
    val COD_IMAGE = 101
    var imageBitMap: Bitmap? = null
    fun abrirGaleria(){

        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), COD_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {

                val inputStream = data.getData()?.let { contentResolver.openInputStream(it) };
                imageBitMap = BitmapFactory.decodeStream(inputStream)
                img_foto_produto.setImageBitmap(imageBitMap)

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        val btn_inserirr : Button
        btn_inserirr = btn_inserir

        val img_foto_camera = img_foto_produto
        img_foto_camera.setOnClickListener {
            abrirGaleria()
        }

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
                            val prod = Produto(produto, qtd.toInt(), valor.toDouble(), imageBitMap)
                            produtosGlobal.add(prod)
                            txt_produto.text.clear()
                            txt_qtd.text.clear()
                            txt_valor.text.clear()
                            val ic_twotone_photo_camera_24 = R.drawable.ic_twotone_photo_camera_24
                            img_foto_produto.setImageResource(ic_twotone_photo_camera_24)
                            imageBitMap = null
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