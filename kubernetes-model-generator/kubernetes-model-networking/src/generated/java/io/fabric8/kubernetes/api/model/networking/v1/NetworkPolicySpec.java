
package io.fabric8.kubernetes.api.model.networking.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
    "egress",
    "ingress",
    "podSelector",
    "policyTypes"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class NetworkPolicySpec implements KubernetesResource
{

    @JsonProperty("egress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkPolicyEgressRule> egress = new ArrayList<NetworkPolicyEgressRule>();
    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkPolicyIngressRule> ingress = new ArrayList<NetworkPolicyIngressRule>();
    @JsonProperty("podSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector podSelector;
    @JsonProperty("policyTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> policyTypes = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkPolicySpec() {
    }

    public NetworkPolicySpec(List<NetworkPolicyEgressRule> egress, List<NetworkPolicyIngressRule> ingress, io.fabric8.kubernetes.api.model.LabelSelector podSelector, List<String> policyTypes) {
        super();
        this.egress = egress;
        this.ingress = ingress;
        this.podSelector = podSelector;
        this.policyTypes = policyTypes;
    }

    @JsonProperty("egress")
    public List<NetworkPolicyEgressRule> getEgress() {
        return egress;
    }

    @JsonProperty("egress")
    public void setEgress(List<NetworkPolicyEgressRule> egress) {
        this.egress = egress;
    }

    @JsonProperty("ingress")
    public List<NetworkPolicyIngressRule> getIngress() {
        return ingress;
    }

    @JsonProperty("ingress")
    public void setIngress(List<NetworkPolicyIngressRule> ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("podSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getPodSelector() {
        return podSelector;
    }

    @JsonProperty("podSelector")
    public void setPodSelector(io.fabric8.kubernetes.api.model.LabelSelector podSelector) {
        this.podSelector = podSelector;
    }

    @JsonProperty("policyTypes")
    public List<String> getPolicyTypes() {
        return policyTypes;
    }

    @JsonProperty("policyTypes")
    public void setPolicyTypes(List<String> policyTypes) {
        this.policyTypes = policyTypes;
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
