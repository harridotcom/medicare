package com.medicare.other

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.medicare.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun McrNavigationBars(modifier: Modifier = Modifier) {

    val items = listOf(
        NavigationBarItem.Home,
        NavigationBarItem.PhysicalHealth,
        NavigationBarItem.WomenHealth,
        NavigationBarItem.MentalHealth
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.label)}
            )
        }
    }
}



sealed class NavigationBarItem(val label: String,val icon: Int){
    object Home: NavigationBarItem("Home", R.drawable.home)
    object MentalHealth: NavigationBarItem("Mind", R.drawable.brain)
    object PhysicalHealth: NavigationBarItem("Body", R.drawable.weight)
    object WomenHealth: NavigationBarItem("Women",R.drawable.women )
}

