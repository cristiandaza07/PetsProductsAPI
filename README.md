## 📋 **INFROMACIÓN DE TODO EL PROYECTO**

### **CASOS DE USO**

### **Descripción General**

- **Nombre:** Pets Products
- **Grupo:** com.
- **Versión:** 0.0.1-SNAPSHOT
- **Java Version:** 21
- **Spring Boot:** 3.5.3

### **🛠️ Tecnologías y Dependencias Principales**

**Framework Principal:**

- **Spring Boot 3.5.3** - Framework principal
- **Spring Security** - Seguridad y autenticación
- **Spring Data JPA** - Persistencia de datos
- **Spring Web MVC** - API REST

**Base de Datos:**

- **PostgreSQL** - Base de datos principal (runtime)
- **H2 Database** - Base de datos en memoria (para testing)

**Autenticación y Seguridad:**

- **JWT (JSON Web Tokens)** - jjwt 0.11.5 (api, impl, jackson)
- **OAuth2 Client** - Autenticación con proveedor de GitHub

**Mapeo y Validación:**

- **MapStruct 1.6.3** - Mapeo entre DTOs y entidades
- **Lombok** - Reducción de código boilerplate
- **Spring Boot Validation** - Validación de datos

**Documentación y Monitoreo:**

- **SpringDoc OpenAPI 2.8.6** - Documentación automática de API (Swagger)
- **Spring Boot Actuator** - Monitoreo y métricas

**Herramientas de Desarrollo:**

- **Spring Boot DevTools** - Desarrollo y hot reload
- **Spring Security Test** - Testing de seguridad

### **📁 Estructura del Proyecto**

``` 
spring-security-cero-a-experto/
├── .idea/                    # Configuración de IntelliJ IDEA
├── .mvn/                     # Maven Wrapper
├── docker-config/            # Configuración de Docker
├── src/                      # Código fuente
│   ├── main/                 # Código principal
│   └── test/                 # Pruebas unitarias
├── target/                   # Archivos compilados
├── uploads/                  # Directorio de archivos subidos
├── compose.yml               # Docker Compose
├── Dockerfile               # Configuración de Docker
├── pom.xml                  # Configuración de Maven
├── postman_collection.json  # Colección de Postman
└── README.md                # Documentación
```

### **🐳 Containerización**

El proyecto incluye soporte completo para Docker:

- **Dockerfile** para crear imagen de la aplicación
- **docker-compose.yml** para orquestación de servicios
- con configuraciones específicas **docker-config/**

### **🚀 Características del Proyecto**

1. **Seguridad Avanzada:**
    - Implementación completa de Spring Security
    - Autenticación JWT
    - OAuth2 para proveedores externos
    - Testing de seguridad incluido

2. **API RESTful:**
    - Endpoints documentados automáticamente
    - Validación de datos
    - Manejo de archivos (uploads)

3. **Persistencia:**
    - JPA con soporte para PostgreSQL
    - Base de datos H2 para desarrollo/testing

4. **Observabilidad:**
    - Spring Boot Actuator para métricas
    - Documentación OpenAPI/Swagger

5. **Desarrollo Optimizado:**
    - Hot reload con DevTools
    - Lombok para código limpio
    - MapStruct para mapeos eficientes
