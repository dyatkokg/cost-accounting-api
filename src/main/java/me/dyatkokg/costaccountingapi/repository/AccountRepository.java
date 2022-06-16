package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface AccountRepository extends PagingAndSortingRepository<Account, UUID> {
}
