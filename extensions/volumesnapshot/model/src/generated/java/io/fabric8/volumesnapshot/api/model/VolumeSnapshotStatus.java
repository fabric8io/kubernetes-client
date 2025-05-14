
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * VolumeSnapshotStatus is the status of the VolumeSnapshot Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "boundVolumeSnapshotContentName",
    "creationTime",
    "error",
    "readyToUse",
    "restoreSize",
    "volumeGroupSnapshotName"
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
public class VolumeSnapshotStatus implements Editable<VolumeSnapshotStatusBuilder>, KubernetesResource
{

    @JsonProperty("boundVolumeSnapshotContentName")
    private String boundVolumeSnapshotContentName;
    @JsonProperty("creationTime")
    private String creationTime;
    @JsonProperty("error")
    private VolumeSnapshotError error;
    @JsonProperty("readyToUse")
    private Boolean readyToUse;
    @JsonProperty("restoreSize")
    private Quantity restoreSize;
    @JsonProperty("volumeGroupSnapshotName")
    private String volumeGroupSnapshotName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeSnapshotStatus() {
    }

    public VolumeSnapshotStatus(String boundVolumeSnapshotContentName, String creationTime, VolumeSnapshotError error, Boolean readyToUse, Quantity restoreSize, String volumeGroupSnapshotName) {
        super();
        this.boundVolumeSnapshotContentName = boundVolumeSnapshotContentName;
        this.creationTime = creationTime;
        this.error = error;
        this.readyToUse = readyToUse;
        this.restoreSize = restoreSize;
        this.volumeGroupSnapshotName = volumeGroupSnapshotName;
    }

    /**
     * boundVolumeSnapshotContentName is the name of the VolumeSnapshotContent object to which this VolumeSnapshot object intends to bind to. If not specified, it indicates that the VolumeSnapshot object has not been successfully bound to a VolumeSnapshotContent object yet. NOTE: To avoid possible security issues, consumers must verify binding between VolumeSnapshot and VolumeSnapshotContent objects is successful (by validating that both VolumeSnapshot and VolumeSnapshotContent point at each other) before using this object.
     */
    @JsonProperty("boundVolumeSnapshotContentName")
    public String getBoundVolumeSnapshotContentName() {
        return boundVolumeSnapshotContentName;
    }

    /**
     * boundVolumeSnapshotContentName is the name of the VolumeSnapshotContent object to which this VolumeSnapshot object intends to bind to. If not specified, it indicates that the VolumeSnapshot object has not been successfully bound to a VolumeSnapshotContent object yet. NOTE: To avoid possible security issues, consumers must verify binding between VolumeSnapshot and VolumeSnapshotContent objects is successful (by validating that both VolumeSnapshot and VolumeSnapshotContent point at each other) before using this object.
     */
    @JsonProperty("boundVolumeSnapshotContentName")
    public void setBoundVolumeSnapshotContentName(String boundVolumeSnapshotContentName) {
        this.boundVolumeSnapshotContentName = boundVolumeSnapshotContentName;
    }

    /**
     * VolumeSnapshotStatus is the status of the VolumeSnapshot Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("creationTime")
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * VolumeSnapshotStatus is the status of the VolumeSnapshot Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("creationTime")
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * VolumeSnapshotStatus is the status of the VolumeSnapshot Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("error")
    public VolumeSnapshotError getError() {
        return error;
    }

    /**
     * VolumeSnapshotStatus is the status of the VolumeSnapshot Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("error")
    public void setError(VolumeSnapshotError error) {
        this.error = error;
    }

    /**
     * readyToUse indicates if the snapshot is ready to be used to restore a volume. In dynamic snapshot creation case, this field will be filled in by the snapshot controller with the "ready_to_use" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "ready_to_use" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it, otherwise, this field will be set to "True". If not specified, it means the readiness of a snapshot is unknown.
     */
    @JsonProperty("readyToUse")
    public Boolean getReadyToUse() {
        return readyToUse;
    }

    /**
     * readyToUse indicates if the snapshot is ready to be used to restore a volume. In dynamic snapshot creation case, this field will be filled in by the snapshot controller with the "ready_to_use" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "ready_to_use" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it, otherwise, this field will be set to "True". If not specified, it means the readiness of a snapshot is unknown.
     */
    @JsonProperty("readyToUse")
    public void setReadyToUse(Boolean readyToUse) {
        this.readyToUse = readyToUse;
    }

    /**
     * VolumeSnapshotStatus is the status of the VolumeSnapshot Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("restoreSize")
    public Quantity getRestoreSize() {
        return restoreSize;
    }

    /**
     * VolumeSnapshotStatus is the status of the VolumeSnapshot Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("restoreSize")
    public void setRestoreSize(Quantity restoreSize) {
        this.restoreSize = restoreSize;
    }

    /**
     * VolumeGroupSnapshotName is the name of the VolumeGroupSnapshot of which this VolumeSnapshot is a part of.
     */
    @JsonProperty("volumeGroupSnapshotName")
    public String getVolumeGroupSnapshotName() {
        return volumeGroupSnapshotName;
    }

    /**
     * VolumeGroupSnapshotName is the name of the VolumeGroupSnapshot of which this VolumeSnapshot is a part of.
     */
    @JsonProperty("volumeGroupSnapshotName")
    public void setVolumeGroupSnapshotName(String volumeGroupSnapshotName) {
        this.volumeGroupSnapshotName = volumeGroupSnapshotName;
    }

    @JsonIgnore
    public VolumeSnapshotStatusBuilder edit() {
        return new VolumeSnapshotStatusBuilder(this);
    }

    @JsonIgnore
    public VolumeSnapshotStatusBuilder toBuilder() {
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
