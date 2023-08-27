package FrameWorkConstants;

import lombok.Getter;

public class FolderPathConstants {

        // IF IT IS NON STATIC WE CAN USE BY CLAS LEVEL

        private   static @Getter final String requestJsonPath="G:\\api project storage\\build\\src\\test\\resources\\jsons\\request.json";
        private   static @Getter  final String responseJsonPath=System.getProperty("user.dir")+"/src/test/resources/";

    }

