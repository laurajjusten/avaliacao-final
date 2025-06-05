package com.example.avaliacao.repository;

import com.example.avaliacao.entity.Criptomoeda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriptomoedaRepository extends JpaRepository<Criptomoeda, Long> {

    public Criptomoeda findBySigla(String codigo);

}
