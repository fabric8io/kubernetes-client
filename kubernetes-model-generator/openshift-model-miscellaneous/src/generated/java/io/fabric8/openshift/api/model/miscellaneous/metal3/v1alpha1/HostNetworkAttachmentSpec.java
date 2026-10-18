
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
 * HostNetworkAttachmentSpec defines the desired switchport configuration.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedVLANs",
    "mode",
    "mtu",
    "nativeVLAN"
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
public class HostNetworkAttachmentSpec implements Editable<HostNetworkAttachmentSpecBuilder>, KubernetesResource
{

    @JsonProperty("allowedVLANs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedVLANs = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("nativeVLAN")
    private Integer nativeVLAN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostNetworkAttachmentSpec() {
    }

    public HostNetworkAttachmentSpec(List<String> allowedVLANs, String mode, Integer mtu, Integer nativeVLAN) {
        super();
        this.allowedVLANs = allowedVLANs;
        this.mode = mode;
        this.mtu = mtu;
        this.nativeVLAN = nativeVLAN;
    }

    /**
     * AllowedVLANs specifies the VLAN IDs allowed on this network attachment. Each entry is either a single VLAN ID (e.g., "100") or a range (e.g., "100-200"). This is typically used in trunk or hybrid mode to specify which tagged VLANs can be carried on the interface.
     */
    @JsonProperty("allowedVLANs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedVLANs() {
        return allowedVLANs;
    }

    /**
     * AllowedVLANs specifies the VLAN IDs allowed on this network attachment. Each entry is either a single VLAN ID (e.g., "100") or a range (e.g., "100-200"). This is typically used in trunk or hybrid mode to specify which tagged VLANs can be carried on the interface.
     */
    @JsonProperty("allowedVLANs")
    public void setAllowedVLANs(List<String> allowedVLANs) {
        this.allowedVLANs = allowedVLANs;
    }

    /**
     * Mode specifies the network attachment mode.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode specifies the network attachment mode.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * MTU specifies the Maximum Transmission Unit size for the network attachment. If not specified, the default MTU for the underlying network will be used.
     */
    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    /**
     * MTU specifies the Maximum Transmission Unit size for the network attachment. If not specified, the default MTU for the underlying network will be used.
     */
    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    /**
     * NativeVLAN specifies the native VLAN ID for the network attachment. This is the untagged VLAN used on the interface.
     */
    @JsonProperty("nativeVLAN")
    public Integer getNativeVLAN() {
        return nativeVLAN;
    }

    /**
     * NativeVLAN specifies the native VLAN ID for the network attachment. This is the untagged VLAN used on the interface.
     */
    @JsonProperty("nativeVLAN")
    public void setNativeVLAN(Integer nativeVLAN) {
        this.nativeVLAN = nativeVLAN;
    }

    @JsonIgnore
    public HostNetworkAttachmentSpecBuilder edit() {
        return new HostNetworkAttachmentSpecBuilder(this);
    }

    @JsonIgnore
    public HostNetworkAttachmentSpecBuilder toBuilder() {
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
