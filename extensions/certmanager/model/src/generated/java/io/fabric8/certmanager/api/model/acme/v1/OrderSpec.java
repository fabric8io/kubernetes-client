
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
import io.fabric8.certmanager.api.model.meta.v1.ObjectReference;
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
    "commonName",
    "dnsNames",
    "duration",
    "ipAddresses",
    "issuerRef",
    "request"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
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
    private ObjectReference issuerRef;
    @JsonProperty("request")
    private String request;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OrderSpec() {
    }

    public OrderSpec(String commonName, List<String> dnsNames, Duration duration, List<String> ipAddresses, ObjectReference issuerRef, String request) {
        super();
        this.commonName = commonName;
        this.dnsNames = dnsNames;
        this.duration = duration;
        this.ipAddresses = ipAddresses;
        this.issuerRef = issuerRef;
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
    public ObjectReference getIssuerRef() {
        return issuerRef;
    }

    @JsonProperty("issuerRef")
    public void setIssuerRef(ObjectReference issuerRef) {
        this.issuerRef = issuerRef;
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

}
