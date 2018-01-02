package com.doge.eight.seven;

import com.doge.eight.five.Trader;
import com.doge.eight.five.Transaction;
import lombok.Data;
import org.junit.Test;

import java.util.Optional;

public class OptTest {

    @Test
    public void OptTe(){
        Trader trader = new Trader("展示","上海");
        Optional<Trader> optTrader = Optional.ofNullable(trader);
        System.out.println(optTrader.map(Trader::getName).orElse("测试"));

        Optional<Trader> optional = getTrader(null);

        System.out.println(optional.map(Trader::getName).orElse("空值"));

    }

    public Optional<Trader> getTrader(Trader trader){
//        return Optional.of(trader);
        return Optional.ofNullable(trader);
    }

    @Test
    public void multOptTest(){
        Person person = new Person();
        person.setCar(null);

//        Optional<Person> optional = Optional.ofNullable(person);
        Optional<Person> optional = getPerson(person);
        //错误 ： optPerson的getCar返回Optional<Car> 则map操作了一个Option<Option<Car>>对象
//        Optional<String> name = optional.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName);
//        System.out.println(optional.flatMap(Person::getCar)
//                .flatMap(Car::getInsurance)
//                .map(Insurance::getName)
//                .orElse("你好"));

        System.out.println(optional.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown"));
    }

    public Optional<Person> getPerson(Person person){
        return Optional.ofNullable(person);
    }


    @Data
    public static class Person{
        private Optional<Car> car;

        public Optional<Car> getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = Optional.ofNullable(car);
        }
    }
    @Data
    public static class Car{
        private Optional<Insurance> insurance;

    }
    @Data
    public class Insurance{
        private String name;
    }


}
