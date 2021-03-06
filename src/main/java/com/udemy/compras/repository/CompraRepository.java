package com.udemy.compras.repository;

import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.Compra;
import com.udemy.compras.dto.CompraResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Compra> findAllByCliente(Cliente cliente);

    @Query("select new com.udemy.compras.dto.CompraResumo(c.id, cli.nome, p.nome, c.quantidade) from Compra c " +
            "inner join c.cliente cli " +
            "inner join c.produto p ")
    List<CompraResumo> findAllComprasRelatorio();

}
