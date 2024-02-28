package com.hm.Dataconverter.controller;

import com.hm.Dataconverter.utils.CsvConverterUtil;
import com.hm.Dataconverter.utils.JsonConverterUtil;
import com.hm.Dataconverter.utils.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@RestController
public class ConversionController {

    @Autowired
    private CsvConverterUtil csvConverter;

    @Autowired
    private JsonConverterUtil jsonConverter;

    @PostMapping("/convert-csv")
    public List<UserPojo> convertCsv(@RequestParam("csvData") String csvData) {
        List<UserPojo> pojos = csvConverter.convertCsvToPojo(new StringReader(csvData), UserPojo.class);
        // Do something with the converted POJOs
        return pojos;
    }

    @PostMapping("/convert-json")
    public UserPojo convertJson(@RequestParam("jsonData") String jsonData) throws IOException {
        UserPojo pojo = jsonConverter.convertJsonToPojo(jsonData, UserPojo.class);
        // Do something with the converted POJO
        return pojo;
    }
}
