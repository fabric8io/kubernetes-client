package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
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
public class MSTeamsV2ConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.MSTeamsV2ConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPConfigBuilder httpConfig;
  private Boolean sendResolved;
  private String text;
  private String title;
  private SecretKeySelector webhookURL;

  public MSTeamsV2ConfigFluent() {
  }
  
  public MSTeamsV2ConfigFluent(MSTeamsV2Config instance) {
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
  
  protected void copyInstance(MSTeamsV2Config instance) {
    instance = instance != null ? instance : new MSTeamsV2Config();
    if (instance != null) {
        this.withHttpConfig(instance.getHttpConfig());
        this.withSendResolved(instance.getSendResolved());
        this.withText(instance.getText());
        this.withTitle(instance.getTitle());
        this.withWebhookURL(instance.getWebhookURL());
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
    MSTeamsV2ConfigFluent that = (MSTeamsV2ConfigFluent) o;
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
      return false;
    }
    if (!(Objects.equals(title, that.title))) {
      return false;
    }
    if (!(Objects.equals(webhookURL, that.webhookURL))) {
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
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getText() {
    return this.text;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public SecretKeySelector getWebhookURL() {
    return this.webhookURL;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public boolean hasTitle() {
    return this.title != null;
  }
  
  public boolean hasWebhookURL() {
    return this.webhookURL != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpConfig, sendResolved, text, title, webhookURL, additionalProperties);
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
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
        sb.append(",");
    }
    if (!(title == null)) {
        sb.append("title:");
        sb.append(title);
        sb.append(",");
    }
    if (!(webhookURL == null)) {
        sb.append("webhookURL:");
        sb.append(webhookURL);
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
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withNewWebhookURL(String key,String name,Boolean optional) {
    return (A) this.withWebhookURL(new SecretKeySelector(key, name, optional));
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  
  public A withTitle(String title) {
    this.title = title;
    return (A) this;
  }
  
  public A withWebhookURL(SecretKeySelector webhookURL) {
    this.webhookURL = webhookURL;
    return (A) this;
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) MSTeamsV2ConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
}