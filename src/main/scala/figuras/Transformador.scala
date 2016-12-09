package figuras

/**
  * Created by whish on 08/12/16.
  */
class Transformador extends Motor {

  val moverAlOrigen : (Figura => Figura) = mover(0,0)

  def trasladar( x:Int, y:Int )( figura:Figura ) : Figura = figura match {
    case Circulo( a, b, c ) => Circulo( a+x, b+y, c )
    case Rectangulo( a, b, c, d ) => Rectangulo( a+x, b+y, c, d )
    case Linea( a, b, c, d ) => Linea( a+x, b+y, c+x, d+y )
  }

  def mover( x:Int, y:Int )( figura:Figura ) : Figura = figura match{
    case Circulo( a, b, c ) => Circulo( x, y, c )
    case Rectangulo( a, b, c, d ) => Rectangulo( x, y, c, d )
    case Linea( a, b, c, d ) => Linea( x, y, c, d )
  }

  def escalar( valor:Int )(figura:Figura ) : Figura = figura match{
    case Circulo( a, b, c ) => Circulo( a, b, c * valor )
    case Rectangulo( a, b, c, d ) => Rectangulo( a, b, c * valor, d * valor)
    case Linea( a, b, c, d ) => Linea( a, b, c * valor, d * valor )
  }

  def moverX( x:Int )( figura : Figura ) : Figura = {
    mover(x,figura.getY)(figura)
  }

  def moverY( y:Int )( figura : Figura ) : Figura = {
    mover(figura.getY,y)(figura)
  }

  def trasladarXnY( x:Int ) : (Figura => Figura ) = trasladar(x,x)

  def duplicar() : (Figura => Figura ) = escalar(2)

  def cuadruplicar() : (Figura => Figura ) = escalar(4)

  def doble( funcion : Figura => Figura ) : Figura => Figura = funcion compose funcion

}
