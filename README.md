# Microservicio Cliente-Persona

Este microservicio gestiona las entidades **Cliente** y **Persona** dentro de la arquitectura de microservicios. Proporciona APIs para crear, actualizar, consultar y eliminar clientes y personas, y envía eventos relacionados con los clientes a través de RabbitMQ.

## Requisitos

- **Java 17** o superior
- **Spring Boot 3.x**
- **PostgreSQL**
- **RabbitMQ** (para comunicación asíncrona)

## Configuración

### Base de Datos

El microservicio utiliza PostgreSQL como base de datos. Asegúrate de configurar las credenciales en el archivo `application.properties` o `application.yml`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/prueba_tecnica
spring.datasource.username=my_user
spring.datasource.password=134679
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
### RabbitMQ
Para habilitar la comunicación de eventos entre microservicios, configura RabbitMQ
```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```
### Comunicación de Eventos
Este microservicio recibe eventos en RabbitMQ cada vez que se reglistra un movimieento.

### Cliente API - Se adjunta coleccion postman (src/main/resources)
```properties
POST /cliente/save-client: Crear un nuevo cliente.
GET /clientes/get-clients: Obtener todos loa clientes.
PUT /clientes/update-client/{clientId}: Actualizar un cliente por ID.
DELETE /clientes/delete-client/{clientId}: Eliminar un cliente por ID.
```

