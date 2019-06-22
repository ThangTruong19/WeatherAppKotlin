package com.thangtruong19.weatherappkotlin.domain

public interface Command<T>{
    fun execute():T
}