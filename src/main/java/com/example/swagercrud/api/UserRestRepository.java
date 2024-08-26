package com.example.swagercrud.api;

import com.example.swagercrud.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(
        path = "users",
        collectionResourceRel = "users"
)
public interface UserRestRepository extends
        CrudRepository<User, UUID>,
        PagingAndSortingRepository<User, UUID> {

    List<User> findByName(@Param("name") String name);

    @Override
    @RestResource(exported = false) //essa rota nao vai ser exposta, o metodo nao vai ser permitido
    void deleteById(UUID uuid);
}
