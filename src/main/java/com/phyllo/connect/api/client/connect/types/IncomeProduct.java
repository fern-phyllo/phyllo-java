package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = IncomeProduct.Builder.class
)
public final class IncomeProduct {
  private final boolean isSupported;

  private int _cachedHashCode;

  IncomeProduct(boolean isSupported) {
    this.isSupported = isSupported;
  }

  @JsonProperty("is_supported")
  public boolean getIsSupported() {
    return isSupported;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IncomeProduct && equalTo((IncomeProduct) other);
  }

  private boolean equalTo(IncomeProduct other) {
    return isSupported == other.isSupported;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.isSupported);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "IncomeProduct{" + "isSupported: " + isSupported + "}";
  }

  public static IsSupportedStage builder() {
    return new Builder();
  }

  public interface IsSupportedStage {
    _FinalStage isSupported(boolean isSupported);

    Builder from(IncomeProduct other);
  }

  public interface _FinalStage {
    IncomeProduct build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IsSupportedStage, _FinalStage {
    private boolean isSupported;

    private Builder() {
    }

    @Override
    public Builder from(IncomeProduct other) {
      isSupported(other.getIsSupported());
      return this;
    }

    @Override
    @JsonSetter("is_supported")
    public _FinalStage isSupported(boolean isSupported) {
      this.isSupported = isSupported;
      return this;
    }

    @Override
    public IncomeProduct build() {
      return new IncomeProduct(isSupported);
    }
  }
}
