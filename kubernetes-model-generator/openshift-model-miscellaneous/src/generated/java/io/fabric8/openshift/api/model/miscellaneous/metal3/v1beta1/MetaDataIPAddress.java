
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * MetaDataIPAddress contains the info to render th ip address. It is IP-version agnostic.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "end",
    "key",
    "start",
    "step",
    "subnet"
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
public class MetaDataIPAddress implements Editable<MetaDataIPAddressBuilder>, KubernetesResource
{

    @JsonProperty("end")
    private String end;
    @JsonProperty("key")
    private String key;
    @JsonProperty("start")
    private String start;
    @JsonProperty("step")
    private Integer step;
    @JsonProperty("subnet")
    private String subnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetaDataIPAddress() {
    }

    public MetaDataIPAddress(String end, String key, String start, Integer step, String subnet) {
        super();
        this.end = end;
        this.key = key;
        this.start = start;
        this.step = step;
        this.subnet = subnet;
    }

    /**
     * End is the last IP address that can be rendered. It is used as a validation that the rendered IP is in bound.
     */
    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    /**
     * End is the last IP address that can be rendered. It is used as a validation that the rendered IP is in bound.
     */
    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Key will be used as the key to set in the metadata map for cloud-init
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * Key will be used as the key to set in the metadata map for cloud-init
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Start is the first ip address that can be rendered
     */
    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    /**
     * Start is the first ip address that can be rendered
     */
    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Step is the step between the IP addresses rendered.
     */
    @JsonProperty("step")
    public Integer getStep() {
        return step;
    }

    /**
     * Step is the step between the IP addresses rendered.
     */
    @JsonProperty("step")
    public void setStep(Integer step) {
        this.step = step;
    }

    /**
     * Subnet is used to validate that the rendered IP is in bounds. In case the Start value is not given, it is derived from the subnet ip incremented by 1 (`192.168.0.1` for `192.168.0.0/24`)
     */
    @JsonProperty("subnet")
    public String getSubnet() {
        return subnet;
    }

    /**
     * Subnet is used to validate that the rendered IP is in bounds. In case the Start value is not given, it is derived from the subnet ip incremented by 1 (`192.168.0.1` for `192.168.0.0/24`)
     */
    @JsonProperty("subnet")
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    @JsonIgnore
    public MetaDataIPAddressBuilder edit() {
        return new MetaDataIPAddressBuilder(this);
    }

    @JsonIgnore
    public MetaDataIPAddressBuilder toBuilder() {
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
