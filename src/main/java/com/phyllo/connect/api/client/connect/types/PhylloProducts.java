package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class PhylloProducts {
  public static final PhylloProducts IDENTITY = new PhylloProducts(Value.IDENTITY, "IDENTITY");

  public static final PhylloProducts INCOME = new PhylloProducts(Value.INCOME, "INCOME");

  public static final PhylloProducts IDENTITY_AUDIENCE = new PhylloProducts(Value.IDENTITY_AUDIENCE, "IDENTITY.AUDIENCE");

  public static final PhylloProducts ENGAGEMENT_AUDIENCE = new PhylloProducts(Value.ENGAGEMENT_AUDIENCE, "ENGAGEMENT.AUDIENCE");

  public static final PhylloProducts ENGAGEMENT = new PhylloProducts(Value.ENGAGEMENT, "ENGAGEMENT");

  private final Value value;

  private final String string;

  PhylloProducts(Value value, String string) {
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
      || (other instanceof PhylloProducts && this.string.equals(((PhylloProducts) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case IDENTITY:
        return visitor.visitIdentity();
      case INCOME:
        return visitor.visitIncome();
      case IDENTITY_AUDIENCE:
        return visitor.visitIdentityAudience();
      case ENGAGEMENT_AUDIENCE:
        return visitor.visitEngagementAudience();
      case ENGAGEMENT:
        return visitor.visitEngagement();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static PhylloProducts valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "IDENTITY":
        return IDENTITY;
      case "INCOME":
        return INCOME;
      case "IDENTITY.AUDIENCE":
        return IDENTITY_AUDIENCE;
      case "ENGAGEMENT.AUDIENCE":
        return ENGAGEMENT_AUDIENCE;
      case "ENGAGEMENT":
        return ENGAGEMENT;
      default:
        return new PhylloProducts(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    IDENTITY,

    ENGAGEMENT,

    INCOME,

    ENGAGEMENT_AUDIENCE,

    IDENTITY_AUDIENCE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitIdentity();

    T visitEngagement();

    T visitIncome();

    T visitEngagementAudience();

    T visitIdentityAudience();

    T visitUnknown(String unknownType);
  }
}
