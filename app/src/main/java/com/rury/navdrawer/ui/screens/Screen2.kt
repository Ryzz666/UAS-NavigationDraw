package com.rury.navdrawer.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rury.navdrawer.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Analytics", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface)
            )
        },
        containerColor = Background
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = CardDefaults.cardColors(containerColor = Primary),
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.TrendingUp, contentDescription = null, tint = TextOnPrimary)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Overall Growth", color = TextOnPrimary, style = MaterialTheme.typography.titleMedium)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "+24.8%",
                            color = TextOnPrimary,
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Compared to last month",
                            color = TextOnPrimary.copy(alpha = 0.7f),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            item {
                Text("Performance Breakdown", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            }

            items(3) { index ->
                StatProgressBar(
                    label = when (index) {
                        0 -> "User Retention"
                        1 -> "Conversion Rate"
                        else -> "App Stability"
                    },
                    progress = when (index) {
                        0 -> 0.85f
                        1 -> 0.62f
                        else -> 0.98f
                    },
                    value = when (index) {
                        0 -> "85%"
                        1 -> "62%"
                        else -> "98%"
                    }
                )
            }
            
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(containerColor = Surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text("Chart Visualization Placeholder", color = TextSecondary)
                    }
                }
            }
        }
    }
}

@Composable
fun StatProgressBar(label: String, progress: Float, value: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = label, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
                Text(text = value, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold, color = Primary)
            }
            Spacer(modifier = Modifier.height(12.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = Primary,
                trackColor = SurfaceVariant,
                strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    NavDrawerAppTheme {
        Screen2(onBackClick = {})
    }
}
