
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.IssuerReference;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
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
    "commonName",
    "dnsNames",
    "duration",
    "ipAddresses",
    "issuerRef",
    "profile",
    "request"
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
public class OrderSpec implements Editable<OrderSpecBuilder>, KubernetesResource
{

    @JsonProperty("commonName")
    private String commonName;
    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsNames = new ArrayList<>();
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("ipAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipAddresses = new ArrayList<>();
    @JsonProperty("issuerRef")
    private IssuerReference issuerRef;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("request")
    private String request;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OrderSpec() {
    }

    public OrderSpec(String commonName, List<String> dnsNames, Duration duration, List<String> ipAddresses, IssuerReference issuerRef, String profile, String request) {
        super();
        this.commonName = commonName;
        this.dnsNames = dnsNames;
        this.duration = duration;
        this.ipAddresses = ipAddresses;
        this.issuerRef = issuerRef;
        this.profile = profile;
        this.request = request;
    }

    /**
     * CommonName is the common name as specified on the DER encoded CSR. If specified, this value must also be present in `dnsNames` or `ipAddresses`. This field must match the corresponding field on the DER encoded CSR.
     */
    @JsonProperty("commonName")
    public String getCommonName() {
        return commonName;
    }

    /**
     * CommonName is the common name as specified on the DER encoded CSR. If specified, this value must also be present in `dnsNames` or `ipAddresses`. This field must match the corresponding field on the DER encoded CSR.
     */
    @JsonProperty("commonName")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * DNSNames is a list of DNS names that should be included as part of the Order validation process. This field must match the corresponding field on the DER encoded CSR.
     */
    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDnsNames() {
        return dnsNames;
    }

    /**
     * DNSNames is a list of DNS names that should be included as part of the Order validation process. This field must match the corresponding field on the DER encoded CSR.
     */
    @JsonProperty("dnsNames")
    public void setDnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
    }

    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * IPAddresses is a list of IP addresses that should be included as part of the Order validation process. This field must match the corresponding field on the DER encoded CSR.
     */
    @JsonProperty("ipAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    /**
     * IPAddresses is a list of IP addresses that should be included as part of the Order validation process. This field must match the corresponding field on the DER encoded CSR.
     */
    @JsonProperty("ipAddresses")
    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @JsonProperty("issuerRef")
    public IssuerReference getIssuerRef() {
        return issuerRef;
    }

    @JsonProperty("issuerRef")
    public void setIssuerRef(IssuerReference issuerRef) {
        this.issuerRef = issuerRef;
    }

    /**
     * Profile allows requesting a certificate profile from the ACME server. Supported profiles are listed by the server's ACME directory URL.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * Profile allows requesting a certificate profile from the ACME server. Supported profiles are listed by the server's ACME directory URL.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Certificate signing request bytes in DER encoding. This will be used when finalizing the order. This field must be set on the order.
     */
    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    /**
     * Certificate signing request bytes in DER encoding. This will be used when finalizing the order. This field must be set on the order.
     */
    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
    }

    @JsonIgnore
    public OrderSpecBuilder edit() {
        return new OrderSpecBuilder(this);
    }

    @JsonIgnore
    public OrderSpecBuilder toBuilder() {
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
        if (!(o instanceof OrderSpec)) {
            return false;
        }
        OrderSpec other = (OrderSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$commonName = this.getCommonName();
        Object other$commonName = other.getCommonName();
        if (this$commonName == null ? other$commonName != null : !this$commonName.equals(other$commonName)) {
            return false;
        }
        Object this$dnsNames = this.getDnsNames();
        Object other$dnsNames = other.getDnsNames();
        if (this$dnsNames == null ? other$dnsNames != null : !this$dnsNames.equals(other$dnsNames)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$ipAddresses = this.getIpAddresses();
        Object other$ipAddresses = other.getIpAddresses();
        if (this$ipAddresses == null ? other$ipAddresses != null : !this$ipAddresses.equals(other$ipAddresses)) {
            return false;
        }
        Object this$issuerRef = this.getIssuerRef();
        Object other$issuerRef = other.getIssuerRef();
        if (this$issuerRef == null ? other$issuerRef != null : !this$issuerRef.equals(other$issuerRef)) {
            return false;
        }
        Object this$profile = this.getProfile();
        Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
            return false;
        }
        Object this$request = this.getRequest();
        Object other$request = other.getRequest();
        if (this$request == null ? other$request != null : !this$request.equals(other$request)) {
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
        return other instanceof OrderSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $commonName = this.getCommonName();
        result = result * prime + ($commonName == null ? 43 : $commonName.hashCode());
        Object $dnsNames = this.getDnsNames();
        result = result * prime + ($dnsNames == null ? 43 : $dnsNames.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $ipAddresses = this.getIpAddresses();
        result = result * prime + ($ipAddresses == null ? 43 : $ipAddresses.hashCode());
        Object $issuerRef = this.getIssuerRef();
        result = result * prime + ($issuerRef == null ? 43 : $issuerRef.hashCode());
        Object $profile = this.getProfile();
        result = result * prime + ($profile == null ? 43 : $profile.hashCode());
        Object $request = this.getRequest();
        result = result * prime + ($request == null ? 43 : $request.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OrderSpec(" + "commonName=" + this.getCommonName() + ", dnsNames=" + this.getDnsNames() + ", duration=" + this.getDuration() + ", ipAddresses=" + this.getIpAddresses() + ", issuerRef=" + this.getIssuerRef() + ", profile=" + this.getProfile() + ", request=" + this.getRequest() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
