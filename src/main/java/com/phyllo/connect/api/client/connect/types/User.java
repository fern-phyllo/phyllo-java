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
    builder = User.Builder.class
)
public final class User implements IUserAttribute {
  private final UserId id;

  private final String name;

  private final ExternalId externalId;

  private final String createdAt;

  private final String updatedAt;

  private final Status status;

  private int _cachedHashCode;

  User(UserId id, String name, ExternalId externalId, String createdAt, String updatedAt,
      Status status) {
    this.id = id;
    this.name = name;
    this.externalId = externalId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
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

  @JsonProperty("external_id")
  public ExternalId getExternalId() {
    return externalId;
  }

  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updated_at")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @JsonProperty("status")
  public Status getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof User && equalTo((User) other);
  }

  private boolean equalTo(User other) {
    return id.equals(other.id) && name.equals(other.name) && externalId.equals(other.externalId) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && status.equals(other.status);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.name, this.externalId, this.createdAt, this.updatedAt, this.status);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "User{" + "id: " + id + ", name: " + name + ", externalId: " + externalId + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", status: " + status + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    NameStage id(UserId id);

    Builder from(User other);
  }

  public interface NameStage {
    ExternalIdStage name(String name);
  }

  public interface ExternalIdStage {
    CreatedAtStage externalId(ExternalId externalId);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    StatusStage updatedAt(String updatedAt);
  }

  public interface StatusStage {
    _FinalStage status(Status status);
  }

  public interface _FinalStage {
    User build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, NameStage, ExternalIdStage, CreatedAtStage, UpdatedAtStage, StatusStage, _FinalStage {
    private UserId id;

    private String name;

    private ExternalId externalId;

    private String createdAt;

    private String updatedAt;

    private Status status;

    private Builder() {
    }

    @Override
    public Builder from(User other) {
      id(other.getId());
      name(other.getName());
      externalId(other.getExternalId());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      status(other.getStatus());
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
    public ExternalIdStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("external_id")
    public CreatedAtStage externalId(ExternalId externalId) {
      this.externalId = externalId;
      return this;
    }

    @Override
    @JsonSetter("created_at")
    public UpdatedAtStage createdAt(String createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    @JsonSetter("updated_at")
    public StatusStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(Status status) {
      this.status = status;
      return this;
    }

    @Override
    public User build() {
      return new User(id, name, externalId, createdAt, updatedAt, status);
    }
  }
}
