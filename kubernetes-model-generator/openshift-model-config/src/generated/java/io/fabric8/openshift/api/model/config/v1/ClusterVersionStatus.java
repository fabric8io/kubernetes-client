
package io.fabric8.openshift.api.model.config.v1;

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
 * ClusterVersionStatus reports the status of the cluster versioning, including any upgrades that are in progress. The current field will be set to whichever version the cluster is reconciling to, and the conditions array will report whether the update succeeded, is in progress, or is failing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableUpdates",
    "capabilities",
    "conditionalUpdates",
    "conditions",
    "desired",
    "history",
    "observedGeneration",
    "versionHash"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterVersionStatus implements Editable<ClusterVersionStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Release> availableUpdates = new ArrayList<>();
    @JsonProperty("capabilities")
    private ClusterVersionCapabilitiesStatus capabilities;
    @JsonProperty("conditionalUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConditionalUpdate> conditionalUpdates = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterOperatorStatusCondition> conditions = new ArrayList<>();
    @JsonProperty("desired")
    private Release desired;
    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UpdateHistory> history = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("versionHash")
    private String versionHash;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterVersionStatus() {
    }

    public ClusterVersionStatus(List<Release> availableUpdates, ClusterVersionCapabilitiesStatus capabilities, List<ConditionalUpdate> conditionalUpdates, List<ClusterOperatorStatusCondition> conditions, Release desired, List<UpdateHistory> history, Long observedGeneration, String versionHash) {
        super();
        this.availableUpdates = availableUpdates;
        this.capabilities = capabilities;
        this.conditionalUpdates = conditionalUpdates;
        this.conditions = conditions;
        this.desired = desired;
        this.history = history;
        this.observedGeneration = observedGeneration;
        this.versionHash = versionHash;
    }

    /**
     * availableUpdates contains updates recommended for this cluster. Updates which appear in conditionalUpdates but not in availableUpdates may expose this cluster to known issues. This list may be empty if no updates are recommended, if the update service is unavailable, or if an invalid channel has been specified.
     */
    @JsonProperty("availableUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Release> getAvailableUpdates() {
        return availableUpdates;
    }

    /**
     * availableUpdates contains updates recommended for this cluster. Updates which appear in conditionalUpdates but not in availableUpdates may expose this cluster to known issues. This list may be empty if no updates are recommended, if the update service is unavailable, or if an invalid channel has been specified.
     */
    @JsonProperty("availableUpdates")
    public void setAvailableUpdates(List<Release> availableUpdates) {
        this.availableUpdates = availableUpdates;
    }

    /**
     * ClusterVersionStatus reports the status of the cluster versioning, including any upgrades that are in progress. The current field will be set to whichever version the cluster is reconciling to, and the conditions array will report whether the update succeeded, is in progress, or is failing.
     */
    @JsonProperty("capabilities")
    public ClusterVersionCapabilitiesStatus getCapabilities() {
        return capabilities;
    }

    /**
     * ClusterVersionStatus reports the status of the cluster versioning, including any upgrades that are in progress. The current field will be set to whichever version the cluster is reconciling to, and the conditions array will report whether the update succeeded, is in progress, or is failing.
     */
    @JsonProperty("capabilities")
    public void setCapabilities(ClusterVersionCapabilitiesStatus capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * conditionalUpdates contains the list of updates that may be recommended for this cluster if it meets specific required conditions. Consumers interested in the set of updates that are actually recommended for this cluster should use availableUpdates. This list may be empty if no updates are recommended, if the update service is unavailable, or if an empty or invalid channel has been specified.
     */
    @JsonProperty("conditionalUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConditionalUpdate> getConditionalUpdates() {
        return conditionalUpdates;
    }

    /**
     * conditionalUpdates contains the list of updates that may be recommended for this cluster if it meets specific required conditions. Consumers interested in the set of updates that are actually recommended for this cluster should use availableUpdates. This list may be empty if no updates are recommended, if the update service is unavailable, or if an empty or invalid channel has been specified.
     */
    @JsonProperty("conditionalUpdates")
    public void setConditionalUpdates(List<ConditionalUpdate> conditionalUpdates) {
        this.conditionalUpdates = conditionalUpdates;
    }

    /**
     * conditions provides information about the cluster version. The condition "Available" is set to true if the desiredUpdate has been reached. The condition "Progressing" is set to true if an update is being applied. The condition "Degraded" is set to true if an update is currently blocked by a temporary or permanent error. Conditions are only valid for the current desiredUpdate when metadata.generation is equal to status.generation.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterOperatorStatusCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions provides information about the cluster version. The condition "Available" is set to true if the desiredUpdate has been reached. The condition "Progressing" is set to true if an update is being applied. The condition "Degraded" is set to true if an update is currently blocked by a temporary or permanent error. Conditions are only valid for the current desiredUpdate when metadata.generation is equal to status.generation.
     */
    @JsonProperty("conditions")
    public void setConditions(List<ClusterOperatorStatusCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ClusterVersionStatus reports the status of the cluster versioning, including any upgrades that are in progress. The current field will be set to whichever version the cluster is reconciling to, and the conditions array will report whether the update succeeded, is in progress, or is failing.
     */
    @JsonProperty("desired")
    public Release getDesired() {
        return desired;
    }

    /**
     * ClusterVersionStatus reports the status of the cluster versioning, including any upgrades that are in progress. The current field will be set to whichever version the cluster is reconciling to, and the conditions array will report whether the update succeeded, is in progress, or is failing.
     */
    @JsonProperty("desired")
    public void setDesired(Release desired) {
        this.desired = desired;
    }

    /**
     * history contains a list of the most recent versions applied to the cluster. This value may be empty during cluster startup, and then will be updated when a new update is being applied. The newest update is first in the list and it is ordered by recency. Updates in the history have state Completed if the rollout completed - if an update was failing or halfway applied the state will be Partial. Only a limited amount of update history is preserved.
     */
    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UpdateHistory> getHistory() {
        return history;
    }

    /**
     * history contains a list of the most recent versions applied to the cluster. This value may be empty during cluster startup, and then will be updated when a new update is being applied. The newest update is first in the list and it is ordered by recency. Updates in the history have state Completed if the rollout completed - if an update was failing or halfway applied the state will be Partial. Only a limited amount of update history is preserved.
     */
    @JsonProperty("history")
    public void setHistory(List<UpdateHistory> history) {
        this.history = history;
    }

    /**
     * observedGeneration reports which version of the spec is being synced. If this value is not equal to metadata.generation, then the desired and conditions fields may represent a previous version.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration reports which version of the spec is being synced. If this value is not equal to metadata.generation, then the desired and conditions fields may represent a previous version.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * versionHash is a fingerprint of the content that the cluster will be updated with. It is used by the operator to avoid unnecessary work and is for internal use only.
     */
    @JsonProperty("versionHash")
    public String getVersionHash() {
        return versionHash;
    }

    /**
     * versionHash is a fingerprint of the content that the cluster will be updated with. It is used by the operator to avoid unnecessary work and is for internal use only.
     */
    @JsonProperty("versionHash")
    public void setVersionHash(String versionHash) {
        this.versionHash = versionHash;
    }

    @JsonIgnore
    public ClusterVersionStatusBuilder edit() {
        return new ClusterVersionStatusBuilder(this);
    }

    @JsonIgnore
    public ClusterVersionStatusBuilder toBuilder() {
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
