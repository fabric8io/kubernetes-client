
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import java.util.LinkedHashMap;
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
 * ScoreCoordinate represents the configuration of the score type and score source
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addOn",
    "builtIn",
    "type"
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
public class ScoreCoordinate implements Editable<ScoreCoordinateBuilder>, KubernetesResource
{

    @JsonProperty("addOn")
    private AddOnScore addOn;
    @JsonProperty("builtIn")
    private String builtIn;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScoreCoordinate() {
    }

    public ScoreCoordinate(AddOnScore addOn, String builtIn, String type) {
        super();
        this.addOn = addOn;
        this.builtIn = builtIn;
        this.type = type;
    }

    /**
     * ScoreCoordinate represents the configuration of the score type and score source
     */
    @JsonProperty("addOn")
    public AddOnScore getAddOn() {
        return addOn;
    }

    /**
     * ScoreCoordinate represents the configuration of the score type and score source
     */
    @JsonProperty("addOn")
    public void setAddOn(AddOnScore addOn) {
        this.addOn = addOn;
    }

    /**
     * BuiltIn defines the name of a BuiltIn prioritizer. Below are the valid BuiltIn prioritizer names. 1) Balance: balance the decisions among the clusters. 2) Steady: ensure the existing decision is stabilized. 3) ResourceAllocatableCPU &amp; ResourceAllocatableMemory: sort clusters based on the allocatable. 4) Spread: spread the workload evenly to topologies.
     */
    @JsonProperty("builtIn")
    public String getBuiltIn() {
        return builtIn;
    }

    /**
     * BuiltIn defines the name of a BuiltIn prioritizer. Below are the valid BuiltIn prioritizer names. 1) Balance: balance the decisions among the clusters. 2) Steady: ensure the existing decision is stabilized. 3) ResourceAllocatableCPU &amp; ResourceAllocatableMemory: sort clusters based on the allocatable. 4) Spread: spread the workload evenly to topologies.
     */
    @JsonProperty("builtIn")
    public void setBuiltIn(String builtIn) {
        this.builtIn = builtIn;
    }

    /**
     * Type defines the type of the prioritizer score. Type is either "BuiltIn", "AddOn" or "", where "" is "BuiltIn" by default. When the type is "BuiltIn", need to specify a BuiltIn prioritizer name in BuiltIn. When the type is "AddOn", need to configure the score source in AddOn.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines the type of the prioritizer score. Type is either "BuiltIn", "AddOn" or "", where "" is "BuiltIn" by default. When the type is "BuiltIn", need to specify a BuiltIn prioritizer name in BuiltIn. When the type is "AddOn", need to configure the score source in AddOn.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ScoreCoordinateBuilder edit() {
        return new ScoreCoordinateBuilder(this);
    }

    @JsonIgnore
    public ScoreCoordinateBuilder toBuilder() {
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
