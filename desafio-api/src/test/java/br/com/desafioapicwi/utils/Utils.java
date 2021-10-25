package br.com.desafioapicwi.utils;

public class Utils {

    public static String getSchemaBasePath(String pack, String nameSchema){
        return System.getProperty("user.dir")
                    + "/src/test/java/br/com/desafioapicwi/"
                    + pack
                    +"/schema/"
                    + nameSchema
                    + ".json";
    }
}
