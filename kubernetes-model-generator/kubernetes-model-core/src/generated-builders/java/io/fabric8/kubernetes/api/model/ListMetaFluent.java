package io.fabric8.kubernetes.api.model;

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
public class ListMetaFluent<A extends io.fabric8.kubernetes.api.model.ListMetaFluent<A>> extends BaseFluent<A>{

  private String _continue;
  private Map<String,Object> additionalProperties;
  private Long remainingItemCount;
  private String resourceVersion;
  private String selfLink;
  private ShardInfoBuilder shardInfo;

  public ListMetaFluent() {
  }
  
  public ListMetaFluent(ListMeta instance) {
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
  
  public ShardInfo buildShardInfo() {
    return this.shardInfo != null ? this.shardInfo.build() : null;
  }
  
  protected void copyInstance(ListMeta instance) {
    instance = instance != null ? instance : new ListMeta();
    if (instance != null) {
        this.withContinue(instance.getContinue());
        this.withRemainingItemCount(instance.getRemainingItemCount());
        this.withResourceVersion(instance.getResourceVersion());
        this.withSelfLink(instance.getSelfLink());
        this.withShardInfo(instance.getShardInfo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ShardInfoNested<A> editOrNewShardInfo() {
    return this.withNewShardInfoLike(Optional.ofNullable(this.buildShardInfo()).orElse(new ShardInfoBuilder().build()));
  }
  
  public ShardInfoNested<A> editOrNewShardInfoLike(ShardInfo item) {
    return this.withNewShardInfoLike(Optional.ofNullable(this.buildShardInfo()).orElse(item));
  }
  
  public ShardInfoNested<A> editShardInfo() {
    return this.withNewShardInfoLike(Optional.ofNullable(this.buildShardInfo()).orElse(null));
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
    ListMetaFluent that = (ListMetaFluent) o;
    if (!(Objects.equals(_continue, that._continue))) {
      return false;
    }
    if (!(Objects.equals(remainingItemCount, that.remainingItemCount))) {
      return false;
    }
    if (!(Objects.equals(resourceVersion, that.resourceVersion))) {
      return false;
    }
    if (!(Objects.equals(selfLink, that.selfLink))) {
      return false;
    }
    if (!(Objects.equals(shardInfo, that.shardInfo))) {
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
  
  public String getContinue() {
    return this._continue;
  }
  
  public Long getRemainingItemCount() {
    return this.remainingItemCount;
  }
  
  public String getResourceVersion() {
    return this.resourceVersion;
  }
  
  public String getSelfLink() {
    return this.selfLink;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContinue() {
    return this._continue != null;
  }
  
  public boolean hasRemainingItemCount() {
    return this.remainingItemCount != null;
  }
  
  public boolean hasResourceVersion() {
    return this.resourceVersion != null;
  }
  
  public boolean hasSelfLink() {
    return this.selfLink != null;
  }
  
  public boolean hasShardInfo() {
    return this.shardInfo != null;
  }
  
  public int hashCode() {
    return Objects.hash(_continue, remainingItemCount, resourceVersion, selfLink, shardInfo, additionalProperties);
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
    if (!(_continue == null)) {
        sb.append("_continue:");
        sb.append(_continue);
        sb.append(",");
    }
    if (!(remainingItemCount == null)) {
        sb.append("remainingItemCount:");
        sb.append(remainingItemCount);
        sb.append(",");
    }
    if (!(resourceVersion == null)) {
        sb.append("resourceVersion:");
        sb.append(resourceVersion);
        sb.append(",");
    }
    if (!(selfLink == null)) {
        sb.append("selfLink:");
        sb.append(selfLink);
        sb.append(",");
    }
    if (!(shardInfo == null)) {
        sb.append("shardInfo:");
        sb.append(shardInfo);
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
  
  public A withContinue(String _continue) {
    this._continue = _continue;
    return (A) this;
  }
  
  public ShardInfoNested<A> withNewShardInfo() {
    return new ShardInfoNested(null);
  }
  
  public A withNewShardInfo(String selector) {
    return (A) this.withShardInfo(new ShardInfo(selector));
  }
  
  public ShardInfoNested<A> withNewShardInfoLike(ShardInfo item) {
    return new ShardInfoNested(item);
  }
  
  public A withRemainingItemCount(Long remainingItemCount) {
    this.remainingItemCount = remainingItemCount;
    return (A) this;
  }
  
  public A withResourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
    return (A) this;
  }
  
  public A withSelfLink(String selfLink) {
    this.selfLink = selfLink;
    return (A) this;
  }
  
  public A withShardInfo(ShardInfo shardInfo) {
    this._visitables.remove("shardInfo");
    if (shardInfo != null) {
        this.shardInfo = new ShardInfoBuilder(shardInfo);
        this._visitables.get("shardInfo").add(this.shardInfo);
    } else {
        this.shardInfo = null;
        this._visitables.get("shardInfo").remove(this.shardInfo);
    }
    return (A) this;
  }
  public class ShardInfoNested<N> extends ShardInfoFluent<ShardInfoNested<N>> implements Nested<N>{
  
    ShardInfoBuilder builder;
  
    ShardInfoNested(ShardInfo item) {
      this.builder = new ShardInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) ListMetaFluent.this.withShardInfo(builder.build());
    }
    
    public N endShardInfo() {
      return and();
    }
    
  }
}