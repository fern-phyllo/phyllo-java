package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = AllWorkPlatformsResponse.Builder.class
)
public final class AllWorkPlatformsResponse {
  private final List<WorkPlatform> data;

  private final Metadata metadata;

  private int _cachedHashCode;

  AllWorkPlatformsResponse(List<WorkPlatform> data, Metadata metadata) {
    this.data = data;
    this.metadata = metadata;
  }

  @JsonProperty("data")
  public List<WorkPlatform> getData() {
    return data;
  }

  @JsonProperty("metadata")
  public Metadata getMetadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AllWorkPlatformsResponse && equalTo((AllWorkPlatformsResponse) other);
  }

  private boolean equalTo(AllWorkPlatformsResponse other) {
    return data.equals(other.data) && metadata.equals(other.metadata);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.data, this.metadata);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AllWorkPlatformsResponse{" + "data: " + data + ", metadata: " + metadata + "}";
  }

  public static MetadataStage builder() {
    return new Builder();
  }

  public interface MetadataStage {
    _FinalStage metadata(Metadata metadata);

    Builder from(AllWorkPlatformsResponse other);
  }

  public interface _FinalStage {
    AllWorkPlatformsResponse build();

    _FinalStage data(List<WorkPlatform> data);

    _FinalStage data(WorkPlatform data);

    _FinalStage addAllData(List<WorkPlatform> data);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements MetadataStage, _FinalStage {
    private Metadata metadata;

    private List<WorkPlatform> data = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(AllWorkPlatformsResponse other) {
      data(other.getData());
      metadata(other.getMetadata());
      return this;
    }

    @Override
    @JsonSetter("metadata")
    public _FinalStage metadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    @Override
    public _FinalStage addAllData(List<WorkPlatform> data) {
      this.data.addAll(data);
      return this;
    }

    @Override
    public _FinalStage data(WorkPlatform data) {
      this.data.add(data);
      return this;
    }

    @Override
    @JsonSetter(
        value = "data",
        nulls = Nulls.SKIP
    )
    public _FinalStage data(List<WorkPlatform> data) {
      this.data.clear();
      this.data.addAll(data);
      return this;
    }

    @Override
    public AllWorkPlatformsResponse build() {
      return new AllWorkPlatformsResponse(data, metadata);
    }
  }
}
