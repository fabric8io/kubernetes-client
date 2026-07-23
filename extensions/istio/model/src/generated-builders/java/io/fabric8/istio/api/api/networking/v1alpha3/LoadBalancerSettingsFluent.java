package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Double;
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
public class LoadBalancerSettingsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LoadBalancerSettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsLoadBalancerSettingsLbPolicy,?> lbPolicy;
  private LocalityLoadBalancerSettingBuilder localityLbSetting;
  private WarmupConfigurationBuilder warmup;
  private String warmupDurationSecs;

  public LoadBalancerSettingsFluent() {
  }
  
  public LoadBalancerSettingsFluent(LoadBalancerSettings instance) {
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
  
  public IsLoadBalancerSettingsLbPolicy buildLbPolicy() {
    return this.lbPolicy != null ? this.lbPolicy.build() : null;
  }
  
  public LocalityLoadBalancerSetting buildLocalityLbSetting() {
    return this.localityLbSetting != null ? this.localityLbSetting.build() : null;
  }
  
  public WarmupConfiguration buildWarmup() {
    return this.warmup != null ? this.warmup.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "LoadBalancerSettingsSimple":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsSimpleBuilder((LoadBalancerSettingsSimple) item);
    
      case "LoadBalancerSettingsConsistentHash":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsConsistentHashBuilder((LoadBalancerSettingsConsistentHash) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(LoadBalancerSettings instance) {
    instance = instance != null ? instance : new LoadBalancerSettings();
    if (instance != null) {
        this.withLbPolicy(instance.getLbPolicy());
        this.withLocalityLbSetting(instance.getLocalityLbSetting());
        this.withWarmup(instance.getWarmup());
        this.withWarmupDurationSecs(instance.getWarmupDurationSecs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LocalityLbSettingNested<A> editLocalityLbSetting() {
    return this.withNewLocalityLbSettingLike(Optional.ofNullable(this.buildLocalityLbSetting()).orElse(null));
  }
  
  public LocalityLbSettingNested<A> editOrNewLocalityLbSetting() {
    return this.withNewLocalityLbSettingLike(Optional.ofNullable(this.buildLocalityLbSetting()).orElse(new LocalityLoadBalancerSettingBuilder().build()));
  }
  
  public LocalityLbSettingNested<A> editOrNewLocalityLbSettingLike(LocalityLoadBalancerSetting item) {
    return this.withNewLocalityLbSettingLike(Optional.ofNullable(this.buildLocalityLbSetting()).orElse(item));
  }
  
  public WarmupNested<A> editOrNewWarmup() {
    return this.withNewWarmupLike(Optional.ofNullable(this.buildWarmup()).orElse(new WarmupConfigurationBuilder().build()));
  }
  
  public WarmupNested<A> editOrNewWarmupLike(WarmupConfiguration item) {
    return this.withNewWarmupLike(Optional.ofNullable(this.buildWarmup()).orElse(item));
  }
  
  public WarmupNested<A> editWarmup() {
    return this.withNewWarmupLike(Optional.ofNullable(this.buildWarmup()).orElse(null));
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
    LoadBalancerSettingsFluent that = (LoadBalancerSettingsFluent) o;
    if (!(Objects.equals(lbPolicy, that.lbPolicy))) {
      return false;
    }
    if (!(Objects.equals(localityLbSetting, that.localityLbSetting))) {
      return false;
    }
    if (!(Objects.equals(warmup, that.warmup))) {
      return false;
    }
    if (!(Objects.equals(warmupDurationSecs, that.warmupDurationSecs))) {
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
  
  public String getWarmupDurationSecs() {
    return this.warmupDurationSecs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLbPolicy() {
    return this.lbPolicy != null;
  }
  
  public boolean hasLocalityLbSetting() {
    return this.localityLbSetting != null;
  }
  
  public boolean hasWarmup() {
    return this.warmup != null;
  }
  
  public boolean hasWarmupDurationSecs() {
    return this.warmupDurationSecs != null;
  }
  
  public int hashCode() {
    return Objects.hash(lbPolicy, localityLbSetting, warmup, warmupDurationSecs, additionalProperties);
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
    if (!(lbPolicy == null)) {
        sb.append("lbPolicy:");
        sb.append(lbPolicy);
        sb.append(",");
    }
    if (!(localityLbSetting == null)) {
        sb.append("localityLbSetting:");
        sb.append(localityLbSetting);
        sb.append(",");
    }
    if (!(warmup == null)) {
        sb.append("warmup:");
        sb.append(warmup);
        sb.append(",");
    }
    if (!(warmupDurationSecs == null)) {
        sb.append("warmupDurationSecs:");
        sb.append(warmupDurationSecs);
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
  
  public A withLbPolicy(IsLoadBalancerSettingsLbPolicy lbPolicy) {
    if (lbPolicy == null) {
        this.lbPolicy = null;
        this._visitables.remove("lbPolicy");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsLoadBalancerSettingsLbPolicy,?> builder = builder(lbPolicy);
        this._visitables.get("lbPolicy").clear();
        this._visitables.get("lbPolicy").add(builder);
        this.lbPolicy = builder;
        return (A) this;
    }
  }
  
  public A withLocalityLbSetting(LocalityLoadBalancerSetting localityLbSetting) {
    this._visitables.remove("localityLbSetting");
    if (localityLbSetting != null) {
        this.localityLbSetting = new LocalityLoadBalancerSettingBuilder(localityLbSetting);
        this._visitables.get("localityLbSetting").add(this.localityLbSetting);
    } else {
        this.localityLbSetting = null;
        this._visitables.get("localityLbSetting").remove(this.localityLbSetting);
    }
    return (A) this;
  }
  
  public LoadBalancerSettingsConsistentHashLbPolicyNested<A> withNewLoadBalancerSettingsConsistentHashLbPolicy() {
    return new LoadBalancerSettingsConsistentHashLbPolicyNested(null);
  }
  
  public LoadBalancerSettingsConsistentHashLbPolicyNested<A> withNewLoadBalancerSettingsConsistentHashLbPolicyLike(LoadBalancerSettingsConsistentHash item) {
    return new LoadBalancerSettingsConsistentHashLbPolicyNested(item);
  }
  
  public LoadBalancerSettingsSimpleLbPolicyNested<A> withNewLoadBalancerSettingsSimpleLbPolicy() {
    return new LoadBalancerSettingsSimpleLbPolicyNested(null);
  }
  
  public LoadBalancerSettingsSimpleLbPolicyNested<A> withNewLoadBalancerSettingsSimpleLbPolicyLike(LoadBalancerSettingsSimple item) {
    return new LoadBalancerSettingsSimpleLbPolicyNested(item);
  }
  
  public LocalityLbSettingNested<A> withNewLocalityLbSetting() {
    return new LocalityLbSettingNested(null);
  }
  
  public LocalityLbSettingNested<A> withNewLocalityLbSettingLike(LocalityLoadBalancerSetting item) {
    return new LocalityLbSettingNested(item);
  }
  
  public WarmupNested<A> withNewWarmup() {
    return new WarmupNested(null);
  }
  
  public A withNewWarmup(Double aggression,String duration,Double minimumPercent) {
    return (A) this.withWarmup(new WarmupConfiguration(aggression, duration, minimumPercent));
  }
  
  public WarmupNested<A> withNewWarmupLike(WarmupConfiguration item) {
    return new WarmupNested(item);
  }
  
  public A withWarmup(WarmupConfiguration warmup) {
    this._visitables.remove("warmup");
    if (warmup != null) {
        this.warmup = new WarmupConfigurationBuilder(warmup);
        this._visitables.get("warmup").add(this.warmup);
    } else {
        this.warmup = null;
        this._visitables.get("warmup").remove(this.warmup);
    }
    return (A) this;
  }
  
  public A withWarmupDurationSecs(String warmupDurationSecs) {
    this.warmupDurationSecs = warmupDurationSecs;
    return (A) this;
  }
  public class LoadBalancerSettingsConsistentHashLbPolicyNested<N> extends LoadBalancerSettingsConsistentHashFluent<LoadBalancerSettingsConsistentHashLbPolicyNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashBuilder builder;
  
    LoadBalancerSettingsConsistentHashLbPolicyNested(LoadBalancerSettingsConsistentHash item) {
      this.builder = new LoadBalancerSettingsConsistentHashBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsFluent.this.withLbPolicy(builder.build());
    }
    
    public N endLoadBalancerSettingsConsistentHashLbPolicy() {
      return and();
    }
    
  }
  public class LoadBalancerSettingsSimpleLbPolicyNested<N> extends LoadBalancerSettingsSimpleFluent<LoadBalancerSettingsSimpleLbPolicyNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsSimpleBuilder builder;
  
    LoadBalancerSettingsSimpleLbPolicyNested(LoadBalancerSettingsSimple item) {
      this.builder = new LoadBalancerSettingsSimpleBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsFluent.this.withLbPolicy(builder.build());
    }
    
    public N endLoadBalancerSettingsSimpleLbPolicy() {
      return and();
    }
    
  }
  public class LocalityLbSettingNested<N> extends LocalityLoadBalancerSettingFluent<LocalityLbSettingNested<N>> implements Nested<N>{
  
    LocalityLoadBalancerSettingBuilder builder;
  
    LocalityLbSettingNested(LocalityLoadBalancerSetting item) {
      this.builder = new LocalityLoadBalancerSettingBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsFluent.this.withLocalityLbSetting(builder.build());
    }
    
    public N endLocalityLbSetting() {
      return and();
    }
    
  }
  public class WarmupNested<N> extends WarmupConfigurationFluent<WarmupNested<N>> implements Nested<N>{
  
    WarmupConfigurationBuilder builder;
  
    WarmupNested(WarmupConfiguration item) {
      this.builder = new WarmupConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsFluent.this.withWarmup(builder.build());
    }
    
    public N endWarmup() {
      return and();
    }
    
  }
}