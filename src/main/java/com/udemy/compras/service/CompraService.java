package com.udemy.compras.service;

import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.Compra;
import com.udemy.compras.repository.CompraRepository;
import com.udemy.compras.dto.CompraResumo;
import com.udemy.compras.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra findById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Cacheable("comprasByCliente")
    public List<Compra> findAll(Pageable pageable) {
        return compraRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Compra save(Compra compra) {
        if(compra.getQuantidade() > 100) {
            throw new DomainException("Não é possível fazer uma compra com mais de 100 items");
        }
        return compraRepository.save(compra);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if (compraRepository.findById(id).isPresent()) {
            compraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente);
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return compraRepository.findAllComprasRelatorio();
    }
}
