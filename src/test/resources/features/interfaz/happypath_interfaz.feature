@happypath @regresion
  Feature:Validar el correcto funcionamiento de las principales funcionalidades de REDLO

    @TEST06 @interfaz
    Scenario: TEST06:Crear un usuario de manera exitosa
      Given Ingresar a la web de REDLO
      When se ingresan los datos de registro
      Then se valida la creacion del usuario en el email

    @TEST07 @interfaz
    Scenario: TEST07:Iniciar sesion correctamente con un usuario existente
      Given Ingresar a la web de REDLO
      And se ingresan los datos de inicio de sesion
      Then se valida el inicio de sesion

    @TEST08 @interfaz
    Scenario: TEST08:Cerrar sesion correctamente con un usuario existente
      Given Ingresar a la web de REDLO
      When se ingresan los datos de inicio de sesion
      And se valida el inicio de sesion
      Then se cierra sesion
