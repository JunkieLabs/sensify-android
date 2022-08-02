package io.sensify.sensor.ui.labs.Screens


import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import io.sensify.sensor.R
import io.sensify.sensor.ui.utils.MyXAxisFormatter

/**
 * Created by Manish Kumar on 24/07/22.
 */

fun Modifier.advancedShadow(
    color: Color = Color.Black,
    alpha: Float = 0f,
    cornersRadius: Dp = 0.dp,
    shadowBlurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = drawBehind {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparentColor = color.copy(alpha = 0f).toArgb()

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowBlurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            cornersRadius.toPx(),
            cornersRadius.toPx(),
            paint
        )
    }
}

fun Modifier.drawColoredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
//@Composable
//fun HomeScreenHeader(modifier: Modifier = Modifier){
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(
//                start = 30.dp,
//                end = 30.dp,
//            )
//            .background(Color.Transparent)
//
//    ) {
//
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .blur(4.dp, BlurredEdgeTreatment(RoundedCornerShape(5.dp)))
//            .border(
//                width = 5.dp,
//                color = Color.Red,
//                shape = RoundedCornerShape(19.dp)
//            )
//        )
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(
//                    brush = Brush.linearGradient(
//                        listOf(
//                            Color(0xB21ADA66),
//                            Color(0xB200752F),
//                        )
//                    )
//                )
//                .padding(all = 6.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .clip(RoundedCornerShape(19.dp))
//                    .background(
//                        brush = Brush.radialGradient(
//                            listOf(
//                                Color(0x33000000),
//                                Color(0x12000000),
//
//                                )
//                        )
//                    )
//
//                    .border(
//                        brush = Brush.verticalGradient(
//                            listOf(
//
//                                Color(0x00FFFFFF),
//                                Color(0x80FFFFFF),
//                            )
//                        ),
//                        width = 1.dp,
//                        shape = RoundedCornerShape(19.dp)
//                    )
//
//            ) {
//                Box(
//                    modifier = Modifier
//                        .blur(4.dp, BlurredEdgeTreatment(RoundedCornerShape(19.dp)))
//                )
//                Text(
//                    text = "4 Active",
//                    color = Color(0xFFFFFFFF),
//                    modifier = Modifier
//                        .padding(
//                            start = 13.dp,
//                            top = 16.dp,
//                            end = 18.dp,
//                            bottom = 17.dp,
//                        )
//                )
//            }
//            Spacer(modifier = Modifier.width(18.dp))
//
//            Image(
//                painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
//                contentDescription = "slide to left",
//                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
//            )
//
//            Spacer(modifier = Modifier.width(24.dp))
//
//            Box(
//                contentAlignment = Alignment.Center,
//
//                modifier = Modifier
//
//                    .border(1.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
//                    .clip(CircleShape)
//                    .background(Color(0x14FFFFFF))
//
//            ) {
//                Image(
//                    painterResource(id = R.drawable.ic_sensor_gyroscope),
//                    contentDescription = "Gyroscope",
//                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
//                    modifier = Modifier
//                        .width(28.dp)
//                        .height(28.dp)
//                        .padding(start = 7.dp, end = 7.dp, top = 7.dp, bottom = 7.dp)
//                )
//            }
//
//            Spacer(modifier = Modifier.width(23.dp))
//
//            Text(
//                text = "Gyroscope",
//                color = Color.White
//            )
//
//            Spacer(modifier = Modifier.width(22.dp))
//
//            Image(
//                painterResource(id = R.drawable.ic_round_keyboard_arrow_right_24),
//                contentDescription = "slide to left",
//                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
//            )
//        }
//
//    }
//}

@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomeScreenHeader2(modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 30.dp,
            end = 30.dp,
        )
        .clip(RoundedCornerShape(19.dp))
        .background(
            brush = Brush.linearGradient(
                listOf(

                    Color(0xB200752F),
                    Color(0xB200752F),
                )
            )
        )
        .border(
            brush = Brush.verticalGradient(
                listOf(
                    Color(0x80FFFFFF),
                    Color(0x00FFFFFF),
                )
            ),
            width = 1.dp,
            shape = RoundedCornerShape(19.dp)
        )
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 5.dp,
                color = Color.Red,
                shape = RoundedCornerShape(1.dp)
            )
            .blur(4.dp, BlurredEdgeTreatment(RoundedCornerShape(5.dp))))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(19.dp))
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                Color(0x33000000),
                                Color(0x33000000 ),

                                )
                        )
                    )

                    .border(
                        brush = Brush.verticalGradient(
                            listOf(

                                Color(0x00FFFFFF),
                                Color(0x80FFFFFF),
                            )
                        ),
                        width = 1.dp,
                        shape = RoundedCornerShape(19.dp)
                    )

            ) {
                Box(
                    modifier = Modifier
                        .blur(4.dp, BlurredEdgeTreatment(RoundedCornerShape(19.dp)))
                )
                Text(
                    text = "4 Active",
                    color = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .padding(
                            start = 13.dp,
                            top = 16.dp,
                            end = 18.dp,
                            bottom = 17.dp,
                        )
                )
            }

            Spacer(modifier = Modifier.width(18.dp))

            Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
            )

            Spacer(modifier = Modifier.width(24.dp))

            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier

                    .border(1.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
                    .clip(CircleShape)
                    .background(Color(0x14FFFFFF))

            ) {
                Image(
                    painterResource(id = R.drawable.ic_sensor_gyroscope),
                    contentDescription = "Gyroscope",
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                        .padding(start = 7.dp, end = 7.dp, top = 7.dp, bottom = 7.dp)
                )
            }

            Spacer(modifier = Modifier.width(23.dp))

            Text(
                text = "Gyroscope",
                color = Color.White
            )

            Spacer(modifier = Modifier.width(22.dp))

            Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_right_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
            )
        }

        }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview()
