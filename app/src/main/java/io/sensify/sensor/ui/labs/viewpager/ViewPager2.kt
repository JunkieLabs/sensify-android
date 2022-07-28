package io.sensify.sensor.ui.labs.viewpager

import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.RatingBar
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import coil.load

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

/**
 * Created by Manish Kumar on 26/07/22.
 */

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.pager.*
import io.sensify.sensor.R

import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@ExperimentalPagerApi
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun ViewPagerSlider(){


    val pagerState  = rememberPagerState(
        initialPage =  2,
    )

    LaunchedEffect(Unit){
        while (true){
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
            )
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = Color.Magenta),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "View Pager Slide",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Spacer(modifier = Modifier.height(30.dp))
        HorizontalPager(
            count = kidsList.size,
            contentPadding = PaddingValues(start = 48.dp, end = 48.dp),
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 40.dp, 0.dp, 40.dp),
        ) { page ->
            Card(modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale

                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )

                },
                shape = RoundedCornerShape(20.dp)
            ) {

                val newKids = kidsList[page]

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)

                ) {
                    Image(painter = painterResource(
                        id = newKids.imgUri
                    ),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
                    )

                    Column(modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(15.dp)
                    ) {

                        Text(
                            text = newKids.title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        val ratingBar = RatingBar(
                            LocalContext.current, null, android.R.attr.ratingBarStyleSmall
                        ).apply {
                            rating = newKids.rating
                            progressDrawable.setColorFilter(
                                android.graphics.Color.parseColor("#FFFF00"),
                                PorterDuff.Mode.SRC_ATOP
                            )
                        }

                        AndroidView(factory ={ratingBar},
                            modifier = Modifier.padding(0.dp,8.dp,0.dp,0.dp)
                        )
                        Text(
                            text = newKids.desc,
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(0.dp,8.dp,0.dp,0.dp)
                        )


                    }

                }


            }

        }

//        //Horizontal dot indicator
//        HorizontalPagerIndicator(
//            pagerState = pagerState,modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(16.dp)
//        )

    }

}

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun ScrollEffectPager() {
//    val pagerState = rememberPagerState(
//        pageCount = places.size,
//        // We increase the offscreen limit, to allow pre-loading of images
//        initialOffscreenLimit = 2,
//    )
//
//    LaunchedEffect(Unit) {
//        while (true) {
//            yield()
//            delay(2000)
//            pagerState.animateScrollToPage(
//                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
//                animationSpec = tween(600)
//            )
//        }
//    }
//
//    Column {
//        Text(
//            text = "Discover",
//            style = MaterialTheme.typography.h3,
//            modifier = Modifier.padding(start = 16.dp, top = 40.dp),
//            fontWeight = FontWeight.Black
//        )
//        Text(
//            text = "Places",
//            style = MaterialTheme.typography.h4,
//            modifier = Modifier.padding(start = 16.dp),
//            color = MaterialTheme.colors.primary,
//            fontWeight = FontWeight.Black
//        )
//        HorizontalPager(
//            state = pagerState,
//            modifier = Modifier
//                .weight(1f)
//                .padding(
//                    top = 40.dp,
//                    bottom = 40.dp
//                ),
//        ) { pageIndex ->
//            Card(
//                modifier = Modifier
//                    .graphicsLayer {
//                        // Calculate the absolute offset for the current page from the
//                        // scroll position. We use the absolute value which allows us to mirror
//                        // any effects for both directions
//                        val pageOffset = calculateCurrentOffsetForPage(pageIndex).absoluteValue
//
//                        // We animate the scaleX + scaleY, between 85% and 100%
//                        lerp(
//                            start = 0.65f,
//                            stop = 1f,
//                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                        ).also { scale ->
//                            scaleX = scale
//                            scaleY = scale
//                        }
//                    }
//                    .fillMaxWidth()
//                    .padding(
//                        start = 12.dp,
//                        end = 12.dp,
//                    ),
//                shape = RoundedCornerShape(24.dp),
//            ) {
//                val place = places[pageIndex]
//                Box {
//                    val customView = ImageView(LocalContext.current).also{imageView ->
//                        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
//                        imageView.load(place.url)
//                    }
//
//                    AndroidView(
//                        factory = { customView },
//                        modifier = Modifier.fillMaxSize()
//                    )
//                    Box(
//                        Modifier
//                            .fillMaxSize()
//                            .background(Color(android.graphics.Color.parseColor("#80000000")))
//                    ) {}
//
//                    Column(
//                        Modifier
//                            .align(Alignment.BottomStart)
//                            .padding(16.dp)
//                    ) {
//
//                        Text(
//                            text = place.title,
//                            style = MaterialTheme.typography.h5,
//                            color = Color.White,
//                            fontWeight = FontWeight.Bold
//                        )
//
//                        val ratingBar = RatingBar(
//                            LocalContext.current, null, android.R.attr.ratingBarStyleSmall
//                        ).apply {
//                            rating = place.rating
//                            progressDrawable.setColorFilter(
//                                android.graphics.Color.parseColor("#ff8800"),
//                                PorterDuff.Mode.SRC_ATOP
//                            )
//                        }
//                        AndroidView(
//                            factory = { ratingBar },
//                            modifier = Modifier.padding(top = 8.dp)
//                        )
//                        Text(
//                            text = place.description,
//                            style = MaterialTheme.typography.body1,
//                            color = Color.White,
//                            modifier = Modifier.padding(top = 8.dp)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun ScrollEffectPagerPreview() {
//    Surface(color = MaterialTheme.colors.background) {
//        ScrollEffectPager()
//    }
//}