package com.example.remote.dao

import androidx.annotation.DrawableRes
import com.example.R

data class Skill(val name: String, val level: Float)
data class WorkHistory(
    val company: String,
    val duration: String,
    val desc: String,
    val experiences: List<String>
)
data class Education(
    val collage: String,
    val duration: String,
    val desc: String,
    val expertises: List<String>
)
data class Candidate(
    @DrawableRes val avatar: Int,
    val name: String,
    val title: String,
    val details: List<String>,
    val links: List<String>,
    val skills: List<Skill>,
    val languages: List<Skill>,
    val desc: String,
    val workHistoryList: List<WorkHistory>,
    val education: Education
) {
    companion object {
        val JohnChang = Candidate(
            avatar = R.drawable.my_pic,
            name = "John Chang",
            title = "ANDROID DEVELOPER",
            details = buildList {
                add("+886 912345678")
                add("ddtddt55@gmail.com")
            },
            links = buildList {
                add("LinkedIn")
            },
            skills = buildList {
                add(Skill("Java", 1f))
                add(Skill("Kotlin", 1f))
                add(Skill("Git", 1f))
                add(Skill("Android Development", 1f))
            },
            languages = buildList {
                add(Skill("Chinese", 1f))
                add(Skill("English", 0.7f))
                add(Skill("Japanese", 0.4f))
            },
            desc = "My expertise is to develop at Android Platform over 10 year so that I have experienced from Linux Kernel to Application Layer. Over year to year, I still continue to learn new knowledge and show the passion on work.",
            workHistoryList = listOf(
                WorkHistory(
                    company = "Senior Android Engineer, Grab, Singapore",
                    duration = "OCTOBER 2021 — APRIL 2022",
                    desc = "The company provide transport and delivery service in South Asia. My team develop and maintain the driver experience.",
                    experiences = buildList {
                        add("Develop foundation of driver app supporting transport and food")
                        add("Consolidate the process of in-transit")
                        add("Improve trips per transit hour")
                    }
                ),
                WorkHistory(
                    company = "Senior Android Engineer, Rakuten Viki, Singapore",
                    duration = "JULY 2017 — SEPTEMBER 2021",
                    desc = "Global video streaming platform which mainly provide Asia drama and subtle in more than 200 languages.",
                    experiences = buildList {
                        add("Continue to develop/maintain/improve mobile and TV app for Android")
                        add("Adopt modern architecture to refactoring legacy code")
                        add("Be nominated Google Play awards in 2018 and 201 9")
                    }
                ),
                WorkHistory(
                    company = "Android Lead, Migme, Tapei, Taiwan",
                    duration = "SEPTEMBER 2015 — APRIL 2017",
                    desc = "Lead on Android team and make schedule to aligning with requirement.",
                    experiences = buildList {
                        add("Develop social media app, Migme, on Android platform")
                        add("Join discussion of technology estimation with other teams at analysis & design phase.")
                    }
                ),
                WorkHistory(
                    company = "Senior Android Developer, HTC, Taipei, Taiwan",
                    duration = "DECEMBER 2013 — AUGUST 2015",
                    desc = "Responsible for Memory and Performance on Android platform",
                    experiences = buildList {
                        add("Guide RD to avoid issues of memory leak and performance low when designing the new generation’s feature")
                    }
                ),
                WorkHistory(
                    company = "Senior Android Developer, FUJITSU, Taipei, Taiwan",
                    duration = "FEBRUARY 2010 — NOVEMBER 2013",
                    desc = "Develop related software and tool for Wimax related products, including dongle, Wimax/WiFi",
                    experiences = emptyList()
                ),
                WorkHistory(
                    company = "Junior Software Engineer , FOXCONN, Taipei, Taiwan",
                    duration = "OCTOBER 2008 — JANUARY 2010",
                    desc = "Coding and implement the manufacturer and computer-side tool",
                    experiences = emptyList()
                )
            ),
            education = Education(
                "Master, NATIONAL TAIPEI UNIVERSITY OF TECHNOLOGY, Taipei, Taiwan",
                "SEPTEMBER 2005 — JUNE 2007",
                "Major software development and software process",
                buildList {
                    add("Design Pattern")
                    add("OOAD")
                }
            )
        )
    }
}
