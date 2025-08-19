# Foro-Hub API REST

**Foro-Hub API** es una aplicación backend desarrollada con **Spring Boot** que permite la gestión de foros de discusión. La API permite registrar, listar, actualizar y eliminar usuarios, tópicos y respuestas. Incluye autenticación mediante **JWT**, control de acceso por roles y manejo de errores centralizado.

El proyecto está pensado para ser utilizado en entornos educativos o corporativos que necesiten gestionar discusiones, y puede integrarse con un frontend en **React**, **Angular** u otras tecnologías.

---
## Tecnologías
- **Java 24**
- **Spring Boot 3.5**
- **Spring Security** (JWT)
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Jakarta Validation**
- **Swagger/OpenAPI 3** (SpringDoc)
- **MySQL**
- **Maven** como gestor de dependencias

---
# Foro-Hub API REST - Endpoints Compactos
| Recurso | Método | Endpoint | Descripción | Seguridad |
|---------|--------|---------|------------|-----------|
| Usuarios | POST | `/usuarios` | Registrar un usuario | Público |
| Usuarios | GET | `/usuarios` | Listar usuarios activos | JWT |
| Usuarios | GET | `/usuarios/{id}` | Obtener detalle de usuario | JWT |
| Usuarios | PUT | `/usuarios/{id}` | Actualizar usuario | JWT |
| Usuarios | DELETE | `/usuarios/{id}` | Eliminar usuario (soft delete) | JWT |
| Tópicos | POST | `/topicos` | Crear nuevo tópico | JWT |
| Tópicos | GET | `/topicos` | Listar tópicos activos | JWT |
| Tópicos | GET | `/topicos/{id}` | Obtener detalle de un tópico | JWT |
| Tópicos | PUT | `/topicos/{idTopico}` | Actualizar tópico | JWT |
| Tópicos | DELETE | `/topicos/{idTopico}` | Eliminar tópico (soft delete) | JWT |
| Respuestas | POST | `/respuestas` | Crear respuesta a un tópico | JWT |
| Respuestas | GET | `/respuestas` | Listar respuestas activas | JWT |
| Respuestas | GET | `/respuestas/{id}` | Obtener detalle de una respuesta | JWT |
| Respuestas | PUT | `/respuestas/{id}` | Actualizar respuesta | JWT |
| Respuestas | DELETE | `/respuestas/{id}` | Eliminar respuesta (soft delete) | JWT |
| Login | POST | `/login` | Obtener JWT para un usuario | Público |

**Uso del token en requests protegidos:**  

## Manejo de Errores

La API gestiona errores de manera centralizada a través de `GestorDeErrores`.

| Código HTTP | Situación | Respuesta |
|-------------|-----------|-----------|
| 400 Bad Request | Datos inválidos o formato incorrecto | Lista de errores de validación por campo |
| 401 Unauthorized | Credenciales inválidas o token JWT ausente | Mensaje indicando fallo de autenticación |
| 403 Forbidden | Acceso a recurso protegido no autorizado | Mensaje de acceso denegado |
| 404 Not Found | Recurso no encontrado (usuario, tópico, respuesta) | Respuesta vacía 404 |
| 500 Internal Server Error | Error inesperado del servidor | Mensaje de error con detalle |

### Ejemplo de error de validación
```json
[
  {
    "campo": "email",
    "mensaje": "no puede estar vacío"
  }
]
```

### Imagenes de Ejemplo Foro-Hub API REST
![crear topicos.JPG](../../../crear%20topicos.JPG)
![crear usuario.JPG](../../../crear%20usuario.JPG)
![iniciar sesion.JPG](../../../iniciar%20sesion.JPG)
![mysql.JPG](../../../mysql.JPG)
![respuestas.JPG](../../../respuestas.JPG)
