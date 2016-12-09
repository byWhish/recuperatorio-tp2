package figuras

/**
  * Created by whish on 08/12/16.
  */
case class Linea( x:Int, y:Int, xFin:Int, yFin:Int ) extends Figura {

  override def getX = x

  override def getY = y

  override def getAlto: Int = 0

  override def getAncho: Int = 0

  override def getRadio: Int = 0

}
