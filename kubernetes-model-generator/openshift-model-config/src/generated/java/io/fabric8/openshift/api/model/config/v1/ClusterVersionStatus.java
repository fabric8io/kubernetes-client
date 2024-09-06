
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterVersionStatus implements Editable<ClusterVersionStatusBuilder> , KubernetesResource
{

    @JsonProperty("availableUpdates")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object availableUpdates;
    @JsonProperty("capabilities")
    private ClusterVersionStatusCapabilities capabilities;
    @JsonProperty("conditionalUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterVersionStatusConditionalUpdates> conditionalUpdates = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterVersionStatusConditions> conditions = new ArrayList<>();
    @JsonProperty("desired")
    private ClusterVersionStatusDesired desired;
    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterVersionStatusHistory> history = new ArrayList<>();
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

    public ClusterVersionStatus(Object availableUpdates, ClusterVersionStatusCapabilities capabilities, List<ClusterVersionStatusConditionalUpdates> conditionalUpdates, List<ClusterVersionStatusConditions> conditions, ClusterVersionStatusDesired desired, List<ClusterVersionStatusHistory> history, Long observedGeneration, String versionHash) {
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
    public Object getAvailableUpdates() {
        return availableUpdates;
    }

    @JsonProperty("availableUpdates")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setAvailableUpdates(Object availableUpdates) {
        this.availableUpdates = availableUpdates;
    }

    @JsonProperty("capabilities")
    public ClusterVersionStatusCapabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(ClusterVersionStatusCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("conditionalUpdates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterVersionStatusConditionalUpdates> getConditionalUpdates() {
        return conditionalUpdates;
    }

    @JsonProperty("conditionalUpdates")
    public void setConditionalUpdates(List<ClusterVersionStatusConditionalUpdates> conditionalUpdates) {
        this.conditionalUpdates = conditionalUpdates;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterVersionStatusConditions> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ClusterVersionStatusConditions> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("desired")
    public ClusterVersionStatusDesired getDesired() {
        return desired;
    }

    @JsonProperty("desired")
    public void setDesired(ClusterVersionStatusDesired desired) {
        this.desired = desired;
    }

    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterVersionStatusHistory> getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(List<ClusterVersionStatusHistory> history) {
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