//@Composable
//fun HomeScreenHeader2(modifier: Modifier = Modifier){
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(
//                start = 30.dp,
//                end = 30.dp,
//            )
//            .background(Color.Transparent)
//
//    ) {
//
//        Box(modifier = Modifier
//
//        ) {
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(
//                        brush = Brush.verticalGradient(
//                            listOf(
//                                Color(0xB21ADA66),
//                                Color(0xB200752F),
//                            )
//                        )
//                    )
//                    .padding(all = 6.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//
//                Box(
//                    contentAlignment = Alignment.Center,
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(19.dp))
//                        .background(
//                            brush = Brush.radialGradient(
//                                listOf(
//                                    Color(0x33000000),
//                                    Color(0x12000000),
//
//                                    )
//                            )
//                        )
//
//                        .border(
//                            brush = Brush.verticalGradient(
//                                listOf(
//
//                                    Color(0x00FFFFFF),
//                                    Color(0x80FFFFFF),
//                                )
//                            ),
//                            width = 1.dp,
//                            shape = RoundedCornerShape(19.dp)
//                        )
//
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .blur(4.dp, BlurredEdgeTreatment(RoundedCornerShape(19.dp)))
//                    )
//                    Text(
//                        text = "4 Active",
//                        color = Color(0xFFFFFFFF),
//                        modifier = Modifier
//                            .padding(
//                                start = 13.dp,
//                                top = 16.dp,
//                                end = 18.dp,
//                                bottom = 17.dp,
//                            )
//                    )
//                }
//                Spacer(modifier = Modifier.width(18.dp))
//
//                Image(
//                    painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
//                    contentDescription = "slide to left",
//                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
//                )
//
//                Spacer(modifier = Modifier.width(24.dp))
//
//                Box(
//                    contentAlignment = Alignment.Center,
//
//                    modifier = Modifier
//
//                        .border(1.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
//                        .clip(CircleShape)
//                        .background(Color(0x14FFFFFF))
//
//                ) {
//                    Image(
//                        painterResource(id = R.drawable.ic_sensor_gyroscope),
//                        contentDescription = "Gyroscope",
//                        colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
//                        modifier = Modifier
//                            .width(28.dp)
//                            .height(28.dp)
//                            .padding(start = 7.dp, end = 7.dp, top = 7.dp, bottom = 7.dp)
//                    )
//                }
//
//                Spacer(modifier = Modifier.width(23.dp))
//
//                Text(
//                    text = "Gyroscope",
//                    color = Color.White
//                )
//
//                Spacer(modifier = Modifier.width(22.dp))
//
//                Image(
//                    painterResource(id = R.drawable.ic_round_keyboard_arrow_right_24),
//                    contentDescription = "slide to left",
//                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
//                )
//            }
//        }
//    }
//}

//@Preview(showBackground= true, backgroundColor = 0xFFFFFFFF)
//@Composable
//fun MyLineChart() {
//
//    AndroidView(modifier = Modifier.fillMaxWidth().height(250.dp).padding(16.dp),
//        factory = { context ->
//
//            val lineChart = LineChart(context)
//            var entrieOne = mutableListOf(Entry(0f,10f), Entry(1f,14f), Entry(2f, 12f), Entry(3f, 14f))
//            var entrieTwo = mutableListOf(Entry(0f,13f), Entry(1f,11f), Entry(2f, 9f), Entry(3f, 10f))
//
//            val dataSetOne = LineDataSet(entrieOne, "Company 1").apply { color = Color.Red.toArgb() }
//            dataSetOne.axisDependency = YAxis.AxisDependency.LEFT
//            dataSetOne.setDrawValues(true)
//
//            val dataSetTwo = LineDataSet(entrieTwo, "Company 2").apply { color = Color.Green.toArgb() }
//            dataSetTwo.axisDependency = YAxis.AxisDependency.LEFT
//            dataSetTwo.setDrawValues(true)
//
//            val dataSets = mutableListOf<ILineDataSet>(dataSetOne, dataSetTwo)
//            val lineData = LineData(dataSets)
////
////            lineChart.axisLeft.mAxisMaximum = 1f
////            lineChart.axisLeft.mAxisMinimum = -1f
////            lineChart.axisLeft.mAxisRange = 2f
//
//            //Set shadow
//            lineChart.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//            lineChart.renderer.paintRender.setShadowLayer(3F, 5F, 3F, Color.Gray.toArgb());
//
//            //Formatting
//            lineChart.xAxis.valueFormatter = MyXAxisFormatter()
//            lineChart.xAxis.granularity = 1f
//            lineChart.xAxis.setDrawAxisLine(false)
//            lineChart.xAxis.setDrawGridLines(false)
////            lineChart.xAxis.setDrawLabels(false)
//            lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
//
//            lineChart.legend.isEnabled = true
//            lineChart.legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
//            lineChart.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
//            lineChart.legend.orientation = Legend.LegendOrientation.HORIZONTAL
//            lineChart.legend.setDrawInside(false)
//
//
//            lineChart.setDrawGridBackground(false)
//            lineChart.setDrawBorders(false)
//
//
//            lineChart.axisLeft.setDrawZeroLine(false)
//            lineChart.axisRight.setDrawZeroLine(false)
//            lineChart.axisLeft.isEnabled = true
//            lineChart.axisRight.isEnabled = false
//            lineChart.axisLeft.setDrawAxisLine(false)
////            lineChart.axisRight.setDrawAxisLine(false)
//            lineChart.axisLeft.setDrawLabels(false)
////            lineChart.axisRight.setDrawLabels(false)
//            lineChart.axisLeft.setDrawGridLines(false)
////            lineChart.axisRight.setDrawGridLines(false)
//            lineChart.axisLeft.axisMinimum =  8f
//
//            lineChart.description.isEnabled = false
//
//
//            lineChart.data = lineData
//            lineChart.invalidate()
//
//            lineChart
//        }){
//
//        try {
//            Log.d("TAG", "MyLineChart: Update --- Current thread id: ${Thread.currentThread()}")
//
//            it.data.dataSets[0].addEntry(Entry(0f, 0f))
//            it.lineData.notifyDataChanged()
//            it.notifyDataSetChanged()
//            it.invalidate()
//        } catch(ex: Exception) {
//            Log.d("TAG", "MyLineChart: $ex")
//        }
//    }
//}