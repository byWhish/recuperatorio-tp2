package figuras

import ar.edu.unq.example.BaseSpec

/**
  * Created by whish on 08/12/16.
  */
class FigurasSpec extends BaseSpec{


  "un circulo" should "transladar" in {
    var transformer = new Transformador
    var viejo = Circulo(1,1,1)
    var nuevo = transformer.trasladar( 1,1 )( viejo )
    nuevo.getX shouldBe viejo.getX + 1
  }

  "un rectangulo" should "transladar" in {
    var transformer = new Transformador
    var viejo = Rectangulo(1,1,1,1)
    var nuevo = transformer.trasladar( 1,1 )( viejo )
    nuevo.getX shouldBe viejo.getX + 1
  }

  "un linea" should "transladar" in {
    var transformer = new Transformador
    var viejo = Linea(0,0,1,1)
    var nuevo = transformer.trasladar( 1,1 )( viejo )
    nuevo.getX shouldBe viejo.getX + 1
  }

  "un circulo" should "mover" in {
    var transformer = new Transformador
    var viejo = Circulo(1,1,1)
    var nuevo = transformer.mover( 1,1 )( viejo )
    nuevo.getX shouldBe 1
  }

  "un rectangulo" should "mover" in {
    var transformer = new Transformador
    var viejo = Rectangulo(1,1,1,1)
    var nuevo = transformer.mover( 1,1 )( viejo )
    nuevo.getX shouldBe 1
  }

  "un linea" should "mover" in {
    var transformer = new Transformador
    var viejo = Linea(0,0,1,1)
    var nuevo = transformer.mover( 1,1 )( viejo )
    nuevo.getX shouldBe 1
  }

  "un circulo" should "mover al origen" in {
    var transformer = new Transformador
    var moverAlOrigen : (Figura => Figura) = transformer.mover(0,0)
    var viejo = Circulo(1,1,1)
    var nuevo = moverAlOrigen(viejo)
    nuevo.getX shouldBe 0

  }

  "un circulo" should "transformador con aplicacion parcial" in {
    var transformer = new Transformador
    var viejo = Circulo(1, 1, 1)
    var nuevo = transformer.moverAlOrigen(viejo)
    nuevo.getX shouldBe 0
  }

  "un circulo" should "mover x" in {
    var transformer = new Transformador
    var viejo = Circulo(1, 1, 1)
    var nuevo = transformer.moverX(0)(viejo)
    nuevo.getX shouldBe 0
    nuevo.getY shouldBe 1

  }

  "un circulo" should "mover y" in {
    var transformer = new Transformador
    var viejo = Circulo(1, 1, 1)
    var nuevo = transformer.moverY(0)(viejo)
    nuevo.getX shouldBe 1
    nuevo.getY shouldBe 0

  }

  "un circulo" should "trasladarXnY" in {
    var transformer = new Transformador
    var viejo = Circulo(1, 1, 1)
    var nuevo = transformer.trasladarXnY(1)(viejo)
    nuevo.getX shouldBe 2
    nuevo.getY shouldBe 2
  }

  "un circulo" should "duplicar" in {
    var transformer = new Transformador
    var viejo = Circulo(1, 1, 1)
    var nuevo = transformer.duplicar()(viejo)
    nuevo.getRadio shouldBe 2
  }

  "un funcion" should "poder componer" in {
    var transformer = new Transformador
    var dobleEscalarDos : (Figura => Figura ) = transformer.doble(transformer.escalar(2))
    var viejo = Circulo(1,1,1)
    var nuevo = dobleEscalarDos( viejo )
    nuevo.getRadio shouldBe 4
  }

}
