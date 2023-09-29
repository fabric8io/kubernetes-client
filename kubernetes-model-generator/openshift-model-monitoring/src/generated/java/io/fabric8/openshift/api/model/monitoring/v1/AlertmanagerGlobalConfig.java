
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "httpConfig",
    "opsGenieApiKey",
    "opsGenieApiUrl",
    "pagerdutyUrl",
    "resolveTimeout",
    "slackApiUrl",
    "smtp"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class AlertmanagerGlobalConfig implements Editable<AlertmanagerGlobalConfigBuilder> , KubernetesResource
{

    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("opsGenieApiKey")
    private SecretKeySelector opsGenieApiKey;
    @JsonProperty("opsGenieApiUrl")
    private SecretKeySelector opsGenieApiUrl;
    @JsonProperty("pagerdutyUrl")
    private String pagerdutyUrl;
    @JsonProperty("resolveTimeout")
    private String resolveTimeout;
    @JsonProperty("slackApiUrl")
    private SecretKeySelector slackApiUrl;
    @JsonProperty("smtp")
    private GlobalSMTPConfig smtp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerGlobalConfig() {
    }

    public AlertmanagerGlobalConfig(HTTPConfig httpConfig, SecretKeySelector opsGenieApiKey, SecretKeySelector opsGenieApiUrl, String pagerdutyUrl, String resolveTimeout, SecretKeySelector slackApiUrl, GlobalSMTPConfig smtp) {
        super();
        this.httpConfig = httpConfig;
        this.opsGenieApiKey = opsGenieApiKey;
        this.opsGenieApiUrl = opsGenieApiUrl;
        this.pagerdutyUrl = pagerdutyUrl;
        this.resolveTimeout = resolveTimeout;
        this.slackApiUrl = slackApiUrl;
        this.smtp = smtp;
    }

    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    @JsonProperty("opsGenieApiKey")
    public SecretKeySelector getOpsGenieApiKey() {
        return opsGenieApiKey;
    }

    @JsonProperty("opsGenieApiKey")
    public void setOpsGenieApiKey(SecretKeySelector opsGenieApiKey) {
        this.opsGenieApiKey = opsGenieApiKey;
    }

    @JsonProperty("opsGenieApiUrl")
    public SecretKeySelector getOpsGenieApiUrl() {
        return opsGenieApiUrl;
    }

    @JsonProperty("opsGenieApiUrl")
    public void setOpsGenieApiUrl(SecretKeySelector opsGenieApiUrl) {
        this.opsGenieApiUrl = opsGenieApiUrl;
    }

    @JsonProperty("pagerdutyUrl")
    public String getPagerdutyUrl() {
        return pagerdutyUrl;
    }

    @JsonProperty("pagerdutyUrl")
    public void setPagerdutyUrl(String pagerdutyUrl) {
        this.pagerdutyUrl = pagerdutyUrl;
    }

    @JsonProperty("resolveTimeout")
    public String getResolveTimeout() {
        return resolveTimeout;
    }

    @JsonProperty("resolveTimeout")
    public void setResolveTimeout(String resolveTimeout) {
        this.resolveTimeout = resolveTimeout;
    }

    @JsonProperty("slackApiUrl")
    public SecretKeySelector getSlackApiUrl() {
        return slackApiUrl;
    }

    @JsonProperty("slackApiUrl")
    public void setSlackApiUrl(SecretKeySelector slackApiUrl) {
        this.slackApiUrl = slackApiUrl;
    }

    @JsonProperty("smtp")
    public GlobalSMTPConfig getSmtp() {
        return smtp;
    }

    @JsonProperty("smtp")
    public void setSmtp(GlobalSMTPConfig smtp) {
        this.smtp = smtp;
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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
