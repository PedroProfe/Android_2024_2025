package com.example.radiobuttongroupcompose2025_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.radiobuttongroupcompose2025_01.ui.theme.RadioButtonGroupCompose2025_01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            RadioButtonEjemplo()
        }

    }
}

@Composable
fun RadioButtonEjemplo() {
    var selectedOption by remember { mutableStateOf("Carne") }

    Column {
        Text("Elije un plato favorito:")
        RadioButtonGroup(
            options = listOf("Carne", "Verdura", "Pescado"),
            selectedOption = selectedOption,
            onOptionSelected = { selectedOption = it }
        )
        Text("Selected: $selectedOption")
    }
}

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { onOptionSelected(option) }
                )
                Text(option)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonEjemploPreview() {
   RadioButtonEjemplo()
}