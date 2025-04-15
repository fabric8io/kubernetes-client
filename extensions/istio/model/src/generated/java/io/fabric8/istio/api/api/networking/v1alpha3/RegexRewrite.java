
package io.fabric8.istio.api.api.networking.v1alpha3;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "match",
    "rewrite"
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
public class RegexRewrite implements Editable<RegexRewriteBuilder>, KubernetesResource
{

    @JsonProperty("match")
    private String match;
    @JsonProperty("rewrite")
    private String rewrite;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RegexRewrite() {
    }

    public RegexRewrite(String match, String rewrite) {
        super();
        this.match = match;
        this.rewrite = rewrite;
    }

    /**
     * [RE2 style regex-based match](https://github.com/google/re2/wiki/Syntax).
     */
    @JsonProperty("match")
    public String getMatch() {
        return match;
    }

    /**
     * [RE2 style regex-based match](https://github.com/google/re2/wiki/Syntax).
     */
    @JsonProperty("match")
    public void setMatch(String match) {
        this.match = match;
    }

    /**
     * The string that should replace into matching portions of original URI. Capture groups in the pattern can be referenced in the new URI. Examples:<br><p> <br><p> Example 1: rewrite with capture groups Path pattern "/service/update/v1/api" with match "^/service/([^/]+)(/.&#42;)$" and rewrite string of "/customprefix/\2/\1" would transform into "/customprefix/v1/api/update".<br><p> <br><p> Example 2: case insensitive rewrite Path pattern "/aaa/XxX/bbb" with match "(?i)/xxx/" and a rewrite string of /yyy/ would do a case-insensitive match and transform the path to "/aaa/yyy/bbb".
     */
    @JsonProperty("rewrite")
    public String getRewrite() {
        return rewrite;
    }

    /**
     * The string that should replace into matching portions of original URI. Capture groups in the pattern can be referenced in the new URI. Examples:<br><p> <br><p> Example 1: rewrite with capture groups Path pattern "/service/update/v1/api" with match "^/service/([^/]+)(/.&#42;)$" and rewrite string of "/customprefix/\2/\1" would transform into "/customprefix/v1/api/update".<br><p> <br><p> Example 2: case insensitive rewrite Path pattern "/aaa/XxX/bbb" with match "(?i)/xxx/" and a rewrite string of /yyy/ would do a case-insensitive match and transform the path to "/aaa/yyy/bbb".
     */
    @JsonProperty("rewrite")
    public void setRewrite(String rewrite) {
        this.rewrite = rewrite;
    }

    @JsonIgnore
    public RegexRewriteBuilder edit() {
        return new RegexRewriteBuilder(this);
    }

    @JsonIgnore
    public RegexRewriteBuilder toBuilder() {
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
