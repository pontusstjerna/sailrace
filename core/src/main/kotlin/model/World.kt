package model

import com.badlogic.gdx.math.Vector2

class World(val numBoats: Int = 1) {

    companion object Config {
        val TIME_STEP = 1.0f / 60.0f
    }

    val wind = Wind()
    val boats = (1 .. numBoats).map { Boat(Vector2(50f + 100 * it, 100f)) }

    fun update() {
        boats.forEach {boat -> boat.update() }
    }
}
