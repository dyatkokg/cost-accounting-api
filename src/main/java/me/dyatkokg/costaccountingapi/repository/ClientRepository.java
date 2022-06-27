package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.dto.StatisticClientDTO;
import me.dyatkokg.costaccountingapi.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {

    Client findClientByUsername(String username);

    @Query(value = "select concat('-', cast(sum(amount_spent)as varchar)) as amount,e.date,a.id as account_id,c.id as client \n" +
            "from expense e\n" +
            "left join account a on e.account_id = a.id\n" +
            "left join client c on c.id =a.client_id \n" +
            "where c.id = :client and (e.date >= :startDate and e.date <= :endDate)\n" +
            "group by e.date,a.id,c.id\n" +
            "union all\n" +
            "select cast(sum(amount_income)as varchar), i.date,a.id,c.id \n" +
            "from income i \n" +
            "left join account a on i.account_id = a.id\n" +
            "left join client c on c.id =a.client_id \n" +
            "where c.id = :client and (i.date >= :startDate and i.date <= :endDate)\n" +
            "group by i.date,a.id,c.id",nativeQuery = true)
    List<StatisticClientDTO> getStatisticByClient(@Param("client") UUID client, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
