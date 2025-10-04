package com.example.visprog_week4.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visprog_week4.ui.theme.model.ActivityModel
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.googlefonts.FontFamily
import androidx.compose.ui.unit.sp
import com.example.visprog_week4.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val Poppins = FontFamily(
    Font(googleFont = GoogleFont("Poppins"), fontProvider = provider)
)

@Composable
fun ActivityCardView(
    title: String,
    activities: List<ActivityModel>,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = title,
            fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins_semibold)),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 20.dp)
        ) {
            items(activities) { activity ->
                ActivityCardItem(activity = activity)
            }
        }
    }
}

@Composable
fun ActivityCardItem(activity: ActivityModel) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        color = Color(0xFFE8E8E8),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = activity.imageRes),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(130.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Text(
                text = activity.name,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins_semibold)),
                fontSize = 20.sp,
                textAlign = TextAlign.Left
//                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                "${activity.type} • ${activity.duration}",
                fontFamily = FontFamily(androidx.compose.ui.text.font.Font(R.font.poppins)),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFF9CA3AF),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityCardPreview() {
    ActivityCardView(
        title = "Recommended For You",
        activities = listOf(
            ActivityModel(
                name = "Happiness",
                type = "MEDITATION",
                duration = "3-10 MIN",
                imageRes = R.drawable.being_happy_1
            ),
            ActivityModel(
                name = "Focus",
                type = "MEDITATION",
                duration = "3-10 MIN",
                imageRes = R.drawable.meditation_1
            ),
            ActivityModel(
                name = "Happiness",
                type = "MEDITATION",
                duration = "3-10 MIN",
                imageRes = R.drawable.being_happy_1
            ),
            ActivityModel(
                name = "Focus",
                type = "MEDITATION",
                duration = "3-10 MIN",
                imageRes = R.drawable.meditation_1
            )
        )
    )
}