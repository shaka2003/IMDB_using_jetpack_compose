package com.dicoding.jetreward.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetreward.R
import com.dicoding.jetreward.ui.theme.JetRewardTheme
import com.dicoding.jetreward.ui.theme.Shapes

@Composable
fun MovieItem(
    image: Int,
    title: String,
    release: Int,
    sinopsis: String,
    director: String,
    cast: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(Shapes.medium)
        )
        Column (
            modifier = modifier,

        ){
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 20.dp),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = stringResource(R.string.release_year, release),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(horizontal = 20.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = sinopsis,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 20.dp),
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MovieItemPreview() {
    JetRewardTheme {
        MovieItem(R.drawable.reward_4, "Jaket Hoodie Dicoding", 4000,
            "Andy Dufresne (diperankan oleh Tim Robbins) adalah seorang " +
                "bankir yang dihukum secara salah karena pembunuhan istri dan temannya. " +
                "Ia dikirim ke penjara Shawshank State Penitentiary untuk menjalani hukuman" +
                " seumur hidup. Di dalam penjara, ia berteman dengan narapidana lain, terutama " +
                "Ellis \"Red\" Redding (diperankan oleh Morgan Freeman), yang merupakan narator " +
                "cerita ini.",
            "quentin", "robert")
    }
}