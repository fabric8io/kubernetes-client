package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class RecreateDeploymentStrategyParamsFluent<A extends io.fabric8.openshift.api.model.RecreateDeploymentStrategyParamsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LifecycleHookBuilder mid;
  private LifecycleHookBuilder post;
  private LifecycleHookBuilder pre;
  private Long timeoutSeconds;

  public RecreateDeploymentStrategyParamsFluent() {
  }
  
  public RecreateDeploymentStrategyParamsFluent(RecreateDeploymentStrategyParams instance) {
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
  
  public LifecycleHook buildMid() {
    return this.mid != null ? this.mid.build() : null;
  }
  
  public LifecycleHook buildPost() {
    return this.post != null ? this.post.build() : null;
  }
  
  public LifecycleHook buildPre() {
    return this.pre != null ? this.pre.build() : null;
  }
  
  protected void copyInstance(RecreateDeploymentStrategyParams instance) {
    instance = instance != null ? instance : new RecreateDeploymentStrategyParams();
    if (instance != null) {
        this.withMid(instance.getMid());
        this.withPost(instance.getPost());
        this.withPre(instance.getPre());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MidNested<A> editMid() {
    return this.withNewMidLike(Optional.ofNullable(this.buildMid()).orElse(null));
  }
  
  public MidNested<A> editOrNewMid() {
    return this.withNewMidLike(Optional.ofNullable(this.buildMid()).orElse(new LifecycleHookBuilder().build()));
  }
  
  public MidNested<A> editOrNewMidLike(LifecycleHook item) {
    return this.withNewMidLike(Optional.ofNullable(this.buildMid()).orElse(item));
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
    RecreateDeploymentStrategyParamsFluent that = (RecreateDeploymentStrategyParamsFluent) o;
    if (!(Objects.equals(mid, that.mid))) {
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
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Long getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMid() {
    return this.mid != null;
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
  
  public int hashCode() {
    return Objects.hash(mid, post, pre, timeoutSeconds, additionalProperties);
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
    if (!(mid == null)) {
        sb.append("mid:");
        sb.append(mid);
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
  
  public A withMid(LifecycleHook mid) {
    this._visitables.remove("mid");
    if (mid != null) {
        this.mid = new LifecycleHookBuilder(mid);
        this._visitables.get("mid").add(this.mid);
    } else {
        this.mid = null;
        this._visitables.get("mid").remove(this.mid);
    }
    return (A) this;
  }
  
  public MidNested<A> withNewMid() {
    return new MidNested(null);
  }
  
  public MidNested<A> withNewMidLike(LifecycleHook item) {
    return new MidNested(item);
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
  public class MidNested<N> extends LifecycleHookFluent<MidNested<N>> implements Nested<N>{
  
    LifecycleHookBuilder builder;
  
    MidNested(LifecycleHook item) {
      this.builder = new LifecycleHookBuilder(this, item);
    }
  
    public N and() {
      return (N) RecreateDeploymentStrategyParamsFluent.this.withMid(builder.build());
    }
    
    public N endMid() {
      return and();
    }
    
  }
  public class PostNested<N> extends LifecycleHookFluent<PostNested<N>> implements Nested<N>{
  
    LifecycleHookBuilder builder;
  
    PostNested(LifecycleHook item) {
      this.builder = new LifecycleHookBuilder(this, item);
    }
  
    public N and() {
      return (N) RecreateDeploymentStrategyParamsFluent.this.withPost(builder.build());
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
      return (N) RecreateDeploymentStrategyParamsFluent.this.withPre(builder.build());
    }
    
    public N endPre() {
      return and();
    }
    
  }
}