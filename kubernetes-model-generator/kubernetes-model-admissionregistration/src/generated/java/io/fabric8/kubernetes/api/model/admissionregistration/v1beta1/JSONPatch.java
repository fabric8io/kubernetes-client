
package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

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
 * JSONPatch defines a JSON Patch.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expression"
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
public class JSONPatch implements Editable<JSONPatchBuilder>, KubernetesResource
{

    @JsonProperty("expression")
    private String expression;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JSONPatch() {
    }

    public JSONPatch(String expression) {
        super();
        this.expression = expression;
    }

    /**
     * expression will be evaluated by CEL to create a [JSON patch](https://jsonpatch.com/). ref: https://github.com/google/cel-spec<br><p> <br><p> expression must return an array of JSONPatch values.<br><p> <br><p> For example, this CEL expression returns a JSON patch to conditionally modify a value:<br><p> <br><p> 	  [<br><p> 	    JSONPatch{op: "test", path: "/spec/example", value: "Red"},<br><p> 	    JSONPatch{op: "replace", path: "/spec/example", value: "Green"}<br><p> 	  ]<br><p> <br><p> To define an object for the patch value, use Object types. For example:<br><p> <br><p> 	  [<br><p> 	    JSONPatch{<br><p> 	      op: "add",<br><p> 	      path: "/spec/selector",<br><p> 	      value: Object.spec.selector{matchLabels: {"environment": "test"}}<br><p> 	    }<br><p> 	  ]<br><p> <br><p> To use strings containing '/' and '~' as JSONPatch path keys, use "jsonpatch.escapeKey". For example:<br><p> <br><p> 	  [<br><p> 	    JSONPatch{<br><p> 	      op: "add",<br><p> 	      path: "/metadata/labels/" + jsonpatch.escapeKey("example.com/environment"),<br><p> 	      value: "test"<br><p> 	    },<br><p> 	  ]<br><p> <br><p> CEL expressions have access to the types needed to create JSON patches and objects:<br><p> <br><p> - 'JSONPatch' - CEL type of JSON Patch operations. JSONPatch has the fields 'op', 'from', 'path' and 'value'.<br><p>   See [JSON patch](https://jsonpatch.com/) for more details. The 'value' field may be set to any of: string,<br><p>   integer, array, map or object.  If set, the 'path' and 'from' fields must be set to a<br><p>   [JSON pointer](https://datatracker.ietf.org/doc/html/rfc6901/) string, where the 'jsonpatch.escapeKey()' CEL<br><p>   function may be used to escape path keys containing '/' and '~'.<br><p> - 'Object' - CEL type of the resource object. - 'Object.&lt;fieldName&gt;' - CEL type of object field (such as 'Object.spec') - 'Object.&lt;fieldName1&gt;.&lt;fieldName2&gt;...&lt;fieldNameN&gt;` - CEL type of nested field (such as 'Object.spec.containers')<br><p> <br><p> CEL expressions have access to the contents of the API request, organized into CEL variables as well as some other useful variables:<br><p> <br><p> - 'object' - The object from the incoming request. The value is null for DELETE requests. - 'oldObject' - The existing object. The value is null for CREATE requests. - 'request' - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - 'params' - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - 'namespaceObject' - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - 'variables' - Map of composited variables, from its name to its lazily evaluated value.<br><p>   For example, a variable named 'foo' can be accessed as 'variables.foo'.<br><p> - 'authorizer' - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.<br><p>   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz<br><p> - 'authorizer.requestResource' - A CEL ResourceCheck constructed from the 'authorizer' and configured with the<br><p>   request resource.<br><p> <br><p> CEL expressions have access to [Kubernetes CEL function libraries](https://kubernetes.io/docs/reference/using-api/cel/#cel-options-language-features-and-libraries) as well as:<br><p> <br><p> - 'jsonpatch.escapeKey' - Performs JSONPatch key escaping. '~' and  '/' are escaped as '~0' and `~1' respectively).<br><p> <br><p> Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]&#42;` are accessible. Required.
     */
    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    /**
     * expression will be evaluated by CEL to create a [JSON patch](https://jsonpatch.com/). ref: https://github.com/google/cel-spec<br><p> <br><p> expression must return an array of JSONPatch values.<br><p> <br><p> For example, this CEL expression returns a JSON patch to conditionally modify a value:<br><p> <br><p> 	  [<br><p> 	    JSONPatch{op: "test", path: "/spec/example", value: "Red"},<br><p> 	    JSONPatch{op: "replace", path: "/spec/example", value: "Green"}<br><p> 	  ]<br><p> <br><p> To define an object for the patch value, use Object types. For example:<br><p> <br><p> 	  [<br><p> 	    JSONPatch{<br><p> 	      op: "add",<br><p> 	      path: "/spec/selector",<br><p> 	      value: Object.spec.selector{matchLabels: {"environment": "test"}}<br><p> 	    }<br><p> 	  ]<br><p> <br><p> To use strings containing '/' and '~' as JSONPatch path keys, use "jsonpatch.escapeKey". For example:<br><p> <br><p> 	  [<br><p> 	    JSONPatch{<br><p> 	      op: "add",<br><p> 	      path: "/metadata/labels/" + jsonpatch.escapeKey("example.com/environment"),<br><p> 	      value: "test"<br><p> 	    },<br><p> 	  ]<br><p> <br><p> CEL expressions have access to the types needed to create JSON patches and objects:<br><p> <br><p> - 'JSONPatch' - CEL type of JSON Patch operations. JSONPatch has the fields 'op', 'from', 'path' and 'value'.<br><p>   See [JSON patch](https://jsonpatch.com/) for more details. The 'value' field may be set to any of: string,<br><p>   integer, array, map or object.  If set, the 'path' and 'from' fields must be set to a<br><p>   [JSON pointer](https://datatracker.ietf.org/doc/html/rfc6901/) string, where the 'jsonpatch.escapeKey()' CEL<br><p>   function may be used to escape path keys containing '/' and '~'.<br><p> - 'Object' - CEL type of the resource object. - 'Object.&lt;fieldName&gt;' - CEL type of object field (such as 'Object.spec') - 'Object.&lt;fieldName1&gt;.&lt;fieldName2&gt;...&lt;fieldNameN&gt;` - CEL type of nested field (such as 'Object.spec.containers')<br><p> <br><p> CEL expressions have access to the contents of the API request, organized into CEL variables as well as some other useful variables:<br><p> <br><p> - 'object' - The object from the incoming request. The value is null for DELETE requests. - 'oldObject' - The existing object. The value is null for CREATE requests. - 'request' - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - 'params' - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - 'namespaceObject' - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - 'variables' - Map of composited variables, from its name to its lazily evaluated value.<br><p>   For example, a variable named 'foo' can be accessed as 'variables.foo'.<br><p> - 'authorizer' - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.<br><p>   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz<br><p> - 'authorizer.requestResource' - A CEL ResourceCheck constructed from the 'authorizer' and configured with the<br><p>   request resource.<br><p> <br><p> CEL expressions have access to [Kubernetes CEL function libraries](https://kubernetes.io/docs/reference/using-api/cel/#cel-options-language-features-and-libraries) as well as:<br><p> <br><p> - 'jsonpatch.escapeKey' - Performs JSONPatch key escaping. '~' and  '/' are escaped as '~0' and `~1' respectively).<br><p> <br><p> Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]&#42;` are accessible. Required.
     */
    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
    }

    @JsonIgnore
    public JSONPatchBuilder edit() {
        return new JSONPatchBuilder(this);
    }

    @JsonIgnore
    public JSONPatchBuilder toBuilder() {
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
