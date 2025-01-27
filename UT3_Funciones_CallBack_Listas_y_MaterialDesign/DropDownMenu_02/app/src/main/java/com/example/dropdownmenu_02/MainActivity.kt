package com.example.dropdownmenu_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dropdownmenu_02.ui.theme.DropDownMenu_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ListBoxExample()
        }
    }
}

@Composable
fun ListBoxExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select an option") }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Box(
        Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = selectedOption,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .padding(16.dp)
                .border(1.dp, Color.Gray)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }

        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption = option
                        expanded = false
                    },
                    text = { Text(text = option) } // Cambia a la API de Material 3
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListBoxExamplePreview() {
    ListBoxExample()
}