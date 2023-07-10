package model

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.World
import ktx.box2d.body
import ktx.box2d.box
import kotlin.math.cos
import kotlin.math.sin

class Boat(startPosition: Vector2, physWorld: World) : GameObject("boat") {

    override val position: Vector2
        get() = body.position

    override val rotation: Float
        get() = body.angle

    override val width = 2f;
    override val length = 5.25f;

    private val body = physWorld.body(type = BodyDef.BodyType.DynamicBody, init = {
        position.set(startPosition)
        box(width, length) {
            friction = 0f
            density = 10f
        }
    }).apply {
        box(width, length) {

        }
    }

    fun update(wind: Wind) {

        val resistance = wind.force.cpy().scl(-0.9f * cos(body.angle), -1f * sin(body.angle))

        val result = wind.force.cpy().add(resistance)

        body.applyForceToCenter(result, true)
        body.applyTorque(-1f, true)
    }

}
