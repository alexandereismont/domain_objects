package com.example.domainobjects.inventory

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository: CrudRepository<Inventory, Long> {

    @Query("""
        SELECT i
        FROM Inventory i
        WHERE i.shop.id = :shopId
    """)
    fun findByShopId(shopId: Long): Inventory?
}