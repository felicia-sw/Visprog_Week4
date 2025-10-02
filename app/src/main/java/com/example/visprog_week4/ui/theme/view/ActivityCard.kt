package com.example.visprog_week4.ui.theme.view


import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ActivityCardView(activity: Activity, modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier.fillMaxSize()
    ){

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ActivityCardPreview() {
    ActivityCardView()
}