package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class HostDeployPolicySpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HostDeployPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HostClaimNamespacesBuilder hostClaimNamespaces;

  public HostDeployPolicySpecFluent() {
  }
  
  public HostDeployPolicySpecFluent(HostDeployPolicySpec instance) {
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
  
  public HostClaimNamespaces buildHostClaimNamespaces() {
    return this.hostClaimNamespaces != null ? this.hostClaimNamespaces.build() : null;
  }
  
  protected void copyInstance(HostDeployPolicySpec instance) {
    instance = instance != null ? instance : new HostDeployPolicySpec();
    if (instance != null) {
        this.withHostClaimNamespaces(instance.getHostClaimNamespaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HostClaimNamespacesNested<A> editHostClaimNamespaces() {
    return this.withNewHostClaimNamespacesLike(Optional.ofNullable(this.buildHostClaimNamespaces()).orElse(null));
  }
  
  public HostClaimNamespacesNested<A> editOrNewHostClaimNamespaces() {
    return this.withNewHostClaimNamespacesLike(Optional.ofNullable(this.buildHostClaimNamespaces()).orElse(new HostClaimNamespacesBuilder().build()));
  }
  
  public HostClaimNamespacesNested<A> editOrNewHostClaimNamespacesLike(HostClaimNamespaces item) {
    return this.withNewHostClaimNamespacesLike(Optional.ofNullable(this.buildHostClaimNamespaces()).orElse(item));
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
    HostDeployPolicySpecFluent that = (HostDeployPolicySpecFluent) o;
    if (!(Objects.equals(hostClaimNamespaces, that.hostClaimNamespaces))) {
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
  
  public boolean hasHostClaimNamespaces() {
    return this.hostClaimNamespaces != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostClaimNamespaces, additionalProperties);
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
    if (!(hostClaimNamespaces == null)) {
        sb.append("hostClaimNamespaces:");
        sb.append(hostClaimNamespaces);
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
  
  public A withHostClaimNamespaces(HostClaimNamespaces hostClaimNamespaces) {
    this._visitables.remove("hostClaimNamespaces");
    if (hostClaimNamespaces != null) {
        this.hostClaimNamespaces = new HostClaimNamespacesBuilder(hostClaimNamespaces);
        this._visitables.get("hostClaimNamespaces").add(this.hostClaimNamespaces);
    } else {
        this.hostClaimNamespaces = null;
        this._visitables.get("hostClaimNamespaces").remove(this.hostClaimNamespaces);
    }
    return (A) this;
  }
  
  public HostClaimNamespacesNested<A> withNewHostClaimNamespaces() {
    return new HostClaimNamespacesNested(null);
  }
  
  public HostClaimNamespacesNested<A> withNewHostClaimNamespacesLike(HostClaimNamespaces item) {
    return new HostClaimNamespacesNested(item);
  }
  public class HostClaimNamespacesNested<N> extends HostClaimNamespacesFluent<HostClaimNamespacesNested<N>> implements Nested<N>{
  
    HostClaimNamespacesBuilder builder;
  
    HostClaimNamespacesNested(HostClaimNamespaces item) {
      this.builder = new HostClaimNamespacesBuilder(this, item);
    }
  
    public N and() {
      return (N) HostDeployPolicySpecFluent.this.withHostClaimNamespaces(builder.build());
    }
    
    public N endHostClaimNamespaces() {
      return and();
    }
    
  }
}