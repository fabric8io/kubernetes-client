package io.fabric8.openshift.api.model.operator.v1;

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
public class AWSCSIDriverConfigSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.AWSCSIDriverConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSEFSVolumeMetricsBuilder efsVolumeMetrics;
  private String kmsKeyARN;

  public AWSCSIDriverConfigSpecFluent() {
  }
  
  public AWSCSIDriverConfigSpecFluent(AWSCSIDriverConfigSpec instance) {
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
  
  public AWSEFSVolumeMetrics buildEfsVolumeMetrics() {
    return this.efsVolumeMetrics != null ? this.efsVolumeMetrics.build() : null;
  }
  
  protected void copyInstance(AWSCSIDriverConfigSpec instance) {
    instance = instance != null ? instance : new AWSCSIDriverConfigSpec();
    if (instance != null) {
        this.withEfsVolumeMetrics(instance.getEfsVolumeMetrics());
        this.withKmsKeyARN(instance.getKmsKeyARN());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EfsVolumeMetricsNested<A> editEfsVolumeMetrics() {
    return this.withNewEfsVolumeMetricsLike(Optional.ofNullable(this.buildEfsVolumeMetrics()).orElse(null));
  }
  
  public EfsVolumeMetricsNested<A> editOrNewEfsVolumeMetrics() {
    return this.withNewEfsVolumeMetricsLike(Optional.ofNullable(this.buildEfsVolumeMetrics()).orElse(new AWSEFSVolumeMetricsBuilder().build()));
  }
  
  public EfsVolumeMetricsNested<A> editOrNewEfsVolumeMetricsLike(AWSEFSVolumeMetrics item) {
    return this.withNewEfsVolumeMetricsLike(Optional.ofNullable(this.buildEfsVolumeMetrics()).orElse(item));
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
    AWSCSIDriverConfigSpecFluent that = (AWSCSIDriverConfigSpecFluent) o;
    if (!(Objects.equals(efsVolumeMetrics, that.efsVolumeMetrics))) {
      return false;
    }
    if (!(Objects.equals(kmsKeyARN, that.kmsKeyARN))) {
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
  
  public String getKmsKeyARN() {
    return this.kmsKeyARN;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEfsVolumeMetrics() {
    return this.efsVolumeMetrics != null;
  }
  
  public boolean hasKmsKeyARN() {
    return this.kmsKeyARN != null;
  }
  
  public int hashCode() {
    return Objects.hash(efsVolumeMetrics, kmsKeyARN, additionalProperties);
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
    if (!(efsVolumeMetrics == null)) {
        sb.append("efsVolumeMetrics:");
        sb.append(efsVolumeMetrics);
        sb.append(",");
    }
    if (!(kmsKeyARN == null)) {
        sb.append("kmsKeyARN:");
        sb.append(kmsKeyARN);
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
  
  public A withEfsVolumeMetrics(AWSEFSVolumeMetrics efsVolumeMetrics) {
    this._visitables.remove("efsVolumeMetrics");
    if (efsVolumeMetrics != null) {
        this.efsVolumeMetrics = new AWSEFSVolumeMetricsBuilder(efsVolumeMetrics);
        this._visitables.get("efsVolumeMetrics").add(this.efsVolumeMetrics);
    } else {
        this.efsVolumeMetrics = null;
        this._visitables.get("efsVolumeMetrics").remove(this.efsVolumeMetrics);
    }
    return (A) this;
  }
  
  public A withKmsKeyARN(String kmsKeyARN) {
    this.kmsKeyARN = kmsKeyARN;
    return (A) this;
  }
  
  public EfsVolumeMetricsNested<A> withNewEfsVolumeMetrics() {
    return new EfsVolumeMetricsNested(null);
  }
  
  public EfsVolumeMetricsNested<A> withNewEfsVolumeMetricsLike(AWSEFSVolumeMetrics item) {
    return new EfsVolumeMetricsNested(item);
  }
  public class EfsVolumeMetricsNested<N> extends AWSEFSVolumeMetricsFluent<EfsVolumeMetricsNested<N>> implements Nested<N>{
  
    AWSEFSVolumeMetricsBuilder builder;
  
    EfsVolumeMetricsNested(AWSEFSVolumeMetrics item) {
      this.builder = new AWSEFSVolumeMetricsBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSCSIDriverConfigSpecFluent.this.withEfsVolumeMetrics(builder.build());
    }
    
    public N endEfsVolumeMetrics() {
      return and();
    }
    
  }
}