package grupo.todolist.Controller;

import grupo.todolist.Model.Tarefa;
import grupo.todolist.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class Controller {
    @Autowired
    private Repository repository;

    @GetMapping
        public List<Tarefa> listarTarefa(){
        return repository.findAll();
    }
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa){
        return repository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizado){
        return repository.findById(id)
                .map(usuario -> {
                    usuario.setNome(tarefaAtualizado.getNome());
                    usuario.setDescricao(tarefaAtualizado.getDescricao());
                    usuario.setDataCriacao(tarefaAtualizado.getDataCriacao());
                    usuario.setDataConclusao(tarefaAtualizado.getDataConclusao());
                    usuario.setFeito(tarefaAtualizado.isFeito());
                    return repository.save(usuario);
                })
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        repository.deleteById(id);
    }
}
