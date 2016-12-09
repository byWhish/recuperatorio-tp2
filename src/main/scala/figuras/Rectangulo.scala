package figuras

/**
  * Created by whish on 08/12/16.
  */
case class Rectangulo( x:Int, y:Int, alto:Int, ancho:Int ) extends Figura{

  override def getX = x

  override def getY = y

  override def getAlto = alto

  override def getAncho = ancho

  override def getRadio = 0

}
