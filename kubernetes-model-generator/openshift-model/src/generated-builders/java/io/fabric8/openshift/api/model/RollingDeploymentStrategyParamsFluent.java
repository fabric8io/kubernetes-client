package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import java.lang.Long;
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
public class RollingDeploymentStrategyParamsFluent<A extends io.fabric8.openshift.api.model.RollingDeploymentStrategyParamsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long intervalSeconds;
  private IntOrStringBuilder maxSurge;
  private IntOrStringBuilder maxUnavailable;
  private LifecycleHookBuilder post;
  private LifecycleHookBuilder pre;
  private Long timeoutSeconds;
  private Long updatePeriodSeconds;

  public RollingDeploymentStrategyParamsFluent() {
  }
  
  public RollingDeploymentStrategyParamsFluent(RollingDeploymentStrategyParams instance) {
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
  
  public IntOrString buildMaxSurge() {
    return this.maxSurge != null ? this.maxSurge.build() : null;
  }
  
  public IntOrString buildMaxUnavailable() {
    return this.maxUnavailable != null ? this.maxUnavailable.build() : null;
  }
  
  public LifecycleHook buildPost() {
    return this.post != null ? this.post.build() : null;
  }
  
  public LifecycleHook buildPre() {
    return this.pre != null ? this.pre.build() : null;
  }
  
  protected void copyInstance(RollingDeploymentStrategyParams instance) {
    instance = instance != null ? instance : new RollingDeploymentStrategyParams();
    if (instance != null) {
        this.withIntervalSeconds(instance.getIntervalSeconds());
        this.withMaxSurge(instance.getMaxSurge());
        this.withMaxUnavailable(instance.getMaxUnavailable());
        this.withPost(instance.getPost());
        this.withPre(instance.getPre());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withUpdatePeriodSeconds(instance.getUpdatePeriodSeconds());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MaxSurgeNested<A> editMaxSurge() {
    return this.withNewMaxSurgeLike(Optional.ofNullable(this.buildMaxSurge()).orElse(null));
  }
  
  public MaxUnavailableNested<A> editMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(null));
  }
  
  public MaxSurgeNested<A> editOrNewMaxSurge() {
    return this.withNewMaxSurgeLike(Optional.ofNullable(this.buildMaxSurge()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxSurgeNested<A> editOrNewMaxSurgeLike(IntOrString item) {
    return this.withNewMaxSurgeLike(Optional.ofNullable(this.buildMaxSurge()).orElse(item));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailable() {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxUnavailableNested<A> editOrNewMaxUnavailableLike(IntOrString item) {
    return this.withNewMaxUnavailableLike(Optional.ofNullable(this.buildMaxUnavailable()).orElse(item));
  }
  
  public PostNested<A> editOrNewPost() {
    return this.withNewPostLike(Optional.ofNullable(this.buildPost()).orElse(new LifecycleHookBuilder().build()));
  }
  
  public PostNested<A> editOrNewPostLike(LifecycleHook item) {
    return this.withNewPostLike(Optional.ofNullable(this.buildPost()).orElse(item));
  }
  
  public PreNested<A> editOrNewPre() {
    return this.withNewPreLike(Optional.ofNullable(this.buildPre()).orElse(new LifecycleHookBuilder().build()));
  }
  
  public PreNested<A> editOrNewPreLike(LifecycleHook item) {
    return this.withNewPreLike(Optional.ofNullable(this.buildPre()).orElse(item));
  }
  
  public PostNested<A> editPost() {
    return this.withNewPostLike(Optional.ofNullable(this.buildPost()).orElse(null));
  }
  
  public PreNested<A> editPre() {
    return this.withNewPreLike(Optional.ofNullable(this.buildPre()).orElse(null));
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
    RollingDeploymentStrategyParamsFluent that = (RollingDeploymentStrategyParamsFluent) o;
    if (!(Objects.equals(intervalSeconds, that.intervalSeconds))) {
      return false;
    }
    if (!(Objects.equals(maxSurge, that.maxSurge))) {
      return false;
    }
    if (!(Objects.equals(maxUnavailable, that.maxUnavailable))) {
      return false;
    }
    if (!(Objects.equals(post, that.post))) {
      return false;
    }
    if (!(Objects.equals(pre, that.pre))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(updatePeriodSeconds, that.updatePeriodSeconds))) {
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
  
  public Long getIntervalSeconds() {
    return this.intervalSeconds;
  }
  
  public Long getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public Long getUpdatePeriodSeconds() {
    return this.updatePeriodSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIntervalSeconds() {
    return this.intervalSeconds != null;
  }
  
  public boolean hasMaxSurge() {
    return this.maxSurge != null;
  }
  
  public boolean hasMaxUnavailable() {
    return this.maxUnavailable != null;
  }
  
  public boolean hasPost() {
    return this.post != null;
  }
  
  public boolean hasPre() {
    return this.pre != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public boolean hasUpdatePeriodSeconds() {
    return this.updatePeriodSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(intervalSeconds, maxSurge, maxUnavailable, post, pre, timeoutSeconds, updatePeriodSeconds, additionalProperties);
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
    if (!(intervalSeconds == null)) {
        sb.append("intervalSeconds:");
        sb.append(intervalSeconds);
        sb.append(",");
    }
    if (!(maxSurge == null)) {
        sb.append("maxSurge:");
        sb.append(maxSurge);
        sb.append(",");
    }
    if (!(maxUnavailable == null)) {
        sb.append("maxUnavailable:");
        sb.append(maxUnavailable);
        sb.append(",");
    }
    if (!(post == null)) {
        sb.append("post:");
        sb.append(post);
        sb.append(",");
    }
    if (!(pre == null)) {
        sb.append("pre:");
        sb.append(pre);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
        sb.append(",");
    }
    if (!(updatePeriodSeconds == null)) {
        sb.append("updatePeriodSeconds:");
        sb.append(updatePeriodSeconds);
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
  
  public A withIntervalSeconds(Long intervalSeconds) {
    this.intervalSeconds = intervalSeconds;
    return (A) this;
  }
  
  public A withMaxSurge(IntOrString maxSurge) {
    this._visitables.remove("maxSurge");
    if (maxSurge != null) {
        this.maxSurge = new IntOrStringBuilder(maxSurge);
        this._visitables.get("maxSurge").add(this.maxSurge);
    } else {
        this.maxSurge = null;
        this._visitables.get("maxSurge").remove(this.maxSurge);
    }
    return (A) this;
  }
  
  public A withMaxUnavailable(IntOrString maxUnavailable) {
    this._visitables.remove("maxUnavailable");
    if (maxUnavailable != null) {
        this.maxUnavailable = new IntOrStringBuilder(maxUnavailable);
        this._visitables.get("maxUnavailable").add(this.maxUnavailable);
    } else {
        this.maxUnavailable = null;
        this._visitables.get("maxUnavailable").remove(this.maxUnavailable);
    }
    return (A) this;
  }
  
  public MaxSurgeNested<A> withNewMaxSurge() {
    return new MaxSurgeNested(null);
  }
  
  public A withNewMaxSurge(Object value) {
    return (A) this.withMaxSurge(new IntOrString(value));
  }
  
  public MaxSurgeNested<A> withNewMaxSurgeLike(IntOrString item) {
    return new MaxSurgeNested(item);
  }
  
  public MaxUnavailableNested<A> withNewMaxUnavailable() {
    return new MaxUnavailableNested(null);
  }
  
  public A withNewMaxUnavailable(Object value) {
    return (A) this.withMaxUnavailable(new IntOrString(value));
  }
  
  public MaxUnavailableNested<A> withNewMaxUnavailableLike(IntOrString item) {
    return new MaxUnavailableNested(item);
  }
  
  public PostNested<A> withNewPost() {
    return new PostNested(null);
  }
  
  public PostNested<A> withNewPostLike(LifecycleHook item) {
    return new PostNested(item);
  }
  
  public PreNested<A> withNewPre() {
    return new PreNested(null);
  }
  
  public PreNested<A> withNewPreLike(LifecycleHook item) {
    return new PreNested(item);
  }
  
  public A withPost(LifecycleHook post) {
    this._visitables.remove("post");
    if (post != null) {
        this.post = new LifecycleHookBuilder(post);
        this._visitables.get("post").add(this.post);
    } else {
        this.post = null;
        this._visitables.get("post").remove(this.post);
    }
    return (A) this;
  }
  
  public A withPre(LifecycleHook pre) {
    this._visitables.remove("pre");
    if (pre != null) {
        this.pre = new LifecycleHookBuilder(pre);
        this._visitables.get("pre").add(this.pre);
    } else {
        this.pre = null;
        this._visitables.get("pre").remove(this.pre);
    }
    return (A) this;
  }
  
  public A withTimeoutSeconds(Long timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
    return (A) this;
  }
  
  public A withUpdatePeriodSeconds(Long updatePeriodSeconds) {
    this.updatePeriodSeconds = updatePeriodSeconds;
    return (A) this;
  }
  public class MaxSurgeNested<N> extends IntOrStringFluent<MaxSurgeNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxSurgeNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) RollingDeploymentStrategyParamsFluent.this.withMaxSurge(builder.build());
    }
    
    public N endMaxSurge() {
      return and();
    }
    
  }
  public class MaxUnavailableNested<N> extends IntOrStringFluent<MaxUnavailableNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxUnavailableNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) RollingDeploymentStrategyParamsFluent.this.withMaxUnavailable(builder.build());
    }
    
    public N endMaxUnavailable() {
      return and();
    }
    
  }
  public class PostNested<N> extends LifecycleHookFluent<PostNested<N>> implements Nested<N>{
  
    LifecycleHookBuilder builder;
  
    PostNested(LifecycleHook item) {
      this.builder = new LifecycleHookBuilder(this, item);
    }
  
    public N and() {
      return (N) RollingDeploymentStrategyParamsFluent.this.withPost(builder.build());
    }
    
    public N endPost() {
      return and();
    }
    
  }
  public class PreNested<N> extends LifecycleHookFluent<PreNested<N>> implements Nested<N>{
  
    LifecycleHookBuilder builder;
  
    PreNested(LifecycleHook item) {
      this.builder = new LifecycleHookBuilder(this, item);
    }
  
    public N and() {
      return (N) RollingDeploymentStrategyParamsFluent.this.withPre(builder.build());
    }
    
    public N endPre() {
      return and();
    }
    
  }
}