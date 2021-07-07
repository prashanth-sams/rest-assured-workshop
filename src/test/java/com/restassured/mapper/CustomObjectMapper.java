package com.restassured.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.restassured.deserialization.pojo.UserList;
import io.restassured.internal.mapping.Jackson2Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomObjectMapper {

    public static final String BASE_URL = "http://0.0.0.0:3000/users";

    @Test
    public void customObjTest() {

        io.restassured.mapper.ObjectMapper random = new Jackson2Mapper(new Jackson2ObjectMapperFactory() {
            @Override
            public ObjectMapper create(Type type, String s) {
                ObjectMapper om = new ObjectMapper();
                om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return om;
            }
        });

        UserList ul[] = get(BASE_URL).as(UserList[].class, random);
        assertEquals(ul[0].getName(), "Prashanth");
    }

    private Jackson2Mapper getMapper() {
        return new Jackson2Mapper(new Jackson2ObjectMapperFactory() {
            @Override
            public ObjectMapper create(Type type, String s) {
                ObjectMapper om = new ObjectMapper();
                om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return om;
            }
        });
    }

    private Jackson2Mapper getMapperLambda() {
        return new Jackson2Mapper((type, s) -> {
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return om;
        });
    }

}
