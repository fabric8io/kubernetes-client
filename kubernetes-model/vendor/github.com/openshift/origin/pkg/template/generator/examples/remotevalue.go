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
package examples

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"regexp"
	"strings"
)

// RemoteValueGenerator implements GeneratorInterface. It fetches random value
// from an external url endpoint based on the "[GET:<url>]" input expression.
//
// Example:
//   - "[GET:http://api.example.com/generateRandomValue]"
type RemoteValueGenerator struct {
}

var remoteExp = regexp.MustCompile(`\[GET\:(http(s)?:\/\/(.+))\]`)

// NewRemoteValueGenerator creates new RemoteValueGenerator.
func NewRemoteValueGenerator() RemoteValueGenerator {
	return RemoteValueGenerator{}
}

// GenerateValue fetches random value from an external url. The input
// expression must be of the form "[GET:<url>]".
func (g RemoteValueGenerator) GenerateValue(expression string) (interface{}, error) {
	matches := remoteExp.FindAllStringIndex(expression, -1)
	if len(matches) < 1 {
		return expression, fmt.Errorf("no matches found.")
	}
	for _, r := range matches {
		response, err := http.Get(expression[5 : len(expression)-1])
		if err != nil {
			return "", err
		}
		defer response.Body.Close()
		body, err := ioutil.ReadAll(response.Body)
		if err != nil {
			return "", err
		}
		expression = strings.Replace(expression, expression[r[0]:r[1]], strings.TrimSpace(string(body)), 1)
	}
	return expression, nil
}
