
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RouteAdmissionPolicy is an admission policy for allowing new route claims.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namespaceOwnership",
    "wildcardPolicy"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RouteAdmissionPolicy implements Editable<RouteAdmissionPolicyBuilder>, KubernetesResource
{

    @JsonProperty("namespaceOwnership")
    private String namespaceOwnership;
    @JsonProperty("wildcardPolicy")
    private String wildcardPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RouteAdmissionPolicy() {
    }

    public RouteAdmissionPolicy(String namespaceOwnership, String wildcardPolicy) {
        super();
        this.namespaceOwnership = namespaceOwnership;
        this.wildcardPolicy = wildcardPolicy;
    }

    /**
     * namespaceOwnership describes how host name claims across namespaces should be handled.<br><p> <br><p> Value must be one of:<br><p> <br><p> - Strict: Do not allow routes in different namespaces to claim the same host.<br><p> <br><p> - InterNamespaceAllowed: Allow routes to claim different paths of the same<br><p>   host name across namespaces.<br><p> <br><p> If empty, the default is Strict.
     */
    @JsonProperty("namespaceOwnership")
    public String getNamespaceOwnership() {
        return namespaceOwnership;
    }

    /**
     * namespaceOwnership describes how host name claims across namespaces should be handled.<br><p> <br><p> Value must be one of:<br><p> <br><p> - Strict: Do not allow routes in different namespaces to claim the same host.<br><p> <br><p> - InterNamespaceAllowed: Allow routes to claim different paths of the same<br><p>   host name across namespaces.<br><p> <br><p> If empty, the default is Strict.
     */
    @JsonProperty("namespaceOwnership")
    public void setNamespaceOwnership(String namespaceOwnership) {
        this.namespaceOwnership = namespaceOwnership;
    }

    /**
     * wildcardPolicy describes how routes with wildcard policies should be handled for the ingress controller. WildcardPolicy controls use of routes [1] exposed by the ingress controller based on the route's wildcard policy.<br><p> <br><p> [1] https://github.com/openshift/api/blob/master/route/v1/types.go<br><p> <br><p> Note: Updating WildcardPolicy from WildcardsAllowed to WildcardsDisallowed will cause admitted routes with a wildcard policy of Subdomain to stop working. These routes must be updated to a wildcard policy of None to be readmitted by the ingress controller.<br><p> <br><p> WildcardPolicy supports WildcardsAllowed and WildcardsDisallowed values.<br><p> <br><p> If empty, defaults to "WildcardsDisallowed".
     */
    @JsonProperty("wildcardPolicy")
    public String getWildcardPolicy() {
        return wildcardPolicy;
    }

    /**
     * wildcardPolicy describes how routes with wildcard policies should be handled for the ingress controller. WildcardPolicy controls use of routes [1] exposed by the ingress controller based on the route's wildcard policy.<br><p> <br><p> [1] https://github.com/openshift/api/blob/master/route/v1/types.go<br><p> <br><p> Note: Updating WildcardPolicy from WildcardsAllowed to WildcardsDisallowed will cause admitted routes with a wildcard policy of Subdomain to stop working. These routes must be updated to a wildcard policy of None to be readmitted by the ingress controller.<br><p> <br><p> WildcardPolicy supports WildcardsAllowed and WildcardsDisallowed values.<br><p> <br><p> If empty, defaults to "WildcardsDisallowed".
     */
    @JsonProperty("wildcardPolicy")
    public void setWildcardPolicy(String wildcardPolicy) {
        this.wildcardPolicy = wildcardPolicy;
    }

    @JsonIgnore
    public RouteAdmissionPolicyBuilder edit() {
        return new RouteAdmissionPolicyBuilder(this);
    }

    @JsonIgnore
    public RouteAdmissionPolicyBuilder toBuilder() {
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
