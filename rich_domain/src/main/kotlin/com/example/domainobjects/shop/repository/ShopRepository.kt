package com.example.domainobjects.shop.repository

import com.example.domainobjects.shop.domain.Shop
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository : CrudRepository<Shop, Long> {

    @Query("""
        SELECT s 
        FROM Shop s
        JOIN s.inventories i WHERE i.product.id = :productId
    """)
    fun findAllByInventoriesProductId(@Param("productId") productId: Long): List<Shop>
}