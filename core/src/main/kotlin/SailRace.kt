import ktx.app.KtxGame
import ktx.app.KtxScreen
import screens.GameScreen

class SailRace : KtxGame<KtxScreen>() {

    override fun create() {
        addScreen(GameScreen())
        setScreen<GameScreen>()
    }
}
