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
    builder = IdentityData.Builder.class
)
public final class IdentityData {
  private final DataStatus status;

  private final Optional<String> lastSyncAt;

  private final MonitoringType monitorType;

  private final Optional<IdentityAudienceData> audience;

  private int _cachedHashCode;

  IdentityData(DataStatus status, Optional<String> lastSyncAt, MonitoringType monitorType,
      Optional<IdentityAudienceData> audience) {
    this.status = status;
    this.lastSyncAt = lastSyncAt;
    this.monitorType = monitorType;
    this.audience = audience;
  }

  @JsonProperty("status")
  public DataStatus getStatus() {
    return status;
  }

  @JsonProperty("last_sync_at")
  public Optional<String> getLastSyncAt() {
    return lastSyncAt;
  }

  @JsonProperty("monitor_type")
  public MonitoringType getMonitorType() {
    return monitorType;
  }

  @JsonProperty("audience")
  public Optional<IdentityAudienceData> getAudience() {
    return audience;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IdentityData && equalTo((IdentityData) other);
  }

  private boolean equalTo(IdentityData other) {
    return status.equals(other.status) && lastSyncAt.equals(other.lastSyncAt) && monitorType.equals(other.monitorType) && audience.equals(other.audience);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.status, this.lastSyncAt, this.monitorType, this.audience);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "IdentityData{" + "status: " + status + ", lastSyncAt: " + lastSyncAt + ", monitorType: " + monitorType + ", audience: " + audience + "}";
  }

  public static StatusStage builder() {
    return new Builder();
  }

  public interface StatusStage {
    MonitorTypeStage status(DataStatus status);

    Builder from(IdentityData other);
  }

  public interface MonitorTypeStage {
    _FinalStage monitorType(MonitoringType monitorType);
  }

  public interface _FinalStage {
    IdentityData build();

    _FinalStage lastSyncAt(Optional<String> lastSyncAt);

    _FinalStage lastSyncAt(String lastSyncAt);

    _FinalStage audience(Optional<IdentityAudienceData> audience);

    _FinalStage audience(IdentityAudienceData audience);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements StatusStage, MonitorTypeStage, _FinalStage {
    private DataStatus status;

    private MonitoringType monitorType;

    private Optional<IdentityAudienceData> audience = Optional.empty();

    private Optional<String> lastSyncAt = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(IdentityData other) {
      status(other.getStatus());
      lastSyncAt(other.getLastSyncAt());
      monitorType(other.getMonitorType());
      audience(other.getAudience());
      return this;
    }

    @Override
    @JsonSetter("status")
    public MonitorTypeStage status(DataStatus status) {
      this.status = status;
      return this;
    }

    @Override
    @JsonSetter("monitor_type")
    public _FinalStage monitorType(MonitoringType monitorType) {
      this.monitorType = monitorType;
      return this;
    }

    @Override
    public _FinalStage audience(IdentityAudienceData audience) {
      this.audience = Optional.of(audience);
      return this;
    }

    @Override
    @JsonSetter(
        value = "audience",
        nulls = Nulls.SKIP
    )
    public _FinalStage audience(Optional<IdentityAudienceData> audience) {
      this.audience = audience;
      return this;
    }

    @Override
    public _FinalStage lastSyncAt(String lastSyncAt) {
      this.lastSyncAt = Optional.of(lastSyncAt);
      return this;
    }

    @Override
    @JsonSetter(
        value = "last_sync_at",
        nulls = Nulls.SKIP
    )
    public _FinalStage lastSyncAt(Optional<String> lastSyncAt) {
      this.lastSyncAt = lastSyncAt;
      return this;
    }

    @Override
    public IdentityData build() {
      return new IdentityData(status, lastSyncAt, monitorType, audience);
    }
  }
}
