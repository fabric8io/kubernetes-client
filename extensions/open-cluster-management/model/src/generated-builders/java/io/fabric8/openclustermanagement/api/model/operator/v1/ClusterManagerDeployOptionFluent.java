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
public class ClusterManagerDeployOptionFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerDeployOptionFluent<A>> extends BaseFluent<A>{

  private DefaultClusterManagerConfigurationBuilder _default;
  private Map<String,Object> additionalProperties;
  private HostedClusterManagerConfigurationBuilder hosted;
  private String mode;

  public ClusterManagerDeployOptionFluent() {
  }
  
  public ClusterManagerDeployOptionFluent(ClusterManagerDeployOption instance) {
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
  
  public DefaultClusterManagerConfiguration buildDefault() {
    return this._default != null ? this._default.build() : null;
  }
  
  public HostedClusterManagerConfiguration buildHosted() {
    return this.hosted != null ? this.hosted.build() : null;
  }
  
  protected void copyInstance(ClusterManagerDeployOption instance) {
    instance = instance != null ? instance : new ClusterManagerDeployOption();
    if (instance != null) {
        this.withDefault(instance.getDefault());
        this.withHosted(instance.getHosted());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultNested<A> editDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(null));
  }
  
  public HostedNested<A> editHosted() {
    return this.withNewHostedLike(Optional.ofNullable(this.buildHosted()).orElse(null));
  }
  
  public DefaultNested<A> editOrNewDefault() {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(new DefaultClusterManagerConfigurationBuilder().build()));
  }
  
  public DefaultNested<A> editOrNewDefaultLike(DefaultClusterManagerConfiguration item) {
    return this.withNewDefaultLike(Optional.ofNullable(this.buildDefault()).orElse(item));
  }
  
  public HostedNested<A> editOrNewHosted() {
    return this.withNewHostedLike(Optional.ofNullable(this.buildHosted()).orElse(new HostedClusterManagerConfigurationBuilder().build()));
  }
  
  public HostedNested<A> editOrNewHostedLike(HostedClusterManagerConfiguration item) {
    return this.withNewHostedLike(Optional.ofNullable(this.buildHosted()).orElse(item));
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
    ClusterManagerDeployOptionFluent that = (ClusterManagerDeployOptionFluent) o;
    if (!(Objects.equals(_default, that._default))) {
      return false;
    }
    if (!(Objects.equals(hosted, that.hosted))) {
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
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasHosted() {
    return this.hosted != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(_default, hosted, mode, additionalProperties);
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
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(hosted == null)) {
        sb.append("hosted:");
        sb.append(hosted);
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
  
  public A withDefault(DefaultClusterManagerConfiguration _default) {
    this._visitables.remove("_default");
    if (_default != null) {
        this._default = new DefaultClusterManagerConfigurationBuilder(_default);
        this._visitables.get("_default").add(this._default);
    } else {
        this._default = null;
        this._visitables.get("_default").remove(this._default);
    }
    return (A) this;
  }
  
  public A withHosted(HostedClusterManagerConfiguration hosted) {
    this._visitables.remove("hosted");
    if (hosted != null) {
        this.hosted = new HostedClusterManagerConfigurationBuilder(hosted);
        this._visitables.get("hosted").add(this.hosted);
    } else {
        this.hosted = null;
        this._visitables.get("hosted").remove(this.hosted);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public DefaultNested<A> withNewDefault() {
    return new DefaultNested(null);
  }
  
  public DefaultNested<A> withNewDefaultLike(DefaultClusterManagerConfiguration item) {
    return new DefaultNested(item);
  }
  
  public HostedNested<A> withNewHosted() {
    return new HostedNested(null);
  }
  
  public HostedNested<A> withNewHostedLike(HostedClusterManagerConfiguration item) {
    return new HostedNested(item);
  }
  public class DefaultNested<N> extends DefaultClusterManagerConfigurationFluent<DefaultNested<N>> implements Nested<N>{
  
    DefaultClusterManagerConfigurationBuilder builder;
  
    DefaultNested(DefaultClusterManagerConfiguration item) {
      this.builder = new DefaultClusterManagerConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerDeployOptionFluent.this.withDefault(builder.build());
    }
    
    public N endDefault() {
      return and();
    }
    
  }
  public class HostedNested<N> extends HostedClusterManagerConfigurationFluent<HostedNested<N>> implements Nested<N>{
  
    HostedClusterManagerConfigurationBuilder builder;
  
    HostedNested(HostedClusterManagerConfiguration item) {
      this.builder = new HostedClusterManagerConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerDeployOptionFluent.this.withHosted(builder.build());
    }
    
    public N endHosted() {
      return and();
    }
    
  }
}