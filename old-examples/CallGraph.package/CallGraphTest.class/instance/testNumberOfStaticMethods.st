tests
testNumberOfStaticMethods
	self assert: (CallGraph example methods select: #isStatic) size equals: 3