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
package internaloauth

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kauthenticator "k8s.io/apiserver/pkg/authentication/authenticator"
	kuser "k8s.io/apiserver/pkg/authentication/user"

	userclient "github.com/openshift/client-go/user/clientset/versioned/typed/user/v1"
	authorizationapi "github.com/openshift/origin/pkg/authorization/apis/authorization"
	oauthclient "github.com/openshift/origin/pkg/oauth/generated/internalclientset/typed/oauth/internalversion"
)

type tokenAuthenticator struct {
	tokens      oauthclient.OAuthAccessTokenInterface
	users       userclient.UserInterface
	groupMapper UserToGroupMapper
	validators  OAuthTokenValidator
}

func NewTokenAuthenticator(tokens oauthclient.OAuthAccessTokenInterface, users userclient.UserInterface, groupMapper UserToGroupMapper, validators ...OAuthTokenValidator) kauthenticator.Token {
	return &tokenAuthenticator{
		tokens:      tokens,
		users:       users,
		groupMapper: groupMapper,
		validators:  OAuthTokenValidators(validators),
	}
}

func (a *tokenAuthenticator) AuthenticateToken(name string) (kuser.Info, bool, error) {
	token, err := a.tokens.Get(name, metav1.GetOptions{})
	if err != nil {
		return nil, false, err
	}

	user, err := a.users.Get(token.UserName, metav1.GetOptions{})
	if err != nil {
		return nil, false, err
	}

	if err := a.validators.Validate(token, user); err != nil {
		return nil, false, err
	}

	groups, err := a.groupMapper.GroupsFor(user.Name)
	if err != nil {
		return nil, false, err
	}
	groupNames := make([]string, 0, len(groups)+len(user.Groups))
	for _, group := range groups {
		groupNames = append(groupNames, group.Name)
	}
	groupNames = append(groupNames, user.Groups...)

	return &kuser.DefaultInfo{
		Name:   user.Name,
		UID:    string(user.UID),
		Groups: groupNames,
		Extra: map[string][]string{
			authorizationapi.ScopesKey: token.Scopes,
		},
	}, true, nil
}
