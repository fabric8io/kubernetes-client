/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.internal.mappers;

import java.util.Map;

import io.fabric8.kubernetes.api.model.AuthInfo;

public class AuthInfoMapper extends PropertyMapper<AuthInfo> {

    private final NamedExtensionsMapper namedExtensionsMapper = new NamedExtensionsMapper();
    private final AuthProviderMapper authProviderConfigMapper = new AuthProviderMapper();
    private final ExecConfigMapper execConfigMapper = new ExecConfigMapper();
    
    @SuppressWarnings("unchecked")
    @Override
    public AuthInfo map(Map<String, Object> mappedBean) {
        final AuthInfo authInfo = new AuthInfo();
        authInfo.setAs(get("as", mappedBean));
        authInfo.setAsGroups(getList("as-groups", mappedBean));
        authInfo.setAsUserExtra(get("as-user-extra", mappedBean, Map.class));
        authInfo.setAuthProvider(get("auth-provider", mappedBean, authProviderConfigMapper));
        authInfo.setClientCertificate(get("client-certificate", mappedBean));
        authInfo.setClientCertificateData(get("client-certificate-data", mappedBean));
        authInfo.setClientKey(get("client-key", mappedBean));
        authInfo.setClientKeyData(get("client-key-data", mappedBean));
        authInfo.setExec(get("exec", mappedBean, execConfigMapper));
        authInfo.setExtensions(getList("extensions", mappedBean, namedExtensionsMapper));
        authInfo.setPassword(get("password", mappedBean));
        authInfo.setToken(get("token", mappedBean));
        authInfo.setTokenFile(get("tokenFile", mappedBean));
        authInfo.setUsername(get("username", mappedBean));
        return authInfo;
    }

}
