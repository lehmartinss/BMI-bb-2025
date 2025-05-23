package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculator
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.isFilled
import br.senai.sp.jandira.bmi.utils.numberFormat
import java.util.Locale

@Composable

fun BMIResultScreen (navController: NavController?){

    val context = LocalContext.current

    val sharedUserFile = context
        .getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val age = sharedUserFile.getInt("user_age", 0)
    val height = sharedUserFile.getInt("user_height", 0).toDouble()
    val weight = sharedUserFile.getInt("user_weight", 0)

    val bmiResult = bmiCalculator(weight, height)

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
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = stringResource(R.string.your_BMI),
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
                    .padding(25.dp),
                verticalArrangement = Arrangement.SpaceBetween
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
                                color = bmiResult.color
                            ),
                            elevation = CardDefaults
                                .cardElevation(2.dp)
                        ) {
                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Text(
                                text = String.format(
                                    Locale.getDefault(),
                                    format = "%.1f",
                                bmiResult.bmi.second),
                                color = Color(0xF5050404),
                                    fontSize = 35.sp,
                                    fontWeight = FontWeight.Bold,

                                )
                            }
                        }
                        Column (
                            modifier = Modifier
                                .padding(20.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = bmiResult.bmi.first,
                                fontSize = 20.sp,
                                color = Color(0xF5050404)
                            )
                            Card(
                                modifier = Modifier
                                    .height(95.dp)
                                    .width(350.dp)
                                    .padding(20.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor =  Color(0xFF5286BB)
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(5.dp)
                                ){
                                    Column (
                                        modifier = Modifier
                                            .weight(1f) ,
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        Text(
                                            text = stringResource(R.string.age),
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                         )
                                        Text(
                                            text = age.toString(),
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                        )
                                    }
                                    VerticalDivider()
                                    Column(
                                        modifier = Modifier
                                            .weight(1f),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally

                                    ) {
                                        Text(
                                            text = stringResource(R.string.weight),
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                        )
                                        Text(
                                            text = weight.toString() + " Kg",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                        )
                                    }
                                    VerticalDivider()
                                   Column (
                                       modifier = Modifier
                                           .weight(1f),
                                       verticalArrangement = Arrangement.Center,
                                       horizontalAlignment = Alignment.CenterHorizontally
                                   ){
                                       Text(
                                           text = stringResource(R.string.high),
                                           fontSize = 15.sp,
                                           fontWeight = FontWeight.Bold,
                                       )
                                       Text(
                                           text = String.format(
                                               Locale.getDefault(),
                                               "%.2f",
                                               height.div(100)
                                           ),
                                           fontSize = 13.sp,
                                           fontWeight = FontWeight.Bold,
                                       )
                                   }
                                }
                            }
                            // Mostrar o resultado do IMC
                           BmiLevel(
                               markColor = colorResource(R.color.light_blue),
                               text1 = stringResource(R.string.underweight),
                               text2 = "< ${numberFormat(18.5)}",
                               isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.UNDERWEIGHT)
                           )
                           BmiLevel(
                               markColor = colorResource(R.color.light_green),
                               text1 = stringResource(R.string.normal),
                               text2 = "< ${numberFormat(18.6)} - ${numberFormat(24.9)} ",
                               isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.NORMAL)
                           )
                           BmiLevel(
                               markColor = colorResource(R.color.yellow),
                               text1 = stringResource(R.string.overweight),
                               text2 = "< ${numberFormat(25.0)} - ${numberFormat(29.9)} ",
                               isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OVERWEIGHT)
                           )
                           BmiLevel(
                               markColor = colorResource(R.color.light_orange),
                               text1 = stringResource(R.string.obesity1),
                               text2 = "< ${numberFormat(30.0)} - ${numberFormat(34.9)} ",
                               isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY1)
                           )
                           BmiLevel(
                               markColor = colorResource(R.color.dark_orange),
                               text1 = stringResource(R.string.obesity2),
                               text2 = "< ${numberFormat(35.0)} - ${numberFormat(39.9)} ",
                               isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY2)
                           )
                           BmiLevel(
                               markColor = colorResource(R.color.red),
                               text1 = stringResource(R.string.obesity3),
                               text2 = "> ${numberFormat(39.9)}",
                               isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY3)
                           )

                            HorizontalDivider(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                            )
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF88BFEF)
                                )
                            ) {
                                Text(
                                    text = stringResource(R.string.new_calc),
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}