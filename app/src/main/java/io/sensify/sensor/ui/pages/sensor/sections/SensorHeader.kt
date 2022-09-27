package io.sensify.sensor.ui.pages.sensor.sections

import android.util.Log
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.material3.TabPosition
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import io.sensify.sensor.R
import io.sensify.sensor.ui.fix.material3.pagerTabIndicatorOffset
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.themes.JlThemeM3
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResTxtStyles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Niraj on 27-09-2022.
 */
@OptIn(ExperimentalPagerApi::class)
//@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun SensorDetailHeader(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    tabItems: List<String> = listOf("Visual", "Graph")
) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = JlResDimens.dp32, topEnd = JlResDimens.dp32,
                    bottomStart = JlResDimens.dp16, bottomEnd = JlResDimens.dp16
                )
            )
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        JLThemeBase.colorPrimary.copy(alpha = 0.2f),
//                    JLThemeBase.colorPrimary30,
                        JLThemeBase.colorPrimary.copy(alpha = 0.0f),
//                    JLThemeBase.colorPrimary20,
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .border(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                    )
                ),
                width = JlResDimens.dp1,
                shape = RoundedCornerShape(
                    topStart = JlResDimens.dp32, topEnd = JlResDimens.dp32,
                    bottomStart = JlResDimens.dp16, bottomEnd = JlResDimens.dp16
                )
            )
    ) {

        TabRow(
            selectedTabIndex = pagerState.currentPage,

//            backgroundColor = Color.Yellow,
            modifier = Modifier
                .background(color = Color.Transparent)
                .padding(horizontal = JlResDimens.dp8, vertical = JlResDimens.dp8)
//                .clip(RoundedCornerShape(JlResDimens.dp28))
            ,


            containerColor = Color.Transparent,
            divider = { Divider(color = Color.Transparent) },
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(
                            pagerState, tabPositions
                        )
                        .background(
                            brush = Brush.linearGradient(

                                listOf(
                                    JLThemeBase.colorPrimary,
//                            MaterialTheme.colorScheme.primary,
//                    JLThemeBase.colorPrimary30,
                                    JLThemeBase.colorPrimary30,
//                    JLThemeBase.colorPrimary20,
                                ),

                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            ), shape = RoundedCornerShape(
                                topStart = JlResDimens.dp24, topEnd = JlResDimens.dp24,
                                bottomStart = JlResDimens.dp12, bottomEnd = JlResDimens.dp12
                            )
                        )
                        .width(JlResDimens.dp0)
                        .height(JlResDimens.dp48)
                        .zIndex(1f),

                    color = Color.Transparent,

                    )
            }
        ) {
            tabItems.forEachIndexed { index, title ->
                val color = remember {
                    Animatable(Color.Green)
                }

                LaunchedEffect(
                    pagerState.currentPage == index
                ) {
                    Log.d("Tabs", "LaunchedEffect: ${pagerState.currentPage} $index")
                    color.animateTo(if (pagerState.currentPage == index) JLThemeBase.colorPrimary else Color.Transparent)
                }
                Tab(
                    text = {
                        Text(
                            title,
                            style = if (pagerState.currentPage == index) TextStyle(
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = JlResDimens.sp18
                            ) else TextStyle(
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = JlResDimens.sp16
                            )
                        )
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier
                        .background(
                            color = Color.Transparent,// color.value,

                            shape = RoundedCornerShape(
                                topStart = JlResDimens.dp28, topEnd = JlResDimens.dp28,
                                bottomStart = JlResDimens.dp12, bottomEnd = JlResDimens.dp12
                            )
                        )
                        .zIndex(2f)
                        ,

                    onClick = { coroutineScope.launch {
                        Log.d("Tabs", "onClick: $index")
                        pagerState.animateScrollToPage(index)
                    } }
                )
            }
        }


    }
}