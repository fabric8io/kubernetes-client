
package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

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
 * PerVerbAPIRequestCount requestCounts requests by API request verb.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requestCount",
    "verb"
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
public class PerVerbAPIRequestCount implements Editable<PerVerbAPIRequestCountBuilder>, KubernetesResource
{

    @JsonProperty("requestCount")
    private Long requestCount;
    @JsonProperty("verb")
    private String verb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PerVerbAPIRequestCount() {
    }

    public PerVerbAPIRequestCount(Long requestCount, String verb) {
        super();
        this.requestCount = requestCount;
        this.verb = verb;
    }

    /**
     * requestCount of requests for verb.
     */
    @JsonProperty("requestCount")
    public Long getRequestCount() {
        return requestCount;
    }

    /**
     * requestCount of requests for verb.
     */
    @JsonProperty("requestCount")
    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    /**
     * verb of API request (get, list, create, etc...)
     */
    @JsonProperty("verb")
    public String getVerb() {
        return verb;
    }

    /**
     * verb of API request (get, list, create, etc...)
     */
    @JsonProperty("verb")
    public void setVerb(String verb) {
        this.verb = verb;
    }

    @JsonIgnore
    public PerVerbAPIRequestCountBuilder edit() {
        return new PerVerbAPIRequestCountBuilder(this);
    }

    @JsonIgnore
    public PerVerbAPIRequestCountBuilder toBuilder() {
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
        if (!(o instanceof PerVerbAPIRequestCount)) {
            return false;
        }
        PerVerbAPIRequestCount other = (PerVerbAPIRequestCount) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$requestCount = this.getRequestCount();
        Object other$requestCount = other.getRequestCount();
        if (this$requestCount == null ? other$requestCount != null : !this$requestCount.equals(other$requestCount)) {
            return false;
        }
        Object this$verb = this.getVerb();
        Object other$verb = other.getVerb();
        if (this$verb == null ? other$verb != null : !this$verb.equals(other$verb)) {
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
        return other instanceof PerVerbAPIRequestCount;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $requestCount = this.getRequestCount();
        result = result * prime + ($requestCount == null ? 43 : $requestCount.hashCode());
        Object $verb = this.getVerb();
        result = result * prime + ($verb == null ? 43 : $verb.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PerVerbAPIRequestCount(" + "requestCount=" + this.getRequestCount() + ", verb=" + this.getVerb() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
