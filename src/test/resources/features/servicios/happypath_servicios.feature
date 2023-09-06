@happypath @regresion @servicios
  Feature:Validar el correcto funcionamiento de los principales servicios de Contrato-Server QA

    @TEST01
    Scenario: TEST01:0-token-poc
      Given Obtener llamada al servicio de registro con sus datos
      When se valida el codigo de respuesta "200"
      Then guardamos el token obtenido

    @TEST02
    Scenario Outline: TEST02:Registrar
      Given Obtener llamada al servicio de login con sus datos "<json>"
      When se valida el codigo de respuesta "200"
      Then se valida que exista el token de sesion y se guarda "<codigo>"
      Examples: Jsons
      | json                                                  | codigo |
      | Registrar_Error_#01_Data Invalida                     |  8166  |
      | Registrar_Error_#02_Dni_Cliente_Repetido              |  8499  |
      | Registrar_Error_#03_Doc_No_Se_Guardó                  |  8057  |
      | Registrar_Error_#04_Contrato_Ya_Existe                |  8057  |
      | Registrar_Error_#05_BMO_Error_Identificador_Invalido  |  8057  |