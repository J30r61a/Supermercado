package br.com.tech4me.compras.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.compras.service.ComprasService;
import br.com.tech4me.compras.shared.ComprasCompletoDto;
import br.com.tech4me.compras.shared.ComprasDto;

@RestController
@RequestMapping("/Compras")
public class ComprasController {
   
    @Autowired
    private ComprasService servico;

    //Cadastrar pedido
    @PostMapping
    public ResponseEntity<ComprasCompletoDto> cadastrarCompras(@Valid @RequestBody ComprasCompletoDto compras)
    {
        return new ResponseEntity<>(servico.CadastrarCompras(compras),HttpStatus.CREATED);
    }

    //Buscar Pedidos
    @GetMapping
    public ResponseEntity<List<ComprasCompletoDto>> obterCompras()
    {
        return new ResponseEntity<>(servico.obterCompras(),HttpStatus.OK);
    } 

    //Buscar pedido por id
    @GetMapping("/{id}")
    public ResponseEntity<ComprasDto> obterComprasPorId(@PathVariable String id)
    {
       Optional<ComprasDto> retorno = servico.obterComprasPorId(id);
        
        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }

    //Deletar Pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCompras(@PathVariable String id)
    {
        servico.excluirCompra(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Atualizar pedido
    @PutMapping("/{id}")
    public ResponseEntity<ComprasDto> atualizarCompras(@PathVariable String id, @Valid ComprasDto compras){
        Optional<ComprasDto> retorno = servico.atualizarComprasPorId(id, compras);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
