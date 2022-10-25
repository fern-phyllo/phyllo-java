package com.phyllo.connect.api.client;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class BasicAuth {
  private final String token;

  private String username = null;

  private String password = null;

  private BasicAuth(String token) {
    this.token = token;
  }

  @JsonValue
  public String getToken() {
    return this.token;
  }

  public final String username() {
    decode();
    return this.username;
  }

  public final String password() {
    decode();
    return this.password;
  }

  void decode() {
    if (this.username == null || this.password == null) {
      byte[] decodedToken = Base64.getDecoder().decode(getToken());
      String credentials = new String(decodedToken, StandardCharsets.UTF_8);
      String[] values = credentials.split(":", 2);
      if (values.length != 2) {
        throw new IllegalStateException("Failed to decode basic token");
      }
      this.username = values[0];
      this.password = values[1];
    }
  }

  @Override
  public String toString() {
    return "Basic " + getToken();
  }

  public static BasicAuth of(String username, String password) {
    String unencodedToken = username + ":" + password;
    return new BasicAuth(Base64.getEncoder().encodeToString(unencodedToken.getBytes()));
  }
}
