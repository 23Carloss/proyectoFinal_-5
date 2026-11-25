package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.component.BotonesNavegacion
import gonzalez.carlos.myapplication.component.IndicadorProgresoPrenda
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun RegistrarPrendaPaso3(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {}
) {
    var marca by rememberSaveable { mutableStateOf("") }
    var talla by rememberSaveable { mutableStateOf("") }
    var mostrarTallas by remember { mutableStateOf(false) }

    val formaCampo = RoundedCornerShape(12.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCream)
    ) {
        IndicadorProgresoPrenda(pasoActual = 3)

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {
            Text(
                text = "Registrar Prenda",
                modifier = Modifier.fillMaxWidth(),
                color = DarkBrown,
                fontSize = 26.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Unos detalles más",
                color = DarkBrown,
                fontSize = 22.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "La marca y la talla son opcionales.",
                color = MediumBrown,
                fontSize = 14.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Tienda o marca",
                    color = DarkBrown,
                    fontSize = 15.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "  (Opcional)",
                    color = MediumBrown,
                    fontSize = 13.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = formaCampo,
                color = FieldBackground,
                border = BorderStroke(1.5.dp, LightBrownBorder)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 14.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (marca.isEmpty()) {
                        Text(
                            text = "Ej. Zara",
                            color = TextPlaceholder,
                            fontSize = 14.sp,
                            fontFamily = PlusJakartaSansFontFamily
                        )
                    }
                    BasicTextField(
                        value = marca,
                        onValueChange = { marca = it },
                        singleLine = true,
                        textStyle = TextStyle(
                            color = DarkBrown,
                            fontSize = 14.sp,
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Talla",
                    color = DarkBrown,
                    fontSize = 15.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "  (Opcional)",
                    color = MediumBrown,
                    fontSize = 13.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Box {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .clickable { mostrarTallas = true },
                    shape = formaCampo,
                    color = FieldBackground,
                    border = BorderStroke(1.5.dp, LightBrownBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = talla.ifEmpty { "Selecciona una talla" },
                            modifier = Modifier.weight(1f),
                            color = if (talla.isEmpty()) TextPlaceholder else DarkBrown,
                            fontSize = 14.sp,
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "⌄",
                            color = DarkBrown,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                DropdownMenu(
                    expanded = mostrarTallas,
                    onDismissRequest = { mostrarTallas = false },
                    modifier = Modifier.background(BackgroundCream)
                ) {
                    listOf("XS", "S", "M", "L", "XL", "XXL", "Unitalla").forEach { opcion ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = opcion,
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontSize = 14.sp,
                                    color = DarkBrown
                                )
                            },
                            onClick = {
                                talla = opcion
                                mostrarTallas = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                color = FieldBackground,
                border = BorderStroke(1.5.dp, LightBrownBorder)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Podrás editar estos datos cuando quieras.",
                        color = DarkBrown,
                        fontSize = 13.sp,
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            BotonesNavegacion(
                onAtrasClick = onAtrasClick,
                onContinuarClick = onContinuarClick,
                textoAtras = "Atrás",
                textoContinuar = "Guardar prenda"
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        AppBottomNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrarPrendaPaso3() {
    MyApplicationTheme {
        RegistrarPrendaPaso3()
    }
}