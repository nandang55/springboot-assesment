package com.example.controller;

import com.example.model.pojo.Gudang;
import com.example.model.pojo.GudangRequest;
import com.example.service.GudangService;
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
@RequestMapping("/api/gudang")
@Tag(name = "Gudang", description = "API untuk data Gudang")
public class GudangController {

    @Autowired
    private GudangService gudangService;

    @GetMapping("/{id}")
    @Operation(summary = "Get Gudang by ID")
    public ResponseEntity<DataResponse<Gudang>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(gudangService.findById(id));
    }

    @GetMapping("/findAll")
    @Operation(summary = "Get All Gudang")
    public ResponseEntity<ListResponse<Gudang>> findAll() {
        return ResponseEntity.ok(gudangService.findAll());
    }

    @GetMapping("/by-kantor-id/{kantorId}")
    @Operation(summary = "Get Gudang by Kantor ID")
    public ResponseEntity<ListResponse<Gudang>> findByKantorId(@PathVariable Long kantorId) {
        return ResponseEntity.ok(gudangService.findByKantorId(kantorId));
    }

    @PostMapping
    @Operation(summary = "Create Gudang")
    public ResponseEntity<DataResponse<Gudang>> create(@Valid @RequestBody GudangRequest request) {
        return ResponseEntity.ok(gudangService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Gudang")
    public ResponseEntity<DataResponse<Gudang>> update(@PathVariable Long id, @Valid @RequestBody GudangRequest request) {
        return ResponseEntity.ok(gudangService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Gudang")
    public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(gudangService.delete(id));
    }
} 