package io.sensify.sensor.ui.labs.pages.sensordetails.detailpagewidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.sensify.sensor.R
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.themes.JlThemeM3
import io.sensify.sensor.ui.resource.values.JlResDimens

/**
 * Created by Manish Kumar on 15/08/22.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, backgroundColor = 0xFF00230e)
@Composable
fun DetailMain(navController: NavController? = null){

//    Column(modifier = Modifier.fillMaxSize().background(JLThemeBase.colorPrimary10)) {

     val backgroundColor: Color = JLThemeBase.colorPrimary10
        Scaffold(
            topBar  = {
                TopAppBar(
                    modifier = Modifier.padding(top = JlResDimens.dp16),
                    title = {
                            Text(
                                text = "Brightness",
                                color = JlThemeM3.md_theme_dark_onSurface,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = JlResDimens.dp48)
                            )
                        },

                    navigationIcon = {
                        IconButton(
                            onClick = { navController?.navigateUp() },
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Image(
                                painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
                                contentDescription = "slide to left",
                                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
                                alignment = Alignment.Center,
                            )
                        }
                    },
                    backgroundColor = backgroundColor,
                )
            },
            containerColor = backgroundColor,

            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(50),
                    backgroundColor = Color.Transparent,
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    JLThemeBase.colorPrimary30,
                                    JLThemeBase.colorPrimary20,
                                )
                            ),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    elevation = FloatingActionButtonDefaults.elevation(0.dp)

                ) {

                    IconButton(
                        onClick = { navController?.navigateUp() },
                        modifier = Modifier
                    ) {
                        Image(
                            painterResource(id = R.drawable.ic_round_settings_24),
                            contentDescription = "slide to left",
                            colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
                            alignment = Alignment.Center,
                        )
                    }

                }
            }



        ){ innerPadding ->
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = JlResDimens.dp48 + innerPadding.calculateTopPadding())

            ) {

                // Header
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = JlResDimens.dp36, end = JlResDimens.dp36)
                    ) {
                        HeaderButton()
                    }
                }


                //Visual
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(
                                start = JlResDimens.dp32,
                                top = JlResDimens.dp32,
                                end = JlResDimens.dp32
                            )
                            .height(JlResDimens.dp196)
                            .clip(RoundedCornerShape(JlResDimens.dp16))
                            .background(Color.Blue)

                    ) {
                        Text(
                            text = "Visual goes here",
                            color = JlThemeM3.md_theme_dark_onSurface,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth()
                                
                        )
                    }
                }

                //Graph
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(JlResDimens.dp32)
                            .height(JlResDimens.dp196)
                            .clip(RoundedCornerShape(JlResDimens.dp16))
                            .background(Color.Red)
                    ) {
                        Text(
                            text = "Graph goes here",
                            color = JlThemeM3.md_theme_dark_onSurface,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth()
                        )
                    }
                }

                //Current Level
                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = JlResDimens.dp44, end = JlResDimens.dp44)
                    ) {
                        Row(modifier = Modifier){
                            Box(
                                modifier = Modifier
                                    .size(18.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFFFCA10))
                            )

                            Spacer(modifier = Modifier.width(JlResDimens.dp18))
                            Box(modifier = Modifier
                                .fillMaxWidth()

                            ){
                                Text(
                                    text = "Current Value",
                                    textAlign = TextAlign.Start,
                                    color = JlThemeM3.md_theme_dark_onSurface,
                                    fontSize = JlResDimens.sp16,
                                )
                            }
                        }
                        Row(modifier = Modifier.padding(start = JlResDimens.dp36)){
                            Box(modifier = Modifier){
                                Text(
                                    text = "50",
                                    fontSize = JlResDimens.sp48,
                                    color = JlThemeM3.md_theme_dark_onSurface,
                                )
                            }
                            Box(modifier = Modifier.align(Alignment.CenterVertically)){
                                Text(
                                    text = "%",
                                    fontSize = JlResDimens.sp36,
                                    color = Color(0x80FFFFFF),
                                )
                            }
                        }
                    }
                }

                //Graph
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(JlResDimens.dp32)
                            .height(JlResDimens.dp196)
                            .clip(RoundedCornerShape(JlResDimens.dp16))
                            .background(Color.Red)
                    ) {
                        Text(
                            text = "Graph goes here",
                            color = JlThemeM3.md_theme_dark_onSurface,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth()
                        )
                    }
                }

                //Detail

            }
        }


//    }
}