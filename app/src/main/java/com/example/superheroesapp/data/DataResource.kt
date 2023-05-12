package com.example.superheroesapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesApp() {
    Scaffold(
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                SuperHeroCard(
                    hero = it,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun SuperHeroCard(hero: Hero,
                  modifier: Modifier = Modifier) {
    Card(
        elevation = 2.dp, backgroundColor = Color.Cyan,
        modifier = Modifier
            .padding(16.dp)
            .clip(MaterialTheme.shapes.medium)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)
            ) {
            Column (modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(hero.nameRes),
                    style = MaterialTheme.typography.headlineLarge)
                Text(
                    stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small),
                painter = painterResource(hero.imageRes),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun HeroAppPreview() {
    SuperHeroesAppTheme(darkTheme = false) {
        HeroesApp()
    }
}

@Preview
@Composable
fun HeroAppPreviewDark() {
    SuperHeroesAppTheme(darkTheme = true) {
        HeroesApp()
    }
}