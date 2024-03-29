package com.example.domainobjects.shop.domain

import com.example.domainobjects.inventory.Inventory
import com.example.domainobjects.product.Product
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "Shop")
data class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String? = null,
    val location: String? = null
) {

    @OneToMany(mappedBy = "shop")
    val inventories: MutableList<Inventory> = mutableListOf()

    fun addProduct(product: Product): Inventory {
        val existingInventory = inventories.firstOrNull { it.product?.id == product.id  }

        return if(existingInventory == null) {
            val inventory = Inventory(
                product = product,
                shop = this,
                quantity = 1
            )
            inventories.add(inventory)
            inventory
        } else {
            existingInventory.increaseQuantity()
            existingInventory
        }
    }

    fun removeProduct(product: Product): Inventory {
        val existingInventory = inventories.firstOrNull { it.product?.id == product.id  }

        return if(existingInventory == null) {
            throw Exception("product is not in the inventory")
        } else {
            if(existingInventory.isQuantityEmpty()) {
                throw Exception("quantity can't go below 0")
            } else {
                existingInventory.decreaseQuantity()
                if(existingInventory.isQuantityEmpty()) {
                   inventories.remove(existingInventory)
                }
                existingInventory
            }
        }
    }
}