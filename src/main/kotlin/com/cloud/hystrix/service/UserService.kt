package com.cloud.hystrix.service

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import org.springframework.stereotype.Service

@Service
class UserService {


    @HystrixCommand(
        fallbackMethod = "userFail",
        commandProperties = [
            HystrixProperty(
                name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            HystrixProperty(
                name="circuitBreaker.requestVolumeThreshold", value="10"),
            HystrixProperty(
                name="circuitBreaker.errorThresholdPercentage", value="50"),
            HystrixProperty(
                name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
            HystrixProperty(
                name="metrics.rollingStats.timeInMilliseconds", value="15000")
        ]
    )
    fun listAll(): List<String>{
        randomSleep()
        return arrayListOf( "id", "id2", "id3" )
    }

    private fun randomSleep(){
        val random = Math.random() * 10
        if( random < 5 ){
            Thread.sleep( 3000 )
        }
    }

    private fun userFail(): List<String>{
        return arrayListOf( "에러발생")
    }
}