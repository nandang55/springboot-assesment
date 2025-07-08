package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "Operasi CRUD untuk User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET all users
    @GetMapping
    @Operation(
        summary = "Ambil Semua Users",
        description = "Mengambil daftar semua user yang ada di database"
    )
    @ApiResponse(responseCode = "200", description = "Berhasil mengambil daftar users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET user by ID
    @GetMapping("/{id}")
    @Operation(
        summary = "Ambil User by ID",
        description = "Mengambil data user berdasarkan ID"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Berhasil menemukan user"),
        @ApiResponse(responseCode = "404", description = "User tidak ditemukan")
    })
    public ResponseEntity<User> getUserById(
        @Parameter(description = "ID user yang akan dicari", example = "1")
        @PathVariable Long id
    ) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    // POST create new user
    @PostMapping
    @Operation(
        summary = "Buat User Baru",
        description = "Membuat user baru dengan data yang diberikan"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Berhasil membuat user"),
        @ApiResponse(responseCode = "400", description = "Email sudah ada atau data tidak valid")
    })
    public ResponseEntity<User> createUser(
        @Parameter(description = "Data user yang akan dibuat")
        @RequestBody User user
    ) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // PUT update user
    @PutMapping("/{id}")
    @Operation(
        summary = "Update User",
        description = "Mengupdate data user berdasarkan ID"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Berhasil mengupdate user"),
        @ApiResponse(responseCode = "404", description = "User tidak ditemukan")
    })
    public ResponseEntity<User> updateUser(
        @Parameter(description = "ID user yang akan diupdate", example = "1")
        @PathVariable Long id,
        @Parameter(description = "Data user yang akan diupdate")
        @RequestBody User userDetails
    ) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPhone(userDetails.getPhone());
            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE user
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Hapus User",
        description = "Menghapus user berdasarkan ID"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Berhasil menghapus user"),
        @ApiResponse(responseCode = "404", description = "User tidak ditemukan")
    })
    public ResponseEntity<Void> deleteUser(
        @Parameter(description = "ID user yang akan dihapus", example = "1")
        @PathVariable Long id
    ) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
} 