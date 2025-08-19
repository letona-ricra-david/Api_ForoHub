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
---
### Arquitectura Foro-Hub API REST
<img width="1727" height="867" alt="image" src="https://github.com/user-attachments/assets/13ba2aba-1f56-4331-a85b-225459c21d56" />

---
### Diagrama de Secuencia Foro-Hub API REST
<img width="711" height="618" alt="image" src="https://github.com/user-attachments/assets/e0f9e3d0-8711-4dc2-951d-5db373ab8c15" />

---
### Imagenes de Ejemplo Foro-Hub API REST
![mysql](https://github.com/user-attachments/assets/2aa0cb3a-66fd-44c8-a6ec-b9421272b2a3)
![iniciar sesion](https://github.com/user-attachments/assets/c0945b15-935b-4fc9-9fe4-fee41def2b3f)
![crear usuario](https://github.com/user-attachments/assets/6f64bd47-6f80-454c-bdce-f9f2911a13db)
![crear topicos](https://github.com/user-attachments/assets/1a9be5bc-7875-4eda-9296-e83bbc7b37a7)
![respuestas](https://github.com/user-attachments/assets/e109bda9-3616-47b7-94ea-19ad777ff3d2)

