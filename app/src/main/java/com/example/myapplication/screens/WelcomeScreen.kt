package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.layout.ContentScale

@Composable
fun WelcomeScreen(navController: NavController, modifier: Modifier = Modifier) {

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

                    Spacer(modifier = modifier.height(20.dp))

                    // Imagagen principal
                    Image(
                        painter = painterResource(id = R.drawable.fondo_pantalla),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp)
                    )

                    Spacer(modifier = modifier.height(55.dp))

                    //Texto principal
                    Text(
                        text = "Hello",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = modifier.height(6.dp))

                    Text(
                        text = "Welcome To Little Drop, where\nyou manage you daily tasks",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = modifier.height(30.dp))

                    Button(
                        onClick = {
                            navController.navigate("login")
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp),
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

                    Spacer(modifier = modifier.height(18.dp))

                    Button(
                        onClick = {
                            navController.navigate("signUp")
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                1.5.dp,
                                Color(0xFF3F3D9E),
                                RoundedCornerShape(30.dp)
                            ),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Sign Up",
                            color = Color(0xFF343571),
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = modifier.height(35.dp))

                    //Links para sign up
                    Text(
                        text = "Sign up using",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = modifier.height(13.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = null,
                            modifier = modifier.size(30.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.google_plus),
                            contentDescription = null,
                            modifier = modifier.size(30.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.linked_in),
                            contentDescription = null,
                            modifier = modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController()

    WelcomeScreen(navController = navController)
}