package com.yeye.tools.config;

import java.io.IOException;
import java.io.InputStream;
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

        dir = properties.getProperty("dir");
        output = properties.getProperty("output");

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
