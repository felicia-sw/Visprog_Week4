package com.example.visprog_week4.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Nightlight
import androidx.compose.material.icons.outlined.SelfImprovement
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_week4.R
import com.example.visprog_week4.ui.theme.model.ActivityModel
import kotlin.reflect.KProperty

@Composable
fun Soal2View() {
    var selectedTab by remember { mutableStateOf(0) }
    val type = listOf(
        "All",
        "Favorites",
        "Anxious",
        "Sleep",
        "Music"
    )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
//        verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color(0xFFF5F5F5))
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 80.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(40.dp))
            }
            item {
                Column(
                    verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//            horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Good Morning, Jennie!",
                        fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins_semibold)),
                        fontSize = 28.sp
                    )
                    Text(
                        text = "We wish you have a good day",
                        fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins_thin)),
                        fontSize = 20.sp
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
//            contentPadding = PaddingValues(horizontal = 10.dp)
                ) {
                    itemsIndexed(type) { index, item ->
                        CategoryPart(
                            text = item,
                            selected = selectedTab == index,
                            onCLick = { selectedTab = index }
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {

                val basicActivity = ActivityModel(
                    imageRes = R.drawable.heart_face,
                    name = "Basics",
                    type = "COURSE",
                    duration = "3-10 MIN"
                )
                val relaxationActivity = ActivityModel(
                    imageRes = R.drawable.reading_a_book,
                    name = "Relaxation",
                    type = "MUSIC",
                    duration = "3-10 MIN"

                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TwoChoice(
                        activities = basicActivity,
                        backgroundColor = Color(0xFF2D9B8F),
                        modifier = Modifier.weight(1f)
                    )
                    TwoChoice(
                        activities = relaxationActivity,
                        backgroundColor = Color(0xFF8B7AB8),
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .height(90.dp)
                        .width(400.dp)
                        .background(Color.DarkGray, RoundedCornerShape(10.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .padding(22.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                "Daily Thought",
                                color = Color.White,
                                fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins_semibold)),
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                "MEDITATION 3-10 MIN",
                                color = Color.White.copy(alpha = 0.8f),
                                fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins)),
//                            fontWeight = FontWeight.Bold,
                                fontSize = 10.sp
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color.White, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Play",
                                tint = Color.DarkGray,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
//        item {
//            Spacer(modifier = Modifier.height(20.dp))
//        }
            item {
                ActivityCardPreview()
            }
        }
        BottonNavBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BottonNavBar(modifier: Modifier = Modifier) {
    var selectedNavItem by remember { mutableStateOf(0) }
    Box(
        modifier = modifier
            .fillMaxWidth()
//            .height(70.dp)
            .background(Color.White)
            .padding(horizontal = 40.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BotomNavItem(
                icon = Icons.Filled.Home,
                label = "Home",
                selected = selectedNavItem == 0,
                onCLick = { selectedNavItem = 0 }
            )
            BotomNavItem(
                icon = Icons.Outlined.Nightlight,
                label = "Sleep",
                selected = selectedNavItem == 1,
                onCLick = { selectedNavItem = 1 }
            )
            BotomNavItem(
                icon = Icons.Outlined.SelfImprovement,
                label = "Meditate",
                selected = selectedNavItem == 2,
                onCLick = { selectedNavItem = 2 }
            )
            BotomNavItem(
                icon = Icons.Outlined.MusicNote,
                label = "Music",
                selected = selectedNavItem == 3,
                onCLick = { selectedNavItem = 3 }
            )
        }
    }
}

@Composable
fun BotomNavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onCLick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onCLick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (selected) Color(0xFF3498DB).copy(alpha = 0.2f) else Color.Transparent,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) Color(0xFF3498DB) else Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins)),
            fontSize = 10.sp,
            color = if (selected) Color(0xFF3498DB) else Color.Gray
        )
    }
}


@Composable
fun CategoryPart(
    text: String,
    selected: Boolean,
    onCLick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onCLick() }
            .background(
                color = if (selected) Color(0xFF3498DB) else Color(0xFFE8E8E8),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 20.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins)),
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
//            color = if (selected) Color.
            color = if (selected) Color.White else Color.DarkGray,
            fontSize = 14.sp
        )
    }
}

@Composable
fun TwoChoice(
    activities: ActivityModel,
    backgroundColor: Color = Color(0xFF3D4E5C),
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
//            .width(180.dp)
            .height(240.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(activities.imageRes),
                    contentDescription = "Activity Image",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Column {
                Text(
                    text = activities.name,
                    fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins_semibold)),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = activities.type,
                    fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins)),
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 12.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = activities.duration,
                    fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins)),
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 12.sp
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.White.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Text(
                        "START",
                        fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins_semibold)),
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2Preview() {
    Soal2View()
}