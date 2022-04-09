package com.example.androidexample.remote.dao

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimePeriod
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.periodUntil
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
    {
    "id": "121",
    "title": "Carousell is launching its own digital wallet to improve payments for its users",
    "description": "Due to launch next month in Singapore, CarouPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash. CarouPay will be a digital wallet within the Carousell app. \"More than half of our sellers will end up buying items as well, so maybe it makes sense to have that money in the wallet for purchases\" - Quek tells Tech in Asia.",
    "banner_url": "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg",
    "time_created": 1532853058,
    "rank": 2
    }
 */
@Serializable
data class News(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("banner_url") val imageUrl: String,
    @SerialName("time_created") val created: Int,
    @SerialName("rank") val rank: Int,
)

/*
    - 5 days ago > “5 days ago”
    - 7 days ago > “1 week ago”
    - 4 weeks ago > “1 month ago”
    - 12 months ago > “1 year ago”
 */
fun News.createDate(): String {
    val createdInstant = Instant.fromEpochSeconds(created.toLong())
    val zone = TimeZone.currentSystemDefault()
    val period: DateTimePeriod = createdInstant.periodUntil(Clock.System.now(), zone)
    return with(period) {
        when {
            years > 0 -> "$years year ago"
            months > 0 -> "$months month ago"
            else -> "$days days ago"
        }
    }
}
