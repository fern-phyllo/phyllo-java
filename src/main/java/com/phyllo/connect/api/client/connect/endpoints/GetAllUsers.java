package com.phyllo.connect.api.client.connect.endpoints;

import com.phyllo.connect.api.core.BasicAuth;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetAllUsers {
  private GetAllUsers() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final Optional<Integer> limit;

    private final Optional<Integer> offset;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, Optional<Integer> limit, Optional<Integer> offset) {
      this.authOverride = authOverride;
      this.limit = limit;
      this.offset = offset;
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

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && limit.equals(other.limit) && offset.equals(other.offset);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.limit, this.offset);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetAllUsers.Request{" + "authOverride: " + authOverride + ", limit: " + limit + ", offset: " + offset + "}";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<Integer> limit = Optional.empty();

      private Optional<Integer> offset = Optional.empty();

      private Builder() {
      }

      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        limit(other.getLimit());
        offset(other.getOffset());
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

      public Request build() {
        return new Request(authOverride, limit, offset);
      }
    }
  }
}
