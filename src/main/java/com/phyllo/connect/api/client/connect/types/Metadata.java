package com.phyllo.connect.api.client.connect.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Metadata.Builder.class
)
public final class Metadata {
  private final int offset;

  private final int limit;

  private final Optional<String> fromDate;

  private final Optional<String> toDate;

  private int _cachedHashCode;

  Metadata(int offset, int limit, Optional<String> fromDate, Optional<String> toDate) {
    this.offset = offset;
    this.limit = limit;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  @JsonProperty("offset")
  public int getOffset() {
    return offset;
  }

  @JsonProperty("limit")
  public int getLimit() {
    return limit;
  }

  @JsonProperty("from_date")
  public Optional<String> getFromDate() {
    return fromDate;
  }

  @JsonProperty("to_date")
  public Optional<String> getToDate() {
    return toDate;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Metadata && equalTo((Metadata) other);
  }

  private boolean equalTo(Metadata other) {
    return offset == other.offset && limit == other.limit && fromDate.equals(other.fromDate) && toDate.equals(other.toDate);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.offset, this.limit, this.fromDate, this.toDate);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Metadata{" + "offset: " + offset + ", limit: " + limit + ", fromDate: " + fromDate + ", toDate: " + toDate + "}";
  }

  public static OffsetStage builder() {
    return new Builder();
  }

  public interface OffsetStage {
    LimitStage offset(int offset);

    Builder from(Metadata other);
  }

  public interface LimitStage {
    _FinalStage limit(int limit);
  }

  public interface _FinalStage {
    Metadata build();

    _FinalStage fromDate(Optional<String> fromDate);

    _FinalStage fromDate(String fromDate);

    _FinalStage toDate(Optional<String> toDate);

    _FinalStage toDate(String toDate);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements OffsetStage, LimitStage, _FinalStage {
    private int offset;

    private int limit;

    private Optional<String> toDate = Optional.empty();

    private Optional<String> fromDate = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Metadata other) {
      offset(other.getOffset());
      limit(other.getLimit());
      fromDate(other.getFromDate());
      toDate(other.getToDate());
      return this;
    }

    @Override
    @JsonSetter("offset")
    public LimitStage offset(int offset) {
      this.offset = offset;
      return this;
    }

    @Override
    @JsonSetter("limit")
    public _FinalStage limit(int limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public _FinalStage toDate(String toDate) {
      this.toDate = Optional.of(toDate);
      return this;
    }

    @Override
    @JsonSetter(
        value = "to_date",
        nulls = Nulls.SKIP
    )
    public _FinalStage toDate(Optional<String> toDate) {
      this.toDate = toDate;
      return this;
    }

    @Override
    public _FinalStage fromDate(String fromDate) {
      this.fromDate = Optional.of(fromDate);
      return this;
    }

    @Override
    @JsonSetter(
        value = "from_date",
        nulls = Nulls.SKIP
    )
    public _FinalStage fromDate(Optional<String> fromDate) {
      this.fromDate = fromDate;
      return this;
    }

    @Override
    public Metadata build() {
      return new Metadata(offset, limit, fromDate, toDate);
    }
  }
}
