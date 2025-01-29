
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

/**
 * VolumeSnapshotContentStatus is the status of a VolumeSnapshotContent object Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "creationTime",
    "error",
    "readyToUse",
    "restoreSize",
    "snapshotHandle",
    "volumeGroupSnapshotHandle"
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
public class VolumeSnapshotContentStatus implements Editable<VolumeSnapshotContentStatusBuilder>, KubernetesResource
{

    @JsonProperty("creationTime")
    private Long creationTime;
    @JsonProperty("error")
    private VolumeSnapshotError error;
    @JsonProperty("readyToUse")
    private Boolean readyToUse;
    @JsonProperty("restoreSize")
    private Long restoreSize;
    @JsonProperty("snapshotHandle")
    private String snapshotHandle;
    @JsonProperty("volumeGroupSnapshotHandle")
    private String volumeGroupSnapshotHandle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeSnapshotContentStatus() {
    }

    public VolumeSnapshotContentStatus(Long creationTime, VolumeSnapshotError error, Boolean readyToUse, Long restoreSize, String snapshotHandle, String volumeGroupSnapshotHandle) {
        super();
        this.creationTime = creationTime;
        this.error = error;
        this.readyToUse = readyToUse;
        this.restoreSize = restoreSize;
        this.snapshotHandle = snapshotHandle;
        this.volumeGroupSnapshotHandle = volumeGroupSnapshotHandle;
    }

    /**
     * creationTime is the timestamp when the point-in-time snapshot is taken by the underlying storage system. In dynamic snapshot creation case, this field will be filled in by the CSI snapshotter sidecar with the "creation_time" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "creation_time" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it. If not specified, it indicates the creation time is unknown. The format of this field is a Unix nanoseconds time encoded as an int64. On Unix, the command `date +%s%N` returns the current time in nanoseconds since 1970-01-01 00:00:00 UTC.
     */
    @JsonProperty("creationTime")
    public Long getCreationTime() {
        return creationTime;
    }

    /**
     * creationTime is the timestamp when the point-in-time snapshot is taken by the underlying storage system. In dynamic snapshot creation case, this field will be filled in by the CSI snapshotter sidecar with the "creation_time" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "creation_time" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it. If not specified, it indicates the creation time is unknown. The format of this field is a Unix nanoseconds time encoded as an int64. On Unix, the command `date +%s%N` returns the current time in nanoseconds since 1970-01-01 00:00:00 UTC.
     */
    @JsonProperty("creationTime")
    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * VolumeSnapshotContentStatus is the status of a VolumeSnapshotContent object Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("error")
    public VolumeSnapshotError getError() {
        return error;
    }

    /**
     * VolumeSnapshotContentStatus is the status of a VolumeSnapshotContent object Note that CreationTime, RestoreSize, ReadyToUse, and Error are in both VolumeSnapshotStatus and VolumeSnapshotContentStatus. Fields in VolumeSnapshotStatus are updated based on fields in VolumeSnapshotContentStatus. They are eventual consistency. These fields are duplicate in both objects due to the following reasons:<br><p>   - Fields in VolumeSnapshotContentStatus can be used for filtering when importing a<br><p>     volumesnapshot.<br><p>   - VolumsnapshotStatus is used by end users because they cannot see VolumeSnapshotContent.<br><p>   - CSI snapshotter sidecar is light weight as it only watches VolumeSnapshotContent<br><p>     object, not VolumeSnapshot object.
     */
    @JsonProperty("error")
    public void setError(VolumeSnapshotError error) {
        this.error = error;
    }

    /**
     * readyToUse indicates if a snapshot is ready to be used to restore a volume. In dynamic snapshot creation case, this field will be filled in by the CSI snapshotter sidecar with the "ready_to_use" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "ready_to_use" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it, otherwise, this field will be set to "True". If not specified, it means the readiness of a snapshot is unknown.
     */
    @JsonProperty("readyToUse")
    public Boolean getReadyToUse() {
        return readyToUse;
    }

    /**
     * readyToUse indicates if a snapshot is ready to be used to restore a volume. In dynamic snapshot creation case, this field will be filled in by the CSI snapshotter sidecar with the "ready_to_use" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "ready_to_use" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it, otherwise, this field will be set to "True". If not specified, it means the readiness of a snapshot is unknown.
     */
    @JsonProperty("readyToUse")
    public void setReadyToUse(Boolean readyToUse) {
        this.readyToUse = readyToUse;
    }

    /**
     * restoreSize represents the complete size of the snapshot in bytes. In dynamic snapshot creation case, this field will be filled in by the CSI snapshotter sidecar with the "size_bytes" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "size_bytes" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it. When restoring a volume from this snapshot, the size of the volume MUST NOT be smaller than the restoreSize if it is specified, otherwise the restoration will fail. If not specified, it indicates that the size is unknown.
     */
    @JsonProperty("restoreSize")
    public Long getRestoreSize() {
        return restoreSize;
    }

    /**
     * restoreSize represents the complete size of the snapshot in bytes. In dynamic snapshot creation case, this field will be filled in by the CSI snapshotter sidecar with the "size_bytes" value returned from CSI "CreateSnapshot" gRPC call. For a pre-existing snapshot, this field will be filled with the "size_bytes" value returned from the CSI "ListSnapshots" gRPC call if the driver supports it. When restoring a volume from this snapshot, the size of the volume MUST NOT be smaller than the restoreSize if it is specified, otherwise the restoration will fail. If not specified, it indicates that the size is unknown.
     */
    @JsonProperty("restoreSize")
    public void setRestoreSize(Long restoreSize) {
        this.restoreSize = restoreSize;
    }

    /**
     * snapshotHandle is the CSI "snapshot_id" of a snapshot on the underlying storage system. If not specified, it indicates that dynamic snapshot creation has either failed or it is still in progress.
     */
    @JsonProperty("snapshotHandle")
    public String getSnapshotHandle() {
        return snapshotHandle;
    }

    /**
     * snapshotHandle is the CSI "snapshot_id" of a snapshot on the underlying storage system. If not specified, it indicates that dynamic snapshot creation has either failed or it is still in progress.
     */
    @JsonProperty("snapshotHandle")
    public void setSnapshotHandle(String snapshotHandle) {
        this.snapshotHandle = snapshotHandle;
    }

    /**
     * VolumeGroupSnapshotHandle is the CSI "group_snapshot_id" of a group snapshot on the underlying storage system.
     */
    @JsonProperty("volumeGroupSnapshotHandle")
    public String getVolumeGroupSnapshotHandle() {
        return volumeGroupSnapshotHandle;
    }

    /**
     * VolumeGroupSnapshotHandle is the CSI "group_snapshot_id" of a group snapshot on the underlying storage system.
     */
    @JsonProperty("volumeGroupSnapshotHandle")
    public void setVolumeGroupSnapshotHandle(String volumeGroupSnapshotHandle) {
        this.volumeGroupSnapshotHandle = volumeGroupSnapshotHandle;
    }

    @JsonIgnore
    public VolumeSnapshotContentStatusBuilder edit() {
        return new VolumeSnapshotContentStatusBuilder(this);
    }

    @JsonIgnore
    public VolumeSnapshotContentStatusBuilder toBuilder() {
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
