
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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

/**
 * ParamRef describes how to locate the params to be used as input to expressions of rules applied by a policy binding.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "namespace",
    "parameterNotFoundAction",
    "selector"
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
public class ParamRef implements Editable<ParamRefBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("parameterNotFoundAction")
    private String parameterNotFoundAction;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ParamRef() {
    }

    public ParamRef(String name, String namespace, String parameterNotFoundAction, LabelSelector selector) {
        super();
        this.name = name;
        this.namespace = namespace;
        this.parameterNotFoundAction = parameterNotFoundAction;
        this.selector = selector;
    }

    /**
     * name is the name of the resource being referenced.<br><p> <br><p> One of `name` or `selector` must be set, but `name` and `selector` are mutually exclusive properties. If one is set, the other must be unset.<br><p> <br><p> A single parameter used for all admission requests can be configured by setting the `name` field, leaving `selector` blank, and setting namespace if `paramKind` is namespace-scoped.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the resource being referenced.<br><p> <br><p> One of `name` or `selector` must be set, but `name` and `selector` are mutually exclusive properties. If one is set, the other must be unset.<br><p> <br><p> A single parameter used for all admission requests can be configured by setting the `name` field, leaving `selector` blank, and setting namespace if `paramKind` is namespace-scoped.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace is the namespace of the referenced resource. Allows limiting the search for params to a specific namespace. Applies to both `name` and `selector` fields.<br><p> <br><p> A per-namespace parameter may be used by specifying a namespace-scoped `paramKind` in the policy and leaving this field empty.<br><p> <br><p> - If `paramKind` is cluster-scoped, this field MUST be unset. Setting this field results in a configuration error.<br><p> <br><p> - If `paramKind` is namespace-scoped, the namespace of the object being evaluated for admission will be used when this field is left unset. Take care that if this is left empty the binding must not match any cluster-scoped resources, which will result in an error.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is the namespace of the referenced resource. Allows limiting the search for params to a specific namespace. Applies to both `name` and `selector` fields.<br><p> <br><p> A per-namespace parameter may be used by specifying a namespace-scoped `paramKind` in the policy and leaving this field empty.<br><p> <br><p> - If `paramKind` is cluster-scoped, this field MUST be unset. Setting this field results in a configuration error.<br><p> <br><p> - If `paramKind` is namespace-scoped, the namespace of the object being evaluated for admission will be used when this field is left unset. Take care that if this is left empty the binding must not match any cluster-scoped resources, which will result in an error.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * parameterNotFoundAction controls the behavior of the binding when the resource exists, and name or selector is valid, but there are no parameters matched by the binding. If the value is set to `Allow`, then no matched parameters will be treated as successful validation by the binding. If set to `Deny`, then no matched parameters will be subject to the `failurePolicy` of the policy.<br><p> <br><p> Allowed values are `Allow` or `Deny`<br><p> <br><p> Required
     */
    @JsonProperty("parameterNotFoundAction")
    public String getParameterNotFoundAction() {
        return parameterNotFoundAction;
    }

    /**
     * parameterNotFoundAction controls the behavior of the binding when the resource exists, and name or selector is valid, but there are no parameters matched by the binding. If the value is set to `Allow`, then no matched parameters will be treated as successful validation by the binding. If set to `Deny`, then no matched parameters will be subject to the `failurePolicy` of the policy.<br><p> <br><p> Allowed values are `Allow` or `Deny`<br><p> <br><p> Required
     */
    @JsonProperty("parameterNotFoundAction")
    public void setParameterNotFoundAction(String parameterNotFoundAction) {
        this.parameterNotFoundAction = parameterNotFoundAction;
    }

    /**
     * ParamRef describes how to locate the params to be used as input to expressions of rules applied by a policy binding.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * ParamRef describes how to locate the params to be used as input to expressions of rules applied by a policy binding.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public ParamRefBuilder edit() {
        return new ParamRefBuilder(this);
    }

    @JsonIgnore
    public ParamRefBuilder toBuilder() {
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
        if (!(o instanceof ParamRef)) {
            return false;
        }
        ParamRef other = (ParamRef) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$parameterNotFoundAction = this.getParameterNotFoundAction();
        Object other$parameterNotFoundAction = other.getParameterNotFoundAction();
        if (this$parameterNotFoundAction == null ? other$parameterNotFoundAction != null : !this$parameterNotFoundAction.equals(other$parameterNotFoundAction)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
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
        return other instanceof ParamRef;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $parameterNotFoundAction = this.getParameterNotFoundAction();
        result = result * prime + ($parameterNotFoundAction == null ? 43 : $parameterNotFoundAction.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ParamRef(" + "name=" + this.getName() + ", namespace=" + this.getNamespace() + ", parameterNotFoundAction=" + this.getParameterNotFoundAction() + ", selector=" + this.getSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
