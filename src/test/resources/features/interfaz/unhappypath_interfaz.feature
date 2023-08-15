@unhappypath @regresion
  Feature:Validar el correcto funcionamiento de las principales funcionalidades de REDLO

    @TEST09
    Scenario: TEST09:Validar que no se pueda registrar un usuario con el mismo email.
      Given Ingresar a la web de REDLO
      When se ingresan los datos de registro con error email
      Then se valida el error de email existente "Un usuario con el mismo email ya existe."

    @TEST10
    Scenario: TEST10:Validar que no se pueda registrar un usuario con el mismo enterpriseID.
      Given Ingresar a la web de REDLO
      When se ingresan los datos de registro con error enterpriseID
      Then se valida el error de enterpriseID existente "Una empresa con ese ID ya existe."