
package io.fabric8.certmanager.api.model.v1;

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
    "dnsDomains",
    "emailAddresses",
    "ipRanges",
    "uriDomains"
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
public class NameConstraintItem implements Editable<NameConstraintItemBuilder>, KubernetesResource
{

    @JsonProperty("dnsDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsDomains = new ArrayList<>();
    @JsonProperty("emailAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> emailAddresses = new ArrayList<>();
    @JsonProperty("ipRanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipRanges = new ArrayList<>();
    @JsonProperty("uriDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> uriDomains = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NameConstraintItem() {
    }

    public NameConstraintItem(List<String> dnsDomains, List<String> emailAddresses, List<String> ipRanges, List<String> uriDomains) {
        super();
        this.dnsDomains = dnsDomains;
        this.emailAddresses = emailAddresses;
        this.ipRanges = ipRanges;
        this.uriDomains = uriDomains;
    }

    /**
     * DNSDomains is a list of DNS domains that are permitted or excluded.
     */
    @JsonProperty("dnsDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDnsDomains() {
        return dnsDomains;
    }

    /**
     * DNSDomains is a list of DNS domains that are permitted or excluded.
     */
    @JsonProperty("dnsDomains")
    public void setDnsDomains(List<String> dnsDomains) {
        this.dnsDomains = dnsDomains;
    }

    /**
     * EmailAddresses is a list of Email Addresses that are permitted or excluded.
     */
    @JsonProperty("emailAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    /**
     * EmailAddresses is a list of Email Addresses that are permitted or excluded.
     */
    @JsonProperty("emailAddresses")
    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    /**
     * IPRanges is a list of IP Ranges that are permitted or excluded. This should be a valid CIDR notation.
     */
    @JsonProperty("ipRanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpRanges() {
        return ipRanges;
    }

    /**
     * IPRanges is a list of IP Ranges that are permitted or excluded. This should be a valid CIDR notation.
     */
    @JsonProperty("ipRanges")
    public void setIpRanges(List<String> ipRanges) {
        this.ipRanges = ipRanges;
    }

    /**
     * URIDomains is a list of URI domains that are permitted or excluded.
     */
    @JsonProperty("uriDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUriDomains() {
        return uriDomains;
    }

    /**
     * URIDomains is a list of URI domains that are permitted or excluded.
     */
    @JsonProperty("uriDomains")
    public void setUriDomains(List<String> uriDomains) {
        this.uriDomains = uriDomains;
    }

    @JsonIgnore
    public NameConstraintItemBuilder edit() {
        return new NameConstraintItemBuilder(this);
    }

    @JsonIgnore
    public NameConstraintItemBuilder toBuilder() {
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
