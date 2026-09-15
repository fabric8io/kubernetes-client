
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
import io.fabric8.kubernetes.api.model.Condition;
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
 * ListenerStatus is the status associated with a Listener.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachedRoutes",
    "conditions",
    "name",
    "supportedKinds"
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
public class ListenerEntryStatus implements Editable<ListenerEntryStatusBuilder>, KubernetesResource
{

    @JsonProperty("attachedRoutes")
    private Integer attachedRoutes;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("supportedKinds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteGroupKind> supportedKinds = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerEntryStatus() {
    }

    public ListenerEntryStatus(Integer attachedRoutes, List<Condition> conditions, String name, List<RouteGroupKind> supportedKinds) {
        super();
        this.attachedRoutes = attachedRoutes;
        this.conditions = conditions;
        this.name = name;
        this.supportedKinds = supportedKinds;
    }

    /**
     * AttachedRoutes represents the total number of Routes that have been successfully attached to this Listener.<br><p> <br><p> Successful attachment of a Route to a Listener is based solely on the combination of the AllowedRoutes field on the corresponding Listener and the Route's ParentRefs field. A Route is successfully attached to a Listener when it is selected by the Listener's AllowedRoutes field AND the Route has a valid ParentRef selecting the whole Gateway resource or a specific Listener as a parent resource (more detail on attachment semantics can be found in the documentation on the various Route kinds ParentRefs fields). Listener status does not impact successful attachment, i.e. the AttachedRoutes field count MUST be set for Listeners, even if the Accepted condition of an individual Listener is set to "False". The AttachedRoutes number represents the number of Routes with the Accepted condition set to "True" that have been attached to this Listener. Routes with any other value for the Accepted condition MUST NOT be included in this count.<br><p> <br><p> Uses for this field include troubleshooting Route attachment and measuring blast radius/impact of changes to a Listener.
     */
    @JsonProperty("attachedRoutes")
    public Integer getAttachedRoutes() {
        return attachedRoutes;
    }

    /**
     * AttachedRoutes represents the total number of Routes that have been successfully attached to this Listener.<br><p> <br><p> Successful attachment of a Route to a Listener is based solely on the combination of the AllowedRoutes field on the corresponding Listener and the Route's ParentRefs field. A Route is successfully attached to a Listener when it is selected by the Listener's AllowedRoutes field AND the Route has a valid ParentRef selecting the whole Gateway resource or a specific Listener as a parent resource (more detail on attachment semantics can be found in the documentation on the various Route kinds ParentRefs fields). Listener status does not impact successful attachment, i.e. the AttachedRoutes field count MUST be set for Listeners, even if the Accepted condition of an individual Listener is set to "False". The AttachedRoutes number represents the number of Routes with the Accepted condition set to "True" that have been attached to this Listener. Routes with any other value for the Accepted condition MUST NOT be included in this count.<br><p> <br><p> Uses for this field include troubleshooting Route attachment and measuring blast radius/impact of changes to a Listener.
     */
    @JsonProperty("attachedRoutes")
    public void setAttachedRoutes(Integer attachedRoutes) {
        this.attachedRoutes = attachedRoutes;
    }

    /**
     * Conditions describe the current condition of this listener.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions describe the current condition of this listener.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Name is the name of the Listener that this status corresponds to.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the Listener that this status corresponds to.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * SupportedKinds is the list indicating the Kinds supported by this listener. This MUST represent the kinds supported by an implementation for that Listener configuration.<br><p> <br><p> If kinds are specified in Spec that are not supported, they MUST NOT appear in this list and an implementation MUST set the "ResolvedRefs" condition to "False" with the "InvalidRouteKinds" reason. If both valid and invalid Route kinds are specified, the implementation MUST reference the valid Route kinds that have been specified.
     */
    @JsonProperty("supportedKinds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteGroupKind> getSupportedKinds() {
        return supportedKinds;
    }

    /**
     * SupportedKinds is the list indicating the Kinds supported by this listener. This MUST represent the kinds supported by an implementation for that Listener configuration.<br><p> <br><p> If kinds are specified in Spec that are not supported, they MUST NOT appear in this list and an implementation MUST set the "ResolvedRefs" condition to "False" with the "InvalidRouteKinds" reason. If both valid and invalid Route kinds are specified, the implementation MUST reference the valid Route kinds that have been specified.
     */
    @JsonProperty("supportedKinds")
    public void setSupportedKinds(List<RouteGroupKind> supportedKinds) {
        this.supportedKinds = supportedKinds;
    }

    @JsonIgnore
    public ListenerEntryStatusBuilder edit() {
        return new ListenerEntryStatusBuilder(this);
    }

    @JsonIgnore
    public ListenerEntryStatusBuilder toBuilder() {
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
        if (!(o instanceof ListenerEntryStatus)) {
            return false;
        }
        ListenerEntryStatus other = (ListenerEntryStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attachedRoutes = this.getAttachedRoutes();
        Object other$attachedRoutes = other.getAttachedRoutes();
        if (this$attachedRoutes == null ? other$attachedRoutes != null : !this$attachedRoutes.equals(other$attachedRoutes)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$supportedKinds = this.getSupportedKinds();
        Object other$supportedKinds = other.getSupportedKinds();
        if (this$supportedKinds == null ? other$supportedKinds != null : !this$supportedKinds.equals(other$supportedKinds)) {
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
        return other instanceof ListenerEntryStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attachedRoutes = this.getAttachedRoutes();
        result = result * prime + ($attachedRoutes == null ? 43 : $attachedRoutes.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $supportedKinds = this.getSupportedKinds();
        result = result * prime + ($supportedKinds == null ? 43 : $supportedKinds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ListenerEntryStatus(" + "attachedRoutes=" + this.getAttachedRoutes() + ", conditions=" + this.getConditions() + ", name=" + this.getName() + ", supportedKinds=" + this.getSupportedKinds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
