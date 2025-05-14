
package io.fabric8.volumesnapshot.api.model;

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
 * VolumeSnapshotContentSpec is the specification of a VolumeSnapshotContent
 */
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

    /**
     * deletionPolicy determines whether this VolumeSnapshotContent and its physical snapshot on the underlying storage system should be deleted when its bound VolumeSnapshot is deleted. Supported values are "Retain" and "Delete". "Retain" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are kept. "Delete" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are deleted. For dynamically provisioned snapshots, this field will automatically be filled in by the CSI snapshotter sidecar with the "DeletionPolicy" field defined in the corresponding VolumeSnapshotClass. For pre-existing snapshots, users MUST specify this field when creating the<br><p>  VolumeSnapshotContent object.<br><p> Required.
     */
    @JsonProperty("deletionPolicy")
    public String getDeletionPolicy() {
        return deletionPolicy;
    }

    /**
     * deletionPolicy determines whether this VolumeSnapshotContent and its physical snapshot on the underlying storage system should be deleted when its bound VolumeSnapshot is deleted. Supported values are "Retain" and "Delete". "Retain" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are kept. "Delete" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are deleted. For dynamically provisioned snapshots, this field will automatically be filled in by the CSI snapshotter sidecar with the "DeletionPolicy" field defined in the corresponding VolumeSnapshotClass. For pre-existing snapshots, users MUST specify this field when creating the<br><p>  VolumeSnapshotContent object.<br><p> Required.
     */
    @JsonProperty("deletionPolicy")
    public void setDeletionPolicy(String deletionPolicy) {
        this.deletionPolicy = deletionPolicy;
    }

    /**
     * driver is the name of the CSI driver used to create the physical snapshot on the underlying storage system. This MUST be the same as the name returned by the CSI GetPluginName() call for that driver. Required.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * driver is the name of the CSI driver used to create the physical snapshot on the underlying storage system. This MUST be the same as the name returned by the CSI GetPluginName() call for that driver. Required.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * VolumeSnapshotContentSpec is the specification of a VolumeSnapshotContent
     */
    @JsonProperty("source")
    public VolumeSnapshotContentSource getSource() {
        return source;
    }

    /**
     * VolumeSnapshotContentSpec is the specification of a VolumeSnapshotContent
     */
    @JsonProperty("source")
    public void setSource(VolumeSnapshotContentSource source) {
        this.source = source;
    }

    /**
     * SourceVolumeMode is the mode of the volume whose snapshot is taken. Can be either "Filesystem" or "Block". If not specified, it indicates the source volume's mode is unknown. This field is immutable. This field is an alpha field.
     */
    @JsonProperty("sourceVolumeMode")
    public String getSourceVolumeMode() {
        return sourceVolumeMode;
    }

    /**
     * SourceVolumeMode is the mode of the volume whose snapshot is taken. Can be either "Filesystem" or "Block". If not specified, it indicates the source volume's mode is unknown. This field is immutable. This field is an alpha field.
     */
    @JsonProperty("sourceVolumeMode")
    public void setSourceVolumeMode(String sourceVolumeMode) {
        this.sourceVolumeMode = sourceVolumeMode;
    }

    /**
     * name of the VolumeSnapshotClass from which this snapshot was (or will be) created. Note that after provisioning, the VolumeSnapshotClass may be deleted or recreated with different set of values, and as such, should not be referenced post-snapshot creation.
     */
    @JsonProperty("volumeSnapshotClassName")
    public String getVolumeSnapshotClassName() {
        return volumeSnapshotClassName;
    }

    /**
     * name of the VolumeSnapshotClass from which this snapshot was (or will be) created. Note that after provisioning, the VolumeSnapshotClass may be deleted or recreated with different set of values, and as such, should not be referenced post-snapshot creation.
     */
    @JsonProperty("volumeSnapshotClassName")
    public void setVolumeSnapshotClassName(String volumeSnapshotClassName) {
        this.volumeSnapshotClassName = volumeSnapshotClassName;
    }

    /**
     * VolumeSnapshotContentSpec is the specification of a VolumeSnapshotContent
     */
    @JsonProperty("volumeSnapshotRef")
    public ObjectReference getVolumeSnapshotRef() {
        return volumeSnapshotRef;
    }

    /**
     * VolumeSnapshotContentSpec is the specification of a VolumeSnapshotContent
     */
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
