import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.*
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.graphics.use
import model.GameObject

class Renderer(val physicsWorld: World) {

    companion object Config {
        val DEBUG = true
    }

    private val batch = SpriteBatch()
    private val textBatch = SpriteBatch()
    private val font = BitmapFont()
    private val debugRenderer = Box2DDebugRenderer()

    private val camera = OrthographicCamera()
    private val shapeRenderer = ShapeRenderer().apply {
        projectionMatrix = camera.combined
        color = SEA_COLOR
    }

    private val scale = 0.2f;

    private val textureMap = mapOf(Pair("boat", Texture("sailboat_top.png")))

    fun render(gameObjects: List<GameObject>, delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT or (if (Gdx.graphics.bufferFormat.coverageSampling) GL20.GL_COVERAGE_BUFFER_BIT_NV else 0))
        Gdx.gl.glEnable(GL20.GL_BLEND)

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            it.box(- GAME_WIDTH / 2, - GAME_HEIGHT / 2, 0f, 20f, 20f, 0f)
        }

        batch.use { b ->
            gameObjects.forEach { gameObject ->
                val texture = textureMap[gameObject.name]!!
                val width = texture.width * scale
                val height = texture.height * scale

                batch.draw(
                    texture,
                    gameObject.position.x - (width / 2), gameObject.position.y - (height / 2),
                    width / 2, height / 2, width, height, 1f, 1f,
                    gameObject.rotation * MathUtils.radiansToDegrees,
                    0, 0, texture.width, texture.height, false, false
                )
            }
        }

        if (DEBUG) {
            debugRenderer.render(physicsWorld, camera.combined)
        }
    }

}
