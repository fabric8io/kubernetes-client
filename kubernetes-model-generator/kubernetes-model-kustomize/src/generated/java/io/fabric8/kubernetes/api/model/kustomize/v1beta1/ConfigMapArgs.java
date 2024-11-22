
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
    "behavior",
    "env",
    "envs",
    "files",
    "literals",
    "name",
    "namespace",
    "options"
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
public class ConfigMapArgs implements Editable<ConfigMapArgsBuilder> , KubernetesResource
{

    @JsonProperty("behavior")
    private String behavior;
    @JsonProperty("env")
    private String env;
    @JsonProperty("envs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> envs = new ArrayList<>();
    @JsonProperty("files")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> files = new ArrayList<>();
    @JsonProperty("literals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> literals = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("options")
    private GeneratorOptions options;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConfigMapArgs() {
    }

    public ConfigMapArgs(String behavior, String env, List<String> envs, List<String> files, List<String> literals, String name, String namespace, GeneratorOptions options) {
        super();
        this.behavior = behavior;
        this.env = env;
        this.envs = envs;
        this.files = files;
        this.literals = literals;
        this.name = name;
        this.namespace = namespace;
        this.options = options;
    }

    @JsonProperty("behavior")
    public String getBehavior() {
        return behavior;
    }

    @JsonProperty("behavior")
    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    @JsonProperty("env")
    public String getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(String env) {
        this.env = env;
    }

    @JsonProperty("envs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnvs() {
        return envs;
    }

    @JsonProperty("envs")
    public void setEnvs(List<String> envs) {
        this.envs = envs;
    }

    @JsonProperty("files")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFiles() {
        return files;
    }

    @JsonProperty("files")
    public void setFiles(List<String> files) {
        this.files = files;
    }

    @JsonProperty("literals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLiterals() {
        return literals;
    }

    @JsonProperty("literals")
    public void setLiterals(List<String> literals) {
        this.literals = literals;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("options")
    public GeneratorOptions getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(GeneratorOptions options) {
        this.options = options;
    }

    @JsonIgnore
    public ConfigMapArgsBuilder edit() {
        return new ConfigMapArgsBuilder(this);
    }

    @JsonIgnore
    public ConfigMapArgsBuilder toBuilder() {
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
