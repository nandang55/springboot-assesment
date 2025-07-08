package com.example.controller;

import com.example.model.pojo.Kontainer;
import com.example.model.pojo.KontainerRequest;
import com.example.service.KontainerService;
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
@RequestMapping("/api/kontainer")
@Tag(name = "Kontainer", description = "API untuk data Kontainer")
public class KontainerController {

    @Autowired
    private KontainerService kontainerService;

    @GetMapping("/{id}")
    @Operation(summary = "Get Kontainer by ID")
    public ResponseEntity<DataResponse<Kontainer>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(kontainerService.findById(id));
    }

    @GetMapping("/findAll")
    @Operation(summary = "Get All Kontainer")
    public ResponseEntity<ListResponse<Kontainer>> findAll() {
        return ResponseEntity.ok(kontainerService.findAll());
    }

    @GetMapping("/by-gudang-id/{gudangId}")
    @Operation(summary = "Get Kontainer by Gudang ID")
    public ResponseEntity<ListResponse<Kontainer>> findByGudangId(@PathVariable Long gudangId) {
        return ResponseEntity.ok(kontainerService.findByGudangId(gudangId));
    }

    @PostMapping
    @Operation(summary = "Create Kontainer")
    public ResponseEntity<DataResponse<Kontainer>> create(@Valid @RequestBody KontainerRequest request) {
        return ResponseEntity.ok(kontainerService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Kontainer")
    public ResponseEntity<DataResponse<Kontainer>> update(@PathVariable Long id, @Valid @RequestBody KontainerRequest request) {
        return ResponseEntity.ok(kontainerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Kontainer")
    public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(kontainerService.delete(id));
    }
} 