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
public class PushoverConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.PushoverConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String device;
  private String expire;
  private Boolean html;
  private HTTPConfigBuilder httpConfig;
  private String message;
  private Boolean monospace;
  private String priority;
  private String retry;
  private Boolean sendResolved;
  private String sound;
  private String title;
  private SecretKeySelector token;
  private String tokenFile;
  private String ttl;
  private String url;
  private String urlTitle;
  private SecretKeySelector userKey;
  private String userKeyFile;

  public PushoverConfigFluent() {
  }
  
  public PushoverConfigFluent(PushoverConfig instance) {
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
  
  protected void copyInstance(PushoverConfig instance) {
    instance = instance != null ? instance : new PushoverConfig();
    if (instance != null) {
        this.withDevice(instance.getDevice());
        this.withExpire(instance.getExpire());
        this.withHtml(instance.getHtml());
        this.withHttpConfig(instance.getHttpConfig());
        this.withMessage(instance.getMessage());
        this.withMonospace(instance.getMonospace());
        this.withPriority(instance.getPriority());
        this.withRetry(instance.getRetry());
        this.withSendResolved(instance.getSendResolved());
        this.withSound(instance.getSound());
        this.withTitle(instance.getTitle());
        this.withToken(instance.getToken());
        this.withTokenFile(instance.getTokenFile());
        this.withTtl(instance.getTtl());
        this.withUrl(instance.getUrl());
        this.withUrlTitle(instance.getUrlTitle());
        this.withUserKey(instance.getUserKey());
        this.withUserKeyFile(instance.getUserKeyFile());
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
    PushoverConfigFluent that = (PushoverConfigFluent) o;
    if (!(Objects.equals(device, that.device))) {
      return false;
    }
    if (!(Objects.equals(expire, that.expire))) {
      return false;
    }
    if (!(Objects.equals(html, that.html))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(monospace, that.monospace))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(retry, that.retry))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(sound, that.sound))) {
      return false;
    }
    if (!(Objects.equals(title, that.title))) {
      return false;
    }
    if (!(Objects.equals(token, that.token))) {
      return false;
    }
    if (!(Objects.equals(tokenFile, that.tokenFile))) {
      return false;
    }
    if (!(Objects.equals(ttl, that.ttl))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(urlTitle, that.urlTitle))) {
      return false;
    }
    if (!(Objects.equals(userKey, that.userKey))) {
      return false;
    }
    if (!(Objects.equals(userKeyFile, that.userKeyFile))) {
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
  
  public String getDevice() {
    return this.device;
  }
  
  public String getExpire() {
    return this.expire;
  }
  
  public Boolean getHtml() {
    return this.html;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public Boolean getMonospace() {
    return this.monospace;
  }
  
  public String getPriority() {
    return this.priority;
  }
  
  public String getRetry() {
    return this.retry;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getSound() {
    return this.sound;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public SecretKeySelector getToken() {
    return this.token;
  }
  
  public String getTokenFile() {
    return this.tokenFile;
  }
  
  public String getTtl() {
    return this.ttl;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public String getUrlTitle() {
    return this.urlTitle;
  }
  
  public SecretKeySelector getUserKey() {
    return this.userKey;
  }
  
  public String getUserKeyFile() {
    return this.userKeyFile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDevice() {
    return this.device != null;
  }
  
  public boolean hasExpire() {
    return this.expire != null;
  }
  
  public boolean hasHtml() {
    return this.html != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasMonospace() {
    return this.monospace != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasRetry() {
    return this.retry != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasSound() {
    return this.sound != null;
  }
  
  public boolean hasTitle() {
    return this.title != null;
  }
  
  public boolean hasToken() {
    return this.token != null;
  }
  
  public boolean hasTokenFile() {
    return this.tokenFile != null;
  }
  
  public boolean hasTtl() {
    return this.ttl != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasUrlTitle() {
    return this.urlTitle != null;
  }
  
  public boolean hasUserKey() {
    return this.userKey != null;
  }
  
  public boolean hasUserKeyFile() {
    return this.userKeyFile != null;
  }
  
  public int hashCode() {
    return Objects.hash(device, expire, html, httpConfig, message, monospace, priority, retry, sendResolved, sound, title, token, tokenFile, ttl, url, urlTitle, userKey, userKeyFile, additionalProperties);
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
    if (!(device == null)) {
        sb.append("device:");
        sb.append(device);
        sb.append(",");
    }
    if (!(expire == null)) {
        sb.append("expire:");
        sb.append(expire);
        sb.append(",");
    }
    if (!(html == null)) {
        sb.append("html:");
        sb.append(html);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(monospace == null)) {
        sb.append("monospace:");
        sb.append(monospace);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(retry == null)) {
        sb.append("retry:");
        sb.append(retry);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(sound == null)) {
        sb.append("sound:");
        sb.append(sound);
        sb.append(",");
    }
    if (!(title == null)) {
        sb.append("title:");
        sb.append(title);
        sb.append(",");
    }
    if (!(token == null)) {
        sb.append("token:");
        sb.append(token);
        sb.append(",");
    }
    if (!(tokenFile == null)) {
        sb.append("tokenFile:");
        sb.append(tokenFile);
        sb.append(",");
    }
    if (!(ttl == null)) {
        sb.append("ttl:");
        sb.append(ttl);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(urlTitle == null)) {
        sb.append("urlTitle:");
        sb.append(urlTitle);
        sb.append(",");
    }
    if (!(userKey == null)) {
        sb.append("userKey:");
        sb.append(userKey);
        sb.append(",");
    }
    if (!(userKeyFile == null)) {
        sb.append("userKeyFile:");
        sb.append(userKeyFile);
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
  
  public A withDevice(String device) {
    this.device = device;
    return (A) this;
  }
  
  public A withExpire(String expire) {
    this.expire = expire;
    return (A) this;
  }
  
  public A withHtml() {
    return withHtml(true);
  }
  
  public A withHtml(Boolean html) {
    this.html = html;
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
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withMonospace() {
    return withMonospace(true);
  }
  
  public A withMonospace(Boolean monospace) {
    this.monospace = monospace;
    return (A) this;
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withNewToken(String key,String name,Boolean optional) {
    return (A) this.withToken(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewUserKey(String key,String name,Boolean optional) {
    return (A) this.withUserKey(new SecretKeySelector(key, name, optional));
  }
  
  public A withPriority(String priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withRetry(String retry) {
    this.retry = retry;
    return (A) this;
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withSound(String sound) {
    this.sound = sound;
    return (A) this;
  }
  
  public A withTitle(String title) {
    this.title = title;
    return (A) this;
  }
  
  public A withToken(SecretKeySelector token) {
    this.token = token;
    return (A) this;
  }
  
  public A withTokenFile(String tokenFile) {
    this.tokenFile = tokenFile;
    return (A) this;
  }
  
  public A withTtl(String ttl) {
    this.ttl = ttl;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withUrlTitle(String urlTitle) {
    this.urlTitle = urlTitle;
    return (A) this;
  }
  
  public A withUserKey(SecretKeySelector userKey) {
    this.userKey = userKey;
    return (A) this;
  }
  
  public A withUserKeyFile(String userKeyFile) {
    this.userKeyFile = userKeyFile;
    return (A) this;
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PushoverConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
}