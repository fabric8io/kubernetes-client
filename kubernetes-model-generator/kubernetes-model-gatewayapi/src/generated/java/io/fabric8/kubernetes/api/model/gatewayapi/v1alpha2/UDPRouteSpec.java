
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * UDPRouteSpec defines the desired state of UDPRoute.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parentRefs",
    "rules",
    "useDefaultGateways"
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
public class UDPRouteSpec implements Editable<UDPRouteSpecBuilder>, KubernetesResource
{

    @JsonProperty("parentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParentReference> parentRefs = new ArrayList<>();
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UDPRouteRule> rules = new ArrayList<>();
    @JsonProperty("useDefaultGateways")
    private String useDefaultGateways;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public UDPRouteSpec() {
    }

    public UDPRouteSpec(List<ParentReference> parentRefs, List<UDPRouteRule> rules, String useDefaultGateways) {
        super();
        this.parentRefs = parentRefs;
        this.rules = rules;
        this.useDefaultGateways = useDefaultGateways;
    }

    /**
     * ParentRefs references the resources (usually Gateways) that a Route wants to be attached to. Note that the referenced parent resource needs to allow this for the attachment to be complete. For Gateways, that means the Gateway needs to allow attachment from Routes of this kind and namespace. For Services, that means the Service must either be in the same namespace for a "producer" route, or the mesh implementation must support and allow "consumer" routes for the referenced Service. ReferenceGrant is not applicable for governing ParentRefs to Services - it is not possible to create a "producer" route for a Service in a different namespace from the Route.<br><p> <br><p> There are two kinds of parent resources with "Core" support:<br><p> <br><p> &#42; Gateway (Gateway conformance profile) &#42; Service (Mesh conformance profile, ClusterIP Services only)<br><p> <br><p> This API may be extended in the future to support additional kinds of parent resources.<br><p> <br><p> ParentRefs must be _distinct_. This means either that:<br><p> <br><p> &#42; They select different objects.  If this is the case, then parentRef<br><p>   entries are distinct. In terms of fields, this means that the<br><p>   multi-part key defined by `group`, `kind`, `namespace`, and `name` must<br><p>   be unique across all parentRef entries in the Route.<br><p> &#42; They do not select different objects, but for each optional field used,<br><p>   each ParentRef that selects the same object must set the same set of<br><p>   optional fields to different values. If one ParentRef sets a<br><p>   combination of optional fields, all must set the same combination.<br><p> <br><p> Some examples:<br><p> <br><p> &#42; If one ParentRef sets `sectionName`, all ParentRefs referencing the<br><p>   same object must also set `sectionName`.<br><p> &#42; If one ParentRef sets `port`, all ParentRefs referencing the same<br><p>   object must also set `port`.<br><p> &#42; If one ParentRef sets `sectionName` and `port`, all ParentRefs<br><p>   referencing the same object must also set `sectionName` and `port`.<br><p> <br><p> It is possible to separately reference multiple distinct objects that may be collapsed by an implementation. For example, some implementations may choose to merge compatible Gateway Listeners together. If that is the case, the list of routes attached to those resources should also be merged.<br><p> <br><p> Note that for ParentRefs that cross namespace boundaries, there are specific rules. Cross-namespace references are only valid if they are explicitly allowed by something in the namespace they are referring to. For example, Gateway has the AllowedRoutes field, and ReferenceGrant provides a generic way to enable other kinds of cross-namespace reference.<br><p> <br><p> &lt;gateway:experimental:description&gt; ParentRefs from a Route to a Service in the same namespace are "producer" routes, which apply default routing rules to inbound connections from any namespace to the Service.<br><p> <br><p> ParentRefs from a Route to a Service in a different namespace are "consumer" routes, and these routing rules are only applied to outbound connections originating from the same namespace as the Route, for which the intended destination of the connections are a Service targeted as a ParentRef of the Route. &lt;/gateway:experimental:description&gt;<br><p> <br><p> &lt;gateway:standard:validation:XValidation:message="sectionName must be specified when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.all(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__ )) ? ((!has(p1.sectionName) || p1.sectionName == '') == (!has(p2.sectionName) || p2.sectionName == '')) : true))"&gt; &lt;gateway:standard:validation:XValidation:message="sectionName must be unique when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.exists_one(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__ )) &amp;&amp; (((!has(p1.sectionName) || p1.sectionName == '') &amp;&amp; (!has(p2.sectionName) || p2.sectionName == '')) || (has(p1.sectionName) &amp;&amp; has(p2.sectionName) &amp;&amp; p1.sectionName == p2.sectionName))))"&gt; &lt;gateway:experimental:validation:XValidation:message="sectionName or port must be specified when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.all(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__)) ? ((!has(p1.sectionName) || p1.sectionName == '') == (!has(p2.sectionName) || p2.sectionName == '') &amp;&amp; (!has(p1.port) || p1.port == 0) == (!has(p2.port) || p2.port == 0)): true))"&gt; &lt;gateway:experimental:validation:XValidation:message="sectionName or port must be unique when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.exists_one(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__ )) &amp;&amp; (((!has(p1.sectionName) || p1.sectionName == '') &amp;&amp; (!has(p2.sectionName) || p2.sectionName == '')) || ( has(p1.sectionName) &amp;&amp; has(p2.sectionName) &amp;&amp; p1.sectionName == p2.sectionName)) &amp;&amp; (((!has(p1.port) || p1.port == 0) &amp;&amp; (!has(p2.port) || p2.port == 0)) || (has(p1.port) &amp;&amp; has(p2.port) &amp;&amp; p1.port == p2.port))))"&gt;
     */
    @JsonProperty("parentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ParentReference> getParentRefs() {
        return parentRefs;
    }

    /**
     * ParentRefs references the resources (usually Gateways) that a Route wants to be attached to. Note that the referenced parent resource needs to allow this for the attachment to be complete. For Gateways, that means the Gateway needs to allow attachment from Routes of this kind and namespace. For Services, that means the Service must either be in the same namespace for a "producer" route, or the mesh implementation must support and allow "consumer" routes for the referenced Service. ReferenceGrant is not applicable for governing ParentRefs to Services - it is not possible to create a "producer" route for a Service in a different namespace from the Route.<br><p> <br><p> There are two kinds of parent resources with "Core" support:<br><p> <br><p> &#42; Gateway (Gateway conformance profile) &#42; Service (Mesh conformance profile, ClusterIP Services only)<br><p> <br><p> This API may be extended in the future to support additional kinds of parent resources.<br><p> <br><p> ParentRefs must be _distinct_. This means either that:<br><p> <br><p> &#42; They select different objects.  If this is the case, then parentRef<br><p>   entries are distinct. In terms of fields, this means that the<br><p>   multi-part key defined by `group`, `kind`, `namespace`, and `name` must<br><p>   be unique across all parentRef entries in the Route.<br><p> &#42; They do not select different objects, but for each optional field used,<br><p>   each ParentRef that selects the same object must set the same set of<br><p>   optional fields to different values. If one ParentRef sets a<br><p>   combination of optional fields, all must set the same combination.<br><p> <br><p> Some examples:<br><p> <br><p> &#42; If one ParentRef sets `sectionName`, all ParentRefs referencing the<br><p>   same object must also set `sectionName`.<br><p> &#42; If one ParentRef sets `port`, all ParentRefs referencing the same<br><p>   object must also set `port`.<br><p> &#42; If one ParentRef sets `sectionName` and `port`, all ParentRefs<br><p>   referencing the same object must also set `sectionName` and `port`.<br><p> <br><p> It is possible to separately reference multiple distinct objects that may be collapsed by an implementation. For example, some implementations may choose to merge compatible Gateway Listeners together. If that is the case, the list of routes attached to those resources should also be merged.<br><p> <br><p> Note that for ParentRefs that cross namespace boundaries, there are specific rules. Cross-namespace references are only valid if they are explicitly allowed by something in the namespace they are referring to. For example, Gateway has the AllowedRoutes field, and ReferenceGrant provides a generic way to enable other kinds of cross-namespace reference.<br><p> <br><p> &lt;gateway:experimental:description&gt; ParentRefs from a Route to a Service in the same namespace are "producer" routes, which apply default routing rules to inbound connections from any namespace to the Service.<br><p> <br><p> ParentRefs from a Route to a Service in a different namespace are "consumer" routes, and these routing rules are only applied to outbound connections originating from the same namespace as the Route, for which the intended destination of the connections are a Service targeted as a ParentRef of the Route. &lt;/gateway:experimental:description&gt;<br><p> <br><p> &lt;gateway:standard:validation:XValidation:message="sectionName must be specified when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.all(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__ )) ? ((!has(p1.sectionName) || p1.sectionName == '') == (!has(p2.sectionName) || p2.sectionName == '')) : true))"&gt; &lt;gateway:standard:validation:XValidation:message="sectionName must be unique when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.exists_one(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__ )) &amp;&amp; (((!has(p1.sectionName) || p1.sectionName == '') &amp;&amp; (!has(p2.sectionName) || p2.sectionName == '')) || (has(p1.sectionName) &amp;&amp; has(p2.sectionName) &amp;&amp; p1.sectionName == p2.sectionName))))"&gt; &lt;gateway:experimental:validation:XValidation:message="sectionName or port must be specified when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.all(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__)) ? ((!has(p1.sectionName) || p1.sectionName == '') == (!has(p2.sectionName) || p2.sectionName == '') &amp;&amp; (!has(p1.port) || p1.port == 0) == (!has(p2.port) || p2.port == 0)): true))"&gt; &lt;gateway:experimental:validation:XValidation:message="sectionName or port must be unique when parentRefs includes 2 or more references to the same parent",rule="self.all(p1, self.exists_one(p2, p1.group == p2.group &amp;&amp; p1.kind == p2.kind &amp;&amp; p1.name == p2.name &amp;&amp; (((!has(p1.__namespace__) || p1.__namespace__ == '') &amp;&amp; (!has(p2.__namespace__) || p2.__namespace__ == '')) || (has(p1.__namespace__) &amp;&amp; has(p2.__namespace__) &amp;&amp; p1.__namespace__ == p2.__namespace__ )) &amp;&amp; (((!has(p1.sectionName) || p1.sectionName == '') &amp;&amp; (!has(p2.sectionName) || p2.sectionName == '')) || ( has(p1.sectionName) &amp;&amp; has(p2.sectionName) &amp;&amp; p1.sectionName == p2.sectionName)) &amp;&amp; (((!has(p1.port) || p1.port == 0) &amp;&amp; (!has(p2.port) || p2.port == 0)) || (has(p1.port) &amp;&amp; has(p2.port) &amp;&amp; p1.port == p2.port))))"&gt;
     */
    @JsonProperty("parentRefs")
    public void setParentRefs(List<ParentReference> parentRefs) {
        this.parentRefs = parentRefs;
    }

    /**
     * Rules are a list of UDP matchers and actions.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="Rule name must be unique within the route",rule="self.all(l1, !has(l1.name) || self.exists_one(l2, has(l2.name) &amp;&amp; l1.name == l2.name))"&gt;
     */
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UDPRouteRule> getRules() {
        return rules;
    }

    /**
     * Rules are a list of UDP matchers and actions.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="Rule name must be unique within the route",rule="self.all(l1, !has(l1.name) || self.exists_one(l2, has(l2.name) &amp;&amp; l1.name == l2.name))"&gt;
     */
    @JsonProperty("rules")
    public void setRules(List<UDPRouteRule> rules) {
        this.rules = rules;
    }

    /**
     * UseDefaultGateways indicates the default Gateway scope to use for this Route. If unset (the default) or set to None, the Route will not be attached to any default Gateway; if set, it will be attached to any default Gateway supporting the named scope, subject to the usual rules about which Routes a Gateway is allowed to claim.<br><p> <br><p> Think carefully before using this functionality! The set of default Gateways supporting the requested scope can change over time without any notice to the Route author, and in many situations it will not be appropriate to request a default Gateway for a given Route -- for example, a Route with specific security requirements should almost certainly not use a default Gateway.<br><p> <br><p> &lt;gateway:experimental&gt;
     */
    @JsonProperty("useDefaultGateways")
    public String getUseDefaultGateways() {
        return useDefaultGateways;
    }

    /**
     * UseDefaultGateways indicates the default Gateway scope to use for this Route. If unset (the default) or set to None, the Route will not be attached to any default Gateway; if set, it will be attached to any default Gateway supporting the named scope, subject to the usual rules about which Routes a Gateway is allowed to claim.<br><p> <br><p> Think carefully before using this functionality! The set of default Gateways supporting the requested scope can change over time without any notice to the Route author, and in many situations it will not be appropriate to request a default Gateway for a given Route -- for example, a Route with specific security requirements should almost certainly not use a default Gateway.<br><p> <br><p> &lt;gateway:experimental&gt;
     */
    @JsonProperty("useDefaultGateways")
    public void setUseDefaultGateways(String useDefaultGateways) {
        this.useDefaultGateways = useDefaultGateways;
    }

    @JsonIgnore
    public UDPRouteSpecBuilder edit() {
        return new UDPRouteSpecBuilder(this);
    }

    @JsonIgnore
    public UDPRouteSpecBuilder toBuilder() {
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
