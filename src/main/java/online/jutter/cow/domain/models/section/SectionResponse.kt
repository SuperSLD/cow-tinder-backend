package online.jutter.cow.domain.models.section

data class SectionResponse(
    val title: String,
    val subtitle: String,
    val author: String,
    val authorAvatar: String,
    val cover: String,
    val description: String,
    val link: String,
    val schedule: String,
)
