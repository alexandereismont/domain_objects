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

    fun createShop(shopDto: ShopDto) : String {
        val shop = Shop(
            name = shopDto.name,
            location = shopDto.location
        )

        shopRepository.save(shop)
        return shopDto.name
    }

    fun getShopsContainingProduct(productId: Long): List<String?> {
        return shopRepository.findAll()
            .filter { it.inventories.firstOrNull { inventory -> inventory.product?.id == productId } != null }
            .map { it.name }.toList()
    }

    fun getShopsContainingProductWithSql(productId: Long): List<String?> {
        return shopRepository.findAllByInventoriesProductId(productId).map { it.name }
    /*   return shopRepository.findAll()
            .filter { it.inventories.firstOrNull { inventory -> inventory.product?.id == productId } != null }
            .map { it.name }.toList()*/
    }
}