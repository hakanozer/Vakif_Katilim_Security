package com.works.services

import com.works.entities.Product
import com.works.repositories.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ProductService (var productRepository: ProductRepository) {

    fun add(product: Product) : ResponseEntity<Product> {
        productRepository.save(product)
        return ResponseEntity(product, HttpStatus.OK)
    }

    fun list() : ResponseEntity<List<Product>> {
        return ResponseEntity(productRepository.findAll(), HttpStatus.OK)
    }

}