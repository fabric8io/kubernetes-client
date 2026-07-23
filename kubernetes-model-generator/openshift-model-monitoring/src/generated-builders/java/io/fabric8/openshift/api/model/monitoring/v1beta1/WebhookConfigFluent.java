package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class WebhookConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.WebhookConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPConfigBuilder httpConfig;
  private Integer maxAlerts;
  private Boolean sendResolved;
  private String timeout;
  private String url;
  private SecretKeySelectorBuilder urlSecret;

  public WebhookConfigFluent() {
  }
  
  public WebhookConfigFluent(WebhookConfig instance) {
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
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public SecretKeySelector buildUrlSecret() {
    return this.urlSecret != null ? this.urlSecret.build() : null;
  }
  
  protected void copyInstance(WebhookConfig instance) {
    instance = instance != null ? instance : new WebhookConfig();
    if (instance != null) {
        this.withHttpConfig(instance.getHttpConfig());
        this.withMaxAlerts(instance.getMaxAlerts());
        this.withSendResolved(instance.getSendResolved());
        this.withTimeout(instance.getTimeout());
        this.withUrl(instance.getUrl());
        this.withUrlSecret(instance.getUrlSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfig item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
  }
  
  public UrlSecretNested<A> editOrNewUrlSecret() {
    return this.withNewUrlSecretLike(Optional.ofNullable(this.buildUrlSecret()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public UrlSecretNested<A> editOrNewUrlSecretLike(SecretKeySelector item) {
    return this.withNewUrlSecretLike(Optional.ofNullable(this.buildUrlSecret()).orElse(item));
  }
  
  public UrlSecretNested<A> editUrlSecret() {
    return this.withNewUrlSecretLike(Optional.ofNullable(this.buildUrlSecret()).orElse(null));
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
    WebhookConfigFluent that = (WebhookConfigFluent) o;
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(maxAlerts, that.maxAlerts))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(urlSecret, that.urlSecret))) {
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
  
  public Integer getMaxAlerts() {
    return this.maxAlerts;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasMaxAlerts() {
    return this.maxAlerts != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasUrlSecret() {
    return this.urlSecret != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpConfig, maxAlerts, sendResolved, timeout, url, urlSecret, additionalProperties);
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
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(maxAlerts == null)) {
        sb.append("maxAlerts:");
        sb.append(maxAlerts);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(urlSecret == null)) {
        sb.append("urlSecret:");
        sb.append(urlSecret);
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
  
  public A withHttpConfig(HTTPConfig httpConfig) {
    this._visitables.remove("httpConfig");
    if (httpConfig != null) {
        this.httpConfig = new HTTPConfigBuilder(httpConfig);
        this._visitables.get("httpConfig").add(this.httpConfig);
    } else {
        this.httpConfig = null;
        this._visitables.get("httpConfig").remove(this.httpConfig);
    }
    return (A) this;
  }
  
  public A withMaxAlerts(Integer maxAlerts) {
    this.maxAlerts = maxAlerts;
    return (A) this;
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public UrlSecretNested<A> withNewUrlSecret() {
    return new UrlSecretNested(null);
  }
  
  public A withNewUrlSecret(String key,String name) {
    return (A) this.withUrlSecret(new SecretKeySelector(key, name));
  }
  
  public UrlSecretNested<A> withNewUrlSecretLike(SecretKeySelector item) {
    return new UrlSecretNested(item);
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withUrlSecret(SecretKeySelector urlSecret) {
    this._visitables.remove("urlSecret");
    if (urlSecret != null) {
        this.urlSecret = new SecretKeySelectorBuilder(urlSecret);
        this._visitables.get("urlSecret").add(this.urlSecret);
    } else {
        this.urlSecret = null;
        this._visitables.get("urlSecret").remove(this.urlSecret);
    }
    return (A) this;
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
  public class UrlSecretNested<N> extends SecretKeySelectorFluent<UrlSecretNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    UrlSecretNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) WebhookConfigFluent.this.withUrlSecret(builder.build());
    }
    
    public N endUrlSecret() {
      return and();
    }
    
  }
}