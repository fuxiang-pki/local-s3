package com.robothy.s3.rest.utils;

import com.robothy.netty.http.HttpResponse;
import com.robothy.s3.core.util.IdUtils;
import com.robothy.s3.rest.constants.AmzHeaderNames;
import com.robothy.s3.rest.constants.LocalS3Constants;
import io.netty.handler.codec.http.HttpHeaderNames;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalS3 response utils.
 */
public class ResponseUtils {

  /**
   * Add 'date' header.
   *
   * @param response the response to add 'date' header.
   */
  public static void addDateHeader(HttpResponse response) {
    response.putHeader(HttpHeaderNames.DATE.toString(),
        DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneOffset.UTC)));
  }

  /**
   * Add 'x-amz-request-id' header.
   *
   * @param response the response to add 'x-amz-request-id' header.
   */
  public static void addAmzRequestId(HttpResponse response) {
    response.putHeader(AmzHeaderNames.X_AMZ_REQUEST_ID, IdUtils.nextUuid());
  }

  /**
   * Add 'server' header.
   *
   * @param response the response to add 'server' header.
   */
  public static void addServerHeader(HttpResponse response) {
    response.putHeader(HttpHeaderNames.SERVER.toString(), LocalS3Constants.SERVER_NAME);
  }

}
