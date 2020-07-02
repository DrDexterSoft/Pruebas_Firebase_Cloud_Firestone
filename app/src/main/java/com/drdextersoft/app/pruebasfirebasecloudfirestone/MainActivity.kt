package com.drdextersoft.app.pruebasfirebasecloudfirestone

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


var db = FirebaseFirestore.getInstance()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton.setOnClickListener{
            val textos: MutableMap<String, Any> = HashMap()
            textos["texto1"] = edit1.text.toString()
            textos["texto2"] = edit2.text.toString()
            db.collection("Pruebas1")
                .add(textos)
        }

        db.collection("Pruebas1")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    texto1.text=""+texto1.text+document.data.get("texto1").toString()+"\n"
                    texto2.text=""+texto2.text+document.data.get("texto2").toString()+"\n"
                }
            }
    }

}
