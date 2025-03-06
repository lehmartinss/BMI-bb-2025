package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun TelaInicial(modifier: Modifier = Modifier) {

    var nomeState = remember {
        mutableStateOf(value = "")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                listOf(
                    Color(0xFFEFB4B4),
                    Color(0xFF8D2F2F)
                )
            )
            ),
        contentAlignment =  Alignment.BottomCenter
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
               painterResource(id = R.drawable.bmi),
                contentDescription = stringResource(
                    R.string.logo_description),
                modifier = Modifier
                    .padding(top = 55.dp)
            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 32.sp,
                color = Color(0xFF3C0D34)
            )
            Card (modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                ),
            ){
            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
            ){
                Column {
                    Text(
                        text = stringResource(R.string.your_name),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    OutlinedTextField(
                        value = nomeState.value,
                        onValueChange = {it ->
                            nomeState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        shape = RoundedCornerShape(12.dp),
                        label = {
                            Text(text = stringResource(R.string.your_name_here))
                                },
                        trailingIcon =  {
                            Icon(
                                imageVector = Icons.Default.AssignmentInd,
                                contentDescription = "",
                                tint = Color(0xFFEFB4B4)
                            )
                        } ,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "",
                                tint = Color(0xFF8D2F2F)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Sentences
                        )
                    )
                }

                Button(onClick = {},
                    ) {
                    Text(
                        text = stringResource((R.string.next))
                    )
                    Icon(imageVector = Icons.Filled.ArrowForward,
                        contentDescription = ""
                    )
                }
            }
            }
        }
    }
}
   

@Preview(showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    TelaInicial()
}