package com.example.domainobjects.inventory

import org.springframework.stereotype.Service

@Service
class InventoryService(
    private val repository: InventoryRepository
) {

    fun save(inventory: Inventory): Inventory {
        return repository.save(inventory)
    }
}