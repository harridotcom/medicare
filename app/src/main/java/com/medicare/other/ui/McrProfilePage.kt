package com.medicare.other.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.medicare.R
import com.medicare.animations.SlideAnimations
import com.medicare.other.helper.NavDestinations
import com.medicare.other.helper.shareLink

@Composable
fun McrProfilePage(navController: NavController) {
    val context = LocalContext.current
    val linkToShare = "https://www.example.com"

    SlideAnimations.AnimatedScreen {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Circular Image
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(color = MaterialTheme.colorScheme.primary)
                    ) {
                        AsyncImage(
                            model = "https://www.example.com/profile-image", // Update this URL
                            contentDescription = "Profile Picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Profile Name Text
                    Text(
                        text = "Shreekant Pukale",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                // Menu Items
                Text(
                    text = "My Care",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(25.dp))

                ProfileMenuItem(
                    icon = Icons.Default.Share,
                    text = "Share",
                    onClick = {
                        shareLink(context, linkToShare)
                    }
                )

                ProfileMenuItem(
                    icon = Icons.Default.Settings,
                    text = "Settings",
                    onClick = {
                        navController.navigate(NavDestinations.GENERATE_PLAN)
                    }
                )

                ProfileMenuItem(
                    icon = Icons.Default.Home,
                    text = "Saved Diet Plan",
                    onClick = {
                        navController.navigate(NavDestinations.SAVED_PLAN)
                    }
                )

                ProfileMenuItem(
                    icon = Icons.Default.Favorite,
                    text = "Saved Workout Plan",
                    onClick = {
                        navController.navigate(NavDestinations.SAVED_PLAN)
                    }
                )
            }
        }
    }

}

@Composable
fun ProfileMenuItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick) // Handle click event
            .background(colorResource(R.color.lighter_gray), shape = RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 16.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
