
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
    "defaultProxy",
    "env",
    "gitProxy",
    "imageLabels",
    "resources"
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
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildDefaults implements KubernetesResource
{

    @JsonProperty("defaultProxy")
    private ProxySpec defaultProxy;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<EnvVar>();
    @JsonProperty("gitProxy")
    private ProxySpec gitProxy;
    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageLabel> imageLabels = new ArrayList<ImageLabel>();
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildDefaults() {
    }

    public BuildDefaults(ProxySpec defaultProxy, List<EnvVar> env, ProxySpec gitProxy, List<ImageLabel> imageLabels, io.fabric8.kubernetes.api.model.ResourceRequirements resources) {
        super();
        this.defaultProxy = defaultProxy;
        this.env = env;
        this.gitProxy = gitProxy;
        this.imageLabels = imageLabels;
        this.resources = resources;
    }

    @JsonProperty("defaultProxy")
    public ProxySpec getDefaultProxy() {
        return defaultProxy;
    }

    @JsonProperty("defaultProxy")
    public void setDefaultProxy(ProxySpec defaultProxy) {
        this.defaultProxy = defaultProxy;
    }

    @JsonProperty("env")
    public List<EnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    @JsonProperty("gitProxy")
    public ProxySpec getGitProxy() {
        return gitProxy;
    }

    @JsonProperty("gitProxy")
    public void setGitProxy(ProxySpec gitProxy) {
        this.gitProxy = gitProxy;
    }

    @JsonProperty("imageLabels")
    public List<ImageLabel> getImageLabels() {
        return imageLabels;
    }

    @JsonProperty("imageLabels")
    public void setImageLabels(List<ImageLabel> imageLabels) {
        this.imageLabels = imageLabels;
    }

    @JsonProperty("resources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(io.fabric8.kubernetes.api.model.ResourceRequirements resources) {
        this.resources = resources;
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
