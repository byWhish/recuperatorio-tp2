
package figuras

/**
  * Created by whish on 09/12/16.
  */
trait Motor {

  var figuras : List[Figura] = Nil
  var estados : List[List[Figura]] = Nil
  var transformaciones : List[Figura=>Figura] = Nil

  def agregarFigura( figura :Figura ) : Unit = {
     figuras = figuras.::(figura)
  }

  def getFiguras : List[Figura] = this.figuras

  def transformar( funcion : Figura => Figura ) : Unit = {
    transformaciones = transformaciones.::(funcion)
    estados = estados.::(figuras)
    figuras = figuras.map( f => funcion(f) )
  }

  def getEstadoAnterior = estados.head

  def getEstados = estados.::(figuras) flatten

  def repetir : Unit = {
    transformar( transformaciones.head )
  }

  def rollback( n:Int ) : Unit = {
    for ( x <- 1 to n ) {
      figuras = estados.head
      estados = estados.tail
    }
  }

}
