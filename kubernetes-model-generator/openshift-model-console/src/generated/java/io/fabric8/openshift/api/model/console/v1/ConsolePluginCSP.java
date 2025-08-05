
package io.fabric8.openshift.api.model.console.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ConsolePluginCSP holds configuration for a specific CSP directive
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "directive",
    "values"
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
public class ConsolePluginCSP implements Editable<ConsolePluginCSPBuilder>, KubernetesResource
{

    @JsonProperty("directive")
    private String directive;
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> values = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsolePluginCSP() {
    }

    public ConsolePluginCSP(String directive, List<String> values) {
        super();
        this.directive = directive;
        this.values = values;
    }

    /**
     * directive specifies which Content-Security-Policy directive to configure. Available directive types are DefaultSrc, ScriptSrc, StyleSrc, ImgSrc, FontSrc and ConnectSrc. DefaultSrc directive serves as a fallback for the other CSP fetch directives. For more information about the DefaultSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/default-src ScriptSrc directive specifies valid sources for JavaScript. For more information about the ScriptSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/script-src StyleSrc directive specifies valid sources for stylesheets. For more information about the StyleSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/style-src ImgSrc directive specifies a valid sources of images and favicons. For more information about the ImgSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/img-src FontSrc directive specifies valid sources for fonts loaded using @font-face. For more information about the FontSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/font-src ConnectSrc directive restricts the URLs which can be loaded using script interfaces. For more information about the ConnectSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/connect-src<br><p> <br><p> Possible enum values:<br><p>  - `"ConnectSrc"` directive restricts the URLs which can be loaded using script interfaces. For more information about the ConnectSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/connect-src<br><p>  - `"DefaultSrc"` directive serves as a fallback for the other CSP fetch directives. For more information about the DefaultSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/default-src<br><p>  - `"FontSrc"` directive specifies valid sources for fonts loaded using @font-face. For more information about the FontSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/font-src<br><p>  - `"ImgSrc"` directive specifies a valid sources of images and favicons. For more information about the ImgSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/img-src<br><p>  - `"ScriptSrc"` directive specifies valid sources for JavaScript. For more information about the ScriptSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/script-src<br><p>  - `"StyleSrc"` directive specifies valid sources for stylesheets. For more information about the StyleSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/style-src
     */
    @JsonProperty("directive")
    public String getDirective() {
        return directive;
    }

    /**
     * directive specifies which Content-Security-Policy directive to configure. Available directive types are DefaultSrc, ScriptSrc, StyleSrc, ImgSrc, FontSrc and ConnectSrc. DefaultSrc directive serves as a fallback for the other CSP fetch directives. For more information about the DefaultSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/default-src ScriptSrc directive specifies valid sources for JavaScript. For more information about the ScriptSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/script-src StyleSrc directive specifies valid sources for stylesheets. For more information about the StyleSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/style-src ImgSrc directive specifies a valid sources of images and favicons. For more information about the ImgSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/img-src FontSrc directive specifies valid sources for fonts loaded using @font-face. For more information about the FontSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/font-src ConnectSrc directive restricts the URLs which can be loaded using script interfaces. For more information about the ConnectSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/connect-src<br><p> <br><p> Possible enum values:<br><p>  - `"ConnectSrc"` directive restricts the URLs which can be loaded using script interfaces. For more information about the ConnectSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/connect-src<br><p>  - `"DefaultSrc"` directive serves as a fallback for the other CSP fetch directives. For more information about the DefaultSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/default-src<br><p>  - `"FontSrc"` directive specifies valid sources for fonts loaded using @font-face. For more information about the FontSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/font-src<br><p>  - `"ImgSrc"` directive specifies a valid sources of images and favicons. For more information about the ImgSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/img-src<br><p>  - `"ScriptSrc"` directive specifies valid sources for JavaScript. For more information about the ScriptSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/script-src<br><p>  - `"StyleSrc"` directive specifies valid sources for stylesheets. For more information about the StyleSrc directive, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy/style-src
     */
    @JsonProperty("directive")
    public void setDirective(String directive) {
        this.directive = directive;
    }

    /**
     * values defines an array of values to append to the console defaults for this directive. Each ConsolePlugin may define their own directives with their values. These will be set by the OpenShift web console's backend, as part of its Content-Security-Policy header. The array can contain at most 16 values. Each directive value must have a maximum length of 1024 characters and must not contain whitespace, commas (,), semicolons (;) or single quotes ('). The value '&#42;' is not permitted. Each value in the array must be unique.
     */
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getValues() {
        return values;
    }

    /**
     * values defines an array of values to append to the console defaults for this directive. Each ConsolePlugin may define their own directives with their values. These will be set by the OpenShift web console's backend, as part of its Content-Security-Policy header. The array can contain at most 16 values. Each directive value must have a maximum length of 1024 characters and must not contain whitespace, commas (,), semicolons (;) or single quotes ('). The value '&#42;' is not permitted. Each value in the array must be unique.
     */
    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
    }

    @JsonIgnore
    public ConsolePluginCSPBuilder edit() {
        return new ConsolePluginCSPBuilder(this);
    }

    @JsonIgnore
    public ConsolePluginCSPBuilder toBuilder() {
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
