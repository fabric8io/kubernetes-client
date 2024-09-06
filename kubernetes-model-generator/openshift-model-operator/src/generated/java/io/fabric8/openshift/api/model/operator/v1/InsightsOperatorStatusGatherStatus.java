
package io.fabric8.openshift.api.model.operator.v1;

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
    "gatherers",
    "lastGatherDuration",
    "lastGatherTime"
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
public class InsightsOperatorStatusGatherStatus implements Editable<InsightsOperatorStatusGatherStatusBuilder> , KubernetesResource
{

    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InsightsOperatorStatusGSGatherers> gatherers = new ArrayList<>();
    @JsonProperty("lastGatherDuration")
    private String lastGatherDuration;
    @JsonProperty("lastGatherTime")
    private String lastGatherTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InsightsOperatorStatusGatherStatus() {
    }

    public InsightsOperatorStatusGatherStatus(List<InsightsOperatorStatusGSGatherers> gatherers, String lastGatherDuration, String lastGatherTime) {
        super();
        this.gatherers = gatherers;
        this.lastGatherDuration = lastGatherDuration;
        this.lastGatherTime = lastGatherTime;
    }

    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InsightsOperatorStatusGSGatherers> getGatherers() {
        return gatherers;
    }

    @JsonProperty("gatherers")
    public void setGatherers(List<InsightsOperatorStatusGSGatherers> gatherers) {
        this.gatherers = gatherers;
    }

    @JsonProperty("lastGatherDuration")
    public String getLastGatherDuration() {
        return lastGatherDuration;
    }

    @JsonProperty("lastGatherDuration")
    public void setLastGatherDuration(String lastGatherDuration) {
        this.lastGatherDuration = lastGatherDuration;
    }

    @JsonProperty("lastGatherTime")
    public String getLastGatherTime() {
        return lastGatherTime;
    }

    @JsonProperty("lastGatherTime")
    public void setLastGatherTime(String lastGatherTime) {
        this.lastGatherTime = lastGatherTime;
    }

    @JsonIgnore
    public InsightsOperatorStatusGatherStatusBuilder edit() {
        return new InsightsOperatorStatusGatherStatusBuilder(this);
    }

    @JsonIgnore
    public InsightsOperatorStatusGatherStatusBuilder toBuilder() {
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
