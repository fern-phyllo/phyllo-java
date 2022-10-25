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
    builder = EngagementData.Builder.class
)
public final class EngagementData {
  private final DataStatus status;

  private final Optional<String> lastSyncAt;

  private final Optional<String> refreshSince;

  private final Optional<String> dataAvailableFrom;

  private final MonitoringType monitorType;

  private final Optional<EngagementAudienceData> audience;

  private int _cachedHashCode;

  EngagementData(DataStatus status, Optional<String> lastSyncAt, Optional<String> refreshSince,
      Optional<String> dataAvailableFrom, MonitoringType monitorType,
      Optional<EngagementAudienceData> audience) {
    this.status = status;
    this.lastSyncAt = lastSyncAt;
    this.refreshSince = refreshSince;
    this.dataAvailableFrom = dataAvailableFrom;
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

  @JsonProperty("refresh_since")
  public Optional<String> getRefreshSince() {
    return refreshSince;
  }

  @JsonProperty("data_available_from")
  public Optional<String> getDataAvailableFrom() {
    return dataAvailableFrom;
  }

  @JsonProperty("monitor_type")
  public MonitoringType getMonitorType() {
    return monitorType;
  }

  @JsonProperty("audience")
  public Optional<EngagementAudienceData> getAudience() {
    return audience;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EngagementData && equalTo((EngagementData) other);
  }

  private boolean equalTo(EngagementData other) {
    return status.equals(other.status) && lastSyncAt.equals(other.lastSyncAt) && refreshSince.equals(other.refreshSince) && dataAvailableFrom.equals(other.dataAvailableFrom) && monitorType.equals(other.monitorType) && audience.equals(other.audience);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.status, this.lastSyncAt, this.refreshSince, this.dataAvailableFrom, this.monitorType, this.audience);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EngagementData{" + "status: " + status + ", lastSyncAt: " + lastSyncAt + ", refreshSince: " + refreshSince + ", dataAvailableFrom: " + dataAvailableFrom + ", monitorType: " + monitorType + ", audience: " + audience + "}";
  }

  public static StatusStage builder() {
    return new Builder();
  }

  public interface StatusStage {
    MonitorTypeStage status(DataStatus status);

    Builder from(EngagementData other);
  }

  public interface MonitorTypeStage {
    _FinalStage monitorType(MonitoringType monitorType);
  }

  public interface _FinalStage {
    EngagementData build();

    _FinalStage lastSyncAt(Optional<String> lastSyncAt);

    _FinalStage lastSyncAt(String lastSyncAt);

    _FinalStage refreshSince(Optional<String> refreshSince);

    _FinalStage refreshSince(String refreshSince);

    _FinalStage dataAvailableFrom(Optional<String> dataAvailableFrom);

    _FinalStage dataAvailableFrom(String dataAvailableFrom);

    _FinalStage audience(Optional<EngagementAudienceData> audience);

    _FinalStage audience(EngagementAudienceData audience);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements StatusStage, MonitorTypeStage, _FinalStage {
    private DataStatus status;

    private MonitoringType monitorType;

    private Optional<EngagementAudienceData> audience = Optional.empty();

    private Optional<String> dataAvailableFrom = Optional.empty();

    private Optional<String> refreshSince = Optional.empty();

    private Optional<String> lastSyncAt = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(EngagementData other) {
      status(other.getStatus());
      lastSyncAt(other.getLastSyncAt());
      refreshSince(other.getRefreshSince());
      dataAvailableFrom(other.getDataAvailableFrom());
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
    public _FinalStage audience(EngagementAudienceData audience) {
      this.audience = Optional.of(audience);
      return this;
    }

    @Override
    @JsonSetter(
        value = "audience",
        nulls = Nulls.SKIP
    )
    public _FinalStage audience(Optional<EngagementAudienceData> audience) {
      this.audience = audience;
      return this;
    }

    @Override
    public _FinalStage dataAvailableFrom(String dataAvailableFrom) {
      this.dataAvailableFrom = Optional.of(dataAvailableFrom);
      return this;
    }

    @Override
    @JsonSetter(
        value = "data_available_from",
        nulls = Nulls.SKIP
    )
    public _FinalStage dataAvailableFrom(Optional<String> dataAvailableFrom) {
      this.dataAvailableFrom = dataAvailableFrom;
      return this;
    }

    @Override
    public _FinalStage refreshSince(String refreshSince) {
      this.refreshSince = Optional.of(refreshSince);
      return this;
    }

    @Override
    @JsonSetter(
        value = "refresh_since",
        nulls = Nulls.SKIP
    )
    public _FinalStage refreshSince(Optional<String> refreshSince) {
      this.refreshSince = refreshSince;
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
    public EngagementData build() {
      return new EngagementData(status, lastSyncAt, refreshSince, dataAvailableFrom, monitorType, audience);
    }
  }
}
