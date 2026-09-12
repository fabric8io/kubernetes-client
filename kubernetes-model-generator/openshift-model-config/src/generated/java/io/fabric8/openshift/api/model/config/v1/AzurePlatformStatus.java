
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
 * AzurePlatformStatus holds the current status of the Azure infrastructure provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "armEndpoint",
    "cloudLoadBalancerConfig",
    "cloudName",
    "networkResourceGroupName",
    "resourceGroupName",
    "resourceTags"
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
public class AzurePlatformStatus implements Editable<AzurePlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("armEndpoint")
    private String armEndpoint;
    @JsonProperty("cloudLoadBalancerConfig")
    private CloudLoadBalancerConfig cloudLoadBalancerConfig;
    @JsonProperty("cloudName")
    private String cloudName;
    @JsonProperty("networkResourceGroupName")
    private String networkResourceGroupName;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("resourceTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AzureResourceTag> resourceTags = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzurePlatformStatus() {
    }

    public AzurePlatformStatus(String armEndpoint, CloudLoadBalancerConfig cloudLoadBalancerConfig, String cloudName, String networkResourceGroupName, String resourceGroupName, List<AzureResourceTag> resourceTags) {
        super();
        this.armEndpoint = armEndpoint;
        this.cloudLoadBalancerConfig = cloudLoadBalancerConfig;
        this.cloudName = cloudName;
        this.networkResourceGroupName = networkResourceGroupName;
        this.resourceGroupName = resourceGroupName;
        this.resourceTags = resourceTags;
    }

    /**
     * armEndpoint specifies a URL to use for resource management in non-soverign clouds such as Azure Stack.
     */
    @JsonProperty("armEndpoint")
    public String getArmEndpoint() {
        return armEndpoint;
    }

    /**
     * armEndpoint specifies a URL to use for resource management in non-soverign clouds such as Azure Stack.
     */
    @JsonProperty("armEndpoint")
    public void setArmEndpoint(String armEndpoint) {
        this.armEndpoint = armEndpoint;
    }

    /**
     * AzurePlatformStatus holds the current status of the Azure infrastructure provider.
     */
    @JsonProperty("cloudLoadBalancerConfig")
    public CloudLoadBalancerConfig getCloudLoadBalancerConfig() {
        return cloudLoadBalancerConfig;
    }

    /**
     * AzurePlatformStatus holds the current status of the Azure infrastructure provider.
     */
    @JsonProperty("cloudLoadBalancerConfig")
    public void setCloudLoadBalancerConfig(CloudLoadBalancerConfig cloudLoadBalancerConfig) {
        this.cloudLoadBalancerConfig = cloudLoadBalancerConfig;
    }

    /**
     * cloudName is the name of the Azure cloud environment which can be used to configure the Azure SDK with the appropriate Azure API endpoints. If empty, the value is equal to `AzurePublicCloud`.
     */
    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    /**
     * cloudName is the name of the Azure cloud environment which can be used to configure the Azure SDK with the appropriate Azure API endpoints. If empty, the value is equal to `AzurePublicCloud`.
     */
    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    /**
     * networkResourceGroupName is the Resource Group for network resources like the Virtual Network and Subnets used by the cluster. If empty, the value is same as ResourceGroupName.
     */
    @JsonProperty("networkResourceGroupName")
    public String getNetworkResourceGroupName() {
        return networkResourceGroupName;
    }

    /**
     * networkResourceGroupName is the Resource Group for network resources like the Virtual Network and Subnets used by the cluster. If empty, the value is same as ResourceGroupName.
     */
    @JsonProperty("networkResourceGroupName")
    public void setNetworkResourceGroupName(String networkResourceGroupName) {
        this.networkResourceGroupName = networkResourceGroupName;
    }

    /**
     * resourceGroupName is the Resource Group for new Azure resources created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * resourceGroupName is the Resource Group for new Azure resources created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * resourceTags is a list of additional tags to apply to Azure resources created for the cluster. See https://docs.microsoft.com/en-us/rest/api/resources/tags for information on tagging Azure resources. Due to limitations on Automation, Content Delivery Network, DNS Azure resources, a maximum of 15 tags may be applied. OpenShift reserves 5 tags for internal use, allowing 10 tags for user configuration.
     */
    @JsonProperty("resourceTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AzureResourceTag> getResourceTags() {
        return resourceTags;
    }

    /**
     * resourceTags is a list of additional tags to apply to Azure resources created for the cluster. See https://docs.microsoft.com/en-us/rest/api/resources/tags for information on tagging Azure resources. Due to limitations on Automation, Content Delivery Network, DNS Azure resources, a maximum of 15 tags may be applied. OpenShift reserves 5 tags for internal use, allowing 10 tags for user configuration.
     */
    @JsonProperty("resourceTags")
    public void setResourceTags(List<AzureResourceTag> resourceTags) {
        this.resourceTags = resourceTags;
    }

    @JsonIgnore
    public AzurePlatformStatusBuilder edit() {
        return new AzurePlatformStatusBuilder(this);
    }

    @JsonIgnore
    public AzurePlatformStatusBuilder toBuilder() {
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
        if (!(o instanceof AzurePlatformStatus)) {
            return false;
        }
        AzurePlatformStatus other = (AzurePlatformStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$armEndpoint = this.getArmEndpoint();
        Object other$armEndpoint = other.getArmEndpoint();
        if (this$armEndpoint == null ? other$armEndpoint != null : !this$armEndpoint.equals(other$armEndpoint)) {
            return false;
        }
        Object this$cloudLoadBalancerConfig = this.getCloudLoadBalancerConfig();
        Object other$cloudLoadBalancerConfig = other.getCloudLoadBalancerConfig();
        if (this$cloudLoadBalancerConfig == null ? other$cloudLoadBalancerConfig != null : !this$cloudLoadBalancerConfig.equals(other$cloudLoadBalancerConfig)) {
            return false;
        }
        Object this$cloudName = this.getCloudName();
        Object other$cloudName = other.getCloudName();
        if (this$cloudName == null ? other$cloudName != null : !this$cloudName.equals(other$cloudName)) {
            return false;
        }
        Object this$networkResourceGroupName = this.getNetworkResourceGroupName();
        Object other$networkResourceGroupName = other.getNetworkResourceGroupName();
        if (this$networkResourceGroupName == null ? other$networkResourceGroupName != null : !this$networkResourceGroupName.equals(other$networkResourceGroupName)) {
            return false;
        }
        Object this$resourceGroupName = this.getResourceGroupName();
        Object other$resourceGroupName = other.getResourceGroupName();
        if (this$resourceGroupName == null ? other$resourceGroupName != null : !this$resourceGroupName.equals(other$resourceGroupName)) {
            return false;
        }
        Object this$resourceTags = this.getResourceTags();
        Object other$resourceTags = other.getResourceTags();
        if (this$resourceTags == null ? other$resourceTags != null : !this$resourceTags.equals(other$resourceTags)) {
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
        return other instanceof AzurePlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $armEndpoint = this.getArmEndpoint();
        result = result * prime + ($armEndpoint == null ? 43 : $armEndpoint.hashCode());
        Object $cloudLoadBalancerConfig = this.getCloudLoadBalancerConfig();
        result = result * prime + ($cloudLoadBalancerConfig == null ? 43 : $cloudLoadBalancerConfig.hashCode());
        Object $cloudName = this.getCloudName();
        result = result * prime + ($cloudName == null ? 43 : $cloudName.hashCode());
        Object $networkResourceGroupName = this.getNetworkResourceGroupName();
        result = result * prime + ($networkResourceGroupName == null ? 43 : $networkResourceGroupName.hashCode());
        Object $resourceGroupName = this.getResourceGroupName();
        result = result * prime + ($resourceGroupName == null ? 43 : $resourceGroupName.hashCode());
        Object $resourceTags = this.getResourceTags();
        result = result * prime + ($resourceTags == null ? 43 : $resourceTags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzurePlatformStatus(" + "armEndpoint=" + this.getArmEndpoint() + ", cloudLoadBalancerConfig=" + this.getCloudLoadBalancerConfig() + ", cloudName=" + this.getCloudName() + ", networkResourceGroupName=" + this.getNetworkResourceGroupName() + ", resourceGroupName=" + this.getResourceGroupName() + ", resourceTags=" + this.getResourceTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
