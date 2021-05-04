
package io.fabric8.openshift.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "defaultNodeSelector",
    "mastersSchedulable",
    "policy"
})
@ToString
@EqualsAndHashCode
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
public class SchedulerSpec implements KubernetesResource
{

    @JsonProperty("defaultNodeSelector")
    private String defaultNodeSelector;
    @JsonProperty("mastersSchedulable")
    private Boolean mastersSchedulable;
    @JsonProperty("policy")
    private ConfigMapNameReference policy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SchedulerSpec() {
    }

    /**
     * 
     * @param defaultNodeSelector
     * @param mastersSchedulable
     * @param policy
     */
    public SchedulerSpec(String defaultNodeSelector, Boolean mastersSchedulable, ConfigMapNameReference policy) {
        super();
        this.defaultNodeSelector = defaultNodeSelector;
        this.mastersSchedulable = mastersSchedulable;
        this.policy = policy;
    }

    @JsonProperty("defaultNodeSelector")
    public String getDefaultNodeSelector() {
        return defaultNodeSelector;
    }

    @JsonProperty("defaultNodeSelector")
    public void setDefaultNodeSelector(String defaultNodeSelector) {
        this.defaultNodeSelector = defaultNodeSelector;
    }

    @JsonProperty("mastersSchedulable")
    public Boolean getMastersSchedulable() {
        return mastersSchedulable;
    }

    @JsonProperty("mastersSchedulable")
    public void setMastersSchedulable(Boolean mastersSchedulable) {
        this.mastersSchedulable = mastersSchedulable;
    }

    @JsonProperty("policy")
    public ConfigMapNameReference getPolicy() {
        return policy;
    }

    @JsonProperty("policy")
    public void setPolicy(ConfigMapNameReference policy) {
        this.policy = policy;
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
