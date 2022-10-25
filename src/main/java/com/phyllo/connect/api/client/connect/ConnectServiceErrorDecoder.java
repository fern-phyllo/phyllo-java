package com.phyllo.connect.api.client.connect;

import com.fern.java.jackson.ClientObjectMappers;
import com.phyllo.connect.api.client.connect.exceptions.CreateSdkTokenException;
import com.phyllo.connect.api.client.connect.exceptions.CreateUserException;
import com.phyllo.connect.api.client.connect.exceptions.DisconnectAccountException;
import com.phyllo.connect.api.client.connect.exceptions.GetAccountException;
import com.phyllo.connect.api.client.connect.exceptions.GetAllAccountsException;
import com.phyllo.connect.api.client.connect.exceptions.GetAllUsersException;
import com.phyllo.connect.api.client.connect.exceptions.GetAllWorkPlatformsException;
import com.phyllo.connect.api.client.connect.exceptions.GetUserByExernalIdException;
import com.phyllo.connect.api.client.connect.exceptions.GetUserException;
import com.phyllo.connect.api.client.connect.exceptions.GetWorkPlatformException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class ConnectServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("getWorkPlatform")) {
        return decodeException(response, GetWorkPlatformException.class);
      }
      if (methodKey.contains("getAllWorkPlatforms")) {
        return decodeException(response, GetAllWorkPlatformsException.class);
      }
      if (methodKey.contains("getUser")) {
        return decodeException(response, GetUserException.class);
      }
      if (methodKey.contains("getAllUsers")) {
        return decodeException(response, GetAllUsersException.class);
      }
      if (methodKey.contains("createUser")) {
        return decodeException(response, CreateUserException.class);
      }
      if (methodKey.contains("getUserByExernalId")) {
        return decodeException(response, GetUserByExernalIdException.class);
      }
      if (methodKey.contains("createSDKToken")) {
        return decodeException(response, CreateSdkTokenException.class);
      }
      if (methodKey.contains("getAccount")) {
        return decodeException(response, GetAccountException.class);
      }
      if (methodKey.contains("getAllAccounts")) {
        return decodeException(response, GetAllAccountsException.class);
      }
      if (methodKey.contains("disconnectAccount")) {
        return decodeException(response, DisconnectAccountException.class);
      }
    }
    catch (IOException e) {
    }
    return new RuntimeException("Failed to read response body. Received status " + response.status() + " for method " + methodKey);
  }

  private static <T extends Exception> Exception decodeException(Response response, Class<T> clazz)
      throws IOException {
    return ClientObjectMappers.JSON_MAPPER.reader().withAttribute("statusCode", response.status()).readValue(response.body().asInputStream(), clazz);
  }
}
