
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Policy for upgrading http1.1 connections to http2.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy 
{
    DEFAULT(0),
    DO_NOT_UPGRADE(1),
    UPGRADE(2);
    private final int value;
    private ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy fromValue(Object value) {
        if (value instanceof String) {
            for (ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy e : ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy e : ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
