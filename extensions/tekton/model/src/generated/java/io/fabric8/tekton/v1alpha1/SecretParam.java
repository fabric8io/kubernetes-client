
package io.fabric8.tekton.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SecretParam indicates which secret can be used to populate a field of the resource<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fieldName",
    "secretKey",
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
public class SecretParam implements Editable<SecretParamBuilder>, KubernetesResource
{

    @JsonProperty("fieldName")
    private String fieldName;
    @JsonProperty("secretKey")
    private String secretKey;
    @JsonProperty("secretName")
    private String secretName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecretParam() {
    }

    public SecretParam(String fieldName, String secretKey, String secretName) {
        super();
        this.fieldName = fieldName;
        this.secretKey = secretKey;
        this.secretName = secretName;
    }

    /**
     * SecretParam indicates which secret can be used to populate a field of the resource<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("fieldName")
    public String getFieldName() {
        return fieldName;
    }

    /**
     * SecretParam indicates which secret can be used to populate a field of the resource<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("fieldName")
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * SecretParam indicates which secret can be used to populate a field of the resource<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("secretKey")
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * SecretParam indicates which secret can be used to populate a field of the resource<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("secretKey")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * SecretParam indicates which secret can be used to populate a field of the resource<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * SecretParam indicates which secret can be used to populate a field of the resource<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonIgnore
    public SecretParamBuilder edit() {
        return new SecretParamBuilder(this);
    }

    @JsonIgnore
    public SecretParamBuilder toBuilder() {
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
        if (!(o instanceof SecretParam)) {
            return false;
        }
        SecretParam other = (SecretParam) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fieldName = this.getFieldName();
        Object other$fieldName = other.getFieldName();
        if (this$fieldName == null ? other$fieldName != null : !this$fieldName.equals(other$fieldName)) {
            return false;
        }
        Object this$secretKey = this.getSecretKey();
        Object other$secretKey = other.getSecretKey();
        if (this$secretKey == null ? other$secretKey != null : !this$secretKey.equals(other$secretKey)) {
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
        return other instanceof SecretParam;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fieldName = this.getFieldName();
        result = result * prime + ($fieldName == null ? 43 : $fieldName.hashCode());
        Object $secretKey = this.getSecretKey();
        result = result * prime + ($secretKey == null ? 43 : $secretKey.hashCode());
        Object $secretName = this.getSecretName();
        result = result * prime + ($secretName == null ? 43 : $secretName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecretParam(" + "fieldName=" + this.getFieldName() + ", secretKey=" + this.getSecretKey() + ", secretName=" + this.getSecretName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
