package br.com.okayamafilho.taulajetpackcomposeatualizacao

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.RED
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.okayamafilho.taulajetpackcomposeatualizacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAbrirDetalhes.setOnClickListener {
            startActivity(
                Intent(this, ComposeActivity::class.java)
            )
        }

        binding.composeAreaLista.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AreaPerfil()
            }
        }
    }

    @Composable
    fun AreaPerfil(){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .border( width = 2.dp,
                    color = androidx.compose.ui.graphics.Color.Red),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(onClick = {
                startActivity(Intent(applicationContext, DetalhesActivity::class.java))
            }) {
                Text(text = "Abrir detalhes compose")
            }
        }
    }
}