tests
testNumberOfPolymorphicMethods
	self assert: (cg methods select: #isPolymorphic) size equals: 10