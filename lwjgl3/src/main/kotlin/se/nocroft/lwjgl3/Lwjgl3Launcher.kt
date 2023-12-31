package se.nocroft.lwjgl3

import SailRace
import WINDOW_HEIGHT
import WINDOW_WIDTH
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

    val config = Lwjgl3ApplicationConfiguration().also {
        it.setTitle("SailRace")
        it.useVsync(false)
        it.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate)
        it.setWindowedMode(WINDOW_WIDTH.toInt(), WINDOW_HEIGHT.toInt())
        it.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
    }

fun main() {

    if (StartupHelper.startNewJvmIfRequired()) {
        return
    }

    Lwjgl3Application(SailRace(), config)
}

