package com.saraiva.controller;

import com.saraiva.dto.CriarLivroDTO;
import com.saraiva.entity.Livro;
import com.saraiva.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/livros")
@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos(){
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody CriarLivroDTO dto){
        Livro livro = livroService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }
}
