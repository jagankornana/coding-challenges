package com.hackerearth.codemonk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.StringTokenizer;

public class FileStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedReader fileObj = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String filePath = br.readLine();
            fileObj = new BufferedReader(new FileReader(filePath));
            String str;
            int numOfLines = 0;
            int numOfWords = 0;
            int numOfChars = 0;
            Path path = Paths.get(filePath);
            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
            StringTokenizer st;
            while ((str = fileObj.readLine()) != null) {
                numOfLines++;
                numOfChars = numOfChars + str.length() + 1;
                st = new StringTokenizer(str, "[ \t]+");
                while (st.hasMoreTokens()) {
                    st.nextToken();
                    numOfWords++;
                }
            }

            System.out.println(numOfLines);
            System.out.println(numOfWords);
            System.out.println(numOfChars);
            System.out.println(lastModifiedTime);

        } catch (NumberFormatException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
            assert fileObj != null;
            fileObj.close();
        }

    }
}
