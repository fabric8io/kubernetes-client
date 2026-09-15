
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
 * StorageResourceReference holds reference information of a storage resource (storage container, data source image, etc.)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "referenceName",
    "uuid"
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
public class StorageResourceReference implements Editable<StorageResourceReferenceBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("referenceName")
    private String referenceName;
    @JsonProperty("uuid")
    private String uuid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StorageResourceReference() {
    }

    public StorageResourceReference(String name, String referenceName, String uuid) {
        super();
        this.name = name;
        this.referenceName = referenceName;
        this.uuid = uuid;
    }

    /**
     * Name is the name of the storage container resource in the Prism Element.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the storage container resource in the Prism Element.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ReferenceName is the identifier of the storage resource configured in the FailureDomain.
     */
    @JsonProperty("referenceName")
    public String getReferenceName() {
        return referenceName;
    }

    /**
     * ReferenceName is the identifier of the storage resource configured in the FailureDomain.
     */
    @JsonProperty("referenceName")
    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    /**
     * UUID is the UUID of the storage container resource in the Prism Element.
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * UUID is the UUID of the storage container resource in the Prism Element.
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonIgnore
    public StorageResourceReferenceBuilder edit() {
        return new StorageResourceReferenceBuilder(this);
    }

    @JsonIgnore
    public StorageResourceReferenceBuilder toBuilder() {
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
        if (!(o instanceof StorageResourceReference)) {
            return false;
        }
        StorageResourceReference other = (StorageResourceReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$referenceName = this.getReferenceName();
        Object other$referenceName = other.getReferenceName();
        if (this$referenceName == null ? other$referenceName != null : !this$referenceName.equals(other$referenceName)) {
            return false;
        }
        Object this$uuid = this.getUuid();
        Object other$uuid = other.getUuid();
        if (this$uuid == null ? other$uuid != null : !this$uuid.equals(other$uuid)) {
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
        return other instanceof StorageResourceReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $referenceName = this.getReferenceName();
        result = result * prime + ($referenceName == null ? 43 : $referenceName.hashCode());
        Object $uuid = this.getUuid();
        result = result * prime + ($uuid == null ? 43 : $uuid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StorageResourceReference(" + "name=" + this.getName() + ", referenceName=" + this.getReferenceName() + ", uuid=" + this.getUuid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
