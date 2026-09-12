
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

/**
 * JKS configures options for storing a JKS keystore in the target secret. Either PasswordSecretRef or Password must be provided.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alias",
    "create",
    "password",
    "passwordSecretRef"
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
public class JKSKeystore implements Editable<JKSKeystoreBuilder>, KubernetesResource
{

    @JsonProperty("alias")
    private String alias;
    @JsonProperty("create")
    private Boolean create;
    @JsonProperty("password")
    private String password;
    @JsonProperty("passwordSecretRef")
    private SecretKeySelector passwordSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JKSKeystore() {
    }

    public JKSKeystore(String alias, Boolean create, String password, SecretKeySelector passwordSecretRef) {
        super();
        this.alias = alias;
        this.create = create;
        this.password = password;
        this.passwordSecretRef = passwordSecretRef;
    }

    /**
     * Alias specifies the alias of the key in the keystore, required by the JKS format. If not provided, the default alias `certificate` will be used.
     */
    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    /**
     * Alias specifies the alias of the key in the keystore, required by the JKS format. If not provided, the default alias `certificate` will be used.
     */
    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Create enables JKS keystore creation for the Certificate. If true, a file named `keystore.jks` will be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` or `password`. The keystore file will be updated immediately. If the issuer provided a CA certificate, a file named `truststore.jks` will also be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` containing the issuing Certificate Authority
     */
    @JsonProperty("create")
    public Boolean getCreate() {
        return create;
    }

    /**
     * Create enables JKS keystore creation for the Certificate. If true, a file named `keystore.jks` will be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` or `password`. The keystore file will be updated immediately. If the issuer provided a CA certificate, a file named `truststore.jks` will also be created in the target Secret resource, encrypted using the password stored in `passwordSecretRef` containing the issuing Certificate Authority
     */
    @JsonProperty("create")
    public void setCreate(Boolean create) {
        this.create = create;
    }

    /**
     * Password provides a literal password used to encrypt the JKS keystore. Mutually exclusive with passwordSecretRef. One of password or passwordSecretRef must provide a password with a non-zero length.
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Password provides a literal password used to encrypt the JKS keystore. Mutually exclusive with passwordSecretRef. One of password or passwordSecretRef must provide a password with a non-zero length.
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * JKS configures options for storing a JKS keystore in the target secret. Either PasswordSecretRef or Password must be provided.
     */
    @JsonProperty("passwordSecretRef")
    public SecretKeySelector getPasswordSecretRef() {
        return passwordSecretRef;
    }

    /**
     * JKS configures options for storing a JKS keystore in the target secret. Either PasswordSecretRef or Password must be provided.
     */
    @JsonProperty("passwordSecretRef")
    public void setPasswordSecretRef(SecretKeySelector passwordSecretRef) {
        this.passwordSecretRef = passwordSecretRef;
    }

    @JsonIgnore
    public JKSKeystoreBuilder edit() {
        return new JKSKeystoreBuilder(this);
    }

    @JsonIgnore
    public JKSKeystoreBuilder toBuilder() {
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
        if (!(o instanceof JKSKeystore)) {
            return false;
        }
        JKSKeystore other = (JKSKeystore) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alias = this.getAlias();
        Object other$alias = other.getAlias();
        if (this$alias == null ? other$alias != null : !this$alias.equals(other$alias)) {
            return false;
        }
        Object this$create = this.getCreate();
        Object other$create = other.getCreate();
        if (this$create == null ? other$create != null : !this$create.equals(other$create)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$passwordSecretRef = this.getPasswordSecretRef();
        Object other$passwordSecretRef = other.getPasswordSecretRef();
        if (this$passwordSecretRef == null ? other$passwordSecretRef != null : !this$passwordSecretRef.equals(other$passwordSecretRef)) {
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
        return other instanceof JKSKeystore;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alias = this.getAlias();
        result = result * prime + ($alias == null ? 43 : $alias.hashCode());
        Object $create = this.getCreate();
        result = result * prime + ($create == null ? 43 : $create.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $passwordSecretRef = this.getPasswordSecretRef();
        result = result * prime + ($passwordSecretRef == null ? 43 : $passwordSecretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JKSKeystore(" + "alias=" + this.getAlias() + ", create=" + this.getCreate() + ", password=" + this.getPassword() + ", passwordSecretRef=" + this.getPasswordSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
