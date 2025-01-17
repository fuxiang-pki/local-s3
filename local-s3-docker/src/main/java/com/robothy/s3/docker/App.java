package com.robothy.s3.docker;

import com.robothy.s3.rest.LocalS3;
import com.robothy.s3.rest.bootstrap.Mode;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

  private static final String MODE = "MODE";

  public static void main(String[] args) {
    if (System.getenv(MODE) == null) {
      log.info("\"MODE\" is not specified; use the default value \"PERSISTENCE\"");
    }

    final String mode = Optional.ofNullable(System.getenv(MODE)).orElse(Mode.PERSISTENCE.name());
    if (Arrays.stream(Mode.values()).noneMatch(m -> m.name().equalsIgnoreCase(mode))) {
      log.error("\"{}\" is not a valid mode. Valid values are {}", mode, Mode.values());
      System.exit(1);
    }

    log.info("Run LocalS3 in {} mode.", mode);

    LocalS3.Builder builder = LocalS3.builder().port(80);
    if (Mode.valueOf(mode.toUpperCase()) == Mode.PERSISTENCE) {
      builder.dataDirectory(Paths.get("/data"));
    }

    builder.build().start();
  }

}
