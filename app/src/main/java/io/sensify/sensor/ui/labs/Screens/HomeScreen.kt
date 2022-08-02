package io.sensify.sensor.ui.labs.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.sensify.sensor.R

/**
 * Created by Manish Kumar on 23/07/22.
 */

@Preview(showBackground=true, backgroundColor = 0xFF041B11)
@Composable
fun HomeScreenAppBar(
    modifier: Modifier = Modifier
){
    Row( verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)) {

        Spacer(modifier = modifier.width(12.dp))
        Image(
            painterResource(id = R.drawable.pic_sensify_logo),
            contentDescription = null,
        )
        
        Text(
            text = "Sensify",
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight(400),
            modifier = modifier.fillMaxWidth(),
        )
        
    }
}