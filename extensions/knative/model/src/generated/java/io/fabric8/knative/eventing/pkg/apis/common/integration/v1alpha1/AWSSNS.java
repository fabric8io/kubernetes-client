
package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "arn",
    "autoCreateTopic",
    "overrideEndpoint",
    "region",
    "uriEndpointOverride"
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
public class AWSSNS implements Editable<AWSSNSBuilder>, KubernetesResource
{

    @JsonProperty("arn")
    private String arn;
    @JsonProperty("autoCreateTopic")
    private Boolean autoCreateTopic;
    @JsonProperty("overrideEndpoint")
    private Boolean overrideEndpoint;
    @JsonProperty("region")
    private String region;
    @JsonProperty("uriEndpointOverride")
    private String uriEndpointOverride;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSSNS() {
    }

    public AWSSNS(String arn, Boolean autoCreateTopic, Boolean overrideEndpoint, String region, String uriEndpointOverride) {
        super();
        this.arn = arn;
        this.autoCreateTopic = autoCreateTopic;
        this.overrideEndpoint = overrideEndpoint;
        this.region = region;
        this.uriEndpointOverride = uriEndpointOverride;
    }

    /**
     * Embeds AWSCommon to inherit its fields in JSON
     */
    @JsonProperty("arn")
    public String getArn() {
        return arn;
    }

    /**
     * Embeds AWSCommon to inherit its fields in JSON
     */
    @JsonProperty("arn")
    public void setArn(String arn) {
        this.arn = arn;
    }

    /**
     * SNS ARN
     */
    @JsonProperty("autoCreateTopic")
    public Boolean getAutoCreateTopic() {
        return autoCreateTopic;
    }

    /**
     * SNS ARN
     */
    @JsonProperty("autoCreateTopic")
    public void setAutoCreateTopic(Boolean autoCreateTopic) {
        this.autoCreateTopic = autoCreateTopic;
    }

    /**
     * Override endpoint URI
     */
    @JsonProperty("overrideEndpoint")
    public Boolean getOverrideEndpoint() {
        return overrideEndpoint;
    }

    /**
     * Override endpoint URI
     */
    @JsonProperty("overrideEndpoint")
    public void setOverrideEndpoint(Boolean overrideEndpoint) {
        this.overrideEndpoint = overrideEndpoint;
    }

    /**
     * Auth is the S3 authentication (accessKey/secretKey) configuration.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Auth is the S3 authentication (accessKey/secretKey) configuration.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * AWS region
     */
    @JsonProperty("uriEndpointOverride")
    public String getUriEndpointOverride() {
        return uriEndpointOverride;
    }

    /**
     * AWS region
     */
    @JsonProperty("uriEndpointOverride")
    public void setUriEndpointOverride(String uriEndpointOverride) {
        this.uriEndpointOverride = uriEndpointOverride;
    }

    @JsonIgnore
    public AWSSNSBuilder edit() {
        return new AWSSNSBuilder(this);
    }

    @JsonIgnore
    public AWSSNSBuilder toBuilder() {
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
        if (!(o instanceof AWSSNS)) {
            return false;
        }
        AWSSNS other = (AWSSNS) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$arn = this.getArn();
        Object other$arn = other.getArn();
        if (this$arn == null ? other$arn != null : !this$arn.equals(other$arn)) {
            return false;
        }
        Object this$autoCreateTopic = this.getAutoCreateTopic();
        Object other$autoCreateTopic = other.getAutoCreateTopic();
        if (this$autoCreateTopic == null ? other$autoCreateTopic != null : !this$autoCreateTopic.equals(other$autoCreateTopic)) {
            return false;
        }
        Object this$overrideEndpoint = this.getOverrideEndpoint();
        Object other$overrideEndpoint = other.getOverrideEndpoint();
        if (this$overrideEndpoint == null ? other$overrideEndpoint != null : !this$overrideEndpoint.equals(other$overrideEndpoint)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$uriEndpointOverride = this.getUriEndpointOverride();
        Object other$uriEndpointOverride = other.getUriEndpointOverride();
        if (this$uriEndpointOverride == null ? other$uriEndpointOverride != null : !this$uriEndpointOverride.equals(other$uriEndpointOverride)) {
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
        return other instanceof AWSSNS;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $arn = this.getArn();
        result = result * prime + ($arn == null ? 43 : $arn.hashCode());
        Object $autoCreateTopic = this.getAutoCreateTopic();
        result = result * prime + ($autoCreateTopic == null ? 43 : $autoCreateTopic.hashCode());
        Object $overrideEndpoint = this.getOverrideEndpoint();
        result = result * prime + ($overrideEndpoint == null ? 43 : $overrideEndpoint.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $uriEndpointOverride = this.getUriEndpointOverride();
        result = result * prime + ($uriEndpointOverride == null ? 43 : $uriEndpointOverride.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSSNS(" + "arn=" + this.getArn() + ", autoCreateTopic=" + this.getAutoCreateTopic() + ", overrideEndpoint=" + this.getOverrideEndpoint() + ", region=" + this.getRegion() + ", uriEndpointOverride=" + this.getUriEndpointOverride() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
