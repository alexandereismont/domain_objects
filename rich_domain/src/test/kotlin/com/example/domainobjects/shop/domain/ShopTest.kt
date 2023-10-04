package com.example.domainobjects.shop.domain

import com.example.domainobjects.product.Product
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ShopTest {

    @Test
    fun `should add product to shop inventory`() {
        val shop = Shop(1, "TestShop", "Norway")
        val product = Product(1, "TestProduct")

        shop.addProduct(product)

        assertEquals(1, shop.inventories.size)
        assertEquals(product.id, shop.inventories[0].product!!.id)
    }

    @Test
    fun `should remove correct product from shop inventory when quantity is zero`() {
        val shop = Shop(1, "TestShop", "Norway")
        val productA = Product(1, "TestProductA")
        val productB = Product(2, "TestProductB")

        shop.addProduct(productA)
        shop.addProduct(productB)

        shop.removeProduct(productA)

        assertEquals(1, shop.inventories.size,)
        assertEquals("TestProductB", shop.inventories[0].product!!.name)
    }
}