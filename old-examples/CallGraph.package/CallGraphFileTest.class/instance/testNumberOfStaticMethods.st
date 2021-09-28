tests
testNumberOfStaticMethods
	self assert: (cg methods select: #isStatic) size equals: 10