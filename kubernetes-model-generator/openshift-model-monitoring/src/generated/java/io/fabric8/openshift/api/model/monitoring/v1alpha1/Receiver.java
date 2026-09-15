
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
    "rocketchatConfigs",
    "slackConfigs",
    "snsConfigs",
    "telegramConfigs",
    "victoropsConfigs",
    "webexConfigs",
    "webhookConfigs",
    "wechatConfigs"
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
    @JsonProperty("rocketchatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RocketChatConfig> rocketchatConfigs = new ArrayList<>();
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

    public Receiver(List<DiscordConfig> discordConfigs, List<EmailConfig> emailConfigs, List<MSTeamsConfig> msteamsConfigs, List<MSTeamsV2Config> msteamsv2Configs, String name, List<OpsGenieConfig> opsgenieConfigs, List<PagerDutyConfig> pagerdutyConfigs, List<PushoverConfig> pushoverConfigs, List<RocketChatConfig> rocketchatConfigs, List<SlackConfig> slackConfigs, List<SNSConfig> snsConfigs, List<TelegramConfig> telegramConfigs, List<VictorOpsConfig> victoropsConfigs, List<WebexConfig> webexConfigs, List<WebhookConfig> webhookConfigs, List<WeChatConfig> wechatConfigs) {
        super();
        this.discordConfigs = discordConfigs;
        this.emailConfigs = emailConfigs;
        this.msteamsConfigs = msteamsConfigs;
        this.msteamsv2Configs = msteamsv2Configs;
        this.name = name;
        this.opsgenieConfigs = opsgenieConfigs;
        this.pagerdutyConfigs = pagerdutyConfigs;
        this.pushoverConfigs = pushoverConfigs;
        this.rocketchatConfigs = rocketchatConfigs;
        this.slackConfigs = slackConfigs;
        this.snsConfigs = snsConfigs;
        this.telegramConfigs = telegramConfigs;
        this.victoropsConfigs = victoropsConfigs;
        this.webexConfigs = webexConfigs;
        this.webhookConfigs = webhookConfigs;
        this.wechatConfigs = wechatConfigs;
    }

    /**
     * discordConfigs defines the list of Slack configurations.
     */
    @JsonProperty("discordConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DiscordConfig> getDiscordConfigs() {
        return discordConfigs;
    }

    /**
     * discordConfigs defines the list of Slack configurations.
     */
    @JsonProperty("discordConfigs")
    public void setDiscordConfigs(List<DiscordConfig> discordConfigs) {
        this.discordConfigs = discordConfigs;
    }

    /**
     * emailConfigs defines the list of Email configurations.
     */
    @JsonProperty("emailConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EmailConfig> getEmailConfigs() {
        return emailConfigs;
    }

    /**
     * emailConfigs defines the list of Email configurations.
     */
    @JsonProperty("emailConfigs")
    public void setEmailConfigs(List<EmailConfig> emailConfigs) {
        this.emailConfigs = emailConfigs;
    }

    /**
     * msteamsConfigs defines the list of MSTeams configurations. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("msteamsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MSTeamsConfig> getMsteamsConfigs() {
        return msteamsConfigs;
    }

    /**
     * msteamsConfigs defines the list of MSTeams configurations. It requires Alertmanager &gt;= 0.26.0.
     */
    @JsonProperty("msteamsConfigs")
    public void setMsteamsConfigs(List<MSTeamsConfig> msteamsConfigs) {
        this.msteamsConfigs = msteamsConfigs;
    }

    /**
     * msteamsv2Configs defines the list of MSTeamsV2 configurations. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("msteamsv2Configs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MSTeamsV2Config> getMsteamsv2Configs() {
        return msteamsv2Configs;
    }

    /**
     * msteamsv2Configs defines the list of MSTeamsV2 configurations. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("msteamsv2Configs")
    public void setMsteamsv2Configs(List<MSTeamsV2Config> msteamsv2Configs) {
        this.msteamsv2Configs = msteamsv2Configs;
    }

    /**
     * name defines the name of the receiver. Must be unique across all items from the list.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name defines the name of the receiver. Must be unique across all items from the list.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * opsgenieConfigs defines the list of OpsGenie configurations.
     */
    @JsonProperty("opsgenieConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpsGenieConfig> getOpsgenieConfigs() {
        return opsgenieConfigs;
    }

    /**
     * opsgenieConfigs defines the list of OpsGenie configurations.
     */
    @JsonProperty("opsgenieConfigs")
    public void setOpsgenieConfigs(List<OpsGenieConfig> opsgenieConfigs) {
        this.opsgenieConfigs = opsgenieConfigs;
    }

    /**
     * pagerdutyConfigs defines the List of PagerDuty configurations.
     */
    @JsonProperty("pagerdutyConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PagerDutyConfig> getPagerdutyConfigs() {
        return pagerdutyConfigs;
    }

    /**
     * pagerdutyConfigs defines the List of PagerDuty configurations.
     */
    @JsonProperty("pagerdutyConfigs")
    public void setPagerdutyConfigs(List<PagerDutyConfig> pagerdutyConfigs) {
        this.pagerdutyConfigs = pagerdutyConfigs;
    }

    /**
     * pushoverConfigs defines the list of Pushover configurations.
     */
    @JsonProperty("pushoverConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PushoverConfig> getPushoverConfigs() {
        return pushoverConfigs;
    }

    /**
     * pushoverConfigs defines the list of Pushover configurations.
     */
    @JsonProperty("pushoverConfigs")
    public void setPushoverConfigs(List<PushoverConfig> pushoverConfigs) {
        this.pushoverConfigs = pushoverConfigs;
    }

    /**
     * rocketchatConfigs defines the list of RocketChat configurations. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("rocketchatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RocketChatConfig> getRocketchatConfigs() {
        return rocketchatConfigs;
    }

    /**
     * rocketchatConfigs defines the list of RocketChat configurations. It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("rocketchatConfigs")
    public void setRocketchatConfigs(List<RocketChatConfig> rocketchatConfigs) {
        this.rocketchatConfigs = rocketchatConfigs;
    }

    /**
     * slackConfigs defines the list of Slack configurations.
     */
    @JsonProperty("slackConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SlackConfig> getSlackConfigs() {
        return slackConfigs;
    }

    /**
     * slackConfigs defines the list of Slack configurations.
     */
    @JsonProperty("slackConfigs")
    public void setSlackConfigs(List<SlackConfig> slackConfigs) {
        this.slackConfigs = slackConfigs;
    }

    /**
     * snsConfigs defines the list of SNS configurations
     */
    @JsonProperty("snsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SNSConfig> getSnsConfigs() {
        return snsConfigs;
    }

    /**
     * snsConfigs defines the list of SNS configurations
     */
    @JsonProperty("snsConfigs")
    public void setSnsConfigs(List<SNSConfig> snsConfigs) {
        this.snsConfigs = snsConfigs;
    }

    /**
     * telegramConfigs defines the list of Telegram configurations.
     */
    @JsonProperty("telegramConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TelegramConfig> getTelegramConfigs() {
        return telegramConfigs;
    }

    /**
     * telegramConfigs defines the list of Telegram configurations.
     */
    @JsonProperty("telegramConfigs")
    public void setTelegramConfigs(List<TelegramConfig> telegramConfigs) {
        this.telegramConfigs = telegramConfigs;
    }

    /**
     * victoropsConfigs defines the list of VictorOps configurations.
     */
    @JsonProperty("victoropsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VictorOpsConfig> getVictoropsConfigs() {
        return victoropsConfigs;
    }

    /**
     * victoropsConfigs defines the list of VictorOps configurations.
     */
    @JsonProperty("victoropsConfigs")
    public void setVictoropsConfigs(List<VictorOpsConfig> victoropsConfigs) {
        this.victoropsConfigs = victoropsConfigs;
    }

    /**
     * webexConfigs defines the list of Webex configurations.
     */
    @JsonProperty("webexConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WebexConfig> getWebexConfigs() {
        return webexConfigs;
    }

    /**
     * webexConfigs defines the list of Webex configurations.
     */
    @JsonProperty("webexConfigs")
    public void setWebexConfigs(List<WebexConfig> webexConfigs) {
        this.webexConfigs = webexConfigs;
    }

    /**
     * webhookConfigs defines the List of webhook configurations.
     */
    @JsonProperty("webhookConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WebhookConfig> getWebhookConfigs() {
        return webhookConfigs;
    }

    /**
     * webhookConfigs defines the List of webhook configurations.
     */
    @JsonProperty("webhookConfigs")
    public void setWebhookConfigs(List<WebhookConfig> webhookConfigs) {
        this.webhookConfigs = webhookConfigs;
    }

    /**
     * wechatConfigs defines the list of WeChat configurations.
     */
    @JsonProperty("wechatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WeChatConfig> getWechatConfigs() {
        return wechatConfigs;
    }

    /**
     * wechatConfigs defines the list of WeChat configurations.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Receiver)) {
            return false;
        }
        Receiver other = (Receiver) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$discordConfigs = this.getDiscordConfigs();
        Object other$discordConfigs = other.getDiscordConfigs();
        if (this$discordConfigs == null ? other$discordConfigs != null : !this$discordConfigs.equals(other$discordConfigs)) {
            return false;
        }
        Object this$emailConfigs = this.getEmailConfigs();
        Object other$emailConfigs = other.getEmailConfigs();
        if (this$emailConfigs == null ? other$emailConfigs != null : !this$emailConfigs.equals(other$emailConfigs)) {
            return false;
        }
        Object this$msteamsConfigs = this.getMsteamsConfigs();
        Object other$msteamsConfigs = other.getMsteamsConfigs();
        if (this$msteamsConfigs == null ? other$msteamsConfigs != null : !this$msteamsConfigs.equals(other$msteamsConfigs)) {
            return false;
        }
        Object this$msteamsv2Configs = this.getMsteamsv2Configs();
        Object other$msteamsv2Configs = other.getMsteamsv2Configs();
        if (this$msteamsv2Configs == null ? other$msteamsv2Configs != null : !this$msteamsv2Configs.equals(other$msteamsv2Configs)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$opsgenieConfigs = this.getOpsgenieConfigs();
        Object other$opsgenieConfigs = other.getOpsgenieConfigs();
        if (this$opsgenieConfigs == null ? other$opsgenieConfigs != null : !this$opsgenieConfigs.equals(other$opsgenieConfigs)) {
            return false;
        }
        Object this$pagerdutyConfigs = this.getPagerdutyConfigs();
        Object other$pagerdutyConfigs = other.getPagerdutyConfigs();
        if (this$pagerdutyConfigs == null ? other$pagerdutyConfigs != null : !this$pagerdutyConfigs.equals(other$pagerdutyConfigs)) {
            return false;
        }
        Object this$pushoverConfigs = this.getPushoverConfigs();
        Object other$pushoverConfigs = other.getPushoverConfigs();
        if (this$pushoverConfigs == null ? other$pushoverConfigs != null : !this$pushoverConfigs.equals(other$pushoverConfigs)) {
            return false;
        }
        Object this$rocketchatConfigs = this.getRocketchatConfigs();
        Object other$rocketchatConfigs = other.getRocketchatConfigs();
        if (this$rocketchatConfigs == null ? other$rocketchatConfigs != null : !this$rocketchatConfigs.equals(other$rocketchatConfigs)) {
            return false;
        }
        Object this$slackConfigs = this.getSlackConfigs();
        Object other$slackConfigs = other.getSlackConfigs();
        if (this$slackConfigs == null ? other$slackConfigs != null : !this$slackConfigs.equals(other$slackConfigs)) {
            return false;
        }
        Object this$snsConfigs = this.getSnsConfigs();
        Object other$snsConfigs = other.getSnsConfigs();
        if (this$snsConfigs == null ? other$snsConfigs != null : !this$snsConfigs.equals(other$snsConfigs)) {
            return false;
        }
        Object this$telegramConfigs = this.getTelegramConfigs();
        Object other$telegramConfigs = other.getTelegramConfigs();
        if (this$telegramConfigs == null ? other$telegramConfigs != null : !this$telegramConfigs.equals(other$telegramConfigs)) {
            return false;
        }
        Object this$victoropsConfigs = this.getVictoropsConfigs();
        Object other$victoropsConfigs = other.getVictoropsConfigs();
        if (this$victoropsConfigs == null ? other$victoropsConfigs != null : !this$victoropsConfigs.equals(other$victoropsConfigs)) {
            return false;
        }
        Object this$webexConfigs = this.getWebexConfigs();
        Object other$webexConfigs = other.getWebexConfigs();
        if (this$webexConfigs == null ? other$webexConfigs != null : !this$webexConfigs.equals(other$webexConfigs)) {
            return false;
        }
        Object this$webhookConfigs = this.getWebhookConfigs();
        Object other$webhookConfigs = other.getWebhookConfigs();
        if (this$webhookConfigs == null ? other$webhookConfigs != null : !this$webhookConfigs.equals(other$webhookConfigs)) {
            return false;
        }
        Object this$wechatConfigs = this.getWechatConfigs();
        Object other$wechatConfigs = other.getWechatConfigs();
        if (this$wechatConfigs == null ? other$wechatConfigs != null : !this$wechatConfigs.equals(other$wechatConfigs)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Receiver;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $discordConfigs = this.getDiscordConfigs();
        result = result * prime + ($discordConfigs == null ? 43 : $discordConfigs.hashCode());
        Object $emailConfigs = this.getEmailConfigs();
        result = result * prime + ($emailConfigs == null ? 43 : $emailConfigs.hashCode());
        Object $msteamsConfigs = this.getMsteamsConfigs();
        result = result * prime + ($msteamsConfigs == null ? 43 : $msteamsConfigs.hashCode());
        Object $msteamsv2Configs = this.getMsteamsv2Configs();
        result = result * prime + ($msteamsv2Configs == null ? 43 : $msteamsv2Configs.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $opsgenieConfigs = this.getOpsgenieConfigs();
        result = result * prime + ($opsgenieConfigs == null ? 43 : $opsgenieConfigs.hashCode());
        Object $pagerdutyConfigs = this.getPagerdutyConfigs();
        result = result * prime + ($pagerdutyConfigs == null ? 43 : $pagerdutyConfigs.hashCode());
        Object $pushoverConfigs = this.getPushoverConfigs();
        result = result * prime + ($pushoverConfigs == null ? 43 : $pushoverConfigs.hashCode());
        Object $rocketchatConfigs = this.getRocketchatConfigs();
        result = result * prime + ($rocketchatConfigs == null ? 43 : $rocketchatConfigs.hashCode());
        Object $slackConfigs = this.getSlackConfigs();
        result = result * prime + ($slackConfigs == null ? 43 : $slackConfigs.hashCode());
        Object $snsConfigs = this.getSnsConfigs();
        result = result * prime + ($snsConfigs == null ? 43 : $snsConfigs.hashCode());
        Object $telegramConfigs = this.getTelegramConfigs();
        result = result * prime + ($telegramConfigs == null ? 43 : $telegramConfigs.hashCode());
        Object $victoropsConfigs = this.getVictoropsConfigs();
        result = result * prime + ($victoropsConfigs == null ? 43 : $victoropsConfigs.hashCode());
        Object $webexConfigs = this.getWebexConfigs();
        result = result * prime + ($webexConfigs == null ? 43 : $webexConfigs.hashCode());
        Object $webhookConfigs = this.getWebhookConfigs();
        result = result * prime + ($webhookConfigs == null ? 43 : $webhookConfigs.hashCode());
        Object $wechatConfigs = this.getWechatConfigs();
        result = result * prime + ($wechatConfigs == null ? 43 : $wechatConfigs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Receiver(" + "discordConfigs=" + this.getDiscordConfigs() + ", emailConfigs=" + this.getEmailConfigs() + ", msteamsConfigs=" + this.getMsteamsConfigs() + ", msteamsv2Configs=" + this.getMsteamsv2Configs() + ", name=" + this.getName() + ", opsgenieConfigs=" + this.getOpsgenieConfigs() + ", pagerdutyConfigs=" + this.getPagerdutyConfigs() + ", pushoverConfigs=" + this.getPushoverConfigs() + ", rocketchatConfigs=" + this.getRocketchatConfigs() + ", slackConfigs=" + this.getSlackConfigs() + ", snsConfigs=" + this.getSnsConfigs() + ", telegramConfigs=" + this.getTelegramConfigs() + ", victoropsConfigs=" + this.getVictoropsConfigs() + ", webexConfigs=" + this.getWebexConfigs() + ", webhookConfigs=" + this.getWebhookConfigs() + ", wechatConfigs=" + this.getWechatConfigs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
