
package io.fabric8.openshift.api.model.config.v1;

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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerInternalIPs",
    "failureDomains",
    "ingressIPs",
    "machineNetworks",
    "nodeNetworking",
    "vcenters"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class InfrastructureSpecPSVsphere implements Editable<InfrastructureSpecPSVsphereBuilder> , KubernetesResource
{

    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiServerInternalIPs = new ArrayList<>();
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InfrastructureSpecPSVsphereFailureDomains> failureDomains = new ArrayList<>();
    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressIPs = new ArrayList<>();
    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> machineNetworks = new ArrayList<>();
    @JsonProperty("nodeNetworking")
    private InfrastructureSpecPSVsphereNodeNetworking nodeNetworking;
    @JsonProperty("vcenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InfrastructureSpecPSVsphereVcenters> vcenters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfrastructureSpecPSVsphere() {
    }

    public InfrastructureSpecPSVsphere(List<String> apiServerInternalIPs, List<InfrastructureSpecPSVsphereFailureDomains> failureDomains, List<String> ingressIPs, List<String> machineNetworks, InfrastructureSpecPSVsphereNodeNetworking nodeNetworking, List<InfrastructureSpecPSVsphereVcenters> vcenters) {
        super();
        this.apiServerInternalIPs = apiServerInternalIPs;
        this.failureDomains = failureDomains;
        this.ingressIPs = ingressIPs;
        this.machineNetworks = machineNetworks;
        this.nodeNetworking = nodeNetworking;
        this.vcenters = vcenters;
    }

    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiServerInternalIPs() {
        return apiServerInternalIPs;
    }

    @JsonProperty("apiServerInternalIPs")
    public void setApiServerInternalIPs(List<String> apiServerInternalIPs) {
        this.apiServerInternalIPs = apiServerInternalIPs;
    }

    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InfrastructureSpecPSVsphereFailureDomains> getFailureDomains() {
        return failureDomains;
    }

    @JsonProperty("failureDomains")
    public void setFailureDomains(List<InfrastructureSpecPSVsphereFailureDomains> failureDomains) {
        this.failureDomains = failureDomains;
    }

    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressIPs() {
        return ingressIPs;
    }

    @JsonProperty("ingressIPs")
    public void setIngressIPs(List<String> ingressIPs) {
        this.ingressIPs = ingressIPs;
    }

    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMachineNetworks() {
        return machineNetworks;
    }

    @JsonProperty("machineNetworks")
    public void setMachineNetworks(List<String> machineNetworks) {
        this.machineNetworks = machineNetworks;
    }

    @JsonProperty("nodeNetworking")
    public InfrastructureSpecPSVsphereNodeNetworking getNodeNetworking() {
        return nodeNetworking;
    }

    @JsonProperty("nodeNetworking")
    public void setNodeNetworking(InfrastructureSpecPSVsphereNodeNetworking nodeNetworking) {
        this.nodeNetworking = nodeNetworking;
    }

    @JsonProperty("vcenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InfrastructureSpecPSVsphereVcenters> getVcenters() {
        return vcenters;
    }

    @JsonProperty("vcenters")
    public void setVcenters(List<InfrastructureSpecPSVsphereVcenters> vcenters) {
        this.vcenters = vcenters;
    }

    @JsonIgnore
    public InfrastructureSpecPSVsphereBuilder edit() {
        return new InfrastructureSpecPSVsphereBuilder(this);
    }

    @JsonIgnore
    public InfrastructureSpecPSVsphereBuilder toBuilder() {
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
