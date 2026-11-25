package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    onBackToLogin: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }

    fun validateAndSubmit() {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (email.isBlank()) {
            emailError = "El correo electrónico es requerido"
        } else if (!emailRegex.matches(email.trim())) {
            emailError = "Ingresa un correo electrónico válido"
        } else {
            emailError = null
            isSubmitted = true
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundCream),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackToLogin,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Regresar al inicio de sesión",
                        tint = DarkBrown,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.cat_placeholder),
                contentDescription = "Recuperar Contraseña",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Recuperar Contraseña",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = DarkBrown,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = if (isSubmitted)
                    "Hemos enviado las instrucciones para restablecer tu contraseña a tu correo electrónico."
                else
                    "Ingresa tu correo electrónico registrado y te enviaremos las instrucciones de recuperación.",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = MediumBrown,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            if (!isSubmitted) {
                CustomTextField(
                    label = "Correo Electrónico",
                    value = email,
                    onValueChange = {
                        email = it
                        if (emailError != null) emailError = null
                    },
                    keyboardType = KeyboardType.Email,
                    placeholder = "ejemplo@correo.com",
                    errorMessage = emailError
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { validateAndSubmit() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkBrown,
                        contentColor = BackgroundCream
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Text(
                        text = "Enviar Instrucciones",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = BackgroundCream
                    )
                }
            } else {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = FieldBackground),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, LightBrownBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = Color(0xFF2E7D32),
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "¡Correo Enviado!",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = DarkBrown
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Revisa tu bandeja de entrada en $email",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 13.sp,
                                color = MediumBrown
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = onBackToLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkBrown,
                        contentColor = BackgroundCream
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Text(
                        text = "Volver al Iniciar Sesión",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = BackgroundCream
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
fun ForgotPasswordScreenPreview() {
    MyApplicationTheme {
        ForgotPasswordScreen()
    }
}