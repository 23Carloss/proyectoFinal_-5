package gonzalez.carlos.myapplication.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.PlusJakartaSansFontFamily

@Composable
fun BotonesNavegacion(
    onAtrasClick: () -> Unit = {},
    onContinuarClick: () -> Unit = {},
    textoAtras: String = "Atrás",
    textoContinuar: String = "Continuar",
    modifier: Modifier = Modifier,
    continuarHabilitado: Boolean = true
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedButton(
            onClick = onAtrasClick,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = colorResource(id = R.color.AddImageBackground)
            )
        ) {
            Text(
                text = textoAtras,
                color = colorResource(id = R.color.fontColor),
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
        Button(
            onClick = onContinuarClick,
            enabled = continuarHabilitado,
            modifier = Modifier
                .weight(2f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.ButtonContinueBackground)
            )
        ) {
            Text(
                text = textoContinuar,
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewBotonesNavegacion() {
    BotonesNavegacion({}, {}, "Atrás", "Continuar")
}