
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.TypedLocalObjectReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NetworkGatewayv6 represents a gateway, given as a string or as a reference to a Metal3IPPool.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fromIPPool",
    "fromPoolAnnotation",
    "fromPoolRef",
    "string"
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
public class NetworkGatewayv6 implements Editable<NetworkGatewayv6Builder>, KubernetesResource
{

    @JsonProperty("fromIPPool")
    private String fromIPPool;
    @JsonProperty("fromPoolAnnotation")
    private FromPoolAnnotation fromPoolAnnotation;
    @JsonProperty("fromPoolRef")
    private TypedLocalObjectReference fromPoolRef;
    @JsonProperty("string")
    private String string;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkGatewayv6() {
    }

    public NetworkGatewayv6(String fromIPPool, FromPoolAnnotation fromPoolAnnotation, TypedLocalObjectReference fromPoolRef, String string) {
        super();
        this.fromIPPool = fromIPPool;
        this.fromPoolAnnotation = fromPoolAnnotation;
        this.fromPoolRef = fromPoolRef;
        this.string = string;
    }

    /**
     * FromIPPool is the name of the IPPool to fetch the gateway from
     */
    @JsonProperty("fromIPPool")
    public String getFromIPPool() {
        return fromIPPool;
    }

    /**
     * FromIPPool is the name of the IPPool to fetch the gateway from
     */
    @JsonProperty("fromIPPool")
    public void setFromIPPool(String fromIPPool) {
        this.fromIPPool = fromIPPool;
    }

    /**
     * NetworkGatewayv6 represents a gateway, given as a string or as a reference to a Metal3IPPool.
     */
    @JsonProperty("fromPoolAnnotation")
    public FromPoolAnnotation getFromPoolAnnotation() {
        return fromPoolAnnotation;
    }

    /**
     * NetworkGatewayv6 represents a gateway, given as a string or as a reference to a Metal3IPPool.
     */
    @JsonProperty("fromPoolAnnotation")
    public void setFromPoolAnnotation(FromPoolAnnotation fromPoolAnnotation) {
        this.fromPoolAnnotation = fromPoolAnnotation;
    }

    /**
     * NetworkGatewayv6 represents a gateway, given as a string or as a reference to a Metal3IPPool.
     */
    @JsonProperty("fromPoolRef")
    public TypedLocalObjectReference getFromPoolRef() {
        return fromPoolRef;
    }

    /**
     * NetworkGatewayv6 represents a gateway, given as a string or as a reference to a Metal3IPPool.
     */
    @JsonProperty("fromPoolRef")
    public void setFromPoolRef(TypedLocalObjectReference fromPoolRef) {
        this.fromPoolRef = fromPoolRef;
    }

    /**
     * String is the gateway given as a string
     */
    @JsonProperty("string")
    public String getString() {
        return string;
    }

    /**
     * String is the gateway given as a string
     */
    @JsonProperty("string")
    public void setString(String string) {
        this.string = string;
    }

    @JsonIgnore
    public NetworkGatewayv6Builder edit() {
        return new NetworkGatewayv6Builder(this);
    }

    @JsonIgnore
    public NetworkGatewayv6Builder toBuilder() {
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
        if (!(o instanceof NetworkGatewayv6)) {
            return false;
        }
        NetworkGatewayv6 other = (NetworkGatewayv6) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fromIPPool = this.getFromIPPool();
        Object other$fromIPPool = other.getFromIPPool();
        if (this$fromIPPool == null ? other$fromIPPool != null : !this$fromIPPool.equals(other$fromIPPool)) {
            return false;
        }
        Object this$fromPoolAnnotation = this.getFromPoolAnnotation();
        Object other$fromPoolAnnotation = other.getFromPoolAnnotation();
        if (this$fromPoolAnnotation == null ? other$fromPoolAnnotation != null : !this$fromPoolAnnotation.equals(other$fromPoolAnnotation)) {
            return false;
        }
        Object this$fromPoolRef = this.getFromPoolRef();
        Object other$fromPoolRef = other.getFromPoolRef();
        if (this$fromPoolRef == null ? other$fromPoolRef != null : !this$fromPoolRef.equals(other$fromPoolRef)) {
            return false;
        }
        Object this$string = this.getString();
        Object other$string = other.getString();
        if (this$string == null ? other$string != null : !this$string.equals(other$string)) {
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
        return other instanceof NetworkGatewayv6;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fromIPPool = this.getFromIPPool();
        result = result * prime + ($fromIPPool == null ? 43 : $fromIPPool.hashCode());
        Object $fromPoolAnnotation = this.getFromPoolAnnotation();
        result = result * prime + ($fromPoolAnnotation == null ? 43 : $fromPoolAnnotation.hashCode());
        Object $fromPoolRef = this.getFromPoolRef();
        result = result * prime + ($fromPoolRef == null ? 43 : $fromPoolRef.hashCode());
        Object $string = this.getString();
        result = result * prime + ($string == null ? 43 : $string.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkGatewayv6(" + "fromIPPool=" + this.getFromIPPool() + ", fromPoolAnnotation=" + this.getFromPoolAnnotation() + ", fromPoolRef=" + this.getFromPoolRef() + ", string=" + this.getString() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
