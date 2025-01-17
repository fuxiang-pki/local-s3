package com.robothy.s3.rest;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class LocalS3Test {

  @Test
  void start() throws IOException {
    LocalS3 localS3 = LocalS3.builder()
        .port(19090)
        .build();
    localS3.start();
    localS3.shutdown();

    Path tempDirectory = Files.createTempDirectory("local-s3");
    localS3 = LocalS3.builder()
        .port(19090)
        .dataDirectory(tempDirectory)
        .build();
    localS3.start();
    localS3.shutdown();
  }

}