package com.example.domainobjects.shop

import com.example.domainobjects.shop.service.ShopService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shops")
class ShopController(
    val shopService: ShopService
) {

    @GetMapping("/{id}")
    fun getShop(@PathVariable id: String): String {
        return "hello shop $id"
    }

    @PostMapping
    fun saveShop(@RequestBody shopDto: ShopDto): String {
        return shopService.saveShop(shopDto)
    }

    @PostMapping("inventory")
    fun addProductToInventory(@RequestBody shopProductDto: ShopProductDto): Long? {
        return shopService.addProduct(productId = shopProductDto.productId, shopId = shopProductDto.shopId)
    }

    @GetMapping("/products/{productId}")
    fun getShopsContainingProduct(@PathVariable productId: Long) : List<String?> {
        return shopService.getShopsContainingProduct(productId)
    }

}