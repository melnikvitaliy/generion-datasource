package com.initflow.ddistore.repository;

import com.initflow.ddistore.domain.Authority;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface AuthorityRepository extends PagingAndSortingRepository<Authority, String> {
}
