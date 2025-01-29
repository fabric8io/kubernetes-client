
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * EgressServiceSpec defines the desired state of EgressService
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "network",
    "nodeSelector",
    "sourceIPBy"
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
public class EgressServiceSpec implements Editable<EgressServiceSpecBuilder>, KubernetesResource
{

    @JsonProperty("network")
    private String network;
    @JsonProperty("nodeSelector")
    private LabelSelector nodeSelector;
    @JsonProperty("sourceIPBy")
    private String sourceIPBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressServiceSpec() {
    }

    public EgressServiceSpec(String network, LabelSelector nodeSelector, String sourceIPBy) {
        super();
        this.network = network;
        this.nodeSelector = nodeSelector;
        this.sourceIPBy = sourceIPBy;
    }

    /**
     * The network which this service should send egress and corresponding ingress replies to. This is typically implemented as VRF mapping, representing a numeric id or string name of a routing table which by omission uses the default host routing.
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * The network which this service should send egress and corresponding ingress replies to. This is typically implemented as VRF mapping, representing a numeric id or string name of a routing table which by omission uses the default host routing.
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * EgressServiceSpec defines the desired state of EgressService
     */
    @JsonProperty("nodeSelector")
    public LabelSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * EgressServiceSpec defines the desired state of EgressService
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(LabelSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * Determines the source IP of egress traffic originating from the pods backing the LoadBalancer Service. When `LoadBalancerIP` the source IP is set to its LoadBalancer ingress IP. When `Network` the source IP is set according to the interface of the Network, leveraging the masquerade rules that are already in place. Typically these rules specify SNAT to the IP of the outgoing interface, which means the packet will typically leave with the IP of the node.
     */
    @JsonProperty("sourceIPBy")
    public String getSourceIPBy() {
        return sourceIPBy;
    }

    /**
     * Determines the source IP of egress traffic originating from the pods backing the LoadBalancer Service. When `LoadBalancerIP` the source IP is set to its LoadBalancer ingress IP. When `Network` the source IP is set according to the interface of the Network, leveraging the masquerade rules that are already in place. Typically these rules specify SNAT to the IP of the outgoing interface, which means the packet will typically leave with the IP of the node.
     */
    @JsonProperty("sourceIPBy")
    public void setSourceIPBy(String sourceIPBy) {
        this.sourceIPBy = sourceIPBy;
    }

    @JsonIgnore
    public EgressServiceSpecBuilder edit() {
        return new EgressServiceSpecBuilder(this);
    }

    @JsonIgnore
    public EgressServiceSpecBuilder toBuilder() {
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
