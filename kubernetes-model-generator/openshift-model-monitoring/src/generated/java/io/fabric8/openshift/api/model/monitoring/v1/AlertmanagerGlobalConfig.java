
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

/**
 * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpConfig",
    "jira",
    "mattermost",
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
    private HTTPConfigWithProxy httpConfig;
    @JsonProperty("jira")
    private GlobalJiraConfig jira;
    @JsonProperty("mattermost")
    private GlobalMattermostConfig mattermost;
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

    public AlertmanagerGlobalConfig(HTTPConfigWithProxy httpConfig, GlobalJiraConfig jira, GlobalMattermostConfig mattermost, SecretKeySelector opsGenieApiKey, SecretKeySelector opsGenieApiUrl, String pagerdutyUrl, String resolveTimeout, GlobalRocketChatConfig rocketChat, SecretKeySelector slackApiUrl, GlobalSMTPConfig smtp, GlobalTelegramConfig telegram, GlobalVictorOpsConfig victorops, GlobalWebexConfig webex, GlobalWeChatConfig wechat) {
        super();
        this.httpConfig = httpConfig;
        this.jira = jira;
        this.mattermost = mattermost;
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
    public HTTPConfigWithProxy getHttpConfig() {
        return httpConfig;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfigWithProxy httpConfig) {
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
    @JsonProperty("mattermost")
    public GlobalMattermostConfig getMattermost() {
        return mattermost;
    }

    /**
     * AlertmanagerGlobalConfig configures parameters that are valid in all other configuration contexts. See https://prometheus.io/docs/alerting/latest/configuration/#configuration-file
     */
    @JsonProperty("mattermost")
    public void setMattermost(GlobalMattermostConfig mattermost) {
        this.mattermost = mattermost;
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
     * pagerdutyUrl defines the default Pagerduty URL.
     */
    @JsonProperty("pagerdutyUrl")
    public String getPagerdutyUrl() {
        return pagerdutyUrl;
    }

    /**
     * pagerdutyUrl defines the default Pagerduty URL.
     */
    @JsonProperty("pagerdutyUrl")
    public void setPagerdutyUrl(String pagerdutyUrl) {
        this.pagerdutyUrl = pagerdutyUrl;
    }

    /**
     * resolveTimeout defines the default value used by alertmanager if the alert does not include EndsAt, after this time passes it can declare the alert as resolved if it has not been updated. This has no impact on alerts from Prometheus, as they always include EndsAt.
     */
    @JsonProperty("resolveTimeout")
    public String getResolveTimeout() {
        return resolveTimeout;
    }

    /**
     * resolveTimeout defines the default value used by alertmanager if the alert does not include EndsAt, after this time passes it can declare the alert as resolved if it has not been updated. This has no impact on alerts from Prometheus, as they always include EndsAt.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AlertmanagerGlobalConfig)) {
            return false;
        }
        AlertmanagerGlobalConfig other = (AlertmanagerGlobalConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$jira = this.getJira();
        Object other$jira = other.getJira();
        if (this$jira == null ? other$jira != null : !this$jira.equals(other$jira)) {
            return false;
        }
        Object this$mattermost = this.getMattermost();
        Object other$mattermost = other.getMattermost();
        if (this$mattermost == null ? other$mattermost != null : !this$mattermost.equals(other$mattermost)) {
            return false;
        }
        Object this$opsGenieApiKey = this.getOpsGenieApiKey();
        Object other$opsGenieApiKey = other.getOpsGenieApiKey();
        if (this$opsGenieApiKey == null ? other$opsGenieApiKey != null : !this$opsGenieApiKey.equals(other$opsGenieApiKey)) {
            return false;
        }
        Object this$opsGenieApiUrl = this.getOpsGenieApiUrl();
        Object other$opsGenieApiUrl = other.getOpsGenieApiUrl();
        if (this$opsGenieApiUrl == null ? other$opsGenieApiUrl != null : !this$opsGenieApiUrl.equals(other$opsGenieApiUrl)) {
            return false;
        }
        Object this$pagerdutyUrl = this.getPagerdutyUrl();
        Object other$pagerdutyUrl = other.getPagerdutyUrl();
        if (this$pagerdutyUrl == null ? other$pagerdutyUrl != null : !this$pagerdutyUrl.equals(other$pagerdutyUrl)) {
            return false;
        }
        Object this$resolveTimeout = this.getResolveTimeout();
        Object other$resolveTimeout = other.getResolveTimeout();
        if (this$resolveTimeout == null ? other$resolveTimeout != null : !this$resolveTimeout.equals(other$resolveTimeout)) {
            return false;
        }
        Object this$rocketChat = this.getRocketChat();
        Object other$rocketChat = other.getRocketChat();
        if (this$rocketChat == null ? other$rocketChat != null : !this$rocketChat.equals(other$rocketChat)) {
            return false;
        }
        Object this$slackApiUrl = this.getSlackApiUrl();
        Object other$slackApiUrl = other.getSlackApiUrl();
        if (this$slackApiUrl == null ? other$slackApiUrl != null : !this$slackApiUrl.equals(other$slackApiUrl)) {
            return false;
        }
        Object this$smtp = this.getSmtp();
        Object other$smtp = other.getSmtp();
        if (this$smtp == null ? other$smtp != null : !this$smtp.equals(other$smtp)) {
            return false;
        }
        Object this$telegram = this.getTelegram();
        Object other$telegram = other.getTelegram();
        if (this$telegram == null ? other$telegram != null : !this$telegram.equals(other$telegram)) {
            return false;
        }
        Object this$victorops = this.getVictorops();
        Object other$victorops = other.getVictorops();
        if (this$victorops == null ? other$victorops != null : !this$victorops.equals(other$victorops)) {
            return false;
        }
        Object this$webex = this.getWebex();
        Object other$webex = other.getWebex();
        if (this$webex == null ? other$webex != null : !this$webex.equals(other$webex)) {
            return false;
        }
        Object this$wechat = this.getWechat();
        Object other$wechat = other.getWechat();
        if (this$wechat == null ? other$wechat != null : !this$wechat.equals(other$wechat)) {
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
        return other instanceof AlertmanagerGlobalConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $jira = this.getJira();
        result = result * prime + ($jira == null ? 43 : $jira.hashCode());
        Object $mattermost = this.getMattermost();
        result = result * prime + ($mattermost == null ? 43 : $mattermost.hashCode());
        Object $opsGenieApiKey = this.getOpsGenieApiKey();
        result = result * prime + ($opsGenieApiKey == null ? 43 : $opsGenieApiKey.hashCode());
        Object $opsGenieApiUrl = this.getOpsGenieApiUrl();
        result = result * prime + ($opsGenieApiUrl == null ? 43 : $opsGenieApiUrl.hashCode());
        Object $pagerdutyUrl = this.getPagerdutyUrl();
        result = result * prime + ($pagerdutyUrl == null ? 43 : $pagerdutyUrl.hashCode());
        Object $resolveTimeout = this.getResolveTimeout();
        result = result * prime + ($resolveTimeout == null ? 43 : $resolveTimeout.hashCode());
        Object $rocketChat = this.getRocketChat();
        result = result * prime + ($rocketChat == null ? 43 : $rocketChat.hashCode());
        Object $slackApiUrl = this.getSlackApiUrl();
        result = result * prime + ($slackApiUrl == null ? 43 : $slackApiUrl.hashCode());
        Object $smtp = this.getSmtp();
        result = result * prime + ($smtp == null ? 43 : $smtp.hashCode());
        Object $telegram = this.getTelegram();
        result = result * prime + ($telegram == null ? 43 : $telegram.hashCode());
        Object $victorops = this.getVictorops();
        result = result * prime + ($victorops == null ? 43 : $victorops.hashCode());
        Object $webex = this.getWebex();
        result = result * prime + ($webex == null ? 43 : $webex.hashCode());
        Object $wechat = this.getWechat();
        result = result * prime + ($wechat == null ? 43 : $wechat.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AlertmanagerGlobalConfig(" + "httpConfig=" + this.getHttpConfig() + ", jira=" + this.getJira() + ", mattermost=" + this.getMattermost() + ", opsGenieApiKey=" + this.getOpsGenieApiKey() + ", opsGenieApiUrl=" + this.getOpsGenieApiUrl() + ", pagerdutyUrl=" + this.getPagerdutyUrl() + ", resolveTimeout=" + this.getResolveTimeout() + ", rocketChat=" + this.getRocketChat() + ", slackApiUrl=" + this.getSlackApiUrl() + ", smtp=" + this.getSmtp() + ", telegram=" + this.getTelegram() + ", victorops=" + this.getVictorops() + ", webex=" + this.getWebex() + ", wechat=" + this.getWechat() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
