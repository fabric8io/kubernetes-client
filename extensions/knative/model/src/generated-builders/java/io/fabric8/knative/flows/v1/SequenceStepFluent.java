package io.fabric8.knative.flows.v1;

import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.DeliverySpecBuilder;
import io.fabric8.knative.duck.v1.DeliverySpecFluent;
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
public class SequenceStepFluent<A extends io.fabric8.knative.flows.v1.SequenceStepFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String audience;
  private String cACerts;
  private DeliverySpecBuilder delivery;
  private KReferenceBuilder ref;
  private String uri;

  public SequenceStepFluent() {
  }
  
  public SequenceStepFluent(SequenceStep instance) {
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
  
  public DeliverySpec buildDelivery() {
    return this.delivery != null ? this.delivery.build() : null;
  }
  
  public KReference buildRef() {
    return this.ref != null ? this.ref.build() : null;
  }
  
  protected void copyInstance(SequenceStep instance) {
    instance = instance != null ? instance : new SequenceStep();
    if (instance != null) {
        this.withCACerts(instance.getCACerts());
        this.withAudience(instance.getAudience());
        this.withDelivery(instance.getDelivery());
        this.withRef(instance.getRef());
        this.withUri(instance.getUri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeliveryNested<A> editDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(null));
  }
  
  public DeliveryNested<A> editOrNewDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(new DeliverySpecBuilder().build()));
  }
  
  public DeliveryNested<A> editOrNewDeliveryLike(DeliverySpec item) {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(item));
  }
  
  public RefNested<A> editOrNewRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(new KReferenceBuilder().build()));
  }
  
  public RefNested<A> editOrNewRefLike(KReference item) {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(item));
  }
  
  public RefNested<A> editRef() {
    return this.withNewRefLike(Optional.ofNullable(this.buildRef()).orElse(null));
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
    SequenceStepFluent that = (SequenceStepFluent) o;
    if (!(Objects.equals(cACerts, that.cACerts))) {
      return false;
    }
    if (!(Objects.equals(audience, that.audience))) {
      return false;
    }
    if (!(Objects.equals(delivery, that.delivery))) {
      return false;
    }
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
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
  
  public String getAudience() {
    return this.audience;
  }
  
  public String getCACerts() {
    return this.cACerts;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAudience() {
    return this.audience != null;
  }
  
  public boolean hasCACerts() {
    return this.cACerts != null;
  }
  
  public boolean hasDelivery() {
    return this.delivery != null;
  }
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(cACerts, audience, delivery, ref, uri, additionalProperties);
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
    if (!(cACerts == null)) {
        sb.append("cACerts:");
        sb.append(cACerts);
        sb.append(",");
    }
    if (!(audience == null)) {
        sb.append("audience:");
        sb.append(audience);
        sb.append(",");
    }
    if (!(delivery == null)) {
        sb.append("delivery:");
        sb.append(delivery);
        sb.append(",");
    }
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
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
  
  public A withAudience(String audience) {
    this.audience = audience;
    return (A) this;
  }
  
  public A withCACerts(String cACerts) {
    this.cACerts = cACerts;
    return (A) this;
  }
  
  public A withDelivery(DeliverySpec delivery) {
    this._visitables.remove("delivery");
    if (delivery != null) {
        this.delivery = new DeliverySpecBuilder(delivery);
        this._visitables.get("delivery").add(this.delivery);
    } else {
        this.delivery = null;
        this._visitables.get("delivery").remove(this.delivery);
    }
    return (A) this;
  }
  
  public DeliveryNested<A> withNewDelivery() {
    return new DeliveryNested(null);
  }
  
  public DeliveryNested<A> withNewDeliveryLike(DeliverySpec item) {
    return new DeliveryNested(item);
  }
  
  public RefNested<A> withNewRef() {
    return new RefNested(null);
  }
  
  public RefNested<A> withNewRefLike(KReference item) {
    return new RefNested(item);
  }
  
  public A withRef(KReference ref) {
    this._visitables.remove("ref");
    if (ref != null) {
        this.ref = new KReferenceBuilder(ref);
        this._visitables.get("ref").add(this.ref);
    } else {
        this.ref = null;
        this._visitables.get("ref").remove(this.ref);
    }
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  public class DeliveryNested<N> extends DeliverySpecFluent<DeliveryNested<N>> implements Nested<N>{
  
    DeliverySpecBuilder builder;
  
    DeliveryNested(DeliverySpec item) {
      this.builder = new DeliverySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceStepFluent.this.withDelivery(builder.build());
    }
    
    public N endDelivery() {
      return and();
    }
    
  }
  public class RefNested<N> extends KReferenceFluent<RefNested<N>> implements Nested<N>{
  
    KReferenceBuilder builder;
  
    RefNested(KReference item) {
      this.builder = new KReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceStepFluent.this.withRef(builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
}