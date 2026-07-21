package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class PrioritizerConfigFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.PrioritizerConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ScoreCoordinateBuilder scoreCoordinate;
  private Integer weight;

  public PrioritizerConfigFluent() {
  }
  
  public PrioritizerConfigFluent(PrioritizerConfig instance) {
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
  
  public ScoreCoordinate buildScoreCoordinate() {
    return this.scoreCoordinate != null ? this.scoreCoordinate.build() : null;
  }
  
  protected void copyInstance(PrioritizerConfig instance) {
    instance = instance != null ? instance : new PrioritizerConfig();
    if (instance != null) {
        this.withScoreCoordinate(instance.getScoreCoordinate());
        this.withWeight(instance.getWeight());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScoreCoordinateNested<A> editOrNewScoreCoordinate() {
    return this.withNewScoreCoordinateLike(Optional.ofNullable(this.buildScoreCoordinate()).orElse(new ScoreCoordinateBuilder().build()));
  }
  
  public ScoreCoordinateNested<A> editOrNewScoreCoordinateLike(ScoreCoordinate item) {
    return this.withNewScoreCoordinateLike(Optional.ofNullable(this.buildScoreCoordinate()).orElse(item));
  }
  
  public ScoreCoordinateNested<A> editScoreCoordinate() {
    return this.withNewScoreCoordinateLike(Optional.ofNullable(this.buildScoreCoordinate()).orElse(null));
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
    PrioritizerConfigFluent that = (PrioritizerConfigFluent) o;
    if (!(Objects.equals(scoreCoordinate, that.scoreCoordinate))) {
      return false;
    }
    if (!(Objects.equals(weight, that.weight))) {
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
  
  public Integer getWeight() {
    return this.weight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasScoreCoordinate() {
    return this.scoreCoordinate != null;
  }
  
  public boolean hasWeight() {
    return this.weight != null;
  }
  
  public int hashCode() {
    return Objects.hash(scoreCoordinate, weight, additionalProperties);
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
    if (!(scoreCoordinate == null)) {
        sb.append("scoreCoordinate:");
        sb.append(scoreCoordinate);
        sb.append(",");
    }
    if (!(weight == null)) {
        sb.append("weight:");
        sb.append(weight);
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
  
  public ScoreCoordinateNested<A> withNewScoreCoordinate() {
    return new ScoreCoordinateNested(null);
  }
  
  public ScoreCoordinateNested<A> withNewScoreCoordinateLike(ScoreCoordinate item) {
    return new ScoreCoordinateNested(item);
  }
  
  public A withScoreCoordinate(ScoreCoordinate scoreCoordinate) {
    this._visitables.remove("scoreCoordinate");
    if (scoreCoordinate != null) {
        this.scoreCoordinate = new ScoreCoordinateBuilder(scoreCoordinate);
        this._visitables.get("scoreCoordinate").add(this.scoreCoordinate);
    } else {
        this.scoreCoordinate = null;
        this._visitables.get("scoreCoordinate").remove(this.scoreCoordinate);
    }
    return (A) this;
  }
  
  public A withWeight(Integer weight) {
    this.weight = weight;
    return (A) this;
  }
  public class ScoreCoordinateNested<N> extends ScoreCoordinateFluent<ScoreCoordinateNested<N>> implements Nested<N>{
  
    ScoreCoordinateBuilder builder;
  
    ScoreCoordinateNested(ScoreCoordinate item) {
      this.builder = new ScoreCoordinateBuilder(this, item);
    }
  
    public N and() {
      return (N) PrioritizerConfigFluent.this.withScoreCoordinate(builder.build());
    }
    
    public N endScoreCoordinate() {
      return and();
    }
    
  }
}