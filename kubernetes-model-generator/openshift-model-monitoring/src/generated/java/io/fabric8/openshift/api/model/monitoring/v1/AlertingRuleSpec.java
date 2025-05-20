
package io.fabric8.openshift.api.model.monitoring.v1;

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
 * AlertingRuleSpec is the desired state of an AlertingRule resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groups"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AlertingRuleSpec implements Editable<AlertingRuleSpecBuilder>, KubernetesResource
{

    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RuleGroup> groups = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertingRuleSpec() {
    }

    public AlertingRuleSpec(List<RuleGroup> groups) {
        super();
        this.groups = groups;
    }

    /**
     * groups is a list of grouped alerting rules.  Rule groups are the unit at which Prometheus parallelizes rule processing.  All rules in a single group share a configured evaluation interval.  All rules in the group will be processed together on this interval, sequentially, and all rules will be processed.<br><p> <br><p> It's common to group related alerting rules into a single AlertingRule resources, and within that resource, closely related alerts, or simply alerts with the same interval, into individual groups.  You are also free to create AlertingRule resources with only a single rule group, but be aware that this can have a performance impact on Prometheus if the group is extremely large or has very complex query expressions to evaluate. Spreading very complex rules across multiple groups to allow them to be processed in parallel is also a common use-case.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RuleGroup> getGroups() {
        return groups;
    }

    /**
     * groups is a list of grouped alerting rules.  Rule groups are the unit at which Prometheus parallelizes rule processing.  All rules in a single group share a configured evaluation interval.  All rules in the group will be processed together on this interval, sequentially, and all rules will be processed.<br><p> <br><p> It's common to group related alerting rules into a single AlertingRule resources, and within that resource, closely related alerts, or simply alerts with the same interval, into individual groups.  You are also free to create AlertingRule resources with only a single rule group, but be aware that this can have a performance impact on Prometheus if the group is extremely large or has very complex query expressions to evaluate. Spreading very complex rules across multiple groups to allow them to be processed in parallel is also a common use-case.
     */
    @JsonProperty("groups")
    public void setGroups(List<RuleGroup> groups) {
        this.groups = groups;
    }

    @JsonIgnore
    public AlertingRuleSpecBuilder edit() {
        return new AlertingRuleSpecBuilder(this);
    }

    @JsonIgnore
    public AlertingRuleSpecBuilder toBuilder() {
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
