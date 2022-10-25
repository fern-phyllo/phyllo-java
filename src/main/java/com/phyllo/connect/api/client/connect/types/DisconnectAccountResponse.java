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
    builder = DisconnectAccountResponse.Builder.class
)
public final class DisconnectAccountResponse {
  private final AccountId id;

  private final String createdAt;

  private final String updatedAt;

  private final UserAttribute user;

  private final WorkPlatformAttribute workPlatform;

  private final AccountStatus status;

  private int _cachedHashCode;

  DisconnectAccountResponse(AccountId id, String createdAt, String updatedAt, UserAttribute user,
      WorkPlatformAttribute workPlatform, AccountStatus status) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.user = user;
    this.workPlatform = workPlatform;
    this.status = status;
  }

  @JsonProperty("id")
  public AccountId getId() {
    return id;
  }

  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updated_at")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @JsonProperty("user")
  public UserAttribute getUser() {
    return user;
  }

  @JsonProperty("work_platform")
  public WorkPlatformAttribute getWorkPlatform() {
    return workPlatform;
  }

  @JsonProperty("status")
  public AccountStatus getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DisconnectAccountResponse && equalTo((DisconnectAccountResponse) other);
  }

  private boolean equalTo(DisconnectAccountResponse other) {
    return id.equals(other.id) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && user.equals(other.user) && workPlatform.equals(other.workPlatform) && status.equals(other.status);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.createdAt, this.updatedAt, this.user, this.workPlatform, this.status);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "DisconnectAccountResponse{" + "id: " + id + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", user: " + user + ", workPlatform: " + workPlatform + ", status: " + status + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    CreatedAtStage id(AccountId id);

    Builder from(DisconnectAccountResponse other);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    UserStage updatedAt(String updatedAt);
  }

  public interface UserStage {
    WorkPlatformStage user(UserAttribute user);
  }

  public interface WorkPlatformStage {
    StatusStage workPlatform(WorkPlatformAttribute workPlatform);
  }

  public interface StatusStage {
    _FinalStage status(AccountStatus status);
  }

  public interface _FinalStage {
    DisconnectAccountResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, CreatedAtStage, UpdatedAtStage, UserStage, WorkPlatformStage, StatusStage, _FinalStage {
    private AccountId id;

    private String createdAt;

    private String updatedAt;

    private UserAttribute user;

    private WorkPlatformAttribute workPlatform;

    private AccountStatus status;

    private Builder() {
    }

    @Override
    public Builder from(DisconnectAccountResponse other) {
      id(other.getId());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      user(other.getUser());
      workPlatform(other.getWorkPlatform());
      status(other.getStatus());
      return this;
    }

    @Override
    @JsonSetter("id")
    public CreatedAtStage id(AccountId id) {
      this.id = id;
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
    public UserStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    @JsonSetter("user")
    public WorkPlatformStage user(UserAttribute user) {
      this.user = user;
      return this;
    }

    @Override
    @JsonSetter("work_platform")
    public StatusStage workPlatform(WorkPlatformAttribute workPlatform) {
      this.workPlatform = workPlatform;
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(AccountStatus status) {
      this.status = status;
      return this;
    }

    @Override
    public DisconnectAccountResponse build() {
      return new DisconnectAccountResponse(id, createdAt, updatedAt, user, workPlatform, status);
    }
  }
}
