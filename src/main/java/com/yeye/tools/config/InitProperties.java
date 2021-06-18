package com.yeye.tools.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class InitProperties {

    private String dir;

    private String output;

    public InitProperties(){
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("application.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dir = new String(properties.getProperty("dir").getBytes(StandardCharsets.ISO_8859_1),"GBK");
            output = new String(properties.getProperty("output").getBytes(StandardCharsets.ISO_8859_1),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
