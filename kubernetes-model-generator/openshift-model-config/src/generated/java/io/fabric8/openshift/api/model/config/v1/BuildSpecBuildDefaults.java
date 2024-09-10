
package io.fabric8.openshift.api.model.config.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "defaultProxy",
    "env",
    "gitProxy",
    "imageLabels",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildSpecBuildDefaults implements Editable<BuildSpecBuildDefaultsBuilder> , KubernetesResource
{

    @JsonProperty("defaultProxy")
    private BuildSpecBDDefaultProxy defaultProxy;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("gitProxy")
    private BuildSpecBDGitProxy gitProxy;
    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildSpecBDImageLabels> imageLabels = new ArrayList<>();
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildSpecBuildDefaults() {
    }

    public BuildSpecBuildDefaults(BuildSpecBDDefaultProxy defaultProxy, List<EnvVar> env, BuildSpecBDGitProxy gitProxy, List<BuildSpecBDImageLabels> imageLabels, ResourceRequirements resources) {
        super();
        this.defaultProxy = defaultProxy;
        this.env = env;
        this.gitProxy = gitProxy;
        this.imageLabels = imageLabels;
        this.resources = resources;
    }

    @JsonProperty("defaultProxy")
    public BuildSpecBDDefaultProxy getDefaultProxy() {
        return defaultProxy;
    }

    @JsonProperty("defaultProxy")
    public void setDefaultProxy(BuildSpecBDDefaultProxy defaultProxy) {
        this.defaultProxy = defaultProxy;
    }

    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    @JsonProperty("gitProxy")
    public BuildSpecBDGitProxy getGitProxy() {
        return gitProxy;
    }

    @JsonProperty("gitProxy")
    public void setGitProxy(BuildSpecBDGitProxy gitProxy) {
        this.gitProxy = gitProxy;
    }

    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BuildSpecBDImageLabels> getImageLabels() {
        return imageLabels;
    }

    @JsonProperty("imageLabels")
    public void setImageLabels(List<BuildSpecBDImageLabels> imageLabels) {
        this.imageLabels = imageLabels;
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
    public BuildSpecBuildDefaultsBuilder edit() {
        return new BuildSpecBuildDefaultsBuilder(this);
    }

    @JsonIgnore
    public BuildSpecBuildDefaultsBuilder toBuilder() {
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
