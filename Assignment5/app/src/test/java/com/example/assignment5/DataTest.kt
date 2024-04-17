package com.example.assignment5

import org.junit.Assert
import org.junit.Test

class DataTest(private var activity: MainActivity) {

    @Test
    fun name_isString() {
        //Assemble
        val subject = DataManager(activity)
        //Act
        val result = subject.name
        //Assert
        Assert.assertEquals(String(), result)

    }

}