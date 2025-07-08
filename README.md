# Spring Boot Demo Application

Aplikasi Spring Boot sederhana untuk pembelajaran yang mencakup:
- REST API endpoints sederhana
- Swagger/OpenAPI documentation
- Hello World examples

## Fitur

1. **Hello Controller** - Endpoint sederhana untuk testing
2. **Swagger UI** - Dokumentasi API interaktif
3. **REST API** - Endpoints untuk berbagai operasi

## Cara Menjalankan

### Prerequisites
- Java 17 atau lebih tinggi
- Maven

### Langkah-langkah

1. **Clone atau download project ini**

2. **Masuk ke direktori project**
   ```bash
   cd spring-boot-assesment
   ```

3. **Jalankan aplikasi**
   ```bash
   mvn spring-boot:run
   ```

4. **Aplikasi akan berjalan di** `http://localhost:8080`

## API Endpoints

### Hello Endpoints
- `GET /api/hello` - Hello message sederhana
- `GET /api/hello/{name}` - Hello dengan nama
- `POST /api/greet` - Greeting dengan JSON body
- `GET /api/info` - Informasi aplikasi

## Contoh Request

### Hello World
```bash
curl http://localhost:8080/api/hello
```

### Hello dengan nama
```bash
curl http://localhost:8080/api/hello/Nandang
```

### Greeting dengan JSON
```bash
curl -X POST http://localhost:8080/api/greet \
  -H "Content-Type: application/json" \
  -d '{"name": "Nandang"}'
```

### Informasi Aplikasi
```bash
curl http://localhost:8080/api/info
```

## Swagger UI

Untuk melihat dokumentasi API interaktif, buka browser dan akses:
`http://localhost:8080/swagger-ui.html`

## Struktur Project

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           ├── SpringBootDemoApplication.java
│   │           ├── config/
│   │           │   └── OpenApiConfig.java
│   │           └── controller/
│   │               └── HelloController.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── example/
                └── SpringBootDemoApplicationTests.java
```

## Teknologi yang Digunakan

- **Spring Boot 3.2.0**
- **Spring Web** - untuk REST API
- **Swagger/OpenAPI** - untuk dokumentasi API
- **Maven** - build tool
- **Java 17**

## Selanjutnya

Setelah memahami contoh ini, Anda bisa menambahkan:
- Spring Security untuk authentication
- Database integration (MySQL, PostgreSQL)
- Validation untuk input data
- Exception handling yang lebih baik
- Unit tests
- Integration tests 