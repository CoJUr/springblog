package com.example.codeup.springblog.model.demo;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.json.*;


public class EmployeeJSONWriter {

    public static void main(String[] args) throws FileNotFoundException {

        Employee emp = createEmployee();

        JsonObjectBuilder empBuilder = Json.createObjectBuilder();
        JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
        JsonObjectBuilder phoneNumBuilder = Json.createObjectBuilder();

        for (long phone : emp.getPhoneNumbers()) {
            phoneNumBuilder.add("phone", phone);
        }

        addressBuilder.add("street", emp.getAddress().getStreet())
                .add("city", emp.getAddress().getCity())
                .add("zipcode", emp.getAddress().getZipcode());

        empBuilder.add("id", emp.getId())
                .add("name", emp.getName())
                .add("permanent", emp.isPermanent())
                .add("role", emp.getRole());

        empBuilder.add("phoneNumbers", phoneNumBuilder);
        empBuilder.add("address", addressBuilder);

        JsonObject empJsonObject = empBuilder.build();

        System.out.println("Employee Json String\n" + empJsonObject);

//        write to file
        OutputStream os = new FileOutputStream("emp.txt");
        JsonWriter jsonWriter = Json.createWriter(os);

        /*      can get JsonWrite from factory also
              JsonWriterFactory factory = Json.createWriterFactory(null);
                jsonWriter = factory.createWriter(os);       */


        jsonWriter.writeObject(empJsonObject);
        jsonWriter.close();
    }

    public static Employee createEmployee() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[] {123456, 98765});
        emp.setRole("Programmer");

        Address add = new Address();
        add.setCity("Boston");
        add.setStreet("Main Street");
        add.setZipcode(23487);
        emp.setAddress(add);

        return emp;
    }

//    get output like this:
//    Employee Json String
//    {"id":1,"name":"John","permanent":false,"role":"Programmer","phoneNumbers":[{"phone":123456},{"phone":98765}],
//    "address":{"street":"Main Street","city":"Boston","zipcode":23487}}    JSON object also saved in emp.txt
}
