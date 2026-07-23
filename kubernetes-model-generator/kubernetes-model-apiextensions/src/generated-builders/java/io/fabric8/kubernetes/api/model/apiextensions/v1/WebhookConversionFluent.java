package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
public class WebhookConversionFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.WebhookConversionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WebhookClientConfigBuilder clientConfig;
  private List<String> conversionReviewVersions = new ArrayList<String>();

  public WebhookConversionFluent() {
  }
  
  public WebhookConversionFluent(WebhookConversion instance) {
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
  
  public WebhookClientConfig buildClientConfig() {
    return this.clientConfig != null ? this.clientConfig.build() : null;
  }
  
  protected void copyInstance(WebhookConversion instance) {
    instance = instance != null ? instance : new WebhookConversion();
    if (instance != null) {
        this.withClientConfig(instance.getClientConfig());
        this.withConversionReviewVersions(instance.getConversionReviewVersions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientConfigNested<A> editClientConfig() {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(null));
  }
  
  public ClientConfigNested<A> editOrNewClientConfig() {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(new WebhookClientConfigBuilder().build()));
  }
  
  public ClientConfigNested<A> editOrNewClientConfigLike(WebhookClientConfig item) {
    return this.withNewClientConfigLike(Optional.ofNullable(this.buildClientConfig()).orElse(item));
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
    WebhookConversionFluent that = (WebhookConversionFluent) o;
    if (!(Objects.equals(clientConfig, that.clientConfig))) {
      return false;
    }
    if (!(Objects.equals(conversionReviewVersions, that.conversionReviewVersions))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientConfig() {
    return this.clientConfig != null;
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
  
  public int hashCode() {
    return Objects.hash(clientConfig, conversionReviewVersions, additionalProperties);
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
    if (!(clientConfig == null)) {
        sb.append("clientConfig:");
        sb.append(clientConfig);
        sb.append(",");
    }
    if (!(conversionReviewVersions == null) && !(conversionReviewVersions.isEmpty())) {
        sb.append("conversionReviewVersions:");
        sb.append(conversionReviewVersions);
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
  
  public A withClientConfig(WebhookClientConfig clientConfig) {
    this._visitables.remove("clientConfig");
    if (clientConfig != null) {
        this.clientConfig = new WebhookClientConfigBuilder(clientConfig);
        this._visitables.get("clientConfig").add(this.clientConfig);
    } else {
        this.clientConfig = null;
        this._visitables.get("clientConfig").remove(this.clientConfig);
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
  
  public ClientConfigNested<A> withNewClientConfig() {
    return new ClientConfigNested(null);
  }
  
  public ClientConfigNested<A> withNewClientConfigLike(WebhookClientConfig item) {
    return new ClientConfigNested(item);
  }
  public class ClientConfigNested<N> extends WebhookClientConfigFluent<ClientConfigNested<N>> implements Nested<N>{
  
    WebhookClientConfigBuilder builder;
  
    ClientConfigNested(WebhookClientConfig item) {
      this.builder = new WebhookClientConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookConversionFluent.this.withClientConfig(builder.build());
    }
    
    public N endClientConfig() {
      return and();
    }
    
  }
}