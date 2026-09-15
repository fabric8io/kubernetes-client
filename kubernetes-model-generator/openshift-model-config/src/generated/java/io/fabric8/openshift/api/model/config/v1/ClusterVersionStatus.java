
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClusterVersionStatus)) {
            return false;
        }
        ClusterVersionStatus other = (ClusterVersionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availableUpdates = this.getAvailableUpdates();
        Object other$availableUpdates = other.getAvailableUpdates();
        if (this$availableUpdates == null ? other$availableUpdates != null : !this$availableUpdates.equals(other$availableUpdates)) {
            return false;
        }
        Object this$capabilities = this.getCapabilities();
        Object other$capabilities = other.getCapabilities();
        if (this$capabilities == null ? other$capabilities != null : !this$capabilities.equals(other$capabilities)) {
            return false;
        }
        Object this$conditionalUpdates = this.getConditionalUpdates();
        Object other$conditionalUpdates = other.getConditionalUpdates();
        if (this$conditionalUpdates == null ? other$conditionalUpdates != null : !this$conditionalUpdates.equals(other$conditionalUpdates)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$desired = this.getDesired();
        Object other$desired = other.getDesired();
        if (this$desired == null ? other$desired != null : !this$desired.equals(other$desired)) {
            return false;
        }
        Object this$history = this.getHistory();
        Object other$history = other.getHistory();
        if (this$history == null ? other$history != null : !this$history.equals(other$history)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$versionHash = this.getVersionHash();
        Object other$versionHash = other.getVersionHash();
        if (this$versionHash == null ? other$versionHash != null : !this$versionHash.equals(other$versionHash)) {
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
        return other instanceof ClusterVersionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availableUpdates = this.getAvailableUpdates();
        result = result * prime + ($availableUpdates == null ? 43 : $availableUpdates.hashCode());
        Object $capabilities = this.getCapabilities();
        result = result * prime + ($capabilities == null ? 43 : $capabilities.hashCode());
        Object $conditionalUpdates = this.getConditionalUpdates();
        result = result * prime + ($conditionalUpdates == null ? 43 : $conditionalUpdates.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $desired = this.getDesired();
        result = result * prime + ($desired == null ? 43 : $desired.hashCode());
        Object $history = this.getHistory();
        result = result * prime + ($history == null ? 43 : $history.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $versionHash = this.getVersionHash();
        result = result * prime + ($versionHash == null ? 43 : $versionHash.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterVersionStatus(" + "availableUpdates=" + this.getAvailableUpdates() + ", capabilities=" + this.getCapabilities() + ", conditionalUpdates=" + this.getConditionalUpdates() + ", conditions=" + this.getConditions() + ", desired=" + this.getDesired() + ", history=" + this.getHistory() + ", observedGeneration=" + this.getObservedGeneration() + ", versionHash=" + this.getVersionHash() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
