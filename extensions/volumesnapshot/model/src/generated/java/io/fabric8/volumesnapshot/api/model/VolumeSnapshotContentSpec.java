
package io.fabric8.volumesnapshot.api.model;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deletionPolicy",
    "driver",
    "source",
    "sourceVolumeMode",
    "volumeSnapshotClassName",
    "volumeSnapshotRef"
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
public class VolumeSnapshotContentSpec implements Editable<VolumeSnapshotContentSpecBuilder>, KubernetesResource
{

    @JsonProperty("deletionPolicy")
    private String deletionPolicy;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("source")
    private VolumeSnapshotContentSource source;
    @JsonProperty("sourceVolumeMode")
    private String sourceVolumeMode;
    @JsonProperty("volumeSnapshotClassName")
    private String volumeSnapshotClassName;
    @JsonProperty("volumeSnapshotRef")
    private ObjectReference volumeSnapshotRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeSnapshotContentSpec() {
    }

    public VolumeSnapshotContentSpec(String deletionPolicy, String driver, VolumeSnapshotContentSource source, String sourceVolumeMode, String volumeSnapshotClassName, ObjectReference volumeSnapshotRef) {
        super();
        this.deletionPolicy = deletionPolicy;
        this.driver = driver;
        this.source = source;
        this.sourceVolumeMode = sourceVolumeMode;
        this.volumeSnapshotClassName = volumeSnapshotClassName;
        this.volumeSnapshotRef = volumeSnapshotRef;
    }

    @JsonProperty("deletionPolicy")
    public String getDeletionPolicy() {
        return deletionPolicy;
    }

    @JsonProperty("deletionPolicy")
    public void setDeletionPolicy(String deletionPolicy) {
        this.deletionPolicy = deletionPolicy;
    }

    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(String driver) {
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

    @JsonProperty("sourceVolumeMode")
    public String getSourceVolumeMode() {
        return sourceVolumeMode;
    }

    @JsonProperty("sourceVolumeMode")
    public void setSourceVolumeMode(String sourceVolumeMode) {
        this.sourceVolumeMode = sourceVolumeMode;
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
    public ObjectReference getVolumeSnapshotRef() {
        return volumeSnapshotRef;
    }

    @JsonProperty("volumeSnapshotRef")
    public void setVolumeSnapshotRef(ObjectReference volumeSnapshotRef) {
        this.volumeSnapshotRef = volumeSnapshotRef;
    }

    @JsonIgnore
    public VolumeSnapshotContentSpecBuilder edit() {
        return new VolumeSnapshotContentSpecBuilder(this);
    }

    @JsonIgnore
    public VolumeSnapshotContentSpecBuilder toBuilder() {
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
