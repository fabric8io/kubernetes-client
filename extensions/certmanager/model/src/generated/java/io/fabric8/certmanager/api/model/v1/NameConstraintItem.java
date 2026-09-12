
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dnsDomains",
    "emailAddresses",
    "ipRanges",
    "uriDomains"
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NameConstraintItem)) {
            return false;
        }
        NameConstraintItem other = (NameConstraintItem) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dnsDomains = this.getDnsDomains();
        Object other$dnsDomains = other.getDnsDomains();
        if (this$dnsDomains == null ? other$dnsDomains != null : !this$dnsDomains.equals(other$dnsDomains)) {
            return false;
        }
        Object this$emailAddresses = this.getEmailAddresses();
        Object other$emailAddresses = other.getEmailAddresses();
        if (this$emailAddresses == null ? other$emailAddresses != null : !this$emailAddresses.equals(other$emailAddresses)) {
            return false;
        }
        Object this$ipRanges = this.getIpRanges();
        Object other$ipRanges = other.getIpRanges();
        if (this$ipRanges == null ? other$ipRanges != null : !this$ipRanges.equals(other$ipRanges)) {
            return false;
        }
        Object this$uriDomains = this.getUriDomains();
        Object other$uriDomains = other.getUriDomains();
        if (this$uriDomains == null ? other$uriDomains != null : !this$uriDomains.equals(other$uriDomains)) {
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
        return other instanceof NameConstraintItem;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dnsDomains = this.getDnsDomains();
        result = result * prime + ($dnsDomains == null ? 43 : $dnsDomains.hashCode());
        Object $emailAddresses = this.getEmailAddresses();
        result = result * prime + ($emailAddresses == null ? 43 : $emailAddresses.hashCode());
        Object $ipRanges = this.getIpRanges();
        result = result * prime + ($ipRanges == null ? 43 : $ipRanges.hashCode());
        Object $uriDomains = this.getUriDomains();
        result = result * prime + ($uriDomains == null ? 43 : $uriDomains.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NameConstraintItem(" + "dnsDomains=" + this.getDnsDomains() + ", emailAddresses=" + this.getEmailAddresses() + ", ipRanges=" + this.getIpRanges() + ", uriDomains=" + this.getUriDomains() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
