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
    builder = CreateUserRequest.Builder.class
)
public final class CreateUserRequest {
  private final String name;

  private final ExternalId externalId;

  private int _cachedHashCode;

  CreateUserRequest(String name, ExternalId externalId) {
    this.name = name;
    this.externalId = externalId;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("external_id")
  public ExternalId getExternalId() {
    return externalId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateUserRequest && equalTo((CreateUserRequest) other);
  }

  private boolean equalTo(CreateUserRequest other) {
    return name.equals(other.name) && externalId.equals(other.externalId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.externalId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateUserRequest{" + "name: " + name + ", externalId: " + externalId + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    ExternalIdStage name(String name);

    Builder from(CreateUserRequest other);
  }

  public interface ExternalIdStage {
    _FinalStage externalId(String externalId);
  }

  public interface _FinalStage {
    CreateUserRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements NameStage, ExternalIdStage, _FinalStage {
    private String name;

    private ExternalId externalId;

    private Builder() {
    }

    @Override
    public Builder from(CreateUserRequest other) {
      name(other.getName());
      externalId(other.getExternalId());
      return this;
    }

    @Override
    @JsonSetter("name")
    public ExternalIdStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("external_id")
    public _FinalStage externalId(String externalId) {
      this.externalId = externalId;
      return this;
    }

    @Override
    public CreateUserRequest build() {
      return new CreateUserRequest(name, externalId);
    }
  }
}
