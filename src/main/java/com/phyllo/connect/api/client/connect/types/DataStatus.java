package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class DataStatus {
  public static final DataStatus PARTIAL_SYNCED = new DataStatus(Value.PARTIAL_SYNCED, "PARTIAL_SYNCED");

  public static final DataStatus IN_PROGRESS = new DataStatus(Value.IN_PROGRESS, "IN_PROGRESS");

  public static final DataStatus NOT_SUPPORTED = new DataStatus(Value.NOT_SUPPORTED, "NOT_SUPPORTED");

  public static final DataStatus SYNCED = new DataStatus(Value.SYNCED, "SYNCED");

  public static final DataStatus NOT_SYNCED = new DataStatus(Value.NOT_SYNCED, "NOT_SYNCED");

  private final Value value;

  private final String string;

  DataStatus(Value value, String string) {
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
      || (other instanceof DataStatus && this.string.equals(((DataStatus) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case PARTIAL_SYNCED:
        return visitor.visitPartialSynced();
      case IN_PROGRESS:
        return visitor.visitInProgress();
      case NOT_SUPPORTED:
        return visitor.visitNotSupported();
      case SYNCED:
        return visitor.visitSynced();
      case NOT_SYNCED:
        return visitor.visitNotSynced();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static DataStatus valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "PARTIAL_SYNCED":
        return PARTIAL_SYNCED;
      case "IN_PROGRESS":
        return IN_PROGRESS;
      case "NOT_SUPPORTED":
        return NOT_SUPPORTED;
      case "SYNCED":
        return SYNCED;
      case "NOT_SYNCED":
        return NOT_SYNCED;
      default:
        return new DataStatus(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    SYNCED,

    IN_PROGRESS,

    NOT_SUPPORTED,

    NOT_SYNCED,

    PARTIAL_SYNCED,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitSynced();

    T visitInProgress();

    T visitNotSupported();

    T visitNotSynced();

    T visitPartialSynced();

    T visitUnknown(String unknownType);
  }
}
