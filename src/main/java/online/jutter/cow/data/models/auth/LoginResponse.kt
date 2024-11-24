package online.jutter.cow.data.models.auth

data class LoginResponse(
    val token: String?,
    val isRegistered: Boolean,
)