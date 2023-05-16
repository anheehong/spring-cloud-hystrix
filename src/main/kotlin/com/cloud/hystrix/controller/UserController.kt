package com.cloud.hystrix.controller

import com.cloud.hystrix.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ajax/user")
class UserController(
    @Autowired private val userService: UserService
) {

    @GetMapping("/")
    fun listAll(): List<String>{
        return userService.listAll()
    }

}