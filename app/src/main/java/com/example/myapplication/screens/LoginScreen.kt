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
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


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

                    Spacer(modifier = modifier.height(30.dp))

                    // Imagagen principal
                    Image(
                        painter = painterResource(id = R.drawable.fondo_pantalla),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Spacer(modifier = modifier.height(50.dp))

                    //Title
                    Text(
                        text = "Login",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = modifier.height(25.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        enabled = true,
                        readOnly = false,
                        label = { Text("Email", color = Color.DarkGray) },
                        modifier = modifier.padding(5.dp),
                        shape = CircleShape,
                        colors = textFieldColors
                    )

                    Spacer(modifier = modifier.height(20.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        enabled = true,
                        readOnly = false,
                        label = { Text("Password", color = Color.DarkGray) },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = modifier.padding(5.dp),
                        shape = CircleShape,
                        colors = textFieldColors
                    )

                    Spacer(modifier = modifier.height(35.dp))

                    Button(
                        onClick = {
                            navController.navigate("main")
                        },
                        enabled = (password.isNotEmpty() && email.isNotEmpty()),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF5B4DCC)
                        )
                    ) {
                        Text(
                            text = "Login",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = modifier.height(15.dp))

                    Text(
                        text = "Don't have an account?",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = modifier.height(4.dp))

                    Text(
                        text = "Sign up",
                        color = Color(0xFF5B4DCC),
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifier.clickable(onClick = {
                            navController.navigate("signUp")
                        })
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()

    LoginScreen(navController = navController)
}