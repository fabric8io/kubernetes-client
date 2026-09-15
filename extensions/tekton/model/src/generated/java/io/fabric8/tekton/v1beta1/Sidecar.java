
package io.fabric8.tekton.v1beta1;

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
import io.fabric8.kubernetes.api.model.EnvFromSource;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.Lifecycle;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Probe;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecurityContext;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeDevice;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "args",
    "command",
    "env",
    "envFrom",
    "image",
    "imagePullPolicy",
    "lifecycle",
    "livenessProbe",
    "name",
    "ports",
    "readinessProbe",
    "resources",
    "restartPolicy",
    "script",
    "securityContext",
    "startupProbe",
    "stdin",
    "stdinOnce",
    "terminationMessagePath",
    "terminationMessagePolicy",
    "tty",
    "volumeDevices",
    "volumeMounts",
    "workingDir",
    "workspaces"
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
public class Sidecar implements Editable<SidecarBuilder>, KubernetesResource
{

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> args = new ArrayList<>();
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> command = new ArrayList<>();
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvFromSource> envFrom = new ArrayList<>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("lifecycle")
    private Lifecycle lifecycle;
    @JsonProperty("livenessProbe")
    private Probe livenessProbe;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerPort> ports = new ArrayList<>();
    @JsonProperty("readinessProbe")
    private Probe readinessProbe;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonProperty("script")
    private String script;
    @JsonProperty("securityContext")
    private SecurityContext securityContext;
    @JsonProperty("startupProbe")
    private Probe startupProbe;
    @JsonProperty("stdin")
    private Boolean stdin;
    @JsonProperty("stdinOnce")
    private Boolean stdinOnce;
    @JsonProperty("terminationMessagePath")
    private String terminationMessagePath;
    @JsonProperty("terminationMessagePolicy")
    private String terminationMessagePolicy;
    @JsonProperty("tty")
    private Boolean tty;
    @JsonProperty("volumeDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeDevice> volumeDevices = new ArrayList<>();
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMount> volumeMounts = new ArrayList<>();
    @JsonProperty("workingDir")
    private String workingDir;
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspaceUsage> workspaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Sidecar() {
    }

    public Sidecar(List<String> args, List<String> command, List<EnvVar> env, List<EnvFromSource> envFrom, String image, String imagePullPolicy, Lifecycle lifecycle, Probe livenessProbe, String name, List<ContainerPort> ports, Probe readinessProbe, ResourceRequirements resources, String restartPolicy, String script, SecurityContext securityContext, Probe startupProbe, Boolean stdin, Boolean stdinOnce, String terminationMessagePath, String terminationMessagePolicy, Boolean tty, List<VolumeDevice> volumeDevices, List<VolumeMount> volumeMounts, String workingDir, List<WorkspaceUsage> workspaces) {
        super();
        this.args = args;
        this.command = command;
        this.env = env;
        this.envFrom = envFrom;
        this.image = image;
        this.imagePullPolicy = imagePullPolicy;
        this.lifecycle = lifecycle;
        this.livenessProbe = livenessProbe;
        this.name = name;
        this.ports = ports;
        this.readinessProbe = readinessProbe;
        this.resources = resources;
        this.restartPolicy = restartPolicy;
        this.script = script;
        this.securityContext = securityContext;
        this.startupProbe = startupProbe;
        this.stdin = stdin;
        this.stdinOnce = stdinOnce;
        this.terminationMessagePath = terminationMessagePath;
        this.terminationMessagePolicy = terminationMessagePolicy;
        this.tty = tty;
        this.volumeDevices = volumeDevices;
        this.volumeMounts = volumeMounts;
        this.workingDir = workingDir;
        this.workspaces = workspaces;
    }

    /**
     * Arguments to the entrypoint. The image's CMD is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
     */
    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getArgs() {
        return args;
    }

    /**
     * Arguments to the entrypoint. The image's CMD is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
     */
    @JsonProperty("args")
    public void setArgs(List<String> args) {
        this.args = args;
    }

    /**
     * Entrypoint array. Not executed within a shell. The image's ENTRYPOINT is used if this is not provided. Variable references $(VAR_NAME) are expanded using the Sidecar's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
     */
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCommand() {
        return command;
    }

    /**
     * Entrypoint array. Not executed within a shell. The image's ENTRYPOINT is used if this is not provided. Variable references $(VAR_NAME) are expanded using the Sidecar's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
     */
    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    /**
     * List of environment variables to set in the Sidecar. Cannot be updated.
     */
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    /**
     * List of environment variables to set in the Sidecar. Cannot be updated.
     */
    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    /**
     * List of sources to populate environment variables in the Sidecar. The keys defined within a source must be a C_IDENTIFIER. All invalid keys will be reported as an event when the Sidecar is starting. When a key exists in multiple sources, the value associated with the last source will take precedence. Values defined by an Env with a duplicate key will take precedence. Cannot be updated.
     */
    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvFromSource> getEnvFrom() {
        return envFrom;
    }

    /**
     * List of sources to populate environment variables in the Sidecar. The keys defined within a source must be a C_IDENTIFIER. All invalid keys will be reported as an event when the Sidecar is starting. When a key exists in multiple sources, the value associated with the last source will take precedence. Values defined by an Env with a duplicate key will take precedence. Cannot be updated.
     */
    @JsonProperty("envFrom")
    public void setEnvFrom(List<EnvFromSource> envFrom) {
        this.envFrom = envFrom;
    }

    /**
     * Image name to be used by the Sidecar. More info: https://kubernetes.io/docs/concepts/containers/images
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Image name to be used by the Sidecar. More info: https://kubernetes.io/docs/concepts/containers/images
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Image pull policy. One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise. Cannot be updated. More info: https://kubernetes.io/docs/concepts/containers/images#updating-images
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * Image pull policy. One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise. Cannot be updated. More info: https://kubernetes.io/docs/concepts/containers/images#updating-images
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("lifecycle")
    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("lifecycle")
    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("livenessProbe")
    public Probe getLivenessProbe() {
        return livenessProbe;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("livenessProbe")
    public void setLivenessProbe(Probe livenessProbe) {
        this.livenessProbe = livenessProbe;
    }

    /**
     * Name of the Sidecar specified as a DNS_LABEL. Each Sidecar in a Task must have a unique name (DNS_LABEL). Cannot be updated.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the Sidecar specified as a DNS_LABEL. Each Sidecar in a Task must have a unique name (DNS_LABEL). Cannot be updated.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * List of ports to expose from the Sidecar. Exposing a port here gives the system additional information about the network connections a container uses, but is primarily informational. Not specifying a port here DOES NOT prevent that port from being exposed. Any port which is listening on the default "0.0.0.0" address inside a container will be accessible from the network. Cannot be updated.
     */
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerPort> getPorts() {
        return ports;
    }

    /**
     * List of ports to expose from the Sidecar. Exposing a port here gives the system additional information about the network connections a container uses, but is primarily informational. Not specifying a port here DOES NOT prevent that port from being exposed. Any port which is listening on the default "0.0.0.0" address inside a container will be accessible from the network. Cannot be updated.
     */
    @JsonProperty("ports")
    public void setPorts(List<ContainerPort> ports) {
        this.ports = ports;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("readinessProbe")
    public Probe getReadinessProbe() {
        return readinessProbe;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("readinessProbe")
    public void setReadinessProbe(Probe readinessProbe) {
        this.readinessProbe = readinessProbe;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * RestartPolicy refers to kubernetes RestartPolicy. It can only be set for an initContainer and must have it's policy set to "Always". It is currently left optional to help support Kubernetes versions prior to 1.29 when this feature was introduced.
     */
    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    /**
     * RestartPolicy refers to kubernetes RestartPolicy. It can only be set for an initContainer and must have it's policy set to "Always". It is currently left optional to help support Kubernetes versions prior to 1.29 when this feature was introduced.
     */
    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    /**
     * Script is the contents of an executable file to execute.<br><p> <br><p> If Script is not empty, the Step cannot have an Command or Args.
     */
    @JsonProperty("script")
    public String getScript() {
        return script;
    }

    /**
     * Script is the contents of an executable file to execute.<br><p> <br><p> If Script is not empty, the Step cannot have an Command or Args.
     */
    @JsonProperty("script")
    public void setScript(String script) {
        this.script = script;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("securityContext")
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("securityContext")
    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("startupProbe")
    public Probe getStartupProbe() {
        return startupProbe;
    }

    /**
     * Sidecar has nearly the same data structure as Step but does not have the ability to timeout.
     */
    @JsonProperty("startupProbe")
    public void setStartupProbe(Probe startupProbe) {
        this.startupProbe = startupProbe;
    }

    /**
     * Whether this Sidecar should allocate a buffer for stdin in the container runtime. If this is not set, reads from stdin in the Sidecar will always result in EOF. Default is false.
     */
    @JsonProperty("stdin")
    public Boolean getStdin() {
        return stdin;
    }

    /**
     * Whether this Sidecar should allocate a buffer for stdin in the container runtime. If this is not set, reads from stdin in the Sidecar will always result in EOF. Default is false.
     */
    @JsonProperty("stdin")
    public void setStdin(Boolean stdin) {
        this.stdin = stdin;
    }

    /**
     * Whether the container runtime should close the stdin channel after it has been opened by a single attach. When stdin is true the stdin stream will remain open across multiple attach sessions. If stdinOnce is set to true, stdin is opened on Sidecar start, is empty until the first client attaches to stdin, and then remains open and accepts data until the client disconnects, at which time stdin is closed and remains closed until the Sidecar is restarted. If this flag is false, a container processes that reads from stdin will never receive an EOF. Default is false
     */
    @JsonProperty("stdinOnce")
    public Boolean getStdinOnce() {
        return stdinOnce;
    }

    /**
     * Whether the container runtime should close the stdin channel after it has been opened by a single attach. When stdin is true the stdin stream will remain open across multiple attach sessions. If stdinOnce is set to true, stdin is opened on Sidecar start, is empty until the first client attaches to stdin, and then remains open and accepts data until the client disconnects, at which time stdin is closed and remains closed until the Sidecar is restarted. If this flag is false, a container processes that reads from stdin will never receive an EOF. Default is false
     */
    @JsonProperty("stdinOnce")
    public void setStdinOnce(Boolean stdinOnce) {
        this.stdinOnce = stdinOnce;
    }

    /**
     * Optional: Path at which the file to which the Sidecar's termination message will be written is mounted into the Sidecar's filesystem. Message written is intended to be brief final status, such as an assertion failure message. Will be truncated by the node if greater than 4096 bytes. The total message length across all containers will be limited to 12kb. Defaults to /dev/termination-log. Cannot be updated.
     */
    @JsonProperty("terminationMessagePath")
    public String getTerminationMessagePath() {
        return terminationMessagePath;
    }

    /**
     * Optional: Path at which the file to which the Sidecar's termination message will be written is mounted into the Sidecar's filesystem. Message written is intended to be brief final status, such as an assertion failure message. Will be truncated by the node if greater than 4096 bytes. The total message length across all containers will be limited to 12kb. Defaults to /dev/termination-log. Cannot be updated.
     */
    @JsonProperty("terminationMessagePath")
    public void setTerminationMessagePath(String terminationMessagePath) {
        this.terminationMessagePath = terminationMessagePath;
    }

    /**
     * Indicate how the termination message should be populated. File will use the contents of terminationMessagePath to populate the Sidecar status message on both success and failure. FallbackToLogsOnError will use the last chunk of Sidecar log output if the termination message file is empty and the Sidecar exited with an error. The log output is limited to 2048 bytes or 80 lines, whichever is smaller. Defaults to File. Cannot be updated.
     */
    @JsonProperty("terminationMessagePolicy")
    public String getTerminationMessagePolicy() {
        return terminationMessagePolicy;
    }

    /**
     * Indicate how the termination message should be populated. File will use the contents of terminationMessagePath to populate the Sidecar status message on both success and failure. FallbackToLogsOnError will use the last chunk of Sidecar log output if the termination message file is empty and the Sidecar exited with an error. The log output is limited to 2048 bytes or 80 lines, whichever is smaller. Defaults to File. Cannot be updated.
     */
    @JsonProperty("terminationMessagePolicy")
    public void setTerminationMessagePolicy(String terminationMessagePolicy) {
        this.terminationMessagePolicy = terminationMessagePolicy;
    }

    /**
     * Whether this Sidecar should allocate a TTY for itself, also requires 'stdin' to be true. Default is false.
     */
    @JsonProperty("tty")
    public Boolean getTty() {
        return tty;
    }

    /**
     * Whether this Sidecar should allocate a TTY for itself, also requires 'stdin' to be true. Default is false.
     */
    @JsonProperty("tty")
    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    /**
     * volumeDevices is the list of block devices to be used by the Sidecar.
     */
    @JsonProperty("volumeDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeDevice> getVolumeDevices() {
        return volumeDevices;
    }

    /**
     * volumeDevices is the list of block devices to be used by the Sidecar.
     */
    @JsonProperty("volumeDevices")
    public void setVolumeDevices(List<VolumeDevice> volumeDevices) {
        this.volumeDevices = volumeDevices;
    }

    /**
     * Volumes to mount into the Sidecar's filesystem. Cannot be updated.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * Volumes to mount into the Sidecar's filesystem. Cannot be updated.
     */
    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    /**
     * Sidecar's working directory. If not specified, the container runtime's default will be used, which might be configured in the container image. Cannot be updated.
     */
    @JsonProperty("workingDir")
    public String getWorkingDir() {
        return workingDir;
    }

    /**
     * Sidecar's working directory. If not specified, the container runtime's default will be used, which might be configured in the container image. Cannot be updated.
     */
    @JsonProperty("workingDir")
    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    /**
     * This is an alpha field. You must set the "enable-api-fields" feature flag to "alpha" for this field to be supported.<br><p> <br><p> Workspaces is a list of workspaces from the Task that this Sidecar wants exclusive access to. Adding a workspace to this list means that any other Step or Sidecar that does not also request this Workspace will not have access to it.
     */
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkspaceUsage> getWorkspaces() {
        return workspaces;
    }

    /**
     * This is an alpha field. You must set the "enable-api-fields" feature flag to "alpha" for this field to be supported.<br><p> <br><p> Workspaces is a list of workspaces from the Task that this Sidecar wants exclusive access to. Adding a workspace to this list means that any other Step or Sidecar that does not also request this Workspace will not have access to it.
     */
    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspaceUsage> workspaces) {
        this.workspaces = workspaces;
    }

    @JsonIgnore
    public SidecarBuilder edit() {
        return new SidecarBuilder(this);
    }

    @JsonIgnore
    public SidecarBuilder toBuilder() {
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
        if (!(o instanceof Sidecar)) {
            return false;
        }
        Sidecar other = (Sidecar) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$args = this.getArgs();
        Object other$args = other.getArgs();
        if (this$args == null ? other$args != null : !this$args.equals(other$args)) {
            return false;
        }
        Object this$command = this.getCommand();
        Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$envFrom = this.getEnvFrom();
        Object other$envFrom = other.getEnvFrom();
        if (this$envFrom == null ? other$envFrom != null : !this$envFrom.equals(other$envFrom)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$imagePullPolicy = this.getImagePullPolicy();
        Object other$imagePullPolicy = other.getImagePullPolicy();
        if (this$imagePullPolicy == null ? other$imagePullPolicy != null : !this$imagePullPolicy.equals(other$imagePullPolicy)) {
            return false;
        }
        Object this$lifecycle = this.getLifecycle();
        Object other$lifecycle = other.getLifecycle();
        if (this$lifecycle == null ? other$lifecycle != null : !this$lifecycle.equals(other$lifecycle)) {
            return false;
        }
        Object this$livenessProbe = this.getLivenessProbe();
        Object other$livenessProbe = other.getLivenessProbe();
        if (this$livenessProbe == null ? other$livenessProbe != null : !this$livenessProbe.equals(other$livenessProbe)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$ports = this.getPorts();
        Object other$ports = other.getPorts();
        if (this$ports == null ? other$ports != null : !this$ports.equals(other$ports)) {
            return false;
        }
        Object this$readinessProbe = this.getReadinessProbe();
        Object other$readinessProbe = other.getReadinessProbe();
        if (this$readinessProbe == null ? other$readinessProbe != null : !this$readinessProbe.equals(other$readinessProbe)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$restartPolicy = this.getRestartPolicy();
        Object other$restartPolicy = other.getRestartPolicy();
        if (this$restartPolicy == null ? other$restartPolicy != null : !this$restartPolicy.equals(other$restartPolicy)) {
            return false;
        }
        Object this$script = this.getScript();
        Object other$script = other.getScript();
        if (this$script == null ? other$script != null : !this$script.equals(other$script)) {
            return false;
        }
        Object this$securityContext = this.getSecurityContext();
        Object other$securityContext = other.getSecurityContext();
        if (this$securityContext == null ? other$securityContext != null : !this$securityContext.equals(other$securityContext)) {
            return false;
        }
        Object this$startupProbe = this.getStartupProbe();
        Object other$startupProbe = other.getStartupProbe();
        if (this$startupProbe == null ? other$startupProbe != null : !this$startupProbe.equals(other$startupProbe)) {
            return false;
        }
        Object this$stdin = this.getStdin();
        Object other$stdin = other.getStdin();
        if (this$stdin == null ? other$stdin != null : !this$stdin.equals(other$stdin)) {
            return false;
        }
        Object this$stdinOnce = this.getStdinOnce();
        Object other$stdinOnce = other.getStdinOnce();
        if (this$stdinOnce == null ? other$stdinOnce != null : !this$stdinOnce.equals(other$stdinOnce)) {
            return false;
        }
        Object this$terminationMessagePath = this.getTerminationMessagePath();
        Object other$terminationMessagePath = other.getTerminationMessagePath();
        if (this$terminationMessagePath == null ? other$terminationMessagePath != null : !this$terminationMessagePath.equals(other$terminationMessagePath)) {
            return false;
        }
        Object this$terminationMessagePolicy = this.getTerminationMessagePolicy();
        Object other$terminationMessagePolicy = other.getTerminationMessagePolicy();
        if (this$terminationMessagePolicy == null ? other$terminationMessagePolicy != null : !this$terminationMessagePolicy.equals(other$terminationMessagePolicy)) {
            return false;
        }
        Object this$tty = this.getTty();
        Object other$tty = other.getTty();
        if (this$tty == null ? other$tty != null : !this$tty.equals(other$tty)) {
            return false;
        }
        Object this$volumeDevices = this.getVolumeDevices();
        Object other$volumeDevices = other.getVolumeDevices();
        if (this$volumeDevices == null ? other$volumeDevices != null : !this$volumeDevices.equals(other$volumeDevices)) {
            return false;
        }
        Object this$volumeMounts = this.getVolumeMounts();
        Object other$volumeMounts = other.getVolumeMounts();
        if (this$volumeMounts == null ? other$volumeMounts != null : !this$volumeMounts.equals(other$volumeMounts)) {
            return false;
        }
        Object this$workingDir = this.getWorkingDir();
        Object other$workingDir = other.getWorkingDir();
        if (this$workingDir == null ? other$workingDir != null : !this$workingDir.equals(other$workingDir)) {
            return false;
        }
        Object this$workspaces = this.getWorkspaces();
        Object other$workspaces = other.getWorkspaces();
        if (this$workspaces == null ? other$workspaces != null : !this$workspaces.equals(other$workspaces)) {
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
        return other instanceof Sidecar;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $args = this.getArgs();
        result = result * prime + ($args == null ? 43 : $args.hashCode());
        Object $command = this.getCommand();
        result = result * prime + ($command == null ? 43 : $command.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $envFrom = this.getEnvFrom();
        result = result * prime + ($envFrom == null ? 43 : $envFrom.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $lifecycle = this.getLifecycle();
        result = result * prime + ($lifecycle == null ? 43 : $lifecycle.hashCode());
        Object $livenessProbe = this.getLivenessProbe();
        result = result * prime + ($livenessProbe == null ? 43 : $livenessProbe.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $ports = this.getPorts();
        result = result * prime + ($ports == null ? 43 : $ports.hashCode());
        Object $readinessProbe = this.getReadinessProbe();
        result = result * prime + ($readinessProbe == null ? 43 : $readinessProbe.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $restartPolicy = this.getRestartPolicy();
        result = result * prime + ($restartPolicy == null ? 43 : $restartPolicy.hashCode());
        Object $script = this.getScript();
        result = result * prime + ($script == null ? 43 : $script.hashCode());
        Object $securityContext = this.getSecurityContext();
        result = result * prime + ($securityContext == null ? 43 : $securityContext.hashCode());
        Object $startupProbe = this.getStartupProbe();
        result = result * prime + ($startupProbe == null ? 43 : $startupProbe.hashCode());
        Object $stdin = this.getStdin();
        result = result * prime + ($stdin == null ? 43 : $stdin.hashCode());
        Object $stdinOnce = this.getStdinOnce();
        result = result * prime + ($stdinOnce == null ? 43 : $stdinOnce.hashCode());
        Object $terminationMessagePath = this.getTerminationMessagePath();
        result = result * prime + ($terminationMessagePath == null ? 43 : $terminationMessagePath.hashCode());
        Object $terminationMessagePolicy = this.getTerminationMessagePolicy();
        result = result * prime + ($terminationMessagePolicy == null ? 43 : $terminationMessagePolicy.hashCode());
        Object $tty = this.getTty();
        result = result * prime + ($tty == null ? 43 : $tty.hashCode());
        Object $volumeDevices = this.getVolumeDevices();
        result = result * prime + ($volumeDevices == null ? 43 : $volumeDevices.hashCode());
        Object $volumeMounts = this.getVolumeMounts();
        result = result * prime + ($volumeMounts == null ? 43 : $volumeMounts.hashCode());
        Object $workingDir = this.getWorkingDir();
        result = result * prime + ($workingDir == null ? 43 : $workingDir.hashCode());
        Object $workspaces = this.getWorkspaces();
        result = result * prime + ($workspaces == null ? 43 : $workspaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Sidecar(" + "args=" + this.getArgs() + ", command=" + this.getCommand() + ", env=" + this.getEnv() + ", envFrom=" + this.getEnvFrom() + ", image=" + this.getImage() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", lifecycle=" + this.getLifecycle() + ", livenessProbe=" + this.getLivenessProbe() + ", name=" + this.getName() + ", ports=" + this.getPorts() + ", readinessProbe=" + this.getReadinessProbe() + ", resources=" + this.getResources() + ", restartPolicy=" + this.getRestartPolicy() + ", script=" + this.getScript() + ", securityContext=" + this.getSecurityContext() + ", startupProbe=" + this.getStartupProbe() + ", stdin=" + this.getStdin() + ", stdinOnce=" + this.getStdinOnce() + ", terminationMessagePath=" + this.getTerminationMessagePath() + ", terminationMessagePolicy=" + this.getTerminationMessagePolicy() + ", tty=" + this.getTty() + ", volumeDevices=" + this.getVolumeDevices() + ", volumeMounts=" + this.getVolumeMounts() + ", workingDir=" + this.getWorkingDir() + ", workspaces=" + this.getWorkspaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
