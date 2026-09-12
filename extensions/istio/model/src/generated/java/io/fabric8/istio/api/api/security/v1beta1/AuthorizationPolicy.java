
package io.fabric8.istio.api.api.security.v1beta1;

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
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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

/**
 * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ActionDetail",
    "action",
    "rules",
    "selector",
    "targetRef",
    "targetRefs"
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
@Version("v1beta1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AuthorizationPolicy implements Editable<AuthorizationPolicyBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("ActionDetail")
    @JsonUnwrapped
    private IsAuthorizationPolicyActionDetail actionDetail;
    @JsonProperty("action")
    private AuthorizationPolicyAction action;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Rule> rules = new ArrayList<>();
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
    public AuthorizationPolicy() {
    }

    public AuthorizationPolicy(IsAuthorizationPolicyActionDetail actionDetail, AuthorizationPolicyAction action, List<Rule> rules, WorkloadSelector selector, PolicyTargetReference targetRef, List<PolicyTargetReference> targetRefs) {
        super();
        this.actionDetail = actionDetail;
        this.action = action;
        this.rules = rules;
        this.selector = selector;
        this.targetRef = targetRef;
        this.targetRefs = targetRefs;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("ActionDetail")
    @JsonUnwrapped
    public IsAuthorizationPolicyActionDetail getActionDetail() {
        return actionDetail;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("ActionDetail")
    public void setActionDetail(IsAuthorizationPolicyActionDetail actionDetail) {
        this.actionDetail = actionDetail;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("action")
    public AuthorizationPolicyAction getAction() {
        return action;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("action")
    public void setAction(AuthorizationPolicyAction action) {
        this.action = action;
    }

    /**
     * Optional. A list of rules to match the request. A match occurs when at least one rule matches the request.<br><p> <br><p> If not set, the match will never occur. This is equivalent to setting a default of deny for the target workloads if the action is ALLOW.
     */
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Rule> getRules() {
        return rules;
    }

    /**
     * Optional. A list of rules to match the request. A match occurs when at least one rule matches the request.<br><p> <br><p> If not set, the match will never occur. This is equivalent to setting a default of deny for the target workloads if the action is ALLOW.
     */
    @JsonProperty("rules")
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("targetRef")
    public PolicyTargetReference getTargetRef() {
        return targetRef;
    }

    /**
     * AuthorizationPolicy enables access control on workloads.<br><p> <br><p> &lt;!-- crd generation tags representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("targetRef")
    public void setTargetRef(PolicyTargetReference targetRef) {
        this.targetRef = targetRef;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    /**
     * Optional. The targetRefs specifies a list of resources the policy should be applied to. The targeted resources specified will determine which workloads the policy applies to.<br><p> <br><p> Currently, the following resource attachment types are supported: &#42; `kind: Gateway` with `group: gateway.networking.k8s.io` in the same namespace. &#42; `kind: GatewayClass` with `group: gateway.networking.k8s.io` in the root namespace. &#42; `kind: Service` with `group: ""` or `group: "core"` in the same namespace. This type is only supported for waypoints. &#42; `kind: ServiceEntry` with `group: networking.istio.io` in the same namespace.<br><p> <br><p> If not set, the policy is applied as defined by the selector. At most one of the selector and targetRefs can be set.<br><p> <br><p> NOTE: If you are using the `targetRefs` field in a multi-revision environment with Istio versions prior to 1.22, it is highly recommended that you pin the policy to a revision running 1.22+ via the `istio.io/rev` label. This is to prevent proxies connected to older control planes (that don't know about the `targetRefs` field) from misinterpreting the policy as namespace-wide during the upgrade process.<br><p> <br><p> NOTE: Waypoint proxies are required to use this field for policies to apply; `selector` policies will be ignored.
     */
    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
    }

    @JsonIgnore
    public AuthorizationPolicyBuilder edit() {
        return new AuthorizationPolicyBuilder(this);
    }

    @JsonIgnore
    public AuthorizationPolicyBuilder toBuilder() {
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
        if (!(o instanceof AuthorizationPolicy)) {
            return false;
        }
        AuthorizationPolicy other = (AuthorizationPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$actionDetail = this.getActionDetail();
        Object other$actionDetail = other.getActionDetail();
        if (this$actionDetail == null ? other$actionDetail != null : !this$actionDetail.equals(other$actionDetail)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$rules = this.getRules();
        Object other$rules = other.getRules();
        if (this$rules == null ? other$rules != null : !this$rules.equals(other$rules)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$targetRef = this.getTargetRef();
        Object other$targetRef = other.getTargetRef();
        if (this$targetRef == null ? other$targetRef != null : !this$targetRef.equals(other$targetRef)) {
            return false;
        }
        Object this$targetRefs = this.getTargetRefs();
        Object other$targetRefs = other.getTargetRefs();
        if (this$targetRefs == null ? other$targetRefs != null : !this$targetRefs.equals(other$targetRefs)) {
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
        return other instanceof AuthorizationPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $actionDetail = this.getActionDetail();
        result = result * prime + ($actionDetail == null ? 43 : $actionDetail.hashCode());
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $rules = this.getRules();
        result = result * prime + ($rules == null ? 43 : $rules.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $targetRef = this.getTargetRef();
        result = result * prime + ($targetRef == null ? 43 : $targetRef.hashCode());
        Object $targetRefs = this.getTargetRefs();
        result = result * prime + ($targetRefs == null ? 43 : $targetRefs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AuthorizationPolicy(" + "actionDetail=" + this.getActionDetail() + ", action=" + this.getAction() + ", rules=" + this.getRules() + ", selector=" + this.getSelector() + ", targetRef=" + this.getTargetRef() + ", targetRefs=" + this.getTargetRefs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
