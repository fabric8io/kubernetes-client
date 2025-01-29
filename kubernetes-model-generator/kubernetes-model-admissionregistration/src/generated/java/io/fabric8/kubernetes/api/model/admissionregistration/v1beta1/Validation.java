
package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * Validation specifies the CEL expression which is used to apply the validation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expression",
    "message",
    "messageExpression",
    "reason"
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
public class Validation implements Editable<ValidationBuilder>, KubernetesResource
{

    @JsonProperty("expression")
    private String expression;
    @JsonProperty("message")
    private String message;
    @JsonProperty("messageExpression")
    private String messageExpression;
    @JsonProperty("reason")
    private String reason;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Validation() {
    }

    public Validation(String expression, String message, String messageExpression, String reason) {
        super();
        this.expression = expression;
        this.message = message;
        this.messageExpression = messageExpression;
        this.reason = reason;
    }

    /**
     * Expression represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec CEL expressions have access to the contents of the API request/response, organized into CEL variables as well as some other useful variables:<br><p> <br><p> - 'object' - The object from the incoming request. The value is null for DELETE requests. - 'oldObject' - The existing object. The value is null for CREATE requests. - 'request' - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - 'params' - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - 'namespaceObject' - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - 'variables' - Map of composited variables, from its name to its lazily evaluated value.<br><p>   For example, a variable named 'foo' can be accessed as 'variables.foo'.<br><p> - 'authorizer' - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.<br><p>   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz<br><p> - 'authorizer.requestResource' - A CEL ResourceCheck constructed from the 'authorizer' and configured with the<br><p>   request resource.<br><p> <br><p> The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object. No other metadata properties are accessible.<br><p> <br><p> Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]&#42;` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - '__' escapes to '__underscores__' - '.' escapes to '__dot__' - '-' escapes to '__dash__' - '/' escapes to '__slash__' - Property names that exactly match a CEL RESERVED keyword escape to '__{keyword}__'. The keywords are:<br><p> 	  "true", "false", "null", "in", "as", "break", "const", "continue", "else", "for", "function", "if",<br><p> 	  "import", "let", "loop", "package", "namespace", "return".<br><p> Examples:<br><p>   - Expression accessing a property named "namespace": {"Expression": "object.__namespace__ &gt; 0"}<br><p>   - Expression accessing a property named "x-prop": {"Expression": "object.x__dash__prop &gt; 0"}<br><p>   - Expression accessing a property named "redact__d": {"Expression": "object.redact__underscores__d &gt; 0"}<br><p> <br><p> Equality on arrays with list type of 'set' or 'map' ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:<br><p>   - 'set': `X + Y` performs a union where the array positions of all elements in `X` are preserved and<br><p>     non-intersecting elements in `Y` are appended, retaining their partial order.<br><p>   - 'map': `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values<br><p>     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with<br><p>     non-intersecting keys are appended, retaining their partial order.<br><p> Required.
     */
    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    /**
     * Expression represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec CEL expressions have access to the contents of the API request/response, organized into CEL variables as well as some other useful variables:<br><p> <br><p> - 'object' - The object from the incoming request. The value is null for DELETE requests. - 'oldObject' - The existing object. The value is null for CREATE requests. - 'request' - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - 'params' - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - 'namespaceObject' - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - 'variables' - Map of composited variables, from its name to its lazily evaluated value.<br><p>   For example, a variable named 'foo' can be accessed as 'variables.foo'.<br><p> - 'authorizer' - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.<br><p>   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz<br><p> - 'authorizer.requestResource' - A CEL ResourceCheck constructed from the 'authorizer' and configured with the<br><p>   request resource.<br><p> <br><p> The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object. No other metadata properties are accessible.<br><p> <br><p> Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]&#42;` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - '__' escapes to '__underscores__' - '.' escapes to '__dot__' - '-' escapes to '__dash__' - '/' escapes to '__slash__' - Property names that exactly match a CEL RESERVED keyword escape to '__{keyword}__'. The keywords are:<br><p> 	  "true", "false", "null", "in", "as", "break", "const", "continue", "else", "for", "function", "if",<br><p> 	  "import", "let", "loop", "package", "namespace", "return".<br><p> Examples:<br><p>   - Expression accessing a property named "namespace": {"Expression": "object.__namespace__ &gt; 0"}<br><p>   - Expression accessing a property named "x-prop": {"Expression": "object.x__dash__prop &gt; 0"}<br><p>   - Expression accessing a property named "redact__d": {"Expression": "object.redact__underscores__d &gt; 0"}<br><p> <br><p> Equality on arrays with list type of 'set' or 'map' ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:<br><p>   - 'set': `X + Y` performs a union where the array positions of all elements in `X` are preserved and<br><p>     non-intersecting elements in `Y` are appended, retaining their partial order.<br><p>   - 'map': `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values<br><p>     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with<br><p>     non-intersecting keys are appended, retaining their partial order.<br><p> Required.
     */
    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Message represents the message displayed when validation fails. The message is required if the Expression contains line breaks. The message must not contain line breaks. If unset, the message is "failed rule: {Rule}". e.g. "must be a URL with the host matching spec.host" If the Expression contains line breaks. Message is required. The message must not contain line breaks. If unset, the message is "failed Expression: {Expression}".
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message represents the message displayed when validation fails. The message is required if the Expression contains line breaks. The message must not contain line breaks. If unset, the message is "failed rule: {Rule}". e.g. "must be a URL with the host matching spec.host" If the Expression contains line breaks. Message is required. The message must not contain line breaks. If unset, the message is "failed Expression: {Expression}".
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * messageExpression declares a CEL expression that evaluates to the validation failure message that is returned when this rule fails. Since messageExpression is used as a failure message, it must evaluate to a string. If both message and messageExpression are present on a validation, then messageExpression will be used if validation fails. If messageExpression results in a runtime error, the runtime error is logged, and the validation failure message is produced as if the messageExpression field were unset. If messageExpression evaluates to an empty string, a string with only spaces, or a string that contains line breaks, then the validation failure message will also be produced as if the messageExpression field were unset, and the fact that messageExpression produced an empty string/string with only spaces/string with line breaks will be logged. messageExpression has access to all the same variables as the `expression` except for 'authorizer' and 'authorizer.requestResource'. Example: "object.x must be less than max ("+string(params.max)+")"
     */
    @JsonProperty("messageExpression")
    public String getMessageExpression() {
        return messageExpression;
    }

