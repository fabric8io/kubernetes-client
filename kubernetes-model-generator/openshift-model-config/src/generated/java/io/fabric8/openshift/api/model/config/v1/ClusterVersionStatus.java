
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterVersionStatus implements Editable<ClusterVersionStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("availableUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Release> getAvailableUpdates() {
        return availableUpdates;
    }

    @JsonProperty("availableUpdates")
    public void setAvailableUpdates(List<Release> availableUpdates) {
        this.availableUpdates = availableUpdates;
    }

    @JsonProperty("capabilities")
    public ClusterVersionCapabilitiesStatus getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(ClusterVersionCapabilitiesStatus capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("conditionalUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConditionalUpdate> getConditionalUpdates() {
        return conditionalUpdates;
    }

    @JsonProperty("conditionalUpdates")
    public void setConditionalUpdates(List<ConditionalUpdate> conditionalUpdates) {
        this.conditionalUpdates = conditionalUpdates;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterOperatorStatusCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ClusterOperatorStatusCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("desired")
    public Release getDesired() {
        return desired;
    }

    @JsonProperty("desired")
    public void setDesired(Release desired) {
        this.desired = desired;
    }

    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UpdateHistory> getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(List<UpdateHistory> history) {
        this.history = history;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("versionHash")
    public String getVersionHash() {
        return versionHash;
    }

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
