package carvalho.zanini.ponderada1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

import androidx.compose.ui.tooling.preview.Preview
import carvalho.zanini.ponderada1.ui.theme.Ponderada1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LancadorDeDadosApp()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LancadorDeDadosApp() {
    var imagem by remember { mutableIntStateOf(0) }
    var dadoSelecionado by remember { mutableStateOf("D6") }
    var resultado by remember { mutableStateOf("Clique no botão para lançar o dado") }

    val dados = listOf("D6", "D10", "D20", "D100")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Lançador de Dados",
            fontSize = 28.sp
        )

        when (dadoSelecionado) {
            "D6" -> {
                val imagemDadoSelecionado = painterResource(id = R.drawable.d6)
                Image(painter = imagemDadoSelecionado, contentDescription = null, modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally)
                )
            }
            "D10" -> {
                val imagemDadoSelecionado = painterResource(id = R.drawable.d10)
                Image(painter = imagemDadoSelecionado, contentDescription = null, modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally))
            }
            "D20" -> {
                val imagemDadoSelecionado = painterResource(id = R.drawable.d20)
                Image(painter = imagemDadoSelecionado, contentDescription = null, modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally))
            }
            "D100" -> {
                val imagemDadoSelecionado = painterResource(id = R.drawable.d100)
                Image(painter = imagemDadoSelecionado, contentDescription = null, modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Escolha o tipo de dado:")

        dados.forEach { dado ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = dadoSelecionado == dado,
                    onClick = { dadoSelecionado = dado }
                )
                Text(text = dado)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val valorSorteado = when (dadoSelecionado) {
                    "D6" -> Random.nextInt(6) + 1
                    "D10" -> Random.nextInt(10) + 1
                    "D20" -> Random.nextInt(20) + 1
                    "D100" -> Random.nextInt(100) + 1
                    else -> 0
                }

                imagem = when (valorSorteado.toString()) {
                    "1" -> R.drawable._1
                    "2" -> R.drawable._2
                    "3" -> R.drawable._3
                    "4" -> R.drawable._4
                    "5" -> R.drawable._5
                    "6" -> R.drawable._6
                    else -> R.drawable._1
                }

                resultado = "Resultado do $dadoSelecionado: $valorSorteado"

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Lançar dado")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (dadoSelecionado == "D6" && imagem != 0) {
            Image(
                painter = painterResource(id = imagem),
                contentDescription = null,
                modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = resultado,
            fontSize = 20.sp
        )
    }
}