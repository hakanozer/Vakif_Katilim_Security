package com.works.restcontrollers

import com.works.entities.Product
import com.works.services.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductRestController(var productService: ProductService) {

    @PostMapping("/add")
    fun add(@Valid @RequestBody product: Product): ResponseEntity<Product> {
        return productService.add(product)
    }

    @GetMapping("/list")
    fun list(): ResponseEntity<List<Product>> {
        return productService.list()
    }

}