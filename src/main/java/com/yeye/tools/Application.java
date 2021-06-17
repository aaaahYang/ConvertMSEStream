package com.yeye.tools;

import com.yeye.tools.config.InitProperties;

import java.io.File;

public class Application {

    public static void main(String[] args) {

        InitProperties properties = new InitProperties();

        File dir = new File(properties.getDir());

        if (!dir.isDirectory()){
            System.err.println("文件路径请输入文件夹");
            return;
        }


        File[] files = dir.listFiles((f,name)->name.contains("video"));

        for (File f : files){
            String prefix = f.getName();

            System.out.println(prefix.indexOf("-",4));

            System.out.println(f.getAbsoluteFile());
        }
    }

}
