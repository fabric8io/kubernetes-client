
package io.fabric8.istio.api.api.networking.v1alpha3;

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
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * `Sidecar` describes the configuration of the sidecar proxy that mediates inbound and outbound communication of the workload instance to which it is attached.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "egress",
    "inboundConnectionPool",
    "ingress",
    "outboundTrafficPolicy",
    "workloadSelector"
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
@Version("v1alpha3")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Sidecar implements Editable<SidecarBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("egress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IstioEgressListener> egress = new ArrayList<>();
    @JsonProperty("inboundConnectionPool")
    private ConnectionPoolSettings inboundConnectionPool;
    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IstioIngressListener> ingress = new ArrayList<>();
    @JsonProperty("outboundTrafficPolicy")
    private OutboundTrafficPolicy outboundTrafficPolicy;
    @JsonProperty("workloadSelector")
    private WorkloadSelector workloadSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Sidecar() {
    }

    public Sidecar(List<IstioEgressListener> egress, ConnectionPoolSettings inboundConnectionPool, List<IstioIngressListener> ingress, OutboundTrafficPolicy outboundTrafficPolicy, WorkloadSelector workloadSelector) {
        super();
        this.egress = egress;
        this.inboundConnectionPool = inboundConnectionPool;
        this.ingress = ingress;
        this.outboundTrafficPolicy = outboundTrafficPolicy;
        this.workloadSelector = workloadSelector;
    }

    /**
     * Egress specifies the configuration of the sidecar for processing outbound traffic from the attached workload instance to other services in the mesh. If not specified, inherits the system detected defaults from the namespace-wide or the global default Sidecar.
     */
    @JsonProperty("egress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IstioEgressListener> getEgress() {
        return egress;
    }

    /**
     * Egress specifies the configuration of the sidecar for processing outbound traffic from the attached workload instance to other services in the mesh. If not specified, inherits the system detected defaults from the namespace-wide or the global default Sidecar.
     */
    @JsonProperty("egress")
    public void setEgress(List<IstioEgressListener> egress) {
        this.egress = egress;
    }

    /**
     * `Sidecar` describes the configuration of the sidecar proxy that mediates inbound and outbound communication of the workload instance to which it is attached.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("inboundConnectionPool")
    public ConnectionPoolSettings getInboundConnectionPool() {
        return inboundConnectionPool;
    }

    /**
     * `Sidecar` describes the configuration of the sidecar proxy that mediates inbound and outbound communication of the workload instance to which it is attached.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("inboundConnectionPool")
    public void setInboundConnectionPool(ConnectionPoolSettings inboundConnectionPool) {
        this.inboundConnectionPool = inboundConnectionPool;
    }

    /**
     * Ingress specifies the configuration of the sidecar for processing inbound traffic to the attached workload instance. If omitted, Istio will automatically configure the sidecar based on the information about the workload obtained from the orchestration platform (e.g., exposed ports, services, etc.). If specified, inbound ports are configured if and only if the workload instance is associated with a service.
     */
    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IstioIngressListener> getIngress() {
        return ingress;
    }

    /**
     * Ingress specifies the configuration of the sidecar for processing inbound traffic to the attached workload instance. If omitted, Istio will automatically configure the sidecar based on the information about the workload obtained from the orchestration platform (e.g., exposed ports, services, etc.). If specified, inbound ports are configured if and only if the workload instance is associated with a service.
     */
    @JsonProperty("ingress")
    public void setIngress(List<IstioIngressListener> ingress) {
        this.ingress = ingress;
    }

    /**
     * `Sidecar` describes the configuration of the sidecar proxy that mediates inbound and outbound communication of the workload instance to which it is attached.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("outboundTrafficPolicy")
    public OutboundTrafficPolicy getOutboundTrafficPolicy() {
        return outboundTrafficPolicy;
    }

    /**
     * `Sidecar` describes the configuration of the sidecar proxy that mediates inbound and outbound communication of the workload instance to which it is attached.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("outboundTrafficPolicy")
    public void setOutboundTrafficPolicy(OutboundTrafficPolicy outboundTrafficPolicy) {
        this.outboundTrafficPolicy = outboundTrafficPolicy;
    }

    /**
     * `Sidecar` describes the configuration of the sidecar proxy that mediates inbound and outbound communication of the workload instance to which it is attached.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("workloadSelector")
    public WorkloadSelector getWorkloadSelector() {
        return workloadSelector;
    }

    /**
     * `Sidecar` describes the configuration of the sidecar proxy that mediates inbound and outbound communication of the workload instance to which it is attached.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("workloadSelector")
    public void setWorkloadSelector(WorkloadSelector workloadSelector) {
        this.workloadSelector = workloadSelector;
    }

    @JsonIgnore
    public SidecarBuilder edit() {
        return new SidecarBuilder(this);
    }

    @JsonIgnore
    public SidecarBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Sidecar)) {
            return false;
        }
        Sidecar other = (Sidecar) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$egress = this.getEgress();
        Object other$egress = other.getEgress();
        if (this$egress == null ? other$egress != null : !this$egress.equals(other$egress)) {
            return false;
        }
        Object this$inboundConnectionPool = this.getInboundConnectionPool();
        Object other$inboundConnectionPool = other.getInboundConnectionPool();
        if (this$inboundConnectionPool == null ? other$inboundConnectionPool != null : !this$inboundConnectionPool.equals(other$inboundConnectionPool)) {
            return false;
        }
        Object this$ingress = this.getIngress();
        Object other$ingress = other.getIngress();
        if (this$ingress == null ? other$ingress != null : !this$ingress.equals(other$ingress)) {
            return false;
        }
        Object this$outboundTrafficPolicy = this.getOutboundTrafficPolicy();
        Object other$outboundTrafficPolicy = other.getOutboundTrafficPolicy();
        if (this$outboundTrafficPolicy == null ? other$outboundTrafficPolicy != null : !this$outboundTrafficPolicy.equals(other$outboundTrafficPolicy)) {
            return false;
        }
        Object this$workloadSelector = this.getWorkloadSelector();
        Object other$workloadSelector = other.getWorkloadSelector();
        if (this$workloadSelector == null ? other$workloadSelector != null : !this$workloadSelector.equals(other$workloadSelector)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Sidecar;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $egress = this.getEgress();
        result = result * prime + ($egress == null ? 43 : $egress.hashCode());
        Object $inboundConnectionPool = this.getInboundConnectionPool();
        result = result * prime + ($inboundConnectionPool == null ? 43 : $inboundConnectionPool.hashCode());
        Object $ingress = this.getIngress();
        result = result * prime + ($ingress == null ? 43 : $ingress.hashCode());
        Object $outboundTrafficPolicy = this.getOutboundTrafficPolicy();
        result = result * prime + ($outboundTrafficPolicy == null ? 43 : $outboundTrafficPolicy.hashCode());
        Object $workloadSelector = this.getWorkloadSelector();
        result = result * prime + ($workloadSelector == null ? 43 : $workloadSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Sidecar(" + "egress=" + this.getEgress() + ", inboundConnectionPool=" + this.getInboundConnectionPool() + ", ingress=" + this.getIngress() + ", outboundTrafficPolicy=" + this.getOutboundTrafficPolicy() + ", workloadSelector=" + this.getWorkloadSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
