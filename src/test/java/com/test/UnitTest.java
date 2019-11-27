package com.test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import com.home.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UnitTest {
    @Test
    public void testExample() throws IOException {
        File inputFile = new File("src/test/java/com/test/input");
        File outputFile = new File("src/test/java/com/test/output");
        InputStream inputStream = new FileInputStream(inputFile);
        Path p = Paths.get(outputFile.getAbsolutePath());
        byte[] outputBytes = Files.readAllBytes(p);
        assertArrayEquals(outputBytes, Main.doHomework(inputStream).getBytes());
    }
}