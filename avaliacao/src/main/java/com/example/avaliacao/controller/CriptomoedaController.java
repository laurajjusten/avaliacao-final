package com.example.avaliacao.controller;

import com.example.avaliacao.entity.Criptomoeda;
import com.example.avaliacao.service.CriptomoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/criptomoeda")
public class CriptomoedaController {

    @Autowired
    private CriptomoedaService criptomoedaService;

    @PostMapping
    public Criptomoeda cadastrarCriptomoeda(@RequestBody Criptomoeda criptomoeda){
        return criptomoedaService.cadastrar(criptomoeda);
    }

    @GetMapping
    public Criptomoeda buscarPorId(@RequestParam Long id){
        return criptomoedaService.buscarPorId(id).get();
    }

    @GetMapping("/lista")
    public List<Criptomoeda> listarCriptomoedas(){
        return criptomoedaService.listar();
    }

    @PutMapping("{id}")
    public String atualizarCriptomoeda(@PathVariable Long id, @RequestBody Criptomoeda criptomoeda){
        Optional<Criptomoeda> criptomoedaAtual = criptomoedaService.buscarPorId(id);
        if(criptomoedaAtual.isEmpty()){
            return "Criptomoeda com " + id + "  nâo encontrada.";
        }
        criptomoeda.setId(criptomoedaAtual.get().getId());
        criptomoedaService.atualizar(criptomoeda);
        return "Criptomoeda com id " + id + " atualizada com sucesso.";
    }

    @DeleteMapping("{id}")
    public String excluirCriptomoeda(@PathVariable Long id){
        criptomoedaService.excluir(id);
        return "Criptomoeda de " + id + " excluída com sucesso.";
    }

    @GetMapping("/converte")
    public HashMap converterCriptomoeda(@PathVariable String sigla){
        HashMap conversao = new HashMap<String, Double>();
        conversao.put("USS", 2.00);
        conversao.put("R$", 6.00);
        return conversao;
    }

}
