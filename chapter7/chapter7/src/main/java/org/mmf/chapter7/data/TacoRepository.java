package org.mmf.chapter7.data;

import org.mmf.chapter7.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Integer> {
}