    /**
     * messageExpression declares a CEL expression that evaluates to the validation failure message that is returned when this rule fails. Since messageExpression is used as a failure message, it must evaluate to a string. If both message and messageExpression are present on a validation, then messageExpression will be used if validation fails. If messageExpression results in a runtime error, the runtime error is logged, and the validation failure message is produced as if the messageExpression field were unset. If messageExpression evaluates to an empty string, a string with only spaces, or a string that contains line breaks, then the validation failure message will also be produced as if the messageExpression field were unset, and the fact that messageExpression produced an empty string/string with only spaces/string with line breaks will be logged. messageExpression has access to all the same variables as the `expression` except for 'authorizer' and 'authorizer.requestResource'. Example: "object.x must be less than max ("+string(params.max)+")"
     */
    @JsonProperty("messageExpression")
    public void setMessageExpression(String messageExpression) {
        this.messageExpression = messageExpression;
    }

    /**
     * Reason represents a machine-readable description of why this validation failed. If this is the first validation in the list to fail, this reason, as well as the corresponding HTTP response code, are used in the HTTP response to the client. The currently supported reasons are: "Unauthorized", "Forbidden", "Invalid", "RequestEntityTooLarge". If not set, StatusReasonInvalid is used in the response to the client.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Reason represents a machine-readable description of why this validation failed. If this is the first validation in the list to fail, this reason, as well as the corresponding HTTP response code, are used in the HTTP response to the client. The currently supported reasons are: "Unauthorized", "Forbidden", "Invalid", "RequestEntityTooLarge". If not set, StatusReasonInvalid is used in the response to the client.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonIgnore
    public ValidationBuilder edit() {
        return new ValidationBuilder(this);
    }

    @JsonIgnore
    public ValidationBuilder toBuilder() {
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
