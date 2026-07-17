package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class SecuritySettingsFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.SecuritySettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfidentialVMBuilder confidentialVM;
  private String securityType;
  private TrustedLaunchBuilder trustedLaunch;

  public SecuritySettingsFluent() {
  }
  
  public SecuritySettingsFluent(SecuritySettings instance) {
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
  
  public ConfidentialVM buildConfidentialVM() {
    return this.confidentialVM != null ? this.confidentialVM.build() : null;
  }
  
  public TrustedLaunch buildTrustedLaunch() {
    return this.trustedLaunch != null ? this.trustedLaunch.build() : null;
  }
  
  protected void copyInstance(SecuritySettings instance) {
    instance = instance != null ? instance : new SecuritySettings();
    if (instance != null) {
        this.withConfidentialVM(instance.getConfidentialVM());
        this.withSecurityType(instance.getSecurityType());
        this.withTrustedLaunch(instance.getTrustedLaunch());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfidentialVMNested<A> editConfidentialVM() {
    return this.withNewConfidentialVMLike(Optional.ofNullable(this.buildConfidentialVM()).orElse(null));
  }
  
  public ConfidentialVMNested<A> editOrNewConfidentialVM() {
    return this.withNewConfidentialVMLike(Optional.ofNullable(this.buildConfidentialVM()).orElse(new ConfidentialVMBuilder().build()));
  }
  
  public ConfidentialVMNested<A> editOrNewConfidentialVMLike(ConfidentialVM item) {
    return this.withNewConfidentialVMLike(Optional.ofNullable(this.buildConfidentialVM()).orElse(item));
  }
  
  public TrustedLaunchNested<A> editOrNewTrustedLaunch() {
    return this.withNewTrustedLaunchLike(Optional.ofNullable(this.buildTrustedLaunch()).orElse(new TrustedLaunchBuilder().build()));
  }
  
  public TrustedLaunchNested<A> editOrNewTrustedLaunchLike(TrustedLaunch item) {
    return this.withNewTrustedLaunchLike(Optional.ofNullable(this.buildTrustedLaunch()).orElse(item));
  }
  
  public TrustedLaunchNested<A> editTrustedLaunch() {
    return this.withNewTrustedLaunchLike(Optional.ofNullable(this.buildTrustedLaunch()).orElse(null));
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
    SecuritySettingsFluent that = (SecuritySettingsFluent) o;
    if (!(Objects.equals(confidentialVM, that.confidentialVM))) {
      return false;
    }
    if (!(Objects.equals(securityType, that.securityType))) {
      return false;
    }
    if (!(Objects.equals(trustedLaunch, that.trustedLaunch))) {
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
  
  public String getSecurityType() {
    return this.securityType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfidentialVM() {
    return this.confidentialVM != null;
  }
  
  public boolean hasSecurityType() {
    return this.securityType != null;
  }
  
  public boolean hasTrustedLaunch() {
    return this.trustedLaunch != null;
  }
  
  public int hashCode() {
    return Objects.hash(confidentialVM, securityType, trustedLaunch, additionalProperties);
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
    if (!(confidentialVM == null)) {
        sb.append("confidentialVM:");
        sb.append(confidentialVM);
        sb.append(",");
    }
    if (!(securityType == null)) {
        sb.append("securityType:");
        sb.append(securityType);
        sb.append(",");
    }
    if (!(trustedLaunch == null)) {
        sb.append("trustedLaunch:");
        sb.append(trustedLaunch);
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
  
  public A withConfidentialVM(ConfidentialVM confidentialVM) {
    this._visitables.remove("confidentialVM");
    if (confidentialVM != null) {
        this.confidentialVM = new ConfidentialVMBuilder(confidentialVM);
        this._visitables.get("confidentialVM").add(this.confidentialVM);
    } else {
        this.confidentialVM = null;
        this._visitables.get("confidentialVM").remove(this.confidentialVM);
    }
    return (A) this;
  }
  
  public ConfidentialVMNested<A> withNewConfidentialVM() {
    return new ConfidentialVMNested(null);
  }
  
  public ConfidentialVMNested<A> withNewConfidentialVMLike(ConfidentialVM item) {
    return new ConfidentialVMNested(item);
  }
  
  public TrustedLaunchNested<A> withNewTrustedLaunch() {
    return new TrustedLaunchNested(null);
  }
  
  public TrustedLaunchNested<A> withNewTrustedLaunchLike(TrustedLaunch item) {
    return new TrustedLaunchNested(item);
  }
  
  public A withSecurityType(String securityType) {
    this.securityType = securityType;
    return (A) this;
  }
  
  public A withTrustedLaunch(TrustedLaunch trustedLaunch) {
    this._visitables.remove("trustedLaunch");
    if (trustedLaunch != null) {
        this.trustedLaunch = new TrustedLaunchBuilder(trustedLaunch);
        this._visitables.get("trustedLaunch").add(this.trustedLaunch);
    } else {
        this.trustedLaunch = null;
        this._visitables.get("trustedLaunch").remove(this.trustedLaunch);
    }
    return (A) this;
  }
  public class ConfidentialVMNested<N> extends ConfidentialVMFluent<ConfidentialVMNested<N>> implements Nested<N>{
  
    ConfidentialVMBuilder builder;
  
    ConfidentialVMNested(ConfidentialVM item) {
      this.builder = new ConfidentialVMBuilder(this, item);
    }
  
    public N and() {
      return (N) SecuritySettingsFluent.this.withConfidentialVM(builder.build());
    }
    
    public N endConfidentialVM() {
      return and();
    }
    
  }
  public class TrustedLaunchNested<N> extends TrustedLaunchFluent<TrustedLaunchNested<N>> implements Nested<N>{
  
    TrustedLaunchBuilder builder;
  
    TrustedLaunchNested(TrustedLaunch item) {
      this.builder = new TrustedLaunchBuilder(this, item);
    }
  
    public N and() {
      return (N) SecuritySettingsFluent.this.withTrustedLaunch(builder.build());
    }
    
    public N endTrustedLaunch() {
      return and();
    }
    
  }
}