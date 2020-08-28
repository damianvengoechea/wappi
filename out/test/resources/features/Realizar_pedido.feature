Feature: Realizar una orden con y sin cupon de bienvenida
  yo como usuario
  deseo realilzar una orden con cupon y otra sin cupon de bienvenida
  para realizar el pedido

  @ValidarModal
  Scenario Outline: Validar modal del pedido
    Given Damian ingresa a la pagina de wappi con <usuario> <contrasenia>
    When selecciona el articulo Jamón Premium
    Then el precio del articulo del modal debera ser $14,000.00

    Examples:
      | usuario   | contrasenia |
      | tester123 | 12345678    |

  @RealizarPedidoCompletoSinCupon
  Scenario Outline: Realizar pedido sin cupon
    Given Damian ingresa a la pagina de wappi con <usuario> <contrasenia>
    When selecciona los articulos
      | articulos         | cupon |
      | Aceite de Girasol | No    |
      | Pan tajado        | No    |
      | Aceite de Girasol | No    |
    Then en la opcion de mis pedidos validamo el ultimo articulo seleccionado

    Examples:
      | usuario   | contrasenia |
      | tester123 | 12345678    |

  @RealizarPedidoCompletoConCupon
  Scenario Outline: Realizar pedido con cupon
    Given Damian ingresa a la pagina de wappi con <usuario> <contrasenia>
    When optiene el cupon
    And selecciona los articulos
      | articulos         | cupon |
      | Jamón Premium     | Si    |
      | Pan tajado        | Si    |
      | Aceite de Girasol | No    |
      | Jamón Premium     | No    |
      | Aceite de Girasol | No    |
    Then se vera reflejado en mis pedidos el uso del cupon en Si

    Examples:
      | usuario   | contrasenia |
      | tester321 | 12345678    |

  @VerificarValidezCupon
  Scenario Outline: Realizar pedido usando el cupon mas de 2 veces
    Given Damian ingresa a la pagina de wappi con <usuario> <contrasenia>
    When optiene el cupon
    And usa el cupon mas de dos veces
      | articulos         | cupon |
      | Aceite de Girasol | Si    |
      | Pan tajado        | Si    |
      | Aceite de Girasol | Si    |

    Then debera mostra el mensaje Cupón inválido en el modal

    Examples:
      | usuario   | contrasenia |
      | tester321 | 12345678    |