package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale

@Composable
fun SignUpScreen(navController: NavController, modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }


    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidName(name: String): Boolean {
        return name.all { it.isLetter() || it.isWhitespace() }
    }

    fun isValidPhone(phone: String): Boolean {
        return phone.length == 10 && phone.all { it.isDigit() }
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }

    fun passwordsMatch(password: String, confirmPass: String): Boolean {
        return password == confirmPass && password.isNotEmpty()
    }

    val formValid = nameError && emailError && phoneError && passwordError && confirmPasswordError

    val textFieldColors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Color(0xFFEBEBEB),
        unfocusedContainerColor = Color.White,
        focusedBorderColor = Color(0xFF5B4DCC),
        unfocusedBorderColor = Color(0xFFA59CE9),
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF5B4DCC)),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.9f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(24.dp)
        ) {

            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = modifier.height(15.dp))

                    // Imagagen principal
                    Image(
                        painter = painterResource(id = R.drawable.fondo_pantalla),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(130.dp)
                    )

                    Spacer(modifier = modifier.height(30.dp))

                    //Title
                    Text(
                        text = "Sign Up",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = modifier.height(15.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                            nameError = isValidName(it)},
                        enabled = true,
                        readOnly = false,
                        label = { Text("Full name", color = Color.DarkGray) },
                        modifier = modifier.padding(5.dp),
                        isError = !nameError,
                        shape = CircleShape,
                        colors = textFieldColors
                    )

                    Spacer(modifier = modifier.height(15.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            emailError = isValidEmail(it)},
                        enabled = true,
                        readOnly = false,
                        label = { Text("Email", color = Color.DarkGray) },
                        modifier = modifier.padding(5.dp),
                        isError = !emailError,
                        shape = CircleShape,
                        colors = textFieldColors
                    )

                    Spacer(modifier = modifier.height(15.dp))

                    OutlinedTextField(
                        value = phone,
                        onValueChange = {
                            phone = it
                            phoneError = isValidPhone(it)},
                        enabled = true,
                        readOnly = false,
                        label = { Text("Phone number", color = Color.DarkGray) },
                        modifier = modifier.padding(5.dp),
                        isError = !phoneError,
                        shape = CircleShape,
                        colors = textFieldColors
                    )

                    Spacer(modifier = modifier.height(15.dp))


                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            passwordError = isValidPassword(it)},
                        enabled = true,
                        readOnly = false,
                        label = { Text("Password", color = Color.DarkGray) },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = modifier.padding(5.dp),
                        isError = !passwordError,
                        shape = CircleShape,
                        colors = textFieldColors
                    )

                    Spacer(modifier = modifier.height(15.dp))


                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = {
                            confirmPassword = it
                            confirmPasswordError = passwordsMatch(password,it)},
                        enabled = true,
                        readOnly = false,
                        label = { Text("Confirm Password", color = Color.DarkGray) },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = modifier.padding(5.dp),
                        isError = !confirmPasswordError,
                        shape = CircleShape,
                        colors = textFieldColors
                    )

                    Spacer(modifier = modifier.height(18.dp))

                    Button(
                        onClick = {
                            navController.navigate("login")
                        },
                        enabled = formValid,
                        modifier = modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .height(40.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF5B4DCC)
                        )
                    ) {
                        Text(
                            text = "Sign Up",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = modifier.height(12.dp))

                    Text(
                        text = "Already have an account?",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = modifier.height(4.dp))

                    Text(
                        text = "Login",
                        color = Color(0xFF5B4DCC),
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifier.clickable(onClick = {
                            navController.navigate("login")
                        })
                    )

                }
            }
        }
    }
}

@Preview
@Composable
fun RegisterPreview() {
    val navController = rememberNavController()

    SignUpScreen(navController = navController)
}