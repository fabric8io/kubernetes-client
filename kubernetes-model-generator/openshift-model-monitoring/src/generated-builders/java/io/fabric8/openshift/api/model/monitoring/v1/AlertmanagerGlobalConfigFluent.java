package io.fabric8.openshift.api.model.monitoring.v1;

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
public class AlertmanagerGlobalConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerGlobalConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPConfigWithProxyBuilder httpConfig;
  private GlobalJiraConfigBuilder jira;
  private GlobalMattermostConfigBuilder mattermost;
  private SecretKeySelector opsGenieApiKey;
  private SecretKeySelector opsGenieApiUrl;
  private String pagerdutyUrl;
  private String resolveTimeout;
  private GlobalRocketChatConfigBuilder rocketChat;
  private SecretKeySelector slackApiUrl;
  private GlobalSMTPConfigBuilder smtp;
  private GlobalTelegramConfigBuilder telegram;
  private GlobalVictorOpsConfigBuilder victorops;
  private GlobalWebexConfigBuilder webex;
  private GlobalWeChatConfigBuilder wechat;

  public AlertmanagerGlobalConfigFluent() {
  }
  
  public AlertmanagerGlobalConfigFluent(AlertmanagerGlobalConfig instance) {
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
  
  public HTTPConfigWithProxy buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public GlobalJiraConfig buildJira() {
    return this.jira != null ? this.jira.build() : null;
  }
  
  public GlobalMattermostConfig buildMattermost() {
    return this.mattermost != null ? this.mattermost.build() : null;
  }
  
  public GlobalRocketChatConfig buildRocketChat() {
    return this.rocketChat != null ? this.rocketChat.build() : null;
  }
  
  public GlobalSMTPConfig buildSmtp() {
    return this.smtp != null ? this.smtp.build() : null;
  }
  
  public GlobalTelegramConfig buildTelegram() {
    return this.telegram != null ? this.telegram.build() : null;
  }
  
  public GlobalVictorOpsConfig buildVictorops() {
    return this.victorops != null ? this.victorops.build() : null;
  }
  
  public GlobalWebexConfig buildWebex() {
    return this.webex != null ? this.webex.build() : null;
  }
  
  public GlobalWeChatConfig buildWechat() {
    return this.wechat != null ? this.wechat.build() : null;
  }
  
  protected void copyInstance(AlertmanagerGlobalConfig instance) {
    instance = instance != null ? instance : new AlertmanagerGlobalConfig();
    if (instance != null) {
        this.withHttpConfig(instance.getHttpConfig());
        this.withJira(instance.getJira());
        this.withMattermost(instance.getMattermost());
        this.withOpsGenieApiKey(instance.getOpsGenieApiKey());
        this.withOpsGenieApiUrl(instance.getOpsGenieApiUrl());
        this.withPagerdutyUrl(instance.getPagerdutyUrl());
        this.withResolveTimeout(instance.getResolveTimeout());
        this.withRocketChat(instance.getRocketChat());
        this.withSlackApiUrl(instance.getSlackApiUrl());
        this.withSmtp(instance.getSmtp());
        this.withTelegram(instance.getTelegram());
        this.withVictorops(instance.getVictorops());
        this.withWebex(instance.getWebex());
        this.withWechat(instance.getWechat());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public JiraNested<A> editJira() {
    return this.withNewJiraLike(Optional.ofNullable(this.buildJira()).orElse(null));
  }
  
  public MattermostNested<A> editMattermost() {
    return this.withNewMattermostLike(Optional.ofNullable(this.buildMattermost()).orElse(null));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigWithProxyBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfigWithProxy item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
  }
  
  public JiraNested<A> editOrNewJira() {
    return this.withNewJiraLike(Optional.ofNullable(this.buildJira()).orElse(new GlobalJiraConfigBuilder().build()));
  }
  
  public JiraNested<A> editOrNewJiraLike(GlobalJiraConfig item) {
    return this.withNewJiraLike(Optional.ofNullable(this.buildJira()).orElse(item));
  }
  
  public MattermostNested<A> editOrNewMattermost() {
    return this.withNewMattermostLike(Optional.ofNullable(this.buildMattermost()).orElse(new GlobalMattermostConfigBuilder().build()));
  }
  
  public MattermostNested<A> editOrNewMattermostLike(GlobalMattermostConfig item) {
    return this.withNewMattermostLike(Optional.ofNullable(this.buildMattermost()).orElse(item));
  }
  
  public RocketChatNested<A> editOrNewRocketChat() {
    return this.withNewRocketChatLike(Optional.ofNullable(this.buildRocketChat()).orElse(new GlobalRocketChatConfigBuilder().build()));
  }
  
  public RocketChatNested<A> editOrNewRocketChatLike(GlobalRocketChatConfig item) {
    return this.withNewRocketChatLike(Optional.ofNullable(this.buildRocketChat()).orElse(item));
  }
  
  public SmtpNested<A> editOrNewSmtp() {
    return this.withNewSmtpLike(Optional.ofNullable(this.buildSmtp()).orElse(new GlobalSMTPConfigBuilder().build()));
  }
  
  public SmtpNested<A> editOrNewSmtpLike(GlobalSMTPConfig item) {
    return this.withNewSmtpLike(Optional.ofNullable(this.buildSmtp()).orElse(item));
  }
  
  public TelegramNested<A> editOrNewTelegram() {
    return this.withNewTelegramLike(Optional.ofNullable(this.buildTelegram()).orElse(new GlobalTelegramConfigBuilder().build()));
  }
  
  public TelegramNested<A> editOrNewTelegramLike(GlobalTelegramConfig item) {
    return this.withNewTelegramLike(Optional.ofNullable(this.buildTelegram()).orElse(item));
  }
  
  public VictoropsNested<A> editOrNewVictorops() {
    return this.withNewVictoropsLike(Optional.ofNullable(this.buildVictorops()).orElse(new GlobalVictorOpsConfigBuilder().build()));
  }
  
  public VictoropsNested<A> editOrNewVictoropsLike(GlobalVictorOpsConfig item) {
    return this.withNewVictoropsLike(Optional.ofNullable(this.buildVictorops()).orElse(item));
  }
  
  public WebexNested<A> editOrNewWebex() {
    return this.withNewWebexLike(Optional.ofNullable(this.buildWebex()).orElse(new GlobalWebexConfigBuilder().build()));
  }
  
  public WebexNested<A> editOrNewWebexLike(GlobalWebexConfig item) {
    return this.withNewWebexLike(Optional.ofNullable(this.buildWebex()).orElse(item));
  }
  
  public WechatNested<A> editOrNewWechat() {
    return this.withNewWechatLike(Optional.ofNullable(this.buildWechat()).orElse(new GlobalWeChatConfigBuilder().build()));
  }
  
  public WechatNested<A> editOrNewWechatLike(GlobalWeChatConfig item) {
    return this.withNewWechatLike(Optional.ofNullable(this.buildWechat()).orElse(item));
  }
  
  public RocketChatNested<A> editRocketChat() {
    return this.withNewRocketChatLike(Optional.ofNullable(this.buildRocketChat()).orElse(null));
  }
  
  public SmtpNested<A> editSmtp() {
    return this.withNewSmtpLike(Optional.ofNullable(this.buildSmtp()).orElse(null));
  }
  
  public TelegramNested<A> editTelegram() {
    return this.withNewTelegramLike(Optional.ofNullable(this.buildTelegram()).orElse(null));
  }
  
  public VictoropsNested<A> editVictorops() {
    return this.withNewVictoropsLike(Optional.ofNullable(this.buildVictorops()).orElse(null));
  }
  
  public WebexNested<A> editWebex() {
    return this.withNewWebexLike(Optional.ofNullable(this.buildWebex()).orElse(null));
  }
  
  public WechatNested<A> editWechat() {
    return this.withNewWechatLike(Optional.ofNullable(this.buildWechat()).orElse(null));
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
    AlertmanagerGlobalConfigFluent that = (AlertmanagerGlobalConfigFluent) o;
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(jira, that.jira))) {
      return false;
    }
    if (!(Objects.equals(mattermost, that.mattermost))) {
      return false;
    }
    if (!(Objects.equals(opsGenieApiKey, that.opsGenieApiKey))) {
      return false;
    }
    if (!(Objects.equals(opsGenieApiUrl, that.opsGenieApiUrl))) {
      return false;
    }
    if (!(Objects.equals(pagerdutyUrl, that.pagerdutyUrl))) {
      return false;
    }
    if (!(Objects.equals(resolveTimeout, that.resolveTimeout))) {
      return false;
    }
    if (!(Objects.equals(rocketChat, that.rocketChat))) {
      return false;
    }
    if (!(Objects.equals(slackApiUrl, that.slackApiUrl))) {
      return false;
    }
    if (!(Objects.equals(smtp, that.smtp))) {
      return false;
    }
    if (!(Objects.equals(telegram, that.telegram))) {
      return false;
    }
    if (!(Objects.equals(victorops, that.victorops))) {
      return false;
    }
    if (!(Objects.equals(webex, that.webex))) {
      return false;
    }
    if (!(Objects.equals(wechat, that.wechat))) {
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
  
  public SecretKeySelector getOpsGenieApiKey() {
    return this.opsGenieApiKey;
  }
  
  public SecretKeySelector getOpsGenieApiUrl() {
    return this.opsGenieApiUrl;
  }
  
  public String getPagerdutyUrl() {
    return this.pagerdutyUrl;
  }
  
  public String getResolveTimeout() {
    return this.resolveTimeout;
  }
  
  public SecretKeySelector getSlackApiUrl() {
    return this.slackApiUrl;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasJira() {
    return this.jira != null;
  }
  
  public boolean hasMattermost() {
    return this.mattermost != null;
  }
  
  public boolean hasOpsGenieApiKey() {
    return this.opsGenieApiKey != null;
  }
  
  public boolean hasOpsGenieApiUrl() {
    return this.opsGenieApiUrl != null;
  }
  
  public boolean hasPagerdutyUrl() {
    return this.pagerdutyUrl != null;
  }
  
  public boolean hasResolveTimeout() {
    return this.resolveTimeout != null;
  }
  
  public boolean hasRocketChat() {
    return this.rocketChat != null;
  }
  
  public boolean hasSlackApiUrl() {
    return this.slackApiUrl != null;
  }
  
  public boolean hasSmtp() {
    return this.smtp != null;
  }
  
  public boolean hasTelegram() {
    return this.telegram != null;
  }
  
  public boolean hasVictorops() {
    return this.victorops != null;
  }
  
  public boolean hasWebex() {
    return this.webex != null;
  }
  
  public boolean hasWechat() {
    return this.wechat != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpConfig, jira, mattermost, opsGenieApiKey, opsGenieApiUrl, pagerdutyUrl, resolveTimeout, rocketChat, slackApiUrl, smtp, telegram, victorops, webex, wechat, additionalProperties);
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
    if (!(jira == null)) {
        sb.append("jira:");
        sb.append(jira);
        sb.append(",");
    }
    if (!(mattermost == null)) {
        sb.append("mattermost:");
        sb.append(mattermost);
        sb.append(",");
    }
    if (!(opsGenieApiKey == null)) {
        sb.append("opsGenieApiKey:");
        sb.append(opsGenieApiKey);
        sb.append(",");
    }
    if (!(opsGenieApiUrl == null)) {
        sb.append("opsGenieApiUrl:");
        sb.append(opsGenieApiUrl);
        sb.append(",");
    }
    if (!(pagerdutyUrl == null)) {
        sb.append("pagerdutyUrl:");
        sb.append(pagerdutyUrl);
        sb.append(",");
    }
    if (!(resolveTimeout == null)) {
        sb.append("resolveTimeout:");
        sb.append(resolveTimeout);
        sb.append(",");
    }
    if (!(rocketChat == null)) {
        sb.append("rocketChat:");
        sb.append(rocketChat);
        sb.append(",");
    }
    if (!(slackApiUrl == null)) {
        sb.append("slackApiUrl:");
        sb.append(slackApiUrl);
        sb.append(",");
    }
    if (!(smtp == null)) {
        sb.append("smtp:");
        sb.append(smtp);
        sb.append(",");
    }
    if (!(telegram == null)) {
        sb.append("telegram:");
        sb.append(telegram);
        sb.append(",");
    }
    if (!(victorops == null)) {
        sb.append("victorops:");
        sb.append(victorops);
        sb.append(",");
    }
    if (!(webex == null)) {
        sb.append("webex:");
        sb.append(webex);
        sb.append(",");
    }
    if (!(wechat == null)) {
        sb.append("wechat:");
        sb.append(wechat);
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
  
  public A withHttpConfig(HTTPConfigWithProxy httpConfig) {
    this._visitables.remove("httpConfig");
    if (httpConfig != null) {
        this.httpConfig = new HTTPConfigWithProxyBuilder(httpConfig);
        this._visitables.get("httpConfig").add(this.httpConfig);
    } else {
        this.httpConfig = null;
        this._visitables.get("httpConfig").remove(this.httpConfig);
    }
    return (A) this;
  }
  
  public A withJira(GlobalJiraConfig jira) {
    this._visitables.remove("jira");
    if (jira != null) {
        this.jira = new GlobalJiraConfigBuilder(jira);
        this._visitables.get("jira").add(this.jira);
    } else {
        this.jira = null;
        this._visitables.get("jira").remove(this.jira);
    }
    return (A) this;
  }
  
  public A withMattermost(GlobalMattermostConfig mattermost) {
    this._visitables.remove("mattermost");
    if (mattermost != null) {
        this.mattermost = new GlobalMattermostConfigBuilder(mattermost);
        this._visitables.get("mattermost").add(this.mattermost);
    } else {
        this.mattermost = null;
        this._visitables.get("mattermost").remove(this.mattermost);
    }
    return (A) this;
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfigWithProxy item) {
    return new HttpConfigNested(item);
  }
  
  public JiraNested<A> withNewJira() {
    return new JiraNested(null);
  }
  
  public A withNewJira(String apiURL) {
    return (A) this.withJira(new GlobalJiraConfig(apiURL));
  }
  
  public JiraNested<A> withNewJiraLike(GlobalJiraConfig item) {
    return new JiraNested(item);
  }
  
  public MattermostNested<A> withNewMattermost() {
    return new MattermostNested(null);
  }
  
  public MattermostNested<A> withNewMattermostLike(GlobalMattermostConfig item) {
    return new MattermostNested(item);
  }
  
  public A withNewOpsGenieApiKey(String key,String name,Boolean optional) {
    return (A) this.withOpsGenieApiKey(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewOpsGenieApiUrl(String key,String name,Boolean optional) {
    return (A) this.withOpsGenieApiUrl(new SecretKeySelector(key, name, optional));
  }
  
  public RocketChatNested<A> withNewRocketChat() {
    return new RocketChatNested(null);
  }
  
  public RocketChatNested<A> withNewRocketChatLike(GlobalRocketChatConfig item) {
    return new RocketChatNested(item);
  }
  
  public A withNewSlackApiUrl(String key,String name,Boolean optional) {
    return (A) this.withSlackApiUrl(new SecretKeySelector(key, name, optional));
  }
  
  public SmtpNested<A> withNewSmtp() {
    return new SmtpNested(null);
  }
  
  public SmtpNested<A> withNewSmtpLike(GlobalSMTPConfig item) {
    return new SmtpNested(item);
  }
  
  public TelegramNested<A> withNewTelegram() {
    return new TelegramNested(null);
  }
  
  public A withNewTelegram(String apiURL) {
    return (A) this.withTelegram(new GlobalTelegramConfig(apiURL));
  }
  
  public TelegramNested<A> withNewTelegramLike(GlobalTelegramConfig item) {
    return new TelegramNested(item);
  }
  
  public VictoropsNested<A> withNewVictorops() {
    return new VictoropsNested(null);
  }
  
  public VictoropsNested<A> withNewVictoropsLike(GlobalVictorOpsConfig item) {
    return new VictoropsNested(item);
  }
  
  public WebexNested<A> withNewWebex() {
    return new WebexNested(null);
  }
  
  public A withNewWebex(String apiURL) {
    return (A) this.withWebex(new GlobalWebexConfig(apiURL));
  }
  
  public WebexNested<A> withNewWebexLike(GlobalWebexConfig item) {
    return new WebexNested(item);
  }
  
  public WechatNested<A> withNewWechat() {
    return new WechatNested(null);
  }
  
  public WechatNested<A> withNewWechatLike(GlobalWeChatConfig item) {
    return new WechatNested(item);
  }
  
  public A withOpsGenieApiKey(SecretKeySelector opsGenieApiKey) {
    this.opsGenieApiKey = opsGenieApiKey;
    return (A) this;
  }
  
  public A withOpsGenieApiUrl(SecretKeySelector opsGenieApiUrl) {
    this.opsGenieApiUrl = opsGenieApiUrl;
    return (A) this;
  }
  
  public A withPagerdutyUrl(String pagerdutyUrl) {
    this.pagerdutyUrl = pagerdutyUrl;
    return (A) this;
  }
  
  public A withResolveTimeout(String resolveTimeout) {
    this.resolveTimeout = resolveTimeout;
    return (A) this;
  }
  
  public A withRocketChat(GlobalRocketChatConfig rocketChat) {
    this._visitables.remove("rocketChat");
    if (rocketChat != null) {
        this.rocketChat = new GlobalRocketChatConfigBuilder(rocketChat);
        this._visitables.get("rocketChat").add(this.rocketChat);
    } else {
        this.rocketChat = null;
        this._visitables.get("rocketChat").remove(this.rocketChat);
    }
    return (A) this;
  }
  
  public A withSlackApiUrl(SecretKeySelector slackApiUrl) {
    this.slackApiUrl = slackApiUrl;
    return (A) this;
  }
  
  public A withSmtp(GlobalSMTPConfig smtp) {
    this._visitables.remove("smtp");
    if (smtp != null) {
        this.smtp = new GlobalSMTPConfigBuilder(smtp);
        this._visitables.get("smtp").add(this.smtp);
    } else {
        this.smtp = null;
        this._visitables.get("smtp").remove(this.smtp);
    }
    return (A) this;
  }
  
  public A withTelegram(GlobalTelegramConfig telegram) {
    this._visitables.remove("telegram");
    if (telegram != null) {
        this.telegram = new GlobalTelegramConfigBuilder(telegram);
        this._visitables.get("telegram").add(this.telegram);
    } else {
        this.telegram = null;
        this._visitables.get("telegram").remove(this.telegram);
    }
    return (A) this;
  }
  
  public A withVictorops(GlobalVictorOpsConfig victorops) {
    this._visitables.remove("victorops");
    if (victorops != null) {
        this.victorops = new GlobalVictorOpsConfigBuilder(victorops);
        this._visitables.get("victorops").add(this.victorops);
    } else {
        this.victorops = null;
        this._visitables.get("victorops").remove(this.victorops);
    }
    return (A) this;
  }
  
  public A withWebex(GlobalWebexConfig webex) {
    this._visitables.remove("webex");
    if (webex != null) {
        this.webex = new GlobalWebexConfigBuilder(webex);
        this._visitables.get("webex").add(this.webex);
    } else {
        this.webex = null;
        this._visitables.get("webex").remove(this.webex);
    }
    return (A) this;
  }
  
  public A withWechat(GlobalWeChatConfig wechat) {
    this._visitables.remove("wechat");
    if (wechat != null) {
        this.wechat = new GlobalWeChatConfigBuilder(wechat);
        this._visitables.get("wechat").add(this.wechat);
    } else {
        this.wechat = null;
        this._visitables.get("wechat").remove(this.wechat);
    }
    return (A) this;
  }
  public class HttpConfigNested<N> extends HTTPConfigWithProxyFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigWithProxyBuilder builder;
  
    HttpConfigNested(HTTPConfigWithProxy item) {
      this.builder = new HTTPConfigWithProxyBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
  public class JiraNested<N> extends GlobalJiraConfigFluent<JiraNested<N>> implements Nested<N>{
  
    GlobalJiraConfigBuilder builder;
  
    JiraNested(GlobalJiraConfig item) {
      this.builder = new GlobalJiraConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withJira(builder.build());
    }
    
    public N endJira() {
      return and();
    }
    
  }
  public class MattermostNested<N> extends GlobalMattermostConfigFluent<MattermostNested<N>> implements Nested<N>{
  
    GlobalMattermostConfigBuilder builder;
  
    MattermostNested(GlobalMattermostConfig item) {
      this.builder = new GlobalMattermostConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withMattermost(builder.build());
    }
    
    public N endMattermost() {
      return and();
    }
    
  }
  public class RocketChatNested<N> extends GlobalRocketChatConfigFluent<RocketChatNested<N>> implements Nested<N>{
  
    GlobalRocketChatConfigBuilder builder;
  
    RocketChatNested(GlobalRocketChatConfig item) {
      this.builder = new GlobalRocketChatConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withRocketChat(builder.build());
    }
    
    public N endRocketChat() {
      return and();
    }
    
  }
  public class SmtpNested<N> extends GlobalSMTPConfigFluent<SmtpNested<N>> implements Nested<N>{
  
    GlobalSMTPConfigBuilder builder;
  
    SmtpNested(GlobalSMTPConfig item) {
      this.builder = new GlobalSMTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withSmtp(builder.build());
    }
    
    public N endSmtp() {
      return and();
    }
    
  }
  public class TelegramNested<N> extends GlobalTelegramConfigFluent<TelegramNested<N>> implements Nested<N>{
  
    GlobalTelegramConfigBuilder builder;
  
    TelegramNested(GlobalTelegramConfig item) {
      this.builder = new GlobalTelegramConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withTelegram(builder.build());
    }
    
    public N endTelegram() {
      return and();
    }
    
  }
  public class VictoropsNested<N> extends GlobalVictorOpsConfigFluent<VictoropsNested<N>> implements Nested<N>{
  
    GlobalVictorOpsConfigBuilder builder;
  
    VictoropsNested(GlobalVictorOpsConfig item) {
      this.builder = new GlobalVictorOpsConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withVictorops(builder.build());
    }
    
    public N endVictorops() {
      return and();
    }
    
  }
  public class WebexNested<N> extends GlobalWebexConfigFluent<WebexNested<N>> implements Nested<N>{
  
    GlobalWebexConfigBuilder builder;
  
    WebexNested(GlobalWebexConfig item) {
      this.builder = new GlobalWebexConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withWebex(builder.build());
    }
    
    public N endWebex() {
      return and();
    }
    
  }
  public class WechatNested<N> extends GlobalWeChatConfigFluent<WechatNested<N>> implements Nested<N>{
  
    GlobalWeChatConfigBuilder builder;
  
    WechatNested(GlobalWeChatConfig item) {
      this.builder = new GlobalWeChatConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerGlobalConfigFluent.this.withWechat(builder.build());
    }
    
    public N endWechat() {
      return and();
    }
    
  }
}