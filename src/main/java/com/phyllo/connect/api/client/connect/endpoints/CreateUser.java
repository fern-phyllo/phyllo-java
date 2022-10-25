package com.phyllo.connect.api.client.connect.endpoints;

import com.phyllo.connect.api.client.BasicAuth;
import com.phyllo.connect.api.client.connect.types.CreateUserRequest;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class CreateUser {
  private CreateUser() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final CreateUserRequest body;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, CreateUserRequest body) {
      this.authOverride = authOverride;
      this.body = body;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    public CreateUserRequest getBody() {
      return body;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.body);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "CreateUser.Request{" + "authOverride: " + authOverride + ", body: " + body + "}";
    }

    public static BodyStage builder() {
      return new Builder();
    }

    public interface BodyStage {
      _FinalStage body(CreateUserRequest body);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    static final class Builder implements BodyStage, _FinalStage {
      private CreateUserRequest body;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        body(other.getBody());
        return this;
      }

      @Override
      public _FinalStage body(CreateUserRequest body) {
        this.body = body;
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
        return new Request(authOverride, body);
      }
    }
  }
}
