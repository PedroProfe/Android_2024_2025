package com.example.funcioncallbackkotlin_00

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funcioncallbackkotlin_00.ui.theme.FuncionCallBackKotlin_00Theme

/*
* Una función callback en Kotlin (y en programación en general) es una función que se
* pasa como argumento a otra función, para que esta última pueda ejecutarla en un
* momento posterior, generalmente en respuesta a un evento o condición.
* */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun OptionSelector(options: List<String>, onOptionSelected: (String) -> Unit) {
    Column {
        options.forEach { option ->
            Button(onClick = { onOptionSelected(option) }) {
                Text(text = option)
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Estado para almacenar la opción seleccionada
    var selectedOption by remember { mutableStateOf("No hay opción seleccionada") }

    Column {
        // Componente para seleccionar opciones
        OptionSelector(
            options = listOf("Option 1", "Option 2", "Option 3"),
            onOptionSelected = { option ->
                selectedOption = option // Actualiza el estado con la opción seleccionada
            }
        )
        // Mostrar la opción seleccionada
        Text(
            text = "Selected: $selectedOption",
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}


@Preview(showBackground = true)
@Composable
fun OptionSelectorPreview() {
    MainScreen()
}