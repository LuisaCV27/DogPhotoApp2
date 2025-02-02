package com.mexiti.catphotoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mexiti.catphotoapp.R
import com.mexiti.catphotoapp.ui.screens.HomeScreen
import com.mexiti.catphotoapp.viewmodel.DogViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { DogTopBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()) {
            val dogViewModel:DogViewModel = viewModel()
            HomeScreen(dogUiState = dogViewModel.dogUiState, contentPadding = it)
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogTopBar(scrollBehavior: TopAppBarScrollBehavior,modifier:Modifier = Modifier){
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id =R.drawable.perro),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(25.dp)
                        .size(60.dp)
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.Black
                )
            }
        }
    )
}