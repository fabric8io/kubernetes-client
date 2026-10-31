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
  private PlatformRightSizingRecommendationSpecBuilder namespaceRightSizingRecommendation;
  private PlatformRightSizingRecommendationSpecBuilder virtualizationRightSizingRecommendation;

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
  
  public PlatformRightSizingRecommendationSpec buildNamespaceRightSizingRecommendation() {
    return this.namespaceRightSizingRecommendation != null ? this.namespaceRightSizingRecommendation.build() : null;
  }
  
  public PlatformRightSizingRecommendationSpec buildVirtualizationRightSizingRecommendation() {
    return this.virtualizationRightSizingRecommendation != null ? this.virtualizationRightSizingRecommendation.build() : null;
  }
  
  protected void copyInstance(PlatformAnalyticsSpec instance) {
    instance = instance != null ? instance : new PlatformAnalyticsSpec();
    if (instance != null) {
        this.withIncidentDetection(instance.getIncidentDetection());
        this.withNamespaceRightSizingRecommendation(instance.getNamespaceRightSizingRecommendation());
        this.withVirtualizationRightSizingRecommendation(instance.getVirtualizationRightSizingRecommendation());
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
    return this.withNewNamespaceRightSizingRecommendationLike(Optional.ofNullable(this.buildNamespaceRightSizingRecommendation()).orElse(new PlatformRightSizingRecommendationSpecBuilder().build()));
  }
  
  public NamespaceRightSizingRecommendationNested<A> editOrNewNamespaceRightSizingRecommendationLike(PlatformRightSizingRecommendationSpec item) {
    return this.withNewNamespaceRightSizingRecommendationLike(Optional.ofNullable(this.buildNamespaceRightSizingRecommendation()).orElse(item));
  }
  
  public VirtualizationRightSizingRecommendationNested<A> editOrNewVirtualizationRightSizingRecommendation() {
    return this.withNewVirtualizationRightSizingRecommendationLike(Optional.ofNullable(this.buildVirtualizationRightSizingRecommendation()).orElse(new PlatformRightSizingRecommendationSpecBuilder().build()));
  }
  
  public VirtualizationRightSizingRecommendationNested<A> editOrNewVirtualizationRightSizingRecommendationLike(PlatformRightSizingRecommendationSpec item) {
    return this.withNewVirtualizationRightSizingRecommendationLike(Optional.ofNullable(this.buildVirtualizationRightSizingRecommendation()).orElse(item));
  }
  
  public VirtualizationRightSizingRecommendationNested<A> editVirtualizationRightSizingRecommendation() {
    return this.withNewVirtualizationRightSizingRecommendationLike(Optional.ofNullable(this.buildVirtualizationRightSizingRecommendation()).orElse(null));
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
    if (!(Objects.equals(virtualizationRightSizingRecommendation, that.virtualizationRightSizingRecommendation))) {
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
  
  public boolean hasVirtualizationRightSizingRecommendation() {
    return this.virtualizationRightSizingRecommendation != null;
  }
  
  public int hashCode() {
    return Objects.hash(incidentDetection, namespaceRightSizingRecommendation, virtualizationRightSizingRecommendation, additionalProperties);
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
    if (!(virtualizationRightSizingRecommendation == null)) {
        sb.append("virtualizationRightSizingRecommendation:");
        sb.append(virtualizationRightSizingRecommendation);
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
  
  public A withNamespaceRightSizingRecommendation(PlatformRightSizingRecommendationSpec namespaceRightSizingRecommendation) {
    this._visitables.remove("namespaceRightSizingRecommendation");
    if (namespaceRightSizingRecommendation != null) {
        this.namespaceRightSizingRecommendation = new PlatformRightSizingRecommendationSpecBuilder(namespaceRightSizingRecommendation);
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
    return (A) this.withNamespaceRightSizingRecommendation(new PlatformRightSizingRecommendationSpec(enabled, namespaceBinding));
  }
  
  public NamespaceRightSizingRecommendationNested<A> withNewNamespaceRightSizingRecommendationLike(PlatformRightSizingRecommendationSpec item) {
    return new NamespaceRightSizingRecommendationNested(item);
  }
  
  public VirtualizationRightSizingRecommendationNested<A> withNewVirtualizationRightSizingRecommendation() {
    return new VirtualizationRightSizingRecommendationNested(null);
  }
  
  public A withNewVirtualizationRightSizingRecommendation(Boolean enabled,String namespaceBinding) {
    return (A) this.withVirtualizationRightSizingRecommendation(new PlatformRightSizingRecommendationSpec(enabled, namespaceBinding));
  }
  
  public VirtualizationRightSizingRecommendationNested<A> withNewVirtualizationRightSizingRecommendationLike(PlatformRightSizingRecommendationSpec item) {
    return new VirtualizationRightSizingRecommendationNested(item);
  }
  
  public A withVirtualizationRightSizingRecommendation(PlatformRightSizingRecommendationSpec virtualizationRightSizingRecommendation) {
    this._visitables.remove("virtualizationRightSizingRecommendation");
    if (virtualizationRightSizingRecommendation != null) {
        this.virtualizationRightSizingRecommendation = new PlatformRightSizingRecommendationSpecBuilder(virtualizationRightSizingRecommendation);
        this._visitables.get("virtualizationRightSizingRecommendation").add(this.virtualizationRightSizingRecommendation);
    } else {
        this.virtualizationRightSizingRecommendation = null;
        this._visitables.get("virtualizationRightSizingRecommendation").remove(this.virtualizationRightSizingRecommendation);
    }
    return (A) this;
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
  public class NamespaceRightSizingRecommendationNested<N> extends PlatformRightSizingRecommendationSpecFluent<NamespaceRightSizingRecommendationNested<N>> implements Nested<N>{
  
    PlatformRightSizingRecommendationSpecBuilder builder;
  
    NamespaceRightSizingRecommendationNested(PlatformRightSizingRecommendationSpec item) {
      this.builder = new PlatformRightSizingRecommendationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformAnalyticsSpecFluent.this.withNamespaceRightSizingRecommendation(builder.build());
    }
    
    public N endNamespaceRightSizingRecommendation() {
      return and();
    }
    
  }
  public class VirtualizationRightSizingRecommendationNested<N> extends PlatformRightSizingRecommendationSpecFluent<VirtualizationRightSizingRecommendationNested<N>> implements Nested<N>{
  
    PlatformRightSizingRecommendationSpecBuilder builder;
  
    VirtualizationRightSizingRecommendationNested(PlatformRightSizingRecommendationSpec item) {
      this.builder = new PlatformRightSizingRecommendationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformAnalyticsSpecFluent.this.withVirtualizationRightSizingRecommendation(builder.build());
    }
    
    public N endVirtualizationRightSizingRecommendation() {
      return and();
    }
    
  }
}