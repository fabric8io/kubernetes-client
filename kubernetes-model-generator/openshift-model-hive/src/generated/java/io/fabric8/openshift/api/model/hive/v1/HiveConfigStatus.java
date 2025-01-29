
package io.fabric8.openshift.api.model.hive.v1;

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

/**
 * HiveConfigStatus defines the observed state of Hive
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aggregatorClientCAHash",
    "conditions",
    "configApplied",
    "observedGeneration"
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
public class HiveConfigStatus implements Editable<HiveConfigStatusBuilder>, KubernetesResource
{

    @JsonProperty("aggregatorClientCAHash")
    private String aggregatorClientCAHash;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HiveConfigCondition> conditions = new ArrayList<>();
    @JsonProperty("configApplied")
    private Boolean configApplied;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HiveConfigStatus() {
    }

    public HiveConfigStatus(String aggregatorClientCAHash, List<HiveConfigCondition> conditions, Boolean configApplied, Long observedGeneration) {
        super();
        this.aggregatorClientCAHash = aggregatorClientCAHash;
        this.conditions = conditions;
        this.configApplied = configApplied;
        this.observedGeneration = observedGeneration;
    }

    /**
     * AggregatorClientCAHash keeps an md5 hash of the aggregator client CA configmap data from the openshift-config-managed namespace. When the configmap changes, admission is redeployed.
     */
    @JsonProperty("aggregatorClientCAHash")
    public String getAggregatorClientCAHash() {
        return aggregatorClientCAHash;
    }

    /**
     * AggregatorClientCAHash keeps an md5 hash of the aggregator client CA configmap data from the openshift-config-managed namespace. When the configmap changes, admission is redeployed.
     */
    @JsonProperty("aggregatorClientCAHash")
    public void setAggregatorClientCAHash(String aggregatorClientCAHash) {
        this.aggregatorClientCAHash = aggregatorClientCAHash;
    }

    /**
     * Conditions includes more detailed status for the HiveConfig
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HiveConfigCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions includes more detailed status for the HiveConfig
     */
    @JsonProperty("conditions")
    public void setConditions(List<HiveConfigCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ConfigApplied will be set by the hive operator to indicate whether or not the LastGenerationObserved was successfully reconciled.
     */
    @JsonProperty("configApplied")
    public Boolean getConfigApplied() {
        return configApplied;
    }

    /**
     * ConfigApplied will be set by the hive operator to indicate whether or not the LastGenerationObserved was successfully reconciled.
     */
    @JsonProperty("configApplied")
    public void setConfigApplied(Boolean configApplied) {
        this.configApplied = configApplied;
    }

    /**
     * ObservedGeneration will record the most recently processed HiveConfig object's generation.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration will record the most recently processed HiveConfig object's generation.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonIgnore
    public HiveConfigStatusBuilder edit() {
        return new HiveConfigStatusBuilder(this);
    }

    @JsonIgnore
    public HiveConfigStatusBuilder toBuilder() {
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
