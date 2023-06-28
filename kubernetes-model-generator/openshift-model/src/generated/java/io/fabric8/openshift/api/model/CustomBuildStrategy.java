
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
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
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
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CustomBuildStrategy implements KubernetesResource
{

    @JsonProperty("buildAPIVersion")
    private String buildAPIVersion;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<EnvVar>();
    @JsonProperty("exposeDockerSocket")
    private Boolean exposeDockerSocket;
    @JsonProperty("forcePull")
    private Boolean forcePull;
    @JsonProperty("from")
    private io.fabric8.kubernetes.api.model.ObjectReference from;
    @JsonProperty("pullSecret")
    private io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretSpec> secrets = new ArrayList<SecretSpec>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomBuildStrategy() {
    }

    public CustomBuildStrategy(String buildAPIVersion, List<EnvVar> env, Boolean exposeDockerSocket, Boolean forcePull, io.fabric8.kubernetes.api.model.ObjectReference from, io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret, List<SecretSpec> secrets) {
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
    public io.fabric8.kubernetes.api.model.ObjectReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(io.fabric8.kubernetes.api.model.ObjectReference from) {
        this.from = from;
    }

    @JsonProperty("pullSecret")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    @JsonProperty("pullSecret")
    public void setPullSecret(io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    @JsonProperty("secrets")
    public List<SecretSpec> getSecrets() {
        return secrets;
    }

    @JsonProperty("secrets")
    public void setSecrets(List<SecretSpec> secrets) {
        this.secrets = secrets;
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
