package com.phyllo.connect.api.client.connect.endpoints;

import com.phyllo.connect.api.client.BasicAuth;
import com.phyllo.connect.api.client.connect.types.UserId;
import com.phyllo.connect.api.client.connect.types.WorkPlatformId;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetAllAccounts {
  private GetAllAccounts() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final Optional<Integer> limit;

    private final Optional<Integer> offset;

    private final Optional<UserId> userId;

    private final Optional<WorkPlatformId> workPlatformId;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, Optional<Integer> limit, Optional<Integer> offset,
        Optional<UserId> userId, Optional<WorkPlatformId> workPlatformId) {
      this.authOverride = authOverride;
      this.limit = limit;
      this.offset = offset;
      this.userId = userId;
      this.workPlatformId = workPlatformId;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    public Optional<Integer> getLimit() {
      return limit;
    }

    public Optional<Integer> getOffset() {
      return offset;
    }

    public Optional<UserId> getUserId() {
      return userId;
    }

    public Optional<WorkPlatformId> getWorkPlatformId() {
      return workPlatformId;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && limit.equals(other.limit) && offset.equals(other.offset) && userId.equals(other.userId) && workPlatformId.equals(other.workPlatformId);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.limit, this.offset, this.userId, this.workPlatformId);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetAllAccounts.Request{" + "authOverride: " + authOverride + ", limit: " + limit + ", offset: " + offset + ", userId: " + userId + ", workPlatformId: " + workPlatformId + "}";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<Integer> limit = Optional.empty();

      private Optional<Integer> offset = Optional.empty();

      private Optional<UserId> userId = Optional.empty();

      private Optional<WorkPlatformId> workPlatformId = Optional.empty();

      private Builder() {
      }

      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        limit(other.getLimit());
        offset(other.getOffset());
        userId(other.getUserId());
        workPlatformId(other.getWorkPlatformId());
        return this;
      }

      public Builder authOverride(Optional<BasicAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      public Builder authOverride(BasicAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      public Builder limit(Optional<Integer> limit) {
        this.limit = limit;
        return this;
      }

      public Builder limit(Integer limit) {
        this.limit = Optional.of(limit);
        return this;
      }

      public Builder offset(Optional<Integer> offset) {
        this.offset = offset;
        return this;
      }

      public Builder offset(Integer offset) {
        this.offset = Optional.of(offset);
        return this;
      }

      public Builder userId(Optional<UserId> userId) {
        this.userId = userId;
        return this;
      }

      public Builder userId(UserId userId) {
        this.userId = Optional.of(userId);
        return this;
      }

      public Builder workPlatformId(Optional<WorkPlatformId> workPlatformId) {
        this.workPlatformId = workPlatformId;
        return this;
      }

      public Builder workPlatformId(WorkPlatformId workPlatformId) {
        this.workPlatformId = Optional.of(workPlatformId);
        return this;
      }

      public Request build() {
        return new Request(authOverride, limit, offset, userId, workPlatformId);
      }
    }
  }
}
