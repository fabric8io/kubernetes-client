
package io.fabric8.knative.internal.networking.v1alpha1;

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

/**
 * CertificateSpec defines the desired state of a `Certificate`.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dnsNames",
    "domain",
    "secretName"
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
public class CertificateSpec implements Editable<CertificateSpecBuilder>, KubernetesResource
{

    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsNames = new ArrayList<>();
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("secretName")
    private String secretName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateSpec() {
    }

    public CertificateSpec(List<String> dnsNames, String domain, String secretName) {
        super();
        this.dnsNames = dnsNames;
        this.domain = domain;
        this.secretName = secretName;
    }

    /**
     * DNSNames is a list of DNS names the Certificate could support. The wildcard format of DNSNames (e.g. &#42;.default.example.com) is supported.
     */
    @JsonProperty("dnsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDnsNames() {
        return dnsNames;
    }

    /**
     * DNSNames is a list of DNS names the Certificate could support. The wildcard format of DNSNames (e.g. &#42;.default.example.com) is supported.
     */
    @JsonProperty("dnsNames")
    public void setDnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
    }

    /**
     * Domain is the top level domain of the values for DNSNames.
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * Domain is the top level domain of the values for DNSNames.
     */
    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * SecretName is the name of the secret resource to store the SSL certificate in.
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * SecretName is the name of the secret resource to store the SSL certificate in.
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonIgnore
    public CertificateSpecBuilder edit() {
        return new CertificateSpecBuilder(this);
    }

    @JsonIgnore
    public CertificateSpecBuilder toBuilder() {
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
        if (!(o instanceof CertificateSpec)) {
            return false;
        }
        CertificateSpec other = (CertificateSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dnsNames = this.getDnsNames();
        Object other$dnsNames = other.getDnsNames();
        if (this$dnsNames == null ? other$dnsNames != null : !this$dnsNames.equals(other$dnsNames)) {
            return false;
        }
        Object this$domain = this.getDomain();
        Object other$domain = other.getDomain();
        if (this$domain == null ? other$domain != null : !this$domain.equals(other$domain)) {
            return false;
        }
        Object this$secretName = this.getSecretName();
        Object other$secretName = other.getSecretName();
        if (this$secretName == null ? other$secretName != null : !this$secretName.equals(other$secretName)) {
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
        return other instanceof CertificateSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dnsNames = this.getDnsNames();
        result = result * prime + ($dnsNames == null ? 43 : $dnsNames.hashCode());
        Object $domain = this.getDomain();
        result = result * prime + ($domain == null ? 43 : $domain.hashCode());
        Object $secretName = this.getSecretName();
        result = result * prime + ($secretName == null ? 43 : $secretName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertificateSpec(" + "dnsNames=" + this.getDnsNames() + ", domain=" + this.getDomain() + ", secretName=" + this.getSecretName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
