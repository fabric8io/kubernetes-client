
package io.fabric8.openshift.api.model.hive.azure.v1;

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
 * DiskEncryptionSet defines the configuration for a disk encryption set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "resourceGroup",
    "subscriptionId"
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
public class DiskEncryptionSet implements Editable<DiskEncryptionSetBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("subscriptionId")
    private String subscriptionId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DiskEncryptionSet() {
    }

    public DiskEncryptionSet(String name, String resourceGroup, String subscriptionId) {
        super();
        this.name = name;
        this.resourceGroup = resourceGroup;
        this.subscriptionId = subscriptionId;
    }

    /**
     * Name is the name of the disk encryption set.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the disk encryption set.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ResourceGroup defines the Azure resource group used by the disk encryption set.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * ResourceGroup defines the Azure resource group used by the disk encryption set.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * SubscriptionID defines the Azure subscription the disk encryption set is in.
     */
    @JsonProperty("subscriptionId")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * SubscriptionID defines the Azure subscription the disk encryption set is in.
     */
    @JsonProperty("subscriptionId")
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @JsonIgnore
    public DiskEncryptionSetBuilder edit() {
        return new DiskEncryptionSetBuilder(this);
    }

    @JsonIgnore
    public DiskEncryptionSetBuilder toBuilder() {
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
        if (!(o instanceof DiskEncryptionSet)) {
            return false;
        }
        DiskEncryptionSet other = (DiskEncryptionSet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$resourceGroup = this.getResourceGroup();
        Object other$resourceGroup = other.getResourceGroup();
        if (this$resourceGroup == null ? other$resourceGroup != null : !this$resourceGroup.equals(other$resourceGroup)) {
            return false;
        }
        Object this$subscriptionId = this.getSubscriptionId();
        Object other$subscriptionId = other.getSubscriptionId();
        if (this$subscriptionId == null ? other$subscriptionId != null : !this$subscriptionId.equals(other$subscriptionId)) {
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
        return other instanceof DiskEncryptionSet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $resourceGroup = this.getResourceGroup();
        result = result * prime + ($resourceGroup == null ? 43 : $resourceGroup.hashCode());
        Object $subscriptionId = this.getSubscriptionId();
        result = result * prime + ($subscriptionId == null ? 43 : $subscriptionId.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DiskEncryptionSet(" + "name=" + this.getName() + ", resourceGroup=" + this.getResourceGroup() + ", subscriptionId=" + this.getSubscriptionId() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
