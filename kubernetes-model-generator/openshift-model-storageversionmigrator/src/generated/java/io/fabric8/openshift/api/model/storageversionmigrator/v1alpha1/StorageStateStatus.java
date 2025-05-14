
package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * Status of the storage state.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentStorageVersionHash",
    "lastHeartbeatTime",
    "persistedStorageVersionHashes"
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
public class StorageStateStatus implements Editable<StorageStateStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentStorageVersionHash")
    private String currentStorageVersionHash;
    @JsonProperty("lastHeartbeatTime")
    private String lastHeartbeatTime;
    @JsonProperty("persistedStorageVersionHashes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> persistedStorageVersionHashes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StorageStateStatus() {
    }

    public StorageStateStatus(String currentStorageVersionHash, String lastHeartbeatTime, List<String> persistedStorageVersionHashes) {
        super();
        this.currentStorageVersionHash = currentStorageVersionHash;
        this.lastHeartbeatTime = lastHeartbeatTime;
        this.persistedStorageVersionHashes = persistedStorageVersionHashes;
    }

    /**
     * The hash value of the current storage version, as shown in the discovery document served by the API server. Storage Version is the version to which objects are converted to before persisted.
     */
    @JsonProperty("currentStorageVersionHash")
    public String getCurrentStorageVersionHash() {
        return currentStorageVersionHash;
    }

    /**
     * The hash value of the current storage version, as shown in the discovery document served by the API server. Storage Version is the version to which objects are converted to before persisted.
     */
    @JsonProperty("currentStorageVersionHash")
    public void setCurrentStorageVersionHash(String currentStorageVersionHash) {
        this.currentStorageVersionHash = currentStorageVersionHash;
    }

    /**
     * LastHeartbeatTime is the last time the storage migration triggering controller checks the storage version hash of this resource in the discovery document and updates this field.
     */
    @JsonProperty("lastHeartbeatTime")
    public String getLastHeartbeatTime() {
        return lastHeartbeatTime;
    }

    /**
     * LastHeartbeatTime is the last time the storage migration triggering controller checks the storage version hash of this resource in the discovery document and updates this field.
     */
    @JsonProperty("lastHeartbeatTime")
    public void setLastHeartbeatTime(String lastHeartbeatTime) {
        this.lastHeartbeatTime = lastHeartbeatTime;
    }

    /**
     * The hash values of storage versions that persisted instances of spec.resource might still be encoded in. "Unknown" is a valid value in the list, and is the default value. It is not safe to upgrade or downgrade to an apiserver binary that does not support all versions listed in this field, or if "Unknown" is listed. Once the storage version migration for this resource has completed, the value of this field is refined to only contain the currentStorageVersionHash. Once the apiserver has changed the storage version, the new storage version is appended to the list.
     */
    @JsonProperty("persistedStorageVersionHashes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPersistedStorageVersionHashes() {
        return persistedStorageVersionHashes;
    }

    /**
     * The hash values of storage versions that persisted instances of spec.resource might still be encoded in. "Unknown" is a valid value in the list, and is the default value. It is not safe to upgrade or downgrade to an apiserver binary that does not support all versions listed in this field, or if "Unknown" is listed. Once the storage version migration for this resource has completed, the value of this field is refined to only contain the currentStorageVersionHash. Once the apiserver has changed the storage version, the new storage version is appended to the list.
     */
    @JsonProperty("persistedStorageVersionHashes")
    public void setPersistedStorageVersionHashes(List<String> persistedStorageVersionHashes) {
        this.persistedStorageVersionHashes = persistedStorageVersionHashes;
    }

    @JsonIgnore
    public StorageStateStatusBuilder edit() {
        return new StorageStateStatusBuilder(this);
    }

    @JsonIgnore
    public StorageStateStatusBuilder toBuilder() {
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
