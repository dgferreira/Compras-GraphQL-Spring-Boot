package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.*;
import com.udemy.compras.graphql.dto.CompraResumo;
import com.udemy.compras.service.ClienteService;
import com.udemy.compras.service.CompraService;
import com.udemy.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id) {
        return compraService.findById(id);
    }

    public List<Compra> compras(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("quantidade"));
        return compraService.findAll(pageable);
    }

    public List<CompraResumo> comprasRelatorio() {
        return compraService.findAllComprasRelatorio();
    }

    public Compra saveCompra(CompraInput input) {
        ModelMapper modelMapper = new ModelMapper();
        Compra compra = modelMapper.map(input, Compra.class);

        compra.setData(new Date());
        compra.setCliente(clienteService.findById(input.getClienteId()));
        compra.setProduto(produtoService.findById(input.getProdutoId()));

        return compraService.save(compra);
    }

    public Boolean deleteCompra(Long id) {
        return compraService.deleteById(id);
    }

}
