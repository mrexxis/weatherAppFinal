package com.mr.weatherappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.mr.weatherappfinal.ui.theme.WeatherAppFinalTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/*@Preview(showBackground = true)
*@Composable
*fun GreetingPreview() {
*    WeatherAppFinalTheme {
*        Greeting("Android")
*    }
*}
*/

//@Preview(showBackground = true, heightDp = 50, widthDp = 380)
@Composable
fun Cabecalho(): Unit {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(12.dp, 8.dp)
            .fillMaxWidth()

    ){

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            contentPadding = PaddingValues(),
            modifier = Modifier.size(35.dp)
            ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = R.string.Menu_search.toString(),
                //contentScale = ContentScale.FillBounds
                modifier = Modifier.size(20.dp)
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            modifier = Modifier
                .clip(CircleShape)
                .size(35.dp)
            ) {

            Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = R.string.Menu_foto.toString())


            }
    }
}

//@Preview (showBackground = true, widthDp = 380)
@Composable
fun DataNome(name: String="Mário"): Unit {
    Column (
        modifier = Modifier.fillMaxWidth()
    ){

        Row (
            modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Olá",
                modifier = Modifier.padding(end = 2.dp),
                fontSize = TextUnit(25f, TextUnitType.Sp),
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "$name",
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(25f, TextUnitType.Sp),
                color = MaterialTheme.colorScheme.primary
            )
        }


        Text(
            text = formatData(Calendar.getInstance().time),
            fontWeight = FontWeight.Light,
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = MaterialTheme.colorScheme.secondary

        )
        Text(
            text = "Vila Franca de Xira",
            fontWeight = FontWeight.Light,
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = MaterialTheme.colorScheme.secondary
        )


    }
}

@Composable
fun formatData(data: Date): String {
    val format = SimpleDateFormat("dd MMMM, EEEE yyyy", Locale("pt", "PT"))
    return format.format(data)
}
@Preview(showBackground = true, heightDp = 600, widthDp = 380)
@Composable
fun Page(): Unit {
        Image(
            painter = painterResource(R.drawable._86449326_37c2256216_b),
            contentDescription = null,
            alpha = 0.2F,
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Cabecalho()
            DataNome()
            ImagemCentral()
            ProximosSeteDias()
        }

}

var informacaoSeteDias = listOf (
        temperaturaDia(
            temperatura = 25,
            estado = "limpo",
            resource = R.drawable.sun
        ),
        temperaturaDia(
            temperatura = 22,
            estado = "nublado",
            resource = R.drawable.cloudy
        ),
        temperaturaDia(
            temperatura = 18,
            estado = "chuvoso",
            resource = R.drawable.rainy
        ),
        temperaturaDia(
            temperatura = 20,
            estado = "tempestade",
            resource = R.drawable.storm
        ),
        temperaturaDia(
            temperatura = 12,
            estado = "chuvoso",
            resource = R.drawable.rainy
        ),
        temperaturaDia(
            temperatura = 8,
            estado = "chuvoso",
            resource = R.drawable.rainy
        ),
        temperaturaDia(
            temperatura = 4,
            estado = "neve",
            resource = R.drawable.snowy
        )
    )

@Preview(showBackground = true, heightDp = 350, widthDp = 380)
@Composable
fun ProximosSeteDias(): Unit {

    LazyRow(){
        items(informacaoSeteDias) {
            proximoDia(it)
        }
    }

}
@Composable
fun proximoDia (temperaturaDia: temperaturaDia): Unit {

    Column (
        modifier = Modifier
            .width(100.dp)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(painter = painterResource(id = temperaturaDia.resource), contentDescription = temperaturaDia.estado)
        Text(text = temperaturaDia.temperatura.toString())
        Text(text = temperaturaDia.estado,
            fontSize = TextUnit(13f, TextUnitType.Sp)
        )
    }
}
//@Preview(showBackground = true, heightDp = 350, widthDp = 380)
@Composable
fun ImagemCentral(): Unit {
    Box(
        modifier = Modifier
            .height(300.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
        ){

        Box {
            Box (
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(280.dp)
            ){


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                contentAlignment = Alignment.TopCenter
            ){
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "sol")
            }

            Row (
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 170.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "12º",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(55f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Parcialmente nublado",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(10f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.tertiary
                )
                }
//fim da aula de 2 de novembro
            }


        }
    }


}