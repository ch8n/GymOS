package dev.ch8n.gymos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform