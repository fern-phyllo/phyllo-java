package com.phyllo.connect.api.client.connect.endpoints;

import com.phyllo.connect.api.client.BasicAuth;
import com.phyllo.connect.api.client.connect.types.WorkPlatformId;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetWorkPlatform {
  private GetWorkPlatform() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final WorkPlatformId id;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, WorkPlatformId id) {
      this.authOverride = authOverride;
      this.id = id;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    public WorkPlatformId getId() {
      return id;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && id.equals(other.id);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.id);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetWorkPlatform.Request{" + "authOverride: " + authOverride + ", id: " + id + "}";
    }

    public static IdStage builder() {
      return new Builder();
    }

    public interface IdStage {
      _FinalStage id(WorkPlatformId id);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    static final class Builder implements IdStage, _FinalStage {
      private WorkPlatformId id;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        id(other.getId());
        return this;
      }

      @Override
      public _FinalStage id(WorkPlatformId id) {
        this.id = id;
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
        return new Request(authOverride, id);
      }
    }
  }
}
