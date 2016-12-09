package figuras

import ar.edu.unq.example.BaseSpec

/**
  * Created by whish on 09/12/16.
  */
class TrasformacionesSpec extends BaseSpec {

  "un motor" should "agregar una figura" in {
    var unMotor = new Transformador
    var unRectangulo = Rectangulo(1,1,1,1)
    var unCirculo = Circulo(1,1,1)

    unMotor.agregarFigura( unRectangulo )
    unMotor.agregarFigura( unCirculo )

    unMotor.getFiguras shouldBe List(unCirculo,unRectangulo)
  }

  "un motor" should "transformar las figuras" in {
    var unMotor = new Transformador
    var unRectangulo = Rectangulo(1,1,1,1)
    var unCirculo = Circulo(1,1,1)

    unMotor.agregarFigura( unRectangulo )
    unMotor.agregarFigura( unCirculo )

    unMotor.transformar( unMotor.moverAlOrigen )

    unMotor.getFiguras shouldBe List(Circulo(0,0,1),Rectangulo(0,0,1,1))
  }

  "un motor" should "estado anterior" in {
    var unMotor = new Transformador
    var unRectangulo = Rectangulo(1,1,1,1)
    var unCirculo = Circulo(1,1,1)

    unMotor.agregarFigura( unRectangulo )
    unMotor.agregarFigura( unCirculo )

    var estadoAnterior = unMotor.getFiguras

    unMotor.transformar( unMotor.moverAlOrigen )

    unMotor.getEstadoAnterior shouldBe estadoAnterior
    unMotor.getFiguras shouldBe List(Circulo(0,0,1),Rectangulo(0,0,1,1))
    unMotor.getEstados shouldBe List(Circulo(0,0,1),Rectangulo(0,0,1,1),Circulo(1,1,1),Rectangulo(1,1,1,1))

  }

}
