package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.ui.theme.BackgroundCream
import gonzalez.carlos.myapplication.ui.theme.DarkBrown
import gonzalez.carlos.myapplication.ui.theme.FieldBackground
import gonzalez.carlos.myapplication.ui.theme.LightBrownBorder
import gonzalez.carlos.myapplication.ui.theme.MediumBrown
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun SelectorColores(
    colorSeleccionado: String = "Camel",
    onColorSeleccionado: (String) -> Unit = {}
) {
    val colores = listOf(
        "Camel", "Negro", "Blanco", "Beige", "Gris",
        "Azul", "Azul Marino", "Rojo", "Vino", "Verde",
        "Verde Olivo", "Rosa", "Morado", "Amarillo",
        "Naranja", "Marrón", "Mostaza", "Turquesa"
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Color principal",
            color = DarkBrown,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            colores.forEach { color ->
                val isSelected = colorSeleccionado.equals(color, ignoreCase = true)

                val colorPrenda = when (color) {
                    "Camel" -> Color(0xFFC19A6B)
                    "Negro" -> Color(0xFF212121)
                    "Blanco" -> Color(0xFFFFFFFF)
                    "Beige" -> Color(0xFFF5F5DC)
                    "Gris" -> Color(0xFF757575)
                    "Azul" -> Color(0xFF1976D2)
                    "Azul Marino" -> Color(0xFF0D47A1)
                    "Rojo" -> Color(0xFFD32F2F)
                    "Vino" -> Color(0xFF880E4F)
                    "Verde" -> Color(0xFF388E3C)
                    "Verde Olivo" -> Color(0xFF558B2F)
                    "Rosa" -> Color(0xFFE91E63)
                    "Morado" -> Color(0xFF7B1FA2)
                    "Amarillo" -> Color(0xFFFBC02D)
                    "Naranja" -> Color(0xFFF57C00)
                    "Marrón" -> Color(0xFF5D4037)
                    "Mostaza" -> Color(0xFFE65100)
                    "Turquesa" -> Color(0xFF00ACC1)
                    else -> MediumBrown
                }

                val isLightColor = color in listOf("Blanco", "Beige", "Camel", "Amarillo")
                val iconCheckTint = if (isLightColor) DarkBrown else Color.White

                OutlinedButton(
                    onClick = { onColorSeleccionado(color) },
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(
                        width = if (isSelected) 2.5.dp else 1.5.dp,
                        color = if (isSelected) DarkBrown else LightBrownBorder
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isSelected) BackgroundCream else FieldBackground
                    ),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Círculo de color (SIEMPRE VISIBLE)
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .background(colorPrenda)
                                .border(
                                    width = 1.dp,
                                    color = if (isLightColor) LightBrownBorder else Color.Transparent,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Seleccionado",
                                    tint = iconCheckTint,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }

                        Text(
                            text = color,
                            fontSize = 13.sp,
                            color = DarkBrown,
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectorColores() {
    SelectorColores()
}