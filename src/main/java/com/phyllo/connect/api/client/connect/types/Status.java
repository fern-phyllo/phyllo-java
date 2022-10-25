package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class Status {
  public static final Status ACTIVE = new Status(Value.ACTIVE, "ACTIVE");

  public static final Status INACTIVE = new Status(Value.INACTIVE, "INACTIVE");

  private final Value value;

  private final String string;

  Status(Value value, String string) {
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
      || (other instanceof Status && this.string.equals(((Status) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case ACTIVE:
        return visitor.visitActive();
      case INACTIVE:
        return visitor.visitInactive();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static Status valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "ACTIVE":
        return ACTIVE;
      case "INACTIVE":
        return INACTIVE;
      default:
        return new Status(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    ACTIVE,

    INACTIVE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitActive();

    T visitInactive();

    T visitUnknown(String unknownType);
  }
}
