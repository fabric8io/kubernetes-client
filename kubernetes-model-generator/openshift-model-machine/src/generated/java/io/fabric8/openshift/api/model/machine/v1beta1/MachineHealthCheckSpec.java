
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "maxUnhealthy",
    "nodeStartupTimeout",
    "remediationTemplate",
    "selector",
    "unhealthyConditions"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachineHealthCheckSpec implements KubernetesResource
{

    @JsonProperty("maxUnhealthy")
    private io.fabric8.kubernetes.api.model.IntOrString maxUnhealthy;
    @JsonProperty("nodeStartupTimeout")
    private Duration nodeStartupTimeout;
    @JsonProperty("remediationTemplate")
    private io.fabric8.kubernetes.api.model.ObjectReference remediationTemplate;
    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("unhealthyConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UnhealthyCondition> unhealthyConditions = new ArrayList<UnhealthyCondition>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineHealthCheckSpec() {
    }

    public MachineHealthCheckSpec(io.fabric8.kubernetes.api.model.IntOrString maxUnhealthy, Duration nodeStartupTimeout, io.fabric8.kubernetes.api.model.ObjectReference remediationTemplate, io.fabric8.kubernetes.api.model.LabelSelector selector, List<UnhealthyCondition> unhealthyConditions) {
        super();
        this.maxUnhealthy = maxUnhealthy;
        this.nodeStartupTimeout = nodeStartupTimeout;
        this.remediationTemplate = remediationTemplate;
        this.selector = selector;
        this.unhealthyConditions = unhealthyConditions;
    }

    @JsonProperty("maxUnhealthy")
    public io.fabric8.kubernetes.api.model.IntOrString getMaxUnhealthy() {
        return maxUnhealthy;
    }

    @JsonProperty("maxUnhealthy")
    public void setMaxUnhealthy(io.fabric8.kubernetes.api.model.IntOrString maxUnhealthy) {
        this.maxUnhealthy = maxUnhealthy;
    }

    @JsonProperty("nodeStartupTimeout")
    public Duration getNodeStartupTimeout() {
        return nodeStartupTimeout;
    }

    @JsonProperty("nodeStartupTimeout")
    public void setNodeStartupTimeout(Duration nodeStartupTimeout) {
        this.nodeStartupTimeout = nodeStartupTimeout;
    }

    @JsonProperty("remediationTemplate")
    public io.fabric8.kubernetes.api.model.ObjectReference getRemediationTemplate() {
        return remediationTemplate;
    }

    @JsonProperty("remediationTemplate")
    public void setRemediationTemplate(io.fabric8.kubernetes.api.model.ObjectReference remediationTemplate) {
        this.remediationTemplate = remediationTemplate;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("unhealthyConditions")
    public List<UnhealthyCondition> getUnhealthyConditions() {
        return unhealthyConditions;
    }

    @JsonProperty("unhealthyConditions")
    public void setUnhealthyConditions(List<UnhealthyCondition> unhealthyConditions) {
        this.unhealthyConditions = unhealthyConditions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
