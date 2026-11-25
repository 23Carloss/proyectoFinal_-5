package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.component.BotonesNavegacion
import gonzalez.carlos.myapplication.component.CampoTagsPrenda
import gonzalez.carlos.myapplication.component.GrupoOpcionesPrenda
import gonzalez.carlos.myapplication.component.IndicadorProgresoPrenda
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun RegistrarPrendaPaso2(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {}
) {
    var estampada by rememberSaveable { mutableStateOf(false) }
    var temporada by rememberSaveable { mutableStateOf("Otoño") }
    var formalidad by rememberSaveable { mutableStateOf("Casual") }
    var textoTag by rememberSaveable { mutableStateOf("") }
    var tags by rememberSaveable { mutableStateOf(listOf("Favorito", "Básico", "Neutro")) }
    var tagSeleccionado by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCream)
    ) {
        IndicadorProgresoPrenda(pasoActual = 2)

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registrar Prenda",
                color = DarkBrown,
                fontSize = 26.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Dale sus detalles",
                color = DarkBrown,
                fontSize = 22.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Así será más fácil encontrarla y combinarla.",
                color = MediumBrown,
                fontSize = 14.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            GrupoOpcionesPrenda(
                titulo = "¿Es estampada?",
                opciones = listOf("No", "Sí"),
                seleccionadas = listOf(if (estampada) "Sí" else "No"),
                onOpcionSeleccionada = { estampada = it == "Sí" }
            )

            Spacer(modifier = Modifier.height(20.dp))

            CampoTagsPrenda(
                texto = textoTag,
                tags = tags,
                tagsSeleccionados = listOfNotNull(tagSeleccionado),
                onTextoCambiado = { textoTag = it },
                onAgregarTag = {
                    val tag = textoTag.trim()
                    if (tag.isNotEmpty() && tag !in tags) {
                        tags = tags + tag
                        tagSeleccionado = tag
                        textoTag = ""
                    }
                },
                onTagSeleccionado = { tag ->
                    tagSeleccionado = if (tagSeleccionado == tag) null else tag
                }
            )

            Spacer(modifier = Modifier.height(18.dp))

            GrupoOpcionesPrenda(
                titulo = "Temporada",
                opciones = listOf("Primavera", "Verano", "Otoño", "Invierno"),
                seleccionadas = listOf(temporada),
                onOpcionSeleccionada = { temporada = it }
            )

            Spacer(modifier = Modifier.height(18.dp))

            GrupoOpcionesPrenda(
                titulo = "Formalidad",
                opciones = listOf("Casual", "Formal", "Deportivo"),
                seleccionadas = listOf(formalidad),
                onOpcionSeleccionada = { formalidad = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            BotonesNavegacion(
                onAtrasClick = onAtrasClick,
                onContinuarClick = onContinuarClick
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        AppBottomNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrarPrendaPaso2() {
    MyApplicationTheme {
        RegistrarPrendaPaso2()
    }
}