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
package stack

import (
	"fmt"

	"github.com/openshift/origin/tools/junitreport/pkg/api"
)

// TestSuiteStack is a data structure that holds api.TestSuite objects in a LIFO
type TestSuiteStack interface {
	// Push adds the testSuite to the top of the LIFO
	Push(pkg *api.TestSuite)
	// Pop removes the head of the LIFO and returns it
	Pop() *api.TestSuite
	// Peek returns a reference to the head of the LIFO without removing it
	Peek() *api.TestSuite
	// IsEmpty determines if the stack has any members
	IsEmpty() bool
}

// NewTestSuiteStack returns a new TestSuiteStack
func NewTestSuiteStack() TestSuiteStack {
	return &testSuiteStack{
		head: nil,
	}
}

// testSuiteStack is an implementation of a TestSuiteStack using a linked list
type testSuiteStack struct {
	head *testSuiteNode
}

// Push adds the testSuite to the top of the LIFO
func (s *testSuiteStack) Push(data *api.TestSuite) {
	newNode := &testSuiteNode{
		Member: data,
		Next:   s.head,
	}
	s.head = newNode
}

// Pop removes the head of the LIFO and returns it
func (s *testSuiteStack) Pop() *api.TestSuite {
	if s.IsEmpty() {
		return nil
	}
	oldNode := s.head
	s.head = s.head.Next
	return oldNode.Member
}

// Peek returns a reference to the head of the LIFO without removing it
func (s *testSuiteStack) Peek() *api.TestSuite {
	if s.IsEmpty() {
		return nil
	}
	return s.head.Member
}

// IsEmpty determines if the stack has any members
func (s *testSuiteStack) IsEmpty() bool {
	return s.head == nil
}

// testSuiteNode is a node in a singly-linked list
type testSuiteNode struct {
	Member *api.TestSuite
	Next   *testSuiteNode
}

func (n *testSuiteNode) String() string {
	return fmt.Sprintf("{Member: %s, Next: %s}", n.Member, n.Next.String())
}
