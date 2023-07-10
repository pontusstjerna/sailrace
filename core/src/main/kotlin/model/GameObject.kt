package model

import com.badlogic.gdx.math.Vector2

abstract class GameObject(val name: String) {

   abstract val position: Vector2
   abstract val width: Float
   abstract val length: Float
   abstract val rotation: Float
}
