package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@JsonDeserialize(
    builder = SDKTokenRequest.Builder.class
)
public final class SDKTokenRequest {
  private final UserId userId;

  private final Set<PhylloProducts> products;

  private int _cachedHashCode;

  SDKTokenRequest(UserId userId, Set<PhylloProducts> products) {
    this.userId = userId;
    this.products = products;
  }

  @JsonProperty("user_id")
  public UserId getUserId() {
    return userId;
  }

  @JsonProperty("products")
  public Set<PhylloProducts> getProducts() {
    return products;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SDKTokenRequest && equalTo((SDKTokenRequest) other);
  }

  private boolean equalTo(SDKTokenRequest other) {
    return userId.equals(other.userId) && products.equals(other.products);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.userId, this.products);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SDKTokenRequest{" + "userId: " + userId + ", products: " + products + "}";
  }

  public static UserIdStage builder() {
    return new Builder();
  }

  public interface UserIdStage {
    _FinalStage userId(UserId userId);

    Builder from(SDKTokenRequest other);
  }

  public interface _FinalStage {
    SDKTokenRequest build();

    _FinalStage products(Set<PhylloProducts> products);

    _FinalStage products(PhylloProducts products);

    _FinalStage addAllProducts(Set<PhylloProducts> products);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements UserIdStage, _FinalStage {
    private UserId userId;

    private Set<PhylloProducts> products = new LinkedHashSet<>();

    private Builder() {
    }

    @Override
    public Builder from(SDKTokenRequest other) {
      userId(other.getUserId());
      products(other.getProducts());
      return this;
    }

    @Override
    @JsonSetter("user_id")
    public _FinalStage userId(UserId userId) {
      this.userId = userId;
      return this;
    }

    @Override
    public _FinalStage addAllProducts(Set<PhylloProducts> products) {
      this.products.addAll(products);
      return this;
    }

    @Override
    public _FinalStage products(PhylloProducts products) {
      this.products.add(products);
      return this;
    }

    @Override
    @JsonSetter(
        value = "products",
        nulls = Nulls.SKIP
    )
    public _FinalStage products(Set<PhylloProducts> products) {
      this.products.clear();
      this.products.addAll(products);
      return this;
    }

    @Override
    public SDKTokenRequest build() {
      return new SDKTokenRequest(userId, products);
    }
  }
}
