package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TestRunner implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper= Jackson2ObjectMapperBuilder.json().build();
        JsonNode jsonNode = mapper.readTree(TestRunner.class.getClassLoader().getResourceAsStream("a.json"));
        JsonNode a = jsonNode.findValue("a");
        System.out.println(a.asText());
        ObjectNode on=(ObjectNode)jsonNode;
        on.put("a","bbbs");
        System.out.println(jsonNode.findValue("a").asText());
    }
}
