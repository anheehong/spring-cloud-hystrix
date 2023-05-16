package com.cloud.hystrix

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker

@SpringBootApplication
@EnableCircuitBreaker
class SpringCloudHystrixApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudHystrixApplication>(*args)
}
