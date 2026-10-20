
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

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lifecycle",
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
public class IPAMConfig implements Editable<IPAMConfigBuilder>, KubernetesResource
{

    @JsonProperty("lifecycle")
    private String lifecycle;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPAMConfig() {
    }

    public IPAMConfig(String lifecycle, String mode) {
        super();
        this.lifecycle = lifecycle;
        this.mode = mode;
    }

    /**
     * Lifecycle controls IP addresses management lifecycle.<br><p> <br><p> The only allowed value is Persistent. When set, the IP addresses assigned by OVN-Kubernetes will be persisted in an `ipamclaims.k8s.cni.cncf.io` object. These IP addresses will be reused by other pods if requested. Only supported when mode is `Enabled`.
     */
    @JsonProperty("lifecycle")
    public String getLifecycle() {
        return lifecycle;
    }

    /**
     * Lifecycle controls IP addresses management lifecycle.<br><p> <br><p> The only allowed value is Persistent. When set, the IP addresses assigned by OVN-Kubernetes will be persisted in an `ipamclaims.k8s.cni.cncf.io` object. These IP addresses will be reused by other pods if requested. Only supported when mode is `Enabled`.
     */
    @JsonProperty("lifecycle")
    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    /**
     * Mode controls how much of the IP configuration will be managed by OVN. `Enabled` means OVN-Kubernetes will apply IP configuration to the SDN infrastructure and it will also assign IPs from the selected subnet to the individual pods. `DHCP` delegates IP assignment to a DHCP server reachable on the physical network; OVN-Kubernetes does not allocate addresses. Lease acquisition depends on the workload type: regular pods use the DHCP CNI plugin on the node, while KubeVirt virtual machines run a DHCP client inside the guest OS. Only supported for Localnet Secondary networks, and currently only for IPv4. `Disabled` means OVN-Kubernetes will only assign MAC addresses and provide layer 2 communication, letting users configure IP addresses for the pods. `Disabled` is only available for Secondary networks. By disabling IPAM, any Kubernetes features that rely on selecting pods by IP will no longer function (such as network policy, services, etc). Additionally, IP port security will also be disabled for interfaces attached to this network. Defaults to `Enabled`.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode controls how much of the IP configuration will be managed by OVN. `Enabled` means OVN-Kubernetes will apply IP configuration to the SDN infrastructure and it will also assign IPs from the selected subnet to the individual pods. `DHCP` delegates IP assignment to a DHCP server reachable on the physical network; OVN-Kubernetes does not allocate addresses. Lease acquisition depends on the workload type: regular pods use the DHCP CNI plugin on the node, while KubeVirt virtual machines run a DHCP client inside the guest OS. Only supported for Localnet Secondary networks, and currently only for IPv4. `Disabled` means OVN-Kubernetes will only assign MAC addresses and provide layer 2 communication, letting users configure IP addresses for the pods. `Disabled` is only available for Secondary networks. By disabling IPAM, any Kubernetes features that rely on selecting pods by IP will no longer function (such as network policy, services, etc). Additionally, IP port security will also be disabled for interfaces attached to this network. Defaults to `Enabled`.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public IPAMConfigBuilder edit() {
        return new IPAMConfigBuilder(this);
    }

    @JsonIgnore
    public IPAMConfigBuilder toBuilder() {
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
