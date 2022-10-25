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
    builder = AccountData.Builder.class
)
public final class AccountData {
  private final Optional<IdentityData> identity;

  private final Optional<EngagementData> engagement;

  private final Optional<IncomeData> income;

  private int _cachedHashCode;

  AccountData(Optional<IdentityData> identity, Optional<EngagementData> engagement,
      Optional<IncomeData> income) {
    this.identity = identity;
    this.engagement = engagement;
    this.income = income;
  }

  @JsonProperty("identity")
  public Optional<IdentityData> getIdentity() {
    return identity;
  }

  @JsonProperty("engagement")
  public Optional<EngagementData> getEngagement() {
    return engagement;
  }

  @JsonProperty("income")
  public Optional<IncomeData> getIncome() {
    return income;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AccountData && equalTo((AccountData) other);
  }

  private boolean equalTo(AccountData other) {
    return identity.equals(other.identity) && engagement.equals(other.engagement) && income.equals(other.income);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity, this.engagement, this.income);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AccountData{" + "identity: " + identity + ", engagement: " + engagement + ", income: " + income + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<IdentityData> identity = Optional.empty();

    private Optional<EngagementData> engagement = Optional.empty();

    private Optional<IncomeData> income = Optional.empty();

    private Builder() {
    }

    public Builder from(AccountData other) {
      identity(other.getIdentity());
      engagement(other.getEngagement());
      income(other.getIncome());
      return this;
    }

    @JsonSetter(
        value = "identity",
        nulls = Nulls.SKIP
    )
    public Builder identity(Optional<IdentityData> identity) {
      this.identity = identity;
      return this;
    }

    public Builder identity(IdentityData identity) {
      this.identity = Optional.of(identity);
      return this;
    }

    @JsonSetter(
        value = "engagement",
        nulls = Nulls.SKIP
    )
    public Builder engagement(Optional<EngagementData> engagement) {
      this.engagement = engagement;
      return this;
    }

    public Builder engagement(EngagementData engagement) {
      this.engagement = Optional.of(engagement);
      return this;
    }

    @JsonSetter(
        value = "income",
        nulls = Nulls.SKIP
    )
    public Builder income(Optional<IncomeData> income) {
      this.income = income;
      return this;
    }

    public Builder income(IncomeData income) {
      this.income = Optional.of(income);
      return this;
    }

    public AccountData build() {
      return new AccountData(identity, engagement, income);
    }
  }
}
