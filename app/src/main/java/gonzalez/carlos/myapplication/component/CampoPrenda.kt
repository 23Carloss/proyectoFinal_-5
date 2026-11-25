package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.DarkBrown
import gonzalez.carlos.myapplication.ui.theme.FieldBackground
import gonzalez.carlos.myapplication.ui.theme.LightBrownBorder
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily
import gonzalez.carlos.myapplication.ui.theme.TextPlaceholder

@Composable
fun CampoPrenda(
    etiqueta: String,
    ejemplo: String,
    valor: String = "",
    onValorCambiado: (String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = etiqueta,
            color = DarkBrown,
            fontSize = 15.sp,
            fontFamily = PlusJakartaSansFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = valor,
            onValueChange = onValorCambiado,
            placeholder = {
                Text(
                    text = ejemplo,
                    color = TextPlaceholder,
                    fontSize = 14.sp,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Normal
                )
            },
            textStyle = TextStyle(
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = DarkBrown
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            singleLine = true,
            keyboardOptions = keyboardOptions,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = FieldBackground,
                unfocusedContainerColor = FieldBackground,
                focusedBorderColor = DarkBrown,
                unfocusedBorderColor = LightBrownBorder
            )
        )

        Spacer(modifier = Modifier.height(14.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCampoPrenda() {
    CampoPrenda("Nombre de la prenda", "Ej. Blazer oversize camel")
}