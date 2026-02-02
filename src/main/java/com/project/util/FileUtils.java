package com.project.util;

import java.io.*;

public class FileUtils {

    public static BufferedReader reader(String file) throws IOException {
        return new BufferedReader(new FileReader(file));
    }

    public static BufferedWriter writer(String file) throws IOException {
        return new BufferedWriter(new FileWriter(file));
    }

}
