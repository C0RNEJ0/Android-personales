package upv_dap.sep_dic_25.itiid_76129.piu1.calculadorhorasclase_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// Asegúrate de que R se resuelva. Si no, verifica el nombre del paquete y esta importación:
// import upv_dap.sep_dic_25.itiid_76129.piu1.calculadorhorasclase_kotlin.R

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var boton1: Button
    private lateinit var textViewLista: TextView // Para mostrar la lista de nombres

    private val names = ArrayList<String>() // Para almacenar los nombres

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // Asegúrate que R.layout.activity_main sea correcto

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar vistas
        editText1 = findViewById(R.id.EditText1)
        boton1 = findViewById(R.id.Boton1)
        textViewLista = findViewById(R.id.TextViewLista) // Usa el ID de tu XML para la lista

        boton1.setOnClickListener {
            val nombre = editText1.text.toString().trim()

            if (nombre.isNotEmpty()) {
                names.add(nombre)

                // Mostrar mensaje de bienvenida
                Toast.makeText(
                    applicationContext,
                    "Bienvenido Señor: $nombre",
                    Toast.LENGTH_SHORT
                ).show()

                // Actualizar la lista en el TextView
                textViewLista.text = names.joinToString(separator = "\n")

                // Limpiar el campo de entrada
                editText1.text.clear()
            } else {
                Toast.makeText(applicationContext, "Escribe un nombre primero", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
