
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
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
    "resizePolicy",
    "resources",
    "restartPolicy",
    "restartPolicyRules",
    "securityContext",
    "startupProbe",
    "stdin",
    "stdinOnce",
    "targetContainerName",
    "terminationMessagePath",
    "terminationMessagePolicy",
    "tty",
    "volumeDevices",
    "volumeMounts",
    "workingDir"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EphemeralContainer implements Editable<EphemeralContainerBuilder>, KubernetesResource
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
    @JsonProperty("resizePolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerResizePolicy> resizePolicy = new ArrayList<>();
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonProperty("restartPolicyRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerRestartRule> restartPolicyRules = new ArrayList<>();
    @JsonProperty("securityContext")
    private SecurityContext securityContext;
    @JsonProperty("startupProbe")
    private Probe startupProbe;
    @JsonProperty("stdin")
    private Boolean stdin;
    @JsonProperty("stdinOnce")
    private Boolean stdinOnce;
    @JsonProperty("targetContainerName")
    private String targetContainerName;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EphemeralContainer() {
    }

    public EphemeralContainer(List<String> args, List<String> command, List<EnvVar> env, List<EnvFromSource> envFrom, String image, String imagePullPolicy, Lifecycle lifecycle, Probe livenessProbe, String name, List<ContainerPort> ports, Probe readinessProbe, List<ContainerResizePolicy> resizePolicy, ResourceRequirements resources, String restartPolicy, List<ContainerRestartRule> restartPolicyRules, SecurityContext securityContext, Probe startupProbe, Boolean stdin, Boolean stdinOnce, String targetContainerName, String terminationMessagePath, String terminationMessagePolicy, Boolean tty, List<VolumeDevice> volumeDevices, List<VolumeMount> volumeMounts, String workingDir) {
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
        this.resizePolicy = resizePolicy;
        this.resources = resources;
        this.restartPolicy = restartPolicy;
        this.restartPolicyRules = restartPolicyRules;
        this.securityContext = securityContext;
        this.startupProbe = startupProbe;
        this.stdin = stdin;
        this.stdinOnce = stdinOnce;
        this.targetContainerName = targetContainerName;
        this.terminationMessagePath = terminationMessagePath;
        this.terminationMessagePolicy = terminationMessagePolicy;
        this.tty = tty;
        this.volumeDevices = volumeDevices;
        this.volumeMounts = volumeMounts;
        this.workingDir = workingDir;
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
     * Entrypoint array. Not executed within a shell. The image's ENTRYPOINT is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
     */
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCommand() {
        return command;
    }

    /**
     * Entrypoint array. Not executed within a shell. The image's ENTRYPOINT is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
     */
    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    /**
     * List of environment variables to set in the container. Cannot be updated.
     */
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    /**
     * List of environment variables to set in the container. Cannot be updated.
     */
    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    /**
     * List of sources to populate environment variables in the container. The keys defined within a source may consist of any printable ASCII characters except '='. When a key exists in multiple sources, the value associated with the last source will take precedence. Values defined by an Env with a duplicate key will take precedence. Cannot be updated.
     */
    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvFromSource> getEnvFrom() {
        return envFrom;
    }

    /**
     * List of sources to populate environment variables in the container. The keys defined within a source may consist of any printable ASCII characters except '='. When a key exists in multiple sources, the value associated with the last source will take precedence. Values defined by an Env with a duplicate key will take precedence. Cannot be updated.
     */
    @JsonProperty("envFrom")
    public void setEnvFrom(List<EnvFromSource> envFrom) {
        this.envFrom = envFrom;
    }

    /**
     * Container image name. More info: https://kubernetes.io/docs/concepts/containers/images
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Container image name. More info: https://kubernetes.io/docs/concepts/containers/images
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
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("lifecycle")
    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("lifecycle")
    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("livenessProbe")
    public Probe getLivenessProbe() {
        return livenessProbe;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("livenessProbe")
    public void setLivenessProbe(Probe livenessProbe) {
        this.livenessProbe = livenessProbe;
    }

    /**
     * Name of the ephemeral container specified as a DNS_LABEL. This name must be unique among all containers, init containers and ephemeral containers.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the ephemeral container specified as a DNS_LABEL. This name must be unique among all containers, init containers and ephemeral containers.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ports are not allowed for ephemeral containers.
     */
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerPort> getPorts() {
        return ports;
    }

    /**
     * Ports are not allowed for ephemeral containers.
     */
    @JsonProperty("ports")
    public void setPorts(List<ContainerPort> ports) {
        this.ports = ports;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("readinessProbe")
    public Probe getReadinessProbe() {
        return readinessProbe;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("readinessProbe")
    public void setReadinessProbe(Probe readinessProbe) {
        this.readinessProbe = readinessProbe;
    }

    /**
     * Resources resize policy for the container.
     */
    @JsonProperty("resizePolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerResizePolicy> getResizePolicy() {
        return resizePolicy;
    }

    /**
     * Resources resize policy for the container.
     */
    @JsonProperty("resizePolicy")
    public void setResizePolicy(List<ContainerResizePolicy> resizePolicy) {
        this.resizePolicy = resizePolicy;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * Restart policy for the container to manage the restart behavior of each container within a pod. You cannot set this field on ephemeral containers.
     */
    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    /**
     * Restart policy for the container to manage the restart behavior of each container within a pod. You cannot set this field on ephemeral containers.
     */
    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    /**
     * Represents a list of rules to be checked to determine if the container should be restarted on exit. You cannot set this field on ephemeral containers.
     */
    @JsonProperty("restartPolicyRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerRestartRule> getRestartPolicyRules() {
        return restartPolicyRules;
    }

    /**
     * Represents a list of rules to be checked to determine if the container should be restarted on exit. You cannot set this field on ephemeral containers.
     */
    @JsonProperty("restartPolicyRules")
    public void setRestartPolicyRules(List<ContainerRestartRule> restartPolicyRules) {
        this.restartPolicyRules = restartPolicyRules;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("securityContext")
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("securityContext")
    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("startupProbe")
    public Probe getStartupProbe() {
        return startupProbe;
    }

    /**
     * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
     */
    @JsonProperty("startupProbe")
    public void setStartupProbe(Probe startupProbe) {
        this.startupProbe = startupProbe;
    }

    /**
     * Whether this container should allocate a buffer for stdin in the container runtime. If this is not set, reads from stdin in the container will always result in EOF. Default is false.
     */
    @JsonProperty("stdin")
    public Boolean getStdin() {
        return stdin;
    }

    /**
     * Whether this container should allocate a buffer for stdin in the container runtime. If this is not set, reads from stdin in the container will always result in EOF. Default is false.
     */
    @JsonProperty("stdin")
    public void setStdin(Boolean stdin) {
        this.stdin = stdin;
    }

    /**
     * Whether the container runtime should close the stdin channel after it has been opened by a single attach. When stdin is true the stdin stream will remain open across multiple attach sessions. If stdinOnce is set to true, stdin is opened on container start, is empty until the first client attaches to stdin, and then remains open and accepts data until the client disconnects, at which time stdin is closed and remains closed until the container is restarted. If this flag is false, a container processes that reads from stdin will never receive an EOF. Default is false
     */
    @JsonProperty("stdinOnce")
    public Boolean getStdinOnce() {
        return stdinOnce;
    }

    /**
     * Whether the container runtime should close the stdin channel after it has been opened by a single attach. When stdin is true the stdin stream will remain open across multiple attach sessions. If stdinOnce is set to true, stdin is opened on container start, is empty until the first client attaches to stdin, and then remains open and accepts data until the client disconnects, at which time stdin is closed and remains closed until the container is restarted. If this flag is false, a container processes that reads from stdin will never receive an EOF. Default is false
     */
    @JsonProperty("stdinOnce")
    public void setStdinOnce(Boolean stdinOnce) {
        this.stdinOnce = stdinOnce;
    }

    /**
     * If set, the name of the container from PodSpec that this ephemeral container targets. The ephemeral container will be run in the namespaces (IPC, PID, etc) of this container. If not set then the ephemeral container uses the namespaces configured in the Pod spec.<br><p> <br><p> The container runtime must implement support for this feature. If the runtime does not support namespace targeting then the result of setting this field is undefined.
     */
    @JsonProperty("targetContainerName")
    public String getTargetContainerName() {
        return targetContainerName;
    }

    /**
     * If set, the name of the container from PodSpec that this ephemeral container targets. The ephemeral container will be run in the namespaces (IPC, PID, etc) of this container. If not set then the ephemeral container uses the namespaces configured in the Pod spec.<br><p> <br><p> The container runtime must implement support for this feature. If the runtime does not support namespace targeting then the result of setting this field is undefined.
     */
    @JsonProperty("targetContainerName")
    public void setTargetContainerName(String targetContainerName) {
        this.targetContainerName = targetContainerName;
    }

    /**
     * Optional: Path at which the file to which the container's termination message will be written is mounted into the container's filesystem. Message written is intended to be brief final status, such as an assertion failure message. Will be truncated by the node if greater than 4096 bytes. The total message length across all containers will be limited to 12kb. Defaults to /dev/termination-log. Cannot be updated.
     */
    @JsonProperty("terminationMessagePath")
    public String getTerminationMessagePath() {
        return terminationMessagePath;
    }

    /**
     * Optional: Path at which the file to which the container's termination message will be written is mounted into the container's filesystem. Message written is intended to be brief final status, such as an assertion failure message. Will be truncated by the node if greater than 4096 bytes. The total message length across all containers will be limited to 12kb. Defaults to /dev/termination-log. Cannot be updated.
     */
    @JsonProperty("terminationMessagePath")
    public void setTerminationMessagePath(String terminationMessagePath) {
        this.terminationMessagePath = terminationMessagePath;
    }

    /**
     * Indicate how the termination message should be populated. File will use the contents of terminationMessagePath to populate the container status message on both success and failure. FallbackToLogsOnError will use the last chunk of container log output if the termination message file is empty and the container exited with an error. The log output is limited to 2048 bytes or 80 lines, whichever is smaller. Defaults to File. Cannot be updated.
     */
    @JsonProperty("terminationMessagePolicy")
    public String getTerminationMessagePolicy() {
        return terminationMessagePolicy;
    }

    /**
     * Indicate how the termination message should be populated. File will use the contents of terminationMessagePath to populate the container status message on both success and failure. FallbackToLogsOnError will use the last chunk of container log output if the termination message file is empty and the container exited with an error. The log output is limited to 2048 bytes or 80 lines, whichever is smaller. Defaults to File. Cannot be updated.
     */
    @JsonProperty("terminationMessagePolicy")
    public void setTerminationMessagePolicy(String terminationMessagePolicy) {
        this.terminationMessagePolicy = terminationMessagePolicy;
    }

    /**
     * Whether this container should allocate a TTY for itself, also requires 'stdin' to be true. Default is false.
     */
    @JsonProperty("tty")
    public Boolean getTty() {
        return tty;
    }

    /**
     * Whether this container should allocate a TTY for itself, also requires 'stdin' to be true. Default is false.
     */
    @JsonProperty("tty")
    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    /**
     * volumeDevices is the list of block devices to be used by the container.
     */
    @JsonProperty("volumeDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeDevice> getVolumeDevices() {
        return volumeDevices;
    }

    /**
     * volumeDevices is the list of block devices to be used by the container.
     */
    @JsonProperty("volumeDevices")
    public void setVolumeDevices(List<VolumeDevice> volumeDevices) {
        this.volumeDevices = volumeDevices;
    }

    /**
     * Pod volumes to mount into the container's filesystem. Subpath mounts are not allowed for ephemeral containers. Cannot be updated.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * Pod volumes to mount into the container's filesystem. Subpath mounts are not allowed for ephemeral containers. Cannot be updated.
     */
    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    /**
     * Container's working directory. If not specified, the container runtime's default will be used, which might be configured in the container image. Cannot be updated.
     */
    @JsonProperty("workingDir")
    public String getWorkingDir() {
        return workingDir;
    }

    /**
     * Container's working directory. If not specified, the container runtime's default will be used, which might be configured in the container image. Cannot be updated.
     */
    @JsonProperty("workingDir")
    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    @JsonIgnore
    public EphemeralContainerBuilder edit() {
        return new EphemeralContainerBuilder(this);
    }

    @JsonIgnore
    public EphemeralContainerBuilder toBuilder() {
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
        if (!(o instanceof EphemeralContainer)) {
            return false;
        }
        EphemeralContainer other = (EphemeralContainer) o;
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
        Object this$resizePolicy = this.getResizePolicy();
        Object other$resizePolicy = other.getResizePolicy();
        if (this$resizePolicy == null ? other$resizePolicy != null : !this$resizePolicy.equals(other$resizePolicy)) {
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
        Object this$restartPolicyRules = this.getRestartPolicyRules();
        Object other$restartPolicyRules = other.getRestartPolicyRules();
        if (this$restartPolicyRules == null ? other$restartPolicyRules != null : !this$restartPolicyRules.equals(other$restartPolicyRules)) {
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
        Object this$targetContainerName = this.getTargetContainerName();
        Object other$targetContainerName = other.getTargetContainerName();
        if (this$targetContainerName == null ? other$targetContainerName != null : !this$targetContainerName.equals(other$targetContainerName)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof EphemeralContainer;
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
        Object $resizePolicy = this.getResizePolicy();
        result = result * prime + ($resizePolicy == null ? 43 : $resizePolicy.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $restartPolicy = this.getRestartPolicy();
        result = result * prime + ($restartPolicy == null ? 43 : $restartPolicy.hashCode());
        Object $restartPolicyRules = this.getRestartPolicyRules();
        result = result * prime + ($restartPolicyRules == null ? 43 : $restartPolicyRules.hashCode());
        Object $securityContext = this.getSecurityContext();
        result = result * prime + ($securityContext == null ? 43 : $securityContext.hashCode());
        Object $startupProbe = this.getStartupProbe();
        result = result * prime + ($startupProbe == null ? 43 : $startupProbe.hashCode());
        Object $stdin = this.getStdin();
        result = result * prime + ($stdin == null ? 43 : $stdin.hashCode());
        Object $stdinOnce = this.getStdinOnce();
        result = result * prime + ($stdinOnce == null ? 43 : $stdinOnce.hashCode());
        Object $targetContainerName = this.getTargetContainerName();
        result = result * prime + ($targetContainerName == null ? 43 : $targetContainerName.hashCode());
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
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EphemeralContainer(" + "args=" + this.getArgs() + ", command=" + this.getCommand() + ", env=" + this.getEnv() + ", envFrom=" + this.getEnvFrom() + ", image=" + this.getImage() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", lifecycle=" + this.getLifecycle() + ", livenessProbe=" + this.getLivenessProbe() + ", name=" + this.getName() + ", ports=" + this.getPorts() + ", readinessProbe=" + this.getReadinessProbe() + ", resizePolicy=" + this.getResizePolicy() + ", resources=" + this.getResources() + ", restartPolicy=" + this.getRestartPolicy() + ", restartPolicyRules=" + this.getRestartPolicyRules() + ", securityContext=" + this.getSecurityContext() + ", startupProbe=" + this.getStartupProbe() + ", stdin=" + this.getStdin() + ", stdinOnce=" + this.getStdinOnce() + ", targetContainerName=" + this.getTargetContainerName() + ", terminationMessagePath=" + this.getTerminationMessagePath() + ", terminationMessagePolicy=" + this.getTerminationMessagePolicy() + ", tty=" + this.getTty() + ", volumeDevices=" + this.getVolumeDevices() + ", volumeMounts=" + this.getVolumeMounts() + ", workingDir=" + this.getWorkingDir() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
