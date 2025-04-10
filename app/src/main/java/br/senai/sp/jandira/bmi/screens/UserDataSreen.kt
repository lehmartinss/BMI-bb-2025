package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserdataScreen (navController: NavController?){

    var ageState = remember {
        mutableStateOf("")
    }

    var weightState = remember {
       mutableStateOf("")
    }

    var heightState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    var errorMessageState = remember {
        mutableStateOf("")
    }

    //Abrir o arquivi usuario.xml para recuperar o nome que o usuario digitou na tela anterior
    val context = LocalContext.current
    val sharedUserFile = context
        .getSharedPreferences("usuario", Context.MODE_PRIVATE)
    val userName = sharedUserFile.getString( "user_name", "Name  out found! ")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF88BFEF),
                        Color(0xFF5286BB)
                    )
                )
            ),
                contentAlignment =  Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = stringResource(R.string.hi) + " $userName!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xF5050404),
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(1f),

                )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(730.dp),
            shape = RoundedCornerShape(
                topStart = 30.dp,
                topEnd = 30.dp
            ),
            colors = CardDefaults.cardColors(
                contentColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier = Modifier
                                .size(110.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 4.dp,
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFF88BFEF),
                                        Color(0xFFCE75DC)
                                    )
                                )
                            ),
                            elevation = CardDefaults
                                .cardElevation(2.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.homem),
                                contentDescription = ""
                            )
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 8.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color( 0xFF5286BB)
                                    )
                        ) {
                            Text(
                                text = stringResource(R.string.male),
                                color = Color(0xF5050404)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .height(200.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier = Modifier
                                .size(110.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 4.dp,
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFF88BFEF),
                                        Color(0xFFCE75DC)
                                    )
                                )
                            ),
                            elevation = CardDefaults
                                .cardElevation(2.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.mulher),
                                contentDescription = ""
                            )
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFCE75DC)
                            )
                        ) {
                            Text(
                                text = stringResource(R.string.female),
                                color = Color(0xF5050404)

                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ){
                    OutlinedTextField(
                        value = ageState.value,
                        onValueChange = {
                            ageState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(R.string.age)

                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Numbers,
                                contentDescription = "",
                                tint = Color(0xFF5286BB)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        )
                    )
                    OutlinedTextField(
                        value = weightState.value,
                        onValueChange = {
                            weightState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(R.string.weight)

                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Balance,
                                contentDescription = "",
                                tint = Color(0xFF5286BB)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        )
                    )
                    OutlinedTextField(
                        value = heightState.value,
                        onValueChange = {
                            heightState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(R.string.height)

                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Height,
                                contentDescription = "",
                                tint = Color(0xFF5286BB)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        isError =  isErrorState.value,
                        supportingText = {
                        Text(
                            text = errorMessageState.value,
                            color = Color.Red
                        )
                    }
                    )
                }
                Button(
                    onClick = {
                        if (heightState.value.length < 3){
                            isErrorState.value = true
                            errorMessageState.value = context.getString(R.string.support_height)
                        }

                        // Criar uma vareavel para editar o arquivo que acabamos de criar ou abrir
                        val editor = sharedUserFile.edit()
                        editor.putInt("user_age", ageState.value.trim().toInt())
                        editor.putInt("user_weight", weightState.value.trim().toInt())
                        editor.putInt("user_height", heightState.value.trim().toInt())
                        editor.apply()

                        navController?.navigate("result_screen")
                    },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF88BFEF)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.calculate),
                        color = Color.Black
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserdataScreen(null)
}