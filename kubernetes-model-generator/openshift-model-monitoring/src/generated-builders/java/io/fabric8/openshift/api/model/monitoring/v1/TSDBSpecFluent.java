package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class TSDBSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.TSDBSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ChunkEncodingSpecBuilder chunkEncoding;
  private String outOfOrderTimeWindow;
  private Quantity staleSeriesCompactionThreshold;

  public TSDBSpecFluent() {
  }
  
  public TSDBSpecFluent(TSDBSpec instance) {
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
  
  public ChunkEncodingSpec buildChunkEncoding() {
    return this.chunkEncoding != null ? this.chunkEncoding.build() : null;
  }
  
  protected void copyInstance(TSDBSpec instance) {
    instance = instance != null ? instance : new TSDBSpec();
    if (instance != null) {
        this.withChunkEncoding(instance.getChunkEncoding());
        this.withOutOfOrderTimeWindow(instance.getOutOfOrderTimeWindow());
        this.withStaleSeriesCompactionThreshold(instance.getStaleSeriesCompactionThreshold());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ChunkEncodingNested<A> editChunkEncoding() {
    return this.withNewChunkEncodingLike(Optional.ofNullable(this.buildChunkEncoding()).orElse(null));
  }
  
  public ChunkEncodingNested<A> editOrNewChunkEncoding() {
    return this.withNewChunkEncodingLike(Optional.ofNullable(this.buildChunkEncoding()).orElse(new ChunkEncodingSpecBuilder().build()));
  }
  
  public ChunkEncodingNested<A> editOrNewChunkEncodingLike(ChunkEncodingSpec item) {
    return this.withNewChunkEncodingLike(Optional.ofNullable(this.buildChunkEncoding()).orElse(item));
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
    TSDBSpecFluent that = (TSDBSpecFluent) o;
    if (!(Objects.equals(chunkEncoding, that.chunkEncoding))) {
      return false;
    }
    if (!(Objects.equals(outOfOrderTimeWindow, that.outOfOrderTimeWindow))) {
      return false;
    }
    if (!(Objects.equals(staleSeriesCompactionThreshold, that.staleSeriesCompactionThreshold))) {
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
  
  public String getOutOfOrderTimeWindow() {
    return this.outOfOrderTimeWindow;
  }
  
  public Quantity getStaleSeriesCompactionThreshold() {
    return this.staleSeriesCompactionThreshold;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChunkEncoding() {
    return this.chunkEncoding != null;
  }
  
  public boolean hasOutOfOrderTimeWindow() {
    return this.outOfOrderTimeWindow != null;
  }
  
  public boolean hasStaleSeriesCompactionThreshold() {
    return this.staleSeriesCompactionThreshold != null;
  }
  
  public int hashCode() {
    return Objects.hash(chunkEncoding, outOfOrderTimeWindow, staleSeriesCompactionThreshold, additionalProperties);
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
    if (!(chunkEncoding == null)) {
        sb.append("chunkEncoding:");
        sb.append(chunkEncoding);
        sb.append(",");
    }
    if (!(outOfOrderTimeWindow == null)) {
        sb.append("outOfOrderTimeWindow:");
        sb.append(outOfOrderTimeWindow);
        sb.append(",");
    }
    if (!(staleSeriesCompactionThreshold == null)) {
        sb.append("staleSeriesCompactionThreshold:");
        sb.append(staleSeriesCompactionThreshold);
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
  
  public A withChunkEncoding(ChunkEncodingSpec chunkEncoding) {
    this._visitables.remove("chunkEncoding");
    if (chunkEncoding != null) {
        this.chunkEncoding = new ChunkEncodingSpecBuilder(chunkEncoding);
        this._visitables.get("chunkEncoding").add(this.chunkEncoding);
    } else {
        this.chunkEncoding = null;
        this._visitables.get("chunkEncoding").remove(this.chunkEncoding);
    }
    return (A) this;
  }
  
  public ChunkEncodingNested<A> withNewChunkEncoding() {
    return new ChunkEncodingNested(null);
  }
  
  public A withNewChunkEncoding(String floats) {
    return (A) this.withChunkEncoding(new ChunkEncodingSpec(floats));
  }
  
  public ChunkEncodingNested<A> withNewChunkEncodingLike(ChunkEncodingSpec item) {
    return new ChunkEncodingNested(item);
  }
  
  public A withNewStaleSeriesCompactionThreshold(String amount) {
    return (A) this.withStaleSeriesCompactionThreshold(new Quantity(amount));
  }
  
  public A withNewStaleSeriesCompactionThreshold(String amount,String format) {
    return (A) this.withStaleSeriesCompactionThreshold(new Quantity(amount, format));
  }
  
  public A withOutOfOrderTimeWindow(String outOfOrderTimeWindow) {
    this.outOfOrderTimeWindow = outOfOrderTimeWindow;
    return (A) this;
  }
  
  public A withStaleSeriesCompactionThreshold(Quantity staleSeriesCompactionThreshold) {
    this.staleSeriesCompactionThreshold = staleSeriesCompactionThreshold;
    return (A) this;
  }
  public class ChunkEncodingNested<N> extends ChunkEncodingSpecFluent<ChunkEncodingNested<N>> implements Nested<N>{
  
    ChunkEncodingSpecBuilder builder;
  
    ChunkEncodingNested(ChunkEncodingSpec item) {
      this.builder = new ChunkEncodingSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) TSDBSpecFluent.this.withChunkEncoding(builder.build());
    }
    
    public N endChunkEncoding() {
      return and();
    }
    
  }
}