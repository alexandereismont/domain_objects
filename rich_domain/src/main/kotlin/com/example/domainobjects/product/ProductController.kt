package com.example.domainobjects.product

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class ProductController(
    val repository: ProductRepository
) {

    @PostMapping
    fun saveProduct(@RequestBody productDto: ProductDto) : Product {
        val product = Product(
            name = productDto.name,
            labels = productDto.labels
        )

        repository.save(product)
        return product
    }


}