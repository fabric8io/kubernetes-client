
package io.fabric8.certmanager.api.model.v1;

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
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuer;
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
 * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acme",
    "ca",
    "selfSigned",
    "vault",
    "venafi"
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
public class IssuerSpec implements Editable<IssuerSpecBuilder>, KubernetesResource
{

    @JsonProperty("acme")
    private ACMEIssuer acme;
    @JsonProperty("ca")
    private CAIssuer ca;
    @JsonProperty("selfSigned")
    private SelfSignedIssuer selfSigned;
    @JsonProperty("vault")
    private VaultIssuer vault;
    @JsonProperty("venafi")
    private VenafiIssuer venafi;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IssuerSpec() {
    }

    public IssuerSpec(ACMEIssuer acme, CAIssuer ca, SelfSignedIssuer selfSigned, VaultIssuer vault, VenafiIssuer venafi) {
        super();
        this.acme = acme;
        this.ca = ca;
        this.selfSigned = selfSigned;
        this.vault = vault;
        this.venafi = venafi;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("acme")
    public ACMEIssuer getAcme() {
        return acme;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("acme")
    public void setAcme(ACMEIssuer acme) {
        this.acme = acme;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("ca")
    public CAIssuer getCa() {
        return ca;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("ca")
    public void setCa(CAIssuer ca) {
        this.ca = ca;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("selfSigned")
    public SelfSignedIssuer getSelfSigned() {
        return selfSigned;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("selfSigned")
    public void setSelfSigned(SelfSignedIssuer selfSigned) {
        this.selfSigned = selfSigned;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("vault")
    public VaultIssuer getVault() {
        return vault;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("vault")
    public void setVault(VaultIssuer vault) {
        this.vault = vault;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("venafi")
    public VenafiIssuer getVenafi() {
        return venafi;
    }

    /**
     * IssuerSpec is the specification of an Issuer. This includes any configuration required for the issuer.
     */
    @JsonProperty("venafi")
    public void setVenafi(VenafiIssuer venafi) {
        this.venafi = venafi;
    }

    @JsonIgnore
    public IssuerSpecBuilder edit() {
        return new IssuerSpecBuilder(this);
    }

    @JsonIgnore
    public IssuerSpecBuilder toBuilder() {
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
        if (!(o instanceof IssuerSpec)) {
            return false;
        }
        IssuerSpec other = (IssuerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$acme = this.getAcme();
        Object other$acme = other.getAcme();
        if (this$acme == null ? other$acme != null : !this$acme.equals(other$acme)) {
            return false;
        }
        Object this$ca = this.getCa();
        Object other$ca = other.getCa();
        if (this$ca == null ? other$ca != null : !this$ca.equals(other$ca)) {
            return false;
        }
        Object this$selfSigned = this.getSelfSigned();
        Object other$selfSigned = other.getSelfSigned();
        if (this$selfSigned == null ? other$selfSigned != null : !this$selfSigned.equals(other$selfSigned)) {
            return false;
        }
        Object this$vault = this.getVault();
        Object other$vault = other.getVault();
        if (this$vault == null ? other$vault != null : !this$vault.equals(other$vault)) {
            return false;
        }
        Object this$venafi = this.getVenafi();
        Object other$venafi = other.getVenafi();
        if (this$venafi == null ? other$venafi != null : !this$venafi.equals(other$venafi)) {
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
        return other instanceof IssuerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $acme = this.getAcme();
        result = result * prime + ($acme == null ? 43 : $acme.hashCode());
        Object $ca = this.getCa();
        result = result * prime + ($ca == null ? 43 : $ca.hashCode());
        Object $selfSigned = this.getSelfSigned();
        result = result * prime + ($selfSigned == null ? 43 : $selfSigned.hashCode());
        Object $vault = this.getVault();
        result = result * prime + ($vault == null ? 43 : $vault.hashCode());
        Object $venafi = this.getVenafi();
        result = result * prime + ($venafi == null ? 43 : $venafi.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IssuerSpec(" + "acme=" + this.getAcme() + ", ca=" + this.getCa() + ", selfSigned=" + this.getSelfSigned() + ", vault=" + this.getVault() + ", venafi=" + this.getVenafi() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
