
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * WebhookConfig configures notifications via a generic receiver supporting the webhook payload. See https://prometheus.io/docs/alerting/latest/configuration/#webhook_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpConfig",
    "maxAlerts",
    "sendResolved",
    "timeout",
    "url",
    "urlSecret"
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
public class WebhookConfig implements Editable<WebhookConfigBuilder>, KubernetesResource
{

    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("maxAlerts")
    private Integer maxAlerts;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("timeout")
    private String timeout;
    @JsonProperty("url")
    private String url;
    @JsonProperty("urlSecret")
    private SecretKeySelector urlSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebhookConfig() {
    }

    public WebhookConfig(HTTPConfig httpConfig, Integer maxAlerts, Boolean sendResolved, String timeout, String url, SecretKeySelector urlSecret) {
        super();
        this.httpConfig = httpConfig;
        this.maxAlerts = maxAlerts;
        this.sendResolved = sendResolved;
        this.timeout = timeout;
        this.url = url;
        this.urlSecret = urlSecret;
    }

    /**
     * WebhookConfig configures notifications via a generic receiver supporting the webhook payload. See https://prometheus.io/docs/alerting/latest/configuration/#webhook_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * WebhookConfig configures notifications via a generic receiver supporting the webhook payload. See https://prometheus.io/docs/alerting/latest/configuration/#webhook_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * maxAlerts defines the maximum number of alerts to be sent per webhook message. When 0, all alerts are included in the webhook payload.
     */
    @JsonProperty("maxAlerts")
    public Integer getMaxAlerts() {
        return maxAlerts;
    }

    /**
     * maxAlerts defines the maximum number of alerts to be sent per webhook message. When 0, all alerts are included in the webhook payload.
     */
    @JsonProperty("maxAlerts")
    public void setMaxAlerts(Integer maxAlerts) {
        this.maxAlerts = maxAlerts;
    }

    /**
     * sendResolved defines whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    /**
     * sendResolved defines whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    /**
     * timeout defines the maximum time to wait for a webhook request to complete, before failing the request and allowing it to be retried. It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * timeout defines the maximum time to wait for a webhook request to complete, before failing the request and allowing it to be retried. It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    /**
     * url defines the URL to send HTTP POST requests to. urlSecret takes precedence over url. One of urlSecret and url should be defined.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url defines the URL to send HTTP POST requests to. urlSecret takes precedence over url. One of urlSecret and url should be defined.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * WebhookConfig configures notifications via a generic receiver supporting the webhook payload. See https://prometheus.io/docs/alerting/latest/configuration/#webhook_config
     */
    @JsonProperty("urlSecret")
    public SecretKeySelector getUrlSecret() {
        return urlSecret;
    }

    /**
     * WebhookConfig configures notifications via a generic receiver supporting the webhook payload. See https://prometheus.io/docs/alerting/latest/configuration/#webhook_config
     */
    @JsonProperty("urlSecret")
    public void setUrlSecret(SecretKeySelector urlSecret) {
        this.urlSecret = urlSecret;
    }

    @JsonIgnore
    public WebhookConfigBuilder edit() {
        return new WebhookConfigBuilder(this);
    }

    @JsonIgnore
    public WebhookConfigBuilder toBuilder() {
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
        if (!(o instanceof WebhookConfig)) {
            return false;
        }
        WebhookConfig other = (WebhookConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$maxAlerts = this.getMaxAlerts();
        Object other$maxAlerts = other.getMaxAlerts();
        if (this$maxAlerts == null ? other$maxAlerts != null : !this$maxAlerts.equals(other$maxAlerts)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$urlSecret = this.getUrlSecret();
        Object other$urlSecret = other.getUrlSecret();
        if (this$urlSecret == null ? other$urlSecret != null : !this$urlSecret.equals(other$urlSecret)) {
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
        return other instanceof WebhookConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $maxAlerts = this.getMaxAlerts();
        result = result * prime + ($maxAlerts == null ? 43 : $maxAlerts.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $urlSecret = this.getUrlSecret();
        result = result * prime + ($urlSecret == null ? 43 : $urlSecret.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WebhookConfig(" + "httpConfig=" + this.getHttpConfig() + ", maxAlerts=" + this.getMaxAlerts() + ", sendResolved=" + this.getSendResolved() + ", timeout=" + this.getTimeout() + ", url=" + this.getUrl() + ", urlSecret=" + this.getUrlSecret() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
