
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

/**
 * IngressControllerCaptureHTTPCookieUnion describes optional fields of an HTTP cookie that should be captured.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matchType",
    "name",
    "namePrefix"
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
public class IngressControllerCaptureHTTPCookieUnion implements Editable<IngressControllerCaptureHTTPCookieUnionBuilder>, KubernetesResource
{

    @JsonProperty("matchType")
    private String matchType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namePrefix")
    private String namePrefix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerCaptureHTTPCookieUnion() {
    }

    public IngressControllerCaptureHTTPCookieUnion(String matchType, String name, String namePrefix) {
        super();
        this.matchType = matchType;
        this.name = name;
        this.namePrefix = namePrefix;
    }

    /**
     * matchType specifies the type of match to be performed on the cookie name.  Allowed values are "Exact" for an exact string match and "Prefix" for a string prefix match.  If "Exact" is specified, a name must be specified in the name field.  If "Prefix" is provided, a prefix must be specified in the namePrefix field.  For example, specifying matchType "Prefix" and namePrefix "foo" will capture a cookie named "foo" or "foobar" but not one named "bar".  The first matching cookie is captured.
     */
    @JsonProperty("matchType")
    public String getMatchType() {
        return matchType;
    }

    /**
     * matchType specifies the type of match to be performed on the cookie name.  Allowed values are "Exact" for an exact string match and "Prefix" for a string prefix match.  If "Exact" is specified, a name must be specified in the name field.  If "Prefix" is provided, a prefix must be specified in the namePrefix field.  For example, specifying matchType "Prefix" and namePrefix "foo" will capture a cookie named "foo" or "foobar" but not one named "bar".  The first matching cookie is captured.
     */
    @JsonProperty("matchType")
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    /**
     * name specifies a cookie name.  Its value must be a valid HTTP cookie name as defined in RFC 6265 section 4.1.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name specifies a cookie name.  Its value must be a valid HTTP cookie name as defined in RFC 6265 section 4.1.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namePrefix specifies a cookie name prefix.  Its value must be a valid HTTP cookie name as defined in RFC 6265 section 4.1.
     */
    @JsonProperty("namePrefix")
    public String getNamePrefix() {
        return namePrefix;
    }

    /**
     * namePrefix specifies a cookie name prefix.  Its value must be a valid HTTP cookie name as defined in RFC 6265 section 4.1.
     */
    @JsonProperty("namePrefix")
    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @JsonIgnore
    public IngressControllerCaptureHTTPCookieUnionBuilder edit() {
        return new IngressControllerCaptureHTTPCookieUnionBuilder(this);
    }

    @JsonIgnore
    public IngressControllerCaptureHTTPCookieUnionBuilder toBuilder() {
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
        if (!(o instanceof IngressControllerCaptureHTTPCookieUnion)) {
            return false;
        }
        IngressControllerCaptureHTTPCookieUnion other = (IngressControllerCaptureHTTPCookieUnion) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$matchType = this.getMatchType();
        Object other$matchType = other.getMatchType();
        if (this$matchType == null ? other$matchType != null : !this$matchType.equals(other$matchType)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namePrefix = this.getNamePrefix();
        Object other$namePrefix = other.getNamePrefix();
        if (this$namePrefix == null ? other$namePrefix != null : !this$namePrefix.equals(other$namePrefix)) {
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
        return other instanceof IngressControllerCaptureHTTPCookieUnion;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $matchType = this.getMatchType();
        result = result * prime + ($matchType == null ? 43 : $matchType.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namePrefix = this.getNamePrefix();
        result = result * prime + ($namePrefix == null ? 43 : $namePrefix.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressControllerCaptureHTTPCookieUnion(" + "matchType=" + this.getMatchType() + ", name=" + this.getName() + ", namePrefix=" + this.getNamePrefix() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
