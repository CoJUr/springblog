//package com.example.codeup.springblog.model.demo;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//
//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.json.JsonObject;
//import javax.json.JsonReader;
//import javax.json.JsonReaderFactory;
//import javax.json.JsonValue;
//import java.io.IOException;
//
//public class EmployeeJSONReader {
//
//    public static final String JSON_FILE= "employee.txt";
//
//    public static void main(String[] args) throws IOException {
//
//
////        create json reader object
//        JsonReader jsonReader = Json.createReader(fis);
//
//                    //        could create JsonReader from factory as well like this
//                    //        JsonReaderFactory factory = Json.createReaderFactory(null);
//                    //        jsonReader = factory.createReader(fis);
//
//
////        get jsonObject from reader
//        JsonObject jsonObject = jsonReader.readObject();
//
////        close reader and IO resources
//        jsonReader.close();
//        fis.close();
//
////        get data from jsonObject and create employee bean
//        Employee emp = new Employee();
//        emp.setId(jsonObject.getInt("id"));
//        emp.setName(jsonObject.getString("name"));
//        emp.setPermanent(jsonObject.getBoolean("permanent"));
//        emp.setRole(jsonObject.getString("role"));
//
////        reading arrays from json
//        JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");
//        long[] numbers = new long[jsonArray.size()];
//        int index = 0;
//        for (JsonValue value : jsonArray) {
//            numbers[index++] = Long.parseLong(value.toString());
//        }
//        emp.setPhoneNumbers(numbers);
//
//
////        read inner object from json object
//        JsonObject innerJsonObject = jsonObject.getJsonObject("address");
//        Address address = new Address();
//        address.setStreet(innerJsonObject.getString("street"));
//        address.setCity(innerJsonObject.getString("city"));
//        address.setZipcode(innerJsonObject.getInt("zipcode"));
//        emp.setAddress(address);
//
//
////        print employee bean
//        System.out.println(emp);
//
//
////        get output like this:
////        ***** Employee Details ****
////        ID=123
////        Name=John Doe
////        Permanent=true
////        Role=Manager
////        Phone Numbers=[9988664422, 1234567890]
////        Address=123 Main St. Anytown, CA 12345
////        ***********************************************************
//
//    }
//}
