
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
    "buildAPIVersion",
    "env",
    "exposeDockerSocket",
    "forcePull",
    "from",
    "pullSecret",
    "secrets"
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
public class CustomBuildStrategy implements Editable<CustomBuildStrategyBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("buildAPIVersion")
    public String getBuildAPIVersion() {
        return buildAPIVersion;
    }

    @JsonProperty("buildAPIVersion")
    public void setBuildAPIVersion(String buildAPIVersion) {
        this.buildAPIVersion = buildAPIVersion;
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

    @JsonProperty("exposeDockerSocket")
    public Boolean getExposeDockerSocket() {
        return exposeDockerSocket;
    }

    @JsonProperty("exposeDockerSocket")
    public void setExposeDockerSocket(Boolean exposeDockerSocket) {
        this.exposeDockerSocket = exposeDockerSocket;
    }

    @JsonProperty("forcePull")
    public Boolean getForcePull() {
        return forcePull;
    }

    @JsonProperty("forcePull")
    public void setForcePull(Boolean forcePull) {
        this.forcePull = forcePull;
    }

    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    @JsonProperty("pullSecret")
    public LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    @JsonProperty("pullSecret")
    public void setPullSecret(LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretSpec> getSecrets() {
        return secrets;
    }

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
