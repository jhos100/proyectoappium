Feature: Funcionalidad de inicio de sesión en la app de reservas
  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que el usuario esta en la pagina de inicio de sesion
    When el usuario ingresa un nombre de usuario valido "usuario@ejemplo.com" y una contrasena valida "contraseña123"
    Then el usuario debería ser redirigido a la pagina de inicio
    And el usuario deberia ver un mensaje de bienvenida "Bienvenido, usuario@ejemplo.com"
