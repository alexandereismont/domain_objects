package com.example.domainobjects.shop.service

import com.example.domainobjects.inventory.InventoryService
import com.example.domainobjects.product.ProductRepository
import com.example.domainobjects.shop.ShopDto
import com.example.domainobjects.shop.domain.Shop
import com.example.domainobjects.shop.repository.ShopRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ShopService(
    private val shopRepository: ShopRepository,
    private val productRepository: ProductRepository,
    private val inventoryService: InventoryService
) {

    fun saveShop(shopDto: ShopDto) : String {
        val shop = Shop(
            name = shopDto.name,
            location = shopDto.location
        )

        shopRepository.save(shop)
        return shopDto.name
    }

    fun addProduct(productId: Long, shopId: Long): Long? {
        val product = productRepository.findById(productId).getOrNull()
        val shop = shopRepository.findById(shopId).getOrNull()

        if(product == null || shop == null) {
            throw Exception("Missing product/shop")
        }

        val inventory = shop.addProduct(product)

        return inventoryService.save(inventory).id
    }

    fun removeProduct(productId: Long, shopId: Long): Long? {
        val product = productRepository.findById(productId).getOrNull()
        val shop = shopRepository.findById(shopId).getOrNull()

        if(product == null || shop == null) {
            throw Exception("Missing product/shop")
        }

        val inventory = shop.removeProduct(product)

        return inventoryService.save(inventory).id
    }
}