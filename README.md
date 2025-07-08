# Spring Boot Demo Application

Aplikasi Spring Boot sederhana untuk pembelajaran yang mencakup:
- REST API endpoints
- JPA dengan H2 database
- CRUD operations untuk User entity

## Fitur

1. **Hello Controller** - Endpoint sederhana untuk testing
2. **User Management** - CRUD operations untuk User
3. **H2 Database** - Database in-memory untuk development
4. **REST API** - Endpoints untuk berbagai operasi

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

### User Endpoints
- `GET /api/users` - Ambil semua users
- `GET /api/users/{id}` - Ambil user by ID
- `POST /api/users` - Buat user baru
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Hapus user

## Contoh Request

### Membuat User Baru
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "08123456789"
  }'
```

### Mengambil Semua Users
```bash
curl http://localhost:8080/api/users
```

### Greeting dengan JSON
```bash
curl -X POST http://localhost:8080/api/greet \
  -H "Content-Type: application/json" \
  -d '{"name": "Nandang"}'
```

## H2 Database Console

Untuk melihat database, buka browser dan akses:
`http://localhost:8080/h2-console`

**Connection Details:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## Struktur Project

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           ├── SpringBootDemoApplication.java
│   │           ├── controller/
│   │           │   ├── HelloController.java
│   │           │   └── UserController.java
│   │           ├── model/
│   │           │   └── User.java
│   │           └── repository/
│   │               └── UserRepository.java
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
- **Spring Data JPA** - untuk database operations
- **H2 Database** - database in-memory
- **Maven** - build tool
- **Java 17**

## Selanjutnya

Setelah memahami contoh ini, Anda bisa menambahkan:
- Spring Security untuk authentication
- Validation untuk input data
- Exception handling yang lebih baik
- Unit tests
- Integration tests
- Swagger/OpenAPI documentation 