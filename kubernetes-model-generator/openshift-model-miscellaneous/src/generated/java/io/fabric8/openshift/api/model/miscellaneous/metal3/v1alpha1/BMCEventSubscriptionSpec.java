
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "context",
    "destination",
    "hostName",
    "httpHeadersRef"
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
public class BMCEventSubscriptionSpec implements Editable<BMCEventSubscriptionSpecBuilder>, KubernetesResource
{

    @JsonProperty("context")
    private String context;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("hostName")
    private String hostName;
    @JsonProperty("httpHeadersRef")
    private SecretReference httpHeadersRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BMCEventSubscriptionSpec() {
    }

    public BMCEventSubscriptionSpec(String context, String destination, String hostName, SecretReference httpHeadersRef) {
        super();
        this.context = context;
        this.destination = destination;
        this.hostName = hostName;
        this.httpHeadersRef = httpHeadersRef;
    }

    /**
     * Arbitrary user-provided context for the event
     */
    @JsonProperty("context")
    public String getContext() {
        return context;
    }

    /**
     * Arbitrary user-provided context for the event
     */
    @JsonProperty("context")
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * A webhook URL to send events to
     */
    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    /**
     * A webhook URL to send events to
     */
    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * A reference to a BareMetalHost
     */
    @JsonProperty("hostName")
    public String getHostName() {
        return hostName;
    }

    /**
     * A reference to a BareMetalHost
     */
    @JsonProperty("hostName")
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @JsonProperty("httpHeadersRef")
    public SecretReference getHttpHeadersRef() {
        return httpHeadersRef;
    }

    @JsonProperty("httpHeadersRef")
    public void setHttpHeadersRef(SecretReference httpHeadersRef) {
        this.httpHeadersRef = httpHeadersRef;
    }

    @JsonIgnore
    public BMCEventSubscriptionSpecBuilder edit() {
        return new BMCEventSubscriptionSpecBuilder(this);
    }

    @JsonIgnore
    public BMCEventSubscriptionSpecBuilder toBuilder() {
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
        if (!(o instanceof BMCEventSubscriptionSpec)) {
            return false;
        }
        BMCEventSubscriptionSpec other = (BMCEventSubscriptionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$context = this.getContext();
        Object other$context = other.getContext();
        if (this$context == null ? other$context != null : !this$context.equals(other$context)) {
            return false;
        }
        Object this$destination = this.getDestination();
        Object other$destination = other.getDestination();
        if (this$destination == null ? other$destination != null : !this$destination.equals(other$destination)) {
            return false;
        }
        Object this$hostName = this.getHostName();
        Object other$hostName = other.getHostName();
        if (this$hostName == null ? other$hostName != null : !this$hostName.equals(other$hostName)) {
            return false;
        }
        Object this$httpHeadersRef = this.getHttpHeadersRef();
        Object other$httpHeadersRef = other.getHttpHeadersRef();
        if (this$httpHeadersRef == null ? other$httpHeadersRef != null : !this$httpHeadersRef.equals(other$httpHeadersRef)) {
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
        return other instanceof BMCEventSubscriptionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $context = this.getContext();
        result = result * prime + ($context == null ? 43 : $context.hashCode());
        Object $destination = this.getDestination();
        result = result * prime + ($destination == null ? 43 : $destination.hashCode());
        Object $hostName = this.getHostName();
        result = result * prime + ($hostName == null ? 43 : $hostName.hashCode());
        Object $httpHeadersRef = this.getHttpHeadersRef();
        result = result * prime + ($httpHeadersRef == null ? 43 : $httpHeadersRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BMCEventSubscriptionSpec(" + "context=" + this.getContext() + ", destination=" + this.getDestination() + ", hostName=" + this.getHostName() + ", httpHeadersRef=" + this.getHttpHeadersRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
