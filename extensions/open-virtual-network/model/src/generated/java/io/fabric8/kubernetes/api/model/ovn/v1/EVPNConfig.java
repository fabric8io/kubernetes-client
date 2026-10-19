
package io.fabric8.kubernetes.api.model.ovn.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * EVPNConfig contains configuration options for networks operating in EVPN mode.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ipVRF",
    "macVRF",
    "vtep"
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
public class EVPNConfig implements Editable<EVPNConfigBuilder>, KubernetesResource
{

    @JsonProperty("ipVRF")
    private VRFConfig ipVRF;
    @JsonProperty("macVRF")
    private VRFConfig macVRF;
    @JsonProperty("vtep")
    private String vtep;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EVPNConfig() {
    }

    public EVPNConfig(VRFConfig ipVRF, VRFConfig macVRF, String vtep) {
        super();
        this.ipVRF = ipVRF;
        this.macVRF = macVRF;
        this.vtep = vtep;
    }

    /**
     * EVPNConfig contains configuration options for networks operating in EVPN mode.
     */
    @JsonProperty("ipVRF")
    public VRFConfig getIpVRF() {
        return ipVRF;
    }

    /**
     * EVPNConfig contains configuration options for networks operating in EVPN mode.
     */
    @JsonProperty("ipVRF")
    public void setIpVRF(VRFConfig ipVRF) {
        this.ipVRF = ipVRF;
    }

    /**
     * EVPNConfig contains configuration options for networks operating in EVPN mode.
     */
    @JsonProperty("macVRF")
    public VRFConfig getMacVRF() {
        return macVRF;
    }

    /**
     * EVPNConfig contains configuration options for networks operating in EVPN mode.
     */
    @JsonProperty("macVRF")
    public void setMacVRF(VRFConfig macVRF) {
        this.macVRF = macVRF;
    }

    /**
     * VTEP is the name of the VTEP CR that defines VTEP IPs for EVPN.
     */
    @JsonProperty("vtep")
    public String getVtep() {
        return vtep;
    }

    /**
     * VTEP is the name of the VTEP CR that defines VTEP IPs for EVPN.
     */
    @JsonProperty("vtep")
    public void setVtep(String vtep) {
        this.vtep = vtep;
    }

    @JsonIgnore
    public EVPNConfigBuilder edit() {
        return new EVPNConfigBuilder(this);
    }

    @JsonIgnore
    public EVPNConfigBuilder toBuilder() {
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
