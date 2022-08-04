package io.sensify.sensor.ui.labs.root

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.sensify.sensor.ui.labs.navigations.NavDirectionsLabs

/**
 * Created by Niraj on 04-08-2022.
 */

@Composable
fun LabsPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Divider(color = Color.White, thickness = 1.dp)
        Text(
            text = "Core", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = 1.dp)


        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Home")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Launcher")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.Sensors.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Sensors")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Divider(color = Color.White, thickness = 1.dp)
        Text(
            text = "Others", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.ViewPager.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "View Pager")
        }
        Divider(color = Color.White, thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.Styles.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Styles")
        }


    }
}