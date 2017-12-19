package com.doge.container;

import jodd.petite.meta.PetiteBean;

@PetiteBean
public class ServiceTwo {

    public void hello(){
        System.out.println("你好");
    }
}
