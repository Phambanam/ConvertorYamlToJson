package com.phambanam.convertor_yaml_to_json.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import com.phambanam.convertor_yaml_to_json.utils.JsonFormatter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Objects;

    @Controller
    public class YamlJsonController {

        private final ObjectMapper objectMapper;
        private final YAMLMapper yamlMapper;


        public YamlJsonController(final ObjectMapper objectMapper, final  @Qualifier("yamlMapper") YAMLMapper yamlMapper) {
            this.objectMapper = Objects.requireNonNull(objectMapper, "ObjectMapper is null");
            this.yamlMapper = Objects.requireNonNull(yamlMapper, "YAMLMapper is null");
        }
       @GetMapping(value = "/home")
       public String home() {
            return "yaml2json";
        }
        @PostMapping(value = "/yaml2json", consumes = "application/x-www-form-urlencoded", produces = "application/json")
        public String convertYamlToJson(@NotNull  @NotEmpty  final String yaml, Model model) throws IOException, JSONException {
            JsonNode jsonNode = yamlMapper.readValue(yaml, JsonNode.class);
            System.out.println(objectMapper.writeValueAsString(jsonNode));
            String jsonResult = objectMapper.writeValueAsString(jsonNode);
            model.addAttribute("modelYaml",yaml);
             model.addAttribute("modelJson", JsonFormatter.format(new JSONObject(jsonResult)));
            return "yaml2json";
        }


}
