package com.example.domainobjects.inventory

import com.example.domainobjects.product.ProductRepository
import com.example.domainobjects.shop.repository.ShopRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(
    private val repository: InventoryRepository,
    private val shopRepository: ShopRepository,
    private val productRepository: ProductRepository
) {

    fun save(inventory: Inventory): Inventory {
        return repository.save(inventory)
    }

    fun addInventoryProduct(shopId: Long, productId: Long): Inventory {

        val shop = shopRepository.findById(shopId)
        val product = productRepository.findById(productId)

        if(shop.isPresent && product.isPresent) {
            val inventory = Inventory(shop = shop.get(), product = product.get())
            return repository.save(inventory)
        } else {
            throw Exception("Missing shop/product")
        }
    }
}