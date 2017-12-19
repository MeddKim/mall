package com.doge.container;

import jodd.petite.meta.PetiteBean;
import jodd.petite.meta.PetiteInject;

@PetiteBean
public class Foo {

    @PetiteInject
    ServiceTwo serviceTwo;

}
