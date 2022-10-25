package com.phyllo.connect.api.client.connect.endpoints;

import com.phyllo.connect.api.client.BasicAuth;
import com.phyllo.connect.api.client.connect.types.ExternalId;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetUserByExernalId {
  private GetUserByExernalId() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final ExternalId externalId;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, ExternalId externalId) {
      this.authOverride = authOverride;
      this.externalId = externalId;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    public ExternalId getExternalId() {
      return externalId;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && externalId.equals(other.externalId);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.externalId);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetUserByExernalId.Request{" + "authOverride: " + authOverride + ", externalId: " + externalId + "}";
    }

    public static ExternalIdStage builder() {
      return new Builder();
    }

    public interface ExternalIdStage {
      _FinalStage externalId(ExternalId externalId);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    static final class Builder implements ExternalIdStage, _FinalStage {
      private ExternalId externalId;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        externalId(other.getExternalId());
        return this;
      }

      @Override
      public _FinalStage externalId(ExternalId externalId) {
        this.externalId = externalId;
        return this;
      }

      @Override
      public _FinalStage authOverride(BasicAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BasicAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(authOverride, externalId);
      }
    }
  }
}
