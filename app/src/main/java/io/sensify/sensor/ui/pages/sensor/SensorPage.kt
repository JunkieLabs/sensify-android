package io.sensify.sensor.ui.pages.sensor.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import io.sensify.sensor.R
import io.sensify.sensor.ui.pages.sensor.sections.SensorDetail
import io.sensify.sensor.ui.pages.sensor.sections.SensorDetailCurrentValue
import io.sensify.sensor.ui.pages.sensor.sections.SensorDetailHeader
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 27-09-2022.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalTextApi::class,
    ExperimentalPagerApi::class
)
@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun SensorPage(modifier: Modifier = Modifier, navController: NavController? = null) {
    val lazyListState = rememberLazyListState()
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    val tabItems = listOf("Visual", "Graph")

    Scaffold(topBar = {

        SmallTopAppBar(

//            backgroundColor = Color.Transparent,
            colors =  if(lazyListState.firstVisibleItemIndex > 0) TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f), //Add your own color here, just to clarify.
            ) else TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Transparent //Add your own color here, just to clarify.
            ),

            modifier = Modifier.padding(horizontal = JlResDimens.dp16),

            navigationIcon = {

                /*AppBarIcon(
                    icon = imageResource(
                        id = R.drawable.ic_menu_black_24dp)
                ) {
                    // Open nav drawer
                }*/

                IconButton(
                    onClick = { navController?.navigateUp() },
//                    modifier = Modifier.fillMaxHeight()
                ) {
                    Icon(Icons.Rounded.KeyboardArrowLeft, "back")

                   /* Image(
                        painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
                        contentDescription = "slide to left",
                        colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
                        alignment = Alignment.Center,
                    )*/
                }

            },
            title = {
                Text(
                    text = "Brightness",
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h4,
                    fontWeight = FontWeight(400),
                    modifier = modifier.fillMaxWidth(),
                )
            }
        )
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                containerColor = Color.Transparent,

                modifier = Modifier
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                JLThemeBase.colorPrimary.copy(alpha = 0.3f),
                                JLThemeBase.colorPrimary.copy(alpha = 0.1f),
                            )
                        ),
                        shape = RoundedCornerShape(50.dp)
                    ).border(
                        brush = Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            )
                        ),
                        width = JlResDimens.dp1,
                        shape = RoundedCornerShape(50.dp)
                    ),
                elevation = FloatingActionButtonDefaults.elevation(0.dp)

            ) {

                Icon(Icons.Rounded.Settings, "settings")

            }
        }
                ) {
                LazyColumn(

                    modifier = Modifier
                        .consumedWindowInsets(it)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),

                                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.02f),
                                )
                            )
                        )
//                .fillMaxSize()
//                .background(JLThemeBase.colorPrimary10)
//                .consumedWindowInsets

                        .padding(start = JlResDimens.dp32, end = JlResDimens.dp32),
                    contentPadding = it,
                    state = lazyListState
                ) {
                    // Header
                    item {
                        SensorDetailHeader(pagerState, coroutineScope)
                    }
                    item {
                        HorizontalPager(
                            count = tabItems.size,
                            state = pagerState,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.Transparent)
                        ) { page ->
                            Text(
                                text = tabItems[page],
                                modifier = Modifier.padding(JlResDimens.dp64),
                                color = Color.White
                            )
                        }
                    }

                    // Plotting area
                    item {
                        Spacer(modifier = Modifier.height(JlResDimens.dp350))
                    }

                    item {
                        SensorDetailCurrentValue()
                    }

                    item {
                        Spacer(modifier = Modifier.height(JlResDimens.dp12))
                    }

                    item {
                        SensorDetail()
                    }

                }
            }
            }