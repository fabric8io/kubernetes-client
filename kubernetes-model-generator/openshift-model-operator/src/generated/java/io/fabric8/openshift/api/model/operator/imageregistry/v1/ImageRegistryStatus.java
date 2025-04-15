
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
import io.fabric8.openshift.api.model.operator.v1.GenerationStatus;
import io.fabric8.openshift.api.model.operator.v1.OperatorCondition;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ImageRegistryStatus reports image registry operational status.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "generations",
    "latestAvailableRevision",
    "observedGeneration",
    "readyReplicas",
    "storage",
    "storageManaged",
    "version"
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
public class ImageRegistryStatus implements Editable<ImageRegistryStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OperatorCondition> conditions = new ArrayList<>();
    @JsonProperty("generations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenerationStatus> generations = new ArrayList<>();
    @JsonProperty("latestAvailableRevision")
    private Integer latestAvailableRevision;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("storage")
    private ImageRegistryConfigStorage storage;
    @JsonProperty("storageManaged")
    private Boolean storageManaged;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryStatus() {
    }

    public ImageRegistryStatus(List<OperatorCondition> conditions, List<GenerationStatus> generations, Integer latestAvailableRevision, Long observedGeneration, Integer readyReplicas, ImageRegistryConfigStorage storage, Boolean storageManaged, String version) {
        super();
        this.conditions = conditions;
        this.generations = generations;
        this.latestAvailableRevision = latestAvailableRevision;
        this.observedGeneration = observedGeneration;
        this.readyReplicas = readyReplicas;
        this.storage = storage;
        this.storageManaged = storageManaged;
        this.version = version;
    }

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OperatorCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    public void setConditions(List<OperatorCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * generations are used to determine when an item needs to be reconciled or has changed in a way that needs a reaction.
     */
    @JsonProperty("generations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GenerationStatus> getGenerations() {
        return generations;
    }

    /**
     * generations are used to determine when an item needs to be reconciled or has changed in a way that needs a reaction.
     */
    @JsonProperty("generations")
    public void setGenerations(List<GenerationStatus> generations) {
        this.generations = generations;
    }

    /**
     * latestAvailableRevision is the deploymentID of the most recent deployment
     */
    @JsonProperty("latestAvailableRevision")
    public Integer getLatestAvailableRevision() {
        return latestAvailableRevision;
    }

    /**
     * latestAvailableRevision is the deploymentID of the most recent deployment
     */
    @JsonProperty("latestAvailableRevision")
    public void setLatestAvailableRevision(Integer latestAvailableRevision) {
        this.latestAvailableRevision = latestAvailableRevision;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * readyReplicas indicates how many replicas are ready and at the desired state
     */
    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    /**
     * readyReplicas indicates how many replicas are ready and at the desired state
     */
    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    /**
     * ImageRegistryStatus reports image registry operational status.
     */
    @JsonProperty("storage")
    public ImageRegistryConfigStorage getStorage() {
        return storage;
    }

    /**
     * ImageRegistryStatus reports image registry operational status.
     */
    @JsonProperty("storage")
    public void setStorage(ImageRegistryConfigStorage storage) {
        this.storage = storage;
    }

    /**
     * storageManaged is deprecated, please refer to Storage.managementState
     */
    @JsonProperty("storageManaged")
    public Boolean getStorageManaged() {
        return storageManaged;
    }

    /**
     * storageManaged is deprecated, please refer to Storage.managementState
     */
    @JsonProperty("storageManaged")
    public void setStorageManaged(Boolean storageManaged) {
        this.storageManaged = storageManaged;
    }

    /**
     * version is the level this availability applies to
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is the level this availability applies to
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public ImageRegistryStatusBuilder edit() {
        return new ImageRegistryStatusBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryStatusBuilder toBuilder() {
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
