
package io.fabric8.certmanager.api.model.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuer;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "acme",
    "ca",
    "selfSigned",
    "vault",
    "venafi"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class IssuerSpec implements KubernetesResource
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IssuerSpec() {
    }

    /**
     * 
     * @param acme
     * @param selfSigned
     * @param venafi
     * @param ca
     * @param vault
     */
    public IssuerSpec(ACMEIssuer acme, CAIssuer ca, SelfSignedIssuer selfSigned, VaultIssuer vault, VenafiIssuer venafi) {
        super();
        this.acme = acme;
        this.ca = ca;
        this.selfSigned = selfSigned;
        this.vault = vault;
        this.venafi = venafi;
    }

    @JsonProperty("acme")
    public ACMEIssuer getAcme() {
        return acme;
    }

    @JsonProperty("acme")
    public void setAcme(ACMEIssuer acme) {
        this.acme = acme;
    }

    @JsonProperty("ca")
    public CAIssuer getCa() {
        return ca;
    }

    @JsonProperty("ca")
    public void setCa(CAIssuer ca) {
        this.ca = ca;
    }

    @JsonProperty("selfSigned")
    public SelfSignedIssuer getSelfSigned() {
        return selfSigned;
    }

    @JsonProperty("selfSigned")
    public void setSelfSigned(SelfSignedIssuer selfSigned) {
        this.selfSigned = selfSigned;
    }

    @JsonProperty("vault")
    public VaultIssuer getVault() {
        return vault;
    }

    @JsonProperty("vault")
    public void setVault(VaultIssuer vault) {
        this.vault = vault;
    }

    @JsonProperty("venafi")
    public VenafiIssuer getVenafi() {
        return venafi;
    }

    @JsonProperty("venafi")
    public void setVenafi(VenafiIssuer venafi) {
        this.venafi = venafi;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
