
package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Condition;
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
    "conditions",
    "dnsName",
    "resolutionFailures",
    "resolvedAddresses"
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
public class DNSNameResolverResolvedName implements Editable<DNSNameResolverResolvedNameBuilder> , KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("dnsName")
    private String dnsName;
    @JsonProperty("resolutionFailures")
    private Integer resolutionFailures;
    @JsonProperty("resolvedAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DNSNameResolverResolvedAddress> resolvedAddresses = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DNSNameResolverResolvedName() {
    }

    public DNSNameResolverResolvedName(List<Condition> conditions, String dnsName, Integer resolutionFailures, List<DNSNameResolverResolvedAddress> resolvedAddresses) {
        super();
        this.conditions = conditions;
        this.dnsName = dnsName;
        this.resolutionFailures = resolutionFailures;
        this.resolvedAddresses = resolvedAddresses;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("dnsName")
    public String getDnsName() {
        return dnsName;
    }

    @JsonProperty("dnsName")
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    @JsonProperty("resolutionFailures")
    public Integer getResolutionFailures() {
        return resolutionFailures;
    }

    @JsonProperty("resolutionFailures")
    public void setResolutionFailures(Integer resolutionFailures) {
        this.resolutionFailures = resolutionFailures;
    }

    @JsonProperty("resolvedAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSNameResolverResolvedAddress> getResolvedAddresses() {
        return resolvedAddresses;
    }

    @JsonProperty("resolvedAddresses")
    public void setResolvedAddresses(List<DNSNameResolverResolvedAddress> resolvedAddresses) {
        this.resolvedAddresses = resolvedAddresses;
    }

    @JsonIgnore
    public DNSNameResolverResolvedNameBuilder edit() {
        return new DNSNameResolverResolvedNameBuilder(this);
    }

    @JsonIgnore
    public DNSNameResolverResolvedNameBuilder toBuilder() {
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
