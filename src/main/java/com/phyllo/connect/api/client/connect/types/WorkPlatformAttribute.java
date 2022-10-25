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
    builder = WorkPlatformAttribute.Builder.class
)
public final class WorkPlatformAttribute implements IWorkPlatformAttribute {
  private final WorkPlatformId id;

  private final String name;

  private final String logoUrl;

  private int _cachedHashCode;

  WorkPlatformAttribute(WorkPlatformId id, String name, String logoUrl) {
    this.id = id;
    this.name = name;
    this.logoUrl = logoUrl;
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

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WorkPlatformAttribute && equalTo((WorkPlatformAttribute) other);
  }

  private boolean equalTo(WorkPlatformAttribute other) {
    return id.equals(other.id) && name.equals(other.name) && logoUrl.equals(other.logoUrl);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.name, this.logoUrl);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "WorkPlatformAttribute{" + "id: " + id + ", name: " + name + ", logoUrl: " + logoUrl + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    NameStage id(WorkPlatformId id);

    Builder from(WorkPlatformAttribute other);
  }

  public interface NameStage {
    LogoUrlStage name(String name);
  }

  public interface LogoUrlStage {
    _FinalStage logoUrl(String logoUrl);
  }

  public interface _FinalStage {
    WorkPlatformAttribute build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, NameStage, LogoUrlStage, _FinalStage {
    private WorkPlatformId id;

    private String name;

    private String logoUrl;

    private Builder() {
    }

    @Override
    public Builder from(WorkPlatformAttribute other) {
      id(other.getId());
      name(other.getName());
      logoUrl(other.getLogoUrl());
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
    public _FinalStage logoUrl(String logoUrl) {
      this.logoUrl = logoUrl;
      return this;
    }

    @Override
    public WorkPlatformAttribute build() {
      return new WorkPlatformAttribute(id, name, logoUrl);
    }
  }
}
