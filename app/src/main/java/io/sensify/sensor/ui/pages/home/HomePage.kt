package io.sensify.sensor.ui.pages.home

import android.hardware.Sensor
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.R
import io.sensify.sensor.ui.labs.navigations.NavDirectionsLabs
import io.sensify.sensor.ui.navigation.NavDirectionsApp
import io.sensify.sensor.ui.pages.home.items.HomeSensorItem
import io.sensify.sensor.ui.pages.home.sections.HomeHeader
import io.sensify.sensor.ui.pages.home.sections.HomeSensorGraphPager
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResShapes
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 26-09-2022.
 */
@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalTextApi::class,
    ExperimentalPagerApi::class
)
@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomePage(
    modifier: Modifier = Modifier, navController: NavController? = null,
    viewModel: HomeViewModel = HomeViewModel()
) {

    val lazyListState = rememberLazyListState()
//    val sensorsProvider = SensorsProviderComposable()
//    val sensors = remember { sensorsProvider }

    val sensorUiState = viewModel.mUiState.collectAsState()
//    var sensorUiState = viewModel.mUiCurrentSensorState.collectAsState()

    val isAtTop = remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex == 0 && lazyListState.firstVisibleItemScrollOffset == 0
        }
    }

//    Log.d("HomePage", "sensor ${sensorsUiState.value.sensors}");

    Scaffold(topBar = {

        SmallTopAppBar(

//            backgroundColor = Color.Transparent,
            colors = if (!isAtTop.value) TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f), //Add your own color here, just to clarify.
            ) else TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Transparent //Add your own color here, just to clarify.
            ),


            navigationIcon = {
                Box(Modifier.padding(horizontal = JlResDimens.dp20)) {
                    Image(
                        painterResource(id = R.drawable.pic_sensify_logo),
                        modifier = Modifier
                            .width(JlResDimens.dp32)
                            .height(JlResDimens.dp36),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }

            },
            title = {
                Text(
                    text = "Sensify",
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h4,
                    fontWeight = FontWeight(400),
                    modifier = modifier.fillMaxWidth(),
                )
            },
            actions = {
                Box(Modifier.padding(horizontal = JlResDimens.dp20)) {
                    Image(

                        painterResource(id = R.drawable.pic_sensify_logo),
                        modifier = Modifier
                            .alpha(0f)
                            .width(JlResDimens.dp32)
                            .height(JlResDimens.dp36),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }
            },

            )
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController?.navigate(NavDirectionsApp.AboutPage.route) },
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
                    )
                    .border(
                        brush = Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            )
                        ),
                        width = JlResDimens.dp1,
                        shape = RoundedCornerShape(50.dp)
                    ),
                elevation = FloatingActionButtonDefaults.elevation(JlResDimens.dp0)

            ) {

                Icon(Icons.Rounded.Info, "about")

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
                ),
//                .fillMaxSize()
//                .background(JLThemeBase.colorPrimary10)
//                .consumedWindowInsets ,
            contentPadding = it,
            state = lazyListState
        ) {

            item {
                Spacer(modifier = JlResShapes.Space.H24)

            }
            // Header
            item {
                Box(
                    modifier = Modifier.padding(
                        start = JlResDimens.dp32,
                        end = JlResDimens.dp32
                    ),
                ) {
                    HomeHeader(
                        sensorUiState.value.currentSensor,
                        totalActive = sensorUiState.value.activeSensorCounts
                    )
                }
            }
            // Plotting area
            item {
//                Spacer(modifier = Modifier.height(JlResDimens.dp350))

                HomeSensorGraphPager(viewModel = viewModel)

            }

            // Available Sensors
            item {
                Box(
                    modifier = Modifier
                        .padding(
                            start = JlResDimens.dp40, end = JlResDimens.dp32,
                            top = JlResDimens.dp12, bottom = JlResDimens.dp16
                        ),
                ) {
                    Text(
                        text = "Available Sensors",
                        fontSize = JlResDimens.sp16,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }


            items(viewModel.mSensorsList.windowed(2, 2, true)) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = JlResDimens.dp32)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,


                        ) {

                        for (i in item.indices) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
//                                    .fillParentMaxWidth(0.5f)
//                                    .padding(bottom = JlResDimens.dp8)
                                    .clickable(
                                        enabled = true,
                                        onClickLabel = "Card Click",
                                        onClick = {
                                            navController?.navigate(NavDirectionsLabs.DetailPage.route)
                                        })

                            ) {
                                HomeSensorItem(
                                    modelSensor = item[i],
                                    /* se = item[i].sensorName,
                                     sensorValue = item[i].sensorValue,
                                     sensorUnit = item[i].sensorUnit,
                                     sensorIcon = item[i].sensorIcon*/

                                    onCheckChange = { type: Int, isChecked: Boolean ->
                                        viewModel.onSensorChecked(type, isChecked)

                                    },
                                    onClick = {
                                        navController?.navigate("${NavDirectionsApp.SensorDetailPage.route}/${it}")
                                    }
                                )

                            }

                            if (i < item.size - 1) {
                                Spacer(modifier = Modifier.width(JlResDimens.dp8))
                            }
                        }
                        if (item.size % 2 != 0) {
                            Spacer(modifier = Modifier.width(JlResDimens.dp8))

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(JlResDimens.dp8))

            }

            item { Spacer(modifier = Modifier.height(JlResDimens.dp16)) }
//            }
        }
    }
}