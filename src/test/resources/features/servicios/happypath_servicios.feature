@happypath @regresion @servicios
  Feature:Validar el correcto funcionamiento de los principales servicios de REDLO

    @TEST01
    Scenario: TEST01:Obtener token de manera exitosa
      Given Obtener llamada al servicio de registro con sus datos
      When se valida el codigo de respuesta "200"
      Then guardamos el token obtenido

    @TEST02
    Scenario: TEST02:Iniciar sesion correctamente con un usuario existente
      Given Obtener llamada al servicio de login con sus datos
      When se valida el codigo de respuesta "200"
      Then se valida que exista el token de sesion y se guarda

    @TEST03
    Scenario: TEST03:Cerrar sesion correctamente se un usuario logeado
      Given Obtener llamada al servicio de cerrar sesion
      When se valida el codigo de respuesta "204"
      Then se valida el body vacio


