
package io.fabric8.openshift.api.model.insights.v1alpha2;

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
import io.fabric8.kubernetes.api.model.Condition;
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
 * gathererStatus represents information about a particular data gatherer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "lastGatherSeconds",
    "name"
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
public class GathererStatus implements Editable<GathererStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("lastGatherSeconds")
    private Integer lastGatherSeconds;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GathererStatus() {
    }

    public GathererStatus(List<Condition> conditions, Integer lastGatherSeconds, String name) {
        super();
        this.conditions = conditions;
        this.lastGatherSeconds = lastGatherSeconds;
        this.name = name;
    }

    /**
     * conditions provide details on the status of each gatherer.<br><p> <br><p> The current condition type is DataGathered<br><p> <br><p> The DataGathered condition is used to represent whether or not the data was gathered by a gatherer specified by name. When it has a status of True and a reason of GatheredOK, the data has been successfully gathered as expected. When it has a status of False and a reason of NoData, no data was gathered—for example, when the resource is not present in the cluster. When it has a status of False and a reason of GatherError, an error occurred and no data was gathered. When it has a status of False and a reason of GatherPanic, a panic occurred during gathering and no data was collected. When it has a status of False and a reason of GatherWithErrorReason, data was partially gathered or gathered with an error message.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions provide details on the status of each gatherer.<br><p> <br><p> The current condition type is DataGathered<br><p> <br><p> The DataGathered condition is used to represent whether or not the data was gathered by a gatherer specified by name. When it has a status of True and a reason of GatheredOK, the data has been successfully gathered as expected. When it has a status of False and a reason of NoData, no data was gathered—for example, when the resource is not present in the cluster. When it has a status of False and a reason of GatherError, an error occurred and no data was gathered. When it has a status of False and a reason of GatherPanic, a panic occurred during gathering and no data was collected. When it has a status of False and a reason of GatherWithErrorReason, data was partially gathered or gathered with an error message.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * lastGatherSeconds is required field that represents the time spent gathering in seconds
     */
    @JsonProperty("lastGatherSeconds")
    public Integer getLastGatherSeconds() {
        return lastGatherSeconds;
    }

    /**
     * lastGatherSeconds is required field that represents the time spent gathering in seconds
     */
    @JsonProperty("lastGatherSeconds")
    public void setLastGatherSeconds(Integer lastGatherSeconds) {
        this.lastGatherSeconds = lastGatherSeconds;
    }

    /**
     * name is the required name of the gatherer. It must contain at least 5 characters and may not exceed 256 characters.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the required name of the gatherer. It must contain at least 5 characters and may not exceed 256 characters.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public GathererStatusBuilder edit() {
        return new GathererStatusBuilder(this);
    }

    @JsonIgnore
    public GathererStatusBuilder toBuilder() {
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
        if (!(o instanceof GathererStatus)) {
            return false;
        }
        GathererStatus other = (GathererStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$lastGatherSeconds = this.getLastGatherSeconds();
        Object other$lastGatherSeconds = other.getLastGatherSeconds();
        if (this$lastGatherSeconds == null ? other$lastGatherSeconds != null : !this$lastGatherSeconds.equals(other$lastGatherSeconds)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof GathererStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $lastGatherSeconds = this.getLastGatherSeconds();
        result = result * prime + ($lastGatherSeconds == null ? 43 : $lastGatherSeconds.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GathererStatus(" + "conditions=" + this.getConditions() + ", lastGatherSeconds=" + this.getLastGatherSeconds() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
