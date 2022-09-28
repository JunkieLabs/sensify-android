package io.sensify.sensor.ui.pages.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
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
import io.sensify.sensor.ui.pages.about.sections.AboutCommunity
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResShapes
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 28-09-2022.
 */
@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalTextApi::class,
    ExperimentalPagerApi::class
)
@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun AboutPage(modifier: Modifier = Modifier, navController: NavController? = null) {
    val lazyListState = rememberLazyListState()

    Scaffold(topBar = {

        SmallTopAppBar(

//            backgroundColor = Color.Transparent,
            colors = if (lazyListState.firstVisibleItemIndex > 0) TopAppBarDefaults.mediumTopAppBarColors(
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
                    text = "",
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h4,
                    fontWeight = FontWeight(400),
                    modifier = modifier.fillMaxWidth(),
                )
            }
        )
    }
    ) {

        Box(
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


        ) {

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = JlResDimens.dp32, end = JlResDimens.dp32),
//            con = it,

            ) {

                Spacer(modifier = JlResShapes.Space.H64)
                Image(
                    painterResource(id = io.sensify.sensor.R.drawable.pic_about_gradient),
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.2f),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = JlResDimens.dp32, end = JlResDimens.dp32),
//            con = it,

            ) {

                Spacer(modifier = JlResShapes.Space.H64)

                Image(
                    painterResource(id = R.drawable.pic_logo),
                    modifier = Modifier
                        .width(JlResDimens.dp64)
                        .height(JlResDimens.dp64)
                        .align(alignment = Alignment.CenterHorizontally),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(JlResDimens.dp24))

                Text(
                    modifier = Modifier
                        .width(width = 300.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    text = "Hey, Thank you for downloading Sensify",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.87f),
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h2,
                )

                Spacer(modifier = Modifier.weight(1f))
//            Spacer(modifier = Modifier.)

                Text(
                    modifier = Modifier
                        .width(width = 300.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    text = "Collaborate in Junkielabs",
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h3,
                )
                Spacer(modifier = Modifier.height(JlResDimens.dp6))
                Text(
                    modifier = Modifier
                        .width(width = 300.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    text = "At Junkielabs we create apps for new developers.",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h5,
                )

                Spacer(modifier = Modifier.height(JlResDimens.dp12))

                AboutCommunity()

                Spacer(modifier = Modifier.height(JlResDimens.dp36))

                ElevatedButton(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF030303)),
                    modifier = Modifier.height(JlResDimens.dp56),
                    shape = RoundedCornerShape(JlResDimens.dp16),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(size = JlResDimens.dp24),
                        tint = Color.White,
                        painter = painterResource(R.drawable.ic_github),
                        contentDescription = "print"
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        color = Color.White,
                        text = "Github",textAlign = TextAlign.Center,
                        style = JlResTxtStyles.h5,)
                }

                Spacer(modifier = Modifier.height(JlResDimens.dp12))

                ElevatedButton(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDE1D34)),
                    modifier = Modifier.height(JlResDimens.dp56),
                    shape = RoundedCornerShape(JlResDimens.dp16),
                    onClick = { /*TODO*/ }) {
                    Text(
                        modifier = Modifier.weight(1f),
                        color = Color.White,
                        text = "Junkie Labs",textAlign = TextAlign.Center,
                        style = JlResTxtStyles.h5,)
                }
                Spacer(modifier = Modifier.height(JlResDimens.dp20))

            }

        }


    }
}