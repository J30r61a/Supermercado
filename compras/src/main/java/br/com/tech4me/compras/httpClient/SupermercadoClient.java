package br.com.tech4me.compras.httpClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.*;

import br.com.tech4me.compras.model.Produto;

@FeignClient("supermercado")
public interface SupermercadoClient {

    @RequestMapping(method= RequestMethod.GET, value="/Produtos_Para_Venda/{id}")
    Produto obterProduto(@PathVariable String id);
    
    
}
