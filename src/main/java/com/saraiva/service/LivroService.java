package com.saraiva.service;

import com.saraiva.dto.CriarLivroDTO;
import com.saraiva.entity.Livro;
import com.saraiva.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id){
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Livro criar(CriarLivroDTO dto) {
        Livro livro = Livro.builder()
                .titulo(dto.nome())
                .capaUrl(dto.capaUrl())
                .descricao(dto.descricao())
                .anoLancamento(dto.anoLancamento())
                .quantidade(dto.quantidade())
                .autor(dto.autor())
                .disponivel(dto.quantidade() > 0)
                .build();

        return livroRepository.save(livro);
    }

    public void deletar(Long id){
        Livro livro = buscarPorId(id);
        livroRepository.delete(livro);
    }

    public Livro devolver(Long id){
        Livro livro = buscarPorId(id);

        livro.setQuantidade(livro.getQuantidade() + 1);
        livro.setDisponivel(true);

        return livroRepository.save(livro);
    }

    public Livro emprestar(Long id){
        Livro livro = buscarPorId(id);

        if(!livro.getDisponivel()){
            throw new RuntimeException("Livro não disponível para emprestar");
        }

        livro.setQuantidade(livro.getQuantidade() - 1);

        if(livro.getQuantidade() == 0){
            livro.setDisponivel(false);
        }

        return livroRepository.save(livro);
    }
}
