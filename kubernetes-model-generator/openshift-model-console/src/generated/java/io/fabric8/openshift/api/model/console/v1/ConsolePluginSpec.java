
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

/**
 * ConsolePluginSpec is the desired plugin configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backend",
    "contentSecurityPolicy",
    "displayName",
    "i18n",
    "proxy"
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
public class ConsolePluginSpec implements Editable<ConsolePluginSpecBuilder>, KubernetesResource
{

    @JsonProperty("backend")
    private ConsolePluginBackend backend;
    @JsonProperty("contentSecurityPolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConsolePluginCSP> contentSecurityPolicy = new ArrayList<>();
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("i18n")
    private ConsolePluginI18n i18n;
    @JsonProperty("proxy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConsolePluginProxy> proxy = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsolePluginSpec() {
    }

    public ConsolePluginSpec(ConsolePluginBackend backend, List<ConsolePluginCSP> contentSecurityPolicy, String displayName, ConsolePluginI18n i18n, List<ConsolePluginProxy> proxy) {
        super();
        this.backend = backend;
        this.contentSecurityPolicy = contentSecurityPolicy;
        this.displayName = displayName;
        this.i18n = i18n;
        this.proxy = proxy;
    }

    /**
     * ConsolePluginSpec is the desired plugin configuration.
     */
    @JsonProperty("backend")
    public ConsolePluginBackend getBackend() {
        return backend;
    }

    /**
     * ConsolePluginSpec is the desired plugin configuration.
     */
    @JsonProperty("backend")
    public void setBackend(ConsolePluginBackend backend) {
        this.backend = backend;
    }

    /**
     * contentSecurityPolicy is a list of Content-Security-Policy (CSP) directives for the plugin. Each directive specifies a list of values, appropriate for the given directive type, for example a list of remote endpoints for fetch directives such as ScriptSrc. Console web application uses CSP to detect and mitigate certain types of attacks, such as cross-site scripting (XSS) and data injection attacks. Dynamic plugins should specify this field if need to load assets from outside the cluster or if violation reports are observed. Dynamic plugins should always prefer loading their assets from within the cluster, either by vendoring them, or fetching from a cluster service. CSP violation reports can be viewed in the browser's console logs during development and testing of the plugin in the OpenShift web console. Available directive types are DefaultSrc, ScriptSrc, StyleSrc, ImgSrc, FontSrc and ConnectSrc. Each of the available directives may be defined only once in the list. The value 'self' is automatically included in all fetch directives by the OpenShift web console's backend. For more information about the CSP directives, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy<br><p> <br><p> The OpenShift web console server aggregates the CSP directives and values across its own default values and all enabled ConsolePlugin CRs, merging them into a single policy string that is sent to the browser via `Content-Security-Policy` HTTP response header.<br><p> <br><p> Example:<br><p>   ConsolePlugin A directives:<br><p>     script-src: https://script1.com/, https://script2.com/<br><p>     font-src: https://font1.com/<br><p> <br><p>   ConsolePlugin B directives:<br><p>     script-src: https://script2.com/, https://script3.com/<br><p>     font-src: https://font2.com/<br><p>     img-src: https://img1.com/<br><p> <br><p>   Unified set of CSP directives, passed to the OpenShift web console server:<br><p>     script-src: https://script1.com/, https://script2.com/, https://script3.com/<br><p>     font-src: https://font1.com/, https://font2.com/<br><p>     img-src: https://img1.com/<br><p> <br><p>   OpenShift web console server CSP response header:<br><p>     Content-Security-Policy: default-src 'self'; base-uri 'self'; script-src 'self' https://script1.com/ https://script2.com/ https://script3.com/; font-src 'self' https://font1.com/ https://font2.com/; img-src 'self' https://img1.com/; style-src 'self'; frame-src 'none'; object-src 'none'
     */
    @JsonProperty("contentSecurityPolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConsolePluginCSP> getContentSecurityPolicy() {
        return contentSecurityPolicy;
    }

    /**
     * contentSecurityPolicy is a list of Content-Security-Policy (CSP) directives for the plugin. Each directive specifies a list of values, appropriate for the given directive type, for example a list of remote endpoints for fetch directives such as ScriptSrc. Console web application uses CSP to detect and mitigate certain types of attacks, such as cross-site scripting (XSS) and data injection attacks. Dynamic plugins should specify this field if need to load assets from outside the cluster or if violation reports are observed. Dynamic plugins should always prefer loading their assets from within the cluster, either by vendoring them, or fetching from a cluster service. CSP violation reports can be viewed in the browser's console logs during development and testing of the plugin in the OpenShift web console. Available directive types are DefaultSrc, ScriptSrc, StyleSrc, ImgSrc, FontSrc and ConnectSrc. Each of the available directives may be defined only once in the list. The value 'self' is automatically included in all fetch directives by the OpenShift web console's backend. For more information about the CSP directives, see: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy<br><p> <br><p> The OpenShift web console server aggregates the CSP directives and values across its own default values and all enabled ConsolePlugin CRs, merging them into a single policy string that is sent to the browser via `Content-Security-Policy` HTTP response header.<br><p> <br><p> Example:<br><p>   ConsolePlugin A directives:<br><p>     script-src: https://script1.com/, https://script2.com/<br><p>     font-src: https://font1.com/<br><p> <br><p>   ConsolePlugin B directives:<br><p>     script-src: https://script2.com/, https://script3.com/<br><p>     font-src: https://font2.com/<br><p>     img-src: https://img1.com/<br><p> <br><p>   Unified set of CSP directives, passed to the OpenShift web console server:<br><p>     script-src: https://script1.com/, https://script2.com/, https://script3.com/<br><p>     font-src: https://font1.com/, https://font2.com/<br><p>     img-src: https://img1.com/<br><p> <br><p>   OpenShift web console server CSP response header:<br><p>     Content-Security-Policy: default-src 'self'; base-uri 'self'; script-src 'self' https://script1.com/ https://script2.com/ https://script3.com/; font-src 'self' https://font1.com/ https://font2.com/; img-src 'self' https://img1.com/; style-src 'self'; frame-src 'none'; object-src 'none'
     */
    @JsonProperty("contentSecurityPolicy")
    public void setContentSecurityPolicy(List<ConsolePluginCSP> contentSecurityPolicy) {
        this.contentSecurityPolicy = contentSecurityPolicy;
    }

    /**
     * displayName is the display name of the plugin. The dispalyName should be between 1 and 128 characters.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * displayName is the display name of the plugin. The dispalyName should be between 1 and 128 characters.
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * ConsolePluginSpec is the desired plugin configuration.
     */
    @JsonProperty("i18n")
    public ConsolePluginI18n getI18n() {
        return i18n;
    }

    /**
     * ConsolePluginSpec is the desired plugin configuration.
     */
    @JsonProperty("i18n")
    public void setI18n(ConsolePluginI18n i18n) {
        this.i18n = i18n;
    }

    /**
     * proxy is a list of proxies that describe various service type to which the plugin needs to connect to.
     */
    @JsonProperty("proxy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConsolePluginProxy> getProxy() {
        return proxy;
    }

    /**
     * proxy is a list of proxies that describe various service type to which the plugin needs to connect to.
     */
    @JsonProperty("proxy")
    public void setProxy(List<ConsolePluginProxy> proxy) {
        this.proxy = proxy;
    }

    @JsonIgnore
    public ConsolePluginSpecBuilder edit() {
        return new ConsolePluginSpecBuilder(this);
    }

    @JsonIgnore
    public ConsolePluginSpecBuilder toBuilder() {
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
        if (!(o instanceof ConsolePluginSpec)) {
            return false;
        }
        ConsolePluginSpec other = (ConsolePluginSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$backend = this.getBackend();
        Object other$backend = other.getBackend();
        if (this$backend == null ? other$backend != null : !this$backend.equals(other$backend)) {
            return false;
        }
        Object this$contentSecurityPolicy = this.getContentSecurityPolicy();
        Object other$contentSecurityPolicy = other.getContentSecurityPolicy();
        if (this$contentSecurityPolicy == null ? other$contentSecurityPolicy != null : !this$contentSecurityPolicy.equals(other$contentSecurityPolicy)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$i18n = this.getI18n();
        Object other$i18n = other.getI18n();
        if (this$i18n == null ? other$i18n != null : !this$i18n.equals(other$i18n)) {
            return false;
        }
        Object this$proxy = this.getProxy();
        Object other$proxy = other.getProxy();
        if (this$proxy == null ? other$proxy != null : !this$proxy.equals(other$proxy)) {
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
        return other instanceof ConsolePluginSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $backend = this.getBackend();
        result = result * prime + ($backend == null ? 43 : $backend.hashCode());
        Object $contentSecurityPolicy = this.getContentSecurityPolicy();
        result = result * prime + ($contentSecurityPolicy == null ? 43 : $contentSecurityPolicy.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $i18n = this.getI18n();
        result = result * prime + ($i18n == null ? 43 : $i18n.hashCode());
        Object $proxy = this.getProxy();
        result = result * prime + ($proxy == null ? 43 : $proxy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsolePluginSpec(" + "backend=" + this.getBackend() + ", contentSecurityPolicy=" + this.getContentSecurityPolicy() + ", displayName=" + this.getDisplayName() + ", i18n=" + this.getI18n() + ", proxy=" + this.getProxy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
