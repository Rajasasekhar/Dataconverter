package com.hm.Dataconverter.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class CsvConverterUtil {

    /*public UserPojo csvToPojo(String csvFileLoc) throws FileNotFoundException {
        List<UserPojo> beans=new CsvToBeanBuilder<UserPojo>(new FileReader(csvFileLoc)).withType(UserPojo.class).build().parse();
        UserPojo upojo=new UserPojo();
        for(UserPojo pojo : beans){
            upojo.setId(pojo.getId());
            upojo.setUserName(pojo.getUserName());
            upojo.setEmail(pojo.getEmail());
            upojo.setPassword(pojo.getPassword());
            return upojo;
        }
     return upojo;
    }*/

    public <T> List<T> convertCsvToPojo(Reader reader, Class<T> clazz) {
        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.parse();
    }

    public UserPojo jsonToPojo(String jsonFilLoc) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        List<UserPojo> beans=objectMapper.readValue(new File("jsonFilLoc"), objectMapper.getTypeFactory().constructCollectionType(List.class, UserPojo.class));
        UserPojo jsonToPojo=new UserPojo();
        for(UserPojo pojo : beans){
            jsonToPojo.setId(pojo.getId());
            jsonToPojo.setUserName(pojo.getUserName());
            jsonToPojo.setEmail(pojo.getEmail());
            jsonToPojo.setPassword(pojo.getPassword());
            return jsonToPojo;
        }
        return jsonToPojo;
    }
}
