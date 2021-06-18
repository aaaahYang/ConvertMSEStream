package com.yeye.tools;

import com.yeye.tools.config.InitProperties;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Application {

    private final static String AUDIO = "audio";

    public static void main(String[] args) {

        InitProperties properties = new InitProperties();

        File dir = new File(properties.getDir());

        if (!dir.isDirectory()){
            System.err.println("文件路径请输入文件夹");
            return;
        }




        File[] files = dir.listFiles((f,name)->name.endsWith(".mp4"));

        for (File f : files){

            String prefix = f.getName();
//            Integer idx = prefix.indexOf("video");
//            System.out.println(idx);
//            String s = prefix.substring(0,idx);
//            System.out.println(s);
//            System.out.println("prefix"+prefix);
            Path p = Paths.get(f.toURI());

            System.out.println(p.getFileName());
            System.out.println(p.getParent());


            try {
                Path path = Files.walkFileTree(Paths.get("d:","temp"),new SimpleFileVisitor<Path>(){
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                        System.out.println(s);
                        System.out.println(file.endsWith("result.mp4"));
                        System.out.println(file.toString().endsWith("mp4"));
                        if (file.toString().endsWith("mp4")){
                            System.out.println("已经找到文件："+file);
                        }
                        System.out.println("正在访问："+file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult preVisitDirectory(Path d, BasicFileAttributes attrs) throws IOException {

                        if (d.equals(Paths.get("d:","temp"))){
                            return FileVisitResult.CONTINUE;
                        }
                        return FileVisitResult.SKIP_SUBTREE;
//                        return super.preVisitDirectory(dir, attrs);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

//            System.out.println(prefix.indexOf("-",4));

            System.out.println(f.getAbsoluteFile());
        }
    }

}
