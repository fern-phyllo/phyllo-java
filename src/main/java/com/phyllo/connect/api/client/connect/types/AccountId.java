package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public final class AccountId {
  private final String value;

  private AccountId(String value) {
    this.value = value;
  }

  @JsonValue
  public String get() {
    return this.value;
  }

  @Override
  public boolean equals(Object other) {
    return this == other || (other instanceof AccountId && this.value.equals(((AccountId) other).value));
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return value;
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static AccountId of(String value) {
    return new AccountId(value);
  }

  public static AccountId valueOf(String value) {
    return of(value);
  }
}
