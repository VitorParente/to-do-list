package grupo.todolist.Repository;

import grupo.todolist.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Tarefa, Long> {
}
