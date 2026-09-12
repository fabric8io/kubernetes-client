
package io.fabric8.openclustermanagement.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authType",
    "awsIrsa"
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
public class RegistrationDriver implements Editable<RegistrationDriverBuilder>, KubernetesResource
{

    @JsonProperty("authType")
    private String authType;
    @JsonProperty("awsIrsa")
    private AwsIrsa awsIrsa;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RegistrationDriver() {
    }

    public RegistrationDriver(String authType, AwsIrsa awsIrsa) {
        super();
        this.authType = authType;
        this.awsIrsa = awsIrsa;
    }

    /**
     * Type of the authentication used by managedcluster to register as well as pull work from hub. Possible values are csr and awsirsa.
     */
    @JsonProperty("authType")
    public String getAuthType() {
        return authType;
    }

    /**
     * Type of the authentication used by managedcluster to register as well as pull work from hub. Possible values are csr and awsirsa.
     */
    @JsonProperty("authType")
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @JsonProperty("awsIrsa")
    public AwsIrsa getAwsIrsa() {
        return awsIrsa;
    }

    @JsonProperty("awsIrsa")
    public void setAwsIrsa(AwsIrsa awsIrsa) {
        this.awsIrsa = awsIrsa;
    }

    @JsonIgnore
    public RegistrationDriverBuilder edit() {
        return new RegistrationDriverBuilder(this);
    }

    @JsonIgnore
    public RegistrationDriverBuilder toBuilder() {
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
        if (!(o instanceof RegistrationDriver)) {
            return false;
        }
        RegistrationDriver other = (RegistrationDriver) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authType = this.getAuthType();
        Object other$authType = other.getAuthType();
        if (this$authType == null ? other$authType != null : !this$authType.equals(other$authType)) {
            return false;
        }
        Object this$awsIrsa = this.getAwsIrsa();
        Object other$awsIrsa = other.getAwsIrsa();
        if (this$awsIrsa == null ? other$awsIrsa != null : !this$awsIrsa.equals(other$awsIrsa)) {
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
        return other instanceof RegistrationDriver;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authType = this.getAuthType();
        result = result * prime + ($authType == null ? 43 : $authType.hashCode());
        Object $awsIrsa = this.getAwsIrsa();
        result = result * prime + ($awsIrsa == null ? 43 : $awsIrsa.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationDriver(" + "authType=" + this.getAuthType() + ", awsIrsa=" + this.getAwsIrsa() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
