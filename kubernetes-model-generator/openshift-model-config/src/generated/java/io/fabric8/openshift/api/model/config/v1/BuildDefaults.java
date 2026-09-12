
package io.fabric8.openshift.api.model.config.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "defaultProxy",
    "env",
    "gitProxy",
    "imageLabels",
    "resources"
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
public class BuildDefaults implements Editable<BuildDefaultsBuilder>, KubernetesResource
{

    @JsonProperty("defaultProxy")
    private ProxySpec defaultProxy;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("gitProxy")
    private ProxySpec gitProxy;
    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageLabel> imageLabels = new ArrayList<>();
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildDefaults() {
    }

    public BuildDefaults(ProxySpec defaultProxy, List<EnvVar> env, ProxySpec gitProxy, List<ImageLabel> imageLabels, ResourceRequirements resources) {
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

    /**
     * env is a set of default environment variables that will be applied to the build if the specified variables do not exist on the build
     */
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    /**
     * env is a set of default environment variables that will be applied to the build if the specified variables do not exist on the build
     */
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

    /**
     * imageLabels is a list of docker labels that are applied to the resulting image. User can override a default label by providing a label with the same name in their Build/BuildConfig.
     */
    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageLabel> getImageLabels() {
        return imageLabels;
    }

    /**
     * imageLabels is a list of docker labels that are applied to the resulting image. User can override a default label by providing a label with the same name in their Build/BuildConfig.
     */
    @JsonProperty("imageLabels")
    public void setImageLabels(List<ImageLabel> imageLabels) {
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
    public BuildDefaultsBuilder edit() {
        return new BuildDefaultsBuilder(this);
    }

    @JsonIgnore
    public BuildDefaultsBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BuildDefaults)) {
            return false;
        }
        BuildDefaults other = (BuildDefaults) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$defaultProxy = this.getDefaultProxy();
        Object other$defaultProxy = other.getDefaultProxy();
        if (this$defaultProxy == null ? other$defaultProxy != null : !this$defaultProxy.equals(other$defaultProxy)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$gitProxy = this.getGitProxy();
        Object other$gitProxy = other.getGitProxy();
        if (this$gitProxy == null ? other$gitProxy != null : !this$gitProxy.equals(other$gitProxy)) {
            return false;
        }
        Object this$imageLabels = this.getImageLabels();
        Object other$imageLabels = other.getImageLabels();
        if (this$imageLabels == null ? other$imageLabels != null : !this$imageLabels.equals(other$imageLabels)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof BuildDefaults;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $defaultProxy = this.getDefaultProxy();
        result = result * prime + ($defaultProxy == null ? 43 : $defaultProxy.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $gitProxy = this.getGitProxy();
        result = result * prime + ($gitProxy == null ? 43 : $gitProxy.hashCode());
        Object $imageLabels = this.getImageLabels();
        result = result * prime + ($imageLabels == null ? 43 : $imageLabels.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildDefaults(" + "defaultProxy=" + this.getDefaultProxy() + ", env=" + this.getEnv() + ", gitProxy=" + this.getGitProxy() + ", imageLabels=" + this.getImageLabels() + ", resources=" + this.getResources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
