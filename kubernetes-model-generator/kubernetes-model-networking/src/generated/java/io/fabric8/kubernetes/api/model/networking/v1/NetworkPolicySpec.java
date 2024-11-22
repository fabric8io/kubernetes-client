
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "egress",
    "ingress",
    "podSelector",
    "policyTypes"
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
public class NetworkPolicySpec implements Editable<NetworkPolicySpecBuilder> , KubernetesResource
{

    @JsonProperty("egress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkPolicyEgressRule> egress = new ArrayList<>();
    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkPolicyIngressRule> ingress = new ArrayList<>();
    @JsonProperty("podSelector")
    private LabelSelector podSelector;
    @JsonProperty("policyTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> policyTypes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkPolicySpec() {
    }

    public NetworkPolicySpec(List<NetworkPolicyEgressRule> egress, List<NetworkPolicyIngressRule> ingress, LabelSelector podSelector, List<String> policyTypes) {
        super();
        this.egress = egress;
        this.ingress = ingress;
        this.podSelector = podSelector;
        this.policyTypes = policyTypes;
    }

    @JsonProperty("egress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkPolicyEgressRule> getEgress() {
        return egress;
    }

    @JsonProperty("egress")
    public void setEgress(List<NetworkPolicyEgressRule> egress) {
        this.egress = egress;
    }

    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkPolicyIngressRule> getIngress() {
        return ingress;
    }

    @JsonProperty("ingress")
    public void setIngress(List<NetworkPolicyIngressRule> ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("podSelector")
    public LabelSelector getPodSelector() {
        return podSelector;
    }

    @JsonProperty("podSelector")
    public void setPodSelector(LabelSelector podSelector) {
        this.podSelector = podSelector;
    }

    @JsonProperty("policyTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPolicyTypes() {
        return policyTypes;
    }

    @JsonProperty("policyTypes")
    public void setPolicyTypes(List<String> policyTypes) {
        this.policyTypes = policyTypes;
    }

    @JsonIgnore
    public NetworkPolicySpecBuilder edit() {
        return new NetworkPolicySpecBuilder(this);
    }

    @JsonIgnore
    public NetworkPolicySpecBuilder toBuilder() {
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
