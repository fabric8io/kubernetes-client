
package io.fabric8.openshift.api.model.machine.v1alpha1;

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
 * blockDeviceStorage is the storage type of a block device to create and contains additional storage options.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "volume"
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
public class BlockDeviceStorage implements Editable<BlockDeviceStorageBuilder>, KubernetesResource
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("volume")
    private BlockDeviceVolume volume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BlockDeviceStorage() {
    }

    public BlockDeviceStorage(String type, BlockDeviceVolume volume) {
        super();
        this.type = type;
        this.volume = volume;
    }

    /**
     * type is the type of block device to create. This can be either "Volume" or "Local".
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of block device to create. This can be either "Volume" or "Local".
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * blockDeviceStorage is the storage type of a block device to create and contains additional storage options.
     */
    @JsonProperty("volume")
    public BlockDeviceVolume getVolume() {
        return volume;
    }

    /**
     * blockDeviceStorage is the storage type of a block device to create and contains additional storage options.
     */
    @JsonProperty("volume")
    public void setVolume(BlockDeviceVolume volume) {
        this.volume = volume;
    }

    @JsonIgnore
    public BlockDeviceStorageBuilder edit() {
        return new BlockDeviceStorageBuilder(this);
    }

    @JsonIgnore
    public BlockDeviceStorageBuilder toBuilder() {
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
        if (!(o instanceof BlockDeviceStorage)) {
            return false;
        }
        BlockDeviceStorage other = (BlockDeviceStorage) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$volume = this.getVolume();
        Object other$volume = other.getVolume();
        if (this$volume == null ? other$volume != null : !this$volume.equals(other$volume)) {
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
        return other instanceof BlockDeviceStorage;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $volume = this.getVolume();
        result = result * prime + ($volume == null ? 43 : $volume.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BlockDeviceStorage(" + "type=" + this.getType() + ", volume=" + this.getVolume() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
