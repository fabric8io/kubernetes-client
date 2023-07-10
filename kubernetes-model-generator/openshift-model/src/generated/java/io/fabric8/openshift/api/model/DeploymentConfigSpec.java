
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
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
    "minReadySeconds",
    "paused",
    "replicas",
    "revisionHistoryLimit",
    "selector",
    "strategy",
    "template",
    "test",
    "triggers"
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
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class DeploymentConfigSpec implements KubernetesResource
{

    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("revisionHistoryLimit")
    private Integer revisionHistoryLimit;
    @JsonProperty("selector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> selector = new LinkedHashMap<String, String>();
    @JsonProperty("strategy")
    private DeploymentStrategy strategy;
    @JsonProperty("template")
    private io.fabric8.kubernetes.api.model.PodTemplateSpec template;
    @JsonProperty("test")
    private Boolean test;
    @JsonProperty("triggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeploymentTriggerPolicy> triggers = new ArrayList<DeploymentTriggerPolicy>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeploymentConfigSpec() {
    }

    public DeploymentConfigSpec(Integer minReadySeconds, Boolean paused, Integer replicas, Integer revisionHistoryLimit, Map<String, String> selector, DeploymentStrategy strategy, io.fabric8.kubernetes.api.model.PodTemplateSpec template, Boolean test, List<DeploymentTriggerPolicy> triggers) {
        super();
        this.minReadySeconds = minReadySeconds;
        this.paused = paused;
        this.replicas = replicas;
        this.revisionHistoryLimit = revisionHistoryLimit;
        this.selector = selector;
        this.strategy = strategy;
        this.template = template;
        this.test = test;
        this.triggers = triggers;
    }

    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("revisionHistoryLimit")
    public Integer getRevisionHistoryLimit() {
        return revisionHistoryLimit;
    }

    @JsonProperty("revisionHistoryLimit")
    public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
        this.revisionHistoryLimit = revisionHistoryLimit;
    }

    @JsonProperty("selector")
    public Map<String, String> getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(Map<String, String> selector) {
        this.selector = selector;
    }

    @JsonProperty("strategy")
    public DeploymentStrategy getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(DeploymentStrategy strategy) {
        this.strategy = strategy;
    }

    @JsonProperty("template")
    public io.fabric8.kubernetes.api.model.PodTemplateSpec getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(io.fabric8.kubernetes.api.model.PodTemplateSpec template) {
        this.template = template;
    }

    @JsonProperty("test")
    public Boolean getTest() {
        return test;
    }

    @JsonProperty("test")
    public void setTest(Boolean test) {
        this.test = test;
    }

    @JsonProperty("triggers")
    public List<DeploymentTriggerPolicy> getTriggers() {
        return triggers;
    }

    @JsonProperty("triggers")
    public void setTriggers(List<DeploymentTriggerPolicy> triggers) {
        this.triggers = triggers;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
