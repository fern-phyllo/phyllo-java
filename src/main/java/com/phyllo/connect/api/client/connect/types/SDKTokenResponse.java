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
    builder = SDKTokenResponse.Builder.class
)
public final class SDKTokenResponse {
  private final String sdkToken;

  private final String expiresAt;

  private int _cachedHashCode;

  SDKTokenResponse(String sdkToken, String expiresAt) {
    this.sdkToken = sdkToken;
    this.expiresAt = expiresAt;
  }

  @JsonProperty("sdk_token")
  public String getSdkToken() {
    return sdkToken;
  }

  @JsonProperty("expires_at")
  public String getExpiresAt() {
    return expiresAt;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SDKTokenResponse && equalTo((SDKTokenResponse) other);
  }

  private boolean equalTo(SDKTokenResponse other) {
    return sdkToken.equals(other.sdkToken) && expiresAt.equals(other.expiresAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.sdkToken, this.expiresAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SDKTokenResponse{" + "sdkToken: " + sdkToken + ", expiresAt: " + expiresAt + "}";
  }

  public static SdkTokenStage builder() {
    return new Builder();
  }

  public interface SdkTokenStage {
    ExpiresAtStage sdkToken(String sdkToken);

    Builder from(SDKTokenResponse other);
  }

  public interface ExpiresAtStage {
    _FinalStage expiresAt(String expiresAt);
  }

  public interface _FinalStage {
    SDKTokenResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements SdkTokenStage, ExpiresAtStage, _FinalStage {
    private String sdkToken;

    private String expiresAt;

    private Builder() {
    }

    @Override
    public Builder from(SDKTokenResponse other) {
      sdkToken(other.getSdkToken());
      expiresAt(other.getExpiresAt());
      return this;
    }

    @Override
    @JsonSetter("sdk_token")
    public ExpiresAtStage sdkToken(String sdkToken) {
      this.sdkToken = sdkToken;
      return this;
    }

    @Override
    @JsonSetter("expires_at")
    public _FinalStage expiresAt(String expiresAt) {
      this.expiresAt = expiresAt;
      return this;
    }

    @Override
    public SDKTokenResponse build() {
      return new SDKTokenResponse(sdkToken, expiresAt);
    }
  }
}
