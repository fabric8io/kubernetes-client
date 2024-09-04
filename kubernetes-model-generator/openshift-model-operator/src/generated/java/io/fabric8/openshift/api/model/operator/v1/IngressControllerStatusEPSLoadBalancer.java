
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
    "allowedSourceRanges",
    "dnsManagementPolicy",
    "providerParameters",
    "scope"
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
public class IngressControllerStatusEPSLoadBalancer implements Editable<IngressControllerStatusEPSLoadBalancerBuilder> , KubernetesResource
{

    @JsonProperty("allowedSourceRanges")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object allowedSourceRanges;
    @JsonProperty("dnsManagementPolicy")
    private String dnsManagementPolicy;
    @JsonProperty("providerParameters")
    private IngressControllerStatusEPSLBProviderParameters providerParameters;
    @JsonProperty("scope")
    private String scope;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerStatusEPSLoadBalancer() {
    }

    public IngressControllerStatusEPSLoadBalancer(Object allowedSourceRanges, String dnsManagementPolicy, IngressControllerStatusEPSLBProviderParameters providerParameters, String scope) {
        super();
        this.allowedSourceRanges = allowedSourceRanges;
        this.dnsManagementPolicy = dnsManagementPolicy;
        this.providerParameters = providerParameters;
        this.scope = scope;
    }

    @JsonProperty("allowedSourceRanges")
    public Object getAllowedSourceRanges() {
        return allowedSourceRanges;
    }

    @JsonProperty("allowedSourceRanges")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setAllowedSourceRanges(Object allowedSourceRanges) {
        this.allowedSourceRanges = allowedSourceRanges;
    }

    @JsonProperty("dnsManagementPolicy")
    public String getDnsManagementPolicy() {
        return dnsManagementPolicy;
    }

    @JsonProperty("dnsManagementPolicy")
    public void setDnsManagementPolicy(String dnsManagementPolicy) {
        this.dnsManagementPolicy = dnsManagementPolicy;
    }

    @JsonProperty("providerParameters")
    public IngressControllerStatusEPSLBProviderParameters getProviderParameters() {
        return providerParameters;
    }

    @JsonProperty("providerParameters")
    public void setProviderParameters(IngressControllerStatusEPSLBProviderParameters providerParameters) {
        this.providerParameters = providerParameters;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonIgnore
    public IngressControllerStatusEPSLoadBalancerBuilder edit() {
        return new IngressControllerStatusEPSLoadBalancerBuilder(this);
    }

    @JsonIgnore
    public IngressControllerStatusEPSLoadBalancerBuilder toBuilder() {
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
