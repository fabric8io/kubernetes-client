
package io.fabric8.openshift.api.model.machine.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "availabilityZone",
    "deviceType",
    "diskSize",
    "sourceType",
    "sourceUUID",
    "volumeType"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class RootVolume implements Editable<RootVolumeBuilder> , KubernetesResource
{

    @JsonProperty("availabilityZone")
    private String availabilityZone;
    @JsonProperty("deviceType")
    private String deviceType;
    @JsonProperty("diskSize")
    private Integer diskSize;
    @JsonProperty("sourceType")
    private String sourceType;
    @JsonProperty("sourceUUID")
    private String sourceUUID;
    @JsonProperty("volumeType")
    private String volumeType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RootVolume() {
    }

    public RootVolume(String availabilityZone, String deviceType, Integer diskSize, String sourceType, String sourceUUID, String volumeType) {
        super();
        this.availabilityZone = availabilityZone;
        this.deviceType = deviceType;
        this.diskSize = diskSize;
        this.sourceType = sourceType;
        this.sourceUUID = sourceUUID;
        this.volumeType = volumeType;
    }

    @JsonProperty("availabilityZone")
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    @JsonProperty("availabilityZone")
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    @JsonProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    @JsonProperty("deviceType")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @JsonProperty("diskSize")
    public Integer getDiskSize() {
        return diskSize;
    }

    @JsonProperty("diskSize")
    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
    }

    @JsonProperty("sourceType")
    public String getSourceType() {
        return sourceType;
    }

    @JsonProperty("sourceType")
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @JsonProperty("sourceUUID")
    public String getSourceUUID() {
        return sourceUUID;
    }

    @JsonProperty("sourceUUID")
    public void setSourceUUID(String sourceUUID) {
        this.sourceUUID = sourceUUID;
    }

    @JsonProperty("volumeType")
    public String getVolumeType() {
        return volumeType;
    }

    @JsonProperty("volumeType")
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    @JsonIgnore
    public RootVolumeBuilder edit() {
        return new RootVolumeBuilder(this);
    }

    @JsonIgnore
    public RootVolumeBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
