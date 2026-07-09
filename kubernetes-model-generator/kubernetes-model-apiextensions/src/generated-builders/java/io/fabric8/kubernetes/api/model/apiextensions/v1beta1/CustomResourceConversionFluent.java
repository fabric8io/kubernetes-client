package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CustomResourceConversionFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceConversionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> conversionReviewVersions = new ArrayList<String>();
  private String strategy;
  private WebhookClientConfigBuilder webhookClientConfig;

  public CustomResourceConversionFluent() {
  }
  
  public CustomResourceConversionFluent(CustomResourceConversion instance) {
    this.copyInstance(instance);
  }

  public A addAllToConversionReviewVersions(Collection<String> items) {
    if (this.conversionReviewVersions == null) {
      this.conversionReviewVersions = new ArrayList();
    }
    for (String item : items) {
      this.conversionReviewVersions.add(item);
    }
    return (A) this;
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
  
  public A addToConversionReviewVersions(String... items) {
    if (this.conversionReviewVersions == null) {
      this.conversionReviewVersions = new ArrayList();
    }
    for (String item : items) {
      this.conversionReviewVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToConversionReviewVersions(int index,String item) {
    if (this.conversionReviewVersions == null) {
      this.conversionReviewVersions = new ArrayList();
    }
    this.conversionReviewVersions.add(index, item);
    return (A) this;
  }
  
  public WebhookClientConfig buildWebhookClientConfig() {
    return this.webhookClientConfig != null ? this.webhookClientConfig.build() : null;
  }
  
  protected void copyInstance(CustomResourceConversion instance) {
    instance = instance != null ? instance : new CustomResourceConversion();
    if (instance != null) {
        this.withConversionReviewVersions(instance.getConversionReviewVersions());
        this.withStrategy(instance.getStrategy());
        this.withWebhookClientConfig(instance.getWebhookClientConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WebhookClientConfigNested<A> editOrNewWebhookClientConfig() {
    return this.withNewWebhookClientConfigLike(Optional.ofNullable(this.buildWebhookClientConfig()).orElse(new WebhookClientConfigBuilder().build()));
  }
  
  public WebhookClientConfigNested<A> editOrNewWebhookClientConfigLike(WebhookClientConfig item) {
    return this.withNewWebhookClientConfigLike(Optional.ofNullable(this.buildWebhookClientConfig()).orElse(item));
  }
  
  public WebhookClientConfigNested<A> editWebhookClientConfig() {
    return this.withNewWebhookClientConfigLike(Optional.ofNullable(this.buildWebhookClientConfig()).orElse(null));
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
    if (!(Objects.equals(conversionReviewVersions, that.conversionReviewVersions))) {
      return false;
    }
    if (!(Objects.equals(strategy, that.strategy))) {
      return false;
    }
    if (!(Objects.equals(webhookClientConfig, that.webhookClientConfig))) {
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
  
  public String getConversionReviewVersion(int index) {
    return this.conversionReviewVersions.get(index);
  }
  
  public List<String> getConversionReviewVersions() {
    return this.conversionReviewVersions;
  }
  
  public String getFirstConversionReviewVersion() {
    return this.conversionReviewVersions.get(0);
  }
  
  public String getLastConversionReviewVersion() {
    return this.conversionReviewVersions.get(conversionReviewVersions.size() - 1);
  }
  
  public String getMatchingConversionReviewVersion(Predicate<String> predicate) {
      for (String item : conversionReviewVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getStrategy() {
    return this.strategy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConversionReviewVersions() {
    return this.conversionReviewVersions != null && !(this.conversionReviewVersions.isEmpty());
  }
  
  public boolean hasMatchingConversionReviewVersion(Predicate<String> predicate) {
      for (String item : conversionReviewVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStrategy() {
    return this.strategy != null;
  }
  
  public boolean hasWebhookClientConfig() {
    return this.webhookClientConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(conversionReviewVersions, strategy, webhookClientConfig, additionalProperties);
  }
  
  public A removeAllFromConversionReviewVersions(Collection<String> items) {
    if (this.conversionReviewVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.conversionReviewVersions.remove(item);
    }
    return (A) this;
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
  
  public A removeFromConversionReviewVersions(String... items) {
    if (this.conversionReviewVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.conversionReviewVersions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConversionReviewVersions(int index,String item) {
    if (this.conversionReviewVersions == null) {
      this.conversionReviewVersions = new ArrayList();
    }
    this.conversionReviewVersions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conversionReviewVersions == null) && !(conversionReviewVersions.isEmpty())) {
        sb.append("conversionReviewVersions:");
        sb.append(conversionReviewVersions);
        sb.append(",");
    }
    if (!(strategy == null)) {
        sb.append("strategy:");
        sb.append(strategy);
        sb.append(",");
    }
    if (!(webhookClientConfig == null)) {
        sb.append("webhookClientConfig:");
        sb.append(webhookClientConfig);
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
  
  public A withConversionReviewVersions(List<String> conversionReviewVersions) {
    if (conversionReviewVersions != null) {
        this.conversionReviewVersions = new ArrayList();
        for (String item : conversionReviewVersions) {
          this.addToConversionReviewVersions(item);
        }
    } else {
      this.conversionReviewVersions = null;
    }
    return (A) this;
  }
  
  public A withConversionReviewVersions(String... conversionReviewVersions) {
    if (this.conversionReviewVersions != null) {
        this.conversionReviewVersions.clear();
        _visitables.remove("conversionReviewVersions");
    }
    if (conversionReviewVersions != null) {
      for (String item : conversionReviewVersions) {
        this.addToConversionReviewVersions(item);
      }
    }
    return (A) this;
  }
  
  public WebhookClientConfigNested<A> withNewWebhookClientConfig() {
    return new WebhookClientConfigNested(null);
  }
  
  public WebhookClientConfigNested<A> withNewWebhookClientConfigLike(WebhookClientConfig item) {
    return new WebhookClientConfigNested(item);
  }
  
  public A withStrategy(String strategy) {
    this.strategy = strategy;
    return (A) this;
  }
  
  public A withWebhookClientConfig(WebhookClientConfig webhookClientConfig) {
    this._visitables.remove("webhookClientConfig");
    if (webhookClientConfig != null) {
        this.webhookClientConfig = new WebhookClientConfigBuilder(webhookClientConfig);
        this._visitables.get("webhookClientConfig").add(this.webhookClientConfig);
    } else {
        this.webhookClientConfig = null;
        this._visitables.get("webhookClientConfig").remove(this.webhookClientConfig);
    }
    return (A) this;
  }
  public class WebhookClientConfigNested<N> extends WebhookClientConfigFluent<WebhookClientConfigNested<N>> implements Nested<N>{
  
    WebhookClientConfigBuilder builder;
  
    WebhookClientConfigNested(WebhookClientConfig item) {
      this.builder = new WebhookClientConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceConversionFluent.this.withWebhookClientConfig(builder.build());
    }
    
    public N endWebhookClientConfig() {
      return and();
    }
    
  }
}