package com.rury.navdrawer.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rury.navdrawer.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1(
    onBackClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableIntStateOf(0) }
    val categories = listOf("All", "Apps", "Themes", "Services", "Updates")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Explore", fontWeight = FontWeight.Bold) },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search possibilities...") },
                leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = null) },
                shape = MaterialTheme.shapes.extraLarge,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Surface,
                    unfocusedContainerColor = Surface,
                    focusedBorderColor = Primary
                )
            )

            ScrollableTabRow(
                selectedTabIndex = selectedCategory,
                edgePadding = 16.dp,
                containerColor = Background,
                contentColor = Primary,
                divider = {},
                indicator = {}
            ) {
                categories.forEachIndexed { index, category ->
                    FilterChip(
                        selected = selectedCategory == index,
                        onClick = { selectedCategory = index },
                        label = { Text(category) },
                        modifier = Modifier.padding(horizontal = 4.dp),
                        shape = MaterialTheme.shapes.medium
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(10) { index ->
                    ExploreCard(
                        title = "Feature #$index",
                        category = categories[(index % 4) + 1]
                    )
                }
            }
        }
    }
}

@Composable
fun ExploreCard(title: String, category: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = Surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                shape = MaterialTheme.shapes.medium,
                color = SurfaceVariant
            ) {
                Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
                    Text("Preview", color = TextSecondary)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = category, style = MaterialTheme.typography.bodySmall, color = TextSecondary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen1Preview() {
    NavDrawerAppTheme {
        Screen1(onBackClick = {})
    }
}
