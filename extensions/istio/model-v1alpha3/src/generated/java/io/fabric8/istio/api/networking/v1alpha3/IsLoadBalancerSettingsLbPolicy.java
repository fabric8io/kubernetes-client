
package io.fabric8.istio.api.networking.v1alpha3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHash;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsSimple;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(LoadBalancerSettingsConsistentHash.class),
    @JsonSubTypes.Type(LoadBalancerSettingsSimple.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
public interface IsLoadBalancerSettingsLbPolicy {


}
