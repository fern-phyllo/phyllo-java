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
    builder = UserAttribute.Builder.class
)
public final class UserAttribute implements IUserAttribute {
  private final UserId id;

  private final String name;

  private int _cachedHashCode;

  UserAttribute(UserId id, String name) {
    this.id = id;
    this.name = name;
  }

  @JsonProperty("id")
  @Override
  public UserId getId() {
    return id;
  }

  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UserAttribute && equalTo((UserAttribute) other);
  }

  private boolean equalTo(UserAttribute other) {
    return id.equals(other.id) && name.equals(other.name);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.name);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UserAttribute{" + "id: " + id + ", name: " + name + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    NameStage id(UserId id);

    Builder from(UserAttribute other);
  }

  public interface NameStage {
    _FinalStage name(String name);
  }

  public interface _FinalStage {
    UserAttribute build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, NameStage, _FinalStage {
    private UserId id;

    private String name;

    private Builder() {
    }

    @Override
    public Builder from(UserAttribute other) {
      id(other.getId());
      name(other.getName());
      return this;
    }

    @Override
    @JsonSetter("id")
    public NameStage id(UserId id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("name")
    public _FinalStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    public UserAttribute build() {
      return new UserAttribute(id, name);
    }
  }
}
