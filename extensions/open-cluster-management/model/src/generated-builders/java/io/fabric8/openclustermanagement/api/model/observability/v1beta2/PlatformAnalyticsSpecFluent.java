package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class PlatformAnalyticsSpecFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.PlatformAnalyticsSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PlatformIncidentDetectionSpecBuilder incidentDetection;
  private PlatformNamespaceRightSizingRecommendationSpecBuilder namespaceRightSizingRecommendation;

  public PlatformAnalyticsSpecFluent() {
  }
  
  public PlatformAnalyticsSpecFluent(PlatformAnalyticsSpec instance) {
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
  
  public PlatformIncidentDetectionSpec buildIncidentDetection() {
    return this.incidentDetection != null ? this.incidentDetection.build() : null;
  }
  
  public PlatformNamespaceRightSizingRecommendationSpec buildNamespaceRightSizingRecommendation() {
    return this.namespaceRightSizingRecommendation != null ? this.namespaceRightSizingRecommendation.build() : null;
  }
  
  protected void copyInstance(PlatformAnalyticsSpec instance) {
    instance = instance != null ? instance : new PlatformAnalyticsSpec();
    if (instance != null) {
        this.withIncidentDetection(instance.getIncidentDetection());
        this.withNamespaceRightSizingRecommendation(instance.getNamespaceRightSizingRecommendation());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IncidentDetectionNested<A> editIncidentDetection() {
    return this.withNewIncidentDetectionLike(Optional.ofNullable(this.buildIncidentDetection()).orElse(null));
  }
  
  public NamespaceRightSizingRecommendationNested<A> editNamespaceRightSizingRecommendation() {
    return this.withNewNamespaceRightSizingRecommendationLike(Optional.ofNullable(this.buildNamespaceRightSizingRecommendation()).orElse(null));
  }
  
  public IncidentDetectionNested<A> editOrNewIncidentDetection() {
    return this.withNewIncidentDetectionLike(Optional.ofNullable(this.buildIncidentDetection()).orElse(new PlatformIncidentDetectionSpecBuilder().build()));
  }
  
  public IncidentDetectionNested<A> editOrNewIncidentDetectionLike(PlatformIncidentDetectionSpec item) {
    return this.withNewIncidentDetectionLike(Optional.ofNullable(this.buildIncidentDetection()).orElse(item));
  }
  
  public NamespaceRightSizingRecommendationNested<A> editOrNewNamespaceRightSizingRecommendation() {
    return this.withNewNamespaceRightSizingRecommendationLike(Optional.ofNullable(this.buildNamespaceRightSizingRecommendation()).orElse(new PlatformNamespaceRightSizingRecommendationSpecBuilder().build()));
  }
  
  public NamespaceRightSizingRecommendationNested<A> editOrNewNamespaceRightSizingRecommendationLike(PlatformNamespaceRightSizingRecommendationSpec item) {
    return this.withNewNamespaceRightSizingRecommendationLike(Optional.ofNullable(this.buildNamespaceRightSizingRecommendation()).orElse(item));
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
    PlatformAnalyticsSpecFluent that = (PlatformAnalyticsSpecFluent) o;
    if (!(Objects.equals(incidentDetection, that.incidentDetection))) {
      return false;
    }
    if (!(Objects.equals(namespaceRightSizingRecommendation, that.namespaceRightSizingRecommendation))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIncidentDetection() {
    return this.incidentDetection != null;
  }
  
  public boolean hasNamespaceRightSizingRecommendation() {
    return this.namespaceRightSizingRecommendation != null;
  }
  
  public int hashCode() {
    return Objects.hash(incidentDetection, namespaceRightSizingRecommendation, additionalProperties);
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
    if (!(incidentDetection == null)) {
        sb.append("incidentDetection:");
        sb.append(incidentDetection);
        sb.append(",");
    }
    if (!(namespaceRightSizingRecommendation == null)) {
        sb.append("namespaceRightSizingRecommendation:");
        sb.append(namespaceRightSizingRecommendation);
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
  
  public A withIncidentDetection(PlatformIncidentDetectionSpec incidentDetection) {
    this._visitables.remove("incidentDetection");
    if (incidentDetection != null) {
        this.incidentDetection = new PlatformIncidentDetectionSpecBuilder(incidentDetection);
        this._visitables.get("incidentDetection").add(this.incidentDetection);
    } else {
        this.incidentDetection = null;
        this._visitables.get("incidentDetection").remove(this.incidentDetection);
    }
    return (A) this;
  }
  
  public A withNamespaceRightSizingRecommendation(PlatformNamespaceRightSizingRecommendationSpec namespaceRightSizingRecommendation) {
    this._visitables.remove("namespaceRightSizingRecommendation");
    if (namespaceRightSizingRecommendation != null) {
        this.namespaceRightSizingRecommendation = new PlatformNamespaceRightSizingRecommendationSpecBuilder(namespaceRightSizingRecommendation);
        this._visitables.get("namespaceRightSizingRecommendation").add(this.namespaceRightSizingRecommendation);
    } else {
        this.namespaceRightSizingRecommendation = null;
        this._visitables.get("namespaceRightSizingRecommendation").remove(this.namespaceRightSizingRecommendation);
    }
    return (A) this;
  }
  
  public IncidentDetectionNested<A> withNewIncidentDetection() {
    return new IncidentDetectionNested(null);
  }
  
  public A withNewIncidentDetection(Boolean enabled) {
    return (A) this.withIncidentDetection(new PlatformIncidentDetectionSpec(enabled));
  }
  
  public IncidentDetectionNested<A> withNewIncidentDetectionLike(PlatformIncidentDetectionSpec item) {
    return new IncidentDetectionNested(item);
  }
  
  public NamespaceRightSizingRecommendationNested<A> withNewNamespaceRightSizingRecommendation() {
    return new NamespaceRightSizingRecommendationNested(null);
  }
  
  public A withNewNamespaceRightSizingRecommendation(Boolean enabled,String namespaceBinding) {
    return (A) this.withNamespaceRightSizingRecommendation(new PlatformNamespaceRightSizingRecommendationSpec(enabled, namespaceBinding));
  }
  
  public NamespaceRightSizingRecommendationNested<A> withNewNamespaceRightSizingRecommendationLike(PlatformNamespaceRightSizingRecommendationSpec item) {
    return new NamespaceRightSizingRecommendationNested(item);
  }
  public class IncidentDetectionNested<N> extends PlatformIncidentDetectionSpecFluent<IncidentDetectionNested<N>> implements Nested<N>{
  
    PlatformIncidentDetectionSpecBuilder builder;
  
    IncidentDetectionNested(PlatformIncidentDetectionSpec item) {
      this.builder = new PlatformIncidentDetectionSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformAnalyticsSpecFluent.this.withIncidentDetection(builder.build());
    }
    
    public N endIncidentDetection() {
      return and();
    }
    
  }
  public class NamespaceRightSizingRecommendationNested<N> extends PlatformNamespaceRightSizingRecommendationSpecFluent<NamespaceRightSizingRecommendationNested<N>> implements Nested<N>{
  
    PlatformNamespaceRightSizingRecommendationSpecBuilder builder;
  
    NamespaceRightSizingRecommendationNested(PlatformNamespaceRightSizingRecommendationSpec item) {
      this.builder = new PlatformNamespaceRightSizingRecommendationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformAnalyticsSpecFluent.this.withNamespaceRightSizingRecommendation(builder.build());
    }
    
    public N endNamespaceRightSizingRecommendation() {
      return and();
    }
    
  }
}