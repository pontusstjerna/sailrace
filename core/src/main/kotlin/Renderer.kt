import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import ktx.graphics.use
import model.GameObject

class Renderer {

    private val batch = SpriteBatch()
    private val textBatch = SpriteBatch()
    private val font = BitmapFont()
    private val debugRenderer = Box2DDebugRenderer()

    private val textureMap = mapOf(Pair("boat", Texture("sailboat_top.png")))

    fun render(gameObjects: List<GameObject>, delta: Float) {
        Gdx.gl.glClearColor(0f, 0.41f, 0.58f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.use { b ->
            gameObjects.forEach { gameObject ->
                val texture = textureMap.get(gameObject.name)
                b.draw(texture, gameObject.position.x, gameObject.position.y, 100f, 75f)
            }
        }
    }

}
