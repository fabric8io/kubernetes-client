
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
    "command",
    "containerName",
    "env",
    "volumes"
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
public class ExecNewPodHook implements Editable<ExecNewPodHookBuilder> , KubernetesResource
{

    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> command = new ArrayList<>();
    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExecNewPodHook() {
    }

    public ExecNewPodHook(List<String> command, String containerName, List<EnvVar> env, List<String> volumes) {
        super();
        this.command = command;
        this.containerName = containerName;
        this.env = env;
        this.volumes = volumes;
    }

    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
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

    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public ExecNewPodHookBuilder edit() {
        return new ExecNewPodHookBuilder(this);
    }

    @JsonIgnore
    public ExecNewPodHookBuilder toBuilder() {
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
