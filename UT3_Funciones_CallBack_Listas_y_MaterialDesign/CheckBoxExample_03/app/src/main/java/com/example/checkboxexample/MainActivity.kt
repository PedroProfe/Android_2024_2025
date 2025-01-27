package com.example.checkboxexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.checkboxexample.ui.theme.CheckBoxExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun CheckBoxExample() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Text(
            text = if (isChecked) "Checked" else "Unchecked",
            modifier = Modifier.padding(start = 8.dp)
        )


    }
}

@Composable
fun RadioButtonExample() {
    var selectedOption by remember { mutableStateOf("Option 1") }

    Column {
        Text("Select an option:")
        RadioButtonGroup(
            options = listOf("Option 1", "Option 2", "Option 3"),
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


@Composable
fun MainScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("RadioButton Example", style = MaterialTheme.typography.headlineSmall)
        RadioButtonExample()

        Spacer(modifier = Modifier.height(24.dp))

        Text("ListBox Example", style = MaterialTheme.typography.headlineSmall)
        //ListBoxExample()

        Spacer(modifier = Modifier.height(24.dp))

        Text("CheckBox Example", style = MaterialTheme.typography.headlineSmall)
        CheckBoxExample()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}