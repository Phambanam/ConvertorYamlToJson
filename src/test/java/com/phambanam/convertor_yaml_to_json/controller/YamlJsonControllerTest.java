package com.phambanam.convertor_yaml_to_json.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.phambanam.convertor_yaml_to_json.ConvertorYamlToJsonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ConvertorYamlToJsonApplication.class})
public class YamlJsonControllerTest extends AbstractTest {
    @Autowired
    private YamlJsonController controller;
    @Autowired
    @Qualifier("yamlMapper")
    private YAMLMapper yamlMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void convert1JsonToYaml() throws Exception {
        String input = readStringFrom("test1.json");
        final JsonNode jsonNode = objectMapper.readTree(input.replaceAll("\\t", " "));
        String result = yamlMapper.writeValueAsString(jsonNode);
        JsonNode expectedOutput = readYamlFrom("test1.yml");
        assertThat(yamlMapper.readTree(result), is(expectedOutput));
    }

    @Test
    public void convert2JsonToYaml() throws Exception {
        String input = readStringFrom("test2.json");
        final JsonNode jsonNode = objectMapper.readTree(input.replaceAll("\\t", " "));
        String result = yamlMapper.writeValueAsString(jsonNode);
        JsonNode expectedOutput = readYamlFrom("test2.yml");
        assertThat(yamlMapper.readTree(result), equalTo(expectedOutput));
    }
    @Test
    public void convert1YamlToJson() throws Exception {
        String input = readStringFrom("test1.yml");
        JsonNode jsonNode = yamlMapper.readValue(input, JsonNode.class);
        String result = objectMapper.writeValueAsString(jsonNode);
        JsonNode expectedOutput = readJsonFrom("test1.json");
        assertThat(yamlMapper.readTree(result), is(expectedOutput));
    }

    @Test
    public void convert2YamlToJson() throws Exception {
        String input = readStringFrom("test2.yml");
        JsonNode jsonNode = yamlMapper.readValue(input, JsonNode.class);
        String result = objectMapper.writeValueAsString(jsonNode);
        JsonNode expectedOutput = readJsonFrom("test2.json");
        assertThat(yamlMapper.readTree(result), equalTo(expectedOutput));
    }
    private JsonNode readYamlFrom(String file) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/" + file)), "UTF-8");
        return yamlMapper.readTree(content);
    }
    private JsonNode readJsonFrom(String file) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/" + file)), "UTF-8");
        return objectMapper.readTree(content);
    }
}