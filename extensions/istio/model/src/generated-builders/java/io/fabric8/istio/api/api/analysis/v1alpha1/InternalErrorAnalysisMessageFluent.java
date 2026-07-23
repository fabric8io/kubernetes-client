package io.fabric8.istio.api.api.analysis.v1alpha1;

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
public class InternalErrorAnalysisMessageFluent<A extends io.fabric8.istio.api.api.analysis.v1alpha1.InternalErrorAnalysisMessageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String detail;
  private AnalysisMessageBaseBuilder messageBase;

  public InternalErrorAnalysisMessageFluent() {
  }
  
  public InternalErrorAnalysisMessageFluent(InternalErrorAnalysisMessage instance) {
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
  
  public AnalysisMessageBase buildMessageBase() {
    return this.messageBase != null ? this.messageBase.build() : null;
  }
  
  protected void copyInstance(InternalErrorAnalysisMessage instance) {
    instance = instance != null ? instance : new InternalErrorAnalysisMessage();
    if (instance != null) {
        this.withDetail(instance.getDetail());
        this.withMessageBase(instance.getMessageBase());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MessageBaseNested<A> editMessageBase() {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(null));
  }
  
  public MessageBaseNested<A> editOrNewMessageBase() {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(new AnalysisMessageBaseBuilder().build()));
  }
  
  public MessageBaseNested<A> editOrNewMessageBaseLike(AnalysisMessageBase item) {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(item));
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
    InternalErrorAnalysisMessageFluent that = (InternalErrorAnalysisMessageFluent) o;
    if (!(Objects.equals(detail, that.detail))) {
      return false;
    }
    if (!(Objects.equals(messageBase, that.messageBase))) {
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
  
  public String getDetail() {
    return this.detail;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDetail() {
    return this.detail != null;
  }
  
  public boolean hasMessageBase() {
    return this.messageBase != null;
  }
  
  public int hashCode() {
    return Objects.hash(detail, messageBase, additionalProperties);
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
    if (!(detail == null)) {
        sb.append("detail:");
        sb.append(detail);
        sb.append(",");
    }
    if (!(messageBase == null)) {
        sb.append("messageBase:");
        sb.append(messageBase);
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
  
  public A withDetail(String detail) {
    this.detail = detail;
    return (A) this;
  }
  
  public A withMessageBase(AnalysisMessageBase messageBase) {
    this._visitables.remove("messageBase");
    if (messageBase != null) {
        this.messageBase = new AnalysisMessageBaseBuilder(messageBase);
        this._visitables.get("messageBase").add(this.messageBase);
    } else {
        this.messageBase = null;
        this._visitables.get("messageBase").remove(this.messageBase);
    }
    return (A) this;
  }
  
  public MessageBaseNested<A> withNewMessageBase() {
    return new MessageBaseNested(null);
  }
  
  public MessageBaseNested<A> withNewMessageBaseLike(AnalysisMessageBase item) {
    return new MessageBaseNested(item);
  }
  public class MessageBaseNested<N> extends AnalysisMessageBaseFluent<MessageBaseNested<N>> implements Nested<N>{
  
    AnalysisMessageBaseBuilder builder;
  
    MessageBaseNested(AnalysisMessageBase item) {
      this.builder = new AnalysisMessageBaseBuilder(this, item);
    }
  
    public N and() {
      return (N) InternalErrorAnalysisMessageFluent.this.withMessageBase(builder.build());
    }
    
    public N endMessageBase() {
      return and();
    }
    
  }
}