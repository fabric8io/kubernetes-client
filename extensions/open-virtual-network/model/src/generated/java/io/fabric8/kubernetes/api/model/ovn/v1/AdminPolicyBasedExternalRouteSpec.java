
package io.fabric8.kubernetes.api.model.ovn.v1;

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
 * AdminPolicyBasedExternalRouteSpec defines the desired state of AdminPolicyBasedExternalRoute
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "nextHops"
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
public class AdminPolicyBasedExternalRouteSpec implements Editable<AdminPolicyBasedExternalRouteSpecBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private ExternalNetworkSource from;
    @JsonProperty("nextHops")
    private ExternalNextHops nextHops;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AdminPolicyBasedExternalRouteSpec() {
    }

    public AdminPolicyBasedExternalRouteSpec(ExternalNetworkSource from, ExternalNextHops nextHops) {
        super();
        this.from = from;
        this.nextHops = nextHops;
    }

    /**
     * AdminPolicyBasedExternalRouteSpec defines the desired state of AdminPolicyBasedExternalRoute
     */
    @JsonProperty("from")
    public ExternalNetworkSource getFrom() {
        return from;
    }

    /**
     * AdminPolicyBasedExternalRouteSpec defines the desired state of AdminPolicyBasedExternalRoute
     */
    @JsonProperty("from")
    public void setFrom(ExternalNetworkSource from) {
        this.from = from;
    }

    /**
     * AdminPolicyBasedExternalRouteSpec defines the desired state of AdminPolicyBasedExternalRoute
     */
    @JsonProperty("nextHops")
    public ExternalNextHops getNextHops() {
        return nextHops;
    }

    /**
     * AdminPolicyBasedExternalRouteSpec defines the desired state of AdminPolicyBasedExternalRoute
     */
    @JsonProperty("nextHops")
    public void setNextHops(ExternalNextHops nextHops) {
        this.nextHops = nextHops;
    }

    @JsonIgnore
    public AdminPolicyBasedExternalRouteSpecBuilder edit() {
        return new AdminPolicyBasedExternalRouteSpecBuilder(this);
    }

    @JsonIgnore
    public AdminPolicyBasedExternalRouteSpecBuilder toBuilder() {
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
        if (!(o instanceof AdminPolicyBasedExternalRouteSpec)) {
            return false;
        }
        AdminPolicyBasedExternalRouteSpec other = (AdminPolicyBasedExternalRouteSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$nextHops = this.getNextHops();
        Object other$nextHops = other.getNextHops();
        if (this$nextHops == null ? other$nextHops != null : !this$nextHops.equals(other$nextHops)) {
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
        return other instanceof AdminPolicyBasedExternalRouteSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $nextHops = this.getNextHops();
        result = result * prime + ($nextHops == null ? 43 : $nextHops.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AdminPolicyBasedExternalRouteSpec(" + "from=" + this.getFrom() + ", nextHops=" + this.getNextHops() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
