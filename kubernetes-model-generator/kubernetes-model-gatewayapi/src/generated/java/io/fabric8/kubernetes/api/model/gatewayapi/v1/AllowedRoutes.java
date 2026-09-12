
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AllowedRoutes defines which Routes may be attached to this Listener.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kinds",
    "namespaces"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AllowedRoutes implements Editable<AllowedRoutesBuilder>, KubernetesResource
{

    @JsonProperty("kinds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteGroupKind> kinds = new ArrayList<>();
    @JsonProperty("namespaces")
    private RouteNamespaces namespaces;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AllowedRoutes() {
    }

    public AllowedRoutes(List<RouteGroupKind> kinds, RouteNamespaces namespaces) {
        super();
        this.kinds = kinds;
        this.namespaces = namespaces;
    }

    /**
     * Kinds specifies the groups and kinds of Routes that are allowed to bind to this Gateway Listener. When unspecified or empty, the kinds of Routes selected are determined using the Listener protocol.<br><p> <br><p> A RouteGroupKind MUST correspond to kinds of Routes that are compatible with the application protocol specified in the Listener's Protocol field. If an implementation does not support or recognize this resource type, it MUST set the "ResolvedRefs" condition to False for this Listener with the "InvalidRouteKinds" reason.<br><p> <br><p> Support: Core
     */
    @JsonProperty("kinds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteGroupKind> getKinds() {
        return kinds;
    }

    /**
     * Kinds specifies the groups and kinds of Routes that are allowed to bind to this Gateway Listener. When unspecified or empty, the kinds of Routes selected are determined using the Listener protocol.<br><p> <br><p> A RouteGroupKind MUST correspond to kinds of Routes that are compatible with the application protocol specified in the Listener's Protocol field. If an implementation does not support or recognize this resource type, it MUST set the "ResolvedRefs" condition to False for this Listener with the "InvalidRouteKinds" reason.<br><p> <br><p> Support: Core
     */
    @JsonProperty("kinds")
    public void setKinds(List<RouteGroupKind> kinds) {
        this.kinds = kinds;
    }

    /**
     * AllowedRoutes defines which Routes may be attached to this Listener.
     */
    @JsonProperty("namespaces")
    public RouteNamespaces getNamespaces() {
        return namespaces;
    }

    /**
     * AllowedRoutes defines which Routes may be attached to this Listener.
     */
    @JsonProperty("namespaces")
    public void setNamespaces(RouteNamespaces namespaces) {
        this.namespaces = namespaces;
    }

    @JsonIgnore
    public AllowedRoutesBuilder edit() {
        return new AllowedRoutesBuilder(this);
    }

    @JsonIgnore
    public AllowedRoutesBuilder toBuilder() {
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
        if (!(o instanceof AllowedRoutes)) {
            return false;
        }
        AllowedRoutes other = (AllowedRoutes) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$kinds = this.getKinds();
        Object other$kinds = other.getKinds();
        if (this$kinds == null ? other$kinds != null : !this$kinds.equals(other$kinds)) {
            return false;
        }
        Object this$namespaces = this.getNamespaces();
        Object other$namespaces = other.getNamespaces();
        if (this$namespaces == null ? other$namespaces != null : !this$namespaces.equals(other$namespaces)) {
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
        return other instanceof AllowedRoutes;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $kinds = this.getKinds();
        result = result * prime + ($kinds == null ? 43 : $kinds.hashCode());
        Object $namespaces = this.getNamespaces();
        result = result * prime + ($namespaces == null ? 43 : $namespaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AllowedRoutes(" + "kinds=" + this.getKinds() + ", namespaces=" + this.getNamespaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
