
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpConfig",
    "jira",
    "opsGenieApiKey",
    "opsGenieApiUrl",
    "pagerdutyUrl",
    "resolveTimeout",
    "rocketChat",
    "slackApiUrl",
    "smtp",
    "telegram",
    "victorops",
    "webex",
    "wechat"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AlertmanagerGlobalConfig implements Editable<AlertmanagerGlobalConfigBuilder>, KubernetesResource
{

    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("jira")
    private GlobalJiraConfig jira;
    @JsonProperty("opsGenieApiKey")
    private SecretKeySelector opsGenieApiKey;
    @JsonProperty("opsGenieApiUrl")
    private SecretKeySelector opsGenieApiUrl;
    @JsonProperty("pagerdutyUrl")
    private String pagerdutyUrl;
    @JsonProperty("resolveTimeout")
    private String resolveTimeout;
    @JsonProperty("rocketChat")
    private GlobalRocketChatConfig rocketChat;
    @JsonProperty("slackApiUrl")
    private SecretKeySelector slackApiUrl;
    @JsonProperty("smtp")
    private GlobalSMTPConfig smtp;
    @JsonProperty("telegram")
    private GlobalTelegramConfig telegram;
    @JsonProperty("victorops")
    private GlobalVictorOpsConfig victorops;
    @JsonProperty("webex")
    private GlobalWebexConfig webex;
    @JsonProperty("wechat")
    private GlobalWeChatConfig wechat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertmanagerGlobalConfig() {
    }

    public AlertmanagerGlobalConfig(HTTPConfig httpConfig, GlobalJiraConfig jira, SecretKeySelector opsGenieApiKey, SecretKeySelector opsGenieApiUrl, String pagerdutyUrl, String resolveTimeout, GlobalRocketChatConfig rocketChat, SecretKeySelector slackApiUrl, GlobalSMTPConfig smtp, GlobalTelegramConfig telegram, GlobalVictorOpsConfig victorops, GlobalWebexConfig webex, GlobalWeChatConfig wechat) {
        super();
        this.httpConfig = httpConfig;
        this.jira = jira;
        this.opsGenieApiKey = opsGenieApiKey;
        this.opsGenieApiUrl = opsGenieApiUrl;
        this.pagerdutyUrl = pagerdutyUrl;
        this.resolveTimeout = resolveTimeout;
        this.rocketChat = rocketChat;
        this.slackApiUrl = slackApiUrl;
        this.smtp = smtp;
        this.telegram = telegram;
        this.victorops = victorops;
        this.webex = webex;
        this.wechat = wechat;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("jira")
    public GlobalJiraConfig getJira() {
        return jira;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("jira")
    public void setJira(GlobalJiraConfig jira) {
        this.jira = jira;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("opsGenieApiKey")
    public SecretKeySelector getOpsGenieApiKey() {
        return opsGenieApiKey;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("opsGenieApiKey")
    public void setOpsGenieApiKey(SecretKeySelector opsGenieApiKey) {
        this.opsGenieApiKey = opsGenieApiKey;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("opsGenieApiUrl")
    public SecretKeySelector getOpsGenieApiUrl() {
        return opsGenieApiUrl;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("opsGenieApiUrl")
    public void setOpsGenieApiUrl(SecretKeySelector opsGenieApiUrl) {
        this.opsGenieApiUrl = opsGenieApiUrl;
    }

    /**
     * The default Pagerduty URL.
     */
    @JsonProperty("pagerdutyUrl")
    public String getPagerdutyUrl() {
        return pagerdutyUrl;
    }

    /**
     * The default Pagerduty URL.
     */
    @JsonProperty("pagerdutyUrl")
    public void setPagerdutyUrl(String pagerdutyUrl) {
        this.pagerdutyUrl = pagerdutyUrl;
    }

    /**
     * ResolveTimeout is the default value used by alertmanager if the alert does not include EndsAt, after this time passes it can declare the alert as resolved if it has not been updated. This has no impact on alerts from Prometheus, as they always include EndsAt.
     */
    @JsonProperty("resolveTimeout")
    public String getResolveTimeout() {
        return resolveTimeout;
    }

    /**
     * ResolveTimeout is the default value used by alertmanager if the alert does not include EndsAt, after this time passes it can declare the alert as resolved if it has not been updated. This has no impact on alerts from Prometheus, as they always include EndsAt.
     */
    @JsonProperty("resolveTimeout")
    public void setResolveTimeout(String resolveTimeout) {
        this.resolveTimeout = resolveTimeout;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("rocketChat")
    public GlobalRocketChatConfig getRocketChat() {
        return rocketChat;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("rocketChat")
    public void setRocketChat(GlobalRocketChatConfig rocketChat) {
        this.rocketChat = rocketChat;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("slackApiUrl")
    public SecretKeySelector getSlackApiUrl() {
        return slackApiUrl;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("slackApiUrl")
    public void setSlackApiUrl(SecretKeySelector slackApiUrl) {
        this.slackApiUrl = slackApiUrl;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("smtp")
    public GlobalSMTPConfig getSmtp() {
        return smtp;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("smtp")
    public void setSmtp(GlobalSMTPConfig smtp) {
        this.smtp = smtp;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("telegram")
    public GlobalTelegramConfig getTelegram() {
        return telegram;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("telegram")
    public void setTelegram(GlobalTelegramConfig telegram) {
        this.telegram = telegram;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("victorops")
    public GlobalVictorOpsConfig getVictorops() {
        return victorops;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("victorops")
    public void setVictorops(GlobalVictorOpsConfig victorops) {
        this.victorops = victorops;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("webex")
    public GlobalWebexConfig getWebex() {
        return webex;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("webex")
    public void setWebex(GlobalWebexConfig webex) {
        this.webex = webex;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("wechat")
    public GlobalWeChatConfig getWechat() {
        return wechat;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("wechat")
    public void setWechat(GlobalWeChatConfig wechat) {
        this.wechat = wechat;
    }

    @JsonIgnore
    public AlertmanagerGlobalConfigBuilder edit() {
        return new AlertmanagerGlobalConfigBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerGlobalConfigBuilder toBuilder() {
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
