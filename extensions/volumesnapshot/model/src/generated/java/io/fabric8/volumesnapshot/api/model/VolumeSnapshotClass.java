
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VolumeSnapshotClass specifies parameters that a underlying storage system uses when creating a volume snapshot. A specific VolumeSnapshotClass is used by specifying its name in a VolumeSnapshot object. VolumeSnapshotClasses are non-namespaced
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "deletionPolicy",
    "driver",
    "parameters"
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
@Version("v1")
@Group("snapshot.storage.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeSnapshotClass implements Editable<VolumeSnapshotClassBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "snapshot.storage.k8s.io/v1";
    @JsonProperty("deletionPolicy")
    private String deletionPolicy;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("kind")
    private String kind = "VolumeSnapshotClass";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> parameters = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeSnapshotClass() {
    }

    public VolumeSnapshotClass(String apiVersion, String deletionPolicy, String driver, String kind, ObjectMeta metadata, Map<String, String> parameters) {
        super();
        this.apiVersion = apiVersion;
        this.deletionPolicy = deletionPolicy;
        this.driver = driver;
        this.kind = kind;
        this.metadata = metadata;
        this.parameters = parameters;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * deletionPolicy determines whether a VolumeSnapshotContent created through the VolumeSnapshotClass should be deleted when its bound VolumeSnapshot is deleted. Supported values are "Retain" and "Delete". "Retain" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are kept. "Delete" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are deleted. Required.
     */
    @JsonProperty("deletionPolicy")
    public String getDeletionPolicy() {
        return deletionPolicy;
    }

    /**
     * deletionPolicy determines whether a VolumeSnapshotContent created through the VolumeSnapshotClass should be deleted when its bound VolumeSnapshot is deleted. Supported values are "Retain" and "Delete". "Retain" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are kept. "Delete" means that the VolumeSnapshotContent and its physical snapshot on underlying storage system are deleted. Required.
     */
    @JsonProperty("deletionPolicy")
    public void setDeletionPolicy(String deletionPolicy) {
        this.deletionPolicy = deletionPolicy;
    }

    /**
     * driver is the name of the storage driver that handles this VolumeSnapshotClass. Required.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * driver is the name of the storage driver that handles this VolumeSnapshotClass. Required.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * VolumeSnapshotClass specifies parameters that a underlying storage system uses when creating a volume snapshot. A specific VolumeSnapshotClass is used by specifying its name in a VolumeSnapshot object. VolumeSnapshotClasses are non-namespaced
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * VolumeSnapshotClass specifies parameters that a underlying storage system uses when creating a volume snapshot. A specific VolumeSnapshotClass is used by specifying its name in a VolumeSnapshot object. VolumeSnapshotClasses are non-namespaced
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * parameters is a key-value map with storage driver specific parameters for creating snapshots. These values are opaque to Kubernetes.
     */
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * parameters is a key-value map with storage driver specific parameters for creating snapshots. These values are opaque to Kubernetes.
     */
    @JsonProperty("parameters")
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @JsonIgnore
    public VolumeSnapshotClassBuilder edit() {
        return new VolumeSnapshotClassBuilder(this);
    }

    @JsonIgnore
    public VolumeSnapshotClassBuilder toBuilder() {
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
        if (!(o instanceof VolumeSnapshotClass)) {
            return false;
        }
        VolumeSnapshotClass other = (VolumeSnapshotClass) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$deletionPolicy = this.getDeletionPolicy();
        Object other$deletionPolicy = other.getDeletionPolicy();
        if (this$deletionPolicy == null ? other$deletionPolicy != null : !this$deletionPolicy.equals(other$deletionPolicy)) {
            return false;
        }
        Object this$driver = this.getDriver();
        Object other$driver = other.getDriver();
        if (this$driver == null ? other$driver != null : !this$driver.equals(other$driver)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$parameters = this.getParameters();
        Object other$parameters = other.getParameters();
        if (this$parameters == null ? other$parameters != null : !this$parameters.equals(other$parameters)) {
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
        return other instanceof VolumeSnapshotClass;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $deletionPolicy = this.getDeletionPolicy();
        result = result * prime + ($deletionPolicy == null ? 43 : $deletionPolicy.hashCode());
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $parameters = this.getParameters();
        result = result * prime + ($parameters == null ? 43 : $parameters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeSnapshotClass(" + "apiVersion=" + this.getApiVersion() + ", deletionPolicy=" + this.getDeletionPolicy() + ", driver=" + this.getDriver() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", parameters=" + this.getParameters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
