
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * CPU describes one processor on the host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "arch",
    "clockMegahertz",
    "count",
    "flags",
    "model"
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
public class CPU implements Editable<CPUBuilder>, KubernetesResource
{

    @JsonProperty("arch")
    private String arch;
    @JsonProperty("clockMegahertz")
    private Double clockMegahertz;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("flags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> flags = new ArrayList<>();
    @JsonProperty("model")
    private String model;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CPU() {
    }

    public CPU(String arch, Double clockMegahertz, Integer count, List<String> flags, String model) {
        super();
        this.arch = arch;
        this.clockMegahertz = clockMegahertz;
        this.count = count;
        this.flags = flags;
        this.model = model;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("arch")
    public String getArch() {
        return arch;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("arch")
    public void setArch(String arch) {
        this.arch = arch;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("clockMegahertz")
    public Double getClockMegahertz() {
        return clockMegahertz;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("clockMegahertz")
    public void setClockMegahertz(Double clockMegahertz) {
        this.clockMegahertz = clockMegahertz;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("flags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFlags() {
        return flags;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("flags")
    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * CPU describes one processor on the host.
     */
    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonIgnore
    public CPUBuilder edit() {
        return new CPUBuilder(this);
    }

    @JsonIgnore
    public CPUBuilder toBuilder() {
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
