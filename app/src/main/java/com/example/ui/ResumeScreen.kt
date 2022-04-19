package com.example.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remote.dao.Candidate
import com.example.remote.dao.Skill
import com.example.remote.dao.WorkHistory

@Composable
fun ResumeScreen(candidate: Candidate) {
    Row(modifier = Modifier.fillMaxSize()) {
        LeftPanel(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Blue),
            candidate = candidate
        )
        RightPanel(
            modifier = Modifier
                .fillMaxSize()
                .weight(2f)
                .background(Color.White),
            candidate = candidate
        )
    }
}

@Composable
private fun LeftPanel(modifier: Modifier, candidate: Candidate) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        AvatarSection(candidate.avatar, candidate.name, candidate.title)
        Spacer(modifier = Modifier.height(20.dp))
        DetailSection(candidate.details)
        Spacer(modifier = Modifier.height(20.dp))
        LinkSection(candidate.links)
        Spacer(modifier = Modifier.height(20.dp))
        SkillSection(candidate.skills)
        Spacer(modifier = Modifier.height(20.dp))
        LanguageSection(candidate.languages)
    }
}

@Composable
private fun LinkSection(links: List<String>) {
    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Links",
        style = MaterialTheme.typography.caption,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    links.forEach {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = it,
            style = MaterialTheme.typography.overline
                .copy(fontSize = 6.sp),
            color = Color.White,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.height(2.dp))
    }
}

@Composable
private fun DetailSection(details: List<String>) {
    Text(
        modifier = Modifier.padding(start = 16.dp, bottom = 4.dp),
        text = "Details",
        style = MaterialTheme.typography.caption,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    details.forEach {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = it,
            style = MaterialTheme.typography.overline
                .copy(fontSize = 6.sp),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(2.dp))
    }
}

@Composable
private fun AvatarSection(
    @DrawableRes imageRes: Int,
    name: String,
    title: String,
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .size(64.dp)
            .clip(CircleShape),
        alignment = Alignment.Center,
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = name,
        style = MaterialTheme.typography.caption,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(8.dp))
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp),
        color = Color.White,
        thickness = 1.dp,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = title,
        style = MaterialTheme.typography.overline
            .copy(fontSize = 6.sp),
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun SkillSection(skills: List<Skill>) {
    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Skills",
        style = MaterialTheme.typography.caption,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    skills.forEach { SkillItem(it) }
}

@Composable
private fun SkillItem(skill: Skill) {
    Text(
        modifier = Modifier
            .padding(start = 16.dp, bottom = 4.dp),
        text = skill.name,
        style = MaterialTheme.typography.overline
            .copy(fontSize = 6.sp),
        color = Color.White,
        textDecoration = TextDecoration.Underline
    )
    LinearProgressIndicator(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            .height(4.dp),
        progress = skill.level,
        color = Color.White,
        backgroundColor = Color.Gray
    )
}

@Composable
private fun LanguageSection(languages: List<Skill>) {
    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Language",
        style = MaterialTheme.typography.caption,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    languages.forEach { SkillItem(it) }
}

@Composable
private fun RightPanel(modifier: Modifier, candidate: Candidate) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        ProfileSection(desc = candidate.desc)
        Spacer(modifier = Modifier.height(20.dp))
        EmploymentHistorySection(candidate.workHistoryList)
        Spacer(modifier = Modifier.height(16.dp))
        with(candidate.education) {
            EducationSection(
                collage,
                duration,
                desc,
                expertises
            )
        }
    }
}

@Composable
private fun EducationSection(
    collage: String,
    duration: String,
    desc: String,
    expertises: List<String>
) {
    Text(
        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
        text = "Education",
        style = MaterialTheme.typography.h6,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
        text = collage,
        style = MaterialTheme.typography.overline.copy(
            fontSize = 6.sp
        ),
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
        text = duration,
        style = MaterialTheme.typography.overline.copy(
            fontSize = 4.sp
        ),
        color = Color.Gray
    )
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
        text = desc,
        style = MaterialTheme.typography.overline.copy(
            fontSize = 4.sp
        ),
        color = Color.Black
    )
    val bullet = "\u2022"
    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    Text(
        modifier = Modifier.padding(start = 12.dp, end = 8.dp, bottom = 4.dp),
        text = buildAnnotatedString {
            expertises.forEach {
                withStyle(style = paragraphStyle) {
                    append(bullet)
                    append("\t")
                    append(it)
                }
            }
        },
        style = MaterialTheme.typography.overline.copy(
            fontSize = 4.sp
        ),
        color = Color.Black
    )

}

@Composable
private fun EmploymentHistorySection(workHistoryList: List<WorkHistory>) {
    Text(
        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
        text = "Employment History",
        style = MaterialTheme.typography.h6,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
    workHistoryList.forEach {
        EmploymentHistory(
            company = it.company,
            duration = it.duration,
            desc = it.desc,
            experiences = it.experiences
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
private fun EmploymentHistory(
    company: String,
    duration: String,
    desc: String,
    experiences: List<String>
) {
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
        text = company,
        style = MaterialTheme.typography.overline.copy(
            fontSize = 6.sp
        ),
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
        text = duration,
        style = MaterialTheme.typography.overline.copy(
            fontSize = 4.sp
        ),
        color = Color.Gray
    )
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
        text = desc,
        style = MaterialTheme.typography.overline.copy(
            fontSize = 4.sp
        ),
        color = Color.Black
    )
    val bullet = "\u2022"
    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    Text(
        modifier = Modifier.padding(start = 12.dp, end = 8.dp, bottom = 4.dp),
        text = buildAnnotatedString {
            experiences.forEach {
                withStyle(style = paragraphStyle) {
                    append(bullet)
                    append("\t")
                    append(it)
                }
            }
        },
        style = MaterialTheme.typography.overline.copy(
            fontSize = 4.sp
        ),
        color = Color.Black
    )
}

@Composable
private fun ProfileSection(desc: String) {
    Text(
        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
        text = "Profile",
        style = MaterialTheme.typography.h6,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        text = desc,
        style = MaterialTheme.typography.overline.copy(
            fontSize = 6.sp
        ),
        color = Color.DarkGray,
    )
}

@Preview
@Composable
fun ResumeScreenPreview() {
    ResumeScreen(Candidate.JohnChang)
}