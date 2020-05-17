package com.samir.main.shop.facturation.web;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FacturationServletTest {

    @Test
    void Given_StringWith2Parameters_When_SplitFunction_Then_CorrectMap() {
        String stringParams = "param1=value11value12&param2=value2";
        HashMap paramsMap = new FacturationServlet().splitParameters(stringParams);
        assertEquals(2,paramsMap.size());
        assertEquals("value11value12",paramsMap.get("param1"));
        assertEquals("value2",paramsMap.get("param2"));
    }

    @Test
    void Given_StringWith1ParamNoValueAnd1OkParam_When_SplitFunction_Then_CorrectMap() {
        String stringParams = "param1=&param2=value2";
        HashMap paramsMap = new FacturationServlet().splitParameters(stringParams);
        assertEquals(1,paramsMap.size());
        assertEquals("value2",paramsMap.get("param2"));
    }

    @Test
    void Given_NoParameters_When_SplitFunction_Then_OK() {
        String stringParams = "test";
        HashMap paramsMap = new FacturationServlet().splitParameters(stringParams);
        assertEquals(0,paramsMap.size());
    }

    @Test
    void Given__When__Then_(){

    }
}