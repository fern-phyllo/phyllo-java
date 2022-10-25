package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Account.Builder.class
)
public final class Account {
  private final AccountId id;

  private final String createdAt;

  private final String updatedAt;

  private final UserAttribute user;

  private final WorkPlatformAttribute workPlatform;

  private final Optional<String> platformUsername;

  private final Optional<String> profilePicUrl;

  private final AccountStatus status;

  private final Optional<String> platformProfileName;

  private final Optional<String> platformProfileId;

  private final Optional<String> platformProfilePublishedAt;

  private final AccountData data;

  private int _cachedHashCode;

  Account(AccountId id, String createdAt, String updatedAt, UserAttribute user,
      WorkPlatformAttribute workPlatform, Optional<String> platformUsername,
      Optional<String> profilePicUrl, AccountStatus status, Optional<String> platformProfileName,
      Optional<String> platformProfileId, Optional<String> platformProfilePublishedAt,
      AccountData data) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.user = user;
    this.workPlatform = workPlatform;
    this.platformUsername = platformUsername;
    this.profilePicUrl = profilePicUrl;
    this.status = status;
    this.platformProfileName = platformProfileName;
    this.platformProfileId = platformProfileId;
    this.platformProfilePublishedAt = platformProfilePublishedAt;
    this.data = data;
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

  @JsonProperty("platform_username")
  public Optional<String> getPlatformUsername() {
    return platformUsername;
  }

  @JsonProperty("profile_pic_url")
  public Optional<String> getProfilePicUrl() {
    return profilePicUrl;
  }

  @JsonProperty("status")
  public AccountStatus getStatus() {
    return status;
  }

  @JsonProperty("platform_profile_name")
  public Optional<String> getPlatformProfileName() {
    return platformProfileName;
  }

  @JsonProperty("platform_profile_id")
  public Optional<String> getPlatformProfileId() {
    return platformProfileId;
  }

  @JsonProperty("platform_profile_published_at")
  public Optional<String> getPlatformProfilePublishedAt() {
    return platformProfilePublishedAt;
  }

  @JsonProperty("data")
  public AccountData getData() {
    return data;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Account && equalTo((Account) other);
  }

  private boolean equalTo(Account other) {
    return id.equals(other.id) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && user.equals(other.user) && workPlatform.equals(other.workPlatform) && platformUsername.equals(other.platformUsername) && profilePicUrl.equals(other.profilePicUrl) && status.equals(other.status) && platformProfileName.equals(other.platformProfileName) && platformProfileId.equals(other.platformProfileId) && platformProfilePublishedAt.equals(other.platformProfilePublishedAt) && data.equals(other.data);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.createdAt, this.updatedAt, this.user, this.workPlatform, this.platformUsername, this.profilePicUrl, this.status, this.platformProfileName, this.platformProfileId, this.platformProfilePublishedAt, this.data);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Account{" + "id: " + id + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", user: " + user + ", workPlatform: " + workPlatform + ", platformUsername: " + platformUsername + ", profilePicUrl: " + profilePicUrl + ", status: " + status + ", platformProfileName: " + platformProfileName + ", platformProfileId: " + platformProfileId + ", platformProfilePublishedAt: " + platformProfilePublishedAt + ", data: " + data + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    CreatedAtStage id(AccountId id);

    Builder from(Account other);
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
    DataStage status(AccountStatus status);
  }

  public interface DataStage {
    _FinalStage data(AccountData data);
  }

  public interface _FinalStage {
    Account build();

    _FinalStage platformUsername(Optional<String> platformUsername);

    _FinalStage platformUsername(String platformUsername);

    _FinalStage profilePicUrl(Optional<String> profilePicUrl);

    _FinalStage profilePicUrl(String profilePicUrl);

    _FinalStage platformProfileName(Optional<String> platformProfileName);

    _FinalStage platformProfileName(String platformProfileName);

    _FinalStage platformProfileId(Optional<String> platformProfileId);

    _FinalStage platformProfileId(String platformProfileId);

    _FinalStage platformProfilePublishedAt(Optional<String> platformProfilePublishedAt);

    _FinalStage platformProfilePublishedAt(String platformProfilePublishedAt);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, CreatedAtStage, UpdatedAtStage, UserStage, WorkPlatformStage, StatusStage, DataStage, _FinalStage {
    private AccountId id;

    private String createdAt;

    private String updatedAt;

    private UserAttribute user;

    private WorkPlatformAttribute workPlatform;

    private AccountStatus status;

    private AccountData data;

    private Optional<String> platformProfilePublishedAt = Optional.empty();

    private Optional<String> platformProfileId = Optional.empty();

    private Optional<String> platformProfileName = Optional.empty();

    private Optional<String> profilePicUrl = Optional.empty();

    private Optional<String> platformUsername = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Account other) {
      id(other.getId());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      user(other.getUser());
      workPlatform(other.getWorkPlatform());
      platformUsername(other.getPlatformUsername());
      profilePicUrl(other.getProfilePicUrl());
      status(other.getStatus());
      platformProfileName(other.getPlatformProfileName());
      platformProfileId(other.getPlatformProfileId());
      platformProfilePublishedAt(other.getPlatformProfilePublishedAt());
      data(other.getData());
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
    public DataStage status(AccountStatus status) {
      this.status = status;
      return this;
    }

    @Override
    @JsonSetter("data")
    public _FinalStage data(AccountData data) {
      this.data = data;
      return this;
    }

    @Override
    public _FinalStage platformProfilePublishedAt(String platformProfilePublishedAt) {
      this.platformProfilePublishedAt = Optional.of(platformProfilePublishedAt);
      return this;
    }

    @Override
    @JsonSetter(
        value = "platform_profile_published_at",
        nulls = Nulls.SKIP
    )
    public _FinalStage platformProfilePublishedAt(Optional<String> platformProfilePublishedAt) {
      this.platformProfilePublishedAt = platformProfilePublishedAt;
      return this;
    }

    @Override
    public _FinalStage platformProfileId(String platformProfileId) {
      this.platformProfileId = Optional.of(platformProfileId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "platform_profile_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage platformProfileId(Optional<String> platformProfileId) {
      this.platformProfileId = platformProfileId;
      return this;
    }

    @Override
    public _FinalStage platformProfileName(String platformProfileName) {
      this.platformProfileName = Optional.of(platformProfileName);
      return this;
    }

    @Override
    @JsonSetter(
        value = "platform_profile_name",
        nulls = Nulls.SKIP
    )
    public _FinalStage platformProfileName(Optional<String> platformProfileName) {
      this.platformProfileName = platformProfileName;
      return this;
    }

    @Override
    public _FinalStage profilePicUrl(String profilePicUrl) {
      this.profilePicUrl = Optional.of(profilePicUrl);
      return this;
    }

    @Override
    @JsonSetter(
        value = "profile_pic_url",
        nulls = Nulls.SKIP
    )
    public _FinalStage profilePicUrl(Optional<String> profilePicUrl) {
      this.profilePicUrl = profilePicUrl;
      return this;
    }

    @Override
    public _FinalStage platformUsername(String platformUsername) {
      this.platformUsername = Optional.of(platformUsername);
      return this;
    }

    @Override
    @JsonSetter(
        value = "platform_username",
        nulls = Nulls.SKIP
    )
    public _FinalStage platformUsername(Optional<String> platformUsername) {
      this.platformUsername = platformUsername;
      return this;
    }

    @Override
    public Account build() {
      return new Account(id, createdAt, updatedAt, user, workPlatform, platformUsername, profilePicUrl, status, platformProfileName, platformProfileId, platformProfilePublishedAt, data);
    }
  }
}
