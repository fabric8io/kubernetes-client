
package io.fabric8.istio.api.networking.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "egress",
    "inboundConnectionPool",
    "ingress",
    "outboundTrafficPolicy",
    "workloadSelector"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class SidecarSpec implements Editable<SidecarSpecBuilder> , KubernetesResource
{

    @JsonProperty("egress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IstioEgressListener> egress = new ArrayList<IstioEgressListener>();
    @JsonProperty("inboundConnectionPool")
    private ConnectionPoolSettings inboundConnectionPool;
    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IstioIngressListener> ingress = new ArrayList<IstioIngressListener>();
    @JsonProperty("outboundTrafficPolicy")
    private OutboundTrafficPolicy outboundTrafficPolicy;
    @JsonProperty("workloadSelector")
    private WorkloadSelector workloadSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SidecarSpec() {
    }

    public SidecarSpec(List<IstioEgressListener> egress, ConnectionPoolSettings inboundConnectionPool, List<IstioIngressListener> ingress, OutboundTrafficPolicy outboundTrafficPolicy, WorkloadSelector workloadSelector) {
        super();
        this.egress = egress;
        this.inboundConnectionPool = inboundConnectionPool;
        this.ingress = ingress;
        this.outboundTrafficPolicy = outboundTrafficPolicy;
        this.workloadSelector = workloadSelector;
    }

    @JsonProperty("egress")
    public List<IstioEgressListener> getEgress() {
        return egress;
    }

    @JsonProperty("egress")
    public void setEgress(List<IstioEgressListener> egress) {
        this.egress = egress;
    }

    @JsonProperty("inboundConnectionPool")
    public ConnectionPoolSettings getInboundConnectionPool() {
        return inboundConnectionPool;
    }

    @JsonProperty("inboundConnectionPool")
    public void setInboundConnectionPool(ConnectionPoolSettings inboundConnectionPool) {
        this.inboundConnectionPool = inboundConnectionPool;
    }

    @JsonProperty("ingress")
    public List<IstioIngressListener> getIngress() {
        return ingress;
    }

    @JsonProperty("ingress")
    public void setIngress(List<IstioIngressListener> ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("outboundTrafficPolicy")
    public OutboundTrafficPolicy getOutboundTrafficPolicy() {
        return outboundTrafficPolicy;
    }

    @JsonProperty("outboundTrafficPolicy")
    public void setOutboundTrafficPolicy(OutboundTrafficPolicy outboundTrafficPolicy) {
        this.outboundTrafficPolicy = outboundTrafficPolicy;
    }

    @JsonProperty("workloadSelector")
    public WorkloadSelector getWorkloadSelector() {
        return workloadSelector;
    }

    @JsonProperty("workloadSelector")
    public void setWorkloadSelector(WorkloadSelector workloadSelector) {
        this.workloadSelector = workloadSelector;
    }

    @JsonIgnore
    public SidecarSpecBuilder edit() {
        return new SidecarSpecBuilder(this);
    }

    @JsonIgnore
    public SidecarSpecBuilder toBuilder() {
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

}
