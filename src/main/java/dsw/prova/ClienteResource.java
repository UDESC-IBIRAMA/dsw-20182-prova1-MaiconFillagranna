/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsw.prova;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maicon
 */
@RestController
@RequestMapping("/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteRepositorio clientes;
    
//    @GetMapping("/{id}");
    public Optional<Cliente> buscar(@PathVariable Long id) {
        return clientes.findById(id);
    }
    
    @GetMapping
    public List<Cliente> buscarTodos() {
        return clientes.findAll();
    }
    
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clientes.save(cliente);
    }
    
    @PutMapping
    public void atualizar(@RequestBody Cliente cliente) {
        clientes.deleteById(cliente.getId());
        clientes.save(cliente);      
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        this.clientes.deleteById(id);
    }
}
