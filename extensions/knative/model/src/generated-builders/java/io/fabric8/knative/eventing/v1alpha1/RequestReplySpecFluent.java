package io.fabric8.knative.eventing.v1alpha1;

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
public class RequestReplySpecFluent<A extends io.fabric8.knative.eventing.v1alpha1.RequestReplySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private KReferenceBuilder brokerRef;
  private String correlationAttribute;
  private DeliverySpecBuilder delivery;
  private String replyAttribute;
  private String timeout;

  public RequestReplySpecFluent() {
  }
  
  public RequestReplySpecFluent(RequestReplySpec instance) {
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
  
  public KReference buildBrokerRef() {
    return this.brokerRef != null ? this.brokerRef.build() : null;
  }
  
  public DeliverySpec buildDelivery() {
    return this.delivery != null ? this.delivery.build() : null;
  }
  
  protected void copyInstance(RequestReplySpec instance) {
    instance = instance != null ? instance : new RequestReplySpec();
    if (instance != null) {
        this.withBrokerRef(instance.getBrokerRef());
        this.withCorrelationAttribute(instance.getCorrelationAttribute());
        this.withDelivery(instance.getDelivery());
        this.withReplyAttribute(instance.getReplyAttribute());
        this.withTimeout(instance.getTimeout());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BrokerRefNested<A> editBrokerRef() {
    return this.withNewBrokerRefLike(Optional.ofNullable(this.buildBrokerRef()).orElse(null));
  }
  
  public DeliveryNested<A> editDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(null));
  }
  
  public BrokerRefNested<A> editOrNewBrokerRef() {
    return this.withNewBrokerRefLike(Optional.ofNullable(this.buildBrokerRef()).orElse(new KReferenceBuilder().build()));
  }
  
  public BrokerRefNested<A> editOrNewBrokerRefLike(KReference item) {
    return this.withNewBrokerRefLike(Optional.ofNullable(this.buildBrokerRef()).orElse(item));
  }
  
  public DeliveryNested<A> editOrNewDelivery() {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(new DeliverySpecBuilder().build()));
  }
  
  public DeliveryNested<A> editOrNewDeliveryLike(DeliverySpec item) {
    return this.withNewDeliveryLike(Optional.ofNullable(this.buildDelivery()).orElse(item));
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
    RequestReplySpecFluent that = (RequestReplySpecFluent) o;
    if (!(Objects.equals(brokerRef, that.brokerRef))) {
      return false;
    }
    if (!(Objects.equals(correlationAttribute, that.correlationAttribute))) {
      return false;
    }
    if (!(Objects.equals(delivery, that.delivery))) {
      return false;
    }
    if (!(Objects.equals(replyAttribute, that.replyAttribute))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
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
  
  public String getCorrelationAttribute() {
    return this.correlationAttribute;
  }
  
  public String getReplyAttribute() {
    return this.replyAttribute;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBrokerRef() {
    return this.brokerRef != null;
  }
  
  public boolean hasCorrelationAttribute() {
    return this.correlationAttribute != null;
  }
  
  public boolean hasDelivery() {
    return this.delivery != null;
  }
  
  public boolean hasReplyAttribute() {
    return this.replyAttribute != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(brokerRef, correlationAttribute, delivery, replyAttribute, timeout, additionalProperties);
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
    if (!(brokerRef == null)) {
        sb.append("brokerRef:");
        sb.append(brokerRef);
        sb.append(",");
    }
    if (!(correlationAttribute == null)) {
        sb.append("correlationAttribute:");
        sb.append(correlationAttribute);
        sb.append(",");
    }
    if (!(delivery == null)) {
        sb.append("delivery:");
        sb.append(delivery);
        sb.append(",");
    }
    if (!(replyAttribute == null)) {
        sb.append("replyAttribute:");
        sb.append(replyAttribute);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
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
  
  public A withBrokerRef(KReference brokerRef) {
    this._visitables.remove("brokerRef");
    if (brokerRef != null) {
        this.brokerRef = new KReferenceBuilder(brokerRef);
        this._visitables.get("brokerRef").add(this.brokerRef);
    } else {
        this.brokerRef = null;
        this._visitables.get("brokerRef").remove(this.brokerRef);
    }
    return (A) this;
  }
  
  public A withCorrelationAttribute(String correlationAttribute) {
    this.correlationAttribute = correlationAttribute;
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
  
  public BrokerRefNested<A> withNewBrokerRef() {
    return new BrokerRefNested(null);
  }
  
  public BrokerRefNested<A> withNewBrokerRefLike(KReference item) {
    return new BrokerRefNested(item);
  }
  
  public DeliveryNested<A> withNewDelivery() {
    return new DeliveryNested(null);
  }
  
  public DeliveryNested<A> withNewDeliveryLike(DeliverySpec item) {
    return new DeliveryNested(item);
  }
  
  public A withReplyAttribute(String replyAttribute) {
    this.replyAttribute = replyAttribute;
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  public class BrokerRefNested<N> extends KReferenceFluent<BrokerRefNested<N>> implements Nested<N>{
  
    KReferenceBuilder builder;
  
    BrokerRefNested(KReference item) {
      this.builder = new KReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) RequestReplySpecFluent.this.withBrokerRef(builder.build());
    }
    
    public N endBrokerRef() {
      return and();
    }
    
  }
  public class DeliveryNested<N> extends DeliverySpecFluent<DeliveryNested<N>> implements Nested<N>{
  
    DeliverySpecBuilder builder;
  
    DeliveryNested(DeliverySpec item) {
      this.builder = new DeliverySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) RequestReplySpecFluent.this.withDelivery(builder.build());
    }
    
    public N endDelivery() {
      return and();
    }
    
  }
}