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
public class DefaultClusterManagerConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.DefaultClusterManagerConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DefaultWebhookConfigurationBuilder addonWebhookConfiguration;
  private DefaultWebhookConfigurationBuilder registrationWebhookConfiguration;
  private DefaultWebhookConfigurationBuilder workWebhookConfiguration;

  public DefaultClusterManagerConfigurationFluent() {
  }
  
  public DefaultClusterManagerConfigurationFluent(DefaultClusterManagerConfiguration instance) {
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
  
  public DefaultWebhookConfiguration buildAddonWebhookConfiguration() {
    return this.addonWebhookConfiguration != null ? this.addonWebhookConfiguration.build() : null;
  }
  
  public DefaultWebhookConfiguration buildRegistrationWebhookConfiguration() {
    return this.registrationWebhookConfiguration != null ? this.registrationWebhookConfiguration.build() : null;
  }
  
  public DefaultWebhookConfiguration buildWorkWebhookConfiguration() {
    return this.workWebhookConfiguration != null ? this.workWebhookConfiguration.build() : null;
  }
  
  protected void copyInstance(DefaultClusterManagerConfiguration instance) {
    instance = instance != null ? instance : new DefaultClusterManagerConfiguration();
    if (instance != null) {
        this.withAddonWebhookConfiguration(instance.getAddonWebhookConfiguration());
        this.withRegistrationWebhookConfiguration(instance.getRegistrationWebhookConfiguration());
        this.withWorkWebhookConfiguration(instance.getWorkWebhookConfiguration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddonWebhookConfigurationNested<A> editAddonWebhookConfiguration() {
    return this.withNewAddonWebhookConfigurationLike(Optional.ofNullable(this.buildAddonWebhookConfiguration()).orElse(null));
  }
  
  public AddonWebhookConfigurationNested<A> editOrNewAddonWebhookConfiguration() {
    return this.withNewAddonWebhookConfigurationLike(Optional.ofNullable(this.buildAddonWebhookConfiguration()).orElse(new DefaultWebhookConfigurationBuilder().build()));
  }
  
  public AddonWebhookConfigurationNested<A> editOrNewAddonWebhookConfigurationLike(DefaultWebhookConfiguration item) {
    return this.withNewAddonWebhookConfigurationLike(Optional.ofNullable(this.buildAddonWebhookConfiguration()).orElse(item));
  }
  
  public RegistrationWebhookConfigurationNested<A> editOrNewRegistrationWebhookConfiguration() {
    return this.withNewRegistrationWebhookConfigurationLike(Optional.ofNullable(this.buildRegistrationWebhookConfiguration()).orElse(new DefaultWebhookConfigurationBuilder().build()));
  }
  
  public RegistrationWebhookConfigurationNested<A> editOrNewRegistrationWebhookConfigurationLike(DefaultWebhookConfiguration item) {
    return this.withNewRegistrationWebhookConfigurationLike(Optional.ofNullable(this.buildRegistrationWebhookConfiguration()).orElse(item));
  }
  
  public WorkWebhookConfigurationNested<A> editOrNewWorkWebhookConfiguration() {
    return this.withNewWorkWebhookConfigurationLike(Optional.ofNullable(this.buildWorkWebhookConfiguration()).orElse(new DefaultWebhookConfigurationBuilder().build()));
  }
  
  public WorkWebhookConfigurationNested<A> editOrNewWorkWebhookConfigurationLike(DefaultWebhookConfiguration item) {
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
    DefaultClusterManagerConfigurationFluent that = (DefaultClusterManagerConfigurationFluent) o;
    if (!(Objects.equals(addonWebhookConfiguration, that.addonWebhookConfiguration))) {
      return false;
    }
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
  
  public boolean hasAddonWebhookConfiguration() {
    return this.addonWebhookConfiguration != null;
  }
  
  public boolean hasRegistrationWebhookConfiguration() {
    return this.registrationWebhookConfiguration != null;
  }
  
  public boolean hasWorkWebhookConfiguration() {
    return this.workWebhookConfiguration != null;
  }
  
  public int hashCode() {
    return Objects.hash(addonWebhookConfiguration, registrationWebhookConfiguration, workWebhookConfiguration, additionalProperties);
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
    if (!(addonWebhookConfiguration == null)) {
        sb.append("addonWebhookConfiguration:");
        sb.append(addonWebhookConfiguration);
        sb.append(",");
    }
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
  
  public A withAddonWebhookConfiguration(DefaultWebhookConfiguration addonWebhookConfiguration) {
    this._visitables.remove("addonWebhookConfiguration");
    if (addonWebhookConfiguration != null) {
        this.addonWebhookConfiguration = new DefaultWebhookConfigurationBuilder(addonWebhookConfiguration);
        this._visitables.get("addonWebhookConfiguration").add(this.addonWebhookConfiguration);
    } else {
        this.addonWebhookConfiguration = null;
        this._visitables.get("addonWebhookConfiguration").remove(this.addonWebhookConfiguration);
    }
    return (A) this;
  }
  
  public AddonWebhookConfigurationNested<A> withNewAddonWebhookConfiguration() {
    return new AddonWebhookConfigurationNested(null);
  }
  
  public AddonWebhookConfigurationNested<A> withNewAddonWebhookConfigurationLike(DefaultWebhookConfiguration item) {
    return new AddonWebhookConfigurationNested(item);
  }
  
  public RegistrationWebhookConfigurationNested<A> withNewRegistrationWebhookConfiguration() {
    return new RegistrationWebhookConfigurationNested(null);
  }
  
  public RegistrationWebhookConfigurationNested<A> withNewRegistrationWebhookConfigurationLike(DefaultWebhookConfiguration item) {
    return new RegistrationWebhookConfigurationNested(item);
  }
  
  public WorkWebhookConfigurationNested<A> withNewWorkWebhookConfiguration() {
    return new WorkWebhookConfigurationNested(null);
  }
  
  public WorkWebhookConfigurationNested<A> withNewWorkWebhookConfigurationLike(DefaultWebhookConfiguration item) {
    return new WorkWebhookConfigurationNested(item);
  }
  
  public A withRegistrationWebhookConfiguration(DefaultWebhookConfiguration registrationWebhookConfiguration) {
    this._visitables.remove("registrationWebhookConfiguration");
    if (registrationWebhookConfiguration != null) {
        this.registrationWebhookConfiguration = new DefaultWebhookConfigurationBuilder(registrationWebhookConfiguration);
        this._visitables.get("registrationWebhookConfiguration").add(this.registrationWebhookConfiguration);
    } else {
        this.registrationWebhookConfiguration = null;
        this._visitables.get("registrationWebhookConfiguration").remove(this.registrationWebhookConfiguration);
    }
    return (A) this;
  }
  
  public A withWorkWebhookConfiguration(DefaultWebhookConfiguration workWebhookConfiguration) {
    this._visitables.remove("workWebhookConfiguration");
    if (workWebhookConfiguration != null) {
        this.workWebhookConfiguration = new DefaultWebhookConfigurationBuilder(workWebhookConfiguration);
        this._visitables.get("workWebhookConfiguration").add(this.workWebhookConfiguration);
    } else {
        this.workWebhookConfiguration = null;
        this._visitables.get("workWebhookConfiguration").remove(this.workWebhookConfiguration);
    }
    return (A) this;
  }
  public class AddonWebhookConfigurationNested<N> extends DefaultWebhookConfigurationFluent<AddonWebhookConfigurationNested<N>> implements Nested<N>{
  
    DefaultWebhookConfigurationBuilder builder;
  
    AddonWebhookConfigurationNested(DefaultWebhookConfiguration item) {
      this.builder = new DefaultWebhookConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) DefaultClusterManagerConfigurationFluent.this.withAddonWebhookConfiguration(builder.build());
    }
    
    public N endAddonWebhookConfiguration() {
      return and();
    }
    
  }
  public class RegistrationWebhookConfigurationNested<N> extends DefaultWebhookConfigurationFluent<RegistrationWebhookConfigurationNested<N>> implements Nested<N>{
  
    DefaultWebhookConfigurationBuilder builder;
  
    RegistrationWebhookConfigurationNested(DefaultWebhookConfiguration item) {
      this.builder = new DefaultWebhookConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) DefaultClusterManagerConfigurationFluent.this.withRegistrationWebhookConfiguration(builder.build());
    }
    
    public N endRegistrationWebhookConfiguration() {
      return and();
    }
    
  }
  public class WorkWebhookConfigurationNested<N> extends DefaultWebhookConfigurationFluent<WorkWebhookConfigurationNested<N>> implements Nested<N>{
  
    DefaultWebhookConfigurationBuilder builder;
  
    WorkWebhookConfigurationNested(DefaultWebhookConfiguration item) {
      this.builder = new DefaultWebhookConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) DefaultClusterManagerConfigurationFluent.this.withWorkWebhookConfiguration(builder.build());
    }
    
    public N endWorkWebhookConfiguration() {
      return and();
    }
    
  }
}