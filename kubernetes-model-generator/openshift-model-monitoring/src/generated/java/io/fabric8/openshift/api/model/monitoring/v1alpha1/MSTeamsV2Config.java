
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
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
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * Whether to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    /**
     * Whether to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    /**
     * Message body template.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * Message body template.
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Message title template.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Message title template.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
     */
    @JsonProperty("webhookURL")
    public SecretKeySelector getWebhookURL() {
        return webhookURL;
    }

    /**
     * MSTeamsV2Config configures notifications via Microsoft Teams using the new message format with adaptive cards as required by flows See https://prometheus.io/docs/alerting/latest/configuration/#msteamsv2_config It requires Alertmanager &gt;= 0.28.0.
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

}
