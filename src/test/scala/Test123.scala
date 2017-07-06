import java.io.File

import io.github.peter32.spark.HelloWorld.getClass

/**
  * Created by peterjmyers on 7/5/17.
  */
object Test123 extends App {
  val f = new File("src/main/dictionary.txt")
  println(f.getAbsolutePath)
}
