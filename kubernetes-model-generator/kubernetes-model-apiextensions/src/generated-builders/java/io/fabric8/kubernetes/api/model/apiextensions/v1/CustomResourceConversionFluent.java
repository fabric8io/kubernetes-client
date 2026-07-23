package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
public class CustomResourceConversionFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceConversionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String strategy;
  private WebhookConversionBuilder webhook;

  public CustomResourceConversionFluent() {
  }
  
  public CustomResourceConversionFluent(CustomResourceConversion instance) {
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
  
  public WebhookConversion buildWebhook() {
    return this.webhook != null ? this.webhook.build() : null;
  }
  
  protected void copyInstance(CustomResourceConversion instance) {
    instance = instance != null ? instance : new CustomResourceConversion();
    if (instance != null) {
        this.withStrategy(instance.getStrategy());
        this.withWebhook(instance.getWebhook());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WebhookNested<A> editOrNewWebhook() {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(new WebhookConversionBuilder().build()));
  }
  
  public WebhookNested<A> editOrNewWebhookLike(WebhookConversion item) {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(item));
  }
  
  public WebhookNested<A> editWebhook() {
    return this.withNewWebhookLike(Optional.ofNullable(this.buildWebhook()).orElse(null));
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
    CustomResourceConversionFluent that = (CustomResourceConversionFluent) o;
    if (!(Objects.equals(strategy, that.strategy))) {
      return false;
    }
    if (!(Objects.equals(webhook, that.webhook))) {
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
  
  public String getStrategy() {
    return this.strategy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public boolean hasWebhook() {
    return this.webhook != null;
  }
  
  public int hashCode() {
    return Objects.hash(strategy, webhook, additionalProperties);
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
    if (!(strategy == null)) {
        sb.append("strategy:");
        sb.append(strategy);
        sb.append(",");
    }
    if (!(webhook == null)) {
        sb.append("webhook:");
        sb.append(webhook);
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
  
  public WebhookNested<A> withNewWebhook() {
    return new WebhookNested(null);
  }
  
  public WebhookNested<A> withNewWebhookLike(WebhookConversion item) {
    return new WebhookNested(item);
  }
  
  public A withStrategy(String strategy) {
    this.strategy = strategy;
    return (A) this;
  }
  
  public A withWebhook(WebhookConversion webhook) {
    this._visitables.remove("webhook");
    if (webhook != null) {
        this.webhook = new WebhookConversionBuilder(webhook);
        this._visitables.get("webhook").add(this.webhook);
    } else {
        this.webhook = null;
        this._visitables.get("webhook").remove(this.webhook);
    }
    return (A) this;
  }
  public class WebhookNested<N> extends WebhookConversionFluent<WebhookNested<N>> implements Nested<N>{
  
    WebhookConversionBuilder builder;
  
    WebhookNested(WebhookConversion item) {
      this.builder = new WebhookConversionBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceConversionFluent.this.withWebhook(builder.build());
    }
    
    public N endWebhook() {
      return and();
    }
    
  }
}