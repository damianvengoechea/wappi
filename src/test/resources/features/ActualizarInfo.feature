Feature: Actualizar informacion personal
  Yo como usuario
  Deseo actualizar la informacion personal
  Para actualizar la base de datos

  Scenario Outline: Actualizar informacion personal
    Given Damian ingresa a la pagina de wappi con <usuario> <contrasenia>
    When diligencia el formulario
      | imagen   | nombre   | apellido   | fecha_nacimiento   | pais   |
      | <imagen> | <nombre> | <apellido> | <fecha_nacimiento> | <pais> |
    Then se actualiza la informacion y debe mostrar el mensaje Tu información se guardó correctamente

    Examples:
      | usuario   | contrasenia | imagen                                           | nombre | apellido   | fecha_nacimiento | pais     |
      | prueba123 | 12345678    | D:\wappi\src\test\resources\imagenes\imagen.jpeg | damian | vengoechea | 11/11/1983       | colombia |

    #############################################################
    ## Tener en cuenta la ruta de la imagen, para la ejecucion ##
    #############################################################