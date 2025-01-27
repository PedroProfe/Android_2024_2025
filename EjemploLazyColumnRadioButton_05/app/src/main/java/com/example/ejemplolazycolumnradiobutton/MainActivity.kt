package com.example.ejemplolazycolumnradiobutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import com.example.ejemplolazycolumnradiobutton.ui.theme.EjemploLazyColumnRadioButtonTheme


// Modelo de datos
data class Producto(val nombre: String, val categoria: String, val precio: Double)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    // Lista de productos de ejemplo
    val productos = listOf(
        Producto("Manzana", "Frutas", 1.5),
        Producto("Pan", "Panadería", 2.0),
        Producto("Leche", "Lácteos", 1.2),
        Producto("Queso", "Lácteos", 3.5),
        Producto("Plátano", "Frutas", 1.3),
        Producto("Carne", "Carnicería", 5.0),
        Producto("Pescado", "Pescadería", 4.0)
    )

    var filtroSeleccionado by remember { mutableStateOf("Todos") }
    var productoSeleccionado by remember { mutableStateOf<Producto?>(null) }

    // Aplicar filtro según la categoría seleccionada
    val productosFiltrados = when (filtroSeleccionado) {
        "Frutas" -> productos.filter { it.categoria == "Frutas" }
        "Lácteos" -> productos.filter { it.categoria == "Lácteos" }
        else -> productos
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Sección de filtro con RadioButtons
        Text("Filtrar por categoría:", fontWeight = FontWeight.Bold)
        Row {
            RadioButtonGroup(
                opciones = listOf("Todos", "Frutas", "Lácteos"),
                seleccionado = filtroSeleccionado,
                onSeleccionar = { filtroSeleccionado = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de productos
        LazyColumn {
            items(productosFiltrados) { producto ->
                ProductoItem(producto = producto) {
                    productoSeleccionado = producto
                }
            }
        }

        // Detalle del producto seleccionado
        productoSeleccionado?.let {
            Spacer(modifier = Modifier.height(16.dp))
            DetalleProducto(producto = it)
        }
    }
}

@Composable
fun RadioButtonGroup(opciones: List<String>, seleccionado: String, onSeleccionar: (String) -> Unit) {
    opciones.forEach { opcion ->
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = opcion == seleccionado,
                onClick = { onSeleccionar(opcion) }
            )
            Text(opcion, modifier = Modifier.clickable { onSeleccionar(opcion) })
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
fun ProductoItem(producto: Producto, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(producto.nombre)
        Text("${producto.precio} €")
    }
}

@Composable
fun DetalleProducto(producto: Producto) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp) // Elevación en Material 3
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Detalles del Producto", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Nombre: ${producto.nombre}")
            Text("Categoría: ${producto.categoria}")
            Text("Precio: ${producto.precio} €")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppContentPreview() {

    AppContent()

}