
package io.fabric8.istio.api.networking.v1beta1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpCookie;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpHeaderName;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBUseSourceIp;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(LoadBalancerSettingsConsistentHashLBHttpHeaderName.class),
    @JsonSubTypes.Type(LoadBalancerSettingsConsistentHashLBHttpCookie.class),
    @JsonSubTypes.Type(LoadBalancerSettingsConsistentHashLBUseSourceIp.class),
    @JsonSubTypes.Type(LoadBalancerSettingsConsistentHashLBHttpQueryParameterName.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
public interface IsLoadBalancerSettingsConsistentHashLBHashKey {


}
