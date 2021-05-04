
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "httpProxy",
    "httpsProxy",
    "noProxy",
    "readinessEndpoints",
    "trustedCA"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ProxySpec implements KubernetesResource
{

    @JsonProperty("httpProxy")
    private String httpProxy;
    @JsonProperty("httpsProxy")
    private String httpsProxy;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("readinessEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> readinessEndpoints = new ArrayList<String>();
    @JsonProperty("trustedCA")
    private ConfigMapNameReference trustedCA;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProxySpec() {
    }

    /**
     * 
     * @param httpProxy
     * @param trustedCA
     * @param httpsProxy
     * @param noProxy
     * @param readinessEndpoints
     */
    public ProxySpec(String httpProxy, String httpsProxy, String noProxy, List<String> readinessEndpoints, ConfigMapNameReference trustedCA) {
        super();
        this.httpProxy = httpProxy;
        this.httpsProxy = httpsProxy;
        this.noProxy = noProxy;
        this.readinessEndpoints = readinessEndpoints;
        this.trustedCA = trustedCA;
    }

    @JsonProperty("httpProxy")
    public String getHttpProxy() {
        return httpProxy;
    }

    @JsonProperty("httpProxy")
    public void setHttpProxy(String httpProxy) {
        this.httpProxy = httpProxy;
    }

    @JsonProperty("httpsProxy")
    public String getHttpsProxy() {
        return httpsProxy;
    }

    @JsonProperty("httpsProxy")
    public void setHttpsProxy(String httpsProxy) {
        this.httpsProxy = httpsProxy;
    }

    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    @JsonProperty("readinessEndpoints")
    public List<String> getReadinessEndpoints() {
        return readinessEndpoints;
    }

    @JsonProperty("readinessEndpoints")
    public void setReadinessEndpoints(List<String> readinessEndpoints) {
        this.readinessEndpoints = readinessEndpoints;
    }

    @JsonProperty("trustedCA")
    public ConfigMapNameReference getTrustedCA() {
        return trustedCA;
    }

    @JsonProperty("trustedCA")
    public void setTrustedCA(ConfigMapNameReference trustedCA) {
        this.trustedCA = trustedCA;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
