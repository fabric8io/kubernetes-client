
package io.fabric8.kubernetes.api.model.flowcontrol.v1;

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
    "distinguisherMethod",
    "matchingPrecedence",
    "priorityLevelConfiguration",
    "rules"
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
public class FlowSchemaSpec implements Editable<FlowSchemaSpecBuilder> , KubernetesResource
{

    @JsonProperty("distinguisherMethod")
    private FlowDistinguisherMethod distinguisherMethod;
    @JsonProperty("matchingPrecedence")
    private Integer matchingPrecedence;
    @JsonProperty("priorityLevelConfiguration")
    private PriorityLevelConfigurationReference priorityLevelConfiguration;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyRulesWithSubjects> rules = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlowSchemaSpec() {
    }

    public FlowSchemaSpec(FlowDistinguisherMethod distinguisherMethod, Integer matchingPrecedence, PriorityLevelConfigurationReference priorityLevelConfiguration, List<PolicyRulesWithSubjects> rules) {
        super();
        this.distinguisherMethod = distinguisherMethod;
        this.matchingPrecedence = matchingPrecedence;
        this.priorityLevelConfiguration = priorityLevelConfiguration;
        this.rules = rules;
    }

    @JsonProperty("distinguisherMethod")
    public FlowDistinguisherMethod getDistinguisherMethod() {
        return distinguisherMethod;
    }

    @JsonProperty("distinguisherMethod")
    public void setDistinguisherMethod(FlowDistinguisherMethod distinguisherMethod) {
        this.distinguisherMethod = distinguisherMethod;
    }

    @JsonProperty("matchingPrecedence")
    public Integer getMatchingPrecedence() {
        return matchingPrecedence;
    }

    @JsonProperty("matchingPrecedence")
    public void setMatchingPrecedence(Integer matchingPrecedence) {
        this.matchingPrecedence = matchingPrecedence;
    }

    @JsonProperty("priorityLevelConfiguration")
    public PriorityLevelConfigurationReference getPriorityLevelConfiguration() {
        return priorityLevelConfiguration;
    }

    @JsonProperty("priorityLevelConfiguration")
    public void setPriorityLevelConfiguration(PriorityLevelConfigurationReference priorityLevelConfiguration) {
        this.priorityLevelConfiguration = priorityLevelConfiguration;
    }

    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyRulesWithSubjects> getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(List<PolicyRulesWithSubjects> rules) {
        this.rules = rules;
    }

    @JsonIgnore
    public FlowSchemaSpecBuilder edit() {
        return new FlowSchemaSpecBuilder(this);
    }

    @JsonIgnore
    public FlowSchemaSpecBuilder toBuilder() {
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
