package com.example.domainobjects.inventory

import com.example.domainobjects.product.Product
import com.example.domainobjects.shop.domain.Shop
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
data class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "shop_id")
    val product: Product? = null,
    @ManyToOne
    @JoinColumn(name = "product_id")
    val shop: Shop? = null,
    private var quantity: Int? = 0,
    @Column(name = "created_at")
    val createAt: LocalDate = LocalDate.now(),
    @Column(name = "updated_at")
    private var updatedAt: LocalDate = LocalDate.now()
) {

    fun increaseQuantity() {
        this.quantity = this.quantity!! + 1
        this.updatedAt = LocalDate.now()
    }

    fun decreaseQuantity() {
        this.quantity = this.quantity!! + 1
        this.updatedAt = LocalDate.now()
    }

    fun isQuantityEmpty() = quantity == 0

}