
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.ContainerResizePolicy;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.VolumeDevice;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "securityContext",
    "startupProbe",
    "stdin",
    "stdinOnce",
    "terminationMessagePath",
    "terminationMessagePolicy",
    "tty",
    "volumeDevices",
    "volumeMounts",
    "workingDir"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ThanosRulerSpecInitContainers implements Editable<ThanosRulerSpecInitContainersBuilder> , KubernetesResource
{

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> args = new ArrayList<>();
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> command = new ArrayList<>();
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ThanosRulerSpecICEnv> env = new ArrayList<>();
    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ThanosRulerSpecICEnvFrom> envFrom = new ArrayList<>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("lifecycle")
    private ThanosRulerSpecICLifecycle lifecycle;
    @JsonProperty("livenessProbe")
    private ThanosRulerSpecICLivenessProbe livenessProbe;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ThanosRulerSpecICPorts> ports = new ArrayList<>();
    @JsonProperty("readinessProbe")
    private ThanosRulerSpecICReadinessProbe readinessProbe;
    @JsonProperty("resizePolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerResizePolicy> resizePolicy = new ArrayList<>();
    @JsonProperty("resources")
    private ThanosRulerSpecICResources resources;
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonProperty("securityContext")
    private ThanosRulerSpecICSecurityContext securityContext;
    @JsonProperty("startupProbe")
    private ThanosRulerSpecICStartupProbe startupProbe;
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
    private List<ThanosRulerSpecICVolumeMounts> volumeMounts = new ArrayList<>();
    @JsonProperty("workingDir")
    private String workingDir;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpecInitContainers() {
    }

    public ThanosRulerSpecInitContainers(List<String> args, List<String> command, List<ThanosRulerSpecICEnv> env, List<ThanosRulerSpecICEnvFrom> envFrom, String image, String imagePullPolicy, ThanosRulerSpecICLifecycle lifecycle, ThanosRulerSpecICLivenessProbe livenessProbe, String name, List<ThanosRulerSpecICPorts> ports, ThanosRulerSpecICReadinessProbe readinessProbe, List<ContainerResizePolicy> resizePolicy, ThanosRulerSpecICResources resources, String restartPolicy, ThanosRulerSpecICSecurityContext securityContext, ThanosRulerSpecICStartupProbe startupProbe, Boolean stdin, Boolean stdinOnce, String terminationMessagePath, String terminationMessagePolicy, Boolean tty, List<VolumeDevice> volumeDevices, List<ThanosRulerSpecICVolumeMounts> volumeMounts, String workingDir) {
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
    }

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getArgs() {
        return args;
    }

    @JsonProperty("args")
    public void setArgs(List<String> args) {
        this.args = args;
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

    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ThanosRulerSpecICEnv> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<ThanosRulerSpecICEnv> env) {
        this.env = env;
    }

    @JsonProperty("envFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ThanosRulerSpecICEnvFrom> getEnvFrom() {
        return envFrom;
    }

    @JsonProperty("envFrom")
    public void setEnvFrom(List<ThanosRulerSpecICEnvFrom> envFrom) {
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

    @JsonProperty("lifecycle")
    public ThanosRulerSpecICLifecycle getLifecycle() {
        return lifecycle;
    }

    @JsonProperty("lifecycle")
    public void setLifecycle(ThanosRulerSpecICLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @JsonProperty("livenessProbe")
    public ThanosRulerSpecICLivenessProbe getLivenessProbe() {
        return livenessProbe;
    }

    @JsonProperty("livenessProbe")
    public void setLivenessProbe(ThanosRulerSpecICLivenessProbe livenessProbe) {
        this.livenessProbe = livenessProbe;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ThanosRulerSpecICPorts> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<ThanosRulerSpecICPorts> ports) {
        this.ports = ports;
    }

    @JsonProperty("readinessProbe")
    public ThanosRulerSpecICReadinessProbe getReadinessProbe() {
        return readinessProbe;
    }

    @JsonProperty("readinessProbe")
    public void setReadinessProbe(ThanosRulerSpecICReadinessProbe readinessProbe) {
        this.readinessProbe = readinessProbe;
    }

    @JsonProperty("resizePolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerResizePolicy> getResizePolicy() {
        return resizePolicy;
    }

    @JsonProperty("resizePolicy")
    public void setResizePolicy(List<ContainerResizePolicy> resizePolicy) {
        this.resizePolicy = resizePolicy;
    }

    @JsonProperty("resources")
    public ThanosRulerSpecICResources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ThanosRulerSpecICResources resources) {
        this.resources = resources;
    }

    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("securityContext")
    public ThanosRulerSpecICSecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(ThanosRulerSpecICSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @JsonProperty("startupProbe")
    public ThanosRulerSpecICStartupProbe getStartupProbe() {
        return startupProbe;
    }

    @JsonProperty("startupProbe")
    public void setStartupProbe(ThanosRulerSpecICStartupProbe startupProbe) {
        this.startupProbe = startupProbe;
    }

    @JsonProperty("stdin")
    public Boolean getStdin() {
        return stdin;
    }

    @JsonProperty("stdin")
    public void setStdin(Boolean stdin) {
        this.stdin = stdin;
    }

    @JsonProperty("stdinOnce")
    public Boolean getStdinOnce() {
        return stdinOnce;
    }

    @JsonProperty("stdinOnce")
    public void setStdinOnce(Boolean stdinOnce) {
        this.stdinOnce = stdinOnce;
    }

    @JsonProperty("terminationMessagePath")
    public String getTerminationMessagePath() {
        return terminationMessagePath;
    }

    @JsonProperty("terminationMessagePath")
    public void setTerminationMessagePath(String terminationMessagePath) {
        this.terminationMessagePath = terminationMessagePath;
    }

    @JsonProperty("terminationMessagePolicy")
    public String getTerminationMessagePolicy() {
        return terminationMessagePolicy;
    }

    @JsonProperty("terminationMessagePolicy")
    public void setTerminationMessagePolicy(String terminationMessagePolicy) {
        this.terminationMessagePolicy = terminationMessagePolicy;
    }

    @JsonProperty("tty")
    public Boolean getTty() {
        return tty;
    }

    @JsonProperty("tty")
    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    @JsonProperty("volumeDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeDevice> getVolumeDevices() {
        return volumeDevices;
    }

    @JsonProperty("volumeDevices")
    public void setVolumeDevices(List<VolumeDevice> volumeDevices) {
        this.volumeDevices = volumeDevices;
    }

    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ThanosRulerSpecICVolumeMounts> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<ThanosRulerSpecICVolumeMounts> volumeMounts) {
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

    @JsonIgnore
    public ThanosRulerSpecInitContainersBuilder edit() {
        return new ThanosRulerSpecInitContainersBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecInitContainersBuilder toBuilder() {
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
