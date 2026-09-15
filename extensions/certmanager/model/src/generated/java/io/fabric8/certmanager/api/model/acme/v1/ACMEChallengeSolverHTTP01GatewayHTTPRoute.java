
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.kubernetes.api.model.gatewayapi.v1.ParentReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * The ACMEChallengeSolverHTTP01GatewayHTTPRoute solver will create HTTPRoute objects for a Gateway class routing to an ACME challenge solver pod.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labels",
    "parentRefs",
    "podTemplate",
    "serviceType"
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
public class ACMEChallengeSolverHTTP01GatewayHTTPRoute implements Editable<ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder>, KubernetesResource
{

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("parentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParentReference> parentRefs = new ArrayList<>();
    @JsonProperty("podTemplate")
    private ACMEChallengeSolverHTTP01IngressPodTemplate podTemplate;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEChallengeSolverHTTP01GatewayHTTPRoute() {
    }

    public ACMEChallengeSolverHTTP01GatewayHTTPRoute(Map<String, String> labels, List<ParentReference> parentRefs, ACMEChallengeSolverHTTP01IngressPodTemplate podTemplate, String serviceType) {
        super();
        this.labels = labels;
        this.parentRefs = parentRefs;
        this.podTemplate = podTemplate;
        this.serviceType = serviceType;
    }

    /**
     * Custom labels that will be applied to HTTPRoutes created by cert-manager while solving HTTP-01 challenges.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Custom labels that will be applied to HTTPRoutes created by cert-manager while solving HTTP-01 challenges.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * When solving an HTTP-01 challenge, cert-manager creates an HTTPRoute. cert-manager needs to know which parentRefs should be used when creating the HTTPRoute. Usually, the parentRef references a Gateway. See: https://gateway-api.sigs.k8s.io/api-types/httproute/#attaching-to-gateways
     */
    @JsonProperty("parentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ParentReference> getParentRefs() {
        return parentRefs;
    }

    /**
     * When solving an HTTP-01 challenge, cert-manager creates an HTTPRoute. cert-manager needs to know which parentRefs should be used when creating the HTTPRoute. Usually, the parentRef references a Gateway. See: https://gateway-api.sigs.k8s.io/api-types/httproute/#attaching-to-gateways
     */
    @JsonProperty("parentRefs")
    public void setParentRefs(List<ParentReference> parentRefs) {
        this.parentRefs = parentRefs;
    }

    /**
     * The ACMEChallengeSolverHTTP01GatewayHTTPRoute solver will create HTTPRoute objects for a Gateway class routing to an ACME challenge solver pod.
     */
    @JsonProperty("podTemplate")
    public ACMEChallengeSolverHTTP01IngressPodTemplate getPodTemplate() {
        return podTemplate;
    }

    /**
     * The ACMEChallengeSolverHTTP01GatewayHTTPRoute solver will create HTTPRoute objects for a Gateway class routing to an ACME challenge solver pod.
     */
    @JsonProperty("podTemplate")
    public void setPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate podTemplate) {
        this.podTemplate = podTemplate;
    }

    /**
     * Optional service type for Kubernetes solver service. Supported values are NodePort or ClusterIP. If unset, defaults to NodePort.
     */
    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Optional service type for Kubernetes solver service. Supported values are NodePort or ClusterIP. If unset, defaults to NodePort.
     */
    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonIgnore
    public ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder edit() {
        return new ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder(this);
    }

    @JsonIgnore
    public ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder toBuilder() {
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
        if (!(o instanceof ACMEChallengeSolverHTTP01GatewayHTTPRoute)) {
            return false;
        }
        ACMEChallengeSolverHTTP01GatewayHTTPRoute other = (ACMEChallengeSolverHTTP01GatewayHTTPRoute) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
            return false;
        }
        Object this$parentRefs = this.getParentRefs();
        Object other$parentRefs = other.getParentRefs();
        if (this$parentRefs == null ? other$parentRefs != null : !this$parentRefs.equals(other$parentRefs)) {
            return false;
        }
        Object this$podTemplate = this.getPodTemplate();
        Object other$podTemplate = other.getPodTemplate();
        if (this$podTemplate == null ? other$podTemplate != null : !this$podTemplate.equals(other$podTemplate)) {
            return false;
        }
        Object this$serviceType = this.getServiceType();
        Object other$serviceType = other.getServiceType();
        if (this$serviceType == null ? other$serviceType != null : !this$serviceType.equals(other$serviceType)) {
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
        return other instanceof ACMEChallengeSolverHTTP01GatewayHTTPRoute;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
        Object $parentRefs = this.getParentRefs();
        result = result * prime + ($parentRefs == null ? 43 : $parentRefs.hashCode());
        Object $podTemplate = this.getPodTemplate();
        result = result * prime + ($podTemplate == null ? 43 : $podTemplate.hashCode());
        Object $serviceType = this.getServiceType();
        result = result * prime + ($serviceType == null ? 43 : $serviceType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEChallengeSolverHTTP01GatewayHTTPRoute(" + "labels=" + this.getLabels() + ", parentRefs=" + this.getParentRefs() + ", podTemplate=" + this.getPodTemplate() + ", serviceType=" + this.getServiceType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
