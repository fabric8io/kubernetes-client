
package io.fabric8.kubernetes.api.model.ovn.v1;

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
 * VTEPSpec defines the desired state of VTEP.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidrs",
    "mode"
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
public class VTEPSpec implements Editable<VTEPSpecBuilder>, KubernetesResource
{

    @JsonProperty("cidrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cidrs = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VTEPSpec() {
    }

    public VTEPSpec(List<String> cidrs, String mode) {
        super();
        this.cidrs = cidrs;
        this.mode = mode;
    }

    /**
     * CIDRs is the list of IP ranges from which VTEP IPs are discovered (unmanaged mode) or allocated (managed mode). Multiple CIDRs may be specified to expand capacity over time without recreating the VTEP. Each entry must be a valid network address in CIDR notation (for example, "100.64.0.0/24" or "fd00:100::/64"). Each node receives at most one IP per address family from the CIDRs listed here. In managed mode, CIDRs are consumed sequentially: IPs are allocated from the first CIDR until it is exhausted, then from the next, and so on. In managed mode, CIDRs are append-only: existing entries cannot be removed, reordered, or shrunk to a smaller mask; they can only be expanded to a wider mask, and new entries may be appended. In unmanaged mode, if multiple IPs on a node match the configured CIDRs, or if the match is otherwise ambiguous, the VTEP will be placed into a failed status. In unmanaged mode, CIDRs may be freely added, removed, reordered, or resized. Caution: removing or modifying CIDRs in unmanaged mode that are actively in use may cause traffic disruption; no downtime guarantees are provided for such operations.
     */
    @JsonProperty("cidrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCidrs() {
        return cidrs;
    }

    /**
     * CIDRs is the list of IP ranges from which VTEP IPs are discovered (unmanaged mode) or allocated (managed mode). Multiple CIDRs may be specified to expand capacity over time without recreating the VTEP. Each entry must be a valid network address in CIDR notation (for example, "100.64.0.0/24" or "fd00:100::/64"). Each node receives at most one IP per address family from the CIDRs listed here. In managed mode, CIDRs are consumed sequentially: IPs are allocated from the first CIDR until it is exhausted, then from the next, and so on. In managed mode, CIDRs are append-only: existing entries cannot be removed, reordered, or shrunk to a smaller mask; they can only be expanded to a wider mask, and new entries may be appended. In unmanaged mode, if multiple IPs on a node match the configured CIDRs, or if the match is otherwise ambiguous, the VTEP will be placed into a failed status. In unmanaged mode, CIDRs may be freely added, removed, reordered, or resized. Caution: removing or modifying CIDRs in unmanaged mode that are actively in use may cause traffic disruption; no downtime guarantees are provided for such operations.
     */
    @JsonProperty("cidrs")
    public void setCidrs(List<String> cidrs) {
        this.cidrs = cidrs;
    }

    /**
     * Mode specifies how VTEP IPs are managed. "Managed" means OVN-Kubernetes allocates and assigns VTEP IPs per node automatically. "Unmanaged" means an external provider handles IP assignment; OVN-Kubernetes discovers existing IPs on nodes. Defaults to "Managed".
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode specifies how VTEP IPs are managed. "Managed" means OVN-Kubernetes allocates and assigns VTEP IPs per node automatically. "Unmanaged" means an external provider handles IP assignment; OVN-Kubernetes discovers existing IPs on nodes. Defaults to "Managed".
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public VTEPSpecBuilder edit() {
        return new VTEPSpecBuilder(this);
    }

    @JsonIgnore
    public VTEPSpecBuilder toBuilder() {
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
