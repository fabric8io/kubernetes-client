
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
 * PKCS12 configures options for storing a PKCS12 keystore in the `spec.secretName` Secret resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "create",
    "password",
    "passwordSecretRef",
    "profile"
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
public class PKCS12Keystore implements Editable<PKCS12KeystoreBuilder>, KubernetesResource
{

    @JsonProperty("create")
    private Boolean create;
    @JsonProperty("password")
    private String password;
    @JsonProperty("passwordSecretRef")
    private SecretKeySelector passwordSecretRef;
    @JsonProperty("profile")
    private String profile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PKCS12Keystore() {
    }

    public PKCS12Keystore(Boolean create, String password, SecretKeySelector passwordSecretRef, String profile) {
        super();
        this.create = create;
        this.password = password;
        this.passwordSecretRef = passwordSecretRef;
        this.profile = profile;
    }

    /**
     * Create enables PKCS12 keystore creation for the Certificate. If true, a file named `keystore.p12` will be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` or in `password`. The keystore file will be updated immediately. If the issuer provided a CA certificate, a file named `truststore.p12` will also be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` containing the issuing Certificate Authority
     */
    @JsonProperty("create")
    public Boolean getCreate() {
        return create;
    }

    /**
     * Create enables PKCS12 keystore creation for the Certificate. If true, a file named `keystore.p12` will be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` or in `password`. The keystore file will be updated immediately. If the issuer provided a CA certificate, a file named `truststore.p12` will also be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` containing the issuing Certificate Authority
     */
    @JsonProperty("create")
    public void setCreate(Boolean create) {
        this.create = create;
    }

    /**
     * Password provides a literal password used to encrypt the PKCS#12 keystore. Mutually exclusive with passwordSecretRef. One of password or passwordSecretRef must provide a password with a non-zero length.
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Password provides a literal password used to encrypt the PKCS#12 keystore. Mutually exclusive with passwordSecretRef. One of password or passwordSecretRef must provide a password with a non-zero length.
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * PKCS12 configures options for storing a PKCS12 keystore in the `spec.secretName` Secret resource.
     */
    @JsonProperty("passwordSecretRef")
    public SecretKeySelector getPasswordSecretRef() {
        return passwordSecretRef;
    }

    /**
     * PKCS12 configures options for storing a PKCS12 keystore in the `spec.secretName` Secret resource.
     */
    @JsonProperty("passwordSecretRef")
    public void setPasswordSecretRef(SecretKeySelector passwordSecretRef) {
        this.passwordSecretRef = passwordSecretRef;
    }

    /**
     * Profile specifies the key and certificate encryption algorithms and the HMAC algorithm used to create the PKCS12 keystore. Default value is `LegacyRC2` for backward compatibility.<br><p> <br><p> If provided, allowed values are: `LegacyRC2`: Deprecated. Not supported by default in OpenSSL 3 or Java 20. `LegacyDES`: Less secure algorithm. Use this option for maximal compatibility. `Modern2023`: Secure algorithm. Use this option in case you have to always use secure algorithms (e.g., because of company policy). Please note that the security of the algorithm is not that important in reality, because the unencrypted certificate and private key are also stored in the Secret.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * Profile specifies the key and certificate encryption algorithms and the HMAC algorithm used to create the PKCS12 keystore. Default value is `LegacyRC2` for backward compatibility.<br><p> <br><p> If provided, allowed values are: `LegacyRC2`: Deprecated. Not supported by default in OpenSSL 3 or Java 20. `LegacyDES`: Less secure algorithm. Use this option for maximal compatibility. `Modern2023`: Secure algorithm. Use this option in case you have to always use secure algorithms (e.g., because of company policy). Please note that the security of the algorithm is not that important in reality, because the unencrypted certificate and private key are also stored in the Secret.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonIgnore
    public PKCS12KeystoreBuilder edit() {
        return new PKCS12KeystoreBuilder(this);
    }

    @JsonIgnore
    public PKCS12KeystoreBuilder toBuilder() {
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
