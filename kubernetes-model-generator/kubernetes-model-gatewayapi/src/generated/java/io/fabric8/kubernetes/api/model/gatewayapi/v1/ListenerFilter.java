
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ListenerFilter is one element of a ListenerFilters.Requests list. Unlike HTTPRouteFilter, which runs after a route is selected and whose ordering is a SHOULD, ListenerFilter runs before route selection and its ordering within the containing list is a MUST.<br><p> <br><p> Only a subset of HTTPRouteFilter variants are permitted: ExternalAuth (to establish identity that route matching can consume) and ExtensionRef (the escape hatch for custom pre-routing behavior, for example body-based routing or JWT-claim projection). The other HTTPRouteFilter variants are excluded because they either cannot influence route selection or can already be expressed post-routing with equal expressiveness. See the GEP text for details.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "extensionRef",
    "externalAuth",
    "type"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class ListenerFilter implements Editable<ListenerFilterBuilder>, KubernetesResource
{

    @JsonProperty("extensionRef")
    private LocalObjectReference extensionRef;
    @JsonProperty("externalAuth")
    private HTTPExternalAuthFilter externalAuth;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerFilter() {
    }

    public ListenerFilter(LocalObjectReference extensionRef, HTTPExternalAuthFilter externalAuth, String type) {
        super();
        this.extensionRef = extensionRef;
        this.externalAuth = externalAuth;
        this.type = type;
    }

    /**
     * ListenerFilter is one element of a ListenerFilters.Requests list. Unlike HTTPRouteFilter, which runs after a route is selected and whose ordering is a SHOULD, ListenerFilter runs before route selection and its ordering within the containing list is a MUST.<br><p> <br><p> Only a subset of HTTPRouteFilter variants are permitted: ExternalAuth (to establish identity that route matching can consume) and ExtensionRef (the escape hatch for custom pre-routing behavior, for example body-based routing or JWT-claim projection). The other HTTPRouteFilter variants are excluded because they either cannot influence route selection or can already be expressed post-routing with equal expressiveness. See the GEP text for details.
     */
    @JsonProperty("extensionRef")
    public LocalObjectReference getExtensionRef() {
        return extensionRef;
    }

    /**
     * ListenerFilter is one element of a ListenerFilters.Requests list. Unlike HTTPRouteFilter, which runs after a route is selected and whose ordering is a SHOULD, ListenerFilter runs before route selection and its ordering within the containing list is a MUST.<br><p> <br><p> Only a subset of HTTPRouteFilter variants are permitted: ExternalAuth (to establish identity that route matching can consume) and ExtensionRef (the escape hatch for custom pre-routing behavior, for example body-based routing or JWT-claim projection). The other HTTPRouteFilter variants are excluded because they either cannot influence route selection or can already be expressed post-routing with equal expressiveness. See the GEP text for details.
     */
    @JsonProperty("extensionRef")
    public void setExtensionRef(LocalObjectReference extensionRef) {
        this.extensionRef = extensionRef;
    }

    /**
     * ListenerFilter is one element of a ListenerFilters.Requests list. Unlike HTTPRouteFilter, which runs after a route is selected and whose ordering is a SHOULD, ListenerFilter runs before route selection and its ordering within the containing list is a MUST.<br><p> <br><p> Only a subset of HTTPRouteFilter variants are permitted: ExternalAuth (to establish identity that route matching can consume) and ExtensionRef (the escape hatch for custom pre-routing behavior, for example body-based routing or JWT-claim projection). The other HTTPRouteFilter variants are excluded because they either cannot influence route selection or can already be expressed post-routing with equal expressiveness. See the GEP text for details.
     */
    @JsonProperty("externalAuth")
    public HTTPExternalAuthFilter getExternalAuth() {
        return externalAuth;
    }

    /**
     * ListenerFilter is one element of a ListenerFilters.Requests list. Unlike HTTPRouteFilter, which runs after a route is selected and whose ordering is a SHOULD, ListenerFilter runs before route selection and its ordering within the containing list is a MUST.<br><p> <br><p> Only a subset of HTTPRouteFilter variants are permitted: ExternalAuth (to establish identity that route matching can consume) and ExtensionRef (the escape hatch for custom pre-routing behavior, for example body-based routing or JWT-claim projection). The other HTTPRouteFilter variants are excluded because they either cannot influence route selection or can already be expressed post-routing with equal expressiveness. See the GEP text for details.
     */
    @JsonProperty("externalAuth")
    public void setExternalAuth(HTTPExternalAuthFilter externalAuth) {
        this.externalAuth = externalAuth;
    }

    /**
     * Type identifies which variant of the discriminated union below is populated. Uses the same union-discriminator pattern as HTTPRouteFilter and GRPCRouteFilter.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type identifies which variant of the discriminated union below is populated. Uses the same union-discriminator pattern as HTTPRouteFilter and GRPCRouteFilter.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ListenerFilterBuilder edit() {
        return new ListenerFilterBuilder(this);
    }

    @JsonIgnore
    public ListenerFilterBuilder toBuilder() {
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

}
