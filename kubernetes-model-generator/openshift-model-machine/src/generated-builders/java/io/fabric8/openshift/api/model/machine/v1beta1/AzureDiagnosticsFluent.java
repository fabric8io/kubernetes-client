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
public class AzureDiagnosticsFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.AzureDiagnosticsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AzureBootDiagnosticsBuilder boot;

  public AzureDiagnosticsFluent() {
  }
  
  public AzureDiagnosticsFluent(AzureDiagnostics instance) {
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
  
  public AzureBootDiagnostics buildBoot() {
    return this.boot != null ? this.boot.build() : null;
  }
  
  protected void copyInstance(AzureDiagnostics instance) {
    instance = instance != null ? instance : new AzureDiagnostics();
    if (instance != null) {
        this.withBoot(instance.getBoot());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BootNested<A> editBoot() {
    return this.withNewBootLike(Optional.ofNullable(this.buildBoot()).orElse(null));
  }
  
  public BootNested<A> editOrNewBoot() {
    return this.withNewBootLike(Optional.ofNullable(this.buildBoot()).orElse(new AzureBootDiagnosticsBuilder().build()));
  }
  
  public BootNested<A> editOrNewBootLike(AzureBootDiagnostics item) {
    return this.withNewBootLike(Optional.ofNullable(this.buildBoot()).orElse(item));
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
    AzureDiagnosticsFluent that = (AzureDiagnosticsFluent) o;
    if (!(Objects.equals(boot, that.boot))) {
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
  
  public boolean hasBoot() {
    return this.boot != null;
  }
  
  public int hashCode() {
    return Objects.hash(boot, additionalProperties);
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
    if (!(boot == null)) {
        sb.append("boot:");
        sb.append(boot);
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
  
  public A withBoot(AzureBootDiagnostics boot) {
    this._visitables.remove("boot");
    if (boot != null) {
        this.boot = new AzureBootDiagnosticsBuilder(boot);
        this._visitables.get("boot").add(this.boot);
    } else {
        this.boot = null;
        this._visitables.get("boot").remove(this.boot);
    }
    return (A) this;
  }
  
  public BootNested<A> withNewBoot() {
    return new BootNested(null);
  }
  
  public BootNested<A> withNewBootLike(AzureBootDiagnostics item) {
    return new BootNested(item);
  }
  public class BootNested<N> extends AzureBootDiagnosticsFluent<BootNested<N>> implements Nested<N>{
  
    AzureBootDiagnosticsBuilder builder;
  
    BootNested(AzureBootDiagnostics item) {
      this.builder = new AzureBootDiagnosticsBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureDiagnosticsFluent.this.withBoot(builder.build());
    }
    
    public N endBoot() {
      return and();
    }
    
  }
}