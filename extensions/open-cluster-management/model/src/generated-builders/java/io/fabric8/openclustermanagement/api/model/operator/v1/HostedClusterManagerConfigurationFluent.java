package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class HostedClusterManagerConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.HostedClusterManagerConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HostedWebhookConfigurationBuilder registrationWebhookConfiguration;
  private HostedWebhookConfigurationBuilder workWebhookConfiguration;

  public HostedClusterManagerConfigurationFluent() {
  }
  
  public HostedClusterManagerConfigurationFluent(HostedClusterManagerConfiguration instance) {
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
  
  public HostedWebhookConfiguration buildRegistrationWebhookConfiguration() {
    return this.registrationWebhookConfiguration != null ? this.registrationWebhookConfiguration.build() : null;
  }
  
  public HostedWebhookConfiguration buildWorkWebhookConfiguration() {
    return this.workWebhookConfiguration != null ? this.workWebhookConfiguration.build() : null;
  }
  
  protected void copyInstance(HostedClusterManagerConfiguration instance) {
    instance = instance != null ? instance : new HostedClusterManagerConfiguration();
    if (instance != null) {
        this.withRegistrationWebhookConfiguration(instance.getRegistrationWebhookConfiguration());
        this.withWorkWebhookConfiguration(instance.getWorkWebhookConfiguration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RegistrationWebhookConfigurationNested<A> editOrNewRegistrationWebhookConfiguration() {
    return this.withNewRegistrationWebhookConfigurationLike(Optional.ofNullable(this.buildRegistrationWebhookConfiguration()).orElse(new HostedWebhookConfigurationBuilder().build()));
  }
  
  public RegistrationWebhookConfigurationNested<A> editOrNewRegistrationWebhookConfigurationLike(HostedWebhookConfiguration item) {
    return this.withNewRegistrationWebhookConfigurationLike(Optional.ofNullable(this.buildRegistrationWebhookConfiguration()).orElse(item));
  }
  
  public WorkWebhookConfigurationNested<A> editOrNewWorkWebhookConfiguration() {
    return this.withNewWorkWebhookConfigurationLike(Optional.ofNullable(this.buildWorkWebhookConfiguration()).orElse(new HostedWebhookConfigurationBuilder().build()));
  }
  
  public WorkWebhookConfigurationNested<A> editOrNewWorkWebhookConfigurationLike(HostedWebhookConfiguration item) {
    return this.withNewWorkWebhookConfigurationLike(Optional.ofNullable(this.buildWorkWebhookConfiguration()).orElse(item));
  }
  
  public RegistrationWebhookConfigurationNested<A> editRegistrationWebhookConfiguration() {
    return this.withNewRegistrationWebhookConfigurationLike(Optional.ofNullable(this.buildRegistrationWebhookConfiguration()).orElse(null));
  }
  
  public WorkWebhookConfigurationNested<A> editWorkWebhookConfiguration() {
    return this.withNewWorkWebhookConfigurationLike(Optional.ofNullable(this.buildWorkWebhookConfiguration()).orElse(null));
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
    HostedClusterManagerConfigurationFluent that = (HostedClusterManagerConfigurationFluent) o;
    if (!(Objects.equals(registrationWebhookConfiguration, that.registrationWebhookConfiguration))) {
      return false;
    }
    if (!(Objects.equals(workWebhookConfiguration, that.workWebhookConfiguration))) {
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
  
  public boolean hasRegistrationWebhookConfiguration() {
    return this.registrationWebhookConfiguration != null;
  }
  
  public boolean hasWorkWebhookConfiguration() {
    return this.workWebhookConfiguration != null;
  }
  
  public int hashCode() {
    return Objects.hash(registrationWebhookConfiguration, workWebhookConfiguration, additionalProperties);
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
    if (!(registrationWebhookConfiguration == null)) {
        sb.append("registrationWebhookConfiguration:");
        sb.append(registrationWebhookConfiguration);
        sb.append(",");
    }
    if (!(workWebhookConfiguration == null)) {
        sb.append("workWebhookConfiguration:");
        sb.append(workWebhookConfiguration);
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
  
  public RegistrationWebhookConfigurationNested<A> withNewRegistrationWebhookConfiguration() {
    return new RegistrationWebhookConfigurationNested(null);
  }
  
  public RegistrationWebhookConfigurationNested<A> withNewRegistrationWebhookConfigurationLike(HostedWebhookConfiguration item) {
    return new RegistrationWebhookConfigurationNested(item);
  }
  
  public WorkWebhookConfigurationNested<A> withNewWorkWebhookConfiguration() {
    return new WorkWebhookConfigurationNested(null);
  }
  
  public WorkWebhookConfigurationNested<A> withNewWorkWebhookConfigurationLike(HostedWebhookConfiguration item) {
    return new WorkWebhookConfigurationNested(item);
  }
  
  public A withRegistrationWebhookConfiguration(HostedWebhookConfiguration registrationWebhookConfiguration) {
    this._visitables.remove("registrationWebhookConfiguration");
    if (registrationWebhookConfiguration != null) {
        this.registrationWebhookConfiguration = new HostedWebhookConfigurationBuilder(registrationWebhookConfiguration);
        this._visitables.get("registrationWebhookConfiguration").add(this.registrationWebhookConfiguration);
    } else {
        this.registrationWebhookConfiguration = null;
        this._visitables.get("registrationWebhookConfiguration").remove(this.registrationWebhookConfiguration);
    }
    return (A) this;
  }
  
  public A withWorkWebhookConfiguration(HostedWebhookConfiguration workWebhookConfiguration) {
    this._visitables.remove("workWebhookConfiguration");
    if (workWebhookConfiguration != null) {
        this.workWebhookConfiguration = new HostedWebhookConfigurationBuilder(workWebhookConfiguration);
        this._visitables.get("workWebhookConfiguration").add(this.workWebhookConfiguration);
    } else {
        this.workWebhookConfiguration = null;
        this._visitables.get("workWebhookConfiguration").remove(this.workWebhookConfiguration);
    }
    return (A) this;
  }
  public class RegistrationWebhookConfigurationNested<N> extends HostedWebhookConfigurationFluent<RegistrationWebhookConfigurationNested<N>> implements Nested<N>{
  
    HostedWebhookConfigurationBuilder builder;
  
    RegistrationWebhookConfigurationNested(HostedWebhookConfiguration item) {
      this.builder = new HostedWebhookConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) HostedClusterManagerConfigurationFluent.this.withRegistrationWebhookConfiguration(builder.build());
    }
    
    public N endRegistrationWebhookConfiguration() {
      return and();
    }
    
  }
  public class WorkWebhookConfigurationNested<N> extends HostedWebhookConfigurationFluent<WorkWebhookConfigurationNested<N>> implements Nested<N>{
  
    HostedWebhookConfigurationBuilder builder;
  
    WorkWebhookConfigurationNested(HostedWebhookConfiguration item) {
      this.builder = new HostedWebhookConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) HostedClusterManagerConfigurationFluent.this.withWorkWebhookConfiguration(builder.build());
    }
    
    public N endWorkWebhookConfiguration() {
      return and();
    }
    
  }
}