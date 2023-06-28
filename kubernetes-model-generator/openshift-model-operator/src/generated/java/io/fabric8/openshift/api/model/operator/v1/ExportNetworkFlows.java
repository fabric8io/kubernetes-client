
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "ipfix",
    "netFlow",
    "sFlow"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ExportNetworkFlows implements KubernetesResource
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
     * 
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
