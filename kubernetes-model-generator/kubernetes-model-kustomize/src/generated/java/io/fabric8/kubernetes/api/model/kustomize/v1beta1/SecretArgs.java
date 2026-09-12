
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
    "options",
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SecretArgs implements Editable<SecretArgsBuilder>, KubernetesResource
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
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecretArgs() {
    }

    public SecretArgs(String behavior, String env, List<String> envs, List<String> files, List<String> literals, String name, String namespace, GeneratorOptions options, String type) {
        super();
        this.behavior = behavior;
        this.env = env;
        this.envs = envs;
        this.files = files;
        this.literals = literals;
        this.name = name;
        this.namespace = namespace;
        this.options = options;
        this.type = type;
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

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public SecretArgsBuilder edit() {
        return new SecretArgsBuilder(this);
    }

    @JsonIgnore
    public SecretArgsBuilder toBuilder() {
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
        if (!(o instanceof SecretArgs)) {
            return false;
        }
        SecretArgs other = (SecretArgs) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$behavior = this.getBehavior();
        Object other$behavior = other.getBehavior();
        if (this$behavior == null ? other$behavior != null : !this$behavior.equals(other$behavior)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$envs = this.getEnvs();
        Object other$envs = other.getEnvs();
        if (this$envs == null ? other$envs != null : !this$envs.equals(other$envs)) {
            return false;
        }
        Object this$files = this.getFiles();
        Object other$files = other.getFiles();
        if (this$files == null ? other$files != null : !this$files.equals(other$files)) {
            return false;
        }
        Object this$literals = this.getLiterals();
        Object other$literals = other.getLiterals();
        if (this$literals == null ? other$literals != null : !this$literals.equals(other$literals)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$options = this.getOptions();
        Object other$options = other.getOptions();
        if (this$options == null ? other$options != null : !this$options.equals(other$options)) {
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
        return other instanceof SecretArgs;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $behavior = this.getBehavior();
        result = result * prime + ($behavior == null ? 43 : $behavior.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $envs = this.getEnvs();
        result = result * prime + ($envs == null ? 43 : $envs.hashCode());
        Object $files = this.getFiles();
        result = result * prime + ($files == null ? 43 : $files.hashCode());
        Object $literals = this.getLiterals();
        result = result * prime + ($literals == null ? 43 : $literals.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $options = this.getOptions();
        result = result * prime + ($options == null ? 43 : $options.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecretArgs(" + "behavior=" + this.getBehavior() + ", env=" + this.getEnv() + ", envs=" + this.getEnvs() + ", files=" + this.getFiles() + ", literals=" + this.getLiterals() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", options=" + this.getOptions() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
