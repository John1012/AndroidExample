package com.example.androidexample.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.androidexample.R
import com.example.androidexample.remote.dao.News
import com.example.androidexample.remote.dao.createDate
import com.example.androidexample.screen.NewsScreenState.*
import com.example.androidexample.ui.theme.MediumGray
import com.example.androidexample.ui.theme.newsDescTextColor
import com.example.androidexample.ui.theme.newsTitleTextColor
import com.example.androidexample.ui.theme.topAppBarBackgroundColor
import com.example.androidexample.ui.theme.topAppBarContentColor

@Composable
fun NewsScreen(
    viewModel: NewsViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val uiState: NewsScreenState by viewModel.uiState.collectAsState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AppBar(viewModel) },
        content = {
            when (uiState) {
                is Loading -> {
                    // shimmer animation
                }
                is Loaded -> {
                    val newsList = (uiState as Loaded).newsList
                    if (newsList.isNotEmpty()) {
                        ListContent(newsList)
                    } else {
                        EmptyContent()
                    }
                }
                is Failure -> {
                    FailureContent()
                }
            }
        }
    )
}

@Composable
fun AppBar(
    viewModel: NewsViewModel
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = { MenuAction(viewModel) }
    )
}

@Composable
fun MenuAction(viewModel: NewsViewModel) {
    var expand by remember { mutableStateOf(false) }
    val uiState: NewsScreenState by viewModel.uiState.collectAsState()
    IconButton(onClick = { expand = true }) {
        Icon(
            imageVector = Icons.Outlined.MoreHoriz,
            contentDescription = null,
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expand,
            onDismissRequest = { expand = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expand = false
                    viewModel.alignment(Sort.RECENT)
                }
            ) {
                Text(
                    text = stringResource(id = R.string.recent),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = if (uiState is Loaded && (uiState as Loaded).sort == Sort.RECENT)
                        FontWeight.Bold
                    else
                        FontWeight.Normal,
                )
            }
            DropdownMenuItem(
                onClick = {
                    expand = false
                    viewModel.alignment(Sort.POPULAR)
                }
            ) {
                Text(
                    text = stringResource(id = R.string.popular),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = if (uiState is Loaded && (uiState as Loaded).sort == Sort.POPULAR)
                        FontWeight.Bold
                    else
                        FontWeight.Normal,
                )
            }
        }
    }
}

@Composable
fun ListContent(newsList: List<News>) {
    LazyColumn {
        items(newsList) { news ->
            NewsItem(news = news)
        }
    }
}

@Composable
fun NewsItem(
    news: News
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(news.imageUrl)
                    .size(Size.ORIGINAL)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                text = news.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.newsTitleTextColor,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                text = news.description,
                color = MaterialTheme.colors.newsDescTextColor,
                style = MaterialTheme.typography.subtitle1,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
            Text(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                text = news.createDate()
            )
        }
    }
}

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_sad_face),
            contentDescription = stringResource(id = R.string.sad_face_icon),
            tint = MediumGray
        )
        Text(
            text = stringResource(id = R.string.empty_screen),
            color = MediumGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}

@Composable
fun FailureContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_sad_face),
            contentDescription = stringResource(id = R.string.sad_face_icon),
            tint = MediumGray
        )
        Text(
            text = stringResource(id = R.string.server_error),
            color = MediumGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}
