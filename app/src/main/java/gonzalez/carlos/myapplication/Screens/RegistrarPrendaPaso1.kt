package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.component.BotonesNavegacion
import gonzalez.carlos.myapplication.component.CampoPrenda
import gonzalez.carlos.myapplication.component.FotoPrenda
import gonzalez.carlos.myapplication.component.IndicadorProgresoPrenda
import gonzalez.carlos.myapplication.component.SelectorColores
import gonzalez.carlos.myapplication.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrarPrendaScreen(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {}
) {
    var nombrePrenda by rememberSaveable { mutableStateOf("") }
    var categoria by rememberSaveable { mutableStateOf("") }
    var enlaceCompra by rememberSaveable { mutableStateOf("") }
    var colorPrenda by rememberSaveable { mutableStateOf("Camel") }

    var expandedCategoriaMenu by remember { mutableStateOf(false) }
    val opcionesCategoria = listOf("Camisas", "Playeras", "Pantalones", "Zapatos", "Accesorios", "Chaquetas", "Vestidos")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCream)
    ) {
        IndicadorProgresoPrenda(pasoActual = 1)

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
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

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Empecemos por lo básico",
                color = DarkBrown,
                fontSize = 22.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Añade una foto y cuéntanos sobre la prenda.",
                color = MediumBrown,
                fontSize = 14.sp,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            FotoPrenda()

            Spacer(modifier = Modifier.height(20.dp))

            CampoPrenda(
                etiqueta = "Nombre de la prenda",
                ejemplo = "Ej. Blazer oversize camel",
                valor = nombrePrenda,
                onValorCambiado = { nombrePrenda = it }
            )

            Spacer(modifier = Modifier.height(14.dp))

            // ComboBox para Categoría
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Categoría",
                    color = DarkBrown,
                    fontSize = 15.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                ExposedDropdownMenuBox(
                    expanded = expandedCategoriaMenu,
                    onExpandedChange = { expandedCategoriaMenu = !expandedCategoriaMenu },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .menuAnchor(MenuAnchorType.PrimaryNotEditable, enabled = true),
                        shape = RoundedCornerShape(12.dp),
                        color = FieldBackground,
                        border = BorderStroke(1.5.dp, LightBrownBorder)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = if (categoria.isEmpty()) "Selecciona una categoría" else categoria,
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = if (categoria.isEmpty()) TextPlaceholder else DarkBrown
                            )

                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCategoriaMenu)
                        }
                    }

                    ExposedDropdownMenu(
                        expanded = expandedCategoriaMenu,
                        onDismissRequest = { expandedCategoriaMenu = false },
                        modifier = Modifier.background(BackgroundCream)
                    ) {
                        opcionesCategoria.forEach { opcion ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = opcion,
                                        fontFamily = PlusJakartaSansFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 14.sp,
                                        color = DarkBrown
                                    )
                                },
                                onClick = {
                                    categoria = opcion
                                    expandedCategoriaMenu = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            SelectorColores(
                colorSeleccionado = colorPrenda,
                onColorSeleccionado = { colorPrenda = it }
            )

            Spacer(modifier = Modifier.height(18.dp))

            CampoPrenda(
                etiqueta = "Enlace de compra (Opcional)",
                ejemplo = "Ej. https://www.tienda.com/producto",
                valor = enlaceCompra,
                onValorCambiado = { enlaceCompra = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri)
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
fun PreviewRegistroPrenda() {
    MyApplicationTheme {
        RegistrarPrendaScreen()
    }
}