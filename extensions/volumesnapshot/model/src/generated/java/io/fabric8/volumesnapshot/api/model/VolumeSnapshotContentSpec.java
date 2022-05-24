
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
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
    "deletionPolicy",
    "driver",
    "source",
    "volumeSnapshotClassName",
    "volumeSnapshotRef"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class VolumeSnapshotContentSpec implements KubernetesResource
{

    @JsonProperty("deletionPolicy")
    private java.lang.String deletionPolicy;
    @JsonProperty("driver")
    private java.lang.String driver;
    @JsonProperty("source")
    private VolumeSnapshotContentSource source;
    @JsonProperty("volumeSnapshotClassName")
    private String volumeSnapshotClassName;
    @JsonProperty("volumeSnapshotRef")
    private io.fabric8.kubernetes.api.model.ObjectReference volumeSnapshotRef;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolumeSnapshotContentSpec() {
    }

    /**
     * 
     * @param volumeSnapshotRef
     * @param driver
     * @param volumeSnapshotClassName
     * @param deletionPolicy
     * @param source
     */
    public VolumeSnapshotContentSpec(java.lang.String deletionPolicy, java.lang.String driver, VolumeSnapshotContentSource source, String volumeSnapshotClassName, io.fabric8.kubernetes.api.model.ObjectReference volumeSnapshotRef) {
        super();
        this.deletionPolicy = deletionPolicy;
        this.driver = driver;
        this.source = source;
        this.volumeSnapshotClassName = volumeSnapshotClassName;
        this.volumeSnapshotRef = volumeSnapshotRef;
    }

    @JsonProperty("deletionPolicy")
    public java.lang.String getDeletionPolicy() {
        return deletionPolicy;
    }

    @JsonProperty("deletionPolicy")
    public void setDeletionPolicy(java.lang.String deletionPolicy) {
        this.deletionPolicy = deletionPolicy;
    }

    @JsonProperty("driver")
    public java.lang.String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(java.lang.String driver) {
        this.driver = driver;
    }

    @JsonProperty("source")
    public VolumeSnapshotContentSource getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(VolumeSnapshotContentSource source) {
        this.source = source;
    }

    @JsonProperty("volumeSnapshotClassName")
    public String getVolumeSnapshotClassName() {
        return volumeSnapshotClassName;
    }

    @JsonProperty("volumeSnapshotClassName")
    public void setVolumeSnapshotClassName(String volumeSnapshotClassName) {
        this.volumeSnapshotClassName = volumeSnapshotClassName;
    }

    @JsonProperty("volumeSnapshotRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getVolumeSnapshotRef() {
        return volumeSnapshotRef;
    }

    @JsonProperty("volumeSnapshotRef")
    public void setVolumeSnapshotRef(io.fabric8.kubernetes.api.model.ObjectReference volumeSnapshotRef) {
        this.volumeSnapshotRef = volumeSnapshotRef;
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
