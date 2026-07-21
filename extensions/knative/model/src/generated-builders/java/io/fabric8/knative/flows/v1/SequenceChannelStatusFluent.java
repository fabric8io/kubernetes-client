package io.fabric8.knative.flows.v1;

import io.fabric8.knative.pkg.apis.Condition;
import io.fabric8.knative.pkg.apis.ConditionBuilder;
import io.fabric8.knative.pkg.apis.ConditionFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class SequenceChannelStatusFluent<A extends io.fabric8.knative.flows.v1.SequenceChannelStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder channel;
  private ConditionBuilder ready;

  public SequenceChannelStatusFluent() {
  }
  
  public SequenceChannelStatusFluent(SequenceChannelStatus instance) {
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
  
  public ObjectReference buildChannel() {
    return this.channel != null ? this.channel.build() : null;
  }
  
  public Condition buildReady() {
    return this.ready != null ? this.ready.build() : null;
  }
  
  protected void copyInstance(SequenceChannelStatus instance) {
    instance = instance != null ? instance : new SequenceChannelStatus();
    if (instance != null) {
        this.withChannel(instance.getChannel());
        this.withReady(instance.getReady());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ChannelNested<A> editChannel() {
    return this.withNewChannelLike(Optional.ofNullable(this.buildChannel()).orElse(null));
  }
  
  public ChannelNested<A> editOrNewChannel() {
    return this.withNewChannelLike(Optional.ofNullable(this.buildChannel()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ChannelNested<A> editOrNewChannelLike(ObjectReference item) {
    return this.withNewChannelLike(Optional.ofNullable(this.buildChannel()).orElse(item));
  }
  
  public ReadyNested<A> editOrNewReady() {
    return this.withNewReadyLike(Optional.ofNullable(this.buildReady()).orElse(new ConditionBuilder().build()));
  }
  
  public ReadyNested<A> editOrNewReadyLike(Condition item) {
    return this.withNewReadyLike(Optional.ofNullable(this.buildReady()).orElse(item));
  }
  
  public ReadyNested<A> editReady() {
    return this.withNewReadyLike(Optional.ofNullable(this.buildReady()).orElse(null));
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
    SequenceChannelStatusFluent that = (SequenceChannelStatusFluent) o;
    if (!(Objects.equals(channel, that.channel))) {
      return false;
    }
    if (!(Objects.equals(ready, that.ready))) {
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
  
  public boolean hasChannel() {
    return this.channel != null;
  }
  
  public boolean hasReady() {
    return this.ready != null;
  }
  
  public int hashCode() {
    return Objects.hash(channel, ready, additionalProperties);
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
    if (!(channel == null)) {
        sb.append("channel:");
        sb.append(channel);
        sb.append(",");
    }
    if (!(ready == null)) {
        sb.append("ready:");
        sb.append(ready);
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
  
  public A withChannel(ObjectReference channel) {
    this._visitables.remove("channel");
    if (channel != null) {
        this.channel = new ObjectReferenceBuilder(channel);
        this._visitables.get("channel").add(this.channel);
    } else {
        this.channel = null;
        this._visitables.get("channel").remove(this.channel);
    }
    return (A) this;
  }
  
  public ChannelNested<A> withNewChannel() {
    return new ChannelNested(null);
  }
  
  public ChannelNested<A> withNewChannelLike(ObjectReference item) {
    return new ChannelNested(item);
  }
  
  public ReadyNested<A> withNewReady() {
    return new ReadyNested(null);
  }
  
  public ReadyNested<A> withNewReadyLike(Condition item) {
    return new ReadyNested(item);
  }
  
  public A withReady(Condition ready) {
    this._visitables.remove("ready");
    if (ready != null) {
        this.ready = new ConditionBuilder(ready);
        this._visitables.get("ready").add(this.ready);
    } else {
        this.ready = null;
        this._visitables.get("ready").remove(this.ready);
    }
    return (A) this;
  }
  public class ChannelNested<N> extends ObjectReferenceFluent<ChannelNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ChannelNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceChannelStatusFluent.this.withChannel(builder.build());
    }
    
    public N endChannel() {
      return and();
    }
    
  }
  public class ReadyNested<N> extends ConditionFluent<ReadyNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
  
    ReadyNested(Condition item) {
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceChannelStatusFluent.this.withReady(builder.build());
    }
    
    public N endReady() {
      return and();
    }
    
  }
}