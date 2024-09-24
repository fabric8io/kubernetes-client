
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerConfigSpecReceivers implements Editable<AlertmanagerConfigSpecReceiversBuilder> , KubernetesResource
{

    @JsonProperty("discordConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRDiscordConfigs> discordConfigs = new ArrayList<>();
    @JsonProperty("emailConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecREmailConfigs> emailConfigs = new ArrayList<>();
    @JsonProperty("msteamsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRMsteamsConfigs> msteamsConfigs = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("opsgenieConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecROpsgenieConfigs> opsgenieConfigs = new ArrayList<>();
    @JsonProperty("pagerdutyConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRPagerdutyConfigs> pagerdutyConfigs = new ArrayList<>();
    @JsonProperty("pushoverConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRPushoverConfigs> pushoverConfigs = new ArrayList<>();
    @JsonProperty("slackConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRSlackConfigs> slackConfigs = new ArrayList<>();
    @JsonProperty("snsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRSnsConfigs> snsConfigs = new ArrayList<>();
    @JsonProperty("telegramConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRTelegramConfigs> telegramConfigs = new ArrayList<>();
    @JsonProperty("victoropsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRVictoropsConfigs> victoropsConfigs = new ArrayList<>();
    @JsonProperty("webexConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRWebexConfigs> webexConfigs = new ArrayList<>();
    @JsonProperty("webhookConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRWebhookConfigs> webhookConfigs = new ArrayList<>();
    @JsonProperty("wechatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRWechatConfigs> wechatConfigs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpecReceivers() {
    }

    public AlertmanagerConfigSpecReceivers(List<AlertmanagerConfigSpecRDiscordConfigs> discordConfigs, List<AlertmanagerConfigSpecREmailConfigs> emailConfigs, List<AlertmanagerConfigSpecRMsteamsConfigs> msteamsConfigs, String name, List<AlertmanagerConfigSpecROpsgenieConfigs> opsgenieConfigs, List<AlertmanagerConfigSpecRPagerdutyConfigs> pagerdutyConfigs, List<AlertmanagerConfigSpecRPushoverConfigs> pushoverConfigs, List<AlertmanagerConfigSpecRSlackConfigs> slackConfigs, List<AlertmanagerConfigSpecRSnsConfigs> snsConfigs, List<AlertmanagerConfigSpecRTelegramConfigs> telegramConfigs, List<AlertmanagerConfigSpecRVictoropsConfigs> victoropsConfigs, List<AlertmanagerConfigSpecRWebexConfigs> webexConfigs, List<AlertmanagerConfigSpecRWebhookConfigs> webhookConfigs, List<AlertmanagerConfigSpecRWechatConfigs> wechatConfigs) {
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
    public List<AlertmanagerConfigSpecRDiscordConfigs> getDiscordConfigs() {
        return discordConfigs;
    }

    @JsonProperty("discordConfigs")
    public void setDiscordConfigs(List<AlertmanagerConfigSpecRDiscordConfigs> discordConfigs) {
        this.discordConfigs = discordConfigs;
    }

    @JsonProperty("emailConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecREmailConfigs> getEmailConfigs() {
        return emailConfigs;
    }

    @JsonProperty("emailConfigs")
    public void setEmailConfigs(List<AlertmanagerConfigSpecREmailConfigs> emailConfigs) {
        this.emailConfigs = emailConfigs;
    }

    @JsonProperty("msteamsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRMsteamsConfigs> getMsteamsConfigs() {
        return msteamsConfigs;
    }

    @JsonProperty("msteamsConfigs")
    public void setMsteamsConfigs(List<AlertmanagerConfigSpecRMsteamsConfigs> msteamsConfigs) {
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
    public List<AlertmanagerConfigSpecROpsgenieConfigs> getOpsgenieConfigs() {
        return opsgenieConfigs;
    }

    @JsonProperty("opsgenieConfigs")
    public void setOpsgenieConfigs(List<AlertmanagerConfigSpecROpsgenieConfigs> opsgenieConfigs) {
        this.opsgenieConfigs = opsgenieConfigs;
    }

    @JsonProperty("pagerdutyConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRPagerdutyConfigs> getPagerdutyConfigs() {
        return pagerdutyConfigs;
    }

    @JsonProperty("pagerdutyConfigs")
    public void setPagerdutyConfigs(List<AlertmanagerConfigSpecRPagerdutyConfigs> pagerdutyConfigs) {
        this.pagerdutyConfigs = pagerdutyConfigs;
    }

    @JsonProperty("pushoverConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRPushoverConfigs> getPushoverConfigs() {
        return pushoverConfigs;
    }

    @JsonProperty("pushoverConfigs")
    public void setPushoverConfigs(List<AlertmanagerConfigSpecRPushoverConfigs> pushoverConfigs) {
        this.pushoverConfigs = pushoverConfigs;
    }

    @JsonProperty("slackConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRSlackConfigs> getSlackConfigs() {
        return slackConfigs;
    }

    @JsonProperty("slackConfigs")
    public void setSlackConfigs(List<AlertmanagerConfigSpecRSlackConfigs> slackConfigs) {
        this.slackConfigs = slackConfigs;
    }

    @JsonProperty("snsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRSnsConfigs> getSnsConfigs() {
        return snsConfigs;
    }

    @JsonProperty("snsConfigs")
    public void setSnsConfigs(List<AlertmanagerConfigSpecRSnsConfigs> snsConfigs) {
        this.snsConfigs = snsConfigs;
    }

    @JsonProperty("telegramConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRTelegramConfigs> getTelegramConfigs() {
        return telegramConfigs;
    }

    @JsonProperty("telegramConfigs")
    public void setTelegramConfigs(List<AlertmanagerConfigSpecRTelegramConfigs> telegramConfigs) {
        this.telegramConfigs = telegramConfigs;
    }

    @JsonProperty("victoropsConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRVictoropsConfigs> getVictoropsConfigs() {
        return victoropsConfigs;
    }

    @JsonProperty("victoropsConfigs")
    public void setVictoropsConfigs(List<AlertmanagerConfigSpecRVictoropsConfigs> victoropsConfigs) {
        this.victoropsConfigs = victoropsConfigs;
    }

    @JsonProperty("webexConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRWebexConfigs> getWebexConfigs() {
        return webexConfigs;
    }

    @JsonProperty("webexConfigs")
    public void setWebexConfigs(List<AlertmanagerConfigSpecRWebexConfigs> webexConfigs) {
        this.webexConfigs = webexConfigs;
    }

    @JsonProperty("webhookConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRWebhookConfigs> getWebhookConfigs() {
        return webhookConfigs;
    }

    @JsonProperty("webhookConfigs")
    public void setWebhookConfigs(List<AlertmanagerConfigSpecRWebhookConfigs> webhookConfigs) {
        this.webhookConfigs = webhookConfigs;
    }

    @JsonProperty("wechatConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRWechatConfigs> getWechatConfigs() {
        return wechatConfigs;
    }

    @JsonProperty("wechatConfigs")
    public void setWechatConfigs(List<AlertmanagerConfigSpecRWechatConfigs> wechatConfigs) {
        this.wechatConfigs = wechatConfigs;
    }

    @JsonIgnore
    public AlertmanagerConfigSpecReceiversBuilder edit() {
        return new AlertmanagerConfigSpecReceiversBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecReceiversBuilder toBuilder() {
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
