package com.works.restcontrollers

import com.works.entities.Admin
import com.works.entities.Product
import com.works.services.AdminService
import com.works.services.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductRestController(var productService: ProductService, var adminService: AdminService) {

    @PostMapping("/add")
    fun add(@Valid @RequestBody product: Product): ResponseEntity<Product> {
        return productService.add(product)
    }

    @GetMapping("/list")
    fun list(): ResponseEntity<List<Product>> {
        return productService.list()
    }

    @PostMapping("/adminLogin")
    fun adminLogin(@Valid @RequestBody admin: Admin, req: HttpServletRequest): ResponseEntity<Any> {
        var status = adminService.login(admin.email, admin.password)
        if ( status ) {
            req.getSession().setAttribute("admin", admin.email)
            return ResponseEntity("{status: true}", HttpStatus.OK)
        }else {
            return ResponseEntity("Login Fail", HttpStatus.BAD_REQUEST)
        }
    }

}