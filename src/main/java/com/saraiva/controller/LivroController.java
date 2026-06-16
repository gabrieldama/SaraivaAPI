package com.saraiva.controller;

import com.saraiva.dto.CriarLivroDTO;
import com.saraiva.entity.Livro;
import com.saraiva.service.LivroService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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

    @PatchMapping("/{id}/emprestar")
    public ResponseEntity<Livro> emprestar(@PathVariable Long id){
        return ResponseEntity.ok(livroService.emprestar(id));

    }

    @PatchMapping("/{id}/devolver")
    public ResponseEntity<Livro> devolver(@PathVariable Long id){
        return ResponseEntity.ok(livroService.devolver(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody CriarLivroDTO dto){
        return ResponseEntity.ok(livroService.atualizar(id, dto));
    }
}
