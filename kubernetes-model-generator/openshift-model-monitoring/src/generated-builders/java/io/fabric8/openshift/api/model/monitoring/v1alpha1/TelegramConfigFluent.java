package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
import java.lang.Long;
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
public class TelegramConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.TelegramConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiURL;
  private SecretKeySelector botToken;
  private String botTokenFile;
  private Long chatID;
  private Boolean disableNotifications;
  private HTTPConfigBuilder httpConfig;
  private String message;
  private Long messageThreadID;
  private String parseMode;
  private Boolean sendResolved;

  public TelegramConfigFluent() {
  }
  
  public TelegramConfigFluent(TelegramConfig instance) {
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
  
  protected void copyInstance(TelegramConfig instance) {
    instance = instance != null ? instance : new TelegramConfig();
    if (instance != null) {
        this.withApiURL(instance.getApiURL());
        this.withBotToken(instance.getBotToken());
        this.withBotTokenFile(instance.getBotTokenFile());
        this.withChatID(instance.getChatID());
        this.withDisableNotifications(instance.getDisableNotifications());
        this.withHttpConfig(instance.getHttpConfig());
        this.withMessage(instance.getMessage());
        this.withMessageThreadID(instance.getMessageThreadID());
        this.withParseMode(instance.getParseMode());
        this.withSendResolved(instance.getSendResolved());
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
    TelegramConfigFluent that = (TelegramConfigFluent) o;
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(botToken, that.botToken))) {
      return false;
    }
    if (!(Objects.equals(botTokenFile, that.botTokenFile))) {
      return false;
    }
    if (!(Objects.equals(chatID, that.chatID))) {
      return false;
    }
    if (!(Objects.equals(disableNotifications, that.disableNotifications))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(messageThreadID, that.messageThreadID))) {
      return false;
    }
    if (!(Objects.equals(parseMode, that.parseMode))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
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
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public SecretKeySelector getBotToken() {
    return this.botToken;
  }
  
  public String getBotTokenFile() {
    return this.botTokenFile;
  }
  
  public Long getChatID() {
    return this.chatID;
  }
  
  public Boolean getDisableNotifications() {
    return this.disableNotifications;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public Long getMessageThreadID() {
    return this.messageThreadID;
  }
  
  public String getParseMode() {
    return this.parseMode;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasBotToken() {
    return this.botToken != null;
  }
  
  public boolean hasBotTokenFile() {
    return this.botTokenFile != null;
  }
  
  public boolean hasChatID() {
    return this.chatID != null;
  }
  
  public boolean hasDisableNotifications() {
    return this.disableNotifications != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasMessageThreadID() {
    return this.messageThreadID != null;
  }
  
  public boolean hasParseMode() {
    return this.parseMode != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiURL, botToken, botTokenFile, chatID, disableNotifications, httpConfig, message, messageThreadID, parseMode, sendResolved, additionalProperties);
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
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(botToken == null)) {
        sb.append("botToken:");
        sb.append(botToken);
        sb.append(",");
    }
    if (!(botTokenFile == null)) {
        sb.append("botTokenFile:");
        sb.append(botTokenFile);
        sb.append(",");
    }
    if (!(chatID == null)) {
        sb.append("chatID:");
        sb.append(chatID);
        sb.append(",");
    }
    if (!(disableNotifications == null)) {
        sb.append("disableNotifications:");
        sb.append(disableNotifications);
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
    if (!(messageThreadID == null)) {
        sb.append("messageThreadID:");
        sb.append(messageThreadID);
        sb.append(",");
    }
    if (!(parseMode == null)) {
        sb.append("parseMode:");
        sb.append(parseMode);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
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
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withBotToken(SecretKeySelector botToken) {
    this.botToken = botToken;
    return (A) this;
  }
  
  public A withBotTokenFile(String botTokenFile) {
    this.botTokenFile = botTokenFile;
    return (A) this;
  }
  
  public A withChatID(Long chatID) {
    this.chatID = chatID;
    return (A) this;
  }
  
  public A withDisableNotifications() {
    return withDisableNotifications(true);
  }
  
  public A withDisableNotifications(Boolean disableNotifications) {
    this.disableNotifications = disableNotifications;
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
  
  public A withMessageThreadID(Long messageThreadID) {
    this.messageThreadID = messageThreadID;
    return (A) this;
  }
  
  public A withNewBotToken(String key,String name,Boolean optional) {
    return (A) this.withBotToken(new SecretKeySelector(key, name, optional));
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withParseMode(String parseMode) {
    this.parseMode = parseMode;
    return (A) this;
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) TelegramConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
}