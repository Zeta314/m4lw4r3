package com.zeta314.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
    public static String readFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("The provided path does not exist.");
        }

        if (!file.isFile()) {
            throw new IOException("The provided path does not lead to a file.");
        }

        return Files.readString(file.toPath());
    }

    public static byte[] readBytes(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("The provided path does not exist.");
        }

        if (!file.isFile()) {
            throw new IOException("The provided path does not lead to a file.");
        }

        return Files.readAllBytes(file.toPath());
    }
}
