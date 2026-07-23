package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class LimitedPriorityLevelConfigurationFluent<A extends io.fabric8.kubernetes.api.model.flowcontrol.v1.LimitedPriorityLevelConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer borrowingLimitPercent;
  private Integer lendablePercent;
  private LimitResponseBuilder limitResponse;
  private Integer nominalConcurrencyShares;

  public LimitedPriorityLevelConfigurationFluent() {
  }
  
  public LimitedPriorityLevelConfigurationFluent(LimitedPriorityLevelConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public LimitResponse buildLimitResponse() {
    return this.limitResponse != null ? this.limitResponse.build() : null;
  }
  
  protected void copyInstance(LimitedPriorityLevelConfiguration instance) {
    instance = instance != null ? instance : new LimitedPriorityLevelConfiguration();
    if (instance != null) {
        this.withBorrowingLimitPercent(instance.getBorrowingLimitPercent());
        this.withLendablePercent(instance.getLendablePercent());
        this.withLimitResponse(instance.getLimitResponse());
        this.withNominalConcurrencyShares(instance.getNominalConcurrencyShares());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LimitResponseNested<A> editLimitResponse() {
    return this.withNewLimitResponseLike(Optional.ofNullable(this.buildLimitResponse()).orElse(null));
  }
  
  public LimitResponseNested<A> editOrNewLimitResponse() {
    return this.withNewLimitResponseLike(Optional.ofNullable(this.buildLimitResponse()).orElse(new LimitResponseBuilder().build()));
  }
  
  public LimitResponseNested<A> editOrNewLimitResponseLike(LimitResponse item) {
    return this.withNewLimitResponseLike(Optional.ofNullable(this.buildLimitResponse()).orElse(item));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    LimitedPriorityLevelConfigurationFluent that = (LimitedPriorityLevelConfigurationFluent) o;
    if (!(Objects.equals(borrowingLimitPercent, that.borrowingLimitPercent))) {
      return false;
    }
    if (!(Objects.equals(lendablePercent, that.lendablePercent))) {
      return false;
    }
    if (!(Objects.equals(limitResponse, that.limitResponse))) {
      return false;
    }
    if (!(Objects.equals(nominalConcurrencyShares, that.nominalConcurrencyShares))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Integer getBorrowingLimitPercent() {
    return this.borrowingLimitPercent;
  }
  
  public Integer getLendablePercent() {
    return this.lendablePercent;
  }
  
  public Integer getNominalConcurrencyShares() {
    return this.nominalConcurrencyShares;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBorrowingLimitPercent() {
    return this.borrowingLimitPercent != null;
  }
  
  public boolean hasLendablePercent() {
    return this.lendablePercent != null;
  }
  
  public boolean hasLimitResponse() {
    return this.limitResponse != null;
  }
  
  public boolean hasNominalConcurrencyShares() {
    return this.nominalConcurrencyShares != null;
  }
  
  public int hashCode() {
    return Objects.hash(borrowingLimitPercent, lendablePercent, limitResponse, nominalConcurrencyShares, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(borrowingLimitPercent == null)) {
        sb.append("borrowingLimitPercent:");
        sb.append(borrowingLimitPercent);
        sb.append(",");
    }
    if (!(lendablePercent == null)) {
        sb.append("lendablePercent:");
        sb.append(lendablePercent);
        sb.append(",");
    }
    if (!(limitResponse == null)) {
        sb.append("limitResponse:");
        sb.append(limitResponse);
        sb.append(",");
    }
    if (!(nominalConcurrencyShares == null)) {
        sb.append("nominalConcurrencyShares:");
        sb.append(nominalConcurrencyShares);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBorrowingLimitPercent(Integer borrowingLimitPercent) {
    this.borrowingLimitPercent = borrowingLimitPercent;
    return (A) this;
  }
  
  public A withLendablePercent(Integer lendablePercent) {
    this.lendablePercent = lendablePercent;
    return (A) this;
  }
  
  public A withLimitResponse(LimitResponse limitResponse) {
    this._visitables.remove("limitResponse");
    if (limitResponse != null) {
        this.limitResponse = new LimitResponseBuilder(limitResponse);
        this._visitables.get("limitResponse").add(this.limitResponse);
    } else {
        this.limitResponse = null;
        this._visitables.get("limitResponse").remove(this.limitResponse);
    }
    return (A) this;
  }
  
  public LimitResponseNested<A> withNewLimitResponse() {
    return new LimitResponseNested(null);
  }
  
  public LimitResponseNested<A> withNewLimitResponseLike(LimitResponse item) {
    return new LimitResponseNested(item);
  }
  
  public A withNominalConcurrencyShares(Integer nominalConcurrencyShares) {
    this.nominalConcurrencyShares = nominalConcurrencyShares;
    return (A) this;
  }
  public class LimitResponseNested<N> extends LimitResponseFluent<LimitResponseNested<N>> implements Nested<N>{
  
    LimitResponseBuilder builder;
  
    LimitResponseNested(LimitResponse item) {
      this.builder = new LimitResponseBuilder(this, item);
    }
  
    public N and() {
      return (N) LimitedPriorityLevelConfigurationFluent.this.withLimitResponse(builder.build());
    }
    
    public N endLimitResponse() {
      return and();
    }
    
  }
}