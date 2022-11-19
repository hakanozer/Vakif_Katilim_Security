package com.works.controllers

import com.works.entities.Admin
import com.works.services.AdminService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class LoginController( var adminService: AdminService ) {


    @GetMapping("/")
    fun login( ): String {
        return "login";
    }

    @PostMapping("/adminLogin")
    fun adminLogin( @Valid admin:Admin, model:Model ): String {
        var status = adminService.login(admin.email, admin.password)
        println(status)
        model.addAttribute("email", admin.email)
        return "login"
    }

}