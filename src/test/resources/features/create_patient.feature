Feature: Usuario crea una cuenta como paciente

  Scenario: Crear una cuenta como paciente
    Given el usuario se encuentra en el formulario de registro
    When ingresa su nombre, correo, ubicación, edad, número de celular, contraseña y apellidos correctos, y elige su rol
    Then se registra su nueva cuenta