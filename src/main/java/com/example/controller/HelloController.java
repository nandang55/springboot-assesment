package com.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Hello Controller", description = "Endpoint untuk testing dan greeting")
public class HelloController {

    @GetMapping("/hello")
    @Operation(
        summary = "Hello World",
        description = "Endpoint sederhana untuk testing koneksi API"
    )
    @ApiResponse(responseCode = "200", description = "Berhasil mendapatkan hello message")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/hello/{name}")
    @Operation(
        summary = "Hello dengan nama",
        description = "Mengirim greeting dengan nama yang diberikan"
    )
    @ApiResponse(responseCode = "200", description = "Berhasil mendapatkan greeting")
    public String helloWithName(
        @Parameter(description = "Nama untuk greeting", example = "Nandang")
        @PathVariable String name
    ) {
        return "Hello, " + name + "! Selamat datang di Spring Boot!";
    }

    @PostMapping("/greet")
    @Operation(
        summary = "Greeting dengan JSON",
        description = "Mengirim greeting dengan data JSON yang berisi nama"
    )
    @ApiResponse(responseCode = "200", description = "Berhasil mengirim greeting")
    public Map<String, Object> greet(
        @Parameter(description = "Data JSON dengan field 'name'", example = "{\"name\": \"Nandang\"}")
        @RequestBody Map<String, String> request
    ) {
        String name = request.get("name");
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Halo " + name + "!");
        response.put("timestamp", LocalDateTime.now());
        response.put("status", "success");
        return response;
    }

    @GetMapping("/info")
    @Operation(
        summary = "Informasi Aplikasi",
        description = "Mendapatkan informasi tentang aplikasi Spring Boot"
    )
    @ApiResponse(responseCode = "200", description = "Berhasil mendapatkan info aplikasi")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("application", "Spring Boot Demo");
        info.put("version", "1.0.0");
        info.put("description", "Aplikasi Spring Boot sederhana untuk pembelajaran");
        info.put("timestamp", LocalDateTime.now());
        return info;
    }
} 