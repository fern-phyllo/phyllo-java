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
    builder = AllAccountsResponse.Builder.class
)
public final class AllAccountsResponse {
  private final List<Account> data;

  private final Metadata metadata;

  private int _cachedHashCode;

  AllAccountsResponse(List<Account> data, Metadata metadata) {
    this.data = data;
    this.metadata = metadata;
  }

  @JsonProperty("data")
  public List<Account> getData() {
    return data;
  }

  @JsonProperty("metadata")
  public Metadata getMetadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AllAccountsResponse && equalTo((AllAccountsResponse) other);
  }

  private boolean equalTo(AllAccountsResponse other) {
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
    return "AllAccountsResponse{" + "data: " + data + ", metadata: " + metadata + "}";
  }

  public static MetadataStage builder() {
    return new Builder();
  }

  public interface MetadataStage {
    _FinalStage metadata(Metadata metadata);

    Builder from(AllAccountsResponse other);
  }

  public interface _FinalStage {
    AllAccountsResponse build();

    _FinalStage data(List<Account> data);

    _FinalStage data(Account data);

    _FinalStage addAllData(List<Account> data);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements MetadataStage, _FinalStage {
    private Metadata metadata;

    private List<Account> data = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(AllAccountsResponse other) {
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
    public _FinalStage addAllData(List<Account> data) {
      this.data.addAll(data);
      return this;
    }

    @Override
    public _FinalStage data(Account data) {
      this.data.add(data);
      return this;
    }

    @Override
    @JsonSetter(
        value = "data",
        nulls = Nulls.SKIP
    )
    public _FinalStage data(List<Account> data) {
      this.data.clear();
      this.data.addAll(data);
      return this;
    }

    @Override
    public AllAccountsResponse build() {
      return new AllAccountsResponse(data, metadata);
    }
  }
}
