package FrameWorkConstants;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadAndWriteJsonConstants {

    private ReadAndWriteJsonConstants(){}

    @SneakyThrows
    public static String readJsonAndGetAsString(String filepath) {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
    @SneakyThrows
    public static void  storeStringJson(String filepath, Response res) {
        Files.write(Paths.get(filepath),res.asByteArray());

    }
}
