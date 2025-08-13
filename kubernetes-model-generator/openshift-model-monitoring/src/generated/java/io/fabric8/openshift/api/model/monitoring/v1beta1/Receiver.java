
package io.fabric8.openshift.api.model.monitoring.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Receiver defines one or more notification integrations.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "discordConfigs",
    "emailConfigs",
    "msteamsConfigs",
    "msteamsv2Configs",
    "name",
    "opsgenieConfigs",
    "pagerdutyConfigs",
    "pushoverConfigs",
    "slackConfigs",
    "snsConfigs",
    "telegramConfigs",
    "victoropsConfigs",
    "webexConfigs",
    "webhookConfigs",
    "wechatConfigs"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Receiver implements Editable<ReceiverBuilder>, KubernetesResource
{

    @JsonProperty("discordConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DiscordConfig> discordConfigs = new ArrayList<>();
    @JsonProperty("emailConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EmailConfig> emailConfigs = new ArrayList<>();
    @JsonProperty("msteamsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MSTeamsConfig> msteamsConfigs = new ArrayList<>();
    @JsonProperty("msteamsv2Configs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MSTeamsV2Config> msteamsv2Configs = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("opsgenieConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OpsGenieConfig> opsgenieConfigs = new ArrayList<>();
    @JsonProperty("pagerdutyConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PagerDutyConfig> pagerdutyConfigs = new ArrayList<>();
    @JsonProperty("pushoverConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PushoverConfig> pushoverConfigs = new ArrayList<>();
    @JsonProperty("slackConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SlackConfig> slackConfigs = new ArrayList<>();
    @JsonProperty("snsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SNSConfig> snsConfigs = new ArrayList<>();
    @JsonProperty("telegramConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TelegramConfig> telegramConfigs = new ArrayList<>();
    @JsonProperty("victoropsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VictorOpsConfig> victoropsConfigs = new ArrayList<>();
    @JsonProperty("webexConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WebexConfig> webexConfigs = new ArrayList<>();
    @JsonProperty("webhookConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WebhookConfig> webhookConfigs = new ArrayList<>();
    @JsonProperty("wechatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WeChatConfig> wechatConfigs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Receiver() {
    }

    public Receiver(List<DiscordConfig> discordConfigs, List<EmailConfig> emailConfigs, List<MSTeamsConfig> msteamsConfigs, List<MSTeamsV2Config> msteamsv2Configs, String name, List<OpsGenieConfig> opsgenieConfigs, List<PagerDutyConfig> pagerdutyConfigs, List<PushoverConfig> pushoverConfigs, List<SlackConfig> slackConfigs, List<SNSConfig> snsConfigs, List<TelegramConfig> telegramConfigs, List<VictorOpsConfig> victoropsConfigs, List<WebexConfig> webexConfigs, List<WebhookConfig> webhookConfigs, List<WeChatConfig> wechatConfigs) {
        super();
        this.discordConfigs = discordConfigs;
        this.emailConfigs = emailConfigs;
        this.msteamsConfigs = msteamsConfigs;
        this.msteamsv2Configs = msteamsv2Configs;
        this.name = name;
        this.opsgenieConfigs = opsgenieConfigs;
        this.pagerdutyConfigs = pagerdutyConfigs;
        this.pushoverConfigs = pushoverConfigs;
        this.slackConfigs = slackConfigs;
        this.snsConfigs = snsConfigs;
        this.telegramConfigs = telegramConfigs;
        this.victoropsConfigs = victoropsConfigs;
        this.webexConfigs = webexConfigs;
        this.webhookConfigs = webhookConfigs;
        this.wechatConfigs = wechatConfigs;
    }

    /**
     * List of Slack configurations.
     */
    @JsonProperty("discordConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DiscordConfig> getDiscordConfigs() {
        return discordConfigs;
    }

    /**
     * List of Slack configurations.
     */
    @JsonProperty("discordConfigs")
    public void setDiscordConfigs(List<DiscordConfig> discordConfigs) {
        this.discordConfigs = discordConfigs;
    }

    /**
     * List of Email configurations.
     */
    @JsonProperty("emailConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EmailConfig> getEmailConfigs() {
        return emailConfigs;
    }

    /**
     * List of Email configurations.
     */
    @JsonProperty("emailConfigs")
    public void setEmailConfigs(List<EmailConfig> emailConfigs) {
        this.emailConfigs = emailConfigs;
    }

    /**
     * List of MSTeams configurations. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("msteamsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MSTeamsConfig> getMsteamsConfigs() {
        return msteamsConfigs;
    }

    /**
     * List of MSTeams configurations. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("msteamsConfigs")
    public void setMsteamsConfigs(List<MSTeamsConfig> msteamsConfigs) {
        this.msteamsConfigs = msteamsConfigs;
    }

    /**
     * List of MSTeamsV2 configurations. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("msteamsv2Configs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MSTeamsV2Config> getMsteamsv2Configs() {
        return msteamsv2Configs;
    }

    /**
     * List of MSTeamsV2 configurations. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("msteamsv2Configs")
    public void setMsteamsv2Configs(List<MSTeamsV2Config> msteamsv2Configs) {
        this.msteamsv2Configs = msteamsv2Configs;
    }

    /**
     * Name of the receiver. Must be unique across all items from the list.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the receiver. Must be unique across all items from the list.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * List of OpsGenie configurations.
     */
    @JsonProperty("opsgenieConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpsGenieConfig> getOpsgenieConfigs() {
        return opsgenieConfigs;
    }

    /**
     * List of OpsGenie configurations.
     */
    @JsonProperty("opsgenieConfigs")
    public void setOpsgenieConfigs(List<OpsGenieConfig> opsgenieConfigs) {
        this.opsgenieConfigs = opsgenieConfigs;
    }

    /**
     * List of PagerDuty configurations.
     */
    @JsonProperty("pagerdutyConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PagerDutyConfig> getPagerdutyConfigs() {
        return pagerdutyConfigs;
    }

    /**
     * List of PagerDuty configurations.
     */
    @JsonProperty("pagerdutyConfigs")
    public void setPagerdutyConfigs(List<PagerDutyConfig> pagerdutyConfigs) {
        this.pagerdutyConfigs = pagerdutyConfigs;
    }

    /**
     * List of Pushover configurations.
     */
    @JsonProperty("pushoverConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PushoverConfig> getPushoverConfigs() {
        return pushoverConfigs;
    }

    /**
     * List of Pushover configurations.
     */
    @JsonProperty("pushoverConfigs")
    public void setPushoverConfigs(List<PushoverConfig> pushoverConfigs) {
        this.pushoverConfigs = pushoverConfigs;
    }

    /**
     * List of Slack configurations.
     */
    @JsonProperty("slackConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SlackConfig> getSlackConfigs() {
        return slackConfigs;
    }

    /**
     * List of Slack configurations.
     */
    @JsonProperty("slackConfigs")
    public void setSlackConfigs(List<SlackConfig> slackConfigs) {
        this.slackConfigs = slackConfigs;
    }

    /**
     * List of SNS configurations
     */
    @JsonProperty("snsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SNSConfig> getSnsConfigs() {
        return snsConfigs;
    }

    /**
     * List of SNS configurations
     */
    @JsonProperty("snsConfigs")
    public void setSnsConfigs(List<SNSConfig> snsConfigs) {
        this.snsConfigs = snsConfigs;
    }

    /**
     * List of Telegram configurations.
     */
    @JsonProperty("telegramConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TelegramConfig> getTelegramConfigs() {
        return telegramConfigs;
    }

    /**
     * List of Telegram configurations.
     */
    @JsonProperty("telegramConfigs")
    public void setTelegramConfigs(List<TelegramConfig> telegramConfigs) {
        this.telegramConfigs = telegramConfigs;
    }

    /**
     * List of VictorOps configurations.
     */
    @JsonProperty("victoropsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VictorOpsConfig> getVictoropsConfigs() {
        return victoropsConfigs;
    }

    /**
     * List of VictorOps configurations.
     */
    @JsonProperty("victoropsConfigs")
    public void setVictoropsConfigs(List<VictorOpsConfig> victoropsConfigs) {
        this.victoropsConfigs = victoropsConfigs;
    }

    /**
     * List of Webex configurations.
     */
    @JsonProperty("webexConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WebexConfig> getWebexConfigs() {
        return webexConfigs;
    }

    /**
     * List of Webex configurations.
     */
    @JsonProperty("webexConfigs")
    public void setWebexConfigs(List<WebexConfig> webexConfigs) {
        this.webexConfigs = webexConfigs;
    }

    /**
     * List of webhook configurations.
     */
    @JsonProperty("webhookConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WebhookConfig> getWebhookConfigs() {
        return webhookConfigs;
    }

    /**
     * List of webhook configurations.
     */
    @JsonProperty("webhookConfigs")
    public void setWebhookConfigs(List<WebhookConfig> webhookConfigs) {
        this.webhookConfigs = webhookConfigs;
    }

    /**
     * List of WeChat configurations.
     */
    @JsonProperty("wechatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WeChatConfig> getWechatConfigs() {
        return wechatConfigs;
    }

    /**
     * List of WeChat configurations.
     */
    @JsonProperty("wechatConfigs")
    public void setWechatConfigs(List<WeChatConfig> wechatConfigs) {
        this.wechatConfigs = wechatConfigs;
    }

    @JsonIgnore
    public ReceiverBuilder edit() {
        return new ReceiverBuilder(this);
    }

    @JsonIgnore
    public ReceiverBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
