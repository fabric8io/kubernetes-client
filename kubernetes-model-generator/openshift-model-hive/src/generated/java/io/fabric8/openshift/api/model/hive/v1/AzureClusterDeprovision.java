
package io.fabric8.openshift.api.model.hive.v1;

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
 * AzureClusterDeprovision contains Azure-specific configuration for a ClusterDeprovision
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudName",
    "credentialsSecretRef",
    "resourceGroupName"
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
public class AzureClusterDeprovision implements Editable<AzureClusterDeprovisionBuilder>, KubernetesResource
{

    @JsonProperty("cloudName")
    private String cloudName;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureClusterDeprovision() {
    }

    public AzureClusterDeprovision(String cloudName, LocalObjectReference credentialsSecretRef, String resourceGroupName) {
        super();
        this.cloudName = cloudName;
        this.credentialsSecretRef = credentialsSecretRef;
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * cloudName is the name of the Azure cloud environment which can be used to configure the Azure SDK with the appropriate Azure API endpoints. If empty, the value is equal to "AzurePublicCloud".
     */
    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    /**
     * cloudName is the name of the Azure cloud environment which can be used to configure the Azure SDK with the appropriate Azure API endpoints. If empty, the value is equal to "AzurePublicCloud".
     */
    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    /**
     * AzureClusterDeprovision contains Azure-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * AzureClusterDeprovision contains Azure-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * ResourceGroupName is the name of the resource group where the cluster was installed. Required for new deprovisions (schema notwithstanding).
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * ResourceGroupName is the name of the resource group where the cluster was installed. Required for new deprovisions (schema notwithstanding).
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @JsonIgnore
    public AzureClusterDeprovisionBuilder edit() {
        return new AzureClusterDeprovisionBuilder(this);
    }

    @JsonIgnore
    public AzureClusterDeprovisionBuilder toBuilder() {
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
        if (!(o instanceof AzureClusterDeprovision)) {
            return false;
        }
        AzureClusterDeprovision other = (AzureClusterDeprovision) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cloudName = this.getCloudName();
        Object other$cloudName = other.getCloudName();
        if (this$cloudName == null ? other$cloudName != null : !this$cloudName.equals(other$cloudName)) {
            return false;
        }
        Object this$credentialsSecretRef = this.getCredentialsSecretRef();
        Object other$credentialsSecretRef = other.getCredentialsSecretRef();
        if (this$credentialsSecretRef == null ? other$credentialsSecretRef != null : !this$credentialsSecretRef.equals(other$credentialsSecretRef)) {
            return false;
        }
        Object this$resourceGroupName = this.getResourceGroupName();
        Object other$resourceGroupName = other.getResourceGroupName();
        if (this$resourceGroupName == null ? other$resourceGroupName != null : !this$resourceGroupName.equals(other$resourceGroupName)) {
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
        return other instanceof AzureClusterDeprovision;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cloudName = this.getCloudName();
        result = result * prime + ($cloudName == null ? 43 : $cloudName.hashCode());
        Object $credentialsSecretRef = this.getCredentialsSecretRef();
        result = result * prime + ($credentialsSecretRef == null ? 43 : $credentialsSecretRef.hashCode());
        Object $resourceGroupName = this.getResourceGroupName();
        result = result * prime + ($resourceGroupName == null ? 43 : $resourceGroupName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureClusterDeprovision(" + "cloudName=" + this.getCloudName() + ", credentialsSecretRef=" + this.getCredentialsSecretRef() + ", resourceGroupName=" + this.getResourceGroupName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
