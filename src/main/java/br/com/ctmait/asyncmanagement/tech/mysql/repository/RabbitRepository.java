package br.com.ctmait.asyncmanagement.tech.mysql.repository;

import br.com.ctmait.asyncmanagement.tech.mysql.entity.RabbitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RabbitRepository extends JpaRepository<RabbitEntity, Long> {

    Optional<RabbitEntity> findById(String uuid);
}
