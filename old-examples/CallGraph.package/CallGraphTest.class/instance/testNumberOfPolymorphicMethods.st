tests
testNumberOfPolymorphicMethods
	self assert: (CallGraph example methods select: #isPolymorphic) size equals: 0