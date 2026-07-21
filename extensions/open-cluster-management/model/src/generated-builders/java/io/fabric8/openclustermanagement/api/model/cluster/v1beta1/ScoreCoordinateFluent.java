package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ScoreCoordinateFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ScoreCoordinateFluent<A>> extends BaseFluent<A>{

  private AddOnScoreBuilder addOn;
  private Map<String,Object> additionalProperties;
  private String builtIn;
  private String type;

  public ScoreCoordinateFluent() {
  }
  
  public ScoreCoordinateFluent(ScoreCoordinate instance) {
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
  
  public AddOnScore buildAddOn() {
    return this.addOn != null ? this.addOn.build() : null;
  }
  
  protected void copyInstance(ScoreCoordinate instance) {
    instance = instance != null ? instance : new ScoreCoordinate();
    if (instance != null) {
        this.withAddOn(instance.getAddOn());
        this.withBuiltIn(instance.getBuiltIn());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddOnNested<A> editAddOn() {
    return this.withNewAddOnLike(Optional.ofNullable(this.buildAddOn()).orElse(null));
  }
  
  public AddOnNested<A> editOrNewAddOn() {
    return this.withNewAddOnLike(Optional.ofNullable(this.buildAddOn()).orElse(new AddOnScoreBuilder().build()));
  }
  
  public AddOnNested<A> editOrNewAddOnLike(AddOnScore item) {
    return this.withNewAddOnLike(Optional.ofNullable(this.buildAddOn()).orElse(item));
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
    ScoreCoordinateFluent that = (ScoreCoordinateFluent) o;
    if (!(Objects.equals(addOn, that.addOn))) {
      return false;
    }
    if (!(Objects.equals(builtIn, that.builtIn))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getBuiltIn() {
    return this.builtIn;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAddOn() {
    return this.addOn != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBuiltIn() {
    return this.builtIn != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(addOn, builtIn, type, additionalProperties);
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
    if (!(addOn == null)) {
        sb.append("addOn:");
        sb.append(addOn);
        sb.append(",");
    }
    if (!(builtIn == null)) {
        sb.append("builtIn:");
        sb.append(builtIn);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAddOn(AddOnScore addOn) {
    this._visitables.remove("addOn");
    if (addOn != null) {
        this.addOn = new AddOnScoreBuilder(addOn);
        this._visitables.get("addOn").add(this.addOn);
    } else {
        this.addOn = null;
        this._visitables.get("addOn").remove(this.addOn);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBuiltIn(String builtIn) {
    this.builtIn = builtIn;
    return (A) this;
  }
  
  public AddOnNested<A> withNewAddOn() {
    return new AddOnNested(null);
  }
  
  public A withNewAddOn(String resourceName,String scoreName) {
    return (A) this.withAddOn(new AddOnScore(resourceName, scoreName));
  }
  
  public AddOnNested<A> withNewAddOnLike(AddOnScore item) {
    return new AddOnNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class AddOnNested<N> extends AddOnScoreFluent<AddOnNested<N>> implements Nested<N>{
  
    AddOnScoreBuilder builder;
  
    AddOnNested(AddOnScore item) {
      this.builder = new AddOnScoreBuilder(this, item);
    }
  
    public N and() {
      return (N) ScoreCoordinateFluent.this.withAddOn(builder.build());
    }
    
    public N endAddOn() {
      return and();
    }
    
  }
}