
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
 * SpreadPolicy defines how the placement decision should be spread among the ManagedClusters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "spreadConstraints"
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
public class SpreadPolicy implements Editable<SpreadPolicyBuilder>, KubernetesResource
{

    @JsonProperty("spreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SpreadConstraintsTerm> spreadConstraints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SpreadPolicy() {
    }

    public SpreadPolicy(List<SpreadConstraintsTerm> spreadConstraints) {
        super();
        this.spreadConstraints = spreadConstraints;
    }

    /**
     * SpreadConstraints defines how the placement decision should be distributed among a set of ManagedClusters. The importance of the SpreadConstraintsTerms follows the natural order of their index in the slice. The scheduler first consider SpreadConstraintsTerms with smaller index then those with larger index to distribute the placement decision.
     */
    @JsonProperty("spreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SpreadConstraintsTerm> getSpreadConstraints() {
        return spreadConstraints;
    }

    /**
     * SpreadConstraints defines how the placement decision should be distributed among a set of ManagedClusters. The importance of the SpreadConstraintsTerms follows the natural order of their index in the slice. The scheduler first consider SpreadConstraintsTerms with smaller index then those with larger index to distribute the placement decision.
     */
    @JsonProperty("spreadConstraints")
    public void setSpreadConstraints(List<SpreadConstraintsTerm> spreadConstraints) {
        this.spreadConstraints = spreadConstraints;
    }

    @JsonIgnore
    public SpreadPolicyBuilder edit() {
        return new SpreadPolicyBuilder(this);
    }

    @JsonIgnore
    public SpreadPolicyBuilder toBuilder() {
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
