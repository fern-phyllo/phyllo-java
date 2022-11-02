package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class WorkPlatformCategory {
  public static final WorkPlatformCategory MEDIA = new WorkPlatformCategory(Value.MEDIA, "MEDIA");

  public static final WorkPlatformCategory BUSINESS = new WorkPlatformCategory(Value.BUSINESS, "BUSINESS");

  public static final WorkPlatformCategory LIFESTYLE = new WorkPlatformCategory(Value.LIFESTYLE, "LIFESTYLE");

  public static final WorkPlatformCategory ENTERTAINMENT = new WorkPlatformCategory(Value.ENTERTAINMENT, "ENTERTAINMENT");

  public static final WorkPlatformCategory EDUCATION = new WorkPlatformCategory(Value.EDUCATION, "EDUCATION");

  public static final WorkPlatformCategory SOCIAL = new WorkPlatformCategory(Value.SOCIAL, "SOCIAL");

  private final Value value;

  private final String string;

  WorkPlatformCategory(Value value, String string) {
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
      || (other instanceof WorkPlatformCategory && this.string.equals(((WorkPlatformCategory) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case MEDIA:
        return visitor.visitMedia();
      case BUSINESS:
        return visitor.visitBusiness();
      case LIFESTYLE:
        return visitor.visitLifestyle();
      case ENTERTAINMENT:
        return visitor.visitEntertainment();
      case EDUCATION:
        return visitor.visitEducation();
      case SOCIAL:
        return visitor.visitSocial();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static WorkPlatformCategory valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "MEDIA":
        return MEDIA;
      case "BUSINESS":
        return BUSINESS;
      case "LIFESTYLE":
        return LIFESTYLE;
      case "ENTERTAINMENT":
        return ENTERTAINMENT;
      case "EDUCATION":
        return EDUCATION;
      case "SOCIAL":
        return SOCIAL;
      default:
        return new WorkPlatformCategory(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    MEDIA,

    EDUCATION,

    SOCIAL,

    ENTERTAINMENT,

    LIFESTYLE,

    BUSINESS,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitMedia();

    T visitEducation();

    T visitSocial();

    T visitEntertainment();

    T visitLifestyle();

    T visitBusiness();

    T visitUnknown(String unknownType);
  }
}
