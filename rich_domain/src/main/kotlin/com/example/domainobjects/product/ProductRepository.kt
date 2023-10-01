package com.example.domainobjects.product

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: CrudRepository<Product, Long>