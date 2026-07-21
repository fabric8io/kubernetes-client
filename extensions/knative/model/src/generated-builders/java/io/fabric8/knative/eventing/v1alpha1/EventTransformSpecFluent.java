package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
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
public class EventTransformSpecFluent<A extends io.fabric8.knative.eventing.v1alpha1.EventTransformSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private JsonataEventTransformationSpecBuilder jsonata;
  private ReplySpecBuilder reply;
  private DestinationBuilder sink;

  public EventTransformSpecFluent() {
  }
  
  public EventTransformSpecFluent(EventTransformSpec instance) {
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
  
  public JsonataEventTransformationSpec buildJsonata() {
    return this.jsonata != null ? this.jsonata.build() : null;
  }
  
  public ReplySpec buildReply() {
    return this.reply != null ? this.reply.build() : null;
  }
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  protected void copyInstance(EventTransformSpec instance) {
    instance = instance != null ? instance : new EventTransformSpec();
    if (instance != null) {
        this.withJsonata(instance.getJsonata());
        this.withReply(instance.getReply());
        this.withSink(instance.getSink());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public JsonataNested<A> editJsonata() {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(null));
  }
  
  public JsonataNested<A> editOrNewJsonata() {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(new JsonataEventTransformationSpecBuilder().build()));
  }
  
  public JsonataNested<A> editOrNewJsonataLike(JsonataEventTransformationSpec item) {
    return this.withNewJsonataLike(Optional.ofNullable(this.buildJsonata()).orElse(item));
  }
  
  public ReplyNested<A> editOrNewReply() {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(new ReplySpecBuilder().build()));
  }
  
  public ReplyNested<A> editOrNewReplyLike(ReplySpec item) {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(item));
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public ReplyNested<A> editReply() {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(null));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
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
    EventTransformSpecFluent that = (EventTransformSpecFluent) o;
    if (!(Objects.equals(jsonata, that.jsonata))) {
      return false;
    }
    if (!(Objects.equals(reply, that.reply))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
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
  
  public boolean hasJsonata() {
    return this.jsonata != null;
  }
  
  public boolean hasReply() {
    return this.reply != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public int hashCode() {
    return Objects.hash(jsonata, reply, sink, additionalProperties);
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
    if (!(jsonata == null)) {
        sb.append("jsonata:");
        sb.append(jsonata);
        sb.append(",");
    }
    if (!(reply == null)) {
        sb.append("reply:");
        sb.append(reply);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
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
  
  public A withJsonata(JsonataEventTransformationSpec jsonata) {
    this._visitables.remove("jsonata");
    if (jsonata != null) {
        this.jsonata = new JsonataEventTransformationSpecBuilder(jsonata);
        this._visitables.get("jsonata").add(this.jsonata);
    } else {
        this.jsonata = null;
        this._visitables.get("jsonata").remove(this.jsonata);
    }
    return (A) this;
  }
  
  public JsonataNested<A> withNewJsonata() {
    return new JsonataNested(null);
  }
  
  public A withNewJsonata(String expression) {
    return (A) this.withJsonata(new JsonataEventTransformationSpec(expression));
  }
  
  public JsonataNested<A> withNewJsonataLike(JsonataEventTransformationSpec item) {
    return new JsonataNested(item);
  }
  
  public ReplyNested<A> withNewReply() {
    return new ReplyNested(null);
  }
  
  public ReplyNested<A> withNewReplyLike(ReplySpec item) {
    return new ReplyNested(item);
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public A withReply(ReplySpec reply) {
    this._visitables.remove("reply");
    if (reply != null) {
        this.reply = new ReplySpecBuilder(reply);
        this._visitables.get("reply").add(this.reply);
    } else {
        this.reply = null;
        this._visitables.get("reply").remove(this.reply);
    }
    return (A) this;
  }
  
  public A withSink(Destination sink) {
    this._visitables.remove("sink");
    if (sink != null) {
        this.sink = new DestinationBuilder(sink);
        this._visitables.get("sink").add(this.sink);
    } else {
        this.sink = null;
        this._visitables.get("sink").remove(this.sink);
    }
    return (A) this;
  }
  public class JsonataNested<N> extends JsonataEventTransformationSpecFluent<JsonataNested<N>> implements Nested<N>{
  
    JsonataEventTransformationSpecBuilder builder;
  
    JsonataNested(JsonataEventTransformationSpec item) {
      this.builder = new JsonataEventTransformationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTransformSpecFluent.this.withJsonata(builder.build());
    }
    
    public N endJsonata() {
      return and();
    }
    
  }
  public class ReplyNested<N> extends ReplySpecFluent<ReplyNested<N>> implements Nested<N>{
  
    ReplySpecBuilder builder;
  
    ReplyNested(ReplySpec item) {
      this.builder = new ReplySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTransformSpecFluent.this.withReply(builder.build());
    }
    
    public N endReply() {
      return and();
    }
    
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTransformSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
}