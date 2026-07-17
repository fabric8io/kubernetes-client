package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ProfileSpecFluent<A extends io.fabric8.openshift.api.model.tuned.v1.ProfileSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ProfileConfigBuilder config;
  private ArrayList<TunedProfileBuilder> profile = new ArrayList<TunedProfileBuilder>();

  public ProfileSpecFluent() {
  }
  
  public ProfileSpecFluent(ProfileSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToProfile(Collection<TunedProfile> items) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").add(builder);
        this.profile.add(builder);
    }
    return (A) this;
  }
  
  public ProfileNested<A> addNewProfile() {
    return new ProfileNested(-1, null);
  }
  
  public A addNewProfile(String data,String name) {
    return (A) this.addToProfile(new TunedProfile(data, name));
  }
  
  public ProfileNested<A> addNewProfileLike(TunedProfile item) {
    return new ProfileNested(-1, item);
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
  
  public A addToProfile(TunedProfile... items) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").add(builder);
        this.profile.add(builder);
    }
    return (A) this;
  }
  
  public A addToProfile(int index,TunedProfile item) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    TunedProfileBuilder builder = new TunedProfileBuilder(item);
    if (index < 0 || index >= profile.size()) {
        _visitables.get("profile").add(builder);
        profile.add(builder);
    } else {
        _visitables.get("profile").add(builder);
        profile.add(index, builder);
    }
    return (A) this;
  }
  
  public ProfileConfig buildConfig() {
    return this.config != null ? this.config.build() : null;
  }
  
  public TunedProfile buildFirstProfile() {
    return this.profile.get(0).build();
  }
  
  public TunedProfile buildLastProfile() {
    return this.profile.get(profile.size() - 1).build();
  }
  
  public TunedProfile buildMatchingProfile(Predicate<TunedProfileBuilder> predicate) {
      for (TunedProfileBuilder item : profile) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<TunedProfile> buildProfile() {
    return this.profile != null ? build(profile) : null;
  }
  
  public TunedProfile buildProfile(int index) {
    return this.profile.get(index).build();
  }
  
  protected void copyInstance(ProfileSpec instance) {
    instance = instance != null ? instance : new ProfileSpec();
    if (instance != null) {
        this.withConfig(instance.getConfig());
        this.withProfile(instance.getProfile());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigNested<A> editConfig() {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(null));
  }
  
  public ProfileNested<A> editFirstProfile() {
    if (profile.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "profile"));
    }
    return this.setNewProfileLike(0, this.buildProfile(0));
  }
  
  public ProfileNested<A> editLastProfile() {
    int index = profile.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "profile"));
    }
    return this.setNewProfileLike(index, this.buildProfile(index));
  }
  
  public ProfileNested<A> editMatchingProfile(Predicate<TunedProfileBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < profile.size();i++) {
      if (predicate.test(profile.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "profile"));
    }
    return this.setNewProfileLike(index, this.buildProfile(index));
  }
  
  public ConfigNested<A> editOrNewConfig() {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(new ProfileConfigBuilder().build()));
  }
  
  public ConfigNested<A> editOrNewConfigLike(ProfileConfig item) {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(item));
  }
  
  public ProfileNested<A> editProfile(int index) {
    if (profile.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "profile"));
    }
    return this.setNewProfileLike(index, this.buildProfile(index));
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
    ProfileSpecFluent that = (ProfileSpecFluent) o;
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
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
  
  public boolean hasConfig() {
    return this.config != null;
  }
  
  public boolean hasMatchingProfile(Predicate<TunedProfileBuilder> predicate) {
      for (TunedProfileBuilder item : profile) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProfile() {
    return this.profile != null && !(this.profile.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(config, profile, additionalProperties);
  }
  
  public A removeAllFromProfile(Collection<TunedProfile> items) {
    if (this.profile == null) {
      return (A) this;
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").remove(builder);
        this.profile.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromProfile(TunedProfile... items) {
    if (this.profile == null) {
      return (A) this;
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").remove(builder);
        this.profile.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromProfile(Predicate<TunedProfileBuilder> predicate) {
    if (profile == null) {
      return (A) this;
    }
    Iterator<TunedProfileBuilder> each = profile.iterator();
    List visitables = _visitables.get("profile");
    while (each.hasNext()) {
        TunedProfileBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ProfileNested<A> setNewProfileLike(int index,TunedProfile item) {
    return new ProfileNested(index, item);
  }
  
  public A setToProfile(int index,TunedProfile item) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    TunedProfileBuilder builder = new TunedProfileBuilder(item);
    if (index < 0 || index >= profile.size()) {
        _visitables.get("profile").add(builder);
        profile.add(builder);
    } else {
        _visitables.get("profile").add(builder);
        profile.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(config == null)) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(profile == null) && !(profile.isEmpty())) {
        sb.append("profile:");
        sb.append(profile);
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
  
  public A withConfig(ProfileConfig config) {
    this._visitables.remove("config");
    if (config != null) {
        this.config = new ProfileConfigBuilder(config);
        this._visitables.get("config").add(this.config);
    } else {
        this.config = null;
        this._visitables.get("config").remove(this.config);
    }
    return (A) this;
  }
  
  public ConfigNested<A> withNewConfig() {
    return new ConfigNested(null);
  }
  
  public ConfigNested<A> withNewConfigLike(ProfileConfig item) {
    return new ConfigNested(item);
  }
  
  public A withProfile(List<TunedProfile> profile) {
    if (this.profile != null) {
      this._visitables.get("profile").clear();
    }
    if (profile != null) {
        this.profile = new ArrayList();
        for (TunedProfile item : profile) {
          this.addToProfile(item);
        }
    } else {
      this.profile = null;
    }
    return (A) this;
  }
  
  public A withProfile(TunedProfile... profile) {
    if (this.profile != null) {
        this.profile.clear();
        _visitables.remove("profile");
    }
    if (profile != null) {
      for (TunedProfile item : profile) {
        this.addToProfile(item);
      }
    }
    return (A) this;
  }
  public class ConfigNested<N> extends ProfileConfigFluent<ConfigNested<N>> implements Nested<N>{
  
    ProfileConfigBuilder builder;
  
    ConfigNested(ProfileConfig item) {
      this.builder = new ProfileConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ProfileSpecFluent.this.withConfig(builder.build());
    }
    
    public N endConfig() {
      return and();
    }
    
  }
  public class ProfileNested<N> extends TunedProfileFluent<ProfileNested<N>> implements Nested<N>{
  
    TunedProfileBuilder builder;
    int index;
  
    ProfileNested(int index,TunedProfile item) {
      this.index = index;
      this.builder = new TunedProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) ProfileSpecFluent.this.setToProfile(index, builder.build());
    }
    
    public N endProfile() {
      return and();
    }
    
  }
}