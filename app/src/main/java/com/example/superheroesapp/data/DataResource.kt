package com.example.superheroesapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.ui.res.colorResource
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
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

// I could not make that images ant text where aligned.
@Composable
fun SuperHeroCard(modifier: Modifier = Modifier, hero: Hero) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clip(MaterialTheme.shapes.medium),
        elevation = 2.dp, backgroundColor = Color.Cyan
    ) {
        Row(modifier = Modifier
            .padding(16.dp)
            .sizeIn(72.dp)
            .fillMaxWidth()
            ) {
            HeroText(
                name = hero.nameRes,
                description = hero.descriptionRes,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.padding(8.dp))
            HeroImage(image = hero.imageRes)
        }
    }
}

//This area make the Text resources that will bring the information from the list
@Composable
fun HeroText(@StringRes name: Int, @StringRes description: Int, modifier: Modifier = Modifier) {
    Column (modifier = Modifier) {
        Text(
            stringResource(id = name),
            style = MaterialTheme.typography.headlineLarge)
        Text(
            stringResource(id = description),
            style = MaterialTheme.typography.bodySmall)
    }
}

//This area make the Image resource that will bring the information from the list
@Composable
fun HeroImage(@DrawableRes image: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .size(40.dp),
        painter = painterResource(id = image),
        contentDescription = null
    )
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