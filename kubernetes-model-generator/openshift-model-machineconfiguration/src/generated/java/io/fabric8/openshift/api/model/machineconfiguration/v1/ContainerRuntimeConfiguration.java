
package io.fabric8.openshift.api.model.machineconfiguration.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.Quantity;
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerRuntimeConfiguration implements Editable<ContainerRuntimeConfigurationBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("defaultRuntime")
    public String getDefaultRuntime() {
        return defaultRuntime;
    }

    @JsonProperty("defaultRuntime")
    public void setDefaultRuntime(String defaultRuntime) {
        this.defaultRuntime = defaultRuntime;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("logSizeMax")
    public Quantity getLogSizeMax() {
        return logSizeMax;
    }

    @JsonProperty("logSizeMax")
    public void setLogSizeMax(Quantity logSizeMax) {
        this.logSizeMax = logSizeMax;
    }

    @JsonProperty("overlaySize")
    public Quantity getOverlaySize() {
        return overlaySize;
    }

    @JsonProperty("overlaySize")
    public void setOverlaySize(Quantity overlaySize) {
        this.overlaySize = overlaySize;
    }

    @JsonProperty("pidsLimit")
    public Long getPidsLimit() {
        return pidsLimit;
    }

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
