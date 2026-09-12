
package io.fabric8.certmanager.api.model.v1;

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
 * ServiceAccountRef is a service account used by cert-manager to request a token. By default two audiences are included: the address of the Vault server as specified on the issuer, and a generated audience taking the form of `vault://namespace-name/issuer-name` for an Issuer and `vault://issuer-name` for a ClusterIssuer. The expiration of the token is also set by cert-manager to 10 minutes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "audiences",
    "name"
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
public class ServiceAccountRef implements Editable<ServiceAccountRefBuilder>, KubernetesResource
{

    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> audiences = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServiceAccountRef() {
    }

    public ServiceAccountRef(List<String> audiences, String name) {
        super();
        this.audiences = audiences;
        this.name = name;
    }

    /**
     * TokenAudiences is an optional list of extra audiences to include in the token passed to Vault. The default audiences are always included in the token.
     */
    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAudiences() {
        return audiences;
    }

    /**
     * TokenAudiences is an optional list of extra audiences to include in the token passed to Vault. The default audiences are always included in the token.
     */
    @JsonProperty("audiences")
    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
    }

    /**
     * Name of the ServiceAccount used to request a token.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the ServiceAccount used to request a token.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public ServiceAccountRefBuilder edit() {
        return new ServiceAccountRefBuilder(this);
    }

    @JsonIgnore
    public ServiceAccountRefBuilder toBuilder() {
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
        if (!(o instanceof ServiceAccountRef)) {
            return false;
        }
        ServiceAccountRef other = (ServiceAccountRef) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$audiences = this.getAudiences();
        Object other$audiences = other.getAudiences();
        if (this$audiences == null ? other$audiences != null : !this$audiences.equals(other$audiences)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof ServiceAccountRef;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $audiences = this.getAudiences();
        result = result * prime + ($audiences == null ? 43 : $audiences.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ServiceAccountRef(" + "audiences=" + this.getAudiences() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
