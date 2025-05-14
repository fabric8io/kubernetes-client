
package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Condition;
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
 * DNSNameResolverResolvedName describes the details of a resolved DNS name.
 */
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DNSNameResolverResolvedName implements Editable<DNSNameResolverResolvedNameBuilder>, KubernetesResource
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

    /**
     * conditions provide information about the state of the DNS name. Known .status.conditions.type is: "Degraded". "Degraded" is true when the last resolution failed for the DNS name, and false otherwise.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions provide information about the state of the DNS name. Known .status.conditions.type is: "Degraded". "Degraded" is true when the last resolution failed for the DNS name, and false otherwise.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * dnsName is the resolved DNS name matching the name field of DNSNameResolverSpec. This field can store both regular and wildcard DNS names which match the spec.name field. When the spec.name field contains a regular DNS name, this field will store the same regular DNS name after it is successfully resolved. When the spec.name field contains a wildcard DNS name, each resolvedName.dnsName will store the regular DNS names which match the wildcard DNS name and have been successfully resolved. If the wildcard DNS name can also be successfully resolved, then this field will store the wildcard DNS name as well.
     */
    @JsonProperty("dnsName")
    public String getDnsName() {
        return dnsName;
    }

    /**
     * dnsName is the resolved DNS name matching the name field of DNSNameResolverSpec. This field can store both regular and wildcard DNS names which match the spec.name field. When the spec.name field contains a regular DNS name, this field will store the same regular DNS name after it is successfully resolved. When the spec.name field contains a wildcard DNS name, each resolvedName.dnsName will store the regular DNS names which match the wildcard DNS name and have been successfully resolved. If the wildcard DNS name can also be successfully resolved, then this field will store the wildcard DNS name as well.
     */
    @JsonProperty("dnsName")
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    /**
     * resolutionFailures keeps the count of how many consecutive times the DNS resolution failed for the dnsName. If the DNS resolution succeeds then the field will be set to zero. Upon every failure, the value of the field will be incremented by one. The details about the DNS name will be removed, if the value of resolutionFailures reaches 5 and the TTL of all the associated IP addresses have expired.
     */
    @JsonProperty("resolutionFailures")
    public Integer getResolutionFailures() {
        return resolutionFailures;
    }

    /**
     * resolutionFailures keeps the count of how many consecutive times the DNS resolution failed for the dnsName. If the DNS resolution succeeds then the field will be set to zero. Upon every failure, the value of the field will be incremented by one. The details about the DNS name will be removed, if the value of resolutionFailures reaches 5 and the TTL of all the associated IP addresses have expired.
     */
    @JsonProperty("resolutionFailures")
    public void setResolutionFailures(Integer resolutionFailures) {
        this.resolutionFailures = resolutionFailures;
    }

    /**
     * resolvedAddresses gives the list of associated IP addresses and their corresponding TTLs and last lookup times for the dnsName.
     */
    @JsonProperty("resolvedAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSNameResolverResolvedAddress> getResolvedAddresses() {
        return resolvedAddresses;
    }

    /**
     * resolvedAddresses gives the list of associated IP addresses and their corresponding TTLs and last lookup times for the dnsName.
     */
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

}
