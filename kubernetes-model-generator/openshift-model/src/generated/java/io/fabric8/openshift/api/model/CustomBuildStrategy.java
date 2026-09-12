
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

/**
 * CustomBuildStrategy defines input parameters specific to Custom build.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildAPIVersion",
    "env",
    "exposeDockerSocket",
    "forcePull",
    "from",
    "pullSecret",
    "secrets"
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
public class CustomBuildStrategy implements Editable<CustomBuildStrategyBuilder>, KubernetesResource
{

    @JsonProperty("buildAPIVersion")
    private String buildAPIVersion;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("exposeDockerSocket")
    private Boolean exposeDockerSocket;
    @JsonProperty("forcePull")
    private Boolean forcePull;
    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("pullSecret")
    private LocalObjectReference pullSecret;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretSpec> secrets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomBuildStrategy() {
    }

    public CustomBuildStrategy(String buildAPIVersion, List<EnvVar> env, Boolean exposeDockerSocket, Boolean forcePull, ObjectReference from, LocalObjectReference pullSecret, List<SecretSpec> secrets) {
        super();
        this.buildAPIVersion = buildAPIVersion;
        this.env = env;
        this.exposeDockerSocket = exposeDockerSocket;
        this.forcePull = forcePull;
        this.from = from;
        this.pullSecret = pullSecret;
        this.secrets = secrets;
    }

    /**
     * buildAPIVersion is the requested API version for the Build object serialized and passed to the custom builder
     */
    @JsonProperty("buildAPIVersion")
    public String getBuildAPIVersion() {
        return buildAPIVersion;
    }

    /**
     * buildAPIVersion is the requested API version for the Build object serialized and passed to the custom builder
     */
    @JsonProperty("buildAPIVersion")
    public void setBuildAPIVersion(String buildAPIVersion) {
        this.buildAPIVersion = buildAPIVersion;
    }

    /**
     * env contains additional environment variables you want to pass into a builder container.
     */
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    /**
     * env contains additional environment variables you want to pass into a builder container.
     */
    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    /**
     * exposeDockerSocket will allow running Docker commands (and build container images) from inside the container.
     */
    @JsonProperty("exposeDockerSocket")
    public Boolean getExposeDockerSocket() {
        return exposeDockerSocket;
    }

    /**
     * exposeDockerSocket will allow running Docker commands (and build container images) from inside the container.
     */
    @JsonProperty("exposeDockerSocket")
    public void setExposeDockerSocket(Boolean exposeDockerSocket) {
        this.exposeDockerSocket = exposeDockerSocket;
    }

    /**
     * forcePull describes if the controller should configure the build pod to always pull the images for the builder or only pull if it is not present locally
     */
    @JsonProperty("forcePull")
    public Boolean getForcePull() {
        return forcePull;
    }

    /**
     * forcePull describes if the controller should configure the build pod to always pull the images for the builder or only pull if it is not present locally
     */
    @JsonProperty("forcePull")
    public void setForcePull(Boolean forcePull) {
        this.forcePull = forcePull;
    }

    /**
     * CustomBuildStrategy defines input parameters specific to Custom build.
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * CustomBuildStrategy defines input parameters specific to Custom build.
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * CustomBuildStrategy defines input parameters specific to Custom build.
     */
    @JsonProperty("pullSecret")
    public LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    /**
     * CustomBuildStrategy defines input parameters specific to Custom build.
     */
    @JsonProperty("pullSecret")
    public void setPullSecret(LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    /**
     * secrets is a list of additional secrets that will be included in the build pod
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretSpec> getSecrets() {
        return secrets;
    }

    /**
     * secrets is a list of additional secrets that will be included in the build pod
     */
    @JsonProperty("secrets")
    public void setSecrets(List<SecretSpec> secrets) {
        this.secrets = secrets;
    }

    @JsonIgnore
    public CustomBuildStrategyBuilder edit() {
        return new CustomBuildStrategyBuilder(this);
    }

    @JsonIgnore
    public CustomBuildStrategyBuilder toBuilder() {
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
        if (!(o instanceof CustomBuildStrategy)) {
            return false;
        }
        CustomBuildStrategy other = (CustomBuildStrategy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$buildAPIVersion = this.getBuildAPIVersion();
        Object other$buildAPIVersion = other.getBuildAPIVersion();
        if (this$buildAPIVersion == null ? other$buildAPIVersion != null : !this$buildAPIVersion.equals(other$buildAPIVersion)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$exposeDockerSocket = this.getExposeDockerSocket();
        Object other$exposeDockerSocket = other.getExposeDockerSocket();
        if (this$exposeDockerSocket == null ? other$exposeDockerSocket != null : !this$exposeDockerSocket.equals(other$exposeDockerSocket)) {
            return false;
        }
        Object this$forcePull = this.getForcePull();
        Object other$forcePull = other.getForcePull();
        if (this$forcePull == null ? other$forcePull != null : !this$forcePull.equals(other$forcePull)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$pullSecret = this.getPullSecret();
        Object other$pullSecret = other.getPullSecret();
        if (this$pullSecret == null ? other$pullSecret != null : !this$pullSecret.equals(other$pullSecret)) {
            return false;
        }
        Object this$secrets = this.getSecrets();
        Object other$secrets = other.getSecrets();
        if (this$secrets == null ? other$secrets != null : !this$secrets.equals(other$secrets)) {
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
        return other instanceof CustomBuildStrategy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $buildAPIVersion = this.getBuildAPIVersion();
        result = result * prime + ($buildAPIVersion == null ? 43 : $buildAPIVersion.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $exposeDockerSocket = this.getExposeDockerSocket();
        result = result * prime + ($exposeDockerSocket == null ? 43 : $exposeDockerSocket.hashCode());
        Object $forcePull = this.getForcePull();
        result = result * prime + ($forcePull == null ? 43 : $forcePull.hashCode());
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $pullSecret = this.getPullSecret();
        result = result * prime + ($pullSecret == null ? 43 : $pullSecret.hashCode());
        Object $secrets = this.getSecrets();
        result = result * prime + ($secrets == null ? 43 : $secrets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomBuildStrategy(" + "buildAPIVersion=" + this.getBuildAPIVersion() + ", env=" + this.getEnv() + ", exposeDockerSocket=" + this.getExposeDockerSocket() + ", forcePull=" + this.getForcePull() + ", from=" + this.getFrom() + ", pullSecret=" + this.getPullSecret() + ", secrets=" + this.getSecrets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
