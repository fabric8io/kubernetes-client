
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureDiskEncryptionSet defines the configuration for a disk encryption set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "resourceGroup",
    "subscriptionID"
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
public class AzureDiskEncryptionSet implements Editable<AzureDiskEncryptionSetBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureDiskEncryptionSet() {
    }

    public AzureDiskEncryptionSet(String name, String resourceGroup, String subscriptionID) {
        super();
        this.name = name;
        this.resourceGroup = resourceGroup;
        this.subscriptionID = subscriptionID;
    }

    /**
     * name is the name of the disk encryption set that will be set on the default storage class. The value should consist of only alphanumberic characters, underscores (_), hyphens, and be at most 80 characters in length.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the disk encryption set that will be set on the default storage class. The value should consist of only alphanumberic characters, underscores (_), hyphens, and be at most 80 characters in length.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * resourceGroup defines the Azure resource group that contains the disk encryption set. The value should consist of only alphanumberic characters, underscores (_), parentheses, hyphens and periods. The value should not end in a period and be at most 90 characters in length.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * resourceGroup defines the Azure resource group that contains the disk encryption set. The value should consist of only alphanumberic characters, underscores (_), parentheses, hyphens and periods. The value should not end in a period and be at most 90 characters in length.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * subscriptionID defines the Azure subscription that contains the disk encryption set. The value should meet the following conditions: 1. It should be a 128-bit number. 2. It should be 36 characters (32 hexadecimal characters and 4 hyphens) long. 3. It should be displayed in five groups separated by hyphens (-). 4. The first group should be 8 characters long. 5. The second, third, and fourth groups should be 4 characters long. 6. The fifth group should be 12 characters long. An Example SubscrionID: f2007bbf-f802-4a47-9336-cf7c6b89b378
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * subscriptionID defines the Azure subscription that contains the disk encryption set. The value should meet the following conditions: 1. It should be a 128-bit number. 2. It should be 36 characters (32 hexadecimal characters and 4 hyphens) long. 3. It should be displayed in five groups separated by hyphens (-). 4. The first group should be 8 characters long. 5. The second, third, and fourth groups should be 4 characters long. 6. The fifth group should be 12 characters long. An Example SubscrionID: f2007bbf-f802-4a47-9336-cf7c6b89b378
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    @JsonIgnore
    public AzureDiskEncryptionSetBuilder edit() {
        return new AzureDiskEncryptionSetBuilder(this);
    }

    @JsonIgnore
    public AzureDiskEncryptionSetBuilder toBuilder() {
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
