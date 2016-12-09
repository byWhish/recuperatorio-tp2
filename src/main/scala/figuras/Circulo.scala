package figuras

/**
  * Created by whish on 08/12/16.
  */
case class Circulo( x:Int, y:Int, radio:Int ) extends Figura {

  override def getX = x

  override def getY = y

  override def getRadio = radio

  override def getAlto: Int = 0

  override def getAncho: Int = 0

}
