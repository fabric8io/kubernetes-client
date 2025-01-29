
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
import io.fabric8.kubernetes.api.model.Condition;
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
 * AddOnPlacementScoreStatus represents the current status of AddOnPlacementScore.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "scores",
    "validUntil"
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
public class AddOnPlacementScoreStatus implements Editable<AddOnPlacementScoreStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("scores")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AddOnPlacementScoreItem> scores = new ArrayList<>();
    @JsonProperty("validUntil")
    private String validUntil;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AddOnPlacementScoreStatus() {
    }

    public AddOnPlacementScoreStatus(List<Condition> conditions, List<AddOnPlacementScoreItem> scores, String validUntil) {
        super();
        this.conditions = conditions;
        this.scores = scores;
        this.validUntil = validUntil;
    }

    /**
     * Conditions contain the different condition statuses for this AddOnPlacementScore.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions contain the different condition statuses for this AddOnPlacementScore.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Scores contain a list of score name and value of this managed cluster.
     */
    @JsonProperty("scores")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AddOnPlacementScoreItem> getScores() {
        return scores;
    }

    /**
     * Scores contain a list of score name and value of this managed cluster.
     */
    @JsonProperty("scores")
    public void setScores(List<AddOnPlacementScoreItem> scores) {
        this.scores = scores;
    }

    /**
     * AddOnPlacementScoreStatus represents the current status of AddOnPlacementScore.
     */
    @JsonProperty("validUntil")
    public String getValidUntil() {
        return validUntil;
    }

    /**
     * AddOnPlacementScoreStatus represents the current status of AddOnPlacementScore.
     */
    @JsonProperty("validUntil")
    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    @JsonIgnore
    public AddOnPlacementScoreStatusBuilder edit() {
        return new AddOnPlacementScoreStatusBuilder(this);
    }

    @JsonIgnore
    public AddOnPlacementScoreStatusBuilder toBuilder() {
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
