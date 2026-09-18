
package io.fabric8.openshift.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ipfix",
    "netFlow",
    "sFlow"
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
public class ExportNetworkFlows implements Editable<ExportNetworkFlowsBuilder>, KubernetesResource
{

    @JsonProperty("ipfix")
    private IPFIXConfig ipfix;
    @JsonProperty("netFlow")
    private NetFlowConfig netFlow;
    @JsonProperty("sFlow")
    private SFlowConfig sFlow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExportNetworkFlows() {
    }

    public ExportNetworkFlows(IPFIXConfig ipfix, NetFlowConfig netFlow, SFlowConfig sFlow) {
        super();
        this.ipfix = ipfix;
        this.netFlow = netFlow;
        this.sFlow = sFlow;
    }

    @JsonProperty("ipfix")
    public IPFIXConfig getIpfix() {
        return ipfix;
    }

    @JsonProperty("ipfix")
    public void setIpfix(IPFIXConfig ipfix) {
        this.ipfix = ipfix;
    }

    @JsonProperty("netFlow")
    public NetFlowConfig getNetFlow() {
        return netFlow;
    }

    @JsonProperty("netFlow")
    public void setNetFlow(NetFlowConfig netFlow) {
        this.netFlow = netFlow;
    }

    @JsonProperty("sFlow")
    public SFlowConfig getSFlow() {
        return sFlow;
    }

    @JsonProperty("sFlow")
    public void setSFlow(SFlowConfig sFlow) {
        this.sFlow = sFlow;
    }

    @JsonIgnore
    public ExportNetworkFlowsBuilder edit() {
        return new ExportNetworkFlowsBuilder(this);
    }

    @JsonIgnore
    public ExportNetworkFlowsBuilder toBuilder() {
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
        if (!(o instanceof ExportNetworkFlows)) {
            return false;
        }
        ExportNetworkFlows other = (ExportNetworkFlows) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ipfix = this.getIpfix();
        Object other$ipfix = other.getIpfix();
        if (this$ipfix == null ? other$ipfix != null : !this$ipfix.equals(other$ipfix)) {
            return false;
        }
        Object this$netFlow = this.getNetFlow();
        Object other$netFlow = other.getNetFlow();
        if (this$netFlow == null ? other$netFlow != null : !this$netFlow.equals(other$netFlow)) {
            return false;
        }
        Object this$sFlow = this.getSFlow();
        Object other$sFlow = other.getSFlow();
        if (this$sFlow == null ? other$sFlow != null : !this$sFlow.equals(other$sFlow)) {
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
        return other instanceof ExportNetworkFlows;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ipfix = this.getIpfix();
        result = result * prime + ($ipfix == null ? 43 : $ipfix.hashCode());
        Object $netFlow = this.getNetFlow();
        result = result * prime + ($netFlow == null ? 43 : $netFlow.hashCode());
        Object $sFlow = this.getSFlow();
        result = result * prime + ($sFlow == null ? 43 : $sFlow.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExportNetworkFlows(" + "ipfix=" + this.getIpfix() + ", netFlow=" + this.getNetFlow() + ", sFlow=" + this.getSFlow() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
