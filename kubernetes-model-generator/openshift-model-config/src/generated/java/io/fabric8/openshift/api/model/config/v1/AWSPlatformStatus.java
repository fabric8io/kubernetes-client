
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AWSPlatformStatus holds the current status of the Amazon Web Services infrastructure provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudLoadBalancerConfig",
    "region",
    "resourceTags",
    "serviceEndpoints"
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
public class AWSPlatformStatus implements Editable<AWSPlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("cloudLoadBalancerConfig")
    private CloudLoadBalancerConfig cloudLoadBalancerConfig;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSResourceTag> resourceTags = new ArrayList<>();
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSPlatformStatus() {
    }

    public AWSPlatformStatus(CloudLoadBalancerConfig cloudLoadBalancerConfig, String region, List<AWSResourceTag> resourceTags, List<AWSServiceEndpoint> serviceEndpoints) {
        super();
        this.cloudLoadBalancerConfig = cloudLoadBalancerConfig;
        this.region = region;
        this.resourceTags = resourceTags;
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * AWSPlatformStatus holds the current status of the Amazon Web Services infrastructure provider.
     */
    @JsonProperty("cloudLoadBalancerConfig")
    public CloudLoadBalancerConfig getCloudLoadBalancerConfig() {
        return cloudLoadBalancerConfig;
    }

    /**
     * AWSPlatformStatus holds the current status of the Amazon Web Services infrastructure provider.
     */
    @JsonProperty("cloudLoadBalancerConfig")
    public void setCloudLoadBalancerConfig(CloudLoadBalancerConfig cloudLoadBalancerConfig) {
        this.cloudLoadBalancerConfig = cloudLoadBalancerConfig;
    }

    /**
     * region holds the default AWS region for new AWS resources created by the cluster.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region holds the default AWS region for new AWS resources created by the cluster.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * resourceTags is a list of additional tags to apply to AWS resources created for the cluster. See https://docs.aws.amazon.com/general/latest/gr/aws_tagging.html for information on tagging AWS resources. AWS supports a maximum of 50 tags per resource. OpenShift reserves 25 tags for its use, leaving 25 tags available for the user.
     */
    @JsonProperty("resourceTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSResourceTag> getResourceTags() {
        return resourceTags;
    }

    /**
     * resourceTags is a list of additional tags to apply to AWS resources created for the cluster. See https://docs.aws.amazon.com/general/latest/gr/aws_tagging.html for information on tagging AWS resources. AWS supports a maximum of 50 tags per resource. OpenShift reserves 25 tags for its use, leaving 25 tags available for the user.
     */
    @JsonProperty("resourceTags")
    public void setResourceTags(List<AWSResourceTag> resourceTags) {
        this.resourceTags = resourceTags;
    }

    /**
     * serviceEndpoints list contains custom endpoints which will override default service endpoint of AWS Services. There must be only one ServiceEndpoint for a service.
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * serviceEndpoints list contains custom endpoints which will override default service endpoint of AWS Services. There must be only one ServiceEndpoint for a service.
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<AWSServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonIgnore
    public AWSPlatformStatusBuilder edit() {
        return new AWSPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public AWSPlatformStatusBuilder toBuilder() {
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
        if (!(o instanceof AWSPlatformStatus)) {
            return false;
        }
        AWSPlatformStatus other = (AWSPlatformStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cloudLoadBalancerConfig = this.getCloudLoadBalancerConfig();
        Object other$cloudLoadBalancerConfig = other.getCloudLoadBalancerConfig();
        if (this$cloudLoadBalancerConfig == null ? other$cloudLoadBalancerConfig != null : !this$cloudLoadBalancerConfig.equals(other$cloudLoadBalancerConfig)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$resourceTags = this.getResourceTags();
        Object other$resourceTags = other.getResourceTags();
        if (this$resourceTags == null ? other$resourceTags != null : !this$resourceTags.equals(other$resourceTags)) {
            return false;
        }
        Object this$serviceEndpoints = this.getServiceEndpoints();
        Object other$serviceEndpoints = other.getServiceEndpoints();
        if (this$serviceEndpoints == null ? other$serviceEndpoints != null : !this$serviceEndpoints.equals(other$serviceEndpoints)) {
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
        return other instanceof AWSPlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cloudLoadBalancerConfig = this.getCloudLoadBalancerConfig();
        result = result * prime + ($cloudLoadBalancerConfig == null ? 43 : $cloudLoadBalancerConfig.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $resourceTags = this.getResourceTags();
        result = result * prime + ($resourceTags == null ? 43 : $resourceTags.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSPlatformStatus(" + "cloudLoadBalancerConfig=" + this.getCloudLoadBalancerConfig() + ", region=" + this.getRegion() + ", resourceTags=" + this.getResourceTags() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
