package com.example.visprog_week4.ui.theme.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.visprog_week4.ui.theme.model.GameDataSource
import com.example.visprog_week4.ui.theme.model.GameModel

@Composable
fun GameCardView(gameModel: GameModel, modifier: Modifier = Modifier) {

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun GameCardPreview() {
    GameCardView(gameModel = GameDataSource.games[0])
}