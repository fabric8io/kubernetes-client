package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SubscriptionStatusPhysicalSubscriptionFluent<A extends io.fabric8.knative.messaging.v1.SubscriptionStatusPhysicalSubscriptionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String deadLetterSinkAudience;
  private String deadLetterSinkCACerts;
  private String deadLetterSinkUri;
  private String replyAudience;
  private String replyCACerts;
  private String replyUri;
  private String subscriberAudience;
  private String subscriberCACerts;
  private String subscriberUri;

  public SubscriptionStatusPhysicalSubscriptionFluent() {
  }
  
  public SubscriptionStatusPhysicalSubscriptionFluent(SubscriptionStatusPhysicalSubscription instance) {
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
  
  protected void copyInstance(SubscriptionStatusPhysicalSubscription instance) {
    instance = instance != null ? instance : new SubscriptionStatusPhysicalSubscription();
    if (instance != null) {
        this.withDeadLetterSinkAudience(instance.getDeadLetterSinkAudience());
        this.withDeadLetterSinkCACerts(instance.getDeadLetterSinkCACerts());
        this.withDeadLetterSinkUri(instance.getDeadLetterSinkUri());
        this.withReplyAudience(instance.getReplyAudience());
        this.withReplyCACerts(instance.getReplyCACerts());
        this.withReplyUri(instance.getReplyUri());
        this.withSubscriberAudience(instance.getSubscriberAudience());
        this.withSubscriberCACerts(instance.getSubscriberCACerts());
        this.withSubscriberUri(instance.getSubscriberUri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    SubscriptionStatusPhysicalSubscriptionFluent that = (SubscriptionStatusPhysicalSubscriptionFluent) o;
    if (!(Objects.equals(deadLetterSinkAudience, that.deadLetterSinkAudience))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSinkCACerts, that.deadLetterSinkCACerts))) {
      return false;
    }
    if (!(Objects.equals(deadLetterSinkUri, that.deadLetterSinkUri))) {
      return false;
    }
    if (!(Objects.equals(replyAudience, that.replyAudience))) {
      return false;
    }
    if (!(Objects.equals(replyCACerts, that.replyCACerts))) {
      return false;
    }
    if (!(Objects.equals(replyUri, that.replyUri))) {
      return false;
    }
    if (!(Objects.equals(subscriberAudience, that.subscriberAudience))) {
      return false;
    }
    if (!(Objects.equals(subscriberCACerts, that.subscriberCACerts))) {
      return false;
    }
    if (!(Objects.equals(subscriberUri, that.subscriberUri))) {
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
  
  public String getDeadLetterSinkAudience() {
    return this.deadLetterSinkAudience;
  }
  
  public String getDeadLetterSinkCACerts() {
    return this.deadLetterSinkCACerts;
  }
  
  public String getDeadLetterSinkUri() {
    return this.deadLetterSinkUri;
  }
  
  public String getReplyAudience() {
    return this.replyAudience;
  }
  
  public String getReplyCACerts() {
    return this.replyCACerts;
  }
  
  public String getReplyUri() {
    return this.replyUri;
  }
  
  public String getSubscriberAudience() {
    return this.subscriberAudience;
  }
  
  public String getSubscriberCACerts() {
    return this.subscriberCACerts;
  }
  
  public String getSubscriberUri() {
    return this.subscriberUri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeadLetterSinkAudience() {
    return this.deadLetterSinkAudience != null;
  }
  
  public boolean hasDeadLetterSinkCACerts() {
    return this.deadLetterSinkCACerts != null;
  }
  
  public boolean hasDeadLetterSinkUri() {
    return this.deadLetterSinkUri != null;
  }
  
  public boolean hasReplyAudience() {
    return this.replyAudience != null;
  }
  
  public boolean hasReplyCACerts() {
    return this.replyCACerts != null;
  }
  
  public boolean hasReplyUri() {
    return this.replyUri != null;
  }
  
  public boolean hasSubscriberAudience() {
    return this.subscriberAudience != null;
  }
  
  public boolean hasSubscriberCACerts() {
    return this.subscriberCACerts != null;
  }
  
  public boolean hasSubscriberUri() {
    return this.subscriberUri != null;
  }
  
  public int hashCode() {
    return Objects.hash(deadLetterSinkAudience, deadLetterSinkCACerts, deadLetterSinkUri, replyAudience, replyCACerts, replyUri, subscriberAudience, subscriberCACerts, subscriberUri, additionalProperties);
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
    if (!(deadLetterSinkAudience == null)) {
        sb.append("deadLetterSinkAudience:");
        sb.append(deadLetterSinkAudience);
        sb.append(",");
    }
    if (!(deadLetterSinkCACerts == null)) {
        sb.append("deadLetterSinkCACerts:");
        sb.append(deadLetterSinkCACerts);
        sb.append(",");
    }
    if (!(deadLetterSinkUri == null)) {
        sb.append("deadLetterSinkUri:");
        sb.append(deadLetterSinkUri);
        sb.append(",");
    }
    if (!(replyAudience == null)) {
        sb.append("replyAudience:");
        sb.append(replyAudience);
        sb.append(",");
    }
    if (!(replyCACerts == null)) {
        sb.append("replyCACerts:");
        sb.append(replyCACerts);
        sb.append(",");
    }
    if (!(replyUri == null)) {
        sb.append("replyUri:");
        sb.append(replyUri);
        sb.append(",");
    }
    if (!(subscriberAudience == null)) {
        sb.append("subscriberAudience:");
        sb.append(subscriberAudience);
        sb.append(",");
    }
    if (!(subscriberCACerts == null)) {
        sb.append("subscriberCACerts:");
        sb.append(subscriberCACerts);
        sb.append(",");
    }
    if (!(subscriberUri == null)) {
        sb.append("subscriberUri:");
        sb.append(subscriberUri);
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
  
  public A withDeadLetterSinkAudience(String deadLetterSinkAudience) {
    this.deadLetterSinkAudience = deadLetterSinkAudience;
    return (A) this;
  }
  
  public A withDeadLetterSinkCACerts(String deadLetterSinkCACerts) {
    this.deadLetterSinkCACerts = deadLetterSinkCACerts;
    return (A) this;
  }
  
  public A withDeadLetterSinkUri(String deadLetterSinkUri) {
    this.deadLetterSinkUri = deadLetterSinkUri;
    return (A) this;
  }
  
  public A withReplyAudience(String replyAudience) {
    this.replyAudience = replyAudience;
    return (A) this;
  }
  
  public A withReplyCACerts(String replyCACerts) {
    this.replyCACerts = replyCACerts;
    return (A) this;
  }
  
  public A withReplyUri(String replyUri) {
    this.replyUri = replyUri;
    return (A) this;
  }
  
  public A withSubscriberAudience(String subscriberAudience) {
    this.subscriberAudience = subscriberAudience;
    return (A) this;
  }
  
  public A withSubscriberCACerts(String subscriberCACerts) {
    this.subscriberCACerts = subscriberCACerts;
    return (A) this;
  }
  
  public A withSubscriberUri(String subscriberUri) {
    this.subscriberUri = subscriberUri;
    return (A) this;
  }
  
}