package com.example.domainobjects.shop

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository : CrudRepository<Shop, Long>