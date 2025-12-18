
package io.fabric8.openshift.api.model.machineconfiguration.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ContainerRuntimeConfiguration defines the tuneables of the container runtime
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "defaultRuntime",
    "logLevel",
    "logSizeMax",
    "overlaySize",
    "pidsLimit"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerRuntimeConfiguration implements Editable<ContainerRuntimeConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("defaultRuntime")
    private String defaultRuntime;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("logSizeMax")
    private Quantity logSizeMax;
    @JsonProperty("overlaySize")
    private Quantity overlaySize;
    @JsonProperty("pidsLimit")
    private Long pidsLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerRuntimeConfiguration() {
    }

    public ContainerRuntimeConfiguration(String defaultRuntime, String logLevel, Quantity logSizeMax, Quantity overlaySize, Long pidsLimit) {
        super();
        this.defaultRuntime = defaultRuntime;
        this.logLevel = logLevel;
        this.logSizeMax = logSizeMax;
        this.overlaySize = overlaySize;
        this.pidsLimit = pidsLimit;
    }

    /**
     * defaultRuntime is the name of the OCI runtime to be used as the default for containers. Allowed values are `runc` and `crun`. When set to `runc`, OpenShift will use runc to execute the container When set to `crun`, OpenShift will use crun to execute the container When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. Currently, the default is `crun`.
     */
    @JsonProperty("defaultRuntime")
    public String getDefaultRuntime() {
        return defaultRuntime;
    }

    /**
     * defaultRuntime is the name of the OCI runtime to be used as the default for containers. Allowed values are `runc` and `crun`. When set to `runc`, OpenShift will use runc to execute the container When set to `crun`, OpenShift will use crun to execute the container When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. Currently, the default is `crun`.
     */
    @JsonProperty("defaultRuntime")
    public void setDefaultRuntime(String defaultRuntime) {
        this.defaultRuntime = defaultRuntime;
    }

    /**
     * logLevel specifies the verbosity of the logs based on the level it is set to. Options are fatal, panic, error, warn, info, and debug.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel specifies the verbosity of the logs based on the level it is set to. Options are fatal, panic, error, warn, info, and debug.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * ContainerRuntimeConfiguration defines the tuneables of the container runtime
     */
    @JsonProperty("logSizeMax")
    public Quantity getLogSizeMax() {
        return logSizeMax;
    }

    /**
     * ContainerRuntimeConfiguration defines the tuneables of the container runtime
     */
    @JsonProperty("logSizeMax")
    public void setLogSizeMax(Quantity logSizeMax) {
        this.logSizeMax = logSizeMax;
    }

    /**
     * ContainerRuntimeConfiguration defines the tuneables of the container runtime
     */
    @JsonProperty("overlaySize")
    public Quantity getOverlaySize() {
        return overlaySize;
    }

    /**
     * ContainerRuntimeConfiguration defines the tuneables of the container runtime
     */
    @JsonProperty("overlaySize")
    public void setOverlaySize(Quantity overlaySize) {
        this.overlaySize = overlaySize;
    }

    /**
     * pidsLimit specifies the maximum number of processes allowed in a container
     */
    @JsonProperty("pidsLimit")
    public Long getPidsLimit() {
        return pidsLimit;
    }

    /**
     * pidsLimit specifies the maximum number of processes allowed in a container
     */
    @JsonProperty("pidsLimit")
    public void setPidsLimit(Long pidsLimit) {
        this.pidsLimit = pidsLimit;
    }

    @JsonIgnore
    public ContainerRuntimeConfigurationBuilder edit() {
        return new ContainerRuntimeConfigurationBuilder(this);
    }

    @JsonIgnore
    public ContainerRuntimeConfigurationBuilder toBuilder() {
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

}
