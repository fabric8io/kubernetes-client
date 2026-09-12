
package io.fabric8.knative.eventing.v1alpha1;

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
import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.KReference;
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
    "brokerRef",
    "correlationAttribute",
    "delivery",
    "replyAttribute",
    "timeout"
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
public class RequestReplySpec implements Editable<RequestReplySpecBuilder>, KubernetesResource
{

    @JsonProperty("brokerRef")
    private KReference brokerRef;
    @JsonProperty("correlationAttribute")
    private String correlationAttribute;
    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("replyAttribute")
    private String replyAttribute;
    @JsonProperty("timeout")
    private String timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RequestReplySpec() {
    }

    public RequestReplySpec(KReference brokerRef, String correlationAttribute, DeliverySpec delivery, String replyAttribute, String timeout) {
        super();
        this.brokerRef = brokerRef;
        this.correlationAttribute = correlationAttribute;
        this.delivery = delivery;
        this.replyAttribute = replyAttribute;
        this.timeout = timeout;
    }

    @JsonProperty("brokerRef")
    public KReference getBrokerRef() {
        return brokerRef;
    }

    @JsonProperty("brokerRef")
    public void setBrokerRef(KReference brokerRef) {
        this.brokerRef = brokerRef;
    }

    @JsonProperty("correlationAttribute")
    public String getCorrelationAttribute() {
        return correlationAttribute;
    }

    @JsonProperty("correlationAttribute")
    public void setCorrelationAttribute(String correlationAttribute) {
        this.correlationAttribute = correlationAttribute;
    }

    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    @JsonProperty("replyAttribute")
    public String getReplyAttribute() {
        return replyAttribute;
    }

    @JsonProperty("replyAttribute")
    public void setReplyAttribute(String replyAttribute) {
        this.replyAttribute = replyAttribute;
    }

    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public RequestReplySpecBuilder edit() {
        return new RequestReplySpecBuilder(this);
    }

    @JsonIgnore
    public RequestReplySpecBuilder toBuilder() {
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
        if (!(o instanceof RequestReplySpec)) {
            return false;
        }
        RequestReplySpec other = (RequestReplySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$brokerRef = this.getBrokerRef();
        Object other$brokerRef = other.getBrokerRef();
        if (this$brokerRef == null ? other$brokerRef != null : !this$brokerRef.equals(other$brokerRef)) {
            return false;
        }
        Object this$correlationAttribute = this.getCorrelationAttribute();
        Object other$correlationAttribute = other.getCorrelationAttribute();
        if (this$correlationAttribute == null ? other$correlationAttribute != null : !this$correlationAttribute.equals(other$correlationAttribute)) {
            return false;
        }
        Object this$delivery = this.getDelivery();
        Object other$delivery = other.getDelivery();
        if (this$delivery == null ? other$delivery != null : !this$delivery.equals(other$delivery)) {
            return false;
        }
        Object this$replyAttribute = this.getReplyAttribute();
        Object other$replyAttribute = other.getReplyAttribute();
        if (this$replyAttribute == null ? other$replyAttribute != null : !this$replyAttribute.equals(other$replyAttribute)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
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
        return other instanceof RequestReplySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $brokerRef = this.getBrokerRef();
        result = result * prime + ($brokerRef == null ? 43 : $brokerRef.hashCode());
        Object $correlationAttribute = this.getCorrelationAttribute();
        result = result * prime + ($correlationAttribute == null ? 43 : $correlationAttribute.hashCode());
        Object $delivery = this.getDelivery();
        result = result * prime + ($delivery == null ? 43 : $delivery.hashCode());
        Object $replyAttribute = this.getReplyAttribute();
        result = result * prime + ($replyAttribute == null ? 43 : $replyAttribute.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RequestReplySpec(" + "brokerRef=" + this.getBrokerRef() + ", correlationAttribute=" + this.getCorrelationAttribute() + ", delivery=" + this.getDelivery() + ", replyAttribute=" + this.getReplyAttribute() + ", timeout=" + this.getTimeout() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
