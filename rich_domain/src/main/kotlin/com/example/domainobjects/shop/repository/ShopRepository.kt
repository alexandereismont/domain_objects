package com.example.domainobjects.shop.repository

import com.example.domainobjects.shop.domain.Shop
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository : CrudRepository<Shop, Long>