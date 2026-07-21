package io.fabric8.knative.eventing.v1beta1;

import io.fabric8.knative.duck.v1.KReference;
import io.fabric8.knative.duck.v1.KReferenceBuilder;
import io.fabric8.knative.duck.v1.KReferenceFluent;
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
public class EventTypeSpecFluent<A extends io.fabric8.knative.eventing.v1beta1.EventTypeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String broker;
  private String description;
  private KReferenceBuilder reference;
  private String schema;
  private String schemaData;
  private String source;
  private String type;

  public EventTypeSpecFluent() {
  }
  
  public EventTypeSpecFluent(EventTypeSpec instance) {
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
  
  public KReference buildReference() {
    return this.reference != null ? this.reference.build() : null;
  }
  
  protected void copyInstance(EventTypeSpec instance) {
    instance = instance != null ? instance : new EventTypeSpec();
    if (instance != null) {
        this.withBroker(instance.getBroker());
        this.withDescription(instance.getDescription());
        this.withReference(instance.getReference());
        this.withSchema(instance.getSchema());
        this.withSchemaData(instance.getSchemaData());
        this.withSource(instance.getSource());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReferenceNested<A> editOrNewReference() {
    return this.withNewReferenceLike(Optional.ofNullable(this.buildReference()).orElse(new KReferenceBuilder().build()));
  }
  
  public ReferenceNested<A> editOrNewReferenceLike(KReference item) {
    return this.withNewReferenceLike(Optional.ofNullable(this.buildReference()).orElse(item));
  }
  
  public ReferenceNested<A> editReference() {
    return this.withNewReferenceLike(Optional.ofNullable(this.buildReference()).orElse(null));
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
    EventTypeSpecFluent that = (EventTypeSpecFluent) o;
    if (!(Objects.equals(broker, that.broker))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(reference, that.reference))) {
      return false;
    }
    if (!(Objects.equals(schema, that.schema))) {
      return false;
    }
    if (!(Objects.equals(schemaData, that.schemaData))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getBroker() {
    return this.broker;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getSchema() {
    return this.schema;
  }
  
  public String getSchemaData() {
    return this.schemaData;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBroker() {
    return this.broker != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasReference() {
    return this.reference != null;
  }
  
  public boolean hasSchema() {
    return this.schema != null;
  }
  
  public boolean hasSchemaData() {
    return this.schemaData != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(broker, description, reference, schema, schemaData, source, type, additionalProperties);
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
    if (!(broker == null)) {
        sb.append("broker:");
        sb.append(broker);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(reference == null)) {
        sb.append("reference:");
        sb.append(reference);
        sb.append(",");
    }
    if (!(schema == null)) {
        sb.append("schema:");
        sb.append(schema);
        sb.append(",");
    }
    if (!(schemaData == null)) {
        sb.append("schemaData:");
        sb.append(schemaData);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withBroker(String broker) {
    this.broker = broker;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public ReferenceNested<A> withNewReference() {
    return new ReferenceNested(null);
  }
  
  public ReferenceNested<A> withNewReferenceLike(KReference item) {
    return new ReferenceNested(item);
  }
  
  public A withReference(KReference reference) {
    this._visitables.remove("reference");
    if (reference != null) {
        this.reference = new KReferenceBuilder(reference);
        this._visitables.get("reference").add(this.reference);
    } else {
        this.reference = null;
        this._visitables.get("reference").remove(this.reference);
    }
    return (A) this;
  }
  
  public A withSchema(String schema) {
    this.schema = schema;
    return (A) this;
  }
  
  public A withSchemaData(String schemaData) {
    this.schemaData = schemaData;
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ReferenceNested<N> extends KReferenceFluent<ReferenceNested<N>> implements Nested<N>{
  
    KReferenceBuilder builder;
  
    ReferenceNested(KReference item) {
      this.builder = new KReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EventTypeSpecFluent.this.withReference(builder.build());
    }
    
    public N endReference() {
      return and();
    }
    
  }
}