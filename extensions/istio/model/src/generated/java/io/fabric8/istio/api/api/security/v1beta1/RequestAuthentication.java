
package io.fabric8.istio.api.api.security.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "jwtRules",
    "selector",
    "targetRef",
    "targetRefs"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RequestAuthentication implements Editable<RequestAuthenticationBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("jwtRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JWTRule> jwtRules = new ArrayList<>();
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonProperty("targetRef")
    private PolicyTargetReference targetRef;
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyTargetReference> targetRefs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RequestAuthentication() {
    }

    public RequestAuthentication(List<JWTRule> jwtRules, WorkloadSelector selector, PolicyTargetReference targetRef, List<PolicyTargetReference> targetRefs) {
        super();
        this.jwtRules = jwtRules;
        this.selector = selector;
        this.targetRef = targetRef;
        this.targetRefs = targetRefs;
    }

    /**
     * Define the list of JWTs that can be validated at the selected workloads' proxy. A valid token will be used to extract the authenticated identity. Each rule will be activated only when a token is presented at the location recognized by the rule. The token will be validated based on the JWT rule config. If validation fails, the request will be rejected. Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("jwtRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JWTRule> getJwtRules() {
        return jwtRules;
    }

    /**
     * Define the list of JWTs that can be validated at the selected workloads' proxy. A valid token will be used to extract the authenticated identity. Each rule will be activated only when a token is presented at the location recognized by the rule. The token will be validated based on the JWT rule config. If validation fails, the request will be rejected. Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("jwtRules")
    public void setJwtRules(List<JWTRule> jwtRules) {
        this.jwtRules = jwtRules;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("targetRef")
    public PolicyTargetReference getTargetRef() {
        return targetRef;
    }

    /**
     * RequestAuthentication defines what request authentication methods are supported by a workload. It will reject a request if the request contains invalid authentication information, based on the configured authentication rules. A request that does not contain any authentication credentials will be accepted but will not have any authenticated identity. To restrict access to authenticated requests only, this should be accompanied by an authorization rule. Examples:<br><p> <br><p> - Require JWT for all request for workloads that have label `app:httpbin`<br><p> <br><p> ```yaml apiVersion: security.istio.io/v1 kind: RequestAuthentication metadata:<br><p> <br><p> 	name: httpbin<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  matchLabels:<br><p> 	    app: httpbin<br><p> 	jwtRules:<br><p> 	- issuer: "issuer-foo"<br><p> 	  jwksUri: https://example.com/.well-known/jwks.json
     */
    @JsonProperty("targetRef")
    public void setTargetRef(PolicyTargetReference targetRef) {
        this.targetRef = targetRef;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
    }

    @JsonIgnore
    public RequestAuthenticationBuilder edit() {
        return new RequestAuthenticationBuilder(this);
    }

    @JsonIgnore
    public RequestAuthenticationBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
