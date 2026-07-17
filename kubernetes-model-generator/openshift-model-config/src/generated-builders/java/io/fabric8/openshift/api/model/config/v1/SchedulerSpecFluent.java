package io.fabric8.openshift.api.model.config.v1;

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
public class SchedulerSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.SchedulerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String defaultNodeSelector;
  private Boolean mastersSchedulable;
  private ConfigMapNameReferenceBuilder policy;
  private String profile;
  private ProfileCustomizationsBuilder profileCustomizations;

  public SchedulerSpecFluent() {
  }
  
  public SchedulerSpecFluent(SchedulerSpec instance) {
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
  
  public ConfigMapNameReference buildPolicy() {
    return this.policy != null ? this.policy.build() : null;
  }
  
  public ProfileCustomizations buildProfileCustomizations() {
    return this.profileCustomizations != null ? this.profileCustomizations.build() : null;
  }
  
  protected void copyInstance(SchedulerSpec instance) {
    instance = instance != null ? instance : new SchedulerSpec();
    if (instance != null) {
        this.withDefaultNodeSelector(instance.getDefaultNodeSelector());
        this.withMastersSchedulable(instance.getMastersSchedulable());
        this.withPolicy(instance.getPolicy());
        this.withProfile(instance.getProfile());
        this.withProfileCustomizations(instance.getProfileCustomizations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PolicyNested<A> editOrNewPolicy() {
    return this.withNewPolicyLike(Optional.ofNullable(this.buildPolicy()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public PolicyNested<A> editOrNewPolicyLike(ConfigMapNameReference item) {
    return this.withNewPolicyLike(Optional.ofNullable(this.buildPolicy()).orElse(item));
  }
  
  public ProfileCustomizationsNested<A> editOrNewProfileCustomizations() {
    return this.withNewProfileCustomizationsLike(Optional.ofNullable(this.buildProfileCustomizations()).orElse(new ProfileCustomizationsBuilder().build()));
  }
  
  public ProfileCustomizationsNested<A> editOrNewProfileCustomizationsLike(ProfileCustomizations item) {
    return this.withNewProfileCustomizationsLike(Optional.ofNullable(this.buildProfileCustomizations()).orElse(item));
  }
  
  public PolicyNested<A> editPolicy() {
    return this.withNewPolicyLike(Optional.ofNullable(this.buildPolicy()).orElse(null));
  }
  
  public ProfileCustomizationsNested<A> editProfileCustomizations() {
    return this.withNewProfileCustomizationsLike(Optional.ofNullable(this.buildProfileCustomizations()).orElse(null));
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
    SchedulerSpecFluent that = (SchedulerSpecFluent) o;
    if (!(Objects.equals(defaultNodeSelector, that.defaultNodeSelector))) {
      return false;
    }
    if (!(Objects.equals(mastersSchedulable, that.mastersSchedulable))) {
      return false;
    }
    if (!(Objects.equals(policy, that.policy))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
      return false;
    }
    if (!(Objects.equals(profileCustomizations, that.profileCustomizations))) {
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
  
  public String getDefaultNodeSelector() {
    return this.defaultNodeSelector;
  }
  
  public Boolean getMastersSchedulable() {
    return this.mastersSchedulable;
  }
  
  public String getProfile() {
    return this.profile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefaultNodeSelector() {
    return this.defaultNodeSelector != null;
  }
  
  public boolean hasMastersSchedulable() {
    return this.mastersSchedulable != null;
  }
  
  public boolean hasPolicy() {
    return this.policy != null;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public boolean hasProfileCustomizations() {
    return this.profileCustomizations != null;
  }
  
  public int hashCode() {
    return Objects.hash(defaultNodeSelector, mastersSchedulable, policy, profile, profileCustomizations, additionalProperties);
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
    if (!(defaultNodeSelector == null)) {
        sb.append("defaultNodeSelector:");
        sb.append(defaultNodeSelector);
        sb.append(",");
    }
    if (!(mastersSchedulable == null)) {
        sb.append("mastersSchedulable:");
        sb.append(mastersSchedulable);
        sb.append(",");
    }
    if (!(policy == null)) {
        sb.append("policy:");
        sb.append(policy);
        sb.append(",");
    }
    if (!(profile == null)) {
        sb.append("profile:");
        sb.append(profile);
        sb.append(",");
    }
    if (!(profileCustomizations == null)) {
        sb.append("profileCustomizations:");
        sb.append(profileCustomizations);
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
  
  public A withDefaultNodeSelector(String defaultNodeSelector) {
    this.defaultNodeSelector = defaultNodeSelector;
    return (A) this;
  }
  
  public A withMastersSchedulable() {
    return withMastersSchedulable(true);
  }
  
  public A withMastersSchedulable(Boolean mastersSchedulable) {
    this.mastersSchedulable = mastersSchedulable;
    return (A) this;
  }
  
  public PolicyNested<A> withNewPolicy() {
    return new PolicyNested(null);
  }
  
  public A withNewPolicy(String name) {
    return (A) this.withPolicy(new ConfigMapNameReference(name));
  }
  
  public PolicyNested<A> withNewPolicyLike(ConfigMapNameReference item) {
    return new PolicyNested(item);
  }
  
  public ProfileCustomizationsNested<A> withNewProfileCustomizations() {
    return new ProfileCustomizationsNested(null);
  }
  
  public A withNewProfileCustomizations(String dynamicResourceAllocation) {
    return (A) this.withProfileCustomizations(new ProfileCustomizations(dynamicResourceAllocation));
  }
  
  public ProfileCustomizationsNested<A> withNewProfileCustomizationsLike(ProfileCustomizations item) {
    return new ProfileCustomizationsNested(item);
  }
  
  public A withPolicy(ConfigMapNameReference policy) {
    this._visitables.remove("policy");
    if (policy != null) {
        this.policy = new ConfigMapNameReferenceBuilder(policy);
        this._visitables.get("policy").add(this.policy);
    } else {
        this.policy = null;
        this._visitables.get("policy").remove(this.policy);
    }
    return (A) this;
  }
  
  public A withProfile(String profile) {
    this.profile = profile;
    return (A) this;
  }
  
  public A withProfileCustomizations(ProfileCustomizations profileCustomizations) {
    this._visitables.remove("profileCustomizations");
    if (profileCustomizations != null) {
        this.profileCustomizations = new ProfileCustomizationsBuilder(profileCustomizations);
        this._visitables.get("profileCustomizations").add(this.profileCustomizations);
    } else {
        this.profileCustomizations = null;
        this._visitables.get("profileCustomizations").remove(this.profileCustomizations);
    }
    return (A) this;
  }
  public class PolicyNested<N> extends ConfigMapNameReferenceFluent<PolicyNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    PolicyNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SchedulerSpecFluent.this.withPolicy(builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
  public class ProfileCustomizationsNested<N> extends ProfileCustomizationsFluent<ProfileCustomizationsNested<N>> implements Nested<N>{
  
    ProfileCustomizationsBuilder builder;
  
    ProfileCustomizationsNested(ProfileCustomizations item) {
      this.builder = new ProfileCustomizationsBuilder(this, item);
    }
  
    public N and() {
      return (N) SchedulerSpecFluent.this.withProfileCustomizations(builder.build());
    }
    
    public N endProfileCustomizations() {
      return and();
    }
    
  }
}