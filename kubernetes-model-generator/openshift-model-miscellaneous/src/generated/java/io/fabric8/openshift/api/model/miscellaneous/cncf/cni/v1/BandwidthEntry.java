
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
 * BandwidthEntry for CNI BandwidthEntry
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "egressBurst",
    "egressRate",
    "ingressBurst",
    "ingressRate"
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
public class BandwidthEntry implements Editable<BandwidthEntryBuilder>, KubernetesResource
{

    @JsonProperty("egressBurst")
    private Integer egressBurst;
    @JsonProperty("egressRate")
    private Integer egressRate;
    @JsonProperty("ingressBurst")
    private Integer ingressBurst;
    @JsonProperty("ingressRate")
    private Integer ingressRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BandwidthEntry() {
    }

    public BandwidthEntry(Integer egressBurst, Integer egressRate, Integer ingressBurst, Integer ingressRate) {
        super();
        this.egressBurst = egressBurst;
        this.egressRate = egressRate;
        this.ingressBurst = ingressBurst;
        this.ingressRate = ingressRate;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("egressBurst")
    public Integer getEgressBurst() {
        return egressBurst;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("egressBurst")
    public void setEgressBurst(Integer egressBurst) {
        this.egressBurst = egressBurst;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("egressRate")
    public Integer getEgressRate() {
        return egressRate;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("egressRate")
    public void setEgressRate(Integer egressRate) {
        this.egressRate = egressRate;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("ingressBurst")
    public Integer getIngressBurst() {
        return ingressBurst;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("ingressBurst")
    public void setIngressBurst(Integer ingressBurst) {
        this.ingressBurst = ingressBurst;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("ingressRate")
    public Integer getIngressRate() {
        return ingressRate;
    }

    /**
     * BandwidthEntry for CNI BandwidthEntry
     */
    @JsonProperty("ingressRate")
    public void setIngressRate(Integer ingressRate) {
        this.ingressRate = ingressRate;
    }

    @JsonIgnore
    public BandwidthEntryBuilder edit() {
        return new BandwidthEntryBuilder(this);
    }

    @JsonIgnore
    public BandwidthEntryBuilder toBuilder() {
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
