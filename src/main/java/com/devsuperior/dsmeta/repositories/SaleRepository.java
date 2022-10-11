package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.projections.SaleReportProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value = "SELECT tb_sales.id, tb_sales.date, tb_sales.amount, tb_seller.name AS sellerName, SUM(tb_sales.amount) FROM tb_seller " +
            "INNER JOIN tb_sales ON tb_sales.seller_id = tb_seller.id " +
            "WHERE UPPER(tb_seller.name) LIKE UPPER(CONCAT('%', :name ,'%')) AND tb_sales.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY tb_sales.id, tb_sales.date,  tb_sales.amount, tb_seller.name " +
            "ORDER BY tb_sales.date DESC")
    List<SaleReportProjection> searchReport(LocalDate minDate, LocalDate maxDate, String name);



}
