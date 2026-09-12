
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
    "awsirsa",
    "csr",
    "grpc"
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
public class RegistrationDriverHub implements Editable<RegistrationDriverHubBuilder>, KubernetesResource
{

    @JsonProperty("authType")
    private String authType;
    @JsonProperty("awsirsa")
    private AwsIrsaConfig awsirsa;
    @JsonProperty("csr")
    private CSRConfig csr;
    @JsonProperty("grpc")
    private GRPCRegistrationConfig grpc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RegistrationDriverHub() {
    }

    public RegistrationDriverHub(String authType, AwsIrsaConfig awsirsa, CSRConfig csr, GRPCRegistrationConfig grpc) {
        super();
        this.authType = authType;
        this.awsirsa = awsirsa;
        this.csr = csr;
        this.grpc = grpc;
    }

    /**
     * authType is the type of the authentication used by hub to initialize the Hub cluster. Possible values are csr, awsirsa and grpc.
     */
    @JsonProperty("authType")
    public String getAuthType() {
        return authType;
    }

    /**
     * authType is the type of the authentication used by hub to initialize the Hub cluster. Possible values are csr, awsirsa and grpc.
     */
    @JsonProperty("authType")
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @JsonProperty("awsirsa")
    public AwsIrsaConfig getAwsirsa() {
        return awsirsa;
    }

    @JsonProperty("awsirsa")
    public void setAwsirsa(AwsIrsaConfig awsirsa) {
        this.awsirsa = awsirsa;
    }

    @JsonProperty("csr")
    public CSRConfig getCsr() {
        return csr;
    }

    @JsonProperty("csr")
    public void setCsr(CSRConfig csr) {
        this.csr = csr;
    }

    @JsonProperty("grpc")
    public GRPCRegistrationConfig getGrpc() {
        return grpc;
    }

    @JsonProperty("grpc")
    public void setGrpc(GRPCRegistrationConfig grpc) {
        this.grpc = grpc;
    }

    @JsonIgnore
    public RegistrationDriverHubBuilder edit() {
        return new RegistrationDriverHubBuilder(this);
    }

    @JsonIgnore
    public RegistrationDriverHubBuilder toBuilder() {
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
        if (!(o instanceof RegistrationDriverHub)) {
            return false;
        }
        RegistrationDriverHub other = (RegistrationDriverHub) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authType = this.getAuthType();
        Object other$authType = other.getAuthType();
        if (this$authType == null ? other$authType != null : !this$authType.equals(other$authType)) {
            return false;
        }
        Object this$awsirsa = this.getAwsirsa();
        Object other$awsirsa = other.getAwsirsa();
        if (this$awsirsa == null ? other$awsirsa != null : !this$awsirsa.equals(other$awsirsa)) {
            return false;
        }
        Object this$csr = this.getCsr();
        Object other$csr = other.getCsr();
        if (this$csr == null ? other$csr != null : !this$csr.equals(other$csr)) {
            return false;
        }
        Object this$grpc = this.getGrpc();
        Object other$grpc = other.getGrpc();
        if (this$grpc == null ? other$grpc != null : !this$grpc.equals(other$grpc)) {
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
        return other instanceof RegistrationDriverHub;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authType = this.getAuthType();
        result = result * prime + ($authType == null ? 43 : $authType.hashCode());
        Object $awsirsa = this.getAwsirsa();
        result = result * prime + ($awsirsa == null ? 43 : $awsirsa.hashCode());
        Object $csr = this.getCsr();
        result = result * prime + ($csr == null ? 43 : $csr.hashCode());
        Object $grpc = this.getGrpc();
        result = result * prime + ($grpc == null ? 43 : $grpc.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationDriverHub(" + "authType=" + this.getAuthType() + ", awsirsa=" + this.getAwsirsa() + ", csr=" + this.getCsr() + ", grpc=" + this.getGrpc() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
