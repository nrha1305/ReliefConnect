package com.reliefconnect.app.ui.request

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.reliefconnect.app.navigation.Routes
import androidx.compose.foundation.clickable
import com.reliefconnect.app.ui.components.AppTopBar


@Composable
fun RequestListScreen(navController: NavController) {

    val requests = listOf(
        "Food Supplies - Flood Area",
        "Medicine for Children",
        "Blankets & Clothes",
        "Clean Water",
        "Emergency Shelter"
    )
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Aid Requests"
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(requests) { item ->
                RequestCard(
                    title = item,
                    onClick = {
                        navController.navigate(
                            Routes.requestDetail(item)
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun RequestCard(
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Tap to see details",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}
