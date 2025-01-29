
package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

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
    "arguments",
    "envVar",
    "imageOverride",
    "replicaCount",
    "resources"
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
public class DeploymentConfig implements Editable<DeploymentConfigBuilder>, KubernetesResource
{

    @JsonProperty("arguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> arguments = new ArrayList<>();
    @JsonProperty("envVar")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> envVar = new ArrayList<>();
    @JsonProperty("imageOverride")
    private String imageOverride;
    @JsonProperty("replicaCount")
    private Integer replicaCount;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentConfig() {
    }

    public DeploymentConfig(List<String> arguments, List<EnvVar> envVar, String imageOverride, Integer replicaCount, ResourceRequirements resources) {
        super();
        this.arguments = arguments;
        this.envVar = envVar;
        this.imageOverride = imageOverride;
        this.replicaCount = replicaCount;
        this.resources = resources;
    }

    @JsonProperty("arguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getArguments() {
        return arguments;
    }

    @JsonProperty("arguments")
    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    @JsonProperty("envVar")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnvVar() {
        return envVar;
    }

    @JsonProperty("envVar")
    public void setEnvVar(List<EnvVar> envVar) {
        this.envVar = envVar;
    }

    @JsonProperty("imageOverride")
    public String getImageOverride() {
        return imageOverride;
    }

    @JsonProperty("imageOverride")
    public void setImageOverride(String imageOverride) {
        this.imageOverride = imageOverride;
    }

    @JsonProperty("replicaCount")
    public Integer getReplicaCount() {
        return replicaCount;
    }

    @JsonProperty("replicaCount")
    public void setReplicaCount(Integer replicaCount) {
        this.replicaCount = replicaCount;
    }

    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonIgnore
    public DeploymentConfigBuilder edit() {
        return new DeploymentConfigBuilder(this);
    }

    @JsonIgnore
    public DeploymentConfigBuilder toBuilder() {
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
