
package io.fabric8.tekton.pipeline.v1;

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
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.EnvFromSource;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.SecurityContext;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeDevice;
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
    "args",
    "command",
    "computeResources",
    "env",
    "envFrom",
    "image",
    "imagePullPolicy",
    "name",
    "onError",
    "script",
    "securityContext",
    "stderrConfig",
    "stdoutConfig",
    "timeout",
    "volumeDevices",
    "volumeMounts",
    "workingDir",
    "workspaces"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class Step implements KubernetesResource
{

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> args = new ArrayList<String>();
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> command = new ArrayList<String>();
    @JsonProperty("computeResources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements computeResources;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.EnvVar> env = new ArrayList<io.fabric8.kubernetes.api.model.EnvVar>();
    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvFromSource> envFrom = new ArrayList<EnvFromSource>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("onError")
    private String onError;
    @JsonProperty("script")
    private String script;
    @JsonProperty("securityContext")
    private SecurityContext securityContext;
    @JsonProperty("stderrConfig")
    private StepOutputConfig stderrConfig;
    @JsonProperty("stdoutConfig")
    private StepOutputConfig stdoutConfig;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonProperty("volumeDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeDevice> volumeDevices = new ArrayList<VolumeDevice>();
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.VolumeMount> volumeMounts = new ArrayList<io.fabric8.kubernetes.api.model.VolumeMount>();
    @JsonProperty("workingDir")
    private String workingDir;
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspaceUsage> workspaces = new ArrayList<WorkspaceUsage>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Step() {
    }

    public Step(List<String> args, List<String> command, io.fabric8.kubernetes.api.model.ResourceRequirements computeResources, List<io.fabric8.kubernetes.api.model.EnvVar> env, List<EnvFromSource> envFrom, String image, String imagePullPolicy, String name, String onError, String script, SecurityContext securityContext, StepOutputConfig stderrConfig, StepOutputConfig stdoutConfig, Duration timeout, List<VolumeDevice> volumeDevices, List<io.fabric8.kubernetes.api.model.VolumeMount> volumeMounts, String workingDir, List<WorkspaceUsage> workspaces) {
        super();
        this.args = args;
        this.command = command;
        this.computeResources = computeResources;
        this.env = env;
        this.envFrom = envFrom;
        this.image = image;
        this.imagePullPolicy = imagePullPolicy;
        this.name = name;
        this.onError = onError;
        this.script = script;
        this.securityContext = securityContext;
        this.stderrConfig = stderrConfig;
        this.stdoutConfig = stdoutConfig;
        this.timeout = timeout;
        this.volumeDevices = volumeDevices;
        this.volumeMounts = volumeMounts;
        this.workingDir = workingDir;
        this.workspaces = workspaces;
    }

    @JsonProperty("args")
    public List<String> getArgs() {
        return args;
    }

    @JsonProperty("args")
    public void setArgs(List<String> args) {
        this.args = args;
    }

    @JsonProperty("command")
    public List<String> getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    @JsonProperty("computeResources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getComputeResources() {
        return computeResources;
    }

    @JsonProperty("computeResources")
    public void setComputeResources(io.fabric8.kubernetes.api.model.ResourceRequirements computeResources) {
        this.computeResources = computeResources;
    }

    @JsonProperty("env")
    public List<io.fabric8.kubernetes.api.model.EnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<io.fabric8.kubernetes.api.model.EnvVar> env) {
        this.env = env;
    }

    @JsonProperty("envFrom")
    public List<EnvFromSource> getEnvFrom() {
        return envFrom;
    }

    @JsonProperty("envFrom")
    public void setEnvFrom(List<EnvFromSource> envFrom) {
        this.envFrom = envFrom;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("onError")
    public String getOnError() {
        return onError;
    }

    @JsonProperty("onError")
    public void setOnError(String onError) {
        this.onError = onError;
    }

    @JsonProperty("script")
    public String getScript() {
        return script;
    }

    @JsonProperty("script")
    public void setScript(String script) {
        this.script = script;
    }

    @JsonProperty("securityContext")
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @JsonProperty("stderrConfig")
    public StepOutputConfig getStderrConfig() {
        return stderrConfig;
    }

    @JsonProperty("stderrConfig")
    public void setStderrConfig(StepOutputConfig stderrConfig) {
        this.stderrConfig = stderrConfig;
    }

    @JsonProperty("stdoutConfig")
    public StepOutputConfig getStdoutConfig() {
        return stdoutConfig;
    }

    @JsonProperty("stdoutConfig")
    public void setStdoutConfig(StepOutputConfig stdoutConfig) {
        this.stdoutConfig = stdoutConfig;
    }

    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    @JsonProperty("volumeDevices")
    public List<VolumeDevice> getVolumeDevices() {
        return volumeDevices;
    }

    @JsonProperty("volumeDevices")
    public void setVolumeDevices(List<VolumeDevice> volumeDevices) {
        this.volumeDevices = volumeDevices;
    }

    @JsonProperty("volumeMounts")
    public List<io.fabric8.kubernetes.api.model.VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<io.fabric8.kubernetes.api.model.VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("workingDir")
    public String getWorkingDir() {
        return workingDir;
    }

    @JsonProperty("workingDir")
    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    @JsonProperty("workspaces")
    public List<WorkspaceUsage> getWorkspaces() {
        return workspaces;
    }

    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspaceUsage> workspaces) {
        this.workspaces = workspaces;
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
