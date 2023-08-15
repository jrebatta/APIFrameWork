@unhappypath @regresion
Feature: Validar el correcto funcionamiento de los principales servicios de REDLO

  @TEST04
  Scenario: TEST04:Validar que no se pueda registrar un usuario con el mismo email.
    Given Obtener llamada al servicio de registro con sus datos con error email
    When se valida el codigo de respuesta "400"
    Then se valida la respuesta del servicio error email "Un usuario con el mismo email ya existe."

  @TEST05
  Scenario: TEST05:Validar que no se pueda registrar un usuario con el mismo enterpriseID.
    Given Obtener llamada al servicio de registro con sus datos con error enterpriseID
    When se valida el codigo de respuesta "400"
    Then se valida la respuesta del servicio error enterpriseID "Una empresa con ese ID ya existe."