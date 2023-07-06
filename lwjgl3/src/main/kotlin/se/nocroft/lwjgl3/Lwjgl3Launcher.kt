package se.nocroft.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import se.nocroft.SailRace

    val config = Lwjgl3ApplicationConfiguration().also {
        it.setTitle("SailRace")
        it.useVsync(false)
        it.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate)
        it.setWindowedMode(640, 480)
        it.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
    }

fun main() {

    if (StartupHelper.startNewJvmIfRequired()) {
        return
    }

    Lwjgl3Application(SailRace(), config)
}

