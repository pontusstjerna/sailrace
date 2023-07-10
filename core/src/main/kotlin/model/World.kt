package model

import com.badlogic.gdx.math.Vector2
import ktx.box2d.createWorld

class World(val numBoats: Int = 1) {

    companion object Config {
        val TIME_STEP = 1.0f / 60.0f
        val VELOCITY_ITERATIONS = 8
        val POSITION_ITERATIONS = 3
    }

    val physicsWorld = createWorld(Vector2.Zero)
    val wind = Wind()
    val boats = (1 .. numBoats).map { Boat(Vector2(50f + 100 * it, 100f), physicsWorld) }

    fun update() {
        physicsWorld.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS)

        boats.forEach {boat -> boat.update(wind) }
    }
}
