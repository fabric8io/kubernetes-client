
package io.fabric8.volumesnapshot.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "boundVolumeSnapshotContentName",
    "creationTime",
    "error",
    "readyToUse",
    "restoreSize"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class VolumeSnapshotStatus implements KubernetesResource
{

    @JsonProperty("boundVolumeSnapshotContentName")
    private String boundVolumeSnapshotContentName;
    @JsonProperty("creationTime")
    private java.lang.String creationTime;
    @JsonProperty("error")
    private VolumeSnapshotError error;
    @JsonProperty("readyToUse")
    private Boolean readyToUse;
    @JsonProperty("restoreSize")
    private Quantity restoreSize;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolumeSnapshotStatus() {
    }

    /**
     * 
     * @param creationTime
     * @param restoreSize
     * @param readyToUse
     * @param error
     * @param boundVolumeSnapshotContentName
     */
    public VolumeSnapshotStatus(String boundVolumeSnapshotContentName, java.lang.String creationTime, VolumeSnapshotError error, Boolean readyToUse, Quantity restoreSize) {
        super();
        this.boundVolumeSnapshotContentName = boundVolumeSnapshotContentName;
        this.creationTime = creationTime;
        this.error = error;
        this.readyToUse = readyToUse;
        this.restoreSize = restoreSize;
    }

    @JsonProperty("boundVolumeSnapshotContentName")
    public String getBoundVolumeSnapshotContentName() {
        return boundVolumeSnapshotContentName;
    }

    @JsonProperty("boundVolumeSnapshotContentName")
    public void setBoundVolumeSnapshotContentName(String boundVolumeSnapshotContentName) {
        this.boundVolumeSnapshotContentName = boundVolumeSnapshotContentName;
    }

    @JsonProperty("creationTime")
    public java.lang.String getCreationTime() {
        return creationTime;
    }

    @JsonProperty("creationTime")
    public void setCreationTime(java.lang.String creationTime) {
        this.creationTime = creationTime;
    }

    @JsonProperty("error")
    public VolumeSnapshotError getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(VolumeSnapshotError error) {
        this.error = error;
    }

    @JsonProperty("readyToUse")
    public Boolean getReadyToUse() {
        return readyToUse;
    }

    @JsonProperty("readyToUse")
    public void setReadyToUse(Boolean readyToUse) {
        this.readyToUse = readyToUse;
    }

    @JsonProperty("restoreSize")
    public Quantity getRestoreSize() {
        return restoreSize;
    }

    @JsonProperty("restoreSize")
    public void setRestoreSize(Quantity restoreSize) {
        this.restoreSize = restoreSize;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
