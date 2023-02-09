package br.com.tech4me.supermercado.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RestController;


import br.com.tech4me.supermercado.service.ProdutoService;
import br.com.tech4me.supermercado.shared.ProdutoCompletoDto;
import br.com.tech4me.supermercado.shared.ProdutoDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Produtos_Para_Venda")
public class ProdutoController {
    @Autowired
    private ProdutoService servico;

    @PostMapping
    public ResponseEntity<ProdutoCompletoDto> cadastrarProduto(@RequestBody @Valid ProdutoCompletoDto produto){
        return new ResponseEntity<>(servico.cadastrar(produto), HttpStatus.CREATED); 
      }

    @GetMapping
    public ResponseEntity<List<ProdutoCompletoDto>> obterProdutos_Para_Venda() {
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);  
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> obterProduto(@PathVariable String id) {
      Optional<ProdutoDto> retorno = servico.obterPorId(id);
  
      if (retorno.isPresent()) {
        return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable String id){
      servico.excluirPorId(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoCompletoDto> atualizarProduto(@PathVariable String id, @RequestBody ProdutoCompletoDto produto){
      Optional<ProdutoCompletoDto> retorno = servico.atualizarPorId(id, produto); 
  
      if (retorno.isPresent()) {
        return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
      }
     
    }
    @GetMapping("/porta")
    public String obterPorta(@Value("${local.server.port}") String porta){
      return "A instância que respondeu a requisição está rodando na porta" + porta;
    }
    
  
    
      
}
