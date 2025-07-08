package com.example.controller;

import com.example.model.pojo.Kantor;
import com.example.service.KantorService;
import com.example.wrapper.DataResponse;
import com.example.wrapper.ListResponse;
import com.example.wrapper.DefaultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/kantor")
@Tag(name = "Kantor", description = "API untuk data Kantor")
public class KantorController {

    @Autowired
    private KantorService kantorService;

    @GetMapping("/{id}")
    @Operation(summary = "Get Kantor by ID")
    public ResponseEntity<DataResponse<Kantor>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(kantorService.findById(id));
    }

    @GetMapping("/findAll")
    @Operation(summary = "Get All Kantor")
    public ResponseEntity<ListResponse<Kantor>> findAll() {
        return ResponseEntity.ok(kantorService.findAll());
    }

    @PostMapping
    @Operation(summary = "Create Kantor")
    public ResponseEntity<DataResponse<Kantor>> create(@Valid @RequestBody Kantor kantor) {
        return ResponseEntity.ok(kantorService.create(kantor));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Kantor")
    public ResponseEntity<DataResponse<Kantor>> update(@PathVariable Long id, @Valid @RequestBody Kantor kantor) {
        return ResponseEntity.ok(kantorService.update(id, kantor));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Kantor")
    public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(kantorService.delete(id));
    }
} 