
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GenericWebHookEvent is the payload expected for a generic webhook post
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dockerStrategyOptions",
    "env",
    "git",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GenericWebHookEvent implements Editable<GenericWebHookEventBuilder>, KubernetesResource
{

    @JsonProperty("dockerStrategyOptions")
    private DockerStrategyOptions dockerStrategyOptions;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("git")
    private GitInfo git;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericWebHookEvent() {
    }

    public GenericWebHookEvent(DockerStrategyOptions dockerStrategyOptions, List<EnvVar> env, GitInfo git, String type) {
        super();
        this.dockerStrategyOptions = dockerStrategyOptions;
        this.env = env;
        this.git = git;
        this.type = type;
    }

    /**
     * GenericWebHookEvent is the payload expected for a generic webhook post
     */
    @JsonProperty("dockerStrategyOptions")
    public DockerStrategyOptions getDockerStrategyOptions() {
        return dockerStrategyOptions;
    }

    /**
     * GenericWebHookEvent is the payload expected for a generic webhook post
     */
    @JsonProperty("dockerStrategyOptions")
    public void setDockerStrategyOptions(DockerStrategyOptions dockerStrategyOptions) {
        this.dockerStrategyOptions = dockerStrategyOptions;
    }

    /**
     * env contains additional environment variables you want to pass into a builder container. ValueFrom is not supported.
     */
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    /**
     * env contains additional environment variables you want to pass into a builder container. ValueFrom is not supported.
     */
    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    /**
     * GenericWebHookEvent is the payload expected for a generic webhook post
     */
    @JsonProperty("git")
    public GitInfo getGit() {
        return git;
    }

    /**
     * GenericWebHookEvent is the payload expected for a generic webhook post
     */
    @JsonProperty("git")
    public void setGit(GitInfo git) {
        this.git = git;
    }

    /**
     * type is the type of source repository
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of source repository
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public GenericWebHookEventBuilder edit() {
        return new GenericWebHookEventBuilder(this);
    }

    @JsonIgnore
    public GenericWebHookEventBuilder toBuilder() {
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
        if (!(o instanceof GenericWebHookEvent)) {
            return false;
        }
        GenericWebHookEvent other = (GenericWebHookEvent) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dockerStrategyOptions = this.getDockerStrategyOptions();
        Object other$dockerStrategyOptions = other.getDockerStrategyOptions();
        if (this$dockerStrategyOptions == null ? other$dockerStrategyOptions != null : !this$dockerStrategyOptions.equals(other$dockerStrategyOptions)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$git = this.getGit();
        Object other$git = other.getGit();
        if (this$git == null ? other$git != null : !this$git.equals(other$git)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof GenericWebHookEvent;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dockerStrategyOptions = this.getDockerStrategyOptions();
        result = result * prime + ($dockerStrategyOptions == null ? 43 : $dockerStrategyOptions.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $git = this.getGit();
        result = result * prime + ($git == null ? 43 : $git.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GenericWebHookEvent(" + "dockerStrategyOptions=" + this.getDockerStrategyOptions() + ", env=" + this.getEnv() + ", git=" + this.getGit() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
