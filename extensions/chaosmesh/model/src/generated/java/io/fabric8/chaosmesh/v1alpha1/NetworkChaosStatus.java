
package io.fabric8.chaosmesh.v1alpha1;

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
 * NetworkChaosStatus defines the observed state of NetworkChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "experiment",
    "instances"
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
public class NetworkChaosStatus implements Editable<NetworkChaosStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ChaosCondition> conditions = new ArrayList<>();
    @JsonProperty("experiment")
    private ExperimentStatus experiment;
    @JsonProperty("instances")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Long> instances = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkChaosStatus() {
    }

    public NetworkChaosStatus(List<ChaosCondition> conditions, ExperimentStatus experiment, Map<String, Long> instances) {
        super();
        this.conditions = conditions;
        this.experiment = experiment;
        this.instances = instances;
    }

    /**
     * Conditions represents the current global condition of the chaos
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ChaosCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions represents the current global condition of the chaos
     */
    @JsonProperty("conditions")
    public void setConditions(List<ChaosCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * NetworkChaosStatus defines the observed state of NetworkChaos
     */
    @JsonProperty("experiment")
    public ExperimentStatus getExperiment() {
        return experiment;
    }

    /**
     * NetworkChaosStatus defines the observed state of NetworkChaos
     */
    @JsonProperty("experiment")
    public void setExperiment(ExperimentStatus experiment) {
        this.experiment = experiment;
    }

    /**
     * Instances always specifies podnetworkchaos generation or empty
     */
    @JsonProperty("instances")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Long> getInstances() {
        return instances;
    }

    /**
     * Instances always specifies podnetworkchaos generation or empty
     */
    @JsonProperty("instances")
    public void setInstances(Map<String, Long> instances) {
        this.instances = instances;
    }

    @JsonIgnore
    public NetworkChaosStatusBuilder edit() {
        return new NetworkChaosStatusBuilder(this);
    }

    @JsonIgnore
    public NetworkChaosStatusBuilder toBuilder() {
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
