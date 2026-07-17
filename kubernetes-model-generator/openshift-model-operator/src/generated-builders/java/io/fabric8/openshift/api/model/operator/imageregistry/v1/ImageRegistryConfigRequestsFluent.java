package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ImageRegistryConfigRequestsFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigRequestsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ImageRegistryConfigRequestsLimitsBuilder read;
  private ImageRegistryConfigRequestsLimitsBuilder write;

  public ImageRegistryConfigRequestsFluent() {
  }
  
  public ImageRegistryConfigRequestsFluent(ImageRegistryConfigRequests instance) {
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
  
  public ImageRegistryConfigRequestsLimits buildRead() {
    return this.read != null ? this.read.build() : null;
  }
  
  public ImageRegistryConfigRequestsLimits buildWrite() {
    return this.write != null ? this.write.build() : null;
  }
  
  protected void copyInstance(ImageRegistryConfigRequests instance) {
    instance = instance != null ? instance : new ImageRegistryConfigRequests();
    if (instance != null) {
        this.withRead(instance.getRead());
        this.withWrite(instance.getWrite());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReadNested<A> editOrNewRead() {
    return this.withNewReadLike(Optional.ofNullable(this.buildRead()).orElse(new ImageRegistryConfigRequestsLimitsBuilder().build()));
  }
  
  public ReadNested<A> editOrNewReadLike(ImageRegistryConfigRequestsLimits item) {
    return this.withNewReadLike(Optional.ofNullable(this.buildRead()).orElse(item));
  }
  
  public WriteNested<A> editOrNewWrite() {
    return this.withNewWriteLike(Optional.ofNullable(this.buildWrite()).orElse(new ImageRegistryConfigRequestsLimitsBuilder().build()));
  }
  
  public WriteNested<A> editOrNewWriteLike(ImageRegistryConfigRequestsLimits item) {
    return this.withNewWriteLike(Optional.ofNullable(this.buildWrite()).orElse(item));
  }
  
  public ReadNested<A> editRead() {
    return this.withNewReadLike(Optional.ofNullable(this.buildRead()).orElse(null));
  }
  
  public WriteNested<A> editWrite() {
    return this.withNewWriteLike(Optional.ofNullable(this.buildWrite()).orElse(null));
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
    ImageRegistryConfigRequestsFluent that = (ImageRegistryConfigRequestsFluent) o;
    if (!(Objects.equals(read, that.read))) {
      return false;
    }
    if (!(Objects.equals(write, that.write))) {
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
  
  public boolean hasRead() {
    return this.read != null;
  }
  
  public boolean hasWrite() {
    return this.write != null;
  }
  
  public int hashCode() {
    return Objects.hash(read, write, additionalProperties);
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
    if (!(read == null)) {
        sb.append("read:");
        sb.append(read);
        sb.append(",");
    }
    if (!(write == null)) {
        sb.append("write:");
        sb.append(write);
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
  
  public ReadNested<A> withNewRead() {
    return new ReadNested(null);
  }
  
  public A withNewRead(Integer maxInQueue,Integer maxRunning,String maxWaitInQueue) {
    return (A) this.withRead(new ImageRegistryConfigRequestsLimits(maxInQueue, maxRunning, maxWaitInQueue));
  }
  
  public ReadNested<A> withNewReadLike(ImageRegistryConfigRequestsLimits item) {
    return new ReadNested(item);
  }
  
  public WriteNested<A> withNewWrite() {
    return new WriteNested(null);
  }
  
  public A withNewWrite(Integer maxInQueue,Integer maxRunning,String maxWaitInQueue) {
    return (A) this.withWrite(new ImageRegistryConfigRequestsLimits(maxInQueue, maxRunning, maxWaitInQueue));
  }
  
  public WriteNested<A> withNewWriteLike(ImageRegistryConfigRequestsLimits item) {
    return new WriteNested(item);
  }
  
  public A withRead(ImageRegistryConfigRequestsLimits read) {
    this._visitables.remove("read");
    if (read != null) {
        this.read = new ImageRegistryConfigRequestsLimitsBuilder(read);
        this._visitables.get("read").add(this.read);
    } else {
        this.read = null;
        this._visitables.get("read").remove(this.read);
    }
    return (A) this;
  }
  
  public A withWrite(ImageRegistryConfigRequestsLimits write) {
    this._visitables.remove("write");
    if (write != null) {
        this.write = new ImageRegistryConfigRequestsLimitsBuilder(write);
        this._visitables.get("write").add(this.write);
    } else {
        this.write = null;
        this._visitables.get("write").remove(this.write);
    }
    return (A) this;
  }
  public class ReadNested<N> extends ImageRegistryConfigRequestsLimitsFluent<ReadNested<N>> implements Nested<N>{
  
    ImageRegistryConfigRequestsLimitsBuilder builder;
  
    ReadNested(ImageRegistryConfigRequestsLimits item) {
      this.builder = new ImageRegistryConfigRequestsLimitsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigRequestsFluent.this.withRead(builder.build());
    }
    
    public N endRead() {
      return and();
    }
    
  }
  public class WriteNested<N> extends ImageRegistryConfigRequestsLimitsFluent<WriteNested<N>> implements Nested<N>{
  
    ImageRegistryConfigRequestsLimitsBuilder builder;
  
    WriteNested(ImageRegistryConfigRequestsLimits item) {
      this.builder = new ImageRegistryConfigRequestsLimitsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigRequestsFluent.this.withWrite(builder.build());
    }
    
    public N endWrite() {
      return and();
    }
    
  }
}