package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class WeChatConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.WeChatConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String agentID;
  private SecretKeySelectorBuilder apiSecret;
  private String apiURL;
  private String corpID;
  private HTTPConfigBuilder httpConfig;
  private String message;
  private String messageType;
  private Boolean sendResolved;
  private String toParty;
  private String toTag;
  private String toUser;

  public WeChatConfigFluent() {
  }
  
  public WeChatConfigFluent(WeChatConfig instance) {
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
  
  public SecretKeySelector buildApiSecret() {
    return this.apiSecret != null ? this.apiSecret.build() : null;
  }
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  protected void copyInstance(WeChatConfig instance) {
    instance = instance != null ? instance : new WeChatConfig();
    if (instance != null) {
        this.withAgentID(instance.getAgentID());
        this.withApiSecret(instance.getApiSecret());
        this.withApiURL(instance.getApiURL());
        this.withCorpID(instance.getCorpID());
        this.withHttpConfig(instance.getHttpConfig());
        this.withMessage(instance.getMessage());
        this.withMessageType(instance.getMessageType());
        this.withSendResolved(instance.getSendResolved());
        this.withToParty(instance.getToParty());
        this.withToTag(instance.getToTag());
        this.withToUser(instance.getToUser());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApiSecretNested<A> editApiSecret() {
    return this.withNewApiSecretLike(Optional.ofNullable(this.buildApiSecret()).orElse(null));
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public ApiSecretNested<A> editOrNewApiSecret() {
    return this.withNewApiSecretLike(Optional.ofNullable(this.buildApiSecret()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ApiSecretNested<A> editOrNewApiSecretLike(SecretKeySelector item) {
    return this.withNewApiSecretLike(Optional.ofNullable(this.buildApiSecret()).orElse(item));
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
    WeChatConfigFluent that = (WeChatConfigFluent) o;
    if (!(Objects.equals(agentID, that.agentID))) {
      return false;
    }
    if (!(Objects.equals(apiSecret, that.apiSecret))) {
      return false;
    }
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(corpID, that.corpID))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(messageType, that.messageType))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(toParty, that.toParty))) {
      return false;
    }
    if (!(Objects.equals(toTag, that.toTag))) {
      return false;
    }
    if (!(Objects.equals(toUser, that.toUser))) {
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
  
  public String getAgentID() {
    return this.agentID;
  }
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public String getCorpID() {
    return this.corpID;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getMessageType() {
    return this.messageType;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getToParty() {
    return this.toParty;
  }
  
  public String getToTag() {
    return this.toTag;
  }
  
  public String getToUser() {
    return this.toUser;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAgentID() {
    return this.agentID != null;
  }
  
  public boolean hasApiSecret() {
    return this.apiSecret != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasCorpID() {
    return this.corpID != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasMessageType() {
    return this.messageType != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasToParty() {
    return this.toParty != null;
  }
  
  public boolean hasToTag() {
    return this.toTag != null;
  }
  
  public boolean hasToUser() {
    return this.toUser != null;
  }
  
  public int hashCode() {
    return Objects.hash(agentID, apiSecret, apiURL, corpID, httpConfig, message, messageType, sendResolved, toParty, toTag, toUser, additionalProperties);
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
    if (!(agentID == null)) {
        sb.append("agentID:");
        sb.append(agentID);
        sb.append(",");
    }
    if (!(apiSecret == null)) {
        sb.append("apiSecret:");
        sb.append(apiSecret);
        sb.append(",");
    }
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(corpID == null)) {
        sb.append("corpID:");
        sb.append(corpID);
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
    if (!(messageType == null)) {
        sb.append("messageType:");
        sb.append(messageType);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(toParty == null)) {
        sb.append("toParty:");
        sb.append(toParty);
        sb.append(",");
    }
    if (!(toTag == null)) {
        sb.append("toTag:");
        sb.append(toTag);
        sb.append(",");
    }
    if (!(toUser == null)) {
        sb.append("toUser:");
        sb.append(toUser);
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
  
  public A withAgentID(String agentID) {
    this.agentID = agentID;
    return (A) this;
  }
  
  public A withApiSecret(SecretKeySelector apiSecret) {
    this._visitables.remove("apiSecret");
    if (apiSecret != null) {
        this.apiSecret = new SecretKeySelectorBuilder(apiSecret);
        this._visitables.get("apiSecret").add(this.apiSecret);
    } else {
        this.apiSecret = null;
        this._visitables.get("apiSecret").remove(this.apiSecret);
    }
    return (A) this;
  }
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withCorpID(String corpID) {
    this.corpID = corpID;
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
  
  public A withMessageType(String messageType) {
    this.messageType = messageType;
    return (A) this;
  }
  
  public ApiSecretNested<A> withNewApiSecret() {
    return new ApiSecretNested(null);
  }
  
  public A withNewApiSecret(String key,String name) {
    return (A) this.withApiSecret(new SecretKeySelector(key, name));
  }
  
  public ApiSecretNested<A> withNewApiSecretLike(SecretKeySelector item) {
    return new ApiSecretNested(item);
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withToParty(String toParty) {
    this.toParty = toParty;
    return (A) this;
  }
  
  public A withToTag(String toTag) {
    this.toTag = toTag;
    return (A) this;
  }
  
  public A withToUser(String toUser) {
    this.toUser = toUser;
    return (A) this;
  }
  public class ApiSecretNested<N> extends SecretKeySelectorFluent<ApiSecretNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ApiSecretNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) WeChatConfigFluent.this.withApiSecret(builder.build());
    }
    
    public N endApiSecret() {
      return and();
    }
    
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) WeChatConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
}