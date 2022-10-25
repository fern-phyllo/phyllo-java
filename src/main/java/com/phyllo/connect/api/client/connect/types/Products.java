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
    builder = Products.Builder.class
)
public final class Products {
  private final IdentityProduct identity;

  private final EngagementProduct engagement;

  private final IncomeProduct income;

  private final SwitchProduct switch_;

  private int _cachedHashCode;

  Products(IdentityProduct identity, EngagementProduct engagement, IncomeProduct income,
      SwitchProduct switch_) {
    this.identity = identity;
    this.engagement = engagement;
    this.income = income;
    this.switch_ = switch_;
  }

  @JsonProperty("identity")
  public IdentityProduct getIdentity() {
    return identity;
  }

  @JsonProperty("engagement")
  public EngagementProduct getEngagement() {
    return engagement;
  }

  @JsonProperty("income")
  public IncomeProduct getIncome() {
    return income;
  }

  @JsonProperty("switch")
  public SwitchProduct getSwitch() {
    return switch_;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Products && equalTo((Products) other);
  }

  private boolean equalTo(Products other) {
    return identity.equals(other.identity) && engagement.equals(other.engagement) && income.equals(other.income) && switch_.equals(other.switch_);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity, this.engagement, this.income, this.switch_);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Products{" + "identity: " + identity + ", engagement: " + engagement + ", income: " + income + ", switch_: " + switch_ + "}";
  }

  public static IdentityStage builder() {
    return new Builder();
  }

  public interface IdentityStage {
    EngagementStage identity(IdentityProduct identity);

    Builder from(Products other);
  }

  public interface EngagementStage {
    IncomeStage engagement(EngagementProduct engagement);
  }

  public interface IncomeStage {
    SwitchStage income(IncomeProduct income);
  }

  public interface SwitchStage {
    _FinalStage switch_(SwitchProduct switch_);
  }

  public interface _FinalStage {
    Products build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdentityStage, EngagementStage, IncomeStage, SwitchStage, _FinalStage {
    private IdentityProduct identity;

    private EngagementProduct engagement;

    private IncomeProduct income;

    private SwitchProduct switch_;

    private Builder() {
    }

    @Override
    public Builder from(Products other) {
      identity(other.getIdentity());
      engagement(other.getEngagement());
      income(other.getIncome());
      switch_(other.getSwitch());
      return this;
    }

    @Override
    @JsonSetter("identity")
    public EngagementStage identity(IdentityProduct identity) {
      this.identity = identity;
      return this;
    }

    @Override
    @JsonSetter("engagement")
    public IncomeStage engagement(EngagementProduct engagement) {
      this.engagement = engagement;
      return this;
    }

    @Override
    @JsonSetter("income")
    public SwitchStage income(IncomeProduct income) {
      this.income = income;
      return this;
    }

    @Override
    @JsonSetter("switch")
    public _FinalStage switch_(SwitchProduct switch_) {
      this.switch_ = switch_;
      return this;
    }

    @Override
    public Products build() {
      return new Products(identity, engagement, income, switch_);
    }
  }
}
