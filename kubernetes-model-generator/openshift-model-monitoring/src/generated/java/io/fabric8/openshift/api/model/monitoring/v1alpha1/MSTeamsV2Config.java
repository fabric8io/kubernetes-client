
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows. See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpConfig",
    "sendResolved",
    "text",
    "title",
    "webhookURL"
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
public class MSTeamsV2Config implements Editable<MSTeamsV2ConfigBuilder>, KubernetesResource
{

    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("text")
    private String text;
    @JsonProperty("title")
    private String title;
    @JsonProperty("webhookURL")
    private SecretKeySelector webhookURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MSTeamsV2Config() {
    }

    public MSTeamsV2Config(HTTPConfig httpConfig, Boolean sendResolved, String text, String title, SecretKeySelector webhookURL) {
        super();
        this.httpConfig = httpConfig;
        this.sendResolved = sendResolved;
        this.text = text;
        this.title = title;
        this.webhookURL = webhookURL;
    }

    /**
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows. See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows. See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
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
     * text defines the message body template for adaptive card notifications. This contains the detailed content displayed in the Teams adaptive card format.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text defines the message body template for adaptive card notifications. This contains the detailed content displayed in the Teams adaptive card format.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * title defines the message title template for adaptive card notifications. This appears as the main heading in the Teams adaptive card.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title defines the message title template for adaptive card notifications. This appears as the main heading in the Teams adaptive card.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows. See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("webhookURL")
    public SecretKeySelector getWebhookURL() {
        return webhookURL;
    }

    /**
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows. See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("webhookURL")
    public void setWebhookURL(SecretKeySelector webhookURL) {
        this.webhookURL = webhookURL;
    }

    @JsonIgnore
    public MSTeamsV2ConfigBuilder edit() {
        return new MSTeamsV2ConfigBuilder(this);
    }

    @JsonIgnore
    public MSTeamsV2ConfigBuilder toBuilder() {
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
        if (!(o instanceof MSTeamsV2Config)) {
            return false;
        }
        MSTeamsV2Config other = (MSTeamsV2Config) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$text = this.getText();
        Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) {
            return false;
        }
        Object this$title = this.getTitle();
        Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        Object this$webhookURL = this.getWebhookURL();
        Object other$webhookURL = other.getWebhookURL();
        if (this$webhookURL == null ? other$webhookURL != null : !this$webhookURL.equals(other$webhookURL)) {
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
        return other instanceof MSTeamsV2Config;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $text = this.getText();
        result = result * prime + ($text == null ? 43 : $text.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $webhookURL = this.getWebhookURL();
        result = result * prime + ($webhookURL == null ? 43 : $webhookURL.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MSTeamsV2Config(" + "httpConfig=" + this.getHttpConfig() + ", sendResolved=" + this.getSendResolved() + ", text=" + this.getText() + ", title=" + this.getTitle() + ", webhookURL=" + this.getWebhookURL() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
