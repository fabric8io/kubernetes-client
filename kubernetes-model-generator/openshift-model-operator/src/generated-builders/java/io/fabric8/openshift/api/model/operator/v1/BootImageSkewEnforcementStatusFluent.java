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
public class BootImageSkewEnforcementStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1.BootImageSkewEnforcementStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterBootImageAutomaticBuilder automatic;
  private ClusterBootImageManualBuilder manual;
  private String mode;

  public BootImageSkewEnforcementStatusFluent() {
  }
  
  public BootImageSkewEnforcementStatusFluent(BootImageSkewEnforcementStatus instance) {
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
  
  public ClusterBootImageAutomatic buildAutomatic() {
    return this.automatic != null ? this.automatic.build() : null;
  }
  
  public ClusterBootImageManual buildManual() {
    return this.manual != null ? this.manual.build() : null;
  }
  
  protected void copyInstance(BootImageSkewEnforcementStatus instance) {
    instance = instance != null ? instance : new BootImageSkewEnforcementStatus();
    if (instance != null) {
        this.withAutomatic(instance.getAutomatic());
        this.withManual(instance.getManual());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AutomaticNested<A> editAutomatic() {
    return this.withNewAutomaticLike(Optional.ofNullable(this.buildAutomatic()).orElse(null));
  }
  
  public ManualNested<A> editManual() {
    return this.withNewManualLike(Optional.ofNullable(this.buildManual()).orElse(null));
  }
  
  public AutomaticNested<A> editOrNewAutomatic() {
    return this.withNewAutomaticLike(Optional.ofNullable(this.buildAutomatic()).orElse(new ClusterBootImageAutomaticBuilder().build()));
  }
  
  public AutomaticNested<A> editOrNewAutomaticLike(ClusterBootImageAutomatic item) {
    return this.withNewAutomaticLike(Optional.ofNullable(this.buildAutomatic()).orElse(item));
  }
  
  public ManualNested<A> editOrNewManual() {
    return this.withNewManualLike(Optional.ofNullable(this.buildManual()).orElse(new ClusterBootImageManualBuilder().build()));
  }
  
  public ManualNested<A> editOrNewManualLike(ClusterBootImageManual item) {
    return this.withNewManualLike(Optional.ofNullable(this.buildManual()).orElse(item));
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
    BootImageSkewEnforcementStatusFluent that = (BootImageSkewEnforcementStatusFluent) o;
    if (!(Objects.equals(automatic, that.automatic))) {
      return false;
    }
    if (!(Objects.equals(manual, that.manual))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutomatic() {
    return this.automatic != null;
  }
  
  public boolean hasManual() {
    return this.manual != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(automatic, manual, mode, additionalProperties);
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
    if (!(automatic == null)) {
        sb.append("automatic:");
        sb.append(automatic);
        sb.append(",");
    }
    if (!(manual == null)) {
        sb.append("manual:");
        sb.append(manual);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withAutomatic(ClusterBootImageAutomatic automatic) {
    this._visitables.remove("automatic");
    if (automatic != null) {
        this.automatic = new ClusterBootImageAutomaticBuilder(automatic);
        this._visitables.get("automatic").add(this.automatic);
    } else {
        this.automatic = null;
        this._visitables.get("automatic").remove(this.automatic);
    }
    return (A) this;
  }
  
  public A withManual(ClusterBootImageManual manual) {
    this._visitables.remove("manual");
    if (manual != null) {
        this.manual = new ClusterBootImageManualBuilder(manual);
        this._visitables.get("manual").add(this.manual);
    } else {
        this.manual = null;
        this._visitables.get("manual").remove(this.manual);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public AutomaticNested<A> withNewAutomatic() {
    return new AutomaticNested(null);
  }
  
  public A withNewAutomatic(String ocpVersion,String rhcosVersion) {
    return (A) this.withAutomatic(new ClusterBootImageAutomatic(ocpVersion, rhcosVersion));
  }
  
  public AutomaticNested<A> withNewAutomaticLike(ClusterBootImageAutomatic item) {
    return new AutomaticNested(item);
  }
  
  public ManualNested<A> withNewManual() {
    return new ManualNested(null);
  }
  
  public A withNewManual(String mode,String ocpVersion,String rhcosVersion) {
    return (A) this.withManual(new ClusterBootImageManual(mode, ocpVersion, rhcosVersion));
  }
  
  public ManualNested<A> withNewManualLike(ClusterBootImageManual item) {
    return new ManualNested(item);
  }
  public class AutomaticNested<N> extends ClusterBootImageAutomaticFluent<AutomaticNested<N>> implements Nested<N>{
  
    ClusterBootImageAutomaticBuilder builder;
  
    AutomaticNested(ClusterBootImageAutomatic item) {
      this.builder = new ClusterBootImageAutomaticBuilder(this, item);
    }
  
    public N and() {
      return (N) BootImageSkewEnforcementStatusFluent.this.withAutomatic(builder.build());
    }
    
    public N endAutomatic() {
      return and();
    }
    
  }
  public class ManualNested<N> extends ClusterBootImageManualFluent<ManualNested<N>> implements Nested<N>{
  
    ClusterBootImageManualBuilder builder;
  
    ManualNested(ClusterBootImageManual item) {
      this.builder = new ClusterBootImageManualBuilder(this, item);
    }
  
    public N and() {
      return (N) BootImageSkewEnforcementStatusFluent.this.withManual(builder.build());
    }
    
    public N endManual() {
      return and();
    }
    
  }
}