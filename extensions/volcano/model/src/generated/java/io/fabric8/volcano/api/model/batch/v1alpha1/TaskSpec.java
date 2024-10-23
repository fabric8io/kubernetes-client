
package io.fabric8.volcano.api.model.batch.v1alpha1;

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
    "dependsOn",
    "maxRetry",
    "minAvailable",
    "name",
    "policies",
    "replicas",
    "template",
    "topologyPolicy"
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
@Generated("jsonschema2pojo")
public class TaskSpec implements Editable<TaskSpecBuilder> , KubernetesResource
{

    @JsonProperty("dependsOn")
    private DependsOn dependsOn;
    @JsonProperty("maxRetry")
    private Integer maxRetry;
    @JsonProperty("minAvailable")
    private Integer minAvailable;
    @JsonProperty("name")
    private String name;
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LifecyclePolicy> policies = new ArrayList<>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonProperty("topologyPolicy")
    private String topologyPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaskSpec() {
    }

    public TaskSpec(DependsOn dependsOn, Integer maxRetry, Integer minAvailable, String name, List<LifecyclePolicy> policies, Integer replicas, PodTemplateSpec template, String topologyPolicy) {
        super();
        this.dependsOn = dependsOn;
        this.maxRetry = maxRetry;
        this.minAvailable = minAvailable;
        this.name = name;
        this.policies = policies;
        this.replicas = replicas;
        this.template = template;
        this.topologyPolicy = topologyPolicy;
    }

    @JsonProperty("dependsOn")
    public DependsOn getDependsOn() {
        return dependsOn;
    }

    @JsonProperty("dependsOn")
    public void setDependsOn(DependsOn dependsOn) {
        this.dependsOn = dependsOn;
    }

    @JsonProperty("maxRetry")
    public Integer getMaxRetry() {
        return maxRetry;
    }

    @JsonProperty("maxRetry")
    public void setMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
    }

    @JsonProperty("minAvailable")
    public Integer getMinAvailable() {
        return minAvailable;
    }

    @JsonProperty("minAvailable")
    public void setMinAvailable(Integer minAvailable) {
        this.minAvailable = minAvailable;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LifecyclePolicy> getPolicies() {
        return policies;
    }

    @JsonProperty("policies")
    public void setPolicies(List<LifecyclePolicy> policies) {
        this.policies = policies;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    @JsonProperty("topologyPolicy")
    public String getTopologyPolicy() {
        return topologyPolicy;
    }

    @JsonProperty("topologyPolicy")
    public void setTopologyPolicy(String topologyPolicy) {
        this.topologyPolicy = topologyPolicy;
    }

    @JsonIgnore
    public TaskSpecBuilder edit() {
        return new TaskSpecBuilder(this);
    }

    @JsonIgnore
    public TaskSpecBuilder toBuilder() {
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
