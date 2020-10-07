package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String> {

}
