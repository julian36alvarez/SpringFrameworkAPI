package com.test.demomark.persistence.crud;

import com.test.demomark.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // manera nativa

   // @Query(value = "SELECT * FROM productos where id_categoria = ?", nativeQuery = true)
    //List<Producto> getByIdCategoria(int idCatergoria);

    //query metod

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
