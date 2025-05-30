
package io.fabric8.certmanager.api.model.acme.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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

/**
 * ACMEIssuerDNS01ProviderRFC2136 is a structure containing the configuration for RFC2136 DNS
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nameserver",
    "tsigAlgorithm",
    "tsigKeyName",
    "tsigSecretSecretRef"
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
public class ACMEIssuerDNS01ProviderRFC2136 implements Editable<ACMEIssuerDNS01ProviderRFC2136Builder>, KubernetesResource
{

    @JsonProperty("nameserver")
    private String nameserver;
    @JsonProperty("tsigAlgorithm")
    private String tsigAlgorithm;
    @JsonProperty("tsigKeyName")
    private String tsigKeyName;
    @JsonProperty("tsigSecretSecretRef")
    private SecretKeySelector tsigSecretSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderRFC2136() {
    }

    public ACMEIssuerDNS01ProviderRFC2136(String nameserver, String tsigAlgorithm, String tsigKeyName, SecretKeySelector tsigSecretSecretRef) {
        super();
        this.nameserver = nameserver;
        this.tsigAlgorithm = tsigAlgorithm;
        this.tsigKeyName = tsigKeyName;
        this.tsigSecretSecretRef = tsigSecretSecretRef;
    }

    /**
     * The IP address or hostname of an authoritative DNS server supporting RFC2136 in the form host:port. If the host is an IPv6 address it must be enclosed in square brackets (e.g [2001:db8::1]) ; port is optional. This field is required.
     */
    @JsonProperty("nameserver")
    public String getNameserver() {
        return nameserver;
    }

    /**
     * The IP address or hostname of an authoritative DNS server supporting RFC2136 in the form host:port. If the host is an IPv6 address it must be enclosed in square brackets (e.g [2001:db8::1]) ; port is optional. This field is required.
     */
    @JsonProperty("nameserver")
    public void setNameserver(String nameserver) {
        this.nameserver = nameserver;
    }

    /**
     * The TSIG Algorithm configured in the DNS supporting RFC2136. Used only when ``tsigSecretSecretRef`` and ``tsigKeyName`` are defined. Supported values are (case-insensitive): ``HMACMD5`` (default), ``HMACSHA1``, ``HMACSHA256`` or ``HMACSHA512``.
     */
    @JsonProperty("tsigAlgorithm")
    public String getTsigAlgorithm() {
        return tsigAlgorithm;
    }

    /**
     * The TSIG Algorithm configured in the DNS supporting RFC2136. Used only when ``tsigSecretSecretRef`` and ``tsigKeyName`` are defined. Supported values are (case-insensitive): ``HMACMD5`` (default), ``HMACSHA1``, ``HMACSHA256`` or ``HMACSHA512``.
     */
    @JsonProperty("tsigAlgorithm")
    public void setTsigAlgorithm(String tsigAlgorithm) {
        this.tsigAlgorithm = tsigAlgorithm;
    }

    /**
     * The TSIG Key name configured in the DNS. If ``tsigSecretSecretRef`` is defined, this field is required.
     */
    @JsonProperty("tsigKeyName")
    public String getTsigKeyName() {
        return tsigKeyName;
    }

    /**
     * The TSIG Key name configured in the DNS. If ``tsigSecretSecretRef`` is defined, this field is required.
     */
    @JsonProperty("tsigKeyName")
    public void setTsigKeyName(String tsigKeyName) {
        this.tsigKeyName = tsigKeyName;
    }

    /**
     * ACMEIssuerDNS01ProviderRFC2136 is a structure containing the configuration for RFC2136 DNS
     */
    @JsonProperty("tsigSecretSecretRef")
    public SecretKeySelector getTsigSecretSecretRef() {
        return tsigSecretSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderRFC2136 is a structure containing the configuration for RFC2136 DNS
     */
    @JsonProperty("tsigSecretSecretRef")
    public void setTsigSecretSecretRef(SecretKeySelector tsigSecretSecretRef) {
        this.tsigSecretSecretRef = tsigSecretSecretRef;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderRFC2136Builder edit() {
        return new ACMEIssuerDNS01ProviderRFC2136Builder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderRFC2136Builder toBuilder() {
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
