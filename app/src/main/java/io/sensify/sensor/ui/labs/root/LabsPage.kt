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
import io.sensify.sensor.ui.navigation.NavDirectionsApp
import io.sensify.sensor.ui.resource.values.JlResDimens

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
        Divider(color = Color.White, thickness = JlResDimens.dp1)
        Text(
            text = "Core", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = JlResDimens.dp1)

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { navController.navigate(NavDirectionsApp.Splash.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Launcher")
        }
        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { navController.navigate(NavDirectionsApp.HomePage.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Home")
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { navController.navigate(NavDirectionsApp.SensorDetailPage.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Sensor Detail")
        }



        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.Sensors.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Sensors")
        }

        Divider(color = Color.White, thickness = JlResDimens.dp1)
        Text(
            text = "Old", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = JlResDimens.dp1)

        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.HomePage.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Old Home")
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp20))
        Divider(color = Color.White, thickness = JlResDimens.dp1)
        Text(
            text = "Others", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = JlResDimens.dp1)
        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.ViewPager.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "View Pager")
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.Styles.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Styles")
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.Permissions.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "permissions")
        }
        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.SensorData.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Sensors Data")
        }
        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = {
                navController.navigate(NavDirectionsLabs.LineChart.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Line Chart Realtime")
        }
        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Line Chart Ui")
        }
        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Divider(color = Color.White, thickness = JlResDimens.dp1)

        Spacer(modifier = Modifier.height(JlResDimens.dp16))

    }
}