package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class HTTPRequestMirrorFilterFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRequestMirrorFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BackendObjectReferenceBuilder backendRef;
  private FractionBuilder fraction;
  private Integer percent;

  public HTTPRequestMirrorFilterFluent() {
  }
  
  public HTTPRequestMirrorFilterFluent(HTTPRequestMirrorFilter instance) {
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
  
  public BackendObjectReference buildBackendRef() {
    return this.backendRef != null ? this.backendRef.build() : null;
  }
  
  public Fraction buildFraction() {
    return this.fraction != null ? this.fraction.build() : null;
  }
  
  protected void copyInstance(HTTPRequestMirrorFilter instance) {
    instance = instance != null ? instance : new HTTPRequestMirrorFilter();
    if (instance != null) {
        this.withBackendRef(instance.getBackendRef());
        this.withFraction(instance.getFraction());
        this.withPercent(instance.getPercent());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendRefNested<A> editBackendRef() {
    return this.withNewBackendRefLike(Optional.ofNullable(this.buildBackendRef()).orElse(null));
  }
  
  public FractionNested<A> editFraction() {
    return this.withNewFractionLike(Optional.ofNullable(this.buildFraction()).orElse(null));
  }
  
  public BackendRefNested<A> editOrNewBackendRef() {
    return this.withNewBackendRefLike(Optional.ofNullable(this.buildBackendRef()).orElse(new BackendObjectReferenceBuilder().build()));
  }
  
  public BackendRefNested<A> editOrNewBackendRefLike(BackendObjectReference item) {
    return this.withNewBackendRefLike(Optional.ofNullable(this.buildBackendRef()).orElse(item));
  }
  
  public FractionNested<A> editOrNewFraction() {
    return this.withNewFractionLike(Optional.ofNullable(this.buildFraction()).orElse(new FractionBuilder().build()));
  }
  
  public FractionNested<A> editOrNewFractionLike(Fraction item) {
    return this.withNewFractionLike(Optional.ofNullable(this.buildFraction()).orElse(item));
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
    HTTPRequestMirrorFilterFluent that = (HTTPRequestMirrorFilterFluent) o;
    if (!(Objects.equals(backendRef, that.backendRef))) {
      return false;
    }
    if (!(Objects.equals(fraction, that.fraction))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
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
  
  public Integer getPercent() {
    return this.percent;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackendRef() {
    return this.backendRef != null;
  }
  
  public boolean hasFraction() {
    return this.fraction != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public int hashCode() {
    return Objects.hash(backendRef, fraction, percent, additionalProperties);
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
    if (!(backendRef == null)) {
        sb.append("backendRef:");
        sb.append(backendRef);
        sb.append(",");
    }
    if (!(fraction == null)) {
        sb.append("fraction:");
        sb.append(fraction);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
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
  
  public A withBackendRef(BackendObjectReference backendRef) {
    this._visitables.remove("backendRef");
    if (backendRef != null) {
        this.backendRef = new BackendObjectReferenceBuilder(backendRef);
        this._visitables.get("backendRef").add(this.backendRef);
    } else {
        this.backendRef = null;
        this._visitables.get("backendRef").remove(this.backendRef);
    }
    return (A) this;
  }
  
  public A withFraction(Fraction fraction) {
    this._visitables.remove("fraction");
    if (fraction != null) {
        this.fraction = new FractionBuilder(fraction);
        this._visitables.get("fraction").add(this.fraction);
    } else {
        this.fraction = null;
        this._visitables.get("fraction").remove(this.fraction);
    }
    return (A) this;
  }
  
  public BackendRefNested<A> withNewBackendRef() {
    return new BackendRefNested(null);
  }
  
  public A withNewBackendRef(String group,String kind,String name,String namespace,Integer port) {
    return (A) this.withBackendRef(new BackendObjectReference(group, kind, name, namespace, port));
  }
  
  public BackendRefNested<A> withNewBackendRefLike(BackendObjectReference item) {
    return new BackendRefNested(item);
  }
  
  public FractionNested<A> withNewFraction() {
    return new FractionNested(null);
  }
  
  public A withNewFraction(Integer denominator,Integer numerator) {
    return (A) this.withFraction(new Fraction(denominator, numerator));
  }
  
  public FractionNested<A> withNewFractionLike(Fraction item) {
    return new FractionNested(item);
  }
  
  public A withPercent(Integer percent) {
    this.percent = percent;
    return (A) this;
  }
  public class BackendRefNested<N> extends BackendObjectReferenceFluent<BackendRefNested<N>> implements Nested<N>{
  
    BackendObjectReferenceBuilder builder;
  
    BackendRefNested(BackendObjectReference item) {
      this.builder = new BackendObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRequestMirrorFilterFluent.this.withBackendRef(builder.build());
    }
    
    public N endBackendRef() {
      return and();
    }
    
  }
  public class FractionNested<N> extends FractionFluent<FractionNested<N>> implements Nested<N>{
  
    FractionBuilder builder;
  
    FractionNested(Fraction item) {
      this.builder = new FractionBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRequestMirrorFilterFluent.this.withFraction(builder.build());
    }
    
    public N endFraction() {
      return and();
    }
    
  }
}