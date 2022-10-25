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
    builder = EngagementProduct.Builder.class
)
public final class EngagementProduct {
  private final boolean isSupported;

  private final Audience audience;

  private int _cachedHashCode;

  EngagementProduct(boolean isSupported, Audience audience) {
    this.isSupported = isSupported;
    this.audience = audience;
  }

  @JsonProperty("is_supported")
  public boolean getIsSupported() {
    return isSupported;
  }

  @JsonProperty("audience")
  public Audience getAudience() {
    return audience;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EngagementProduct && equalTo((EngagementProduct) other);
  }

  private boolean equalTo(EngagementProduct other) {
    return isSupported == other.isSupported && audience.equals(other.audience);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.isSupported, this.audience);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EngagementProduct{" + "isSupported: " + isSupported + ", audience: " + audience + "}";
  }

  public static IsSupportedStage builder() {
    return new Builder();
  }

  public interface IsSupportedStage {
    AudienceStage isSupported(boolean isSupported);

    Builder from(EngagementProduct other);
  }

  public interface AudienceStage {
    _FinalStage audience(Audience audience);
  }

  public interface _FinalStage {
    EngagementProduct build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IsSupportedStage, AudienceStage, _FinalStage {
    private boolean isSupported;

    private Audience audience;

    private Builder() {
    }

    @Override
    public Builder from(EngagementProduct other) {
      isSupported(other.getIsSupported());
      audience(other.getAudience());
      return this;
    }

    @Override
    @JsonSetter("is_supported")
    public AudienceStage isSupported(boolean isSupported) {
      this.isSupported = isSupported;
      return this;
    }

    @Override
    @JsonSetter("audience")
    public _FinalStage audience(Audience audience) {
      this.audience = audience;
      return this;
    }

    @Override
    public EngagementProduct build() {
      return new EngagementProduct(isSupported, audience);
    }
  }
}
