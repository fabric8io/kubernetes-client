
package io.fabric8.openshift.api.model.monitoring.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "discordConfigs",
    "emailConfigs",
    "msteamsConfigs",
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
public class Receiver implements Editable<ReceiverBuilder> , KubernetesResource
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
     * 
     */
    public Receiver() {
    }

    public Receiver(List<DiscordConfig> discordConfigs, List<EmailConfig> emailConfigs, List<MSTeamsConfig> msteamsConfigs, String name, List<OpsGenieConfig> opsgenieConfigs, List<PagerDutyConfig> pagerdutyConfigs, List<PushoverConfig> pushoverConfigs, List<SlackConfig> slackConfigs, List<SNSConfig> snsConfigs, List<TelegramConfig> telegramConfigs, List<VictorOpsConfig> victoropsConfigs, List<WebexConfig> webexConfigs, List<WebhookConfig> webhookConfigs, List<WeChatConfig> wechatConfigs) {
        super();
        this.discordConfigs = discordConfigs;
        this.emailConfigs = emailConfigs;
        this.msteamsConfigs = msteamsConfigs;
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

    @JsonProperty("discordConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DiscordConfig> getDiscordConfigs() {
        return discordConfigs;
    }

    @JsonProperty("discordConfigs")
    public void setDiscordConfigs(List<DiscordConfig> discordConfigs) {
        this.discordConfigs = discordConfigs;
    }

    @JsonProperty("emailConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EmailConfig> getEmailConfigs() {
        return emailConfigs;
    }

    @JsonProperty("emailConfigs")
    public void setEmailConfigs(List<EmailConfig> emailConfigs) {
        this.emailConfigs = emailConfigs;
    }

    @JsonProperty("msteamsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MSTeamsConfig> getMsteamsConfigs() {
        return msteamsConfigs;
    }

    @JsonProperty("msteamsConfigs")
    public void setMsteamsConfigs(List<MSTeamsConfig> msteamsConfigs) {
        this.msteamsConfigs = msteamsConfigs;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("opsgenieConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpsGenieConfig> getOpsgenieConfigs() {
        return opsgenieConfigs;
    }

    @JsonProperty("opsgenieConfigs")
    public void setOpsgenieConfigs(List<OpsGenieConfig> opsgenieConfigs) {
        this.opsgenieConfigs = opsgenieConfigs;
    }

    @JsonProperty("pagerdutyConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PagerDutyConfig> getPagerdutyConfigs() {
        return pagerdutyConfigs;
    }

    @JsonProperty("pagerdutyConfigs")
    public void setPagerdutyConfigs(List<PagerDutyConfig> pagerdutyConfigs) {
        this.pagerdutyConfigs = pagerdutyConfigs;
    }

    @JsonProperty("pushoverConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PushoverConfig> getPushoverConfigs() {
        return pushoverConfigs;
    }

    @JsonProperty("pushoverConfigs")
    public void setPushoverConfigs(List<PushoverConfig> pushoverConfigs) {
        this.pushoverConfigs = pushoverConfigs;
    }

    @JsonProperty("slackConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SlackConfig> getSlackConfigs() {
        return slackConfigs;
    }

    @JsonProperty("slackConfigs")
    public void setSlackConfigs(List<SlackConfig> slackConfigs) {
        this.slackConfigs = slackConfigs;
    }

    @JsonProperty("snsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SNSConfig> getSnsConfigs() {
        return snsConfigs;
    }

    @JsonProperty("snsConfigs")
    public void setSnsConfigs(List<SNSConfig> snsConfigs) {
        this.snsConfigs = snsConfigs;
    }

    @JsonProperty("telegramConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TelegramConfig> getTelegramConfigs() {
        return telegramConfigs;
    }

    @JsonProperty("telegramConfigs")
    public void setTelegramConfigs(List<TelegramConfig> telegramConfigs) {
        this.telegramConfigs = telegramConfigs;
    }

    @JsonProperty("victoropsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VictorOpsConfig> getVictoropsConfigs() {
        return victoropsConfigs;
    }

    @JsonProperty("victoropsConfigs")
    public void setVictoropsConfigs(List<VictorOpsConfig> victoropsConfigs) {
        this.victoropsConfigs = victoropsConfigs;
    }

    @JsonProperty("webexConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WebexConfig> getWebexConfigs() {
        return webexConfigs;
    }

    @JsonProperty("webexConfigs")
    public void setWebexConfigs(List<WebexConfig> webexConfigs) {
        this.webexConfigs = webexConfigs;
    }

    @JsonProperty("webhookConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WebhookConfig> getWebhookConfigs() {
        return webhookConfigs;
    }

    @JsonProperty("webhookConfigs")
    public void setWebhookConfigs(List<WebhookConfig> webhookConfigs) {
        this.webhookConfigs = webhookConfigs;
    }

    @JsonProperty("wechatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WeChatConfig> getWechatConfigs() {
        return wechatConfigs;
    }

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
