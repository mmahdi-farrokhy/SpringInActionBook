package org.mmf.chapter7.data;

import org.mmf.chapter7.Taco;
import org.mmf.chapter7.TacoOrder;
import org.mmf.chapter7.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacoRepository extends JpaRepository<Taco, Integer> {
}
