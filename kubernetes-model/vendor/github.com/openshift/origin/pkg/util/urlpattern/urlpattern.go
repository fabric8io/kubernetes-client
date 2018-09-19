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
package urlpattern

import (
	"errors"
	"net/url"
	"regexp"
	"sort"
	"strings"
)

var InvalidPatternError = errors.New("invalid pattern")

var urlPatternRegex = regexp.MustCompile(`^` +
	`(?:(\*|git|http|https|ssh)://)` +
	`(\*|(?:\*\.)?[^@/*]+)` +
	`(/.*)` +
	`$`)

type URLPattern struct {
	pattern string // original pattern text

	schemeRegexp *regexp.Regexp
	hostRegexp   *regexp.Regexp
	pathRegexp   *regexp.Regexp

	Cookie interface{}

	// for test
	scheme string
	host   string
	path   string
}

func NewURLPattern(pattern string) (*URLPattern, error) {
	err := InvalidPatternError

	match := urlPatternRegex.FindStringSubmatch(pattern)
	if match == nil {
		return nil, err
	}

	urlPattern := URLPattern{pattern: pattern}

	if match[1] == "*" {
		urlPattern.scheme = `^(git|http|https|ssh)$`
	} else {
		urlPattern.scheme = `^` + regexp.QuoteMeta(match[1]) + `$`
	}

	urlPattern.schemeRegexp, err = regexp.Compile(urlPattern.scheme)
	if err != nil {
		return nil, err
	}

	if match[2] == "*" {
		urlPattern.host = `^.*$`
	} else if strings.HasPrefix(match[2], "*.") {
		urlPattern.host = `^(?:.*\.)?` + regexp.QuoteMeta(match[2][2:]) + `$`
	} else {
		urlPattern.host = `^` + regexp.QuoteMeta(match[2]) + `$`
	}

	urlPattern.hostRegexp, err = regexp.Compile(urlPattern.host)
	if err != nil {
		return nil, err
	}

	parts := strings.Split(match[3], "*")
	for i := range parts {
		parts[i] = regexp.QuoteMeta(parts[i])
	}
	urlPattern.path = `^` + strings.Join(parts, `.*`) + `$`

	urlPattern.pathRegexp, err = regexp.Compile(urlPattern.path)
	if err != nil {
		return nil, err
	}

	return &urlPattern, nil
}

func (pattern *URLPattern) match(url *url.URL) bool {
	return pattern.schemeRegexp.MatchString(url.Scheme) &&
		pattern.hostRegexp.MatchString(url.Host) &&
		pattern.pathRegexp.MatchString(url.Path)
}

type byLength []*URLPattern

func (patterns byLength) Len() int {
	return len(patterns)
}

func (patterns byLength) Swap(i, j int) {
	patterns[i], patterns[j] = patterns[j], patterns[i]
}

func (patterns byLength) Less(i, j int) bool {
	return len(patterns[i].pattern) < len(patterns[j].pattern)
}

func Match(patterns []*URLPattern, url *url.URL) *URLPattern {
	sort.Sort(sort.Reverse(byLength(patterns)))
	for _, pattern := range patterns {
		if pattern.match(url) {
			return pattern
		}
	}
	return nil
}
