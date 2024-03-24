import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.picfol.R
import com.project.picfol.ui.theme.DarkPurple
import com.project.picfol.ui.theme.EnglishViolet
import androidx.compose.ui.text.TextStyle
import com.project.picfol.ui.theme.CoolGray

@Composable
fun WelcomeScreen() {
    Surface(
        modifier = Modifier
            .width(428.dp)
            .height(926.dp),
        color = DarkPurple,

        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(39.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            WelcomeText()
            PicfolLogoWelcome()
            DescriptionWelcomeScreen()
            StartImage(){
                //TODO
            }

        }
    }
}

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(147.dp)
            .height(45.dp)
    ) {
        Text(
            text = "Welcome",
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                color = EnglishViolet,

                textAlign = TextAlign.Center,
            )
        )
    }
}

@Composable
fun DescriptionWelcomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .width(321.dp)
            .height(86.dp)
    ) {
        Text(
            text = "\"Picfol\" is an innovative program designed for users to craft their own photo albums effortlessly. With \"Picfol,\" users can easily create, edit, and organize their moments and memories all in one place.",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                color = CoolGray,

                textAlign = TextAlign.Center,
            )
        )
    }
}

@Composable
fun PicfolLogoWelcome() {
    Box(
        modifier = Modifier
            .width(359.dp)
            .height(148.dp)
    ) {
//        Text(
//            text = "PICFOL",
//            style = TextStyle(
//                fontSize = 96.sp,
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight(700),
//                color = Color(0xFFF8F8DD),
//                textAlign = TextAlign.Center,
//            )
//        )

        Image(
            painter = painterResource(id = R.drawable.picfollogo),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun StartImage(click: () -> Unit) {
    Box(
        modifier = Modifier
            .width(224.dp)
            .height(192.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.moon_2),
            contentDescription = "image description",
            contentScale = ContentScale.Crop
        )
        StartButtonWelcom(click = click)
    }
}

@Composable
fun StartButtonWelcom(click: ()-> Unit) {
    Box(
        modifier = Modifier
            .width(224.dp)
            .height(192.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .alpha(0.9f)
                .width(177.dp)
                .height(39.dp)
                .background(color = DarkPurple).clickable(onClick = {
                    click()
                }),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .width(77.dp)
                    .height(45.dp),
                text = "Start",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(700),
                    color = EnglishViolet,

                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun Preview() {
    WelcomeScreen()
}