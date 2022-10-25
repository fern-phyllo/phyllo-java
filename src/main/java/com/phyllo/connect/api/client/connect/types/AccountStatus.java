package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class AccountStatus {
  public static final AccountStatus CONNECTED = new AccountStatus(Value.CONNECTED, "CONNECTED");

  public static final AccountStatus SESSION_EXPIRED = new AccountStatus(Value.SESSION_EXPIRED, "SESSION_EXPIRED");

  public static final AccountStatus NOT_CONNECTED = new AccountStatus(Value.NOT_CONNECTED, "NOT_CONNECTED");

  private final Value value;

  private final String string;

  AccountStatus(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof AccountStatus && this.string.equals(((AccountStatus) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case CONNECTED:
        return visitor.visitConnected();
      case SESSION_EXPIRED:
        return visitor.visitSessionExpired();
      case NOT_CONNECTED:
        return visitor.visitNotConnected();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static AccountStatus valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "CONNECTED":
        return CONNECTED;
      case "SESSION_EXPIRED":
        return SESSION_EXPIRED;
      case "NOT_CONNECTED":
        return NOT_CONNECTED;
      default:
        return new AccountStatus(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    CONNECTED,

    NOT_CONNECTED,

    SESSION_EXPIRED,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitConnected();

    T visitNotConnected();

    T visitSessionExpired();

    T visitUnknown(String unknownType);
  }
}
