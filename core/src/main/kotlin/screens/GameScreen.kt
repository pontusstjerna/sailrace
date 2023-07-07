package screens

import Renderer
import ktx.app.KtxScreen
import model.World

class GameScreen : KtxScreen {

    private var accumulator: Float = 0.0f
    private val world = World(1)

    private val renderer = Renderer()
    override fun render(delta: Float) {
        renderer.render(world.boats, delta)
    }

    private fun updatePhysics(delta: Float) {
        accumulator += delta

        while (accumulator >= World.TIME_STEP) {
            world.update()
            accumulator -= World.TIME_STEP
        }
    }
}
