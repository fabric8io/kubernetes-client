
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * GCPPlatformStatus holds the current status of the Google Cloud Platform infrastructure provider.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudLoadBalancerConfig",
    "projectID",
    "region",
    "resourceLabels",
    "resourceTags",
    "universeDomain"
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
public class GCPPlatformStatus implements Editable<GCPPlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("cloudLoadBalancerConfig")
    private CloudLoadBalancerConfig cloudLoadBalancerConfig;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPResourceLabel> resourceLabels = new ArrayList<>();
    @JsonProperty("resourceTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPResourceTag> resourceTags = new ArrayList<>();
    @JsonProperty("universeDomain")
    private String universeDomain;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPPlatformStatus() {
    }

    public GCPPlatformStatus(CloudLoadBalancerConfig cloudLoadBalancerConfig, String projectID, String region, List<GCPResourceLabel> resourceLabels, List<GCPResourceTag> resourceTags, String universeDomain) {
        super();
        this.cloudLoadBalancerConfig = cloudLoadBalancerConfig;
        this.projectID = projectID;
        this.region = region;
        this.resourceLabels = resourceLabels;
        this.resourceTags = resourceTags;
        this.universeDomain = universeDomain;
    }

    /**
     * GCPPlatformStatus holds the current status of the Google Cloud Platform infrastructure provider.
     */
    @JsonProperty("cloudLoadBalancerConfig")
    public CloudLoadBalancerConfig getCloudLoadBalancerConfig() {
        return cloudLoadBalancerConfig;
    }

    /**
     * GCPPlatformStatus holds the current status of the Google Cloud Platform infrastructure provider.
     */
    @JsonProperty("cloudLoadBalancerConfig")
    public void setCloudLoadBalancerConfig(CloudLoadBalancerConfig cloudLoadBalancerConfig) {
        this.cloudLoadBalancerConfig = cloudLoadBalancerConfig;
    }

    /**
     * resourceGroupName is the Project ID for new GCP resources created for the cluster.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * resourceGroupName is the Project ID for new GCP resources created for the cluster.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * region holds the region for new GCP resources created for the cluster.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region holds the region for new GCP resources created for the cluster.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * resourceLabels is a list of additional labels to apply to GCP resources created for the cluster. See https://cloud.google.com/compute/docs/labeling-resources for information on labeling GCP resources. GCP supports a maximum of 64 labels per resource. OpenShift reserves 32 labels for internal use, allowing 32 labels for user configuration.
     */
    @JsonProperty("resourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPResourceLabel> getResourceLabels() {
        return resourceLabels;
    }

    /**
     * resourceLabels is a list of additional labels to apply to GCP resources created for the cluster. See https://cloud.google.com/compute/docs/labeling-resources for information on labeling GCP resources. GCP supports a maximum of 64 labels per resource. OpenShift reserves 32 labels for internal use, allowing 32 labels for user configuration.
     */
    @JsonProperty("resourceLabels")
    public void setResourceLabels(List<GCPResourceLabel> resourceLabels) {
        this.resourceLabels = resourceLabels;
    }

    /**
     * resourceTags is a list of additional tags to apply to GCP resources created for the cluster. See https://cloud.google.com/resource-manager/docs/tags/tags-overview for information on tagging GCP resources. GCP supports a maximum of 50 tags per resource.
     */
    @JsonProperty("resourceTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPResourceTag> getResourceTags() {
        return resourceTags;
    }

    /**
     * resourceTags is a list of additional tags to apply to GCP resources created for the cluster. See https://cloud.google.com/resource-manager/docs/tags/tags-overview for information on tagging GCP resources. GCP supports a maximum of 50 tags per resource.
     */
    @JsonProperty("resourceTags")
    public void setResourceTags(List<GCPResourceTag> resourceTags) {
        this.resourceTags = resourceTags;
    }

    /**
     * universeDomain is the GCP universe domain for the cluster, detected from the installer credentials. Components with their own GCP credentials should read the universe domain from those credentials, as they are the authoritative source. This field is provided for components that do not have GCP credentials and for general observability.<br><p> <br><p> When omitted, standard public GCP (googleapis.com) is assumed.<br><p> <br><p> universeDomain is an optional field that, when specified, must be non-empty and at most 253 characters. It must be a valid DNS subdomain: containing only lowercase alphanumeric characters, '-' or '.', and starting and ending with an alphanumeric character.
     */
    @JsonProperty("universeDomain")
    public String getUniverseDomain() {
        return universeDomain;
    }

    /**
     * universeDomain is the GCP universe domain for the cluster, detected from the installer credentials. Components with their own GCP credentials should read the universe domain from those credentials, as they are the authoritative source. This field is provided for components that do not have GCP credentials and for general observability.<br><p> <br><p> When omitted, standard public GCP (googleapis.com) is assumed.<br><p> <br><p> universeDomain is an optional field that, when specified, must be non-empty and at most 253 characters. It must be a valid DNS subdomain: containing only lowercase alphanumeric characters, '-' or '.', and starting and ending with an alphanumeric character.
     */
    @JsonProperty("universeDomain")
    public void setUniverseDomain(String universeDomain) {
        this.universeDomain = universeDomain;
    }

    @JsonIgnore
    public GCPPlatformStatusBuilder edit() {
        return new GCPPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public GCPPlatformStatusBuilder toBuilder() {
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
        if (!(o instanceof GCPPlatformStatus)) {
            return false;
        }
        GCPPlatformStatus other = (GCPPlatformStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cloudLoadBalancerConfig = this.getCloudLoadBalancerConfig();
        Object other$cloudLoadBalancerConfig = other.getCloudLoadBalancerConfig();
        if (this$cloudLoadBalancerConfig == null ? other$cloudLoadBalancerConfig != null : !this$cloudLoadBalancerConfig.equals(other$cloudLoadBalancerConfig)) {
            return false;
        }
        Object this$projectID = this.getProjectID();
        Object other$projectID = other.getProjectID();
        if (this$projectID == null ? other$projectID != null : !this$projectID.equals(other$projectID)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$resourceLabels = this.getResourceLabels();
        Object other$resourceLabels = other.getResourceLabels();
        if (this$resourceLabels == null ? other$resourceLabels != null : !this$resourceLabels.equals(other$resourceLabels)) {
            return false;
        }
        Object this$resourceTags = this.getResourceTags();
        Object other$resourceTags = other.getResourceTags();
        if (this$resourceTags == null ? other$resourceTags != null : !this$resourceTags.equals(other$resourceTags)) {
            return false;
        }
        Object this$universeDomain = this.getUniverseDomain();
        Object other$universeDomain = other.getUniverseDomain();
        if (this$universeDomain == null ? other$universeDomain != null : !this$universeDomain.equals(other$universeDomain)) {
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
        return other instanceof GCPPlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cloudLoadBalancerConfig = this.getCloudLoadBalancerConfig();
        result = result * prime + ($cloudLoadBalancerConfig == null ? 43 : $cloudLoadBalancerConfig.hashCode());
        Object $projectID = this.getProjectID();
        result = result * prime + ($projectID == null ? 43 : $projectID.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $resourceLabels = this.getResourceLabels();
        result = result * prime + ($resourceLabels == null ? 43 : $resourceLabels.hashCode());
        Object $resourceTags = this.getResourceTags();
        result = result * prime + ($resourceTags == null ? 43 : $resourceTags.hashCode());
        Object $universeDomain = this.getUniverseDomain();
        result = result * prime + ($universeDomain == null ? 43 : $universeDomain.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPPlatformStatus(" + "cloudLoadBalancerConfig=" + this.getCloudLoadBalancerConfig() + ", projectID=" + this.getProjectID() + ", region=" + this.getRegion() + ", resourceLabels=" + this.getResourceLabels() + ", resourceTags=" + this.getResourceTags() + ", universeDomain=" + this.getUniverseDomain() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
