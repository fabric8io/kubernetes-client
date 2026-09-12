
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
 * ExecNewPodHook is a hook implementation which runs a command in a new pod based on the specified container which is assumed to be part of the deployment template.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "command",
    "containerName",
    "env",
    "volumes"
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
public class ExecNewPodHook implements Editable<ExecNewPodHookBuilder>, KubernetesResource
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

    /**
     * command is the action command and its arguments.
     */
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCommand() {
        return command;
    }

    /**
     * command is the action command and its arguments.
     */
    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    /**
     * containerName is the name of a container in the deployment pod template whose container image will be used for the hook pod's container.
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * containerName is the name of a container in the deployment pod template whose container image will be used for the hook pod's container.
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * env is a set of environment variables to supply to the hook pod's container.
     */
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    /**
     * env is a set of environment variables to supply to the hook pod's container.
     */
    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    /**
     * volumes is a list of named volumes from the pod template which should be copied to the hook pod. Volumes names not found in pod spec are ignored. An empty list means no volumes will be copied.
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumes() {
        return volumes;
    }

    /**
     * volumes is a list of named volumes from the pod template which should be copied to the hook pod. Volumes names not found in pod spec are ignored. An empty list means no volumes will be copied.
     */
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
        if (!(o instanceof ExecNewPodHook)) {
            return false;
        }
        ExecNewPodHook other = (ExecNewPodHook) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$command = this.getCommand();
        Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) {
            return false;
        }
        Object this$containerName = this.getContainerName();
        Object other$containerName = other.getContainerName();
        if (this$containerName == null ? other$containerName != null : !this$containerName.equals(other$containerName)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$volumes = this.getVolumes();
        Object other$volumes = other.getVolumes();
        if (this$volumes == null ? other$volumes != null : !this$volumes.equals(other$volumes)) {
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
        return other instanceof ExecNewPodHook;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $command = this.getCommand();
        result = result * prime + ($command == null ? 43 : $command.hashCode());
        Object $containerName = this.getContainerName();
        result = result * prime + ($containerName == null ? 43 : $containerName.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExecNewPodHook(" + "command=" + this.getCommand() + ", containerName=" + this.getContainerName() + ", env=" + this.getEnv() + ", volumes=" + this.getVolumes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
