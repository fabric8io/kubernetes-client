package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ProfileConfigFluent<A extends io.fabric8.openshift.api.model.tuned.v1.ProfileConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean debug;
  private String providerName;
  private TuneDConfigBuilder tunedConfig;
  private String tunedProfile;
  private Integer verbosity;

  public ProfileConfigFluent() {
  }
  
  public ProfileConfigFluent(ProfileConfig instance) {
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
  
  public TuneDConfig buildTunedConfig() {
    return this.tunedConfig != null ? this.tunedConfig.build() : null;
  }
  
  protected void copyInstance(ProfileConfig instance) {
    instance = instance != null ? instance : new ProfileConfig();
    if (instance != null) {
        this.withDebug(instance.getDebug());
        this.withProviderName(instance.getProviderName());
        this.withTunedConfig(instance.getTunedConfig());
        this.withTunedProfile(instance.getTunedProfile());
        this.withVerbosity(instance.getVerbosity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TunedConfigNested<A> editOrNewTunedConfig() {
    return this.withNewTunedConfigLike(Optional.ofNullable(this.buildTunedConfig()).orElse(new TuneDConfigBuilder().build()));
  }
  
  public TunedConfigNested<A> editOrNewTunedConfigLike(TuneDConfig item) {
    return this.withNewTunedConfigLike(Optional.ofNullable(this.buildTunedConfig()).orElse(item));
  }
  
  public TunedConfigNested<A> editTunedConfig() {
    return this.withNewTunedConfigLike(Optional.ofNullable(this.buildTunedConfig()).orElse(null));
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
    ProfileConfigFluent that = (ProfileConfigFluent) o;
    if (!(Objects.equals(debug, that.debug))) {
      return false;
    }
    if (!(Objects.equals(providerName, that.providerName))) {
      return false;
    }
    if (!(Objects.equals(tunedConfig, that.tunedConfig))) {
      return false;
    }
    if (!(Objects.equals(tunedProfile, that.tunedProfile))) {
      return false;
    }
    if (!(Objects.equals(verbosity, that.verbosity))) {
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
  
  public Boolean getDebug() {
    return this.debug;
  }
  
  public String getProviderName() {
    return this.providerName;
  }
  
  public String getTunedProfile() {
    return this.tunedProfile;
  }
  
  public Integer getVerbosity() {
    return this.verbosity;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDebug() {
    return this.debug != null;
  }
  
  public boolean hasProviderName() {
    return this.providerName != null;
  }
  
  public boolean hasTunedConfig() {
    return this.tunedConfig != null;
  }
  
  public boolean hasTunedProfile() {
    return this.tunedProfile != null;
  }
  
  public boolean hasVerbosity() {
    return this.verbosity != null;
  }
  
  public int hashCode() {
    return Objects.hash(debug, providerName, tunedConfig, tunedProfile, verbosity, additionalProperties);
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
    if (!(debug == null)) {
        sb.append("debug:");
        sb.append(debug);
        sb.append(",");
    }
    if (!(providerName == null)) {
        sb.append("providerName:");
        sb.append(providerName);
        sb.append(",");
    }
    if (!(tunedConfig == null)) {
        sb.append("tunedConfig:");
        sb.append(tunedConfig);
        sb.append(",");
    }
    if (!(tunedProfile == null)) {
        sb.append("tunedProfile:");
        sb.append(tunedProfile);
        sb.append(",");
    }
    if (!(verbosity == null)) {
        sb.append("verbosity:");
        sb.append(verbosity);
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
  
  public A withDebug() {
    return withDebug(true);
  }
  
  public A withDebug(Boolean debug) {
    this.debug = debug;
    return (A) this;
  }
  
  public TunedConfigNested<A> withNewTunedConfig() {
    return new TunedConfigNested(null);
  }
  
  public A withNewTunedConfig(Boolean reapplySysctl) {
    return (A) this.withTunedConfig(new TuneDConfig(reapplySysctl));
  }
  
  public TunedConfigNested<A> withNewTunedConfigLike(TuneDConfig item) {
    return new TunedConfigNested(item);
  }
  
  public A withProviderName(String providerName) {
    this.providerName = providerName;
    return (A) this;
  }
  
  public A withTunedConfig(TuneDConfig tunedConfig) {
    this._visitables.remove("tunedConfig");
    if (tunedConfig != null) {
        this.tunedConfig = new TuneDConfigBuilder(tunedConfig);
        this._visitables.get("tunedConfig").add(this.tunedConfig);
    } else {
        this.tunedConfig = null;
        this._visitables.get("tunedConfig").remove(this.tunedConfig);
    }
    return (A) this;
  }
  
  public A withTunedProfile(String tunedProfile) {
    this.tunedProfile = tunedProfile;
    return (A) this;
  }
  
  public A withVerbosity(Integer verbosity) {
    this.verbosity = verbosity;
    return (A) this;
  }
  public class TunedConfigNested<N> extends TuneDConfigFluent<TunedConfigNested<N>> implements Nested<N>{
  
    TuneDConfigBuilder builder;
  
    TunedConfigNested(TuneDConfig item) {
      this.builder = new TuneDConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ProfileConfigFluent.this.withTunedConfig(builder.build());
    }
    
    public N endTunedConfig() {
      return and();
    }
    
  }
}