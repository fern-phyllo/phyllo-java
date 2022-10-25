package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class MonitoringType {
  public static final MonitoringType STANDARD = new MonitoringType(Value.STANDARD, "STANDARD");

  public static final MonitoringType ON_DEMAND = new MonitoringType(Value.ON_DEMAND, "ON_DEMAND");

  private final Value value;

  private final String string;

  MonitoringType(Value value, String string) {
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
      || (other instanceof MonitoringType && this.string.equals(((MonitoringType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case STANDARD:
        return visitor.visitStandard();
      case ON_DEMAND:
        return visitor.visitOnDemand();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static MonitoringType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "STANDARD":
        return STANDARD;
      case "ON_DEMAND":
        return ON_DEMAND;
      default:
        return new MonitoringType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    STANDARD,

    ON_DEMAND,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitStandard();

    T visitOnDemand();

    T visitUnknown(String unknownType);
  }
}
