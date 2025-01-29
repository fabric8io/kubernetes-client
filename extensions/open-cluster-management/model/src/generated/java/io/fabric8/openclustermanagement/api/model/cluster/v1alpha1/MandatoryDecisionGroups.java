
package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

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
 * MandatoryDecisionGroups
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mandatoryDecisionGroups"
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
public class MandatoryDecisionGroups implements Editable<MandatoryDecisionGroupsBuilder>, KubernetesResource
{

    @JsonProperty("mandatoryDecisionGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MandatoryDecisionGroup> mandatoryDecisionGroups = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MandatoryDecisionGroups() {
    }

    public MandatoryDecisionGroups(List<MandatoryDecisionGroup> mandatoryDecisionGroups) {
        super();
        this.mandatoryDecisionGroups = mandatoryDecisionGroups;
    }

    /**
     * List of the decision groups names or indexes to apply the workload first and fail if workload did not reach successful state. GroupName or GroupIndex must match with the decisionGroups defined in the placement's decisionStrategy
     */
    @JsonProperty("mandatoryDecisionGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MandatoryDecisionGroup> getMandatoryDecisionGroups() {
        return mandatoryDecisionGroups;
    }

    /**
     * List of the decision groups names or indexes to apply the workload first and fail if workload did not reach successful state. GroupName or GroupIndex must match with the decisionGroups defined in the placement's decisionStrategy
     */
    @JsonProperty("mandatoryDecisionGroups")
    public void setMandatoryDecisionGroups(List<MandatoryDecisionGroup> mandatoryDecisionGroups) {
        this.mandatoryDecisionGroups = mandatoryDecisionGroups;
    }

    @JsonIgnore
    public MandatoryDecisionGroupsBuilder edit() {
        return new MandatoryDecisionGroupsBuilder(this);
    }

    @JsonIgnore
    public MandatoryDecisionGroupsBuilder toBuilder() {
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
