package com.maricotalembrancinhas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.ads.MobileAds
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        val dec = DecimalFormat("#,###.00")

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //Inicializando
        var margem_generica = 140

        //Clicando no Botao Calcular
        calcular.setOnClickListener {
            if(edit_margem.text.isEmpty()){
                esconderTelaMargem()
            } else {
                margem_generica = toInt(edit_margem.text.toString())
                esconderTelaMargem()
            }

            if(item1.text.isEmpty() && item2.text.isEmpty() &&
                item3.text.isEmpty() && item4.text.isEmpty() &&
                item5.text.isEmpty() && item6.text.isEmpty() &&
                item7.text.isEmpty() && item8.text.isEmpty() &&
                item9.text.isEmpty() && item10.text.isEmpty() &&
                item11.text.isEmpty() && item12.text.isEmpty()){
                resultado.text = "Insira Algum Item"
            } else {
                if(item1.text.isEmpty()){
                    item1.setText("0.0")
                }
                if(item2.text.isEmpty()){
                    item2.setText("0.0")
                }
                if(item3.text.isEmpty()){
                    item3.setText("0.0")
                }
                if(item4.text.isEmpty()){
                    item4.setText("0.0")
                }
                if(item5.text.isEmpty()){
                    item5.setText("0.0")
                }
                if(item6.text.isEmpty()){
                    item6.setText("0.0")
                }
                if(item7.text.isEmpty()){
                    item7.setText("0.0")
                }
                if(item8.text.isEmpty()){
                    item8.setText("0.0")
                }
                if(item9.text.isEmpty()){
                    item9.setText("0.0")
                }
                if(item10.text.isEmpty()){
                    item10.setText("0.0")
                }
                if(item11.text.isEmpty()){
                    item11.setText("0.0")
                }
                if(item12.text.isEmpty()){
                    item12.setText("0.0")
                }

                //var itens = DoubleArray(12)
                var Item1 = toDouble(item1.text.toString())
                var Item2 = toDouble(item2.text.toString())
                var Item3 = toDouble(item3.text.toString())
                var Item4 = toDouble(item4.text.toString())
                var Item5 = toDouble(item5.text.toString())
                var Item6 = toDouble(item6.text.toString())
                var Item7 = toDouble(item7.text.toString())
                var Item8 = toDouble(item8.text.toString())
                var Item9 = toDouble(item9.text.toString())
                var Item10 = toDouble(item10.text.toString())
                var Item11 = toDouble(item11.text.toString())
                var Item12 = toDouble(item12.text.toString())

                var resultado_final = calcular(Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,margem_generica)
                resultado.text = "R$ ${dec.format(resultado_final)}"


            }

            }

        margem.setOnClickListener {
            mostrarTelaMargem()
        }

        margem_OK.setOnClickListener {
            if(edit_margem.text.isEmpty()){
                esconderTelaMargem()
            } else {
                margem_generica = toInt(edit_margem.text.toString())
                esconderTelaMargem()
            }
        }

        clear.setOnClickListener {
            limparDados()
            margem_generica = 140
        }

        }

    private fun toDouble (string:String): Double {
        val String = string.toDouble()
        return String
    }
    private fun toInt (string:String): Int {
        return string.toInt()
    }

    private fun calcular (item1:Double ,item2:Double ,item3:Double ,item4:Double ,
                          item5:Double ,item6:Double ,item7:Double ,item8:Double ,
                          item9:Double ,item10:Double ,item11:Double ,item12:Double ,margem:Int):Double {
        var soma = item1 + item2 + item3 + item4 + item5 + item6 + item7 + item8 + item9 + item10 + item11 + item12
        var resultado = (soma) + ((soma * margem) / 100)
        return resultado
    }

    private fun limparDados(): Unit {
        item1.setText("")
        item2.setText("")
        item3.setText("")
        item4.setText("")
        item5.setText("")
        item6.setText("")
        item7.setText("")
        item8.setText("")
        item9.setText("")
        item10.setText("")
        item11.setText("")
        item12.setText("")
        edit_margem.setText("")
        resultado.text = ""
    }

    private fun mostrarTelaMargem(): Unit {
        view_margen.visibility = View.VISIBLE
        edit_margem.visibility = View.VISIBLE
        margem_OK.visibility = View.VISIBLE
        text_margem.visibility = View.VISIBLE
        percent.visibility = View.VISIBLE
    }

    private fun esconderTelaMargem(): Unit {
        view_margen.visibility = View.INVISIBLE
        edit_margem.visibility = View.INVISIBLE
        margem_OK.visibility = View.INVISIBLE
        text_margem.visibility = View.INVISIBLE
        percent.visibility = View.INVISIBLE
    }




    }






