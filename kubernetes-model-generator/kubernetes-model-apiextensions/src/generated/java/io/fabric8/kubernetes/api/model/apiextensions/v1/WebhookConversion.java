
package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
 * WebhookConversion describes how to call a conversion webhook
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientConfig",
    "conversionReviewVersions"
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
public class WebhookConversion implements Editable<WebhookConversionBuilder>, KubernetesResource
{

    @JsonProperty("clientConfig")
    private WebhookClientConfig clientConfig;
    @JsonProperty("conversionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> conversionReviewVersions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebhookConversion() {
    }

    public WebhookConversion(WebhookClientConfig clientConfig, List<String> conversionReviewVersions) {
        super();
        this.clientConfig = clientConfig;
        this.conversionReviewVersions = conversionReviewVersions;
    }

    /**
     * WebhookConversion describes how to call a conversion webhook
     */
    @JsonProperty("clientConfig")
    public WebhookClientConfig getClientConfig() {
        return clientConfig;
    }

    /**
     * WebhookConversion describes how to call a conversion webhook
     */
    @JsonProperty("clientConfig")
    public void setClientConfig(WebhookClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    /**
     * conversionReviewVersions is an ordered list of preferred `ConversionReview` versions the Webhook expects. The API server will use the first version in the list which it supports. If none of the versions specified in this list are supported by API server, conversion will fail for the custom resource. If a persisted Webhook configuration specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will fail.
     */
    @JsonProperty("conversionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConversionReviewVersions() {
        return conversionReviewVersions;
    }

    /**
     * conversionReviewVersions is an ordered list of preferred `ConversionReview` versions the Webhook expects. The API server will use the first version in the list which it supports. If none of the versions specified in this list are supported by API server, conversion will fail for the custom resource. If a persisted Webhook configuration specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will fail.
     */
    @JsonProperty("conversionReviewVersions")
    public void setConversionReviewVersions(List<String> conversionReviewVersions) {
        this.conversionReviewVersions = conversionReviewVersions;
    }

    @JsonIgnore
    public WebhookConversionBuilder edit() {
        return new WebhookConversionBuilder(this);
    }

    @JsonIgnore
    public WebhookConversionBuilder toBuilder() {
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
        if (!(o instanceof WebhookConversion)) {
            return false;
        }
        WebhookConversion other = (WebhookConversion) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientConfig = this.getClientConfig();
        Object other$clientConfig = other.getClientConfig();
        if (this$clientConfig == null ? other$clientConfig != null : !this$clientConfig.equals(other$clientConfig)) {
            return false;
        }
        Object this$conversionReviewVersions = this.getConversionReviewVersions();
        Object other$conversionReviewVersions = other.getConversionReviewVersions();
        if (this$conversionReviewVersions == null ? other$conversionReviewVersions != null : !this$conversionReviewVersions.equals(other$conversionReviewVersions)) {
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
        return other instanceof WebhookConversion;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientConfig = this.getClientConfig();
        result = result * prime + ($clientConfig == null ? 43 : $clientConfig.hashCode());
        Object $conversionReviewVersions = this.getConversionReviewVersions();
        result = result * prime + ($conversionReviewVersions == null ? 43 : $conversionReviewVersions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WebhookConversion(" + "clientConfig=" + this.getClientConfig() + ", conversionReviewVersions=" + this.getConversionReviewVersions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
