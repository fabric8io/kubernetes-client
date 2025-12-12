
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
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

/**
 * PolicyRootOfTrust defines the root of trust based on the selected policyType.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fulcioCAWithRekor",
    "pki",
    "policyType",
    "publicKey"
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
public class PolicyRootOfTrust implements Editable<PolicyRootOfTrustBuilder>, KubernetesResource
{

    @JsonProperty("fulcioCAWithRekor")
    private FulcioCAWithRekor fulcioCAWithRekor;
    @JsonProperty("pki")
    private PKI pki;
    @JsonProperty("policyType")
    private String policyType;
    @JsonProperty("publicKey")
    private PublicKey publicKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyRootOfTrust() {
    }

    public PolicyRootOfTrust(FulcioCAWithRekor fulcioCAWithRekor, PKI pki, String policyType, PublicKey publicKey) {
        super();
        this.fulcioCAWithRekor = fulcioCAWithRekor;
        this.pki = pki;
        this.policyType = policyType;
        this.publicKey = publicKey;
    }

    /**
     * PolicyRootOfTrust defines the root of trust based on the selected policyType.
     */
    @JsonProperty("fulcioCAWithRekor")
    public FulcioCAWithRekor getFulcioCAWithRekor() {
        return fulcioCAWithRekor;
    }

    /**
     * PolicyRootOfTrust defines the root of trust based on the selected policyType.
     */
    @JsonProperty("fulcioCAWithRekor")
    public void setFulcioCAWithRekor(FulcioCAWithRekor fulcioCAWithRekor) {
        this.fulcioCAWithRekor = fulcioCAWithRekor;
    }

    /**
     * PolicyRootOfTrust defines the root of trust based on the selected policyType.
     */
    @JsonProperty("pki")
    public PKI getPki() {
        return pki;
    }

    /**
     * PolicyRootOfTrust defines the root of trust based on the selected policyType.
     */
    @JsonProperty("pki")
    public void setPki(PKI pki) {
        this.pki = pki;
    }

    /**
     * policyType is a required field specifies the type of the policy for verification. This field must correspond to how the policy was generated. Allowed values are "PublicKey", "FulcioCAWithRekor", and "PKI". When set to "PublicKey", the policy relies on a sigstore publicKey and may optionally use a Rekor verification. When set to "FulcioCAWithRekor", the policy is based on the Fulcio certification and incorporates a Rekor verification. When set to "PKI", the policy is based on the certificates from Bring Your Own Public Key Infrastructure (BYOPKI). This value is enabled by turning on the SigstoreImageVerificationPKI feature gate.
     */
    @JsonProperty("policyType")
    public String getPolicyType() {
        return policyType;
    }

    /**
     * policyType is a required field specifies the type of the policy for verification. This field must correspond to how the policy was generated. Allowed values are "PublicKey", "FulcioCAWithRekor", and "PKI". When set to "PublicKey", the policy relies on a sigstore publicKey and may optionally use a Rekor verification. When set to "FulcioCAWithRekor", the policy is based on the Fulcio certification and incorporates a Rekor verification. When set to "PKI", the policy is based on the certificates from Bring Your Own Public Key Infrastructure (BYOPKI). This value is enabled by turning on the SigstoreImageVerificationPKI feature gate.
     */
    @JsonProperty("policyType")
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    /**
     * PolicyRootOfTrust defines the root of trust based on the selected policyType.
     */
    @JsonProperty("publicKey")
    public PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * PolicyRootOfTrust defines the root of trust based on the selected policyType.
     */
    @JsonProperty("publicKey")
    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    @JsonIgnore
    public PolicyRootOfTrustBuilder edit() {
        return new PolicyRootOfTrustBuilder(this);
    }

    @JsonIgnore
    public PolicyRootOfTrustBuilder toBuilder() {
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
