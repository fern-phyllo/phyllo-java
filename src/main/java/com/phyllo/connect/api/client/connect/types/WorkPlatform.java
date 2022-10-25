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
    builder = WorkPlatform.Builder.class
)
public final class WorkPlatform implements IWorkPlatformAttribute {
  private final WorkPlatformId id;

  private final String name;

  private final String logoUrl;

  private final String createdAt;

  private final String updatedAt;

  private final WorkPlatformCategory category;

  private final Status status;

  private final String url;

  private final Products products;

  private int _cachedHashCode;

  WorkPlatform(WorkPlatformId id, String name, String logoUrl, String createdAt, String updatedAt,
      WorkPlatformCategory category, Status status, String url, Products products) {
    this.id = id;
    this.name = name;
    this.logoUrl = logoUrl;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.category = category;
    this.status = status;
    this.url = url;
    this.products = products;
  }

  @JsonProperty("id")
  @Override
  public WorkPlatformId getId() {
    return id;
  }

  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  @JsonProperty("logo_url")
  @Override
  public String getLogoUrl() {
    return logoUrl;
  }

  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updated_at")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @JsonProperty("category")
  public WorkPlatformCategory getCategory() {
    return category;
  }

  @JsonProperty("status")
  public Status getStatus() {
    return status;
  }

  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  @JsonProperty("products")
  public Products getProducts() {
    return products;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WorkPlatform && equalTo((WorkPlatform) other);
  }

  private boolean equalTo(WorkPlatform other) {
    return id.equals(other.id) && name.equals(other.name) && logoUrl.equals(other.logoUrl) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && category.equals(other.category) && status.equals(other.status) && url.equals(other.url) && products.equals(other.products);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.name, this.logoUrl, this.createdAt, this.updatedAt, this.category, this.status, this.url, this.products);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "WorkPlatform{" + "id: " + id + ", name: " + name + ", logoUrl: " + logoUrl + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", category: " + category + ", status: " + status + ", url: " + url + ", products: " + products + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    NameStage id(WorkPlatformId id);

    Builder from(WorkPlatform other);
  }

  public interface NameStage {
    LogoUrlStage name(String name);
  }

  public interface LogoUrlStage {
    CreatedAtStage logoUrl(String logoUrl);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    CategoryStage updatedAt(String updatedAt);
  }

  public interface CategoryStage {
    StatusStage category(WorkPlatformCategory category);
  }

  public interface StatusStage {
    UrlStage status(Status status);
  }

  public interface UrlStage {
    ProductsStage url(String url);
  }

  public interface ProductsStage {
    _FinalStage products(Products products);
  }

  public interface _FinalStage {
    WorkPlatform build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, NameStage, LogoUrlStage, CreatedAtStage, UpdatedAtStage, CategoryStage, StatusStage, UrlStage, ProductsStage, _FinalStage {
    private WorkPlatformId id;

    private String name;

    private String logoUrl;

    private String createdAt;

    private String updatedAt;

    private WorkPlatformCategory category;

    private Status status;

    private String url;

    private Products products;

    private Builder() {
    }

    @Override
    public Builder from(WorkPlatform other) {
      id(other.getId());
      name(other.getName());
      logoUrl(other.getLogoUrl());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      category(other.getCategory());
      status(other.getStatus());
      url(other.getUrl());
      products(other.getProducts());
      return this;
    }

    @Override
    @JsonSetter("id")
    public NameStage id(WorkPlatformId id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("name")
    public LogoUrlStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("logo_url")
    public CreatedAtStage logoUrl(String logoUrl) {
      this.logoUrl = logoUrl;
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
    public CategoryStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    @JsonSetter("category")
    public StatusStage category(WorkPlatformCategory category) {
      this.category = category;
      return this;
    }

    @Override
    @JsonSetter("status")
    public UrlStage status(Status status) {
      this.status = status;
      return this;
    }

    @Override
    @JsonSetter("url")
    public ProductsStage url(String url) {
      this.url = url;
      return this;
    }

    @Override
    @JsonSetter("products")
    public _FinalStage products(Products products) {
      this.products = products;
      return this;
    }

    @Override
    public WorkPlatform build() {
      return new WorkPlatform(id, name, logoUrl, createdAt, updatedAt, category, status, url, products);
    }
  }
}
