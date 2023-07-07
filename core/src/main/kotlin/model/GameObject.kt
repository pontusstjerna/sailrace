package model

import com.badlogic.gdx.math.Vector2

open class GameObject(val name: String, private val startPos: Vector2) {

   var position = startPos.cpy(

   )
}
