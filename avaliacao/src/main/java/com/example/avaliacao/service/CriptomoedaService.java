package com.example.avaliacao.service;

import com.example.avaliacao.entity.Criptomoeda;
import com.example.avaliacao.repository.CriptomoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriptomoedaService {

    @Autowired
    CriptomoedaRepository criptomoedaRepository;

    public Criptomoeda cadastrar(Criptomoeda criptomoeda){
        return criptomoedaRepository.save(criptomoeda);
    }

    public Optional<Criptomoeda> buscarPorId(Long id){
        return criptomoedaRepository.findById(id);
    }

    public List<Criptomoeda> listar(){
        return criptomoedaRepository.findAll();
    }

    public Criptomoeda atualizar(Criptomoeda criptomoeda){
        return criptomoedaRepository.save(criptomoeda);
    }

    public void excluir(Long id){
        criptomoedaRepository.deleteById(id);
    }

    public Criptomoeda converter(String sigla){
        return criptomoedaRepository.findBySigla(sigla);
    }

}
