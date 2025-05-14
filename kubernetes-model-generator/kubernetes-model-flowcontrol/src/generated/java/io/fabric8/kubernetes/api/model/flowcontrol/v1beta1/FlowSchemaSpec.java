
package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

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
 * FlowSchemaSpec describes how the FlowSchema's specification looks like.
 */
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
public class FlowSchemaSpec implements Editable<FlowSchemaSpecBuilder>, KubernetesResource
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

    /**
     * FlowSchemaSpec describes how the FlowSchema's specification looks like.
     */
    @JsonProperty("distinguisherMethod")
    public FlowDistinguisherMethod getDistinguisherMethod() {
        return distinguisherMethod;
    }

    /**
     * FlowSchemaSpec describes how the FlowSchema's specification looks like.
     */
    @JsonProperty("distinguisherMethod")
    public void setDistinguisherMethod(FlowDistinguisherMethod distinguisherMethod) {
        this.distinguisherMethod = distinguisherMethod;
    }

    /**
     * `matchingPrecedence` is used to choose among the FlowSchemas that match a given request. The chosen FlowSchema is among those with the numerically lowest (which we take to be logically highest) MatchingPrecedence.  Each MatchingPrecedence value must be ranged in [1,10000]. Note that if the precedence is not specified, it will be set to 1000 as default.
     */
    @JsonProperty("matchingPrecedence")
    public Integer getMatchingPrecedence() {
        return matchingPrecedence;
    }

    /**
     * `matchingPrecedence` is used to choose among the FlowSchemas that match a given request. The chosen FlowSchema is among those with the numerically lowest (which we take to be logically highest) MatchingPrecedence.  Each MatchingPrecedence value must be ranged in [1,10000]. Note that if the precedence is not specified, it will be set to 1000 as default.
     */
    @JsonProperty("matchingPrecedence")
    public void setMatchingPrecedence(Integer matchingPrecedence) {
        this.matchingPrecedence = matchingPrecedence;
    }

    /**
     * FlowSchemaSpec describes how the FlowSchema's specification looks like.
     */
    @JsonProperty("priorityLevelConfiguration")
    public PriorityLevelConfigurationReference getPriorityLevelConfiguration() {
        return priorityLevelConfiguration;
    }

    /**
     * FlowSchemaSpec describes how the FlowSchema's specification looks like.
     */
    @JsonProperty("priorityLevelConfiguration")
    public void setPriorityLevelConfiguration(PriorityLevelConfigurationReference priorityLevelConfiguration) {
        this.priorityLevelConfiguration = priorityLevelConfiguration;
    }

    /**
     * `rules` describes which requests will match this flow schema. This FlowSchema matches a request if and only if at least one member of rules matches the request. if it is an empty slice, there will be no requests matching the FlowSchema.
     */
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyRulesWithSubjects> getRules() {
        return rules;
    }

    /**
     * `rules` describes which requests will match this flow schema. This FlowSchema matches a request if and only if at least one member of rules matches the request. if it is an empty slice, there will be no requests matching the FlowSchema.
     */
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
