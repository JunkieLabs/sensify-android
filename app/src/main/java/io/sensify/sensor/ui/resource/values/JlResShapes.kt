package io.sensify.sensor.ui.resource.values

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Niraj on 05-08-2022.
 */
object JlResShapes {

    object Common{

        val shapes = Shapes(
            small = RoundedCornerShape(8.dp),
            medium = RoundedCornerShape(12.dp),
            large = RoundedCornerShape(24.dp)
        )
    }



    object Space{
        val H18 = Modifier.height(JlResDimens.dp18)
        val H20 = Modifier.height(JlResDimens.dp20)
        val H24 = Modifier.height(JlResDimens.dp24)
        val H28 = Modifier.height(JlResDimens.dp28)
        val H32 = Modifier.height(JlResDimens.dp32)
        val H48 = Modifier.height(JlResDimens.dp48)
        val H56 = Modifier.height(JlResDimens.dp56)



        val W18 = Modifier.width(JlResDimens.dp18)
        val W20 = Modifier.width(JlResDimens.dp20)
        val W24 = Modifier.width(JlResDimens.dp24)
        val W28 = Modifier.width(JlResDimens.dp28)
        val W32 = Modifier.width(JlResDimens.dp32)
    }
}