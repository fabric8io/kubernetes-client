
package io.fabric8.knative.serving.v1;

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
import io.fabric8.knative.duck.v1.Addressable;
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
 * RouteStatusFields holds the fields of Route's status that are not generally shared.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "traffic",
    "url"
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
public class RouteStatusFields implements Editable<RouteStatusFieldsBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private Addressable address;
    @JsonProperty("traffic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TrafficTarget> traffic = new ArrayList<>();
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RouteStatusFields() {
    }

    public RouteStatusFields(Addressable address, List<TrafficTarget> traffic, String url) {
        super();
        this.address = address;
        this.traffic = traffic;
        this.url = url;
    }

    /**
     * RouteStatusFields holds the fields of Route's status that are not generally shared.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("address")
    public Addressable getAddress() {
        return address;
    }

    /**
     * RouteStatusFields holds the fields of Route's status that are not generally shared.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("address")
    public void setAddress(Addressable address) {
        this.address = address;
    }

    /**
     * Traffic holds the configured traffic distribution. These entries will always contain RevisionName references. When ConfigurationName appears in the spec, this will hold the LatestReadyRevisionName that we last observed.
     */
    @JsonProperty("traffic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TrafficTarget> getTraffic() {
        return traffic;
    }

    /**
     * Traffic holds the configured traffic distribution. These entries will always contain RevisionName references. When ConfigurationName appears in the spec, this will hold the LatestReadyRevisionName that we last observed.
     */
    @JsonProperty("traffic")
    public void setTraffic(List<TrafficTarget> traffic) {
        this.traffic = traffic;
    }

    /**
     * RouteStatusFields holds the fields of Route's status that are not generally shared.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * RouteStatusFields holds the fields of Route's status that are not generally shared.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public RouteStatusFieldsBuilder edit() {
        return new RouteStatusFieldsBuilder(this);
    }

    @JsonIgnore
    public RouteStatusFieldsBuilder toBuilder() {
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
        if (!(o instanceof RouteStatusFields)) {
            return false;
        }
        RouteStatusFields other = (RouteStatusFields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$address = this.getAddress();
        Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
            return false;
        }
        Object this$traffic = this.getTraffic();
        Object other$traffic = other.getTraffic();
        if (this$traffic == null ? other$traffic != null : !this$traffic.equals(other$traffic)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof RouteStatusFields;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $address = this.getAddress();
        result = result * prime + ($address == null ? 43 : $address.hashCode());
        Object $traffic = this.getTraffic();
        result = result * prime + ($traffic == null ? 43 : $traffic.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RouteStatusFields(" + "address=" + this.getAddress() + ", traffic=" + this.getTraffic() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
