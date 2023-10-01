package com.example.domainobjects.inventory

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository: CrudRepository<Inventory, Long>