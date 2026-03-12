package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.navigation.AppNavigation
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }
    }

    /*@Composable
    fun MainScreen() {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF5B4DCC)),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.9f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(24.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))

                        // Imagagen principal
                        Image(
                            painter = painterResource(id = R.drawable.fondo_pantalla),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(320.dp)
                        )

                        Spacer(modifier = Modifier.height(55.dp))

                        //Texto principal
                        Text(
                            text = "Hello",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Welcome To Little Drop, where\nyou manage you daily tasks",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        // Botón de Login y Sign Up (Box)
                        Box(
                            modifier = Modifier
                                .width(250.dp)
                                .height(50.dp)
                                .background(
                                    color = Color(0xFF5B4DCC),
                                    shape = RoundedCornerShape(50.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Login",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        Box(
                            modifier = Modifier
                                .width(250.dp)
                                .height(50.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFF5B4DCC),
                                    shape = RoundedCornerShape(50.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Sign Up",
                                color = Color(0xFF5B4DCC),
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(35.dp))

                        //Links para sign up
                        Text(
                            text = "Sign up using",
                            fontSize = 13.sp,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(13.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.facebook),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.google_plus),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.linked_in),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun SignUp() {

        val textFieldColors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFEBEBEB),
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color(0xFF5B4DCC),
            unfocusedBorderColor = Color(0xFFA59CE9),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF5B4DCC)),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.9f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(24.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(15.dp))

                        // Imagagen principal
                        Image(
                            painter = painterResource(id = R.drawable.fondo_pantalla),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        //Title
                        Text(
                            text = "Sign Up",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        var name by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            enabled = true,
                            readOnly = false,
                            label = { Text("Full name", color = Color.DarkGray) },
                            modifier = Modifier.padding(5.dp),
                            shape = CircleShape,
                            colors = textFieldColors
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        var email by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            enabled = true,
                            readOnly = false,
                            label = { Text("Email", color = Color.DarkGray) },
                            modifier = Modifier.padding(5.dp),
                            shape = CircleShape,
                            colors = textFieldColors
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        var phone by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            enabled = true,
                            readOnly = false,
                            label = { Text("Phone number", color = Color.DarkGray) },
                            modifier = Modifier.padding(5.dp),
                            shape = CircleShape,
                            colors = textFieldColors
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        var password by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            enabled = true,
                            readOnly = false,
                            label = { Text("Password", color = Color.DarkGray) },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            modifier = Modifier.padding(5.dp),
                            shape = CircleShape,
                            colors = textFieldColors
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        var confirmPassword by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            enabled = true,
                            readOnly = false,
                            label = { Text("Confirm Password", color = Color.DarkGray) },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            modifier = Modifier.padding(5.dp),
                            shape = CircleShape,
                            colors = textFieldColors
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(40.dp)
                                .background(
                                    color = Color(0xFF5B4DCC),
                                    shape = RoundedCornerShape(50.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Sign Up",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Already have an account?",
                            fontSize = 13.sp,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Login",
                            color = Color(0xFF5B4DCC),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun Login() {

        val textFieldColors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFEBEBEB),
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color(0xFF5B4DCC),
            unfocusedBorderColor = Color(0xFFA59CE9),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF5B4DCC)),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.9f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(24.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(30.dp))

                        // Imagagen principal
                        Image(
                            painter = painterResource(id = R.drawable.fondo_pantalla),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                        )

                        Spacer(modifier = Modifier.height(50.dp))

                        //Title
                        Text(
                            text = "Login",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(25.dp))

                        var email by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            enabled = true,
                            readOnly = false,
                            label = { Text("Email", color = Color.DarkGray) },
                            modifier = Modifier.padding(5.dp),
                            shape = CircleShape,
                            colors = textFieldColors
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        var password by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            enabled = true,
                            readOnly = false,
                            label = { Text("Password", color = Color.DarkGray) },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            modifier = Modifier.padding(5.dp),
                            shape = CircleShape,
                            colors = textFieldColors
                        )

                        Spacer(modifier = Modifier.height(35.dp))

                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(40.dp)
                                .background(
                                    color = Color(0xFF5B4DCC),
                                    shape = RoundedCornerShape(50.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Login",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Don't have an account?",
                            fontSize = 13.sp,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Sign up",
                            color = Color(0xFF5B4DCC),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }*/


}