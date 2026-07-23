package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ReceiverFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.ReceiverFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DiscordConfigBuilder> discordConfigs = new ArrayList<DiscordConfigBuilder>();
  private ArrayList<EmailConfigBuilder> emailConfigs = new ArrayList<EmailConfigBuilder>();
  private ArrayList<MSTeamsConfigBuilder> msteamsConfigs = new ArrayList<MSTeamsConfigBuilder>();
  private ArrayList<MSTeamsV2ConfigBuilder> msteamsv2Configs = new ArrayList<MSTeamsV2ConfigBuilder>();
  private String name;
  private ArrayList<OpsGenieConfigBuilder> opsgenieConfigs = new ArrayList<OpsGenieConfigBuilder>();
  private ArrayList<PagerDutyConfigBuilder> pagerdutyConfigs = new ArrayList<PagerDutyConfigBuilder>();
  private ArrayList<PushoverConfigBuilder> pushoverConfigs = new ArrayList<PushoverConfigBuilder>();
  private ArrayList<RocketChatConfigBuilder> rocketchatConfigs = new ArrayList<RocketChatConfigBuilder>();
  private ArrayList<SlackConfigBuilder> slackConfigs = new ArrayList<SlackConfigBuilder>();
  private ArrayList<SNSConfigBuilder> snsConfigs = new ArrayList<SNSConfigBuilder>();
  private ArrayList<TelegramConfigBuilder> telegramConfigs = new ArrayList<TelegramConfigBuilder>();
  private ArrayList<VictorOpsConfigBuilder> victoropsConfigs = new ArrayList<VictorOpsConfigBuilder>();
  private ArrayList<WebexConfigBuilder> webexConfigs = new ArrayList<WebexConfigBuilder>();
  private ArrayList<WebhookConfigBuilder> webhookConfigs = new ArrayList<WebhookConfigBuilder>();
  private ArrayList<WeChatConfigBuilder> wechatConfigs = new ArrayList<WeChatConfigBuilder>();

  public ReceiverFluent() {
  }
  
  public ReceiverFluent(Receiver instance) {
    this.copyInstance(instance);
  }

  public A addAllToDiscordConfigs(Collection<DiscordConfig> items) {
    if (this.discordConfigs == null) {
      this.discordConfigs = new ArrayList();
    }
    for (DiscordConfig item : items) {
        DiscordConfigBuilder builder = new DiscordConfigBuilder(item);
        _visitables.get("discordConfigs").add(builder);
        this.discordConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEmailConfigs(Collection<EmailConfig> items) {
    if (this.emailConfigs == null) {
      this.emailConfigs = new ArrayList();
    }
    for (EmailConfig item : items) {
        EmailConfigBuilder builder = new EmailConfigBuilder(item);
        _visitables.get("emailConfigs").add(builder);
        this.emailConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMsteamsConfigs(Collection<MSTeamsConfig> items) {
    if (this.msteamsConfigs == null) {
      this.msteamsConfigs = new ArrayList();
    }
    for (MSTeamsConfig item : items) {
        MSTeamsConfigBuilder builder = new MSTeamsConfigBuilder(item);
        _visitables.get("msteamsConfigs").add(builder);
        this.msteamsConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMsteamsv2Configs(Collection<MSTeamsV2Config> items) {
    if (this.msteamsv2Configs == null) {
      this.msteamsv2Configs = new ArrayList();
    }
    for (MSTeamsV2Config item : items) {
        MSTeamsV2ConfigBuilder builder = new MSTeamsV2ConfigBuilder(item);
        _visitables.get("msteamsv2Configs").add(builder);
        this.msteamsv2Configs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOpsgenieConfigs(Collection<OpsGenieConfig> items) {
    if (this.opsgenieConfigs == null) {
      this.opsgenieConfigs = new ArrayList();
    }
    for (OpsGenieConfig item : items) {
        OpsGenieConfigBuilder builder = new OpsGenieConfigBuilder(item);
        _visitables.get("opsgenieConfigs").add(builder);
        this.opsgenieConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPagerdutyConfigs(Collection<PagerDutyConfig> items) {
    if (this.pagerdutyConfigs == null) {
      this.pagerdutyConfigs = new ArrayList();
    }
    for (PagerDutyConfig item : items) {
        PagerDutyConfigBuilder builder = new PagerDutyConfigBuilder(item);
        _visitables.get("pagerdutyConfigs").add(builder);
        this.pagerdutyConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPushoverConfigs(Collection<PushoverConfig> items) {
    if (this.pushoverConfigs == null) {
      this.pushoverConfigs = new ArrayList();
    }
    for (PushoverConfig item : items) {
        PushoverConfigBuilder builder = new PushoverConfigBuilder(item);
        _visitables.get("pushoverConfigs").add(builder);
        this.pushoverConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRocketchatConfigs(Collection<RocketChatConfig> items) {
    if (this.rocketchatConfigs == null) {
      this.rocketchatConfigs = new ArrayList();
    }
    for (RocketChatConfig item : items) {
        RocketChatConfigBuilder builder = new RocketChatConfigBuilder(item);
        _visitables.get("rocketchatConfigs").add(builder);
        this.rocketchatConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSlackConfigs(Collection<SlackConfig> items) {
    if (this.slackConfigs == null) {
      this.slackConfigs = new ArrayList();
    }
    for (SlackConfig item : items) {
        SlackConfigBuilder builder = new SlackConfigBuilder(item);
        _visitables.get("slackConfigs").add(builder);
        this.slackConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSnsConfigs(Collection<SNSConfig> items) {
    if (this.snsConfigs == null) {
      this.snsConfigs = new ArrayList();
    }
    for (SNSConfig item : items) {
        SNSConfigBuilder builder = new SNSConfigBuilder(item);
        _visitables.get("snsConfigs").add(builder);
        this.snsConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTelegramConfigs(Collection<TelegramConfig> items) {
    if (this.telegramConfigs == null) {
      this.telegramConfigs = new ArrayList();
    }
    for (TelegramConfig item : items) {
        TelegramConfigBuilder builder = new TelegramConfigBuilder(item);
        _visitables.get("telegramConfigs").add(builder);
        this.telegramConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVictoropsConfigs(Collection<VictorOpsConfig> items) {
    if (this.victoropsConfigs == null) {
      this.victoropsConfigs = new ArrayList();
    }
    for (VictorOpsConfig item : items) {
        VictorOpsConfigBuilder builder = new VictorOpsConfigBuilder(item);
        _visitables.get("victoropsConfigs").add(builder);
        this.victoropsConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWebexConfigs(Collection<WebexConfig> items) {
    if (this.webexConfigs == null) {
      this.webexConfigs = new ArrayList();
    }
    for (WebexConfig item : items) {
        WebexConfigBuilder builder = new WebexConfigBuilder(item);
        _visitables.get("webexConfigs").add(builder);
        this.webexConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWebhookConfigs(Collection<WebhookConfig> items) {
    if (this.webhookConfigs == null) {
      this.webhookConfigs = new ArrayList();
    }
    for (WebhookConfig item : items) {
        WebhookConfigBuilder builder = new WebhookConfigBuilder(item);
        _visitables.get("webhookConfigs").add(builder);
        this.webhookConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWechatConfigs(Collection<WeChatConfig> items) {
    if (this.wechatConfigs == null) {
      this.wechatConfigs = new ArrayList();
    }
    for (WeChatConfig item : items) {
        WeChatConfigBuilder builder = new WeChatConfigBuilder(item);
        _visitables.get("wechatConfigs").add(builder);
        this.wechatConfigs.add(builder);
    }
    return (A) this;
  }
  
  public DiscordConfigsNested<A> addNewDiscordConfig() {
    return new DiscordConfigsNested(-1, null);
  }
  
  public DiscordConfigsNested<A> addNewDiscordConfigLike(DiscordConfig item) {
    return new DiscordConfigsNested(-1, item);
  }
  
  public EmailConfigsNested<A> addNewEmailConfig() {
    return new EmailConfigsNested(-1, null);
  }
  
  public EmailConfigsNested<A> addNewEmailConfigLike(EmailConfig item) {
    return new EmailConfigsNested(-1, item);
  }
  
  public MsteamsConfigsNested<A> addNewMsteamsConfig() {
    return new MsteamsConfigsNested(-1, null);
  }
  
  public MsteamsConfigsNested<A> addNewMsteamsConfigLike(MSTeamsConfig item) {
    return new MsteamsConfigsNested(-1, item);
  }
  
  public Msteamsv2ConfigsNested<A> addNewMsteamsv2Config() {
    return new Msteamsv2ConfigsNested(-1, null);
  }
  
  public Msteamsv2ConfigsNested<A> addNewMsteamsv2ConfigLike(MSTeamsV2Config item) {
    return new Msteamsv2ConfigsNested(-1, item);
  }
  
  public OpsgenieConfigsNested<A> addNewOpsgenieConfig() {
    return new OpsgenieConfigsNested(-1, null);
  }
  
  public OpsgenieConfigsNested<A> addNewOpsgenieConfigLike(OpsGenieConfig item) {
    return new OpsgenieConfigsNested(-1, item);
  }
  
  public PagerdutyConfigsNested<A> addNewPagerdutyConfig() {
    return new PagerdutyConfigsNested(-1, null);
  }
  
  public PagerdutyConfigsNested<A> addNewPagerdutyConfigLike(PagerDutyConfig item) {
    return new PagerdutyConfigsNested(-1, item);
  }
  
  public PushoverConfigsNested<A> addNewPushoverConfig() {
    return new PushoverConfigsNested(-1, null);
  }
  
  public PushoverConfigsNested<A> addNewPushoverConfigLike(PushoverConfig item) {
    return new PushoverConfigsNested(-1, item);
  }
  
  public RocketchatConfigsNested<A> addNewRocketchatConfig() {
    return new RocketchatConfigsNested(-1, null);
  }
  
  public RocketchatConfigsNested<A> addNewRocketchatConfigLike(RocketChatConfig item) {
    return new RocketchatConfigsNested(-1, item);
  }
  
  public SlackConfigsNested<A> addNewSlackConfig() {
    return new SlackConfigsNested(-1, null);
  }
  
  public SlackConfigsNested<A> addNewSlackConfigLike(SlackConfig item) {
    return new SlackConfigsNested(-1, item);
  }
  
  public SnsConfigsNested<A> addNewSnsConfig() {
    return new SnsConfigsNested(-1, null);
  }
  
  public SnsConfigsNested<A> addNewSnsConfigLike(SNSConfig item) {
    return new SnsConfigsNested(-1, item);
  }
  
  public TelegramConfigsNested<A> addNewTelegramConfig() {
    return new TelegramConfigsNested(-1, null);
  }
  
  public TelegramConfigsNested<A> addNewTelegramConfigLike(TelegramConfig item) {
    return new TelegramConfigsNested(-1, item);
  }
  
  public VictoropsConfigsNested<A> addNewVictoropsConfig() {
    return new VictoropsConfigsNested(-1, null);
  }
  
  public VictoropsConfigsNested<A> addNewVictoropsConfigLike(VictorOpsConfig item) {
    return new VictoropsConfigsNested(-1, item);
  }
  
  public WebexConfigsNested<A> addNewWebexConfig() {
    return new WebexConfigsNested(-1, null);
  }
  
  public WebexConfigsNested<A> addNewWebexConfigLike(WebexConfig item) {
    return new WebexConfigsNested(-1, item);
  }
  
  public WebhookConfigsNested<A> addNewWebhookConfig() {
    return new WebhookConfigsNested(-1, null);
  }
  
  public WebhookConfigsNested<A> addNewWebhookConfigLike(WebhookConfig item) {
    return new WebhookConfigsNested(-1, item);
  }
  
  public WechatConfigsNested<A> addNewWechatConfig() {
    return new WechatConfigsNested(-1, null);
  }
  
  public WechatConfigsNested<A> addNewWechatConfigLike(WeChatConfig item) {
    return new WechatConfigsNested(-1, item);
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
  
  public A addToDiscordConfigs(DiscordConfig... items) {
    if (this.discordConfigs == null) {
      this.discordConfigs = new ArrayList();
    }
    for (DiscordConfig item : items) {
        DiscordConfigBuilder builder = new DiscordConfigBuilder(item);
        _visitables.get("discordConfigs").add(builder);
        this.discordConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToDiscordConfigs(int index,DiscordConfig item) {
    if (this.discordConfigs == null) {
      this.discordConfigs = new ArrayList();
    }
    DiscordConfigBuilder builder = new DiscordConfigBuilder(item);
    if (index < 0 || index >= discordConfigs.size()) {
        _visitables.get("discordConfigs").add(builder);
        discordConfigs.add(builder);
    } else {
        _visitables.get("discordConfigs").add(builder);
        discordConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEmailConfigs(EmailConfig... items) {
    if (this.emailConfigs == null) {
      this.emailConfigs = new ArrayList();
    }
    for (EmailConfig item : items) {
        EmailConfigBuilder builder = new EmailConfigBuilder(item);
        _visitables.get("emailConfigs").add(builder);
        this.emailConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToEmailConfigs(int index,EmailConfig item) {
    if (this.emailConfigs == null) {
      this.emailConfigs = new ArrayList();
    }
    EmailConfigBuilder builder = new EmailConfigBuilder(item);
    if (index < 0 || index >= emailConfigs.size()) {
        _visitables.get("emailConfigs").add(builder);
        emailConfigs.add(builder);
    } else {
        _visitables.get("emailConfigs").add(builder);
        emailConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMsteamsConfigs(MSTeamsConfig... items) {
    if (this.msteamsConfigs == null) {
      this.msteamsConfigs = new ArrayList();
    }
    for (MSTeamsConfig item : items) {
        MSTeamsConfigBuilder builder = new MSTeamsConfigBuilder(item);
        _visitables.get("msteamsConfigs").add(builder);
        this.msteamsConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToMsteamsConfigs(int index,MSTeamsConfig item) {
    if (this.msteamsConfigs == null) {
      this.msteamsConfigs = new ArrayList();
    }
    MSTeamsConfigBuilder builder = new MSTeamsConfigBuilder(item);
    if (index < 0 || index >= msteamsConfigs.size()) {
        _visitables.get("msteamsConfigs").add(builder);
        msteamsConfigs.add(builder);
    } else {
        _visitables.get("msteamsConfigs").add(builder);
        msteamsConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMsteamsv2Configs(MSTeamsV2Config... items) {
    if (this.msteamsv2Configs == null) {
      this.msteamsv2Configs = new ArrayList();
    }
    for (MSTeamsV2Config item : items) {
        MSTeamsV2ConfigBuilder builder = new MSTeamsV2ConfigBuilder(item);
        _visitables.get("msteamsv2Configs").add(builder);
        this.msteamsv2Configs.add(builder);
    }
    return (A) this;
  }
  
  public A addToMsteamsv2Configs(int index,MSTeamsV2Config item) {
    if (this.msteamsv2Configs == null) {
      this.msteamsv2Configs = new ArrayList();
    }
    MSTeamsV2ConfigBuilder builder = new MSTeamsV2ConfigBuilder(item);
    if (index < 0 || index >= msteamsv2Configs.size()) {
        _visitables.get("msteamsv2Configs").add(builder);
        msteamsv2Configs.add(builder);
    } else {
        _visitables.get("msteamsv2Configs").add(builder);
        msteamsv2Configs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOpsgenieConfigs(OpsGenieConfig... items) {
    if (this.opsgenieConfigs == null) {
      this.opsgenieConfigs = new ArrayList();
    }
    for (OpsGenieConfig item : items) {
        OpsGenieConfigBuilder builder = new OpsGenieConfigBuilder(item);
        _visitables.get("opsgenieConfigs").add(builder);
        this.opsgenieConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToOpsgenieConfigs(int index,OpsGenieConfig item) {
    if (this.opsgenieConfigs == null) {
      this.opsgenieConfigs = new ArrayList();
    }
    OpsGenieConfigBuilder builder = new OpsGenieConfigBuilder(item);
    if (index < 0 || index >= opsgenieConfigs.size()) {
        _visitables.get("opsgenieConfigs").add(builder);
        opsgenieConfigs.add(builder);
    } else {
        _visitables.get("opsgenieConfigs").add(builder);
        opsgenieConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPagerdutyConfigs(PagerDutyConfig... items) {
    if (this.pagerdutyConfigs == null) {
      this.pagerdutyConfigs = new ArrayList();
    }
    for (PagerDutyConfig item : items) {
        PagerDutyConfigBuilder builder = new PagerDutyConfigBuilder(item);
        _visitables.get("pagerdutyConfigs").add(builder);
        this.pagerdutyConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToPagerdutyConfigs(int index,PagerDutyConfig item) {
    if (this.pagerdutyConfigs == null) {
      this.pagerdutyConfigs = new ArrayList();
    }
    PagerDutyConfigBuilder builder = new PagerDutyConfigBuilder(item);
    if (index < 0 || index >= pagerdutyConfigs.size()) {
        _visitables.get("pagerdutyConfigs").add(builder);
        pagerdutyConfigs.add(builder);
    } else {
        _visitables.get("pagerdutyConfigs").add(builder);
        pagerdutyConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPushoverConfigs(PushoverConfig... items) {
    if (this.pushoverConfigs == null) {
      this.pushoverConfigs = new ArrayList();
    }
    for (PushoverConfig item : items) {
        PushoverConfigBuilder builder = new PushoverConfigBuilder(item);
        _visitables.get("pushoverConfigs").add(builder);
        this.pushoverConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToPushoverConfigs(int index,PushoverConfig item) {
    if (this.pushoverConfigs == null) {
      this.pushoverConfigs = new ArrayList();
    }
    PushoverConfigBuilder builder = new PushoverConfigBuilder(item);
    if (index < 0 || index >= pushoverConfigs.size()) {
        _visitables.get("pushoverConfigs").add(builder);
        pushoverConfigs.add(builder);
    } else {
        _visitables.get("pushoverConfigs").add(builder);
        pushoverConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRocketchatConfigs(RocketChatConfig... items) {
    if (this.rocketchatConfigs == null) {
      this.rocketchatConfigs = new ArrayList();
    }
    for (RocketChatConfig item : items) {
        RocketChatConfigBuilder builder = new RocketChatConfigBuilder(item);
        _visitables.get("rocketchatConfigs").add(builder);
        this.rocketchatConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToRocketchatConfigs(int index,RocketChatConfig item) {
    if (this.rocketchatConfigs == null) {
      this.rocketchatConfigs = new ArrayList();
    }
    RocketChatConfigBuilder builder = new RocketChatConfigBuilder(item);
    if (index < 0 || index >= rocketchatConfigs.size()) {
        _visitables.get("rocketchatConfigs").add(builder);
        rocketchatConfigs.add(builder);
    } else {
        _visitables.get("rocketchatConfigs").add(builder);
        rocketchatConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSlackConfigs(SlackConfig... items) {
    if (this.slackConfigs == null) {
      this.slackConfigs = new ArrayList();
    }
    for (SlackConfig item : items) {
        SlackConfigBuilder builder = new SlackConfigBuilder(item);
        _visitables.get("slackConfigs").add(builder);
        this.slackConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToSlackConfigs(int index,SlackConfig item) {
    if (this.slackConfigs == null) {
      this.slackConfigs = new ArrayList();
    }
    SlackConfigBuilder builder = new SlackConfigBuilder(item);
    if (index < 0 || index >= slackConfigs.size()) {
        _visitables.get("slackConfigs").add(builder);
        slackConfigs.add(builder);
    } else {
        _visitables.get("slackConfigs").add(builder);
        slackConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSnsConfigs(SNSConfig... items) {
    if (this.snsConfigs == null) {
      this.snsConfigs = new ArrayList();
    }
    for (SNSConfig item : items) {
        SNSConfigBuilder builder = new SNSConfigBuilder(item);
        _visitables.get("snsConfigs").add(builder);
        this.snsConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToSnsConfigs(int index,SNSConfig item) {
    if (this.snsConfigs == null) {
      this.snsConfigs = new ArrayList();
    }
    SNSConfigBuilder builder = new SNSConfigBuilder(item);
    if (index < 0 || index >= snsConfigs.size()) {
        _visitables.get("snsConfigs").add(builder);
        snsConfigs.add(builder);
    } else {
        _visitables.get("snsConfigs").add(builder);
        snsConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTelegramConfigs(TelegramConfig... items) {
    if (this.telegramConfigs == null) {
      this.telegramConfigs = new ArrayList();
    }
    for (TelegramConfig item : items) {
        TelegramConfigBuilder builder = new TelegramConfigBuilder(item);
        _visitables.get("telegramConfigs").add(builder);
        this.telegramConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToTelegramConfigs(int index,TelegramConfig item) {
    if (this.telegramConfigs == null) {
      this.telegramConfigs = new ArrayList();
    }
    TelegramConfigBuilder builder = new TelegramConfigBuilder(item);
    if (index < 0 || index >= telegramConfigs.size()) {
        _visitables.get("telegramConfigs").add(builder);
        telegramConfigs.add(builder);
    } else {
        _visitables.get("telegramConfigs").add(builder);
        telegramConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVictoropsConfigs(VictorOpsConfig... items) {
    if (this.victoropsConfigs == null) {
      this.victoropsConfigs = new ArrayList();
    }
    for (VictorOpsConfig item : items) {
        VictorOpsConfigBuilder builder = new VictorOpsConfigBuilder(item);
        _visitables.get("victoropsConfigs").add(builder);
        this.victoropsConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToVictoropsConfigs(int index,VictorOpsConfig item) {
    if (this.victoropsConfigs == null) {
      this.victoropsConfigs = new ArrayList();
    }
    VictorOpsConfigBuilder builder = new VictorOpsConfigBuilder(item);
    if (index < 0 || index >= victoropsConfigs.size()) {
        _visitables.get("victoropsConfigs").add(builder);
        victoropsConfigs.add(builder);
    } else {
        _visitables.get("victoropsConfigs").add(builder);
        victoropsConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWebexConfigs(WebexConfig... items) {
    if (this.webexConfigs == null) {
      this.webexConfigs = new ArrayList();
    }
    for (WebexConfig item : items) {
        WebexConfigBuilder builder = new WebexConfigBuilder(item);
        _visitables.get("webexConfigs").add(builder);
        this.webexConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToWebexConfigs(int index,WebexConfig item) {
    if (this.webexConfigs == null) {
      this.webexConfigs = new ArrayList();
    }
    WebexConfigBuilder builder = new WebexConfigBuilder(item);
    if (index < 0 || index >= webexConfigs.size()) {
        _visitables.get("webexConfigs").add(builder);
        webexConfigs.add(builder);
    } else {
        _visitables.get("webexConfigs").add(builder);
        webexConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWebhookConfigs(WebhookConfig... items) {
    if (this.webhookConfigs == null) {
      this.webhookConfigs = new ArrayList();
    }
    for (WebhookConfig item : items) {
        WebhookConfigBuilder builder = new WebhookConfigBuilder(item);
        _visitables.get("webhookConfigs").add(builder);
        this.webhookConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToWebhookConfigs(int index,WebhookConfig item) {
    if (this.webhookConfigs == null) {
      this.webhookConfigs = new ArrayList();
    }
    WebhookConfigBuilder builder = new WebhookConfigBuilder(item);
    if (index < 0 || index >= webhookConfigs.size()) {
        _visitables.get("webhookConfigs").add(builder);
        webhookConfigs.add(builder);
    } else {
        _visitables.get("webhookConfigs").add(builder);
        webhookConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWechatConfigs(WeChatConfig... items) {
    if (this.wechatConfigs == null) {
      this.wechatConfigs = new ArrayList();
    }
    for (WeChatConfig item : items) {
        WeChatConfigBuilder builder = new WeChatConfigBuilder(item);
        _visitables.get("wechatConfigs").add(builder);
        this.wechatConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToWechatConfigs(int index,WeChatConfig item) {
    if (this.wechatConfigs == null) {
      this.wechatConfigs = new ArrayList();
    }
    WeChatConfigBuilder builder = new WeChatConfigBuilder(item);
    if (index < 0 || index >= wechatConfigs.size()) {
        _visitables.get("wechatConfigs").add(builder);
        wechatConfigs.add(builder);
    } else {
        _visitables.get("wechatConfigs").add(builder);
        wechatConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public DiscordConfig buildDiscordConfig(int index) {
    return this.discordConfigs.get(index).build();
  }
  
  public List<DiscordConfig> buildDiscordConfigs() {
    return this.discordConfigs != null ? build(discordConfigs) : null;
  }
  
  public EmailConfig buildEmailConfig(int index) {
    return this.emailConfigs.get(index).build();
  }
  
  public List<EmailConfig> buildEmailConfigs() {
    return this.emailConfigs != null ? build(emailConfigs) : null;
  }
  
  public DiscordConfig buildFirstDiscordConfig() {
    return this.discordConfigs.get(0).build();
  }
  
  public EmailConfig buildFirstEmailConfig() {
    return this.emailConfigs.get(0).build();
  }
  
  public MSTeamsConfig buildFirstMsteamsConfig() {
    return this.msteamsConfigs.get(0).build();
  }
  
  public MSTeamsV2Config buildFirstMsteamsv2Config() {
    return this.msteamsv2Configs.get(0).build();
  }
  
  public OpsGenieConfig buildFirstOpsgenieConfig() {
    return this.opsgenieConfigs.get(0).build();
  }
  
  public PagerDutyConfig buildFirstPagerdutyConfig() {
    return this.pagerdutyConfigs.get(0).build();
  }
  
  public PushoverConfig buildFirstPushoverConfig() {
    return this.pushoverConfigs.get(0).build();
  }
  
  public RocketChatConfig buildFirstRocketchatConfig() {
    return this.rocketchatConfigs.get(0).build();
  }
  
  public SlackConfig buildFirstSlackConfig() {
    return this.slackConfigs.get(0).build();
  }
  
  public SNSConfig buildFirstSnsConfig() {
    return this.snsConfigs.get(0).build();
  }
  
  public TelegramConfig buildFirstTelegramConfig() {
    return this.telegramConfigs.get(0).build();
  }
  
  public VictorOpsConfig buildFirstVictoropsConfig() {
    return this.victoropsConfigs.get(0).build();
  }
  
  public WebexConfig buildFirstWebexConfig() {
    return this.webexConfigs.get(0).build();
  }
  
  public WebhookConfig buildFirstWebhookConfig() {
    return this.webhookConfigs.get(0).build();
  }
  
  public WeChatConfig buildFirstWechatConfig() {
    return this.wechatConfigs.get(0).build();
  }
  
  public DiscordConfig buildLastDiscordConfig() {
    return this.discordConfigs.get(discordConfigs.size() - 1).build();
  }
  
  public EmailConfig buildLastEmailConfig() {
    return this.emailConfigs.get(emailConfigs.size() - 1).build();
  }
  
  public MSTeamsConfig buildLastMsteamsConfig() {
    return this.msteamsConfigs.get(msteamsConfigs.size() - 1).build();
  }
  
  public MSTeamsV2Config buildLastMsteamsv2Config() {
    return this.msteamsv2Configs.get(msteamsv2Configs.size() - 1).build();
  }
  
  public OpsGenieConfig buildLastOpsgenieConfig() {
    return this.opsgenieConfigs.get(opsgenieConfigs.size() - 1).build();
  }
  
  public PagerDutyConfig buildLastPagerdutyConfig() {
    return this.pagerdutyConfigs.get(pagerdutyConfigs.size() - 1).build();
  }
  
  public PushoverConfig buildLastPushoverConfig() {
    return this.pushoverConfigs.get(pushoverConfigs.size() - 1).build();
  }
  
  public RocketChatConfig buildLastRocketchatConfig() {
    return this.rocketchatConfigs.get(rocketchatConfigs.size() - 1).build();
  }
  
  public SlackConfig buildLastSlackConfig() {
    return this.slackConfigs.get(slackConfigs.size() - 1).build();
  }
  
  public SNSConfig buildLastSnsConfig() {
    return this.snsConfigs.get(snsConfigs.size() - 1).build();
  }
  
  public TelegramConfig buildLastTelegramConfig() {
    return this.telegramConfigs.get(telegramConfigs.size() - 1).build();
  }
  
  public VictorOpsConfig buildLastVictoropsConfig() {
    return this.victoropsConfigs.get(victoropsConfigs.size() - 1).build();
  }
  
  public WebexConfig buildLastWebexConfig() {
    return this.webexConfigs.get(webexConfigs.size() - 1).build();
  }
  
  public WebhookConfig buildLastWebhookConfig() {
    return this.webhookConfigs.get(webhookConfigs.size() - 1).build();
  }
  
  public WeChatConfig buildLastWechatConfig() {
    return this.wechatConfigs.get(wechatConfigs.size() - 1).build();
  }
  
  public DiscordConfig buildMatchingDiscordConfig(Predicate<DiscordConfigBuilder> predicate) {
      for (DiscordConfigBuilder item : discordConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EmailConfig buildMatchingEmailConfig(Predicate<EmailConfigBuilder> predicate) {
      for (EmailConfigBuilder item : emailConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MSTeamsConfig buildMatchingMsteamsConfig(Predicate<MSTeamsConfigBuilder> predicate) {
      for (MSTeamsConfigBuilder item : msteamsConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MSTeamsV2Config buildMatchingMsteamsv2Config(Predicate<MSTeamsV2ConfigBuilder> predicate) {
      for (MSTeamsV2ConfigBuilder item : msteamsv2Configs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OpsGenieConfig buildMatchingOpsgenieConfig(Predicate<OpsGenieConfigBuilder> predicate) {
      for (OpsGenieConfigBuilder item : opsgenieConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PagerDutyConfig buildMatchingPagerdutyConfig(Predicate<PagerDutyConfigBuilder> predicate) {
      for (PagerDutyConfigBuilder item : pagerdutyConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PushoverConfig buildMatchingPushoverConfig(Predicate<PushoverConfigBuilder> predicate) {
      for (PushoverConfigBuilder item : pushoverConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RocketChatConfig buildMatchingRocketchatConfig(Predicate<RocketChatConfigBuilder> predicate) {
      for (RocketChatConfigBuilder item : rocketchatConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SlackConfig buildMatchingSlackConfig(Predicate<SlackConfigBuilder> predicate) {
      for (SlackConfigBuilder item : slackConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SNSConfig buildMatchingSnsConfig(Predicate<SNSConfigBuilder> predicate) {
      for (SNSConfigBuilder item : snsConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TelegramConfig buildMatchingTelegramConfig(Predicate<TelegramConfigBuilder> predicate) {
      for (TelegramConfigBuilder item : telegramConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VictorOpsConfig buildMatchingVictoropsConfig(Predicate<VictorOpsConfigBuilder> predicate) {
      for (VictorOpsConfigBuilder item : victoropsConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WebexConfig buildMatchingWebexConfig(Predicate<WebexConfigBuilder> predicate) {
      for (WebexConfigBuilder item : webexConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WebhookConfig buildMatchingWebhookConfig(Predicate<WebhookConfigBuilder> predicate) {
      for (WebhookConfigBuilder item : webhookConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WeChatConfig buildMatchingWechatConfig(Predicate<WeChatConfigBuilder> predicate) {
      for (WeChatConfigBuilder item : wechatConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MSTeamsConfig buildMsteamsConfig(int index) {
    return this.msteamsConfigs.get(index).build();
  }
  
  public List<MSTeamsConfig> buildMsteamsConfigs() {
    return this.msteamsConfigs != null ? build(msteamsConfigs) : null;
  }
  
  public MSTeamsV2Config buildMsteamsv2Config(int index) {
    return this.msteamsv2Configs.get(index).build();
  }
  
  public List<MSTeamsV2Config> buildMsteamsv2Configs() {
    return this.msteamsv2Configs != null ? build(msteamsv2Configs) : null;
  }
  
  public OpsGenieConfig buildOpsgenieConfig(int index) {
    return this.opsgenieConfigs.get(index).build();
  }
  
  public List<OpsGenieConfig> buildOpsgenieConfigs() {
    return this.opsgenieConfigs != null ? build(opsgenieConfigs) : null;
  }
  
  public PagerDutyConfig buildPagerdutyConfig(int index) {
    return this.pagerdutyConfigs.get(index).build();
  }
  
  public List<PagerDutyConfig> buildPagerdutyConfigs() {
    return this.pagerdutyConfigs != null ? build(pagerdutyConfigs) : null;
  }
  
  public PushoverConfig buildPushoverConfig(int index) {
    return this.pushoverConfigs.get(index).build();
  }
  
  public List<PushoverConfig> buildPushoverConfigs() {
    return this.pushoverConfigs != null ? build(pushoverConfigs) : null;
  }
  
  public RocketChatConfig buildRocketchatConfig(int index) {
    return this.rocketchatConfigs.get(index).build();
  }
  
  public List<RocketChatConfig> buildRocketchatConfigs() {
    return this.rocketchatConfigs != null ? build(rocketchatConfigs) : null;
  }
  
  public SlackConfig buildSlackConfig(int index) {
    return this.slackConfigs.get(index).build();
  }
  
  public List<SlackConfig> buildSlackConfigs() {
    return this.slackConfigs != null ? build(slackConfigs) : null;
  }
  
  public SNSConfig buildSnsConfig(int index) {
    return this.snsConfigs.get(index).build();
  }
  
  public List<SNSConfig> buildSnsConfigs() {
    return this.snsConfigs != null ? build(snsConfigs) : null;
  }
  
  public TelegramConfig buildTelegramConfig(int index) {
    return this.telegramConfigs.get(index).build();
  }
  
  public List<TelegramConfig> buildTelegramConfigs() {
    return this.telegramConfigs != null ? build(telegramConfigs) : null;
  }
  
  public VictorOpsConfig buildVictoropsConfig(int index) {
    return this.victoropsConfigs.get(index).build();
  }
  
  public List<VictorOpsConfig> buildVictoropsConfigs() {
    return this.victoropsConfigs != null ? build(victoropsConfigs) : null;
  }
  
  public WebexConfig buildWebexConfig(int index) {
    return this.webexConfigs.get(index).build();
  }
  
  public List<WebexConfig> buildWebexConfigs() {
    return this.webexConfigs != null ? build(webexConfigs) : null;
  }
  
  public WebhookConfig buildWebhookConfig(int index) {
    return this.webhookConfigs.get(index).build();
  }
  
  public List<WebhookConfig> buildWebhookConfigs() {
    return this.webhookConfigs != null ? build(webhookConfigs) : null;
  }
  
  public WeChatConfig buildWechatConfig(int index) {
    return this.wechatConfigs.get(index).build();
  }
  
  public List<WeChatConfig> buildWechatConfigs() {
    return this.wechatConfigs != null ? build(wechatConfigs) : null;
  }
  
  protected void copyInstance(Receiver instance) {
    instance = instance != null ? instance : new Receiver();
    if (instance != null) {
        this.withDiscordConfigs(instance.getDiscordConfigs());
        this.withEmailConfigs(instance.getEmailConfigs());
        this.withMsteamsConfigs(instance.getMsteamsConfigs());
        this.withMsteamsv2Configs(instance.getMsteamsv2Configs());
        this.withName(instance.getName());
        this.withOpsgenieConfigs(instance.getOpsgenieConfigs());
        this.withPagerdutyConfigs(instance.getPagerdutyConfigs());
        this.withPushoverConfigs(instance.getPushoverConfigs());
        this.withRocketchatConfigs(instance.getRocketchatConfigs());
        this.withSlackConfigs(instance.getSlackConfigs());
        this.withSnsConfigs(instance.getSnsConfigs());
        this.withTelegramConfigs(instance.getTelegramConfigs());
        this.withVictoropsConfigs(instance.getVictoropsConfigs());
        this.withWebexConfigs(instance.getWebexConfigs());
        this.withWebhookConfigs(instance.getWebhookConfigs());
        this.withWechatConfigs(instance.getWechatConfigs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DiscordConfigsNested<A> editDiscordConfig(int index) {
    if (discordConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "discordConfigs"));
    }
    return this.setNewDiscordConfigLike(index, this.buildDiscordConfig(index));
  }
  
  public EmailConfigsNested<A> editEmailConfig(int index) {
    if (emailConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "emailConfigs"));
    }
    return this.setNewEmailConfigLike(index, this.buildEmailConfig(index));
  }
  
  public DiscordConfigsNested<A> editFirstDiscordConfig() {
    if (discordConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "discordConfigs"));
    }
    return this.setNewDiscordConfigLike(0, this.buildDiscordConfig(0));
  }
  
  public EmailConfigsNested<A> editFirstEmailConfig() {
    if (emailConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "emailConfigs"));
    }
    return this.setNewEmailConfigLike(0, this.buildEmailConfig(0));
  }
  
  public MsteamsConfigsNested<A> editFirstMsteamsConfig() {
    if (msteamsConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "msteamsConfigs"));
    }
    return this.setNewMsteamsConfigLike(0, this.buildMsteamsConfig(0));
  }
  
  public Msteamsv2ConfigsNested<A> editFirstMsteamsv2Config() {
    if (msteamsv2Configs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "msteamsv2Configs"));
    }
    return this.setNewMsteamsv2ConfigLike(0, this.buildMsteamsv2Config(0));
  }
  
  public OpsgenieConfigsNested<A> editFirstOpsgenieConfig() {
    if (opsgenieConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "opsgenieConfigs"));
    }
    return this.setNewOpsgenieConfigLike(0, this.buildOpsgenieConfig(0));
  }
  
  public PagerdutyConfigsNested<A> editFirstPagerdutyConfig() {
    if (pagerdutyConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pagerdutyConfigs"));
    }
    return this.setNewPagerdutyConfigLike(0, this.buildPagerdutyConfig(0));
  }
  
  public PushoverConfigsNested<A> editFirstPushoverConfig() {
    if (pushoverConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pushoverConfigs"));
    }
    return this.setNewPushoverConfigLike(0, this.buildPushoverConfig(0));
  }
  
  public RocketchatConfigsNested<A> editFirstRocketchatConfig() {
    if (rocketchatConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "rocketchatConfigs"));
    }
    return this.setNewRocketchatConfigLike(0, this.buildRocketchatConfig(0));
  }
  
  public SlackConfigsNested<A> editFirstSlackConfig() {
    if (slackConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "slackConfigs"));
    }
    return this.setNewSlackConfigLike(0, this.buildSlackConfig(0));
  }
  
  public SnsConfigsNested<A> editFirstSnsConfig() {
    if (snsConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "snsConfigs"));
    }
    return this.setNewSnsConfigLike(0, this.buildSnsConfig(0));
  }
  
  public TelegramConfigsNested<A> editFirstTelegramConfig() {
    if (telegramConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "telegramConfigs"));
    }
    return this.setNewTelegramConfigLike(0, this.buildTelegramConfig(0));
  }
  
  public VictoropsConfigsNested<A> editFirstVictoropsConfig() {
    if (victoropsConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "victoropsConfigs"));
    }
    return this.setNewVictoropsConfigLike(0, this.buildVictoropsConfig(0));
  }
  
  public WebexConfigsNested<A> editFirstWebexConfig() {
    if (webexConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "webexConfigs"));
    }
    return this.setNewWebexConfigLike(0, this.buildWebexConfig(0));
  }
  
  public WebhookConfigsNested<A> editFirstWebhookConfig() {
    if (webhookConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "webhookConfigs"));
    }
    return this.setNewWebhookConfigLike(0, this.buildWebhookConfig(0));
  }
  
  public WechatConfigsNested<A> editFirstWechatConfig() {
    if (wechatConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "wechatConfigs"));
    }
    return this.setNewWechatConfigLike(0, this.buildWechatConfig(0));
  }
  
  public DiscordConfigsNested<A> editLastDiscordConfig() {
    int index = discordConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "discordConfigs"));
    }
    return this.setNewDiscordConfigLike(index, this.buildDiscordConfig(index));
  }
  
  public EmailConfigsNested<A> editLastEmailConfig() {
    int index = emailConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "emailConfigs"));
    }
    return this.setNewEmailConfigLike(index, this.buildEmailConfig(index));
  }
  
  public MsteamsConfigsNested<A> editLastMsteamsConfig() {
    int index = msteamsConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "msteamsConfigs"));
    }
    return this.setNewMsteamsConfigLike(index, this.buildMsteamsConfig(index));
  }
  
  public Msteamsv2ConfigsNested<A> editLastMsteamsv2Config() {
    int index = msteamsv2Configs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "msteamsv2Configs"));
    }
    return this.setNewMsteamsv2ConfigLike(index, this.buildMsteamsv2Config(index));
  }
  
  public OpsgenieConfigsNested<A> editLastOpsgenieConfig() {
    int index = opsgenieConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "opsgenieConfigs"));
    }
    return this.setNewOpsgenieConfigLike(index, this.buildOpsgenieConfig(index));
  }
  
  public PagerdutyConfigsNested<A> editLastPagerdutyConfig() {
    int index = pagerdutyConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pagerdutyConfigs"));
    }
    return this.setNewPagerdutyConfigLike(index, this.buildPagerdutyConfig(index));
  }
  
  public PushoverConfigsNested<A> editLastPushoverConfig() {
    int index = pushoverConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pushoverConfigs"));
    }
    return this.setNewPushoverConfigLike(index, this.buildPushoverConfig(index));
  }
  
  public RocketchatConfigsNested<A> editLastRocketchatConfig() {
    int index = rocketchatConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "rocketchatConfigs"));
    }
    return this.setNewRocketchatConfigLike(index, this.buildRocketchatConfig(index));
  }
  
  public SlackConfigsNested<A> editLastSlackConfig() {
    int index = slackConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "slackConfigs"));
    }
    return this.setNewSlackConfigLike(index, this.buildSlackConfig(index));
  }
  
  public SnsConfigsNested<A> editLastSnsConfig() {
    int index = snsConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "snsConfigs"));
    }
    return this.setNewSnsConfigLike(index, this.buildSnsConfig(index));
  }
  
  public TelegramConfigsNested<A> editLastTelegramConfig() {
    int index = telegramConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "telegramConfigs"));
    }
    return this.setNewTelegramConfigLike(index, this.buildTelegramConfig(index));
  }
  
  public VictoropsConfigsNested<A> editLastVictoropsConfig() {
    int index = victoropsConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "victoropsConfigs"));
    }
    return this.setNewVictoropsConfigLike(index, this.buildVictoropsConfig(index));
  }
  
  public WebexConfigsNested<A> editLastWebexConfig() {
    int index = webexConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "webexConfigs"));
    }
    return this.setNewWebexConfigLike(index, this.buildWebexConfig(index));
  }
  
  public WebhookConfigsNested<A> editLastWebhookConfig() {
    int index = webhookConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "webhookConfigs"));
    }
    return this.setNewWebhookConfigLike(index, this.buildWebhookConfig(index));
  }
  
  public WechatConfigsNested<A> editLastWechatConfig() {
    int index = wechatConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "wechatConfigs"));
    }
    return this.setNewWechatConfigLike(index, this.buildWechatConfig(index));
  }
  
  public DiscordConfigsNested<A> editMatchingDiscordConfig(Predicate<DiscordConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < discordConfigs.size();i++) {
      if (predicate.test(discordConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "discordConfigs"));
    }
    return this.setNewDiscordConfigLike(index, this.buildDiscordConfig(index));
  }
  
  public EmailConfigsNested<A> editMatchingEmailConfig(Predicate<EmailConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < emailConfigs.size();i++) {
      if (predicate.test(emailConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "emailConfigs"));
    }
    return this.setNewEmailConfigLike(index, this.buildEmailConfig(index));
  }
  
  public MsteamsConfigsNested<A> editMatchingMsteamsConfig(Predicate<MSTeamsConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < msteamsConfigs.size();i++) {
      if (predicate.test(msteamsConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "msteamsConfigs"));
    }
    return this.setNewMsteamsConfigLike(index, this.buildMsteamsConfig(index));
  }
  
  public Msteamsv2ConfigsNested<A> editMatchingMsteamsv2Config(Predicate<MSTeamsV2ConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < msteamsv2Configs.size();i++) {
      if (predicate.test(msteamsv2Configs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "msteamsv2Configs"));
    }
    return this.setNewMsteamsv2ConfigLike(index, this.buildMsteamsv2Config(index));
  }
  
  public OpsgenieConfigsNested<A> editMatchingOpsgenieConfig(Predicate<OpsGenieConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < opsgenieConfigs.size();i++) {
      if (predicate.test(opsgenieConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "opsgenieConfigs"));
    }
    return this.setNewOpsgenieConfigLike(index, this.buildOpsgenieConfig(index));
  }
  
  public PagerdutyConfigsNested<A> editMatchingPagerdutyConfig(Predicate<PagerDutyConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pagerdutyConfigs.size();i++) {
      if (predicate.test(pagerdutyConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pagerdutyConfigs"));
    }
    return this.setNewPagerdutyConfigLike(index, this.buildPagerdutyConfig(index));
  }
  
  public PushoverConfigsNested<A> editMatchingPushoverConfig(Predicate<PushoverConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pushoverConfigs.size();i++) {
      if (predicate.test(pushoverConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pushoverConfigs"));
    }
    return this.setNewPushoverConfigLike(index, this.buildPushoverConfig(index));
  }
  
  public RocketchatConfigsNested<A> editMatchingRocketchatConfig(Predicate<RocketChatConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < rocketchatConfigs.size();i++) {
      if (predicate.test(rocketchatConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "rocketchatConfigs"));
    }
    return this.setNewRocketchatConfigLike(index, this.buildRocketchatConfig(index));
  }
  
  public SlackConfigsNested<A> editMatchingSlackConfig(Predicate<SlackConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < slackConfigs.size();i++) {
      if (predicate.test(slackConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "slackConfigs"));
    }
    return this.setNewSlackConfigLike(index, this.buildSlackConfig(index));
  }
  
  public SnsConfigsNested<A> editMatchingSnsConfig(Predicate<SNSConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < snsConfigs.size();i++) {
      if (predicate.test(snsConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "snsConfigs"));
    }
    return this.setNewSnsConfigLike(index, this.buildSnsConfig(index));
  }
  
  public TelegramConfigsNested<A> editMatchingTelegramConfig(Predicate<TelegramConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < telegramConfigs.size();i++) {
      if (predicate.test(telegramConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "telegramConfigs"));
    }
    return this.setNewTelegramConfigLike(index, this.buildTelegramConfig(index));
  }
  
  public VictoropsConfigsNested<A> editMatchingVictoropsConfig(Predicate<VictorOpsConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < victoropsConfigs.size();i++) {
      if (predicate.test(victoropsConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "victoropsConfigs"));
    }
    return this.setNewVictoropsConfigLike(index, this.buildVictoropsConfig(index));
  }
  
  public WebexConfigsNested<A> editMatchingWebexConfig(Predicate<WebexConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < webexConfigs.size();i++) {
      if (predicate.test(webexConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "webexConfigs"));
    }
    return this.setNewWebexConfigLike(index, this.buildWebexConfig(index));
  }
  
  public WebhookConfigsNested<A> editMatchingWebhookConfig(Predicate<WebhookConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < webhookConfigs.size();i++) {
      if (predicate.test(webhookConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "webhookConfigs"));
    }
    return this.setNewWebhookConfigLike(index, this.buildWebhookConfig(index));
  }
  
  public WechatConfigsNested<A> editMatchingWechatConfig(Predicate<WeChatConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < wechatConfigs.size();i++) {
      if (predicate.test(wechatConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "wechatConfigs"));
    }
    return this.setNewWechatConfigLike(index, this.buildWechatConfig(index));
  }
  
  public MsteamsConfigsNested<A> editMsteamsConfig(int index) {
    if (msteamsConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "msteamsConfigs"));
    }
    return this.setNewMsteamsConfigLike(index, this.buildMsteamsConfig(index));
  }
  
  public Msteamsv2ConfigsNested<A> editMsteamsv2Config(int index) {
    if (msteamsv2Configs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "msteamsv2Configs"));
    }
    return this.setNewMsteamsv2ConfigLike(index, this.buildMsteamsv2Config(index));
  }
  
  public OpsgenieConfigsNested<A> editOpsgenieConfig(int index) {
    if (opsgenieConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "opsgenieConfigs"));
    }
    return this.setNewOpsgenieConfigLike(index, this.buildOpsgenieConfig(index));
  }
  
  public PagerdutyConfigsNested<A> editPagerdutyConfig(int index) {
    if (pagerdutyConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pagerdutyConfigs"));
    }
    return this.setNewPagerdutyConfigLike(index, this.buildPagerdutyConfig(index));
  }
  
  public PushoverConfigsNested<A> editPushoverConfig(int index) {
    if (pushoverConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pushoverConfigs"));
    }
    return this.setNewPushoverConfigLike(index, this.buildPushoverConfig(index));
  }
  
  public RocketchatConfigsNested<A> editRocketchatConfig(int index) {
    if (rocketchatConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "rocketchatConfigs"));
    }
    return this.setNewRocketchatConfigLike(index, this.buildRocketchatConfig(index));
  }
  
  public SlackConfigsNested<A> editSlackConfig(int index) {
    if (slackConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "slackConfigs"));
    }
    return this.setNewSlackConfigLike(index, this.buildSlackConfig(index));
  }
  
  public SnsConfigsNested<A> editSnsConfig(int index) {
    if (snsConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "snsConfigs"));
    }
    return this.setNewSnsConfigLike(index, this.buildSnsConfig(index));
  }
  
  public TelegramConfigsNested<A> editTelegramConfig(int index) {
    if (telegramConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "telegramConfigs"));
    }
    return this.setNewTelegramConfigLike(index, this.buildTelegramConfig(index));
  }
  
  public VictoropsConfigsNested<A> editVictoropsConfig(int index) {
    if (victoropsConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "victoropsConfigs"));
    }
    return this.setNewVictoropsConfigLike(index, this.buildVictoropsConfig(index));
  }
  
  public WebexConfigsNested<A> editWebexConfig(int index) {
    if (webexConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "webexConfigs"));
    }
    return this.setNewWebexConfigLike(index, this.buildWebexConfig(index));
  }
  
  public WebhookConfigsNested<A> editWebhookConfig(int index) {
    if (webhookConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "webhookConfigs"));
    }
    return this.setNewWebhookConfigLike(index, this.buildWebhookConfig(index));
  }
  
  public WechatConfigsNested<A> editWechatConfig(int index) {
    if (wechatConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "wechatConfigs"));
    }
    return this.setNewWechatConfigLike(index, this.buildWechatConfig(index));
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
    ReceiverFluent that = (ReceiverFluent) o;
    if (!(Objects.equals(discordConfigs, that.discordConfigs))) {
      return false;
    }
    if (!(Objects.equals(emailConfigs, that.emailConfigs))) {
      return false;
    }
    if (!(Objects.equals(msteamsConfigs, that.msteamsConfigs))) {
      return false;
    }
    if (!(Objects.equals(msteamsv2Configs, that.msteamsv2Configs))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(opsgenieConfigs, that.opsgenieConfigs))) {
      return false;
    }
    if (!(Objects.equals(pagerdutyConfigs, that.pagerdutyConfigs))) {
      return false;
    }
    if (!(Objects.equals(pushoverConfigs, that.pushoverConfigs))) {
      return false;
    }
    if (!(Objects.equals(rocketchatConfigs, that.rocketchatConfigs))) {
      return false;
    }
    if (!(Objects.equals(slackConfigs, that.slackConfigs))) {
      return false;
    }
    if (!(Objects.equals(snsConfigs, that.snsConfigs))) {
      return false;
    }
    if (!(Objects.equals(telegramConfigs, that.telegramConfigs))) {
      return false;
    }
    if (!(Objects.equals(victoropsConfigs, that.victoropsConfigs))) {
      return false;
    }
    if (!(Objects.equals(webexConfigs, that.webexConfigs))) {
      return false;
    }
    if (!(Objects.equals(webhookConfigs, that.webhookConfigs))) {
      return false;
    }
    if (!(Objects.equals(wechatConfigs, that.wechatConfigs))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiscordConfigs() {
    return this.discordConfigs != null && !(this.discordConfigs.isEmpty());
  }
  
  public boolean hasEmailConfigs() {
    return this.emailConfigs != null && !(this.emailConfigs.isEmpty());
  }
  
  public boolean hasMatchingDiscordConfig(Predicate<DiscordConfigBuilder> predicate) {
      for (DiscordConfigBuilder item : discordConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEmailConfig(Predicate<EmailConfigBuilder> predicate) {
      for (EmailConfigBuilder item : emailConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMsteamsConfig(Predicate<MSTeamsConfigBuilder> predicate) {
      for (MSTeamsConfigBuilder item : msteamsConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMsteamsv2Config(Predicate<MSTeamsV2ConfigBuilder> predicate) {
      for (MSTeamsV2ConfigBuilder item : msteamsv2Configs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOpsgenieConfig(Predicate<OpsGenieConfigBuilder> predicate) {
      for (OpsGenieConfigBuilder item : opsgenieConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPagerdutyConfig(Predicate<PagerDutyConfigBuilder> predicate) {
      for (PagerDutyConfigBuilder item : pagerdutyConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPushoverConfig(Predicate<PushoverConfigBuilder> predicate) {
      for (PushoverConfigBuilder item : pushoverConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRocketchatConfig(Predicate<RocketChatConfigBuilder> predicate) {
      for (RocketChatConfigBuilder item : rocketchatConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSlackConfig(Predicate<SlackConfigBuilder> predicate) {
      for (SlackConfigBuilder item : slackConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSnsConfig(Predicate<SNSConfigBuilder> predicate) {
      for (SNSConfigBuilder item : snsConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTelegramConfig(Predicate<TelegramConfigBuilder> predicate) {
      for (TelegramConfigBuilder item : telegramConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVictoropsConfig(Predicate<VictorOpsConfigBuilder> predicate) {
      for (VictorOpsConfigBuilder item : victoropsConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWebexConfig(Predicate<WebexConfigBuilder> predicate) {
      for (WebexConfigBuilder item : webexConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWebhookConfig(Predicate<WebhookConfigBuilder> predicate) {
      for (WebhookConfigBuilder item : webhookConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWechatConfig(Predicate<WeChatConfigBuilder> predicate) {
      for (WeChatConfigBuilder item : wechatConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMsteamsConfigs() {
    return this.msteamsConfigs != null && !(this.msteamsConfigs.isEmpty());
  }
  
  public boolean hasMsteamsv2Configs() {
    return this.msteamsv2Configs != null && !(this.msteamsv2Configs.isEmpty());
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOpsgenieConfigs() {
    return this.opsgenieConfigs != null && !(this.opsgenieConfigs.isEmpty());
  }
  
  public boolean hasPagerdutyConfigs() {
    return this.pagerdutyConfigs != null && !(this.pagerdutyConfigs.isEmpty());
  }
  
  public boolean hasPushoverConfigs() {
    return this.pushoverConfigs != null && !(this.pushoverConfigs.isEmpty());
  }
  
  public boolean hasRocketchatConfigs() {
    return this.rocketchatConfigs != null && !(this.rocketchatConfigs.isEmpty());
  }
  
  public boolean hasSlackConfigs() {
    return this.slackConfigs != null && !(this.slackConfigs.isEmpty());
  }
  
  public boolean hasSnsConfigs() {
    return this.snsConfigs != null && !(this.snsConfigs.isEmpty());
  }
  
  public boolean hasTelegramConfigs() {
    return this.telegramConfigs != null && !(this.telegramConfigs.isEmpty());
  }
  
  public boolean hasVictoropsConfigs() {
    return this.victoropsConfigs != null && !(this.victoropsConfigs.isEmpty());
  }
  
  public boolean hasWebexConfigs() {
    return this.webexConfigs != null && !(this.webexConfigs.isEmpty());
  }
  
  public boolean hasWebhookConfigs() {
    return this.webhookConfigs != null && !(this.webhookConfigs.isEmpty());
  }
  
  public boolean hasWechatConfigs() {
    return this.wechatConfigs != null && !(this.wechatConfigs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(discordConfigs, emailConfigs, msteamsConfigs, msteamsv2Configs, name, opsgenieConfigs, pagerdutyConfigs, pushoverConfigs, rocketchatConfigs, slackConfigs, snsConfigs, telegramConfigs, victoropsConfigs, webexConfigs, webhookConfigs, wechatConfigs, additionalProperties);
  }
  
  public A removeAllFromDiscordConfigs(Collection<DiscordConfig> items) {
    if (this.discordConfigs == null) {
      return (A) this;
    }
    for (DiscordConfig item : items) {
        DiscordConfigBuilder builder = new DiscordConfigBuilder(item);
        _visitables.get("discordConfigs").remove(builder);
        this.discordConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEmailConfigs(Collection<EmailConfig> items) {
    if (this.emailConfigs == null) {
      return (A) this;
    }
    for (EmailConfig item : items) {
        EmailConfigBuilder builder = new EmailConfigBuilder(item);
        _visitables.get("emailConfigs").remove(builder);
        this.emailConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMsteamsConfigs(Collection<MSTeamsConfig> items) {
    if (this.msteamsConfigs == null) {
      return (A) this;
    }
    for (MSTeamsConfig item : items) {
        MSTeamsConfigBuilder builder = new MSTeamsConfigBuilder(item);
        _visitables.get("msteamsConfigs").remove(builder);
        this.msteamsConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMsteamsv2Configs(Collection<MSTeamsV2Config> items) {
    if (this.msteamsv2Configs == null) {
      return (A) this;
    }
    for (MSTeamsV2Config item : items) {
        MSTeamsV2ConfigBuilder builder = new MSTeamsV2ConfigBuilder(item);
        _visitables.get("msteamsv2Configs").remove(builder);
        this.msteamsv2Configs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOpsgenieConfigs(Collection<OpsGenieConfig> items) {
    if (this.opsgenieConfigs == null) {
      return (A) this;
    }
    for (OpsGenieConfig item : items) {
        OpsGenieConfigBuilder builder = new OpsGenieConfigBuilder(item);
        _visitables.get("opsgenieConfigs").remove(builder);
        this.opsgenieConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPagerdutyConfigs(Collection<PagerDutyConfig> items) {
    if (this.pagerdutyConfigs == null) {
      return (A) this;
    }
    for (PagerDutyConfig item : items) {
        PagerDutyConfigBuilder builder = new PagerDutyConfigBuilder(item);
        _visitables.get("pagerdutyConfigs").remove(builder);
        this.pagerdutyConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPushoverConfigs(Collection<PushoverConfig> items) {
    if (this.pushoverConfigs == null) {
      return (A) this;
    }
    for (PushoverConfig item : items) {
        PushoverConfigBuilder builder = new PushoverConfigBuilder(item);
        _visitables.get("pushoverConfigs").remove(builder);
        this.pushoverConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRocketchatConfigs(Collection<RocketChatConfig> items) {
    if (this.rocketchatConfigs == null) {
      return (A) this;
    }
    for (RocketChatConfig item : items) {
        RocketChatConfigBuilder builder = new RocketChatConfigBuilder(item);
        _visitables.get("rocketchatConfigs").remove(builder);
        this.rocketchatConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSlackConfigs(Collection<SlackConfig> items) {
    if (this.slackConfigs == null) {
      return (A) this;
    }
    for (SlackConfig item : items) {
        SlackConfigBuilder builder = new SlackConfigBuilder(item);
        _visitables.get("slackConfigs").remove(builder);
        this.slackConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSnsConfigs(Collection<SNSConfig> items) {
    if (this.snsConfigs == null) {
      return (A) this;
    }
    for (SNSConfig item : items) {
        SNSConfigBuilder builder = new SNSConfigBuilder(item);
        _visitables.get("snsConfigs").remove(builder);
        this.snsConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTelegramConfigs(Collection<TelegramConfig> items) {
    if (this.telegramConfigs == null) {
      return (A) this;
    }
    for (TelegramConfig item : items) {
        TelegramConfigBuilder builder = new TelegramConfigBuilder(item);
        _visitables.get("telegramConfigs").remove(builder);
        this.telegramConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVictoropsConfigs(Collection<VictorOpsConfig> items) {
    if (this.victoropsConfigs == null) {
      return (A) this;
    }
    for (VictorOpsConfig item : items) {
        VictorOpsConfigBuilder builder = new VictorOpsConfigBuilder(item);
        _visitables.get("victoropsConfigs").remove(builder);
        this.victoropsConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWebexConfigs(Collection<WebexConfig> items) {
    if (this.webexConfigs == null) {
      return (A) this;
    }
    for (WebexConfig item : items) {
        WebexConfigBuilder builder = new WebexConfigBuilder(item);
        _visitables.get("webexConfigs").remove(builder);
        this.webexConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWebhookConfigs(Collection<WebhookConfig> items) {
    if (this.webhookConfigs == null) {
      return (A) this;
    }
    for (WebhookConfig item : items) {
        WebhookConfigBuilder builder = new WebhookConfigBuilder(item);
        _visitables.get("webhookConfigs").remove(builder);
        this.webhookConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWechatConfigs(Collection<WeChatConfig> items) {
    if (this.wechatConfigs == null) {
      return (A) this;
    }
    for (WeChatConfig item : items) {
        WeChatConfigBuilder builder = new WeChatConfigBuilder(item);
        _visitables.get("wechatConfigs").remove(builder);
        this.wechatConfigs.remove(builder);
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
  
  public A removeFromDiscordConfigs(DiscordConfig... items) {
    if (this.discordConfigs == null) {
      return (A) this;
    }
    for (DiscordConfig item : items) {
        DiscordConfigBuilder builder = new DiscordConfigBuilder(item);
        _visitables.get("discordConfigs").remove(builder);
        this.discordConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEmailConfigs(EmailConfig... items) {
    if (this.emailConfigs == null) {
      return (A) this;
    }
    for (EmailConfig item : items) {
        EmailConfigBuilder builder = new EmailConfigBuilder(item);
        _visitables.get("emailConfigs").remove(builder);
        this.emailConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMsteamsConfigs(MSTeamsConfig... items) {
    if (this.msteamsConfigs == null) {
      return (A) this;
    }
    for (MSTeamsConfig item : items) {
        MSTeamsConfigBuilder builder = new MSTeamsConfigBuilder(item);
        _visitables.get("msteamsConfigs").remove(builder);
        this.msteamsConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMsteamsv2Configs(MSTeamsV2Config... items) {
    if (this.msteamsv2Configs == null) {
      return (A) this;
    }
    for (MSTeamsV2Config item : items) {
        MSTeamsV2ConfigBuilder builder = new MSTeamsV2ConfigBuilder(item);
        _visitables.get("msteamsv2Configs").remove(builder);
        this.msteamsv2Configs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOpsgenieConfigs(OpsGenieConfig... items) {
    if (this.opsgenieConfigs == null) {
      return (A) this;
    }
    for (OpsGenieConfig item : items) {
        OpsGenieConfigBuilder builder = new OpsGenieConfigBuilder(item);
        _visitables.get("opsgenieConfigs").remove(builder);
        this.opsgenieConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPagerdutyConfigs(PagerDutyConfig... items) {
    if (this.pagerdutyConfigs == null) {
      return (A) this;
    }
    for (PagerDutyConfig item : items) {
        PagerDutyConfigBuilder builder = new PagerDutyConfigBuilder(item);
        _visitables.get("pagerdutyConfigs").remove(builder);
        this.pagerdutyConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPushoverConfigs(PushoverConfig... items) {
    if (this.pushoverConfigs == null) {
      return (A) this;
    }
    for (PushoverConfig item : items) {
        PushoverConfigBuilder builder = new PushoverConfigBuilder(item);
        _visitables.get("pushoverConfigs").remove(builder);
        this.pushoverConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRocketchatConfigs(RocketChatConfig... items) {
    if (this.rocketchatConfigs == null) {
      return (A) this;
    }
    for (RocketChatConfig item : items) {
        RocketChatConfigBuilder builder = new RocketChatConfigBuilder(item);
        _visitables.get("rocketchatConfigs").remove(builder);
        this.rocketchatConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSlackConfigs(SlackConfig... items) {
    if (this.slackConfigs == null) {
      return (A) this;
    }
    for (SlackConfig item : items) {
        SlackConfigBuilder builder = new SlackConfigBuilder(item);
        _visitables.get("slackConfigs").remove(builder);
        this.slackConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSnsConfigs(SNSConfig... items) {
    if (this.snsConfigs == null) {
      return (A) this;
    }
    for (SNSConfig item : items) {
        SNSConfigBuilder builder = new SNSConfigBuilder(item);
        _visitables.get("snsConfigs").remove(builder);
        this.snsConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTelegramConfigs(TelegramConfig... items) {
    if (this.telegramConfigs == null) {
      return (A) this;
    }
    for (TelegramConfig item : items) {
        TelegramConfigBuilder builder = new TelegramConfigBuilder(item);
        _visitables.get("telegramConfigs").remove(builder);
        this.telegramConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVictoropsConfigs(VictorOpsConfig... items) {
    if (this.victoropsConfigs == null) {
      return (A) this;
    }
    for (VictorOpsConfig item : items) {
        VictorOpsConfigBuilder builder = new VictorOpsConfigBuilder(item);
        _visitables.get("victoropsConfigs").remove(builder);
        this.victoropsConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWebexConfigs(WebexConfig... items) {
    if (this.webexConfigs == null) {
      return (A) this;
    }
    for (WebexConfig item : items) {
        WebexConfigBuilder builder = new WebexConfigBuilder(item);
        _visitables.get("webexConfigs").remove(builder);
        this.webexConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWebhookConfigs(WebhookConfig... items) {
    if (this.webhookConfigs == null) {
      return (A) this;
    }
    for (WebhookConfig item : items) {
        WebhookConfigBuilder builder = new WebhookConfigBuilder(item);
        _visitables.get("webhookConfigs").remove(builder);
        this.webhookConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWechatConfigs(WeChatConfig... items) {
    if (this.wechatConfigs == null) {
      return (A) this;
    }
    for (WeChatConfig item : items) {
        WeChatConfigBuilder builder = new WeChatConfigBuilder(item);
        _visitables.get("wechatConfigs").remove(builder);
        this.wechatConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDiscordConfigs(Predicate<DiscordConfigBuilder> predicate) {
    if (discordConfigs == null) {
      return (A) this;
    }
    Iterator<DiscordConfigBuilder> each = discordConfigs.iterator();
    List visitables = _visitables.get("discordConfigs");
    while (each.hasNext()) {
        DiscordConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromEmailConfigs(Predicate<EmailConfigBuilder> predicate) {
    if (emailConfigs == null) {
      return (A) this;
    }
    Iterator<EmailConfigBuilder> each = emailConfigs.iterator();
    List visitables = _visitables.get("emailConfigs");
    while (each.hasNext()) {
        EmailConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMsteamsConfigs(Predicate<MSTeamsConfigBuilder> predicate) {
    if (msteamsConfigs == null) {
      return (A) this;
    }
    Iterator<MSTeamsConfigBuilder> each = msteamsConfigs.iterator();
    List visitables = _visitables.get("msteamsConfigs");
    while (each.hasNext()) {
        MSTeamsConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMsteamsv2Configs(Predicate<MSTeamsV2ConfigBuilder> predicate) {
    if (msteamsv2Configs == null) {
      return (A) this;
    }
    Iterator<MSTeamsV2ConfigBuilder> each = msteamsv2Configs.iterator();
    List visitables = _visitables.get("msteamsv2Configs");
    while (each.hasNext()) {
        MSTeamsV2ConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOpsgenieConfigs(Predicate<OpsGenieConfigBuilder> predicate) {
    if (opsgenieConfigs == null) {
      return (A) this;
    }
    Iterator<OpsGenieConfigBuilder> each = opsgenieConfigs.iterator();
    List visitables = _visitables.get("opsgenieConfigs");
    while (each.hasNext()) {
        OpsGenieConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPagerdutyConfigs(Predicate<PagerDutyConfigBuilder> predicate) {
    if (pagerdutyConfigs == null) {
      return (A) this;
    }
    Iterator<PagerDutyConfigBuilder> each = pagerdutyConfigs.iterator();
    List visitables = _visitables.get("pagerdutyConfigs");
    while (each.hasNext()) {
        PagerDutyConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPushoverConfigs(Predicate<PushoverConfigBuilder> predicate) {
    if (pushoverConfigs == null) {
      return (A) this;
    }
    Iterator<PushoverConfigBuilder> each = pushoverConfigs.iterator();
    List visitables = _visitables.get("pushoverConfigs");
    while (each.hasNext()) {
        PushoverConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRocketchatConfigs(Predicate<RocketChatConfigBuilder> predicate) {
    if (rocketchatConfigs == null) {
      return (A) this;
    }
    Iterator<RocketChatConfigBuilder> each = rocketchatConfigs.iterator();
    List visitables = _visitables.get("rocketchatConfigs");
    while (each.hasNext()) {
        RocketChatConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSlackConfigs(Predicate<SlackConfigBuilder> predicate) {
    if (slackConfigs == null) {
      return (A) this;
    }
    Iterator<SlackConfigBuilder> each = slackConfigs.iterator();
    List visitables = _visitables.get("slackConfigs");
    while (each.hasNext()) {
        SlackConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSnsConfigs(Predicate<SNSConfigBuilder> predicate) {
    if (snsConfigs == null) {
      return (A) this;
    }
    Iterator<SNSConfigBuilder> each = snsConfigs.iterator();
    List visitables = _visitables.get("snsConfigs");
    while (each.hasNext()) {
        SNSConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTelegramConfigs(Predicate<TelegramConfigBuilder> predicate) {
    if (telegramConfigs == null) {
      return (A) this;
    }
    Iterator<TelegramConfigBuilder> each = telegramConfigs.iterator();
    List visitables = _visitables.get("telegramConfigs");
    while (each.hasNext()) {
        TelegramConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVictoropsConfigs(Predicate<VictorOpsConfigBuilder> predicate) {
    if (victoropsConfigs == null) {
      return (A) this;
    }
    Iterator<VictorOpsConfigBuilder> each = victoropsConfigs.iterator();
    List visitables = _visitables.get("victoropsConfigs");
    while (each.hasNext()) {
        VictorOpsConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWebexConfigs(Predicate<WebexConfigBuilder> predicate) {
    if (webexConfigs == null) {
      return (A) this;
    }
    Iterator<WebexConfigBuilder> each = webexConfigs.iterator();
    List visitables = _visitables.get("webexConfigs");
    while (each.hasNext()) {
        WebexConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWebhookConfigs(Predicate<WebhookConfigBuilder> predicate) {
    if (webhookConfigs == null) {
      return (A) this;
    }
    Iterator<WebhookConfigBuilder> each = webhookConfigs.iterator();
    List visitables = _visitables.get("webhookConfigs");
    while (each.hasNext()) {
        WebhookConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWechatConfigs(Predicate<WeChatConfigBuilder> predicate) {
    if (wechatConfigs == null) {
      return (A) this;
    }
    Iterator<WeChatConfigBuilder> each = wechatConfigs.iterator();
    List visitables = _visitables.get("wechatConfigs");
    while (each.hasNext()) {
        WeChatConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DiscordConfigsNested<A> setNewDiscordConfigLike(int index,DiscordConfig item) {
    return new DiscordConfigsNested(index, item);
  }
  
  public EmailConfigsNested<A> setNewEmailConfigLike(int index,EmailConfig item) {
    return new EmailConfigsNested(index, item);
  }
  
  public MsteamsConfigsNested<A> setNewMsteamsConfigLike(int index,MSTeamsConfig item) {
    return new MsteamsConfigsNested(index, item);
  }
  
  public Msteamsv2ConfigsNested<A> setNewMsteamsv2ConfigLike(int index,MSTeamsV2Config item) {
    return new Msteamsv2ConfigsNested(index, item);
  }
  
  public OpsgenieConfigsNested<A> setNewOpsgenieConfigLike(int index,OpsGenieConfig item) {
    return new OpsgenieConfigsNested(index, item);
  }
  
  public PagerdutyConfigsNested<A> setNewPagerdutyConfigLike(int index,PagerDutyConfig item) {
    return new PagerdutyConfigsNested(index, item);
  }
  
  public PushoverConfigsNested<A> setNewPushoverConfigLike(int index,PushoverConfig item) {
    return new PushoverConfigsNested(index, item);
  }
  
  public RocketchatConfigsNested<A> setNewRocketchatConfigLike(int index,RocketChatConfig item) {
    return new RocketchatConfigsNested(index, item);
  }
  
  public SlackConfigsNested<A> setNewSlackConfigLike(int index,SlackConfig item) {
    return new SlackConfigsNested(index, item);
  }
  
  public SnsConfigsNested<A> setNewSnsConfigLike(int index,SNSConfig item) {
    return new SnsConfigsNested(index, item);
  }
  
  public TelegramConfigsNested<A> setNewTelegramConfigLike(int index,TelegramConfig item) {
    return new TelegramConfigsNested(index, item);
  }
  
  public VictoropsConfigsNested<A> setNewVictoropsConfigLike(int index,VictorOpsConfig item) {
    return new VictoropsConfigsNested(index, item);
  }
  
  public WebexConfigsNested<A> setNewWebexConfigLike(int index,WebexConfig item) {
    return new WebexConfigsNested(index, item);
  }
  
  public WebhookConfigsNested<A> setNewWebhookConfigLike(int index,WebhookConfig item) {
    return new WebhookConfigsNested(index, item);
  }
  
  public WechatConfigsNested<A> setNewWechatConfigLike(int index,WeChatConfig item) {
    return new WechatConfigsNested(index, item);
  }
  
  public A setToDiscordConfigs(int index,DiscordConfig item) {
    if (this.discordConfigs == null) {
      this.discordConfigs = new ArrayList();
    }
    DiscordConfigBuilder builder = new DiscordConfigBuilder(item);
    if (index < 0 || index >= discordConfigs.size()) {
        _visitables.get("discordConfigs").add(builder);
        discordConfigs.add(builder);
    } else {
        _visitables.get("discordConfigs").add(builder);
        discordConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEmailConfigs(int index,EmailConfig item) {
    if (this.emailConfigs == null) {
      this.emailConfigs = new ArrayList();
    }
    EmailConfigBuilder builder = new EmailConfigBuilder(item);
    if (index < 0 || index >= emailConfigs.size()) {
        _visitables.get("emailConfigs").add(builder);
        emailConfigs.add(builder);
    } else {
        _visitables.get("emailConfigs").add(builder);
        emailConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMsteamsConfigs(int index,MSTeamsConfig item) {
    if (this.msteamsConfigs == null) {
      this.msteamsConfigs = new ArrayList();
    }
    MSTeamsConfigBuilder builder = new MSTeamsConfigBuilder(item);
    if (index < 0 || index >= msteamsConfigs.size()) {
        _visitables.get("msteamsConfigs").add(builder);
        msteamsConfigs.add(builder);
    } else {
        _visitables.get("msteamsConfigs").add(builder);
        msteamsConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMsteamsv2Configs(int index,MSTeamsV2Config item) {
    if (this.msteamsv2Configs == null) {
      this.msteamsv2Configs = new ArrayList();
    }
    MSTeamsV2ConfigBuilder builder = new MSTeamsV2ConfigBuilder(item);
    if (index < 0 || index >= msteamsv2Configs.size()) {
        _visitables.get("msteamsv2Configs").add(builder);
        msteamsv2Configs.add(builder);
    } else {
        _visitables.get("msteamsv2Configs").add(builder);
        msteamsv2Configs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOpsgenieConfigs(int index,OpsGenieConfig item) {
    if (this.opsgenieConfigs == null) {
      this.opsgenieConfigs = new ArrayList();
    }
    OpsGenieConfigBuilder builder = new OpsGenieConfigBuilder(item);
    if (index < 0 || index >= opsgenieConfigs.size()) {
        _visitables.get("opsgenieConfigs").add(builder);
        opsgenieConfigs.add(builder);
    } else {
        _visitables.get("opsgenieConfigs").add(builder);
        opsgenieConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPagerdutyConfigs(int index,PagerDutyConfig item) {
    if (this.pagerdutyConfigs == null) {
      this.pagerdutyConfigs = new ArrayList();
    }
    PagerDutyConfigBuilder builder = new PagerDutyConfigBuilder(item);
    if (index < 0 || index >= pagerdutyConfigs.size()) {
        _visitables.get("pagerdutyConfigs").add(builder);
        pagerdutyConfigs.add(builder);
    } else {
        _visitables.get("pagerdutyConfigs").add(builder);
        pagerdutyConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPushoverConfigs(int index,PushoverConfig item) {
    if (this.pushoverConfigs == null) {
      this.pushoverConfigs = new ArrayList();
    }
    PushoverConfigBuilder builder = new PushoverConfigBuilder(item);
    if (index < 0 || index >= pushoverConfigs.size()) {
        _visitables.get("pushoverConfigs").add(builder);
        pushoverConfigs.add(builder);
    } else {
        _visitables.get("pushoverConfigs").add(builder);
        pushoverConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRocketchatConfigs(int index,RocketChatConfig item) {
    if (this.rocketchatConfigs == null) {
      this.rocketchatConfigs = new ArrayList();
    }
    RocketChatConfigBuilder builder = new RocketChatConfigBuilder(item);
    if (index < 0 || index >= rocketchatConfigs.size()) {
        _visitables.get("rocketchatConfigs").add(builder);
        rocketchatConfigs.add(builder);
    } else {
        _visitables.get("rocketchatConfigs").add(builder);
        rocketchatConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSlackConfigs(int index,SlackConfig item) {
    if (this.slackConfigs == null) {
      this.slackConfigs = new ArrayList();
    }
    SlackConfigBuilder builder = new SlackConfigBuilder(item);
    if (index < 0 || index >= slackConfigs.size()) {
        _visitables.get("slackConfigs").add(builder);
        slackConfigs.add(builder);
    } else {
        _visitables.get("slackConfigs").add(builder);
        slackConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSnsConfigs(int index,SNSConfig item) {
    if (this.snsConfigs == null) {
      this.snsConfigs = new ArrayList();
    }
    SNSConfigBuilder builder = new SNSConfigBuilder(item);
    if (index < 0 || index >= snsConfigs.size()) {
        _visitables.get("snsConfigs").add(builder);
        snsConfigs.add(builder);
    } else {
        _visitables.get("snsConfigs").add(builder);
        snsConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTelegramConfigs(int index,TelegramConfig item) {
    if (this.telegramConfigs == null) {
      this.telegramConfigs = new ArrayList();
    }
    TelegramConfigBuilder builder = new TelegramConfigBuilder(item);
    if (index < 0 || index >= telegramConfigs.size()) {
        _visitables.get("telegramConfigs").add(builder);
        telegramConfigs.add(builder);
    } else {
        _visitables.get("telegramConfigs").add(builder);
        telegramConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVictoropsConfigs(int index,VictorOpsConfig item) {
    if (this.victoropsConfigs == null) {
      this.victoropsConfigs = new ArrayList();
    }
    VictorOpsConfigBuilder builder = new VictorOpsConfigBuilder(item);
    if (index < 0 || index >= victoropsConfigs.size()) {
        _visitables.get("victoropsConfigs").add(builder);
        victoropsConfigs.add(builder);
    } else {
        _visitables.get("victoropsConfigs").add(builder);
        victoropsConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWebexConfigs(int index,WebexConfig item) {
    if (this.webexConfigs == null) {
      this.webexConfigs = new ArrayList();
    }
    WebexConfigBuilder builder = new WebexConfigBuilder(item);
    if (index < 0 || index >= webexConfigs.size()) {
        _visitables.get("webexConfigs").add(builder);
        webexConfigs.add(builder);
    } else {
        _visitables.get("webexConfigs").add(builder);
        webexConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWebhookConfigs(int index,WebhookConfig item) {
    if (this.webhookConfigs == null) {
      this.webhookConfigs = new ArrayList();
    }
    WebhookConfigBuilder builder = new WebhookConfigBuilder(item);
    if (index < 0 || index >= webhookConfigs.size()) {
        _visitables.get("webhookConfigs").add(builder);
        webhookConfigs.add(builder);
    } else {
        _visitables.get("webhookConfigs").add(builder);
        webhookConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWechatConfigs(int index,WeChatConfig item) {
    if (this.wechatConfigs == null) {
      this.wechatConfigs = new ArrayList();
    }
    WeChatConfigBuilder builder = new WeChatConfigBuilder(item);
    if (index < 0 || index >= wechatConfigs.size()) {
        _visitables.get("wechatConfigs").add(builder);
        wechatConfigs.add(builder);
    } else {
        _visitables.get("wechatConfigs").add(builder);
        wechatConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(discordConfigs == null) && !(discordConfigs.isEmpty())) {
        sb.append("discordConfigs:");
        sb.append(discordConfigs);
        sb.append(",");
    }
    if (!(emailConfigs == null) && !(emailConfigs.isEmpty())) {
        sb.append("emailConfigs:");
        sb.append(emailConfigs);
        sb.append(",");
    }
    if (!(msteamsConfigs == null) && !(msteamsConfigs.isEmpty())) {
        sb.append("msteamsConfigs:");
        sb.append(msteamsConfigs);
        sb.append(",");
    }
    if (!(msteamsv2Configs == null) && !(msteamsv2Configs.isEmpty())) {
        sb.append("msteamsv2Configs:");
        sb.append(msteamsv2Configs);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(opsgenieConfigs == null) && !(opsgenieConfigs.isEmpty())) {
        sb.append("opsgenieConfigs:");
        sb.append(opsgenieConfigs);
        sb.append(",");
    }
    if (!(pagerdutyConfigs == null) && !(pagerdutyConfigs.isEmpty())) {
        sb.append("pagerdutyConfigs:");
        sb.append(pagerdutyConfigs);
        sb.append(",");
    }
    if (!(pushoverConfigs == null) && !(pushoverConfigs.isEmpty())) {
        sb.append("pushoverConfigs:");
        sb.append(pushoverConfigs);
        sb.append(",");
    }
    if (!(rocketchatConfigs == null) && !(rocketchatConfigs.isEmpty())) {
        sb.append("rocketchatConfigs:");
        sb.append(rocketchatConfigs);
        sb.append(",");
    }
    if (!(slackConfigs == null) && !(slackConfigs.isEmpty())) {
        sb.append("slackConfigs:");
        sb.append(slackConfigs);
        sb.append(",");
    }
    if (!(snsConfigs == null) && !(snsConfigs.isEmpty())) {
        sb.append("snsConfigs:");
        sb.append(snsConfigs);
        sb.append(",");
    }
    if (!(telegramConfigs == null) && !(telegramConfigs.isEmpty())) {
        sb.append("telegramConfigs:");
        sb.append(telegramConfigs);
        sb.append(",");
    }
    if (!(victoropsConfigs == null) && !(victoropsConfigs.isEmpty())) {
        sb.append("victoropsConfigs:");
        sb.append(victoropsConfigs);
        sb.append(",");
    }
    if (!(webexConfigs == null) && !(webexConfigs.isEmpty())) {
        sb.append("webexConfigs:");
        sb.append(webexConfigs);
        sb.append(",");
    }
    if (!(webhookConfigs == null) && !(webhookConfigs.isEmpty())) {
        sb.append("webhookConfigs:");
        sb.append(webhookConfigs);
        sb.append(",");
    }
    if (!(wechatConfigs == null) && !(wechatConfigs.isEmpty())) {
        sb.append("wechatConfigs:");
        sb.append(wechatConfigs);
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
  
  public A withDiscordConfigs(List<DiscordConfig> discordConfigs) {
    if (this.discordConfigs != null) {
      this._visitables.get("discordConfigs").clear();
    }
    if (discordConfigs != null) {
        this.discordConfigs = new ArrayList();
        for (DiscordConfig item : discordConfigs) {
          this.addToDiscordConfigs(item);
        }
    } else {
      this.discordConfigs = null;
    }
    return (A) this;
  }
  
  public A withDiscordConfigs(DiscordConfig... discordConfigs) {
    if (this.discordConfigs != null) {
        this.discordConfigs.clear();
        _visitables.remove("discordConfigs");
    }
    if (discordConfigs != null) {
      for (DiscordConfig item : discordConfigs) {
        this.addToDiscordConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withEmailConfigs(List<EmailConfig> emailConfigs) {
    if (this.emailConfigs != null) {
      this._visitables.get("emailConfigs").clear();
    }
    if (emailConfigs != null) {
        this.emailConfigs = new ArrayList();
        for (EmailConfig item : emailConfigs) {
          this.addToEmailConfigs(item);
        }
    } else {
      this.emailConfigs = null;
    }
    return (A) this;
  }
  
  public A withEmailConfigs(EmailConfig... emailConfigs) {
    if (this.emailConfigs != null) {
        this.emailConfigs.clear();
        _visitables.remove("emailConfigs");
    }
    if (emailConfigs != null) {
      for (EmailConfig item : emailConfigs) {
        this.addToEmailConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withMsteamsConfigs(List<MSTeamsConfig> msteamsConfigs) {
    if (this.msteamsConfigs != null) {
      this._visitables.get("msteamsConfigs").clear();
    }
    if (msteamsConfigs != null) {
        this.msteamsConfigs = new ArrayList();
        for (MSTeamsConfig item : msteamsConfigs) {
          this.addToMsteamsConfigs(item);
        }
    } else {
      this.msteamsConfigs = null;
    }
    return (A) this;
  }
  
  public A withMsteamsConfigs(MSTeamsConfig... msteamsConfigs) {
    if (this.msteamsConfigs != null) {
        this.msteamsConfigs.clear();
        _visitables.remove("msteamsConfigs");
    }
    if (msteamsConfigs != null) {
      for (MSTeamsConfig item : msteamsConfigs) {
        this.addToMsteamsConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withMsteamsv2Configs(List<MSTeamsV2Config> msteamsv2Configs) {
    if (this.msteamsv2Configs != null) {
      this._visitables.get("msteamsv2Configs").clear();
    }
    if (msteamsv2Configs != null) {
        this.msteamsv2Configs = new ArrayList();
        for (MSTeamsV2Config item : msteamsv2Configs) {
          this.addToMsteamsv2Configs(item);
        }
    } else {
      this.msteamsv2Configs = null;
    }
    return (A) this;
  }
  
  public A withMsteamsv2Configs(MSTeamsV2Config... msteamsv2Configs) {
    if (this.msteamsv2Configs != null) {
        this.msteamsv2Configs.clear();
        _visitables.remove("msteamsv2Configs");
    }
    if (msteamsv2Configs != null) {
      for (MSTeamsV2Config item : msteamsv2Configs) {
        this.addToMsteamsv2Configs(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withOpsgenieConfigs(List<OpsGenieConfig> opsgenieConfigs) {
    if (this.opsgenieConfigs != null) {
      this._visitables.get("opsgenieConfigs").clear();
    }
    if (opsgenieConfigs != null) {
        this.opsgenieConfigs = new ArrayList();
        for (OpsGenieConfig item : opsgenieConfigs) {
          this.addToOpsgenieConfigs(item);
        }
    } else {
      this.opsgenieConfigs = null;
    }
    return (A) this;
  }
  
  public A withOpsgenieConfigs(OpsGenieConfig... opsgenieConfigs) {
    if (this.opsgenieConfigs != null) {
        this.opsgenieConfigs.clear();
        _visitables.remove("opsgenieConfigs");
    }
    if (opsgenieConfigs != null) {
      for (OpsGenieConfig item : opsgenieConfigs) {
        this.addToOpsgenieConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withPagerdutyConfigs(List<PagerDutyConfig> pagerdutyConfigs) {
    if (this.pagerdutyConfigs != null) {
      this._visitables.get("pagerdutyConfigs").clear();
    }
    if (pagerdutyConfigs != null) {
        this.pagerdutyConfigs = new ArrayList();
        for (PagerDutyConfig item : pagerdutyConfigs) {
          this.addToPagerdutyConfigs(item);
        }
    } else {
      this.pagerdutyConfigs = null;
    }
    return (A) this;
  }
  
  public A withPagerdutyConfigs(PagerDutyConfig... pagerdutyConfigs) {
    if (this.pagerdutyConfigs != null) {
        this.pagerdutyConfigs.clear();
        _visitables.remove("pagerdutyConfigs");
    }
    if (pagerdutyConfigs != null) {
      for (PagerDutyConfig item : pagerdutyConfigs) {
        this.addToPagerdutyConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withPushoverConfigs(List<PushoverConfig> pushoverConfigs) {
    if (this.pushoverConfigs != null) {
      this._visitables.get("pushoverConfigs").clear();
    }
    if (pushoverConfigs != null) {
        this.pushoverConfigs = new ArrayList();
        for (PushoverConfig item : pushoverConfigs) {
          this.addToPushoverConfigs(item);
        }
    } else {
      this.pushoverConfigs = null;
    }
    return (A) this;
  }
  
  public A withPushoverConfigs(PushoverConfig... pushoverConfigs) {
    if (this.pushoverConfigs != null) {
        this.pushoverConfigs.clear();
        _visitables.remove("pushoverConfigs");
    }
    if (pushoverConfigs != null) {
      for (PushoverConfig item : pushoverConfigs) {
        this.addToPushoverConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withRocketchatConfigs(List<RocketChatConfig> rocketchatConfigs) {
    if (this.rocketchatConfigs != null) {
      this._visitables.get("rocketchatConfigs").clear();
    }
    if (rocketchatConfigs != null) {
        this.rocketchatConfigs = new ArrayList();
        for (RocketChatConfig item : rocketchatConfigs) {
          this.addToRocketchatConfigs(item);
        }
    } else {
      this.rocketchatConfigs = null;
    }
    return (A) this;
  }
  
  public A withRocketchatConfigs(RocketChatConfig... rocketchatConfigs) {
    if (this.rocketchatConfigs != null) {
        this.rocketchatConfigs.clear();
        _visitables.remove("rocketchatConfigs");
    }
    if (rocketchatConfigs != null) {
      for (RocketChatConfig item : rocketchatConfigs) {
        this.addToRocketchatConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withSlackConfigs(List<SlackConfig> slackConfigs) {
    if (this.slackConfigs != null) {
      this._visitables.get("slackConfigs").clear();
    }
    if (slackConfigs != null) {
        this.slackConfigs = new ArrayList();
        for (SlackConfig item : slackConfigs) {
          this.addToSlackConfigs(item);
        }
    } else {
      this.slackConfigs = null;
    }
    return (A) this;
  }
  
  public A withSlackConfigs(SlackConfig... slackConfigs) {
    if (this.slackConfigs != null) {
        this.slackConfigs.clear();
        _visitables.remove("slackConfigs");
    }
    if (slackConfigs != null) {
      for (SlackConfig item : slackConfigs) {
        this.addToSlackConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withSnsConfigs(List<SNSConfig> snsConfigs) {
    if (this.snsConfigs != null) {
      this._visitables.get("snsConfigs").clear();
    }
    if (snsConfigs != null) {
        this.snsConfigs = new ArrayList();
        for (SNSConfig item : snsConfigs) {
          this.addToSnsConfigs(item);
        }
    } else {
      this.snsConfigs = null;
    }
    return (A) this;
  }
  
  public A withSnsConfigs(SNSConfig... snsConfigs) {
    if (this.snsConfigs != null) {
        this.snsConfigs.clear();
        _visitables.remove("snsConfigs");
    }
    if (snsConfigs != null) {
      for (SNSConfig item : snsConfigs) {
        this.addToSnsConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withTelegramConfigs(List<TelegramConfig> telegramConfigs) {
    if (this.telegramConfigs != null) {
      this._visitables.get("telegramConfigs").clear();
    }
    if (telegramConfigs != null) {
        this.telegramConfigs = new ArrayList();
        for (TelegramConfig item : telegramConfigs) {
          this.addToTelegramConfigs(item);
        }
    } else {
      this.telegramConfigs = null;
    }
    return (A) this;
  }
  
  public A withTelegramConfigs(TelegramConfig... telegramConfigs) {
    if (this.telegramConfigs != null) {
        this.telegramConfigs.clear();
        _visitables.remove("telegramConfigs");
    }
    if (telegramConfigs != null) {
      for (TelegramConfig item : telegramConfigs) {
        this.addToTelegramConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withVictoropsConfigs(List<VictorOpsConfig> victoropsConfigs) {
    if (this.victoropsConfigs != null) {
      this._visitables.get("victoropsConfigs").clear();
    }
    if (victoropsConfigs != null) {
        this.victoropsConfigs = new ArrayList();
        for (VictorOpsConfig item : victoropsConfigs) {
          this.addToVictoropsConfigs(item);
        }
    } else {
      this.victoropsConfigs = null;
    }
    return (A) this;
  }
  
  public A withVictoropsConfigs(VictorOpsConfig... victoropsConfigs) {
    if (this.victoropsConfigs != null) {
        this.victoropsConfigs.clear();
        _visitables.remove("victoropsConfigs");
    }
    if (victoropsConfigs != null) {
      for (VictorOpsConfig item : victoropsConfigs) {
        this.addToVictoropsConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withWebexConfigs(List<WebexConfig> webexConfigs) {
    if (this.webexConfigs != null) {
      this._visitables.get("webexConfigs").clear();
    }
    if (webexConfigs != null) {
        this.webexConfigs = new ArrayList();
        for (WebexConfig item : webexConfigs) {
          this.addToWebexConfigs(item);
        }
    } else {
      this.webexConfigs = null;
    }
    return (A) this;
  }
  
  public A withWebexConfigs(WebexConfig... webexConfigs) {
    if (this.webexConfigs != null) {
        this.webexConfigs.clear();
        _visitables.remove("webexConfigs");
    }
    if (webexConfigs != null) {
      for (WebexConfig item : webexConfigs) {
        this.addToWebexConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withWebhookConfigs(List<WebhookConfig> webhookConfigs) {
    if (this.webhookConfigs != null) {
      this._visitables.get("webhookConfigs").clear();
    }
    if (webhookConfigs != null) {
        this.webhookConfigs = new ArrayList();
        for (WebhookConfig item : webhookConfigs) {
          this.addToWebhookConfigs(item);
        }
    } else {
      this.webhookConfigs = null;
    }
    return (A) this;
  }
  
  public A withWebhookConfigs(WebhookConfig... webhookConfigs) {
    if (this.webhookConfigs != null) {
        this.webhookConfigs.clear();
        _visitables.remove("webhookConfigs");
    }
    if (webhookConfigs != null) {
      for (WebhookConfig item : webhookConfigs) {
        this.addToWebhookConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withWechatConfigs(List<WeChatConfig> wechatConfigs) {
    if (this.wechatConfigs != null) {
      this._visitables.get("wechatConfigs").clear();
    }
    if (wechatConfigs != null) {
        this.wechatConfigs = new ArrayList();
        for (WeChatConfig item : wechatConfigs) {
          this.addToWechatConfigs(item);
        }
    } else {
      this.wechatConfigs = null;
    }
    return (A) this;
  }
  
  public A withWechatConfigs(WeChatConfig... wechatConfigs) {
    if (this.wechatConfigs != null) {
        this.wechatConfigs.clear();
        _visitables.remove("wechatConfigs");
    }
    if (wechatConfigs != null) {
      for (WeChatConfig item : wechatConfigs) {
        this.addToWechatConfigs(item);
      }
    }
    return (A) this;
  }
  public class DiscordConfigsNested<N> extends DiscordConfigFluent<DiscordConfigsNested<N>> implements Nested<N>{
  
    DiscordConfigBuilder builder;
    int index;
  
    DiscordConfigsNested(int index,DiscordConfig item) {
      this.index = index;
      this.builder = new DiscordConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToDiscordConfigs(index, builder.build());
    }
    
    public N endDiscordConfig() {
      return and();
    }
    
  }
  public class EmailConfigsNested<N> extends EmailConfigFluent<EmailConfigsNested<N>> implements Nested<N>{
  
    EmailConfigBuilder builder;
    int index;
  
    EmailConfigsNested(int index,EmailConfig item) {
      this.index = index;
      this.builder = new EmailConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToEmailConfigs(index, builder.build());
    }
    
    public N endEmailConfig() {
      return and();
    }
    
  }
  public class MsteamsConfigsNested<N> extends MSTeamsConfigFluent<MsteamsConfigsNested<N>> implements Nested<N>{
  
    MSTeamsConfigBuilder builder;
    int index;
  
    MsteamsConfigsNested(int index,MSTeamsConfig item) {
      this.index = index;
      this.builder = new MSTeamsConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToMsteamsConfigs(index, builder.build());
    }
    
    public N endMsteamsConfig() {
      return and();
    }
    
  }
  public class Msteamsv2ConfigsNested<N> extends MSTeamsV2ConfigFluent<Msteamsv2ConfigsNested<N>> implements Nested<N>{
  
    MSTeamsV2ConfigBuilder builder;
    int index;
  
    Msteamsv2ConfigsNested(int index,MSTeamsV2Config item) {
      this.index = index;
      this.builder = new MSTeamsV2ConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToMsteamsv2Configs(index, builder.build());
    }
    
    public N endMsteamsv2Config() {
      return and();
    }
    
  }
  public class OpsgenieConfigsNested<N> extends OpsGenieConfigFluent<OpsgenieConfigsNested<N>> implements Nested<N>{
  
    OpsGenieConfigBuilder builder;
    int index;
  
    OpsgenieConfigsNested(int index,OpsGenieConfig item) {
      this.index = index;
      this.builder = new OpsGenieConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToOpsgenieConfigs(index, builder.build());
    }
    
    public N endOpsgenieConfig() {
      return and();
    }
    
  }
  public class PagerdutyConfigsNested<N> extends PagerDutyConfigFluent<PagerdutyConfigsNested<N>> implements Nested<N>{
  
    PagerDutyConfigBuilder builder;
    int index;
  
    PagerdutyConfigsNested(int index,PagerDutyConfig item) {
      this.index = index;
      this.builder = new PagerDutyConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToPagerdutyConfigs(index, builder.build());
    }
    
    public N endPagerdutyConfig() {
      return and();
    }
    
  }
  public class PushoverConfigsNested<N> extends PushoverConfigFluent<PushoverConfigsNested<N>> implements Nested<N>{
  
    PushoverConfigBuilder builder;
    int index;
  
    PushoverConfigsNested(int index,PushoverConfig item) {
      this.index = index;
      this.builder = new PushoverConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToPushoverConfigs(index, builder.build());
    }
    
    public N endPushoverConfig() {
      return and();
    }
    
  }
  public class RocketchatConfigsNested<N> extends RocketChatConfigFluent<RocketchatConfigsNested<N>> implements Nested<N>{
  
    RocketChatConfigBuilder builder;
    int index;
  
    RocketchatConfigsNested(int index,RocketChatConfig item) {
      this.index = index;
      this.builder = new RocketChatConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToRocketchatConfigs(index, builder.build());
    }
    
    public N endRocketchatConfig() {
      return and();
    }
    
  }
  public class SlackConfigsNested<N> extends SlackConfigFluent<SlackConfigsNested<N>> implements Nested<N>{
  
    SlackConfigBuilder builder;
    int index;
  
    SlackConfigsNested(int index,SlackConfig item) {
      this.index = index;
      this.builder = new SlackConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToSlackConfigs(index, builder.build());
    }
    
    public N endSlackConfig() {
      return and();
    }
    
  }
  public class SnsConfigsNested<N> extends SNSConfigFluent<SnsConfigsNested<N>> implements Nested<N>{
  
    SNSConfigBuilder builder;
    int index;
  
    SnsConfigsNested(int index,SNSConfig item) {
      this.index = index;
      this.builder = new SNSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToSnsConfigs(index, builder.build());
    }
    
    public N endSnsConfig() {
      return and();
    }
    
  }
  public class TelegramConfigsNested<N> extends TelegramConfigFluent<TelegramConfigsNested<N>> implements Nested<N>{
  
    TelegramConfigBuilder builder;
    int index;
  
    TelegramConfigsNested(int index,TelegramConfig item) {
      this.index = index;
      this.builder = new TelegramConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToTelegramConfigs(index, builder.build());
    }
    
    public N endTelegramConfig() {
      return and();
    }
    
  }
  public class VictoropsConfigsNested<N> extends VictorOpsConfigFluent<VictoropsConfigsNested<N>> implements Nested<N>{
  
    VictorOpsConfigBuilder builder;
    int index;
  
    VictoropsConfigsNested(int index,VictorOpsConfig item) {
      this.index = index;
      this.builder = new VictorOpsConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToVictoropsConfigs(index, builder.build());
    }
    
    public N endVictoropsConfig() {
      return and();
    }
    
  }
  public class WebexConfigsNested<N> extends WebexConfigFluent<WebexConfigsNested<N>> implements Nested<N>{
  
    WebexConfigBuilder builder;
    int index;
  
    WebexConfigsNested(int index,WebexConfig item) {
      this.index = index;
      this.builder = new WebexConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToWebexConfigs(index, builder.build());
    }
    
    public N endWebexConfig() {
      return and();
    }
    
  }
  public class WebhookConfigsNested<N> extends WebhookConfigFluent<WebhookConfigsNested<N>> implements Nested<N>{
  
    WebhookConfigBuilder builder;
    int index;
  
    WebhookConfigsNested(int index,WebhookConfig item) {
      this.index = index;
      this.builder = new WebhookConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToWebhookConfigs(index, builder.build());
    }
    
    public N endWebhookConfig() {
      return and();
    }
    
  }
  public class WechatConfigsNested<N> extends WeChatConfigFluent<WechatConfigsNested<N>> implements Nested<N>{
  
    WeChatConfigBuilder builder;
    int index;
  
    WechatConfigsNested(int index,WeChatConfig item) {
      this.index = index;
      this.builder = new WeChatConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReceiverFluent.this.setToWechatConfigs(index, builder.build());
    }
    
    public N endWechatConfig() {
      return and();
    }
    
  }
}